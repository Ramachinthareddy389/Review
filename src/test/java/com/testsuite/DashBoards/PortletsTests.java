package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.DashboardPage;
import com.page.module.LoginPage;
import com.page.module.PortletsFeature;
import com.selenium.Sync;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class PortletsTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;
    Random random=new Random();
    String tabularPortletName = "Tabular Portlet - " + random.nextInt(1000);
    String nTabularPortletName = "N Tabular Portlet - " + random.nextInt(1000);
    String dname = "Filters";
    String dname1 = dname + random.nextInt(500);
    String flowPortletName = "Flow Portlet - " +random.nextInt(1000);
    String mapPortletName = "Map Portlet - " + random.nextInt(1000);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, dashBoardData.password);
        loginPage.clickLogInButton();
    }

    @Test(enabled = true)
    public void TC_28_AddingGaugePortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingGaugePortlet();
        portletsFeature.verifyingGaugePortlet();
        portletsFeature.removingPortlet();
    }

    @Test(enabled = true)
    public void TC_29_AddingCounterPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingCounterPortlet();
        portletsFeature.verifyingCounterPortlet();
        portletsFeature.removingPortlet();
    }

    @Test(enabled = true)
    public void TC_058_AddingPortletFromSearchBar() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        portletsFeature.removingPortlet();
    }

    @Test(enabled = true)
    public void TC_055_NavigatetoDrillthroughpage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.navigatingToDrillThroughPage();
        portletsFeature.removingPortlet();
    }


    @Test(enabled = true)
    public void TC_45_ClonePortletToAnotherDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        portletsFeature.cloningPortletInDashboardPage();
        portletsFeature.verifyingClonedPortlet();
        portletsFeature.removingPortlet();
    }


    @Test(enabled = true)
    public void TC023_AddingGeneralHealthPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingPortlet(dname1);
        portletsFeature.VerifyingGHPortlet(dname1);
        portletsFeature.removingPortlet();
    }


    @Test(enabled = true)
    public void TC_25_AddingNTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        portletsFeature.verifyingNTabularPortlet(nTabularPortletName);
        portletsFeature.removingPortlet();
    }

    @Test(enabled = true)
    public void TC_057_NavigateTORCANdPivotNdDrillthroughpageUsing3optionTooltip() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.navigatingToDrilthroughPagesUsingTooltipOptions();
        portletsFeature.removingPortlet();

    }

    @Test(enabled = true)
    public void TC_24_AddingTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingTabularPortlet();
        portletsFeature.addingtabularPortlet1(tabularPortletName);
        portletsFeature.verifyingTabularPortlet(tabularPortletName);
        portletsFeature.removingPortlet();
    }

    @Test(enabled = true)
    public void TC_048_ExportGHPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingPortlet(dname1);
        portletsFeature.validatingExportedGHPortlet(dname1 + "_" + "User Click.csv",dashBoardData.porletHeaders.split(","));
        portletsFeature.removingPortlet();

    }

    @Test(enabled = true)
    public void TC_27_AddingFlowPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingFlowPortlet(flowPortletName);
        portletsFeature.verifyingFlowPortlet(flowPortletName);
        portletsFeature.removingPortlet();
    }
    @Test(enabled = true)
    public void TC_056VerifyhovermessageinfiltericoninAnalysisportletinTabularportlet() throws InterruptedException, IOException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingTabularPortlet();
        portletsFeature.verifyinghovermessageinfiltericoninAnalysisportletinTabularportlet(tabularPortletName);
        portletsFeature.removingPortlet();

    }


    @Test(enabled = true)
    public void TC_049_ExportTabularportlet() throws InterruptedException, IOException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingTabularPortlet();
        portletsFeature.addingtabularPortlet1(tabularPortletName);
        portletsFeature.verifyingTabularPortlet(tabularPortletName);
        portletsFeature.validatingExportedATabularPortlet(tabularPortletName);
        portletsFeature.removingPortlet();

    }

    @Test(enabled = true)
    public void TC_26_AddingMapPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingMapPortlet(mapPortletName);
        portletsFeature.verifyingMapPortlet(mapPortletName);
        portletsFeature.removingPortlet();
    }


    @Test(enabled = true)
    public void TC_50_ExportNTabularPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        portletsFeature.verifyingNTabularPortlet(nTabularPortletName);
        portletsFeature.verifyingExportedNtabularPortlet(nTabularPortletName);
        portletsFeature.removingPortlet();

    }


    @Test(enabled = true)
    public void TC_O52_RemovePortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        portletsFeature.verifyingNTabularPortlet(nTabularPortletName);
        portletsFeature.removingPortlet();
    }

    @Test(enabled = true)
    public void TC_051_ExportMapPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.addingdashboard(dname1);
        portletsFeature.addingMapPortlet(mapPortletName);
        portletsFeature.verifyingMapPortlet(mapPortletName);
        portletsFeature.validatingExportedGHPortlet(mapPortletName+".csv",dashBoardData.mapHeaders.split(","));
        portletsFeature.removingPortlet();

    }
}


