package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.AlertTemplatePage;
import com.page.module.KPIsPage;
import com.page.module.LoginPage;
import com.page.module.SLAsPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SLAsTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private KPIsPage kpIsPage;
    private SLAsPage slAsPage;
    private AlertTemplatePage alertTemplatePage;
    private String sModeOfExecution;
    Random random = new Random();
    String AlertTemplate = "Alerttemplate" + random.nextInt(3000);
    String slasName = "SLAs" + random.nextInt(3000);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        kpIsPage = new KPIsPage(getDriver());
        slAsPage = new SLAsPage(getDriver());
        alertTemplatePage = new AlertTemplatePage(getDriver());
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
    public void TC_SLAs_001_AddSLAConfigforAllTypes() throws InterruptedException {
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate("ALERTTEMPLATE");
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.verifyingSLAsPage(slasName);
    }
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_SLAs_003_EditSLAconfigforallTypes()
    {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.editSLAsConfig(slasName);
        slAsPage.verifyingEditedSLADetails();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_SLAs_002_AddThresholdinFactBasedSLAeditwindow() {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.addingThresholdValueInEditSLAswindow(slasName);
        slAsPage.verifyingAddedThresholdInEditWindow();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_SLAs_004_AddActionsinEditSLAconfigwindow(){

        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.addingActionsInEditSLAConfigWindow(slasName);
        slAsPage.verifyingActionsInEditSLAConfigWindow();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_SLAs_005_AddAlertTemplateInEditSLAConfigWindow() {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.addingAlertTemplateInEditSLAConfigWindow(slasName);
        alertTemplatePage.addIngAlertTemplate(AlertTemplate);
        slAsPage.verifyingAddedAlertTemplateInSLAEditWindow(AlertTemplate);
        alertTemplatePage.navigateToAlertTemplateWindow();
        alertTemplatePage.deletingAlert(AlertTemplate);

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_SLAs_006_NavigateToKPIsPageonClickingAnyKPIUnderKPINameColumn() {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.navigateToKPIPageFromSLAPage(slasName);
        slAsPage.clickingSLAsPage();
        slAsPage.deletingCreatedSLAs(slasName);

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_SLAs_007_NavigateToAlertTemplatesPageonClickingnAlertTempUnderSLASPAge(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.navigateToAlertTemplatePageFrmSLAPage(slasName);
        slAsPage.clickingSLAsPage();
        slAsPage.deletingCreatedSLAs(slasName);

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_SLAs_008_VerifyPageIconsInSLAsPage(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.verifyingPageIconsInSLApage(slasName);
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_SLAs_009_ApplyFiltersInSLAsPage(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.applyingFilters(slasName);

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_SLAs_011_VerifyIconsinEditonfigWindow(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.verifyingIconsInEditWindow(slasName);
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_SLAs_013_ViewDataforFieldswithViewIconInEditConfigWindow(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate("ALERTTEMPLATE");
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage(slasName);
        slAsPage.addingSLAAction("ALERTTEMPLATE");
        slAsPage.viewDataWithFeildsForViewIcon(slasName);
        slAsPage.deleteinAlertTemplate("ALERTTEMPLATE");
    }
}
