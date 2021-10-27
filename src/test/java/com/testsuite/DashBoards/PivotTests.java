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

public class PivotTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private PivotPage pivotPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private String sModeOfExecution;
    Random random = new Random();
    String dname = "testng";
    String dname1 = dname + random.nextInt(1500);
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        pivotPage = new PivotPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        portletsFeature =new PortletsFeature(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }

    @Test(alwaysRun = true)
    public void TC_071_AddingTablePortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
       // portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage(gaugePortletName);
        pivotPage.addTablePortletInPivotPage();
        pivotPage.verifyTablePortletInPivotPage();
        pivotPage.removeTablePortletInPivotPage();
    }

    @Test(alwaysRun = true)
    public void TC_072_AddingChartPortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
       // portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage(gaugePortletName);
        pivotPage.addChartPortletInPivotPage();
        pivotPage.verifyChartPortletInPivotPage();
        pivotPage.removeChartPortletInPivotPage();
    }

    @Test(alwaysRun = true)
    public void TC_075_VerifyingDataInPortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        //portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage(gaugePortletName);
        pivotPage.addDataInTablePortletInPivotPage();
        pivotPage.verifyDataInTablePortletInPivotPage();
        pivotPage.removeTablePortletInPivotPage();
    }
/*
    @Test(alwaysRun = true)
    public void TC_076_EditingChartPortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortletFromSearchBar();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addChartPortletInPivotPage();
        pivotPage.verifyChartPortletInPivotPage();
        pivotPage.editChartPortletInPivotPage();
        pivotPage.verifyEditedChartPortletInPivotPage();
    }

    @Test(alwaysRun = true)
    public void TC_077_EditingTablePortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortletFromSearchBar();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addTablePortletInPivotPage();
        pivotPage.verifyTablePortletInPivotPage();
        pivotPage.editTablePortletInPivotPage();
        pivotPage.verifyEditedTablePortletInPivotPage();
    }*/
}
