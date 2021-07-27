package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.HTTPPage;
import com.page.module.HardwarePage;
import com.page.module.LocalProgramPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class LocalProgramTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private LocalProgramPage localProgramPage;
    private HardwarePage hardwarePage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        localProgramPage  = new LocalProgramPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
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
    public void TC_253_AddLocalProgramConfiguration() throws InterruptedException
    {
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalPrograms();
        localProgramPage.verifyingLocalprogrames();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_254_AddScriptinAddEditLocalProgramwindow() throws InterruptedException
    {
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalPrograms();
        localProgramPage.verifyingAddedScriptInLocalPrograms();


    }

}
