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
      //  getDriver().get(dashBoardData.openCartURL);
     //   (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
       // loginPage.verifyLoginPage();
        //loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
       // loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true)
    public void TC_UXSiebel_001_RecordingUXSessionwithBasicNavigationFlowsInSiebel() {
        siebelPage.launchTheApp();
        siebelPage.addingTestcaseUsingSearchFun("TCUXSiebel001");
        siebelPage.logoutFromSiebel();
    }

/*    @Test(alwaysRun = true)
    public void TC_UXSiebel_002_RecordingUXSessionwithAlertPopupInSiebel() {
        siebelPage.launchTheApp();
        siebelPage.alertPopupInSiebel();
         siebelPage.addingTestcaseUsingSearchFun("TCUXSiebel002");
        siebelPage.logoutFromSiebel();
    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_003_RecordingUXSessionwithPromptinSiebel() {
        siebelPage.launchTheApp();
        siebelPage.windowPopUpInSiebel();
        siebelPage.addingTestcaseUsingSearchFun("TCUXSiebel003");
        siebelPage.logoutFromSiebel();
    }*/

 /*   @Test(alwaysRun = true)
    public void TC_UXSiebel_004_RecordingUXSessionByUsingAllFunctionKeysInSiebel() {


        siebelPage.recordingUXSessionByUsingAllFunctionKeysinSiebel("TCUXSiebel004");
        siebelPage.addingTestcaseUsingSearchFun("TCUXSiebel004");
        siebelPage.logoutFromSiebel();
    }*/

    @Test(alwaysRun = true)
    public void TC_UXSiebel_005_RecordingUXSessionBySearchingContentUsingTheSearchBoxInSiebel()
    {
        siebelPage.searchingContentUsingSearchBoxInSiebel("TCUXSiebel005");
        siebelPage.logoutFromSiebel();

    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_006_RecordingUXSessionByChangingTheQueryInSiebel()
    {
        siebelPage.changingTheQueryInSiebel("TCUXSiebel006");


    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_007_RecordingUXSessionByMakingChangesInContactsandOpportunitiesInSiebel() {
        siebelPage.ChangingInContactNdOpportunitiesOnSibel("TCUXSiebel007");

    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_008_RecordingUXSessionByNavigatingtoaTabOfNoninjectedsitefrmSiebel() {
        siebelPage.openNoninjectedSiteinNewTab("TCUXSiebel008");
        siebelPage.addingTestcaseUsingSearchFun("TCUXSiebel008");
        siebelPage.logoutFromSiebel();

    }

    @Test(alwaysRun = true)
    public void TC_UXSiebel_009_RecordingUXSessionByNavigatingToATabOfinjectedSitefrmSiebel() {
        siebelPage.openInjectedSiteinNewTab("TCUXSiebel009");
        siebelPage.addingTestcaseUsingSearchFun("TCUXSiebel009");
        siebelPage.logoutFromSiebel();
    }
}
