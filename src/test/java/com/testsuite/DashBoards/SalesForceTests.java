package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.LoginPage;
import com.page.module.SalesForcePage;
import com.page.module.SiebelPage;
import com.page.module.WordPressPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SalesForceTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private WordPressPage wordPressPage;
    private SalesForcePage salesForcePage;


    private String sModeOfExecution;
    Random random = new Random();

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashBoardData = new DashBoardData();
        wordPressPage = new WordPressPage(getDriver());
        salesForcePage = new SalesForcePage(getDriver());
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_001() throws InterruptedException {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.clickingOnSalesForce();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_002() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.addingAlertPopup();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_003() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.addingWindowPopup();
    }
}
