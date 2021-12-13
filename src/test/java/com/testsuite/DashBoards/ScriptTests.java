package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.HardwarePage;
import com.page.module.LocalProgramPage;
import com.page.module.LoginPage;
import com.page.module.ScriptPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScriptTests  extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private ScriptPage scriptPage;
    private HardwarePage hardwarePage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        scriptPage  = new ScriptPage(getDriver());
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


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Script_001_AddScriptconfigurationwithallConnectionTypes() throws InterruptedException
    {
        scriptPage.clickingOnAutomation();
        scriptPage.addingScripts();
        scriptPage.searchingForScript();
        scriptPage.verifyingAddedScript();

    }

   @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Script_002_EditScriptConfigurartion()
    {
        scriptPage.clickingOnAutomation();
        scriptPage.addingScripts();
        scriptPage.editScriptConfigurationWindow();
        scriptPage.verifyingAddedScript();

    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Script_004_AddSLAinAddScriptwindow()
    {
        scriptPage.clickingOnAutomation();
        scriptPage.addinSLA();
        scriptPage.verifyingAddedSLAsScriptWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Script_003_NavigateToActionsPageFromScriptEditWindow(){
        scriptPage.clickingOnAutomation();
        scriptPage.addingScripts();
        scriptPage.searchingForScript();
        scriptPage.navigatingToActionPageFrmScriptWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Script_005_VerifyPageIconsInScriptPage(){
        scriptPage.clickingOnAutomation();
        scriptPage.addingScripts();
        scriptPage.verifyingPageIconsinScriptPage();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Script_006_ApplyFiltersInScriptPage(){
        scriptPage.clickingOnAutomation();
        scriptPage.addingScripts();
        scriptPage.applyingFiltersInScriptPage();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Script_008_VerifyIconsInScriptPageEditConfigwindow(){
        scriptPage.clickingOnAutomation();
        scriptPage.addingScripts();
        scriptPage.verifyingIconsInScriptEditWindow();
    }
}
