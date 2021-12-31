package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.AlertTemplatePage;
import com.page.module.AuthenticationPage;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AuthenticationTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private AuthenticationPage authenticationPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;
    Random random = new Random();
    String dname = "testng";
    String dname1 = dname + random.nextInt(1500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        authenticationPage = new AuthenticationPage(getDriver());
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

    @Test(alwaysRun = true)
    public void TC_Auth_001_AddAuthenticationConfiguration() throws InterruptedException
    {
        authenticationPage.clickingOnAuthentication();
        authenticationPage.addingJDBCAuthentication();
        authenticationPage.verifyingAddedAuthentication();
        authenticationPage.addingLADPAuthentication();
        authenticationPage.verifyingAddedAuthentication();
        authenticationPage.addingOauthAuthentication();
        authenticationPage.verifyingAddedAuthentication();

    }

    @Test(alwaysRun = true)
    public  void TC_Auth_002_Editalltypesofproviders()
    {
        authenticationPage.clickingOnAuthentication();
        authenticationPage.addingJDBCAuthentication();
        authenticationPage.editAuthenticationConfigurations();
        authenticationPage.addingLADPAuthentication();
        authenticationPage.editLDAPConfig();
    }

    @Test(alwaysRun = true)
    public  void TC_Auth_003_UpdateManagerPasswordinEditLDAPProviderwindow()
    {
        authenticationPage.clickingOnAuthentication();
        authenticationPage.addingLADPAuthentication();
        authenticationPage.updatingManagerPassword();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Auth_004_VerifyPageIcons(){
        authenticationPage.clickingOnAuthentication();
        authenticationPage.addingJDBCAuthentication();
        authenticationPage.navigatingToAuthPage();
        authenticationPage.verifyingPageIcons();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Auth_005_ApplyFilters(){
        authenticationPage.clickingOnAuthentication();
        authenticationPage.addingJDBCAuthentication();
        authenticationPage.applyingFiltersInAlertsPage();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Auth_007_VerifyIconsinEditConfigWindows(){
        authenticationPage.clickingOnAuthentication();
        authenticationPage.addingJDBCAuthentication();
        authenticationPage.verifyingIconsInEditWindow();
    }
}
