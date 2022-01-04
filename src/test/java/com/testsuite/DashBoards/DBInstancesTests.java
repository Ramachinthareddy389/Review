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

public class DBInstancesTests extends BaseSetup {

    private DashboardPage dashboardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardOverviewPage dashboardOverviewPage;
    private DBInstancesPage dbInstancesPage;
    private AlertTemplatePage alertTemplatePage;

    Random random = new Random();
    String dbinstance = "test"+random.nextInt(500);
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        dbInstancesPage = new DBInstancesPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        alertTemplatePage = new AlertTemplatePage(getDriver());
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
    public void TC_DBInstances_001_AddNewConfiguration() throws InterruptedException {
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.verifyingDbInstanceNameDetails(dbinstance);
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DBInstances_002_EditConfiguration() throws InterruptedException {
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.ediingConfiguration(dbinstance);
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DBInstances_003_VerifyPageIconsInDbinstancesPage(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.verifyingPageIconsInDbinstancespage(dbinstance);
    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DBInstances_004_ApplyFiltersInDbinstancePage(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.applyingFilters(dbinstance);
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DBInstances_005_NavigateToServerPageByClickingonServersUnderServerColumn(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.navigateToHardwarePageFrmDbinstnacePage(dbinstance);
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DBInstances_006_ViewDataForFieldswithViewIconinEditConfigWindow(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.viewDataWithFeildsForViewIcon(dbinstance);
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DBInstances_007_VerifyIconsinDbinstancesEditConfigWindow(){
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        dbInstancesPage.verifyingIconsInEditWindow(dbinstance);
    }

}
