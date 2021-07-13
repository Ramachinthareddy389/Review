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
    public void TC_092_validatingDrillthroughUsingOperational() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        OperationalPage.validatingDrillthroughUsingOperational();
    }


    @Test(groups = "Smoke Test")
    public void TC_094_VerifyCountofKPI() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        OperationalPage.clickingOperationButton();
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        OperationalPage.validatingCountOfKPI();
    }

}
