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

public class ComponentTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private ComponentPage componentPage;
    private HardwarePage hardwarePage;
    private HTTPPage httpPage;
    private String sModeOfExecution;
    Random random = new Random();
    String DistriList = "DistriList" + "-" + random.nextInt(500);

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
    public void TC_CompTypes_001_AddallComponentTypeconfigurations() throws InterruptedException
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

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public  void TC_CompTypes_002_EditallComponentTypeconfigurations()
    {
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent();
        componentPage.verifyingEditedAllComponentTypes();
        componentPage.adding2ndComponent();
        componentPage.verifyingEditedAllComponentTypes();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_Creds_001_AddCredentialsconfiguration()
    {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials();
        componentPage.verifyingAddedCredentials();

    }

    @Test(alwaysRun = true,groups = "Smoke Test" )
    public  void TC_Creds_002_EditCredentialsconfiguration()
    {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials();
        componentPage.editCredentialsConfigs();
        componentPage.verifyingEditedAddedCredentials();
    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_Creds_003_ChangePasswordInCredentialsEditwindow()
    {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials();
        componentPage.changePasswordInEditCredWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_DisplaySettings_001_EditDisplaySettingsConfiguration()
    {
       componentPage.clickingOnDisplaySettings();
    }

    @Test(alwaysRun = true,groups = "Smoke Test" )
    public  void TC_DLs_001_AddDistributionListwithAllDistributiontypes()
    {
      componentPage.clickingOnAddDistributionList(DistriList,"rama.chinthareddy@zenq.com");
      componentPage.verifyingAddedDistributionList(DistriList,"rama.chinthareddy@zenq.com");
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_DLs_002_AddMembersinEditDistributionListwindow(){
        componentPage.clickingOnAddDistributionList(DistriList,"rama.chinthareddy@zenq.com");
        componentPage.addMembersInEditDistributionListwindow(DistriList);
        componentPage.verifyingAddedDistributionList(DistriList,"rama.chinthareddy@zenq.com");
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_DLs_003_EditDistributionListconfiguration()
    {
        componentPage.clickingOnAddDistributionList("rama.chinthareddy@zenq.com",DistriList);
        componentPage.verifyingEditDistributionListConfig(DistriList);

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Auto_001_AddAutoConfig(){
         componentPage.addingAutoConfig();
         componentPage.verifyingAddedAutoConfig();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Auto_002_EditAutoConfig(){
        componentPage.addingAutoConfig();
        componentPage.editAutoConfig();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Auto_003_RepplyToServers(){
        componentPage.addingAutoConfig();
        componentPage.repplyToServers();
    }

    @Test(alwaysRun = true,groups ="Smoke Test")
    public void TC_Auto_004_AddProfileBindingsInEditAutoConfigwindow(){
        componentPage.addingAutoConfig();
        componentPage.addingProfileBinding();
        componentPage.verifyingAddedProfileBinding();
    }
}
