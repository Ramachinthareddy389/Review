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
        hardwarePage = new HardwarePage(getDriver());
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
    public void TC_Hware_001_AddNewHardwareConfiguration() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.verifyingHardwareNameDetails();

    }
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Hware_002_EditingHardwareConfiguration() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.ediingConfiguration();
        hardwarePage.verifyingEditedHardwareNameDetails();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Hware_008_AddLocalMonitoringAgentsinEditconfigwindow() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.addingLocalMonitoringAgentsUsingJVMAgentInEditConfiguration();
        hardwarePage.addingLocalMonitoringAgentsUsingNodeJSInEditConfiguration();
        hardwarePage.addingLocalMonitoringAgentsUsingWebUXAgentInEditConfiguration();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Hware_007_ApplyReapplyMonitoringProfileswindowEditconfigwindow() throws InterruptedException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.configuringNodeInAPMModule();
        hardwarePage.configuringEnginesInAPMModule();
        hardwarePage.clickingOnHardware();
        hardwarePage.validatingHttpProfiles();
        hardwarePage.validatingBIPApServer();
        hardwarePage.validatingApacheTomcatServer();
    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Hware_003_VerifyPageIconsInHardwarepage(){
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.verifyingPageIconsInHardwarePage();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Hware_004_ApplyFiltersInHardwarePage(){
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.applyingFiltersInHarwarePage();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Hware_005_VerifyIconsInHardwareEditConfigWindow(){
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        hardwarePage.VerifyIconsInHardwareEditConfigWindow();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Hware_009_ViewDataForFieldswithViewIconInReferEditConfigWindow(){
        hardwarePage.verifyingViewDataForDataFeildsWithviewIconInreferWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Hware_011_NavigateToComponentEditwindowinReferencesSection(){
        hardwarePage. navigateToReferenceWindowFromSoftwareEditWindow();
    }





}
