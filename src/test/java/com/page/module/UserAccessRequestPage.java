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
    String Email = "Zenqtest"+ random.nextInt(500)+"gmail.com";
    String Edit_Type_Add;


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

    public void requestAccessForExistingUser(String email){
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
    public void addingRoleFromUsersPage(String email){
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        safeClick(ADD_USERS_ICON,"Add icon",MEDIUMWAIT);
        safeTypeUsingChrod(USERS_EMAIL_TXTBOX,email,"Email id",MEDIUMWAIT);
        safeClick(ROLES_ADD_ICON,"Add icon",MEDIUMWAIT);
    }

    public void ClickingFinIShNdCloseButtons(){
        safeClick(BTN_FINISH, "System Label", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USER_ROLES,"Auth Settings",MEDIUMWAIT);
    }

 public void deletingaddedEmail()
 {
     safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
     waitForSecs(10);
     safeType(TEXTBOX_TYPESEARCH, Email + "\n", "Alert Name into type search");
     System.out.println("entered dbtext");
     mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
     safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
     waitForSecs(9);
     safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
     waitForSecs(5);
     safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
     waitForSecs(10);
 }

 public void editingUserConfigurations() {
     safeClick(BTN_FINISH, "System Label", MEDIUMWAIT);
     safeClick(BTN_CLOSE, "Auth Settings Label", MEDIUMWAIT);
     waitForSecs(10);
     safeType(TEXTBOX_TYPESEARCH, Email + "\n", "Alert Name into type search");
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
     safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
     waitForSecs(10);
     safeClick(CLOSE_EDITWINDOW,"Close window",MEDIUMWAIT);
     safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
     safeType(TEXTBOX_TYPESEARCH, Email + "\n", "Alert Name into type search");
     System.out.println("entered dbtext");
     mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
     safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
     waitForSecs(9);
     Assert.assertEquals(Edit_Type_Add,"Business");
     waitForSecs(9);
     safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
     waitForSecs(5);
     safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
     waitForSecs(10);

 }

 public void addingNewUser(String email){
     safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
     safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
     safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
     waitForSecs(10);
     safeClick(ADD_USERS_ICON,"Add icon",MEDIUMWAIT);
     safeTypeUsingChrod(USERS_EMAIL_TXTBOX,email,"Email id",MEDIUMWAIT);
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


    public void resetPasswordFrmEditWindow(String email){
        waitForSecs(10);
        safeClick(LABEL_SYSTEM, "System Label", MEDIUMWAIT);
        safeClick(LABEL_AUTH_SETTINGS, "Auth Settings Label", MEDIUMWAIT);
        safeClick(LABEL_USERS, "Users Label", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, email + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_RESET_PASSWORD,"Reset password button",MEDIUMWAIT);
        String notify = safeGetText(NOTIFY_MESSAGE, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify, "Are you sure you want to reset zenqtest75@gmail.com's password?");
        safeClick(CONFIRM_DELETE,"Confirm button",MEDIUMWAIT);
        String notify1 = safeGetText(NOTIFY_TEXT, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify1, "An email, with a link to reset password, has been sent to zenqtest75@gmail.com.");
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW,"Close edit window",MEDIUMWAIT);
        waitForSecs(10);



    }


}
