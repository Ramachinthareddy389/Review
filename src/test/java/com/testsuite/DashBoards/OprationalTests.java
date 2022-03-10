package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.OperationalPage;
import com.page.module.PortletsFeature;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class OprationalTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private OperationalPage OperationalPage;
    private PortletsFeature portletsFeature;

    private String sModeOfExecution;
    Random random = new Random();
    String tabularPortletName = "Tabular Portlet - " + random.nextInt(1000);
    String nTabularPortletName = "N Tabular Portlet - " + random.nextInt(1000);
    String dname = "Pivots";
    String dname1 = dname + random.nextInt(1500);
    String flowPortletName = "Flow Portlet - " + random.nextInt(1000);
    String mapPortletName = "Map Portlet - " + random.nextInt(1000);
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);
    String counterPortletName = "Counter Portlet - " + random.nextInt(1000);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        OperationalPage = new OperationalPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
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
    public void TC_Oper_003_validatingPivotNdDrillthroughUsingOperational() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        OperationalPage.validatingPivotPageUsingOperational();
        OperationalPage.clickingOperationButton();
        OperationalPage.validatingDrillthroughPageUsingOprtaional();
    }


    @Test(groups = "Smoke Test")
    public void TC_Oper_005_VerifyCountofKPI() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        OperationalPage.validatingCountOfKPI();
    }

    @Test(groups = "Smoke Test")
    public void TC_Oper_001_ApplyTimeRangeinCalendar() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        dashboardOverviewPage.clickingOnCalenderIcon();
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
      //  dashboardOverviewPage.validatingAbsoluteQa_30Mins("01/01/2020 01:01 AM", "02/04/2021 01:30 AM");
     //   dashboardOverviewPage.validatingAbsoluteAllUnits("01/01/2020 01:00 AM", "02/20/2021 05:30 AM");

    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_OPR_008_ViewingDataAvailabilityInAppComponentsTabOfOperationalPage(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToAppComponentsTab();
        OperationalPage.validatingDataAvailabilityInAppComponentsTab();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_OPR_009_NavigatingToPivotDrillthroughPageUsingTheDataAvailableInAppComponentsTab(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToAppComponentsTab();
        OperationalPage.validatingPivotPageUsingOperational();
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToAppComponentsTab();
        OperationalPage.validatingDrillthroughPageUsingOprtaional();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_OPR_011_ViewingDataAvailabilityInDatabasesTabOfOperationalPage(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToDatabaseTab();
        OperationalPage.validatingDataAvailabilityInAppComponentsTab();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_OPR_012_NavigatingToPivotNdDrillthroughPageUsingTheDataAvailableInDatabasesTab(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToDatabaseTab();
        OperationalPage.validatingPivotPageUsingOperational();
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToDatabaseTab();
        OperationalPage.validatingDrillthroughPageUsingOprtaional();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_OPR_014_ViewingDataAvailabilityInEnvironmentTabOfOperationalPage(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToEnvironmentTab();
        OperationalPage.validatingDataAvailabilityInAppComponentsTab();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_015_NavigatingToPivotNdDrillthroughPageUsingTheDataAvailableInEnvironmentTab(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToEnvironmentTab();
        OperationalPage.validatingPivotPageUsingOperational();
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToEnvironmentTab();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        OperationalPage.validatingDrillthroughPageUsingOprtaional();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_017_ViewingDataAvailabilityInHostTabOfOperationalPage(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToHostTab();
        OperationalPage.validatingDataAvailabilityInAppComponentsTab();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_018_NavigatingToPivotNdDrillthroughPageUsingTheDataAvailableInHostTab(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToHostTab();
        OperationalPage.validatingPivotPageUsingOperational();
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToHostTab();
        OperationalPage.validatingDrillthroughPageUsingOprtaional();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_026_ViewingDataAvailabilityInUsersTabOfOperationalPage(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToUsersTab();
        OperationalPage.validatingDataAvailabilityInAppComponentsTab();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_027_NavigatingToPivotNdDrillthroughPageUsingTheDataAvailableInUsersTab(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToUsersTab();
        OperationalPage.validatingPivotPageUsingServerNdBusiProcessTabs();
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToUsersTab();
        OperationalPage.validatingDrillthroughPageUsingServerNdBUsiProcessTabs();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_029_ViewingDataAvailabilityInTrendsTabOfOperationalPage(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToTrendTab();
        OperationalPage.validatingDataAvailabilityInAppComponentsTab();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Oper_030_NavigatingToPivotNdDrillthroughPageUsingTheDataAvailableInTrendsTab(){
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToTrendTab();
        OperationalPage.validatingPivotPageUsingServerNdBusiProcessTabs();
        OperationalPage.clickingOperationButton();
        OperationalPage.navigateToUsersTab();
        OperationalPage.validatingDrillthroughPageUsingServerNdBUsiProcessTabs();
    }
}
