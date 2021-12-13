package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MaintenanceTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private LocalProgramPage localProgramPage;
    private MaintenancePage maintenancePage;
    private HardwarePage hardwarePage;
    private HTTPPage httpPage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        maintenancePage = new MaintenancePage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        httpPage = new HTTPPage(getDriver());
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
    public void TC_Maintenance_001_AddMaintenanceConfiguration() throws InterruptedException {

        maintenancePage.clickingOnMaintenance();
        maintenancePage.addingMaintenanceConfig();
        maintenancePage.verifyingAddedMaintenanceConfigs();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Maintenance_002_AddActionsinEditMaintenancewindow() throws InterruptedException {
        maintenancePage.clickingOnMaintenance();
        maintenancePage.addingMaintenanceConfig();
        maintenancePage.addActionsInEditMaintenanceWindow();
        maintenancePage.addingHTTPactionInMaintennceWindow();
        maintenancePage.addingLocalProgrammes();
        localProgramPage.addingLocalPrograms();

    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Maintenance_004_VerifyRecurringCheckboxinEditMaintenancewindow() {
        maintenancePage.clickingOnMaintenance();
        maintenancePage.addingMaintenanceConfig();
        maintenancePage.verifyingReaccuranceOfCheckBoxInEditMaintenanceWindow();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Maintenance_003_VerifyScheduleinEditMaintenancewindow() {
        maintenancePage.clickingOnMaintenance();
        maintenancePage.addingMaintenanceConfig();
        maintenancePage.VerifyScheduleinEditMaintenancewindow();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Maintenance_005_VerifyGlobalMaintenancePeriod()
    {
        maintenancePage.clickingOnMaintenance();
        maintenancePage.addingMaintenanceConfig();
        maintenancePage.verifyingGlobalMaintanennce();


    }

}
