package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.SoftwarePage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SoftwareTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private SoftwarePage softwarePage;
    private DashboardOverviewPage dashboardOverviewPage;
    Random random = new Random();
    String DbTitle = "Module_soft" + " - " + random.nextInt(500);
    String EditTitle = "Module_Sft_Edit" + " - " + random.nextInt(500);

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        softwarePage = new SoftwarePage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }

    @Test(groups = "Smoke Test")
    public void TC_Sware_001_AddSoftwareConfiguration() throws InterruptedException
    {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware(DbTitle);
        softwarePage.verifyingSoftwareNameDetails(DbTitle);
    }
    @Test(groups = "Smoke Test")
    public void TC_Sware_002_EditSoftwareConfiguration() throws InterruptedException
    {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware(DbTitle);
        softwarePage.editConfiugurationSoftwareDetails(DbTitle,EditTitle);
        softwarePage.verifyingEditSoftwareNameDetails(EditTitle);

    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Sware_004_VerifyPageIconsInSoftwarepage()
    {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware(DbTitle);
        softwarePage.verifyingPageIconsInSoftwarepage(DbTitle);
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Sware_005_ApplyFiltersInSoftwarePage()
    {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware(DbTitle);
        softwarePage.applyingFiltersInSoftwarePage(DbTitle);
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Sware_003_NavigateToReferencesEditWindowInEditConfigwindow()
    {
        softwarePage.navigateToReferenceWindowFromSoftwareEditWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Sware_008_VerifyIconsInEditConfigWindow()
    {
        softwarePage.clickingOnSoftware();
        softwarePage.addingNewSoftware(DbTitle);
        softwarePage.VerifyIconsInSoftwareEditConfigWindow(DbTitle);
    }





}