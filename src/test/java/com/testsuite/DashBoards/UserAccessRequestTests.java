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

public class UserAccessRequestTests extends BaseSetup {
    private UserAccessRequestPage userAccessRequestPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private PresentationModesNdRulesNdRulesPages presentationModesNdRulesPages;
    private EmailPage emailPage;

    private String sModeOfExecution;
    Random random = new Random();
    String tabularPortletName = "Tabular Portlet - " + random.nextInt(1000);
    String nTabularPortletName = "N Tabular Portlet - " + random.nextInt(1000);
    String dname = "Pivots";
    String dname1 = dname + random.nextInt(1500);
    String flowPortletName = "Flow Portlet - " + random.nextInt(1000);
    String mapPortletName = "Map Portlet - " + random.nextInt(1000);
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);
    String counterPortletName = "Counter Portlet - " + random.nextInt(1000);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        userAccessRequestPage = new UserAccessRequestPage(getDriver());
        presentationModesNdRulesPages = new PresentationModesNdRulesNdRulesPages(getDriver());
        emailPage = new EmailPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


/*    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_452_VerifyUserAccessRequestsCreatedFromloginPagefornewusers() throws InterruptedException
    {
        userAccessRequestPage.signOut();
        userAccessRequestPage.requestingTheAccessFromLoginPage();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.verifyingRequestedUserInUserAccessRequestPage();
    }*/

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_467_AddNewRolesInAddNDEditUserwindow()
    {
         userAccessRequestPage.addingRoleFromUsersPage("zenqtest75@gmail.com");
         presentationModesNdRulesPages.addingNewUserRoles();
         userAccessRequestPage.ClickingFinIShNdCloseButtons();
         presentationModesNdRulesPages.verifyingAddedUserRoles();
         userAccessRequestPage.deletingaddedEmail();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_469_EditUserConfiguration(){
        userAccessRequestPage.addingRoleFromUsersPage("zenqtest75@gmail.com");
        presentationModesNdRulesPages.addingNewUserRoles();
        userAccessRequestPage.editingUserConfigurations();
    }



/*    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_451_VerifyUseraccessRequestLoginpageforExistingusers(){
        userAccessRequestPage.signOut();
        userAccessRequestPage.requestAccessForExistingUser("rama.chinthareddy@zenq.com");
    }*/


    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_464_AddNewUserwithWelcomeEmail(){
        userAccessRequestPage.addingNewUser("zenqtest75@gmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.gmail);
        emailPage.navigatingToEmail("zenqtest75@gmail.com","Germain APM - Welcome");
        emailPage.deletingemailsfromgmail();
        getDriver().get(dashBoardData.openCartURL);
        userAccessRequestPage.deletingCreatedUser("zenqtest75@gmail.com");


    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_466_VerifyUserSetupforNewUser(){
        userAccessRequestPage.addingNewUser("zenqtest75@gmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.gmail);
        emailPage.navigatingToEmail("zenqtest75@gmail.com","Germain APM - Welcome");
        emailPage.clickingOnSetPasswordHyperlinkFrmWelcomepage();
        userAccessRequestPage.signOut();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.deletingCreatedUser("zenqtest75@gmail.com");
        emailPage.clickingOnEmptyInbox();
        emailPage.deletingemailsfromgmail();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_468_ResetPasswordinEditUserwindow()
    {
        userAccessRequestPage.addingNewUser("zenqtest75@gmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.gmail);
        emailPage.navigatingToEmail("zenqtest75@gmail.com","Germain APM - Welcome");
        emailPage.clickingOnSetPasswordHyperlinkFrmWelcomepage();
        userAccessRequestPage.signOut();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.resetPasswordFrmEditWindow("zenqtest75@gmail.com");
        userAccessRequestPage.signOut();
        emailPage.closingWindow();
        emailPage.clickingOnEmptyInbox();
        emailPage.verifyingResetPasswordEmail("Germain APM Password Reset");
        emailPage.clickingOnSetPasswordHyperlinkFrmWelcomepage();
        userAccessRequestPage.signOut();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.deletingCreatedUser("zenqtest75@gmail.com");
        emailPage.clickingOnEmptyInbox();
        emailPage.deletingemailsfromgmail();
    }



}
