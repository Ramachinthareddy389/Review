package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InsightsTest extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private InsightsPage insightsPage;
    private DashboardOverviewPage dashboardOverviewPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        insightsPage = new InsightsPage(getDriver());
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

    @Test(groups = "Smoke Test")
    public void TC_098_Navigate_To_Drillthrough_From_Insights_Page() throws InterruptedException {
        insightsPage.navigateToInsightsPage();
        insightsPage.navigateToDrillthroughFromInsightsPage();
        insightsPage.verifyDrillthroughPageNavigatedFromInsightsPage();
    }

    @Test(groups = "Smoke Test")
    public void TC_100_Navigation_Using_3Option_Tooltip_From_Insights_Page() throws InterruptedException {
        insightsPage.navigateToInsightsPage();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        insightsPage.navigationUsingTooltipOptions();
    }

    @Test(groups = "Smoke Test")
    public void TC_102_Verify_GroupBy_In_Insights_Page() throws InterruptedException {
        insightsPage.navigateToInsightsPage();
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        insightsPage.verifyGroupByInInsightsPage();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_103_ApplyTimeRangeinCalendar() throws InterruptedException {
        insightsPage.navigateToInsightsPage();
        insightsPage.clickingOnCalendar();
        dashboardOverviewPage.ValidatingCurrentHour();
        dashboardOverviewPage.validatingLastHour();
        dashboardOverviewPage.validatingBusinessHours("09:00 AM", "05:00 PM");
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

}
