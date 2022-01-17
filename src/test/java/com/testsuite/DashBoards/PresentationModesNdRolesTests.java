package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PresentationModesNdRolesTests extends BaseSetup {
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
    public void TC_PresenModes_001_AddNewPresentationwithDashboards() throws InterruptedException {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingAddedPresenatationModesWithDasshboardsConfig();


    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_PresenModes_002_AddNewPresentationwithViews() throws InterruptedException {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.uncheckDashBoardCheckBox();
        presentationModesNdRulesPages.addingPresentationModeConfigWithViews();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingAddedPresenatationModesWithDasshboardsConfig();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_PresenModes_003_AddDashboardsViewsinEditPresentationModewindow() {
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
    public void TC_PresenModes_005_VerifyPresentationmodesinPresentationbutton() {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingPresentationModesInPresentationButton();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_PresenModes_007_EditDashboardNdViewconfigurationinEditPresentationModewindow() {
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


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_PresenModes_008_VerifyPageIconsInPresentationMode() {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingPageIconsInPresentationModes();
    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_PresenModes_009_ApplyFiltersInPresentationMode() {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.applyingFiltersInPresentationModes();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_PresenModes_011_VerifyIconsInPresentationModeEditConfigWindow() {
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.verifyingIconsInPresentationEditConfigWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_PresenModes_013_ViewDataForFieldsWithViewIconInEditconfigWindows(){
        presentationModesNdRulesPages.clickingOnPresentationModes();
        presentationModesNdRulesPages.addingPresentationModeConfigWithDashboards();
        presentationModesNdRulesPages.addingTimeRangesAndDurationConfigs();
        presentationModesNdRulesPages.viewDataWithFeildsForViewIconInPresentationMode();
    }
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Rules_001_AddRuleconfiguration() {
        presentationModesNdRulesPages.addRuleConfiguration();
        presentationModesNdRulesPages.verifyingAddedRules();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Rules_002_EditRuleConfiguration() {
        presentationModesNdRulesPages.addRuleConfiguration();
        presentationModesNdRulesPages.EditRulesConfig();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Rules_005_VerifyPageIconsInRulesPage() {
        presentationModesNdRulesPages.addRuleConfiguration();
        presentationModesNdRulesPages.verifyingPageIconsInRulesPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_TimeRanges_001_AddAbsoluteTimeRange() {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.startPageConfigs();
        presentationModesNdRulesPages.endPageConfigs();
        presentationModesNdRulesPages.verifyingAddedAbsoluteTimeRangesInEditWindow();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_TimeRanges_002_AddRelativeTimeRange() {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.addingRelativeTimeRanges();
        presentationModesNdRulesPages.addingRelativeTimeRangeEndPageConfigs();
        presentationModesNdRulesPages.verifyingAddedRelativeTimeRange();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_TimeRanges_003_EditTimeRangeConfiguration() {
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

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_TimeRanges_005_VerifyTimeRangesinCalendar() throws InterruptedException {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.startPageConfigs();
        presentationModesNdRulesPages.endPageConfigs();
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SelectingCalender("clone Parent");
        presentationModesNdRulesPages.verifyTimeRangesInCalendar();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_TimeRanges_006_VerifyTimeRangesinGuidedSearchPage() {
        presentationModesNdRulesPages.addingTimeRanges();
        presentationModesNdRulesPages.startPageConfigs();
        presentationModesNdRulesPages.endPageConfigs();
        presentationModesNdRulesPages.verifyingTimeRangesInGuidedSearchPage();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_UserRoles_001_AddNewRole() {
        presentationModesNdRulesPages.clickingOnUserRoles();
        presentationModesNdRulesPages.addingNewUserRoles();
        presentationModesNdRulesPages.verifyingAddedUserRoles();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_UserRoles_002_EditRole() {
        presentationModesNdRulesPages.clickingOnUserRoles();
        presentationModesNdRulesPages.addingNewUserRoles();
        presentationModesNdRulesPages.editUserRolesConfig();
    }
}
