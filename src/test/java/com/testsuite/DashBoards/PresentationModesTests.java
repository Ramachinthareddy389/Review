package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PresentationModesTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private LocalProgramPage localProgramPage;
    private PresentationModesPage presentationModesPage;
    private HardwarePage hardwarePage;
    private HTTPPage httpPage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        presentationModesPage = new PresentationModesPage(getDriver());
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
    public void TC_418_AddNewPresentationwithDashboards() throws InterruptedException {
        presentationModesPage.clickingOnPresentationModes();
        presentationModesPage.addingPresentationModeConfigWithDashboards();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.verifyingAddedPresenatationModesWithDasshboardsConfig();


    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_419_AddNewPresentationwithViews() throws InterruptedException {
        presentationModesPage.clickingOnPresentationModes();
        presentationModesPage.uncheckDashBoardCheckBox();
        presentationModesPage.addingPresentationModeConfigWithViews();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.verifyingAddedPresenatationModesWithDasshboardsConfig();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_420_AddDashboardsViewsinEditPresentationModewindow()
    {
        presentationModesPage.clickingOnPresentationModes();
        presentationModesPage.addingPresentationModeConfigWithDashboards();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.addingDashboardsNDViewsfromEditPresentationModeWindow();
        presentationModesPage.addingPresentationModeConfigWithDashboards();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.verifyingAddedDashboardInEditPresentationWindow();
        presentationModesPage.addingPresentationModePage();
        presentationModesPage.uncheckDashBoardCheckBox();
        presentationModesPage.addingPresentationModeConfigWithViews();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.addingDashboardsNDViewsfromEditPresentationModeWindow();
        presentationModesPage.uncheckDashBoardCheckBox();
        presentationModesPage.addingPresentationModeConfigWithViews();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.verifyingAddedDashboardInEditPresentationWindow();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_422_VerifyPresentationmodesinPresentationbutton() {
        presentationModesPage.clickingOnPresentationModes();
        presentationModesPage.addingPresentationModeConfigWithDashboards();
        presentationModesPage.addingTimeRangesAndDurationConfigs();
        presentationModesPage.verifyingPresentationModesInPresentationButton();
    }

}
