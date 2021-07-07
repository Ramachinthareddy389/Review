package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.SoftwarePage;
import com.page.module.TicketsPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoftwareTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private SoftwarePage softwarePage;
    private DashboardOverviewPage dashboardOverviewPage;


    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        softwarePage = new SoftwarePage(getDriver());
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
    public void TC_152_AddSoftwareConfiguration() throws InterruptedException {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware();
        softwarePage.verifyingSoftwareNameDetails();
    }

    @Test(groups = "Smoke Test")
    public void TC_153_EditSoftwareConfiguration() throws InterruptedException {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware();
        softwarePage.editConfiugurationSoftwareDetails();
        softwarePage.verifyingEditSoftwareNameDetails();

    }

}