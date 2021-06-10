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

public class PortletsTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;

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
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingGaugePortlet();
        portletsFeature.verifyingGaugePortlet();
    }

    @Test(enabled = true)
    public void TC_29_AddingCounterPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingCounterPortlet();
        portletsFeature.verifyingCounterPortlet();
    }

    @Test(enabled = true)
    public void TC_058_AddingPortletFromSearchBar() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
    }

    @Test(enabled = true)
    public void TC_055_NavigatetoDrillthroughpage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.navigatingToDrillThroughPage();
    }


    @Test(enabled = true)
    public void TC_45_ClonePortletToAnotherDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        portletsFeature.cloningPortletInDashboardPage();
        portletsFeature.verifyingClonedPortlet();
    }


    @Test(enabled = true)
    public void TC023_AddingGeneralHealthPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingPortlet();
        portletsFeature.VerifyingGHPortlet();
    }


    @Test(enabled = true)
    public void TC_25_AddingNTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        portletsFeature.addingNTabularPortlet();
        portletsFeature.verifyingNTabularPortlet();
    }

    @Test(enabled = true)
    public void TC_057_NavigateTORCANdPivotNdDrillthroughpageUsing3optionTooltip() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.navigatingToDrilthroughPagesUsingTooltipOptions();

    }

    @Test(enabled = true)
    public void TC_24_AddingTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingTabularPortlet();
        portletsFeature.addingtabularPortlet1();
        portletsFeature.verifyingTabularPortlet();
    }

    @Test(enabled = true)
    public void TC_048_ExportGHPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingPortlet();
        portletsFeature.validatingExportedGHPortlet();

    }

    @Test(enabled = true)
    public void TC_27_AddingFlowPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingFlowPortlet();
        portletsFeature.verifyingFlowPortlet();
    }
    @Test(enabled = true)
    public void TC_056VerifyhovermessageinfiltericoninAnalysisportletinTabularportlet() throws InterruptedException, IOException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        portletsFeature.addingTabularPortlet();
        portletsFeature.verifyinghovermessageinfiltericoninAnalysisportletinTabularportlet();


    }


}


