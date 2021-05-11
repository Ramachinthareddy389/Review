package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashBoardPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class DashboardCreation extends BaseSetup {
    private DashBoardPage dashBoardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage=new LoginPage(getDriver());
        dashBoardPage = new DashBoardPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
    }

    @Test( groups ="Smoke Test" )
    public void tc027_CreatingDashboard() throws InterruptedException {
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, dashBoardData.password);
        loginPage.clickLogInButton();
        dashBoardPage.verifyDashBoardOverviewPage(dashBoardData.dashboard,dashBoardData.allpages);
        dashBoardPage.addingNewDashboard();
        dashBoardPage.enterAddrequirefeildsInDashBoardPage(dashBoardData.dashboard);
        dashBoardPage.signOut();

    }

}
