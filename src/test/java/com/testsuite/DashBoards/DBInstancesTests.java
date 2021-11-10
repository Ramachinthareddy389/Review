package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DBInstancesTests extends BaseSetup {

    private DashboardPage dashboardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardOverviewPage dashboardOverviewPage;
    private DBInstancesPage dbInstancesPage;


    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        dbInstancesPage = new DBInstancesPage(getDriver());
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
    public void TC132_AddNewConfiguration() throws InterruptedException {
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances();
        dbInstancesPage.verifyingDbInstanceNameDetails();
    }

/*    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC133_EditConfiguration() throws InterruptedException {
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances();
        dbInstancesPage.ediingConfiguration();
    }*/


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_134_VerifyPageIconsInDbinstancesPage(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances();
        dbInstancesPage.verifyingPageIconsInDbinstancespage();
    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_135_ApplyFiltersInDbinstancePage(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances();
        dbInstancesPage.applyingFilters();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_136_NavigateToServerPageByClickingonServersUnderServerColumn(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances();
        dbInstancesPage.navigateToHardwarePageFrmDbinstnacePage();
    }

}
