

germainApmLoader(
 "https://qa.cloud.germainapm.com",
 "Germain APM Workspace",
 "Germain APM Workspace",
 ""
);

function germainApmLoader(servicesUrl, initialProfileName, applicationName, serverHostname) {
    if (monitoredExternally())
        return;
    if (!serverHostname)
        serverHostname = "qa.cloud.germainapm.com";
    var loaderArgs = { servicesUrl: servicesUrl, applicationName: applicationName, initialProfileName: initialProfileName, serverHostname: serverHostname };
    var storageKey = "germain-" + applicationName + "-profile";
    var hours = 60 * 60 * 1000;
    var cache = readLocalConfig();
    var cachedScript = cache && cache.agentConfig && { version: cache.agentConfig.scriptVersion, script: cache.agentConfig.monitoringScript };
    if (cache && cache.agentConfig) {
        var ageThreshold = (!cache.agentConfig.enabled || !cache.agentConfig.profileEnabled)
            ? .5 * hours
            : 16 * hours;
        if (cache.timeUpdated < Date.now() - ageThreshold)
            delete cache.agentConfig;
    }
    if (cache && cache.agentConfig) {
        run(cache.agentConfig);
    }
    else {
        updateAndRun();
    }
    function monitoredExternally() {
        try {
            var winPtr = window;
            while (true) {
                if (winPtr.germainApm)
                    return true;
                if (winPtr === top)
                    return false;
                winPtr = winPtr.parent;
            }
        }
        catch (ex) {
            return true;
        }
    }
    function readLocalConfig() {
        var json = localStorage.getItem(storageKey);
        try {
            if (json)
                return JSON.parse(json).value;
        }
        catch (ex) { }
    }
    function run(agentConfig) {
        if (!agentConfig.enabled || !agentConfig.profileEnabled)
            return;
        try {
            Function(agentConfig.monitoringScript)();
        }
        catch (ex) {
            reportError("Exception during eval of monitoringScript", ex);
        }
        try {
            Function('loaderArgs', 'agentConfig', agentConfig.initScript)(loaderArgs, agentConfig);
        }
        catch (ex) {
            reportError("Exception during eval of initScript", ex);
        }
    }
    function updateAndRun() {
        if (!servicesUrl)
            return;
        var pathTerms = ['config', 'agent', 'lookup', 'Web UX', serverHostname, applicationName];
        var args = {
            profile: initialProfileName
        };
        if (cachedScript)
            args.hash = cachedScript.version;
        var req = new XMLHttpRequest();
        req.addEventListener('load', then);
        req.open('GET', makeUrl(servicesUrl, pathTerms, args));
        req.setRequestHeader('Cache-Control', 'no-store, max-age=0');
        function then() {
            var config = { timeUpdated: Date.now() };
            if (req.status === 200) {
                try {
                    if (req.responseText) {
                        config.agentConfig = JSON.parse(req.responseText);
                        if (cachedScript && config.agentConfig && !config.agentConfig.monitoringScript)
                            config.agentConfig.monitoringScript = cachedScript.script;
                    }
                }
                catch (ex) { }
            }
            var entry = { version: [], value: config };
            localStorage.setItem(storageKey, JSON.stringify(entry));
            if (config.agentConfig)
                run(config.agentConfig);
        }
    }
    function makeUrl(prefix, pathTerms, args) {
        var url = prefix;
        if (pathTerms.length)
            url += '/' + pathTerms.map(encodeURIComponent).join('/');
        if (Object.keys(args).length)
            url += '?' + Object.keys(args).map(function (key) { return encodeURIComponent(key) + '=' + encodeURIComponent(args[key]); }).join('&');
        return url;
    }
    function reportError(errorLabel, error) {
        sendStatus(false, {
            errorLabel: errorLabel,
            errorDetails: error instanceof Error ? error.stack : String(error),
            path: location.href,
            userAgent: navigator.userAgent,
        });
    }
    function sendStatus(isRunning, details) {
        var sourceProfile = cache && cache.agentConfig
            ? cache.agentConfig.profileName + ' v' + cache.agentConfig.scriptVersion
            : initialProfileName;
        var sequence = '';
        if (window.germainApm && window.germainApm.tab) {
            sequence = window.germainApm.tab.getCorrelationId() + '.' + window.germainApm.tab.getTabId();
        }
        var fact = {
            myClassName: 'InternalEvent',
            type: 'GermainAPM:Agent Status',
            timestamp: Date.now(),
            name: 'Web UX',
            value: isRunning ? 1 : 0,
            node: serverHostname,
            engine: applicationName,
            sourceFile: sourceProfile,
            details: typeof details === 'object' ? JSON.stringify(details) : details,
            sequence: sequence
        };
        fact.system = { hostname: serverHostname };
        var url = makeUrl(servicesUrl, ['ingestion', 'beacon', 'fact'], {});
        var body = JSON.stringify([fact]);
        if (navigator.sendBeacon) {
            navigator.sendBeacon(url, body);
        }
        else {
            var req = new XMLHttpRequest();
            req.open('POST', url);
            req.send(body);
        }
    }
}