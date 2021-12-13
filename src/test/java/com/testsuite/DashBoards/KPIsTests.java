package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class KPIsTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private KPIsPage kpIsPage;
    private AlertTemplatePage alertTemplatePage;
    private String sModeOfExecution;
    Random random = new Random();
    String dname = "testng";
    String dname1 = dname + random.nextInt(1500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        kpIsPage = new KPIsPage(getDriver());
        dashBoardData = new DashBoardData();
        alertTemplatePage = new AlertTemplatePage(getDriver());
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_001_AddKPIconfigurationwithallSLATypes() throws InterruptedException {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.verifyingKPIsPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_002_EditKPIconfiguration()
    {
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.editKPISConfig();
        kpIsPage.verifyingEditedKPISDetails();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_003_AddSLAsinEditKPIconfigwindow() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.addingSLASInEditConfigWindow();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.verifyingAddedSLASInEditConfigWindow();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_004_AddThresholdinFactBasedSLAeditwindowinKPIpage() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.addingThresholdValueInEditKPIswindow();
        kpIsPage.verifyingAddedThresholdInEditWindow();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_005_NavigatetoDrillthroughpagefromKPIeditconfigwindow() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.navigateToDrillThrghPageFrmKpiEditWindow();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_008_AddActionsinEditSLAconfigwindowinKPIspage() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.addingActionsInEditSLAConfigWindow();
        kpIsPage.verifyingActionsInEditSLAConfigWindow();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_012_VerifyIconsInEditConfigWindow() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(dname1);
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction(dname1);
        kpIsPage.verifyingIconsInEditConfigWindow();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_KPIs_014_ViewDataForFieldsWithViewIconInEditConfigWindow() {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate("ALERTTEMPLATE");
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction("ALERTTEMPLATE");
        kpIsPage.viewDataWithFeildsForViewIcon();
        alertTemplatePage.clickingOnAlertTemplate();
        kpIsPage.deleteinAlertTemplate("ALERTTEMPLATE");
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_KPIs_009_VerifyPageIconsInKPIPage(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate("ALERTTEMPLATE");
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction("ALERTTEMPLATE");
        kpIsPage.verifyingPageIcons();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_KPIs_010_ApplyFiltersInKPIPage(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate("ALERTTEMPLATE");
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction("ALERTTEMPLATE");
        kpIsPage.applyingFilters();
    }


}
