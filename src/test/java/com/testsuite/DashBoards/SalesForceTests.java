package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.LoginPage;
import com.page.module.SalesForcePage;
import com.page.module.SiebelPage;
import com.page.module.WordPressPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SalesForceTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private WordPressPage wordPressPage;
    private SalesForcePage salesForcePage;


    private String sModeOfExecution;
    Random random = new Random();

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashBoardData = new DashBoardData();
        wordPressPage = new WordPressPage(getDriver());
        salesForcePage = new SalesForcePage(getDriver());
        getDriver().manage().deleteAllCookies();
       // getDriver().get(dashBoardData.openCartURL);
      //  (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        //loginPage.verifyLoginPage();
       // loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
      //  loginPage.clickLogInButton();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_001_RecordingaUXSessionwithBasicNavigationFlowsinSalesforceSite() throws InterruptedException {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_001");
        salesForcePage.clickingOnSalesForce();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_002_RecordingaUXSessionwithAlertPopupinSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_002");
        salesForcePage.addingAlertPopup();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_003_RecordingaUXSessionwithPromptinSalesforcesite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_003");
        salesForcePage.addingWindowPopup();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_004_RecordingaUXSessionByUsingAllFunctionKeysinSalesforceSite() {

        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_004");
        salesForcePage.clickingOnFunctionalKeys();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_011_RecordingaUXSessionbyNavigatingToaTabofnoninjectedSitefromSalesForcesite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_011");
        salesForcePage.openNoninjectedSiteinNewTab();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_012_RecordingaUXSessionBynavigatingToaTabofInjectedSiteFromSalesForceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_012");
        salesForcePage.openInjectedSiteinNewTab();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_005_RecordingaUXSessionBySearchingContentUsingTheSearchBoxinSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_005");
        salesForcePage.searchingContentUsingTheSearchBoxInSalesforce();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_006_RecordingaUXSessionByAddingaNewEventInSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_006");
        salesForcePage.addingANewEventInSalesforceSite();

    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_007_RecordingaUXSessionByAddingaNewTaskInSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_007");
        salesForcePage.addingANewTaskInSalesforceSite();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_008_RecordingaUXSessionByAddingaNewContactinSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.addingNewContactInSalesForce();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_009_RecordingaUXSessionByAddingALoggingaCallInSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_009");
        salesForcePage.addingALoggingacallInSalesforce();

    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_010_RecordingaUXSessionByAddingaFavoriteListInSalesforceSite() {

        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_010");
        salesForcePage.addingaFavoriteListInSalesforce();
    }

    @Test(alwaysRun = true)
    public void TC_UXSalesForce_013_RecordingaUXSessionByAccessingTheRecentRecordsfromSalesforceSite() {
        salesForcePage.loginIntoSalesForceApp();
        salesForcePage.searchinhTestcase("TC_UXSalesForce_013");
        salesForcePage.accessingtheRecentRecordsFromSalesforce();
    }
}
