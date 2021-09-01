package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.PresentationModesNdRulesLocators;
import com.page.locators.UserAccessRequestLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Random;

public class UserAccessRequestPage extends SafeActions implements UserAccessRequestLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Email = "accesauto"+ random.nextInt(500)+"@yopmail.com";
    String Rules = "Rules" + "-" + random.nextInt(500);
    String Edit_Rule = "EditRule" + "-" + random.nextInt(500);
    String Edit_Presentation = "EditP_Presentation" + "-" + random.nextInt(500);
    String TimeRanges = "TimeRanges" + "-" + random.nextInt(500);
    String Edit_TimeRange = "EditTimeRange" + "-" + random.nextInt(500);
    String ROLE = "role" + "-" + random.nextInt(500);
    String Name_Add, Duration_Add, Dashboard_add, Timerange_add, Edited_Name_Add, Content_Add;
    String Minute_Add, Hour_Add, Day_Add, Year_Add, Month_add, End_Minute_Add, End_Hour_Add, End_Day_Add, End_Year_Add, End_Month_add, Start_Value_Add, Start_Unit_add, End_Value_Add, End_Unit_add;


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
}
