package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.selenium.Sync;

import jvm.PasswordDecoder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class DashboardOverview extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_001_CreatingDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_005_VerifyTrendGranularityinDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SearchinDashboard();
        dashboardOverviewPage.validaingTrendGranularityUSingHours();
        dashboardOverviewPage.validaingTrendGranularityUSingDaily();
        dashboardOverviewPage.validaingTrendGranularityUSingMonthly();
        dashboardOverviewPage.validaingTrendGranularityUSingYEARLY();
        dashboardOverviewPage.validaingTrendGranularityUSingMinutely();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_011_RenamingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.renamingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC018_ApplyanydatefrompredefinedtimerangesinCalendar() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        dashboardOverviewPage.ValidatingCurrentHour();
        dashboardOverviewPage.validatingLastHour();
        dashboardOverviewPage.validatingBusinessHours("010:00 AM", "05:00 PM");
        dashboardOverviewPage.validatingLast12hours();
        dashboardOverviewPage.validatingThisMonth("12:00 AM");
        dashboardOverviewPage.validatingLastMonth("12:00 AM");
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        dashboardOverviewPage.validatingToday("12:00 AM");
        dashboardOverviewPage.validatingYesterday("12:00 AM");
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        dashboardOverviewPage.validatingAbsoluteQa_30Mins("01/01/2020 01:01 AM", "02/04/2021 01:30 AM");
        dashboardOverviewPage.validatingAbsoluteAllUnits("01/01/2020 01:00 AM", "02/20/2021 05:30 AM");

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC085_RemoveDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.removingDashboard();


    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC089_CloningInDashboardOverview() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.SearchCloneDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC105_AddingDashboardFolder() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingFolder();
        dashboardOverviewPage.deletingDashboard();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC110_DeletingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC113_CloningDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.CloneDashboard("clone Parent");
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC114_CloningPortletInDashboardOverview() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.cloningPortlet();
        //dashboardOverviewPage.deletingDashboard(dname1);
    }

/*
    @AfterMethod()
    public void signOut()
    {

        dashboardOverviewPage.signOut();
    }
*/



}
