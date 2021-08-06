package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SSHNdWMITests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private SSHPage sshPage;
    private HardwarePage hardwarePage;
    private  HTTPPage httpPage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        sshPage = new SSHPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        httpPage = new HTTPPage(getDriver());
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

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_296_AddNewScriptFromAddEditSSHWindow()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.AddedScriptInSSHEditWindow();
        sshPage.verifyingaddedScriptInSSHPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_300_EditSSHConfiguration()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.addingEditedSSH();
        sshPage.verifyingAfterSSHEditedConfigValues();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_311_AddWMIconfiguration()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.verifyingAddedSSH();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_314_AddnewScriptfromAddEditWMIwindow()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.AddedScriptInSSHEditWindow();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_318_EditWMIconfiguration()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.addingEditedSSH();
        sshPage.verifyingAfterSSHEditedConfigValues();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_329_AddClickByExportingRecordedActionsFromExtensionWindow() throws InterruptedException, AWTException
    {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingNewRecordingInClickPage();
        sshPage.switchingToMainWindow();
        sshPage.startedRecording();
        sshPage.addingClickConfigurations();
        sshPage.verifyingAddedClickActions();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_330_AddclickbyimportingexistingJSonfileinsystem() throws InterruptedException, AWTException
    {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingJSonFileUsingImport();
        sshPage.addingClickConfigurations();
        sshPage.verifyingAddedClickActions();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_331_AddandeditcustomRuleClick()
    {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingCUStomeRole();
        sshPage.verifyingCustomRulesConfigs();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_332_EditClickByimportingexistingJSONfileinsystem() throws InterruptedException, AWTException {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingJSonFileUsingImport();
        sshPage.addingClickConfigurations();
        sshPage.addingElementSelectorsInEditSceanrioWindow();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_333_Exportactionsinsystemtoextensionwindow() throws InterruptedException, AWTException {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingNewRecordingInClickPage();
        sshPage.switchingToMainWindow();
        sshPage.verifyingExportingActionsOnClosingGermainApm();
    }
}
