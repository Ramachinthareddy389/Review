package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.UXSettingsPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class UXSettingsTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private UXSettingsPage uxSettingsPage;

    private String sModeOfExecution;
    Random random = new Random();


    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        uxSettingsPage = new UXSettingsPage(getDriver());
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

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_UXSet_005_NavigatetoEditwindowOfWebUXAgentsInApplicationProfileEditWindow() throws InterruptedException
    {
        uxSettingsPage.ClickingOnUXSettings();
        uxSettingsPage.verifyingTheNavigationOfWebExAgentWindow();

    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_UXSet_006_VerifyPageIconsInUXSettingWindow(){
        uxSettingsPage.ClickingOnUXSettings();
        uxSettingsPage.verifyingPageIconsInUXSettingsPage();
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_UXSet_007_ApplyFiltersInUXSettingWindow(){
        uxSettingsPage.ClickingOnUXSettings();
        uxSettingsPage.applyingFiltersInUxSettingsWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_UXSet_011_VerifyIconsInUxSetingsEditConfigWindow() {
        uxSettingsPage.ClickingOnUXSettings();
        uxSettingsPage.VerifyIconsInUxSetingsEditConfigWindow();
    }

}
