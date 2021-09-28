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

public class SSHNdWMINdClickTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private SSHPageNdWMIClickPage sshPageNdWMIClickPage;
    private HardwarePage hardwarePage;
    private  HTTPPage httpPage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        sshPageNdWMIClickPage = new SSHPageNdWMIClickPage(getDriver());
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
        sshPageNdWMIClickPage.clickingOnAutomation();
        sshPageNdWMIClickPage.addingSSH();
        sshPageNdWMIClickPage.verifyingAddedSSH();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_296_AddNewScriptFromAddEditSSHWindow()
    {
        sshPageNdWMIClickPage.clickingOnAutomation();
        sshPageNdWMIClickPage.addingSSH();
        sshPageNdWMIClickPage.AddedScriptInSSHEditWindow();
        sshPageNdWMIClickPage.verifyingaddedScriptInSSHPage();
    }

 /*   @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_300_EditSSHConfiguration()
    {
        sshPageNdWMIClickPage.clickingOnAutomation();
        sshPageNdWMIClickPage.addingSSH();
        sshPageNdWMIClickPage.addingEditedSSH();
        sshPageNdWMIClickPage.verifyingAfterSSHEditedConfigValues();
    }*/

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_311_AddWMIconfiguration()
    {
        sshPageNdWMIClickPage.clickingOnWMIInAutomation();
        sshPageNdWMIClickPage.addingSSH();
        sshPageNdWMIClickPage.verifyingAddedSSH();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_314_AddnewScriptfromAddEditWMIwindow()
    {
        sshPageNdWMIClickPage.clickingOnWMIInAutomation();
        sshPageNdWMIClickPage.addingSSH();
        sshPageNdWMIClickPage.AddedScriptInSSHEditWindow();
    }
/*
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_318_EditWMIconfiguration()
    {
        sshPageNdWMIClickPage.clickingOnWMIInAutomation();
        sshPageNdWMIClickPage.addingSSH();
        sshPageNdWMIClickPage.addingEditedSSH();
        sshPageNdWMIClickPage.verifyingAfterSSHEditedConfigValues();
    }*/

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_329_AddClickByExportingRecordedActionsFromExtensionWindow() throws InterruptedException, AWTException
    {
        sshPageNdWMIClickPage.clickingOnClickModuleInAutomation();
        sshPageNdWMIClickPage.addingNewRecordingInClickPage();
        sshPageNdWMIClickPage.switchingToMainWindow();
        sshPageNdWMIClickPage.startedRecording();
        sshPageNdWMIClickPage.addingClickConfigurations();
        sshPageNdWMIClickPage.verifyingAddedClickActions();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_330_AddclickbyimportingexistingJSonfileinsystem() throws InterruptedException, AWTException
    {
        sshPageNdWMIClickPage.clickingOnClickModuleInAutomation();
        sshPageNdWMIClickPage.addingJSonFileUsingImport();
        sshPageNdWMIClickPage.addingClickConfigurations();
        sshPageNdWMIClickPage.verifyingAddedClickActions();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_331_AddandeditcustomRuleClick()
    {
        sshPageNdWMIClickPage.clickingOnClickModuleInAutomation();
        sshPageNdWMIClickPage.addingCUStomeRole();
        sshPageNdWMIClickPage.verifyingCustomRulesConfigs();
    }


 /*   @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_332_EditClickByimportingexistingJSONfileinsystem() throws InterruptedException, AWTException {
        sshPageNdWMIClickPage.clickingOnClickModuleInAutomation();
        sshPageNdWMIClickPage.addingJSonFileUsingImport();
        sshPageNdWMIClickPage.addingClickConfigurations();
        sshPageNdWMIClickPage.addingElementSelectorsInEditSceanrioWindow();

    }
*/
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_333_Exportactionsinsystemtoextensionwindow() throws InterruptedException, AWTException {
        sshPageNdWMIClickPage.clickingOnClickModuleInAutomation();
        sshPageNdWMIClickPage.addingNewRecordingInClickPage();
        sshPageNdWMIClickPage.switchingToMainWindow();
        sshPageNdWMIClickPage.verifyingExportingActionsOnClosingGermainApm();
    }
}
