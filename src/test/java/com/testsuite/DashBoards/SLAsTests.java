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
    public void TC_213_AddSLAConfigforAllTypes() throws InterruptedException {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.verifyingSLAsPage();
    }
/*
    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_215_EditSLAconfigforallTypes()
    {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.editSLAsConfig();
        slAsPage.verifyingEditedSLADetails();
    }*/

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_214_AddThresholdinFactBasedSLAeditwindow() {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.addingThresholdValueInEditSLAswindow();
        slAsPage.verifyingAddedThresholdInEditWindow();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_216_AddActionsinEditSLAconfigwindow() {

        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.addingActionsInEditSLAConfigWindow();
        slAsPage.verifyingActionsInEditSLAConfigWindow();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_217_AddAlertTemplateInEditSLAConfigWindow() {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.addingAlertTemplateInEditSLAConfigWindow();
        alertTemplatePage.addIngAlertTemplate(AlertTemplate);
        slAsPage.verifyingAddedAlertTemplateInSLAEditWindow(AlertTemplate);
        alertTemplatePage.navigateToAlertTemplateWindow();
        alertTemplatePage.deletingAlert(AlertTemplate);

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_218_NavigateToKPIsPageonClickingAnyKPIUnderKPINameColumn() {
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.navigateToKPIPageFromSLAPage();
        slAsPage.clickingSLAsPage();
        slAsPage.deletingCreatedSLAs();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_219_NavigateToAlertTemplatesPageonClickingnAlertTempUnderSLASPAge(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.navigateToAlertTemplatePageFrmSLAPage();
        slAsPage.clickingSLAsPage();
        slAsPage.deletingCreatedSLAs();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_220_VerifyPageIconsInSLAsPage(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.verifyingPageIconsInSLApage();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_221_ApplyFiltersInSLAsPage(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.applyingFilters();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_223_VerifyIconsinEditonfigWindow(){
        slAsPage.clickingOnSLAs();
        slAsPage.addingSLASettingsPage();
        slAsPage.addingSLAAction();
        slAsPage.verifyingIconsInEditWindow();
    }
}
