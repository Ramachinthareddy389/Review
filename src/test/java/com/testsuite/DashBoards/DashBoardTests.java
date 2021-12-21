package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class DashBoardTests extends BaseSetup {
    private DashboardPage dashboardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private PivotPage pivotPage;

    private String sModeOfExecution;
    Random random = new Random();
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        pivotPage = new PivotPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
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
    public void TC_Dash_012_Verify_Dashboard_Visibility_AllowedUsers() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        portletsFeature.addingGaugePortletForAllThenavgations(gaugePortletName);
        dashboardPage.setAllowedUsersInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.userName, PasswordDecoder.passwordDecrypt(dashBoardData.userPassword));
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByAllowedUser(gaugePortletName);
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.removeAllowedUsersInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.userName, PasswordDecoder.passwordDecrypt(dashBoardData.userPassword));
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByUserAfterRemovingAccess();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Dash_013_Verify_Dashboard_Visibility_RequiredRoles() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        dashboardPage.setRequiredRolesInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.requiredRole_Username, PasswordDecoder.passwordDecrypt(dashBoardData.userPassword));
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByRequiredRoleUser();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.removeRequiredRoleInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.requiredRole_Username, PasswordDecoder.passwordDecrypt(dashBoardData.userPassword));
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByUserAfterRemovingRequiredRole();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Dash_014_Verify_Dashboard_Visibility_OwnerRoles() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        dashboardPage.setOwnerRolesInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.ownerRole_Username, PasswordDecoder.passwordDecrypt(dashBoardData.userPassword));
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByOwnerRoleUser();
        dashboardPage.removeOwnerRoleInDashboardVisibility();
        dashboardPage.accessDashboardByUserAfterRemovingOwnerRole();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Dash_020_CreateTicketOnDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        dashboardPage.clickOnDashboard();
        dashboardPage.createTicketOnDashboard();
        dashboardPage.verifyTicketInTicketsPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardPage.searchingDashboard();
        dashboardPage.deleteDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Dash_021_PinUnPinDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        dashboardPage.PinDashboard();
        dashboardPage.Unpin_Pin_Dashboard_FromDashboardPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardPage.searchingDashboard();
        dashboardPage.deleteDashboard();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Breadcrumb_001_Verify_Standard_Breadcrumb_Navigation() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        portletsFeature.addingGaugePortletForAllThenavgations(gaugePortletName);
      //  portletsFeature.verifyingPortletAddedFromSearchBar();
        // dashboardOverviewPage.validatingLast30Days("12:00 AM");
        pivotPage.navigateToPivotPage(gaugePortletName);
        dashboardPage.navigateToDrillthroughPageFromPivotPage();
        portletsFeature.navigateToRCAFromDrillthroughPage();
        dashboardPage.verifyStandardBreadcrumbNavigation(gaugePortletName);
        dashboardPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Breadcrumb_002_Verify_Standard_Breadcrumb_Backward_Navigation() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        portletsFeature.addingGaugePortletForAllThenavgations(gaugePortletName);
      //  portletsFeature.verifyingPortletAddedFromSearchBar();
        // dashboardOverviewPage.validatingLast30Days("12:00 AM");
        pivotPage.navigateToPivotPage(gaugePortletName);
        dashboardPage.navigateToDrillthroughPageFromPivotPage();
        portletsFeature.navigateToRCAFromDrillthroughPage();
        dashboardPage.verifyStandardBreadcrumbNavigation(gaugePortletName);
        dashboardPage.verifyStandardBreadcrumbBackwardNavigation(gaugePortletName);
        dashboardPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Breadcrumb_003_Verify_Standard_Breadcrumb_Navigation_With_Constraints_From_Drillthrough_To_RCA() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        portletsFeature.addingGaugePortletForAllThenavgations(gaugePortletName);
      //  portletsFeature.verifyingPortletAddedFromSearchBar();
        // dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.navigateToDrillthroughPage(gaugePortletName);
        dashboardPage.applyAndVerifyConstraintsInDrillthroughPage();
        portletsFeature.navigateToRCAFromDrillthroughPage();
        dashboardPage.verifyBreadcrumbNavigationWithConstraintsInDrillthroughPage();
        dashboardPage.verifyBreadcrumbBackwardNavigationWithConstraintsInDrillthroughPage(gaugePortletName);
        dashboardPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Breadcrumb_004_BreadcrumbNavigationfromPortletwithConstraintsinPivotpage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        portletsFeature.addingGaugePortletForAllThenavgations(gaugePortletName);
      //  portletsFeature.verifyingPortletAddedFromSearchBar();
        //  dashboardOverviewPage.validatingLast30Days("12:00 AM");
        pivotPage.navigateToPivotPage(gaugePortletName);
        dashboardPage.applyAndVerifyConstraintsInDrillthroughPage();
        portletsFeature.navigateToRCApageFrmPivotPage();
        dashboardPage.verifyBreadcrumBackwardNavigationFromRCAPAge();
        dashboardPage.deletingDashboard();

    }


}