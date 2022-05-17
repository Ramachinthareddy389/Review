package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class ApmStateTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private String sModeOfExecution;
    private ApmStatePage apmStatePage;
    private HardwarePage hardwarePage;
    private SoftwarePage softwarePage;
    private ComponentPage componentPage;
    Random random = new Random();

    String dname = "HttpScenario";
    String dname1 = dname + random.nextInt(1500);
    String HostName = "HostTest" + "-" + random.nextInt(500);
    String HostName1 = "Hostname" + "-" + random.nextInt(500);
    String DbTitle = "Module_soft" + " - " + random.nextInt(500);
    String Cred = "Cred" + "-" + random.nextInt(500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        softwarePage = new SoftwarePage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        apmStatePage = new ApmStatePage(getDriver());
        componentPage = new ComponentPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_001_AddNewHTTPScenarioComponentDeployementComponent() throws InterruptedException {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.verifyingHttpScenario();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_002_EditExistingHTTPScenarioComponentDeployementComponent() {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.verifyingEditHttpConfigs();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_003_MoveHTTPScenarioComponentDeploymentTootherEngine() {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.movingHttpScenrioToOtherEngine();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_004_AddMonitoredServerandApplicationfromEditWindow() {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.addingMonitoredServer();
        hardwarePage.addingNewHardware(HostName);
        apmStatePage.savingHardware();
        hardwarePage.navigatingToHardwarePage();
        apmStatePage.navigatingToComponentsTab();
        softwarePage.addingNewSoftware(DbTitle);
        apmStatePage.addingMonitoredIcon();
        hardwarePage.addingNewHardware(HostName1);
        apmStatePage.savingHardware();
        softwarePage.navigatingToSoftwarePage(DbTitle);
        apmStatePage.deletingHttpScenarionInComponentsTab();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_005_AddCredentialsfromEditWindow() {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.addingCredentialsInHttpEditWindow();
        componentPage.addingNewCredentials(Cred);
        apmStatePage.savingHardware();
        componentPage.navigatingToCredWindow();
        apmStatePage.deletingHttpScenarionInComponentsTab();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_006_CopyHTTPScenarioComponentDeploymenttootherEngine() {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.copiyingHttpScenarioInTOOtherEngine();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_007_AddNewParserDeploymentcomponent() {
        apmStatePage.configuringParserDepoly();
        apmStatePage.monitoringPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.verifyingParsementDeploymentConfigs();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Apm_008_EditExistingParserDeploymentcomponent() {
        apmStatePage.configuringParserDepoly();
        apmStatePage.monitoringPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.verifyingEditParsementDeployConfig();
    }
}
