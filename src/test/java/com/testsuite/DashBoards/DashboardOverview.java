package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardOverview extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage=new LoginPage(getDriver());
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



    @Test( groups ="Smoke Test")
    public void TC083_CreatingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();

    }

    @Test( groups ="Smoke Test" )
    public void Tc085_RemoveDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.removingDashboard();

    }

    @Test( groups ="Smoke Test")
    public void Tc086_DeletingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.deletingDashboard();

    }


   @Test( enabled = true ,groups ="Smoke Test")
    public void TC002_CloningDashboard() throws InterruptedException {
       dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
       dashboardOverviewPage.ClickAll();
       dashboardOverviewPage.CloneDashboard("clone Parent");


    }


    @Test( enabled = true ,groups ="Smoke Test")
    public void Tc087_RenamingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.renamingDashboard();


    }


    @Test( enabled = true ,groups ="Smoke Test")
    public void Tc089_CloningInDashboardOverview() throws InterruptedException
    {

        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.SearchCloneDashboard("1 Folder");


    }


    @Test( enabled = true ,groups ="Smoke Test")
    public void Tc090_CloningPortletInDashboardOverview() throws InterruptedException
    {

        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingPortlet();



    }


    @AfterMethod()
    public void signOut() {
      dashboardOverviewPage.signOut();
    }



}
