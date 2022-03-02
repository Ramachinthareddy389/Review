package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class APMEnterpriseTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private String sModeOfExecution;
    private APMEnterprisePage apmEnterprisePage;
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
        apmEnterprisePage = new APMEnterprisePage(getDriver());
        componentPage = new ComponentPage(getDriver());
        dashBoardData = new DashBoardData();
        // getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_001_clickingOnEnterpriseSection() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToEnterpriseTab();

    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_003_NavigateToDrillthroughPageFromFactsProcessedPortlet() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.navigateToDrirllThroughPageFrmFactsProcessedPortlet();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_004_ExportFactsProcessedPortlet() throws InterruptedException, IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingPortlets();
        apmEnterprisePage.clickingOnExportBtnOfFactProcessedPortlet();
        apmEnterprisePage.validatingExportedPortlet("Facts Processed_Germain APM Fact Rate.csv", dashBoardData.FactporletHeaders.split(","));


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_006_NavigateToDrillthroughPageFromCPUPortlet() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.navigateToDrirllThroughPageFrmCPUUsagePortlet();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_009_NavigateToDrillthroughPageFromHeapPortlet() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.navigateToDrirllThroughPageFrmHeapUsagePortlet();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_007_ExportCPUUsagePortlet() throws InterruptedException, IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingPortlets();
        apmEnterprisePage.clickingOnExportBtnOfCPUUsagePortlet();
        apmEnterprisePage.validatingExportedPortlet("CPU Usage_Germain APM Service CPU Usage.csv", dashBoardData.CPUndHeapporletHeaders.split(","));


    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_010_ExportHeapUsagePortlet() throws InterruptedException, IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingPortlets();
        apmEnterprisePage.clickingOnExportBtnOfHeapUsagePortlet();
        apmEnterprisePage.validatingExportedPortlet("Heap Usage_Germain APM Service Heap Usage.csv", dashBoardData.CPUndHeapporletHeaders.split(","));


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMQueue_001_ClickOnQueueSection() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToAPMQueueTab();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMQueue_003_NavigateToDrillthroughPageFromQueueSizePortlet() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.navigateToDrirllThroughPageFrmQueueSizePortlet();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMQueue_004_ExportQueueSizePortlet() throws InterruptedException, IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingQueueSizePortlet();
        apmEnterprisePage.clickingOnExportBtnOfQueueSizePortlet();
        apmEnterprisePage.validatingExportedPortlet("Queue Size_ActiveMQ Message Backlog.csv", dashBoardData.QueueSizeporletHeaders.split(","));


    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMQueue_006_NavigateToDrillthroughPageFromQueueHeapUsagePortlet() throws InterruptedException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.navigateToDrirllThroughPageFrmQueueHeapUsagePortlet();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMQueue_007_ExportQueueHeapUsagePortlet() throws InterruptedException, IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingQueueSizePortlet();
        apmEnterprisePage.clickingOnExportBtnOfQueueHeapUsagePortlet();
        apmEnterprisePage.validatingExportedPortlet("Queue Heap Usage_ActiveMQ Heap Usage.csv", dashBoardData.QueueHeapUsageportletHeaders.split(","));


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMNode_001_ClickOnNodessection() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToNodeTab();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMNode_002_AddingNewNodeFrmNodesTab() {
        apmEnterprisePage.configuringNodeInAPMModule();
        apmEnterprisePage.verifyingAddedNodeInNodesPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMNode_003_EditExistingNodeFrmNodesTab() {
        apmEnterprisePage.configuringNodeInAPMModule();
        apmEnterprisePage.verifyingEditedNodeInNodesPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMNode_004_AddEnginesfrmNodeEditWindow() {
        apmEnterprisePage.configuringNodeInAPMModule();
        apmEnterprisePage.verifyingAddedEngineinNodeEditWindow();
        apmEnterprisePage.verifyingAddedEngineInEnginesTab();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_001_ClickingOnEnginesSection() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToAPMEngineTab();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_002_AddingNewEngine() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewEngine();
        apmEnterprisePage.deletingAddedEngine();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_003_EditExistingEngine() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewEngine();
        apmEnterprisePage.editingExistingEngine();
        apmEnterprisePage.deletingAddedEngine();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_011_NavigateToDrillthroughPagefrmCPUUsagePortlet() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewEngine();
        apmEnterprisePage.navigateToDrillthruPageFrmCPUUsagePortlet();
        apmEnterprisePage.deletingAddedEngine();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_014_NavigatetoDrillthroughPagefrmMemoryUsagePortlet() throws IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewEngine();
        apmEnterprisePage.navigateToDrillthruPageFrmMemoryUsagePortlet();
        apmEnterprisePage.deletingAddedEngine();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_012_ExportCPUUsagePortlet() throws IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingCPUPortletsInAPMEngine();
        apmEnterprisePage.clickingOnExportBtnOfCPUUsagePortlet();
        apmEnterprisePage.validatingExportedPortlet("CPU Usage_Germain APM Engine CPU Usage.csv", dashBoardData.QueueHeapUsageportletHeaders.split(","));
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEngine_015_ExportMemoryUsagePortlet() throws IOException {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.exportingCPUPortletsInAPMEngine();
        apmEnterprisePage.clickingOnExportBtnOfMemoryUsagePortlet();
        apmEnterprisePage.validatingExportedPortlet("Memory Usage_Germain APM Engine Memory Usage.csv", dashBoardData.QueueHeapUsageportletHeaders.split(","));
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMComp_001_ClickingOnComponentSection() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToComponentsTab();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMComp_002_AddNewCollatorDeploymentComponent() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewCollatorDeploymentComponent();
        apmEnterprisePage.verifyingAddedCollatorDeploymentComponent();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMComp_003_EditExistingCollatorDeploymentComponent() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewCollatorDeploymentComponent();
        apmEnterprisePage.editExistingCollatorDeploymentComponent();
        apmEnterprisePage.verifyingEditedValuesInCollatorComponent();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void injectingJavaScript() throws IOException {
        apmEnterprisePage.injectingJSscript();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMComp_004_AddNewDatabaseChangeMonitorDeploymentComponent() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewDatabaseChangeMonitorDeploymentComponent();
        apmEnterprisePage.addingNewDatabaseChangeMonitorDeploymentComponent1();
        apmEnterprisePage.DeployementPage();
        apmEnterprisePage.verifyingAddedComponent();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMComp_005_EditexistingDatabaseChangeMonitorDeploymentComponent() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewDatabaseChangeMonitorDeploymentComponent();
        apmEnterprisePage.addingNewDatabaseChangeMonitorDeploymentComponent1();
        apmEnterprisePage.DeployementPage();
        apmEnterprisePage.editexistingDatabaseChangeMonitorDeploymentComponent();
        apmEnterprisePage.verifyingEditedDatabaseChangeConfigs();
    }
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMJScripts_001_ClickOnJSScriptsSection() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToJSScriptsTab();
    }
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMJScripts_002_AddNewConfig() {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.addingNewJSConfig();
        apmEnterprisePage.verifyingAddedJSScripts();

    }
}
