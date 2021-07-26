package com.page.locators;

import org.openqa.selenium.By;

public interface HTTPLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_HTTP = By.xpath("//span[text()='HTTP']");
    By BTN_ADDICON_HTTP = By.xpath("//h5[text()='Http Actions']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_ACTIONS_NAME = By.xpath("//span[text()='Action Name']");
    By TXTBOX_ACTIONS_NAME= By.xpath("//input[@id='name']/../../../../div/div/div/input");
    By LABEL_PATH = By.xpath("//label[@id='path-label']/p/span[text()='Path']");
    By TXTBOX_PATH= By.xpath("//input[@id='path']/../../../../div/div/div/input");
    By LABEL_REQUEST_METHOD = By.xpath("//span[text()='Request Method']");
    By REQUEST_METHOD_GHOSTTEXT = By.xpath("//input[@id='method']/../../../div[1]");
    By TXTBOX_REQUEST_METHOD= By.xpath("//input[@id='method']");
    By LABEL_CONTENT_TYPE = By.xpath("//span[text()='Content Type']");
    By CONTENT_TYPE_GHOSTTEXT = By.xpath("//input[@id='contentType']/../../../div[1]");
    By TXTBOX_CONTENT_TYPE = By.xpath("//input[@id='contentType']");
    By LABEL_SLA = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span");
    By SLA_GHOSTTEXT = By.xpath("//input[@id='names']/../../../div[1]");
    By TXTBOX_SLA = By.xpath("//input[@id='names']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By HYPERLINK_SLAs = By.xpath("//span[text()='Triggered By SLAs']/../../../div/div/button");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_TARGET_PATH = By.xpath("//input[@id='target.path']");
    By TXTBOX_EDITED_TARGET_METHOD = By.xpath("//input[@id='target.method']/../../../div[1]");
    By TXTBOX_EDITED_TARGET_CONTENT_TYPE = By.xpath("//input[@id='target.contentType']/../../../div[1]");
    By SLA_ADD_ICON = By.xpath("//span[text()='Triggered By SLAs']/../../../div/button/span/i[@aria-label='Add New Configuration']");
    By SLAVALUE_INHTTPPAGE = By.xpath("//div[text()='Triggered By SLAs']/following-sibling::span/button");
    //HTTP SCENARIOS
    By BTN_ADDICON_HTTP_SCENARIOS = By.xpath("//h5[text()='Http Scenarios']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_HTTPSCENARIO = By.xpath("//li[text()='HTTP Scenario']");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By LABEL_ENGINE = By.xpath("//span[text()='Engine']");
    By ENGINE_GHOSTTEXT = By.xpath("//input[@id='nodeAndEngine_child']/../../../div[1]");
    By TXTBOX_ENGINE = By.xpath("//input[@id='nodeAndEngine_child']");

    By LABEL_MONITORING_NODE= By.xpath("//span[text()='Monitoring Node']");
    By MONITORING_NODE_GHOSTTEXT = By.xpath("//input[@id='nodeAndEngine']/../../../div[1]");
    By TXTBOX_MONITORING_NODE = By.xpath("//input[@id='nodeAndEngine']");


    By LABEL_APPLICATION_NAME= By.xpath("//span[text()='Application Name']");
    By APPLICATION_NAME_GHOSTTEXT = By.xpath("//input[@id='monitoredApplication']/../../../div[1]");
    By TXTBOX_APPLICATION_NAME = By.xpath("//input[@id='monitoredApplication']");

    By APMHEADER = By.xpath("//span[text()='APM']");
    By APMSTATE_HEADER = By.xpath("//span[text()='APM State']");
    By NODES_TAB = By.xpath("//span[contains(text(),'Nodes')]");
    By LABEL_HOSTNAME_NODE = By.xpath("//span[text()='Hostname']");
    By TXTBOX_HOSTNAME_NODE = By.xpath("//input[@id='hostname']");
    By MONITORSCRIPTPROFILE_LABEL = By.xpath("//span[text()='Monitoring script profile']");
    By ENGINES_ADDICON = By.xpath("//span[text()='Hostname']/../../../../../div[3]/div/div/button/span/i");
    By LABLE_NAME = By.xpath("//span[text()='Show Advanced']/../../parent::div/div[2]/div/div/label");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By BTN_SHOW_ADVANCED =By.xpath("//span[text()='Show Advanced']");
    By LABEL_MONITORED_SERVER = By.xpath("//input[@id='monitoredServer']/../../../../../../label/p/span");
    By MONITORED_SERVER_GHOSTEXT = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
    By TXTBOX_MONITORED = By.xpath("//input[@id='monitoredServer']");
    By ENGINE_MONITORIN_GPROFILES = By.xpath("//h4[text()='Engine Monitoring Profiles:']//../following-sibling::button/span/i");
    By APPLYPROFILEDROPDOWN     = By.xpath("//span[text()='Apply']/../../div/div");
    By LABEL_THRESHOLD_SLA = By.xpath("//label[@id='threshold-label']");
    By TXTBOX_SLA_THRESHOLD = By.xpath("//input[@id='threshold']");
    By LABEL_ACTIONS = By.xpath("//span[text()='SLA Actions']");
    By ACTIONS_GHOSTTEXT = By.xpath("//input[@id='actions']/../../../div[1]");
    By TXTBOX_ACTIONS= By.xpath("//input[@id='actions']");
    By LABEL_HTTPSCENARIO_HAR_FILE = By.xpath("//li[text()='HTTP Scenario (from .har file)']");
    By BTN_IMPORT = By.xpath("//i[@aria-label='Select .har file to import']");
    By SCENARIO_TARGET_ICON = By.xpath("//span[text()='Scenario Targets']/../../../div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_HTTPSCENARIO_TARGET = By.xpath("//li[text()='HTTP Scenario Target']");

}
