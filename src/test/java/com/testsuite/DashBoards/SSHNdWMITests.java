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


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_SSH_001_AddSSHConfiguration() throws InterruptedException
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.verifyingAddedSSH();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_SSH_004_AddNewScriptFromAddEditSSHWindow()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.AddedScriptInSSHEditWindow();
        sshPage.verifyingaddedScriptInSSHPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_SSH_008_EditSSHConfiguration()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.addingEditedSSH();
        sshPage.verifyingAfterSSHEditedConfigValues();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_WMI_001_AddWMIconfiguration()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.verifyingAddedSSH();

    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_WMI_004_AddnewScriptfromAddEditWMIwindow()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.AddedScriptInSSHEditWindow();
        sshPage.deletingAddedSSh();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_WMI_005_NavigatetoScriptPageonClickingAnyScriptUnderSCRIPTColumnInWMIPAge(){
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.AddedScriptInSSHEditWindow();
        sshPage.navigateToScriptPageFrmSSHPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_WMI_008_EditWMIconfiguration()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.addingEditedSSH();
        sshPage.verifyingAfterSSHEditedConfigValues();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_WMI_006_NavigatetoSLAsPageOnClickingAnySLAUnderTriggeredBySLAsColumnInWMIPAge(){
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.navigateToSLAPageFrmSSHPage();
        sshPage.navigateToWMIpage();
        sshPage.deletingAddedSSh();
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_WMI_014_ApplyFiltersInSSHPage()
    {
        sshPage.clickingOnWMIInAutomation();
        sshPage.addingSSH();
        sshPage.applyingFiltersInSSHPage();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Click_001_AddClickByExportingRecordedActionsFromExtensionWindow() throws InterruptedException, AWTException
    {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingNewRecordingInClickPage();
        sshPage.switchingToMainWindow();
        sshPage.startedRecording();
        sshPage.addingClickConfigurations();
        sshPage.verifyingAddedClickActions();

    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Click_002_AddclickbyimportingexistingJSonfileinsystem() throws InterruptedException, AWTException
    {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingJSonFileUsingImport();
        sshPage.addingClickConfigurations();
        sshPage.verifyingAddedClickActions();

    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Click_003_AddandeditcustomRuleClick()
    {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingCUStomeRole();
        sshPage.verifyingCustomRulesConfigs();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Click_004_EditClickByimportingexistingJSONfileinsystem() throws InterruptedException, AWTException {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingJSonFileUsingImport();
        sshPage.addingClickConfigurations();
        sshPage.addingElementSelectorsInEditSceanrioWindow();

    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Click_005_Exportactionsinsystemtoextensionwindow() throws InterruptedException, AWTException {
        sshPage.clickingOnClickModuleInAutomation();
        sshPage.addingNewRecordingInClickPage();
        sshPage.switchingToMainWindow();
        sshPage.verifyingExportingActionsOnClosingGermainApm();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_SSH_013_VerifyPageIconsInSSHPage()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.verifyingPageIconsInSSH();
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_SSH_005_NavigatetoScriptPageOnClickingAnyScriptUnderSCRIPTColumn()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.addingScriptInLocalProgramsEditWindow();
        sshPage.navigateToScriptPageFrmSSHPage();
        sshPage.deletingAddedSSHConfig();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_SSH_006_NavigateToSLAspageonclickinganySLAunderTriggeredBySLAsColumn()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.navigateToSLAPageFrmSSHPage();
        sshPage.deletingAddedSSHConfig();
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_SSH_014_ApplyFiltersInSSHPage()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.applyingFiltersInSSHPage();
    }
    @Test(alwaysRun = true,groups ="Smoke Suite")
    public void TC_SSH_016_VerifyIconsInSSHEditConfigWindow()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.verifyingIconsInSSHEditWindow();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_SSH_018_ViewDataforFieldsWithViewIconinSSHEditconfigwindow()
    {
        sshPage.clickingOnAutomation();
        sshPage.addingSSH();
        sshPage.validateTheFeildsViewIconInSSHWindow();

    }
}
