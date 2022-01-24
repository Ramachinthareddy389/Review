package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.PresentationModesNdRulesLocators;
import com.page.locators.UserAccessRequestLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class UserAccessRequestPage extends SafeActions implements UserAccessRequestLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Email = "Zenqtest" + random.nextInt(500) + "@yopmail.com";
    String Edit_Type_Add;
    String notify = "We were unable to authenticate the supplied username and password. One or both are incorrect. Please verify them and try again, or if you continue to have problems, consult with your system administrator about having your password reset.";


    public UserAccessRequestPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Logout the application")
    public void signOut() {
        waitForPageToLoad();
        safeClick(USERICON, "User Icon", MEDIUMWAIT);
        safeClick(LOGOUT, "Logout", MEDIUMWAIT);
    }

    @Step("Requesting the Access from login page")
    public void requestingTheAccessFromLoginPage() {
        waitForSecs(10);
        safeClick(LABEL_REQUEST_ACCESS, "Request Access Label", MEDIUMWAIT);
        waitForSecs(10);
        safeTypeUsingChrod(TXTBOX_EMAIL, Email, "Entering Email Id", MEDIUMWAIT);
        waitForSecs(2);
        safeClick(LABEL_REQUEST_ACCESS, "Request Access Label", MEDIUMWAIT);
        String notify = safeGetText(NOTIFY_TEXT, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify, "Access requested.");
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    @Step("VerifyingUserRequestInUserAccessRequestPage")
    public void verifyingRequestedUserInUserAccessRequestPage() {
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USER_ACCESS_REQUESTS, "User Access Requests", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, Email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        By EMAIL = By.xpath("//span[text()='" + Email + "']");
        if (!driver.findElement(EMAIL).isDisplayed())
            Assert.fail("Access requested email is not displayed in User Access requested page");
        if (!driver.findElement(BTN_ACCEPT).isDisplayed())
            Assert.fail("Accept button is not displayed in User Access requested page");
        if (!driver.findElement(BTN_REJECT).isDisplayed())
            Assert.fail("Reject button is not displayed in User Access requested page");
        safeClick(BTN_REJECT, "Reject button in User Access Requests Page");
        safeClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }

    public void requestAccessForExistingUser(String email) {
        safeClick(LABEL_REQUEST_ACCESS, "Request Access Label", MEDIUMWAIT);
        waitForSecs(10);
        safeTypeUsingChrod(TXTBOX_EMAIL, email, "Entering Email Id", MEDIUMWAIT);
        waitForSecs(2);
        safeClick(LABEL_REQUEST_ACCESS, "Request Access Label", MEDIUMWAIT);
        String notify = safeGetText(NOTIFY_TEXT, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify, "Failed to request access.. Please contact an admin user to create an account");
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    //Users Page


    @Step("Adding Role from Uesrs Page")
    public void addingRoleFromUsersPage(String email) {
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        safeClick(ADD_USERS_ICON, "Add icon", MEDIUMWAIT);
        safeTypeUsingChrod(USERS_EMAIL_TXTBOX, email, "Email id", MEDIUMWAIT);
        safeClick(ROLES_ADD_ICON, "Add icon", MEDIUMWAIT);
    }

    public void ClickingFinIShNdCloseButtons() {
        safeClick(BTN_FINISH, "System Label", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USER_ROLES, "Auth Settings", MEDIUMWAIT);
    }

    public void addingNewUserWithoutMail(String email) {
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ADD_USERS_ICON, "Add icon", MEDIUMWAIT);
        safeTypeUsingChrod(USERS_EMAIL_TXTBOX, email, "Email id", MEDIUMWAIT);
        safeClick(TXT_SEND_WELCOME_EMAIL, "Welcome email checkbox", MEDIUMWAIT);
    }

    public void addingTechicalUser(String type, String email) {
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ADD_USERS_ICON, "Add icon", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, type, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equalsIgnoreCase(type)) {

                dbs1.get(i).click();
                break;
            }
        }
        safeTypeUsingChrod(USERS_EMAIL_TXTBOX, email, "Email id", MEDIUMWAIT);
        safeClick(TXT_SEND_WELCOME_EMAIL, "Welcome email checkbox", MEDIUMWAIT);
    }

    public void verifyingAddedUser(String type) {
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "type", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + type + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingPageIconsRolesPage(String email) {
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        waitForSecs(10);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        waitForSecs(10);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    public void applyingFiltersInUsersPage(String type,String email) {
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "type", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" +type + "')]");
        waitForSecs(10);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, email);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        }catch (Exception e){
            System.out.println("Confirm delete buttom is not displaying");
        }

    }


    public void verifyingIconsInUserEditWindow(String type) {
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, type + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClearAndType(TXTBOX_TYPE, "Technical", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equalsIgnoreCase("Technical")) {

                dbs1.get(i).click();
                break;
            }
        }

        safeClick(BTN_SAVE_USER, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        }catch (Exception e){
            System.out.println("Confirm delete buttom is not displaying");
        }
    }
    public void deletingaddedEmail(String email) {
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editingUserConfigurations(String email) {
        safeClick(BTN_FINISH, "System Label", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Auth Settings Label", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TYPE_DRPDOWN, "Business", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);

        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Business")) {

                dbs1.get(i).click();
                break;
            }
        }
        Edit_Type_Add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Edit_Type_Add);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close window", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        Assert.assertEquals(Edit_Type_Add, "Business");
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingNewUser(String email) {
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ADD_USERS_ICON, "Add icon", MEDIUMWAIT);
        safeTypeUsingChrod(USERS_EMAIL_TXTBOX, email, "Email id", MEDIUMWAIT);
    }

    public void deletingCreatedUser(String email) {
        waitForSecs(10);
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void resetPasswordFrmEditWindow(String email) {
        waitForSecs(10);
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_RESET_PASSWORD, "Reset password button", MEDIUMWAIT);
        String notify = safeGetText(NOTIFY_MESSAGE, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify, "Are you sure you want to reset zenqtest75@gmail.com's password?");
        safeClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        String notify1 = safeGetText(NOTIFY_TEXT, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify1, "An email, with a link to reset password, has been sent to zenqtest75@gmail.com.");
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close edit window", MEDIUMWAIT);
        waitForSecs(10);


    }

    public void changePasswordFrmUserProfile() {
        safeClick(ICON_USER, "User profile icon", MEDIUMWAIT);
        safeClick(BTN_SETTINGS, "Settings button", MEDIUMWAIT);
        safeClick(BTN_CHANGEPASSWRD, "Change password", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_PASSWRD, "Test@123", "Password textbox", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_CONFIRM_PASSWRD, "Test@123", "Password textbox", MEDIUMWAIT);
        safeClick(BTN_UPDATE_PASSWRD, "Change password", MEDIUMWAIT);
        safeClick(CHANGPASSWORD_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void loginFromAfterLogout(String sEmailAddresss) {
        safeType(EMAILADDRESS_FIELD, sEmailAddresss, "'Email' field in 'Login' page", MEDIUMWAIT);
        safeTypeUsingChrod(PASSWORD_FIELD, "Test@123", "Entering password", MEDIUMWAIT);
        safeClick(LOGIN_BTN, "Login button", MEDIUMWAIT);
        waitForSecs(20);
        boolean operational_Module = isElementDisplayed(LABEL_OPERATIONAL);
        Assert.assertTrue(operational_Module);
    }

    public void verifyingFunctionalityOfForgotPassword(String mail) {
        safeClick(HYPERLINK_FORGOTPASSWD, "hyerlink", MEDIUMWAIT);
        safeTypeUsingChrod(USERNAME_TXTBOX, mail, "Username", MEDIUMWAIT);
        safeClick(BTN_RESET, "reset buttoin", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyinginvalidUsernamendValidPassword(String email, String passwrd) {
        safeType(EMAILADDRESS_FIELD, email, "'Email' field in 'Login' page", MEDIUMWAIT);
        safeType(PASSWORD_FIELD, passwrd, "'Email' field in 'Login' page", MEDIUMWAIT);
        safeClick(LOGIN_BTN, "Login button", MEDIUMWAIT);
        waitForSecs(20);
        boolean b = isElementEnabled(INVALID_NOTIFY);
        System.out.println(b);
        Assert.assertTrue(b);
        String locator = "//p[text()='" + notify + "']";
        By notify_Text = By.xpath(locator);
        boolean st = isElementDisplayed(notify_Text);
        Assert.assertTrue(st);
        System.out.println(st);
    }
}
