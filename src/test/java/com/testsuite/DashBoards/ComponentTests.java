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
    private SQLPage sqlPage;
    private DBInstancesPage dbInstancesPage;
    private String sModeOfExecution;
    Random random = new Random();
    String DistriList = "DistriList" + "-" + random.nextInt(500);
    String SQL = "Sqltest" + random.nextInt(1500);
    String dbinstance = "test" + random.nextInt(500);
    String Cred = "Cred" + "-" + random.nextInt(500);
    String Querys = "Querys" + " - " + random.nextInt(500);
    String Component = "Component" + "-" + random.nextInt(500);
    String AutoConfig = "AutoConfig" + "-" + random.nextInt(500);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        componentPage = new ComponentPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        httpPage = new HTTPPage(getDriver());
        dbInstancesPage = new DBInstancesPage(getDriver());
        sqlPage = new SQLPage(getDriver());
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
    public void TC_CompTypes_001_AddallComponentTypeconfigurations() throws InterruptedException {
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding2ndComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding3rdComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding4thComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding5thComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding8thComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding9thComponent(Component);
        componentPage.verifyingAddedComponent(Component);
        componentPage.adding10thComponent(Component);
        componentPage.verifyingAddedComponent(Component);


    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_CompTypes_002_EditallComponentTypeconfigurations() {
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent(Component);
        componentPage.verifyingEditedAllComponentTypes(Component);
        componentPage.adding2ndComponent(Component);
        componentPage.verifyingEditedAllComponentTypes(Component);
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_CompTypes_005_VerifyPageIcons() {
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent(Component);
        componentPage.navigatingToComponentPage();
        componentPage.verifyingPageIcons(Component);
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_CompTypes_006_ApplyFilters() {
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent(Component);
        componentPage.navigatingToComponentPage();
        componentPage.applyingFilters(Component);
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_CompTypes_008_VerifyIconsinEditconfigWindow(){
        componentPage.clickingOnAutomation();
        componentPage.adding1stComponent(Component);
        componentPage.navigatingToComponentPage();
        componentPage.verifyingIconsInEditWindow(Component);
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_CompTypes_010_ViewDataforFieldsWithViewIconinEditConfigWindows() {
        componentPage.clickingOnAutomation();
        componentPage.adding2ndComponent(Component);
        componentPage.ViewDataforFieldswithViewIconinEditconfigWindows(Component);
    }



    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Creds_001_AddCredentialsconfiguration() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        componentPage.verifyingAddedCredentials(Cred);

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Creds_002_EditCredentialsconfiguration() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        componentPage.editCredentialsConfigs(Cred);
        componentPage.verifyingEditedAddedCredentials();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Creds_003_ChangePasswordInCredentialsEditwindow() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        componentPage.changePasswordInEditCredWindow(Cred);
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Creds_004_NavigateToReferenceEditWindowFrmCredentialsEditWindow() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        dbInstancesPage.clickingOnDbInstances();
        dbInstancesPage.addingNewDbinstances(dbinstance);
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL, "DistributionList", "SELECT NAME, TIMESTAMP, USER_NAME, PATH FROM UX_SESSION WHERE TIMESTAMP > ? AND TIMESTAMP < ?", "ALERTTEMPLATE", dbinstance, Cred, Querys, "Today");
        componentPage.clickingOnAddCredentials();
        componentPage.navigateToReferenceWindowFromSoftwareEditWindow(Cred, Querys);
    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Cred_005_VerifyPageIconsonCredWindow() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        componentPage.navigateToCredentialsWindow();
        componentPage.verifyingPageIcons(Cred);

    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_Cred_006_ApplyFiltersinCredWindow() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        componentPage.applyingFilters(Cred);
    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void Tc_Cred_008_VerifyiconsinCredEditconfigwindow() {
        componentPage.clickingOnAddCredentials();
        componentPage.addingNewCredentials(Cred);
        componentPage.verifyingIconsInEditWindow(Cred);
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DisplaySettings_001_EditDisplaySettingsConfiguration() {

        componentPage.clickingOnDisplaySettings();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DLs_001_AddDistributionListwithAllDistributiontypes()
    {
        componentPage.clickingOnAddDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        componentPage.verifyingAddedDistributionList(DistriList, "rama.chinthareddy@zenq.com");
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DLs_002_AddMembersinEditDistributionListwindow()
    {
        componentPage.clickingOnAddDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        componentPage.addMembersInEditDistributionListwindow(DistriList);
        componentPage.verifyingAddedDistributionList(DistriList, "rama.chinthareddy@zenq.com");
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_DLs_003_EditDistributionListconfiguration()
    {
        componentPage.clickingOnAddDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        componentPage.verifyingEditDistributionListConfig(DistriList);

    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_DLs_004_VerifyPageIconsInDistributionList()
    {
        componentPage.clickingOnAddDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        componentPage.verifyingPageIcons(DistriList);
    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_DLs_005_ApplyFiltersInDistributionList() {
        componentPage.clickingOnAddDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        componentPage.applyingFilters(DistriList);
    }

    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_DLs_007_VerifyIconsinDistributionEditConfigWindow() {
        componentPage.clickingOnAddDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        componentPage.verifyingIconsInEditWindow(DistriList);
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Auto_001_AddAutoConfig() {
        componentPage.addingAutoConfig(AutoConfig);
        componentPage.verifyingAddedAutoConfig(AutoConfig);
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Auto_002_EditAutoConfig() {
        componentPage.addingAutoConfig(AutoConfig);
        componentPage.editAutoConfig(AutoConfig);
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Auto_004_RepplyToServers() {
        componentPage.addingAutoConfig(AutoConfig);
        componentPage.repplyToServers(AutoConfig);
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Auto_003_AddProfileBindingsInEditAutoConfigwindow() {
        componentPage.addingAutoConfig(AutoConfig);
        componentPage.addingProfileBinding(AutoConfig);
        componentPage.verifyingAddedProfileBinding();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_AutoConfig_005_VerifyPageIconsInAutoPage(){
        componentPage.addingAutoConfig(AutoConfig);
        componentPage.clickingOnAutoConfig();
        componentPage.verifyingPageIcons(AutoConfig);

    }


}
