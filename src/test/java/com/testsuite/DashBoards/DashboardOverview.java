package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;

import jvm.PasswordDecoder;
import org.testng.annotations.*;

public class DashboardOverview extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private EmailPage emailPage;
    private PortletsFeature portletsFeature;
    private AlertTemplatePage alertTemplatePage;
    private DashboardPage dashboardPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        alertTemplatePage = new AlertTemplatePage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        emailPage = new EmailPage(getDriver());
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


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Dash_001_CreatingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_005_VerifyTrendGranularityinDashboard() throws InterruptedException
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

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_011_RenamingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.renamingDashboard();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_018_ApplyanydatefrompredefinedtimerangesinCalendar() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
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

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_005_RemoveDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.removingDashboard();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_009_CloningInDashboardOverview() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.SearchCloneDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_001_AddingDashboardFolder() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingFolder();

    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_006_DeletingDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_009_CloningDashboard() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.CloneDashboard("clone Parent");
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DashOverview_010_CloningPortletInDashboardOverview() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.cloningPortlet();

    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_008_ShareDashboardWithExistingUser() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.verifySharingDashboardWithExistingUser();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("access1234@yopmail.com","germain APM - shared this dashboard with you");
        alertTemplatePage.deletingEmails();

    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_009_ShareDashboardWithNewUser() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.verifySharingDashboardWithNewUser();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("testzenq@yopmail.com","germain APM - shared this dashboard with you");
        alertTemplatePage.deletingEmails();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_003_CheckPortletsPerRowinDashboardpage() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.clickingOnDashboardSection();
        dashboardOverviewPage.checkPortletsPerRow();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_002_AddDashboardFolderToExistingFolder() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingFolder();
        dashboardOverviewPage.addingDashboardFolderToExistingfolder();
        dashboardOverviewPage. deletingDashboardFolder();


    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_004_DeleteDashboardFolder() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingFolder();
        dashboardOverviewPage.deletingFolder();


    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_003_AddDashboardtoExistingFolder() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboardFolder();
        dashboardOverviewPage.addingDashboardToExistingFolder();
        dashboardOverviewPage.deletingFolder();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_008_PinUnpinDashboardFolder() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewFolder();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.addingFolder();
        dashboardOverviewPage.PinningDashboardFolder();
        dashboardOverviewPage.searchingDashboardFolder();
        dashboardOverviewPage.Unpin_Pin_Dashboard_Folder_FromDashboardPage();
        dashboardOverviewPage.searchingDashboardFolder();
        dashboardOverviewPage.deletingFolder();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_011_ApplyFilterusingFilterIconDisplayedinAnycolumn() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.applyFilterusingFilterIconDisplayedinAnycolumn();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_DashOverview_010_ApplyAnyFilterInDashboardPage() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.applyingFilters();
        dashboardOverviewPage.deletingDashboard();
    }
/*
    @AfterMethod()
    public void signOut()
    {

        dashboardOverviewPage.signOut();
    }
*/


}
