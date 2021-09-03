package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AlertTemplateTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private AlertTemplatePage alertTemplatePage;
    private  InsightsPage insightsPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private EmailPage emailPage;

    private String sModeOfExecution;
    Random random = new Random();
    String dname = "testng";
    String dname1 = dname + random.nextInt(1500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        alertTemplatePage = new AlertTemplatePage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        insightsPage = new InsightsPage(getDriver());
        emailPage = new EmailPage(getDriver());
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
    public void TC_355_AddAlertTemplateConfiguration() throws InterruptedException {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate();
        alertTemplatePage.verifyingAlertTemplateDetails();

    }

    @Test(alwaysRun = true)
    public void TC_366_EditAlertTemplateConfiguration() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate();
        alertTemplatePage.EditingAlertTemplateConfig();
        alertTemplatePage.verifyingEditedConfiguraions();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_340_TriggerAnAlertbasedonSLAs() {
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts();
        alertTemplatePage.deletingAlert();
        getDriver().get(dashBoardData.yopemail);
        emailPage.navigatingToEmail("alertzenq@yopmail.com", "Germain Alert - User Click - germainApm - PERFORMANCE Issue");
        alertTemplatePage.VerifyingEmailSubject("Germain Alert - User Click - germainApm - PERFORMANCE Issue");
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_344_VerifytriggeredalertsinInsightspage()
    {
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts();
        insightsPage.navigateToInsightsPage();
        alertTemplatePage.verifyingAddedAlertInInsightPage();
        alertTemplatePage.deletingAlert();
    }
}