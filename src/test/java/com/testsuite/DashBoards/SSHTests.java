package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.HardwarePage;
import com.page.module.LocalProgramPage;
import com.page.module.LoginPage;
import com.page.module.SSHPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SSHTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private SSHPage sshPage;
    private HardwarePage hardwarePage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        sshPage  = new SSHPage(getDriver());
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
    public void TC_293_AddSSHConfiguration() throws InterruptedException
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.verifyingAddedSSH();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_296_AddNewScriptFromAddEditWindow()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.verifyingAddedScriptInSSH();
        sshPage.verifyingInScriptPage();
    }
}
