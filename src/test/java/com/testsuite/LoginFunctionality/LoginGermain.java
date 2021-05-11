package com.testsuite.LoginFunctionality;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.LoginPage;
import com.selenium.Sync;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginGermain extends BaseSetup {

    private LoginPage loginPage;
    private DashBoardData openCartTestData;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        openCartTestData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(openCartTestData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
    }

    @Test( groups ="regression" )
    public void tc001_LoginToGermainamApp() {
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(openCartTestData.emailAddress, openCartTestData.password);
        loginPage.clickLogInButton();


    }

}
