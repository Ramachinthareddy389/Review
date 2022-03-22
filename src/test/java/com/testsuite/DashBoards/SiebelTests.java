package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.LoginPage;
import com.page.module.SiebelPage;
import com.page.module.WordPressPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SiebelTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private WordPressPage wordPressPage;
    private SiebelPage siebelPage;


    private String sModeOfExecution;
    Random random = new Random();

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashBoardData = new DashBoardData();
        wordPressPage = new WordPressPage(getDriver());
        siebelPage = new SiebelPage(getDriver());
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true)
    public void TC_UXSiebel_001_RecordingUXSessionwithBasicNavigationFlowsInSiebel() {
        siebelPage.launchTheApp();
        siebelPage.logoutFromSiebel();
    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_002_RecordingUXSessionwithAlertPopupInSiebel() {
        siebelPage.launchTheApp();
        siebelPage.alertPopupInSiebel();
        siebelPage.logoutFromSiebel();
    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_003_RecordingUXSessionwithPromptinSiebel() {
        siebelPage.launchTheApp();
        siebelPage.windowPopUpInSiebel();
        siebelPage.logoutFromSiebel();
    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_004_RecordingUXSessionByUsingAllFunctionKeysInSiebel() {
        siebelPage.recordingUXSessionByUsingAllFunctionKeysinSiebel();
        siebelPage.logoutFromSiebel();
    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_005_RecordingUXSessionBySearchingContentUsingTheSearchBoxInSiebel() {
        siebelPage.launchTheApp();
        siebelPage.searchingContentUsingSearchBoxInSiebel();
        siebelPage.logoutFromSiebel();

    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_006_RecordingUXSessionByChangingTheQueryInSiebel() {
        siebelPage.changingTheQueryInSiebel();

    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_007_RecordingUXSessionByMakingChangesInContactsandOpportunitiesInSiebel() {
        siebelPage.ChangingInContactNdOpportunitiesOnSibel();
    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_008_RecordingUXSessionByNavigatingtoaTabOfNoninjectedsitefrmSiebel() {
        siebelPage.openNoninjectedSiteinNewTab();
        siebelPage.logoutFromSiebel();

    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_009_RecordingUXSessionByNavigatingToATabOfinjectedSitefrmSiebel() {
        siebelPage.openInjectedSiteinNewTab();
        siebelPage.logoutFromSiebel();
    }
}