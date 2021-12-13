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


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_LProgram_001_AddLocalProgramConfiguration() throws InterruptedException
    {
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalPrograms();
        localProgramPage.verifyingLocalprogrames();

    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_LProgram_002_AddScriptinAddEditLocalProgramwindow() throws InterruptedException
    {
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalPrograms();
        localProgramPage.addingScriptInLocalProgramsEditWindow();
        localProgramPage.verifyingAddedScriptInLocalProgramsEditwindow();


    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_003_AddSLAsinAddEditLocalProgramWindow()
    {
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalProgramWithoutSla();
        localProgramPage.verifyingAddedSLAsInLocalProgramsWindow();
        localProgramPage.deletingCreatedLocalProgram();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_007_NavigateToScriptPageFrmLocalProgramPage() throws InterruptedException {
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalPrograms();
        localProgramPage.addingScriptInLocalProgramsEditWindow();
        localProgramPage.navigateToScriptPageFrmLocalProgrammes();
        localProgramPage.deletingCreatedLocalProgram();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_008_NavigateToSLAsPageOnClickingAnySLAUnderTriggeredBySLAsColumn(){
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalProgramWithoutSla();
        localProgramPage.verifyingAddedSLAsInLocalProgramsWindow();
        localProgramPage.navigateToSLAPageFrmLocalPrgms();
        localProgramPage.deletingCreatedLocalProgram();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_009_VerifyPageIconsInLocalPrgm(){
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalProgramWithoutSla();
        localProgramPage.verifyingPageIconsInLocalPrgms();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_010_ApplyFiltersInLocalPrgm(){
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalProgramWithoutSla();
        localProgramPage.applyingFiltersInLocalprgmPage();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_012_VerifyIconsInLocalPrgmsEditConfigWindows(){
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalProgramWithoutSla();
        localProgramPage.VerifyIconsInLocalPrgrmsEditConfigwindow();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_LProgram_014_ViewDataForFieldsWithViewIconInLocalPrgmsEditConfigWindows(){
        localProgramPage.clickingOnAutomation();
        localProgramPage.addingLocalPrograms();
        localProgramPage.addingScriptInLocalProgramsEditWindow();
        localProgramPage.validateTheFeildsViewIconInLocalPrgrmsWindow();
    }
}
