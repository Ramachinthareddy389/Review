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
    private  SLAsPage slAsPage;

    private String sModeOfExecution;
    Random random = new Random();
    String dname = "testng";
    String dname1 = dname + random.nextInt(1500);
    String Alert = "alert" + random.nextInt(1500);
    String slasName = "SLAs" + random.nextInt(3000);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        alertTemplatePage = new AlertTemplatePage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        insightsPage = new InsightsPage(getDriver());
        emailPage = new EmailPage(getDriver());
        slAsPage = new SLAsPage(getDriver());
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
    public void TC_AleTemp_001_AddAlertTemplateConfiguration() throws InterruptedException {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        alertTemplatePage.verifyingAlertTemplateDetails(dname1);

    }

    @Test(alwaysRun = true)
    public void TC_AleTemp_002_EditAlertTemplateConfiguration() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        alertTemplatePage.EditingAlertTemplateConfig(dname1);
        alertTemplatePage.verifyingEditedConfiguraions(dname1);
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Alerts_001_TriggerAnAlertbasedonSLAs() {
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.deletingAlert(Alert);
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zentest75@yopmail.com", "Germain Alert - User Click - germainApm - PERFORMANCE Issue");
      //  alertTemplatePage.VerifyingEmailSubject("Germain Alert - User Click - germainApm - PERFORMANCE Issue");
        emailPage.clickingOnEmptyInbox();
        alertTemplatePage.deletingEmails();
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Alerts_005_VerifytriggeredalertsinInsightspage()
    {
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        insightsPage.navigateToInsightsPage();
        alertTemplatePage.verifyingAddedAlertInInsightPage();
        alertTemplatePage.deletingAlert(Alert);
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public  void TC_Alerts_002_TriggerAnAlertwithNotifications()
    {
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.triggeringAnAlertWithNotify(Alert);
        alertTemplatePage.deletingAlert(Alert);
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zentest75@yopmail.com", "Germain Alert - Internal issue - Notification for "+Alert);
        emailPage.clickingOnEmptyInbox();
       // alertTemplatePage.deletingEmails();
    }

   @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_004_TriggerAnAlertBasedonExecutionCount(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.triggeringAlertBasedOnExecutionCount(Alert);
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zentest75@yopmail.com", "Germain Alert - User Click - germainApm - PERFORMANCE Issue");
//        emailPage.clickingOnEmptyInbox();
    //    alertTemplatePage.deletingEmails();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_003_TriggerAnAlertwithSpecifiedQuiettime(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.triggeringAnAlertWithSpecifiedquiteTime(Alert);
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zentest75@yopmail.com", "Germain Alert - User Click - germainApm - PERFORMANCE Issue");


    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_006_VerifyDatainAlertEmail(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.triggeringAnAlertWithSpecifiedquiteTime(Alert);
        alertTemplatePage.deletingAlert(Alert);
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zentest75@yopmail.com", "Germain Alert - User Click - germainApm - PERFORMANCE Issue");
        emailPage.clickingHyperlinksInAlertEmails();
        //alertTemplatePage.deletingEmails();
    }
    @Test(alwaysRun = true,groups = "Smoke SUite")
    public void TC_Alerts_008_VerifyPageIconsinAlertPage()
    {
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.navigatingToAlertPage();
        alertTemplatePage.verifyingPageIcons(Alert);
        alertTemplatePage.verifyingEditIconFunctionalityInAlerts();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_009_ApplyFiltersInAlertsPage(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.navigatingToAlertPage();
        alertTemplatePage.applyingFilters(Alert);
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_AleTemp_006_VerifyPageIconsInAlertTemplatePage(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        alertTemplatePage.verifyingPageIcons(dname1);
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_AleTemp_007_ApplyFiltersInAlertTemplatePage(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        alertTemplatePage.applyingFilters(dname1);
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_AleTemp_009_VerifyIconsInEditConfigWindow(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        alertTemplatePage.verifyingIconsInEditWindow(dname1);
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_AleTemp_005_NavigateToSLAsPageFromAlertTemplateEditwindow(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction(dname1);
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.NavigateToSLAsPageFromAlertTemplateEditwindow(dname1);
        slAsPage.validatingSLATitleInSlAPAge(slasName);
        slAsPage.deleteinAlertTemplate(dname1);


    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_011_VerifyIconsinEditconfigWindows(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.verifyingIconsInEditWindow(Alert);
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_013_NavigatetoSLAEditWindowfrmAlertsEditwindow(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.NavigateToSLAsPageFromAlertEditwindow(Alert);
        alertTemplatePage.validatingSLAsEditWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_014_ViewDataforFieldsWithViewIconinEditConfigWindows(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.verifyingTheViewDataForFeidlsInAlertsEditWindow(Alert);

    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_Alerts_015_NavigatetoSLAsPageonClickingAnySLAUnderTriggeredBySLAsColumn(){
        alertTemplatePage.clickingOnAlerts();
        alertTemplatePage.addingAlerts(Alert);
        alertTemplatePage.navigateToSLAPageFrmAlertspage(Alert);
        alertTemplatePage.navigatingToAlertPage();
        alertTemplatePage.deletingCreatedAlerts(Alert);
    }

}