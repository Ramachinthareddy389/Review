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
    private DashboardOverviewPage dashboardOverviewPage;
    private AlertTemplatePage alertTemplatePage;
    private LoginPage loginPage;
    private PresentationModesNdRulesNdRulesPages presentationModesNdRulesPages;
    private EmailPage emailPage;

    private String sModeOfExecution;
    Random random = new Random();

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        userAccessRequestPage = new UserAccessRequestPage(getDriver());
        presentationModesNdRulesPages = new PresentationModesNdRulesNdRulesPages(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        alertTemplatePage = new AlertTemplatePage(getDriver());
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


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_UserAccessReq_002_VerifyUserAccessRequestsCreatedFromLoginPageforNewusers() throws InterruptedException {
        userAccessRequestPage.signOut();
        userAccessRequestPage.requestingTheAccessFromLoginPage();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.verifyingRequestedUserInUserAccessRequestPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Users_004_AddNewRolesInAddNDEditUserwindow() {
        userAccessRequestPage.addingRoleFromUsersPage("zenqtest75@yopmail.com");
        presentationModesNdRulesPages.addingNewUserRoles();
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        presentationModesNdRulesPages.verifyingAddedUserRoles();
        userAccessRequestPage.deletingaddedEmail("zenqtest75@yopmail.com");

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Users_006_EditUserConfiguration() {
        userAccessRequestPage.addingRoleFromUsersPage("zenqtest79@yopmail.com");
        presentationModesNdRulesPages.addingNewUserRoles();
        userAccessRequestPage.editingUserConfigurations("zenqtest79@yopmail.com");
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_UserAccessReq_001_VerifyUseraccessRequestLoginpageforExistingusers() {
        userAccessRequestPage.signOut();
        userAccessRequestPage.requestAccessForExistingUser("rama.chinthareddy@zenq.com");
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Users_001_AddNewUserwithWelcomeEmail()
    {
        userAccessRequestPage.addingNewUser("test123@yopmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.yopmail);
        // emailPage.navigatingToEmail("test123@yopmail.com","Germain APM - Welcome");
        emailPage.navigatingToYopMail("test123@yopmail.com", "Germain APM - Welcome");
        getDriver().get(dashBoardData.openCartURL);
        userAccessRequestPage.deletingCreatedUser("test123@yopmail.com");


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Users_003_VerifyUserSetupforNewUser()
    {
        userAccessRequestPage.addingNewUser("zenqtest75@gmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.gmail);
        emailPage.navigatingToEmail("zenqtest75@gmail.com", "Germain APM - Welcome");
        emailPage.clickingOnSetPasswordHyperlinkFrmWelcomepage();
        userAccessRequestPage.signOut();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.deletingCreatedUser("zenqtest75@gmail.com");
        emailPage.clickingOnEmptyInbox();
        emailPage.deletingemailsfromgmail();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Users_005_ResetPasswordinEditUserwindow() {
        userAccessRequestPage.addingNewUser("zenqtest75@gmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.gmail);
        emailPage.navigatingToEmail("zenqtest75@gmail.com", "Germain APM - Welcome");
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

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_UserAccessReq_003_VerifyUserAccessRequestsForTemporaryUsers() throws InterruptedException {
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.verifySharingDashboardWithNewUser();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("testzenq@yopmail.com", "germain APM - shared this dashboard with you");
        alertTemplatePage.deletingEmails();
    }


    @Test(alwaysRun = true)
    public void TC_Login_006_UpdatePasswordfromProfilewithCorrectrequirements(){
        userAccessRequestPage.addingNewUser("zenqtest003@yopmail.com");
        userAccessRequestPage.ClickingFinIShNdCloseButtons();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zenqtest003@yopmail.com", "Germain APM - Welcome");
        emailPage.clickingOnSetPasswordHyperlinkFrmWelcomepage();
        userAccessRequestPage.changePasswordFrmUserProfile();
        userAccessRequestPage.signOut();
        loginPage.verifyLoginPage();
        userAccessRequestPage.loginFromAfterLogout("zenqtest003@yopmail.com");
        userAccessRequestPage.signOut();
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
        userAccessRequestPage.deletingCreatedUser("zenqtest003@yopmail.com");
        userAccessRequestPage.signOut();
        //getDriver().get(dashBoardData.yopmail);
        emailPage.deletingEmails("zenqtest003@yopmail.com");


    }

    @Test(alwaysRun = true)
    public void TC_Login_008_ResetpasswordusingForgotPasswordfield(){
        userAccessRequestPage.signOut();
        userAccessRequestPage.verifyingFunctionalityOfForgotPassword("test1zenq@yopmail.com");
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("test1zenq@yopmail.com", "Germain APM Password Reset");
        emailPage.clickingOnSetPasswordHyperlinkFrmWelcomepage();
        getDriver().get(dashBoardData.yopmail);
        emailPage.deletingemailsfromgmail();
    }

    @Test(alwaysRun = true)
    public void TC_Login_002_LoginwithinvalidUsernamendValidPassword()
    {
        userAccessRequestPage.signOut();
        userAccessRequestPage.verifyinginvalidUsernamendValidPassword("test12@yopmail.com","Test@123");

    }

    @Test(alwaysRun = true)
    public void TC_Login_003_LoginwithvalidUsernamendInvalidPassword() {
        {
            userAccessRequestPage.signOut();
            userAccessRequestPage.verifyinginvalidUsernamendValidPassword("test123@yopmail.com", "Test@12");
        }
    }

    @Test(alwaysRun = true)
    public void TC_Login_004_LoginwithInvalidUsernamendInvalidPassword(){
        userAccessRequestPage.signOut();
        userAccessRequestPage.verifyinginvalidUsernamendValidPassword("test12@yopmail.com", "Test@12");
    }

    @Test(alwaysRun = true)
    public void TC_Login_005_LogoutApplication(){
        userAccessRequestPage.signOut();
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
    }
}