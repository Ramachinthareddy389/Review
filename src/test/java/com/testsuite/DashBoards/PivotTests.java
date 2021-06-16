package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.PivotPage;
import com.page.module.PortletsFeature;
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

    private String sModeOfExecution;
    Random random=new Random();
    String dname = "Filters";
    String dname1 = dname + random.nextInt(1500);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        pivotPage = new PivotPage(getDriver());
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

    @Test(enabled = true)
    public void TC_071_AddingTablePortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.searchingDashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addTablePortletInPivotPage();
        pivotPage.verifyTablePortletInPivotPage();
        pivotPage.removeTablePortletInPivotPage();
    }

    @Test(enabled = true)
    public void TC_072_AddingChartPortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.searchingDashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addChartPortletInPivotPage();
        pivotPage.verifyChartPortletInPivotPage();
        pivotPage.removeChartPortletInPivotPage();
    }

    @Test(enabled = true)
    public void TC_075_VerifyingDataInPortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.searchingDashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addDataInTablePortletInPivotPage();
        pivotPage.verifyDataInTablePortletInPivotPage();
        pivotPage.removeTablePortletInPivotPage();
    }

    @Test(enabled = true)
    public void TC_076_EditingChartPortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.searchingDashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addChartPortletInPivotPage();
        pivotPage.verifyChartPortletInPivotPage();
        pivotPage.editChartPortletInPivotPage();
        pivotPage.verifyEditedChartPortletInPivotPage();
    }

    @Test(enabled = true)
    public void TC_077_EditingTablePortletInPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage(dname1);
        dashboardOverviewPage.searchingDashboard(dname1);
        portletsFeature.addingPortletFromSearchBar();
        portletsFeature.verifyingPortletAddedFromSearchBar();
        pivotPage.navigateToPivotPage();
        pivotPage.addTablePortletInPivotPage();
        pivotPage.verifyTablePortletInPivotPage();
        pivotPage.editTablePortletInPivotPage();
        pivotPage.verifyEditedTablePortletInPivotPage();
    }
}
