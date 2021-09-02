package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PresentationModesNdRulesTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardOverviewPage dashboardOverviewPage;
    private PresentationModesNdRulesNdRulesPages presentationModesNdRulesPages;
    private HardwarePage hardwarePage;
    private HTTPPage httpPage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        presentationModesNdRulesPages = new PresentationModesNdRulesNdRulesPages(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
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
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingAddedPresenatationModesWithDasshboardsConfig();


    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_419_AddNewPresentationwithViews() throws InterruptedException {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.uncheckDashBoardCheckBox();
        presentationModesNdRulesPages.addingPresentationModeConfigWithViews();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingAddedPresenatationModesWithDasshboardsConfig();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_420_AddDashboardsViewsinEditPresentationModewindow()
    {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.addingDashboardsNDViewsfromEditPresentationModeWindow();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingAddedDashboardInEditPresentationWindow();
        presentationModesNdRulesPages.addingPresentationModePage();
        presentationModesNdRulesPages.uncheckDashBoardCheckBox();
        presentationModesNdRulesPages.addingPresentationModeConfigWithViews();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.addingDashboardsNDViewsfromEditPresentationModeWindow();
        presentationModesNdRulesPages.uncheckDashBoardCheckBox();
        presentationModesNdRulesPages.addingPresentationModeConfigWithViews();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingAddedDashboardInEditPresentationWindow();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_422_VerifyPresentationmodesinPresentationbutton() {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingPresentationModesInPresentationButton();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_424_EditDashboardNdViewconfigurationinEditPresentationModewindow()
    {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.editDashboardConfigValues();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingEditedDashboardViewConfigValues();
        presentationModesNdRulesPages.addingPresentationModePage();
        presentationModesNdRulesPages.uncheckDashBoardCheckBox();
        presentationModesNdRulesPages.addingPresentationModeConfigWithViews();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.editDashboardConfigValues();
        presentationModesNdRulesPages.uncheckDashBoardCheckBox();
        presentationModesNdRulesPages.addingPresentationModeConfigWithViews();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingEditedDashboardViewConfigValues();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_431_AddRuleconfiguration()
    {
      presentationModesNdRulesPages.addRuleConfiguration();
      presentationModesNdRulesPages.verifyingAddedRules();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_432_EditRuleConfiguration()
    {
        presentationModesNdRulesPages.addRuleConfiguration();
        presentationModesNdRulesPages.EditRulesConfig();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_440_AddAbsoluteTimeRange()
    {
       presentationModesNdRulesPages.addingTimeRanges();
       presentationModesNdRulesPages.startPageConfigs();
       presentationModesNdRulesPages.endPageConfigs();
       presentationModesNdRulesPages.verifyingAddedAbsoluteTimeRangesInEditWindow();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_441_AddRelativeTimeRange()
    {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.addingRelativeTimeRanges();
        presentationModesNdRulesPages.addingRelativeTimeRangeEndPageConfigs();
        presentationModesNdRulesPages.verifyingAddedRelativeTimeRange();
    }

    @Test(alwaysRun = true,groups ="Smoke Test")
    public void TC_442_EditTimeRangeConfiguration()
    {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.startPageConfigs();
        presentationModesNdRulesPages.endPageConfigs();
        presentationModesNdRulesPages.editingAbsoluteTimerange();
        presentationModesNdRulesPages.verifyingEditedValuesInAbsoluteTimerange();
        presentationModesNdRulesPages.ClickingOnTimeRanges();
        presentationModesNdRulesPages.addingRelativeTimeRanges();
        presentationModesNdRulesPages.addingRelativeTimeRangeEndPageConfigs();
        presentationModesNdRulesPages.editingRelativeTimeRange();
        presentationModesNdRulesPages.verifyingEditedRelativeTimerangeConfigs();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_444_VerifyTimeRangesinCalendar() throws InterruptedException {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.startPageConfigs();
        presentationModesNdRulesPages.endPageConfigs();
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        presentationModesNdRulesPages.verifyTimeRangesInCalendar();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_445_VerifyTimeRangesinGuidedSearchPage()
    {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.startPageConfigs();
        presentationModesNdRulesPages.endPageConfigs();
        presentationModesNdRulesPages.verifyingTimeRangesInGuidedSearchPage();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_457_AddNewRole()
    {
        presentationModesNdRulesPages.clickingOnUserRoles();
        presentationModesNdRulesPages.addingNewUserRoles();
        presentationModesNdRulesPages.verifyingAddedUserRoles();
    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_458_EditRole()
    {
        presentationModesNdRulesPages.clickingOnUserRoles();
        presentationModesNdRulesPages.addingNewUserRoles();
        presentationModesNdRulesPages.editUserRolesConfig();
    }
}
