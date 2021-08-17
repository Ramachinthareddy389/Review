package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComponentTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private ComponentPage componentPage;
    private HardwarePage hardwarePage;
    private HTTPPage httpPage;
    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        componentPage= new ComponentPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        httpPage = new HTTPPage(getDriver());
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
    public void TC_373_AddallComponentTypeconfigurations() throws InterruptedException
    {
       componentPage.clickingOnAutomation();
       componentPage.adding1stComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding2ndComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding3rdComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding4thComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding5thComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding8thComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding9thComponent();
        componentPage.verifyingAddedComponent();
        componentPage.adding10thComponent();
        componentPage.verifyingAddedComponent();


    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_383_AddCredentialsconfiguration()
    {
       componentPage.clickingOnAddCredentials();
       componentPage.addingNewCredentials();
       componentPage.verifyingAddedCredentials();

    }

    @Test(alwaysRun = true,groups = "Smoke Test" )
    public  void TC_384_EditCredentialsconfiguration()
    {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials();
        componentPage.editCredentialsConfigs();
        componentPage.verifyingEditedAddedCredentials();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_374_EditallComponentTypeconfigurations()
    {
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent();
        componentPage.verifyingEditedAllComponentTypes();
        componentPage.adding2ndComponent();
        componentPage.verifyingEditedAllComponentTypes();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_385_ChangePasswordInCredentialsEditwindow()
    {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials();
        componentPage.changePasswordInEditCredWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_393_EditDisplaySettingsConfiguration()
    {
       componentPage.clickingOnDisplaySettings();
    }

    @Test(alwaysRun = true,groups = "Smoke Test" )
    public  void TC_399_AddDistributionListwithAllDistributiontypes()
    {
      componentPage.clickingOnAddDistributionList();
      componentPage.verifyingAddedDistributionList();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_400_AddMembersinEditDistributionListwindow(){
        componentPage.clickingOnAddDistributionList();
        componentPage.addMembersInEditDistributionListwindow();
        componentPage.verifyingAddedDistributionList();
    }
}