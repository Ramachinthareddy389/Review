package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardwareTests extends BaseSetup {
    private DashboardPage dashboardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardOverviewPage dashboardOverviewPage;
    private HardwarePage hardwarePage;


    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
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
    public void TC_141_AddNewHardwareConfiguration() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.verifyingHardwareNameDetails();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_142_EditingHardwareConfiguration() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.ediingConfiguration();
        hardwarePage.verifyingEditedHardwareNameDetails();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_148_AddLocalMonitoringAgentsinEditconfigwindow() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.addingLocalMonitoringAgentsUsingJVMAgentInEditConfiguration();
        hardwarePage.addingLocalMonitoringAgentsUsingNodeJSInEditConfiguration();
        hardwarePage.addingLocalMonitoringAgentsUsingWebUXAgentInEditConfiguration();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_147_ApplyReapplyMonitoringProfileswindowEditconfigwindow() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.configuringNodeInAPMModule();
        hardwarePage.configuringEnginesInAPMModule();
        hardwarePage.clickingOnHardware();
        hardwarePage.validatingEngineMonitoringProfiles();
        hardwarePage.validatingBIPApServer();
    }

}
