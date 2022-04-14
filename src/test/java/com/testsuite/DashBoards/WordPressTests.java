package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class WordPressTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private WordPressPage wordPressPage;


    private String sModeOfExecution;
    Random random = new Random();

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        dashBoardData = new DashBoardData();
        wordPressPage = new WordPressPage(getDriver());
        getDriver().manage().deleteAllCookies();
        //getDriver().get(dashBoardData.openCartURL);
      //  (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        //loginPage.verifyLoginPage();
      //  loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        //loginPage.clickLogInButton();
    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_001_RecordingUXSessionwithBasicNavigationFlowsInWP() {
        wordPressPage.LoginToWordPressSite();
        wordPressPage.basicWorkFlow();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress001");

    }

/*    @Test(alwaysRun = true)
    public void TC_UXWordPress_002_RecordingUXSessionwithAlertPopupinWP() {
        wordPressPage.LoginToWordPressSite();
        wordPressPage.alertPopupInWordPress();
                wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress002");
    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_003_RecordingUXSessionwithPromptinWP() {
        wordPressPage.LoginToWordPressSite();
        wordPressPage.windowPopUpinWordPress();
                wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress003");
    }*/

/*    @Test(alwaysRun = true)
    public void TC_UXWordPress_004_RecordingUXSessionbyUsingAllFunctionKeysinWP() {
        wordPressPage.LoginToWordPressSite();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress004");
        wordPressPage.clickingOnFunctionalKeys();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress004");
    }*/

    @Test(alwaysRun = true)
    public void TC_UXWordPress_005_RecordingUXSessionbySearchingContentsingtheSearchboxinWP() {
        wordPressPage.searchingTheApp();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress005");
    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_006_RecordingUXSessionBySubmittingForminContactPageinWP() {
        wordPressPage.ClickingOnContacts();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress006");
    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_007_RecordingUXSessionByClickingonDifferentLinksinContactUsinWP() {
        wordPressPage.clickingOnDiffLinksInContactUs("TCUXWordPress007");

    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_008_RecordingUXSessionByDownloadingEverestForumPlugininWP() throws IOException {
        wordPressPage.downloadingEverestForumPluginInWP();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress008");
    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_009_RecordingUXSessionByNavigatingToaTabOfNoninjectedSiteFromWP() {
        wordPressPage.LoginToWordPressSite();
        wordPressPage.openNoninjectedSiteinNewTab();
        wordPressPage.basicWorkFlow();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress009");
    }

    @Test(alwaysRun = true)
    public void TC_UXWordPress_010_RecordingUXSessionbyNavigatingtoTabOfinjectedSiteFromWP(){
        wordPressPage.LoginToWordPressSite();
        wordPressPage.openInjectedSiteinNewTab();
        wordPressPage.basicWorkFlow();
        wordPressPage.addingTestcaseFrmSearchbtn("TCUXWordPress010");
    }

}
