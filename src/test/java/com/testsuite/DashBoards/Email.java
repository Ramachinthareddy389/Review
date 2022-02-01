package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import org.testng.annotations.BeforeMethod;

public class Email extends BaseSetup {
    private DashboardPage dashboardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private EmailPage emailPage;
    private HardwarePage hardwarePage;


    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        emailPage = new EmailPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.gmail);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
/*        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();*/
    }

/*
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void emailVerification() throws InterruptedException
    {

        emailPage.navigatingToEmail("zentest75@gmail.com","Germain Report - User Login Report - Germain Software - QA");


    }
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_454_VerifyAcceptRejectrequestemails() throws InterruptedException {

        emailPage.navigatingToEmail("zentest75@gmail.com","Germain APM User Access Requested");
        emailPage.actionPerformingInMail();

    }
*/

}
