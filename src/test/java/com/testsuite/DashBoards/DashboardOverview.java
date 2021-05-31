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



    @Test( groups ="Smoke Test",priority = 0)
    public void TC083_CreatingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
    }

    @Test( groups ="Smoke Test" )
    public void TC085_RemoveDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        dashboardOverviewPage.removingDashboard();

    }

    @Test( groups ="Smoke Test")
    public void TC086_DeletingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        dashboardOverviewPage.deletingDashboard();

    }


   @Test( enabled = true ,groups ="Smoke Test")
    public void TC002_CloningDashboard() throws InterruptedException {
       dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
       dashboardOverviewPage.ClickAll();
       dashboardOverviewPage.CloneDashboard("clone Parent");


    }


    @Test( enabled = true ,groups ="Smoke Test")
    public void TC087_RenamingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        dashboardOverviewPage.renamingDashboard();


    }


    @Test( enabled = true ,groups ="Smoke Test")
    public void TC089_CloningInDashboardOverview() throws InterruptedException
    {

        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        dashboardOverviewPage.SearchCloneDashboard("1");


    }

    @Test( enabled = true ,groups ="Smoke Test")
    public void TC090_CloningPortletInDashboardOverview() throws InterruptedException
    {

        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        dashboardOverviewPage.cloningPortlet();


    }

    @Test(enabled = true)
    public void TC20_AddingGeneralHealthPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingdashboard();
        dashboardOverviewPage.addingPortlet();
    }

    @Test(enabled = true)
    public void TC001_AddingDashboardFolder() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingFolder();
    }


    @Test( enabled = true )
    public void tc02_SelectingpredefinedTimeRanges() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        dashboardOverviewPage.differentTimeRanges();
        //dashboardOverviewPage.validatingLastHour();


    }

    @Test(enabled = true)
    public void ValidatingLastHour() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        dashboardOverviewPage.validatingLastHour();
    }

    @Test(enabled = true)
    public  void ValidatingBusinessHours() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        dashboardOverviewPage.validatingBusinessHours("09:00 AM","05:00 PM");


    }

    @Test(enabled = true)
    public void ValidatingLast12Hours() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        dashboardOverviewPage.validatingLast12hours();
    }

    @Test(enabled = true)
    public void validatingLast7days() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        dashboardOverviewPage.validatingThisMonth();
    }

    @AfterMethod()
    public void signOut()
    {

        dashboardOverviewPage.signOut();
    }



}
