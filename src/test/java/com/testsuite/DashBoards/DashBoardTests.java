package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.DashboardPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashBoardTests extends BaseSetup  {
    private DashboardPage dashboardPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private DashboardOverviewPage dashboardOverviewPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashboardOverviewPage  =new DashboardOverviewPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, dashBoardData.password);
        loginPage.clickLogInButton();
    }

    @Test( groups ="Smoke Test" )
    public void TC112_PinUnPinDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        dashboardPage.PinDashboard();
        dashboardPage.Unpin_Pin_Dashboard_FromDashboardPage();
    }

    @Test( groups ="Smoke Test" )
    public void TC020_CreateTicketOnDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        dashboardPage.clickOnDashboard();
        dashboardPage.createTicketOnDashboard();
        dashboardPage.verifyTicketInTicketsPage();
    }
    @Test(groups = "Smoke Test")
    public void TC012_Verify_Dashboard_Visibility_AllowedUsers() throws InterruptedException {
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.setAllowedUsersInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.userName,dashBoardData.userPassword);
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.accessDashboardByAllowedUser();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, dashBoardData.password);
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.removeAllowedUsersInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.userName,dashBoardData.userPassword);
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByUserAfterRemovingAccess();
    }

    @Test(groups = "Smoke Test")
    public void TC013_Verify_Dashboard_Visibility_RequiredRoles() throws InterruptedException {
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.setRequiredRolesInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.requiredRole_Username,dashBoardData.userPassword);
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.accessDashboardByRequiredRoleUser();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, dashBoardData.password);
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.removeRequiredRoleInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.requiredRole_Username,dashBoardData.userPassword);
        loginPage.clickLogInButton();
        dashboardPage.accessDashboardByUserAfterRemovingRequiredRole();
    }

    @Test(groups = "Smoke Test")
    public void TC014_Verify_Dashboard_Visibility_OwnerRoles() throws InterruptedException {
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.setOwnerRolesInDashboardVisibility();
        loginPage.clickLogoutButton();
        loginPage.enterLoginCredentials(dashBoardData.ownerRole_Username,dashBoardData.userPassword);
        loginPage.clickLogInButton();
        dashboardPage.navigateToDashboardsPage();
        dashboardPage.accessDashboardByOwnerRoleUser();
        dashboardPage.removeOwnerRoleInDashboardVisibility();
        dashboardPage.accessDashboardByUserAfterRemovingOwnerRole();
    }


}