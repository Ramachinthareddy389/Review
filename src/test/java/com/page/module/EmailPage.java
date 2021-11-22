package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.EmailLocators;
import com.page.locators.UserAccessRequestLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class EmailPage extends SafeActions implements EmailLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();

    public EmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigatingToEmail(String Email, String title) {
        safeTypeUsingChrod(TXTBOX_EMAIl, Email, "Entering yop mail", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Forward button", MEDIUMWAIT);
        waitForSecs(10);
       // safeTypeUsingChrod(TXTBOX_PASSWORD, "Zenq@123", "Entering yop mail", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Forward button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(BTN_InBOX, "Inbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> a = driver.findElements(EMAIL_SUBJECT);
        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getText());
            if (a.get(i).getText().contains(title)) {
                waitForSecs(10);
                a.get(i).click();
                break;
            } else {
                Assert.fail("Title is not displaying as expected.");
            }
        }
        waitForSecs(10);

    }

    public void verifyingResetPasswordEmail(String title) {
        List<WebElement> a = driver.findElements(EMAIL_SUBJECT);
        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getText());
            if (a.get(i).getText().contains(title)) {
                waitForSecs(10);
                a.get(i).click();
                break;
            } else {
                Assert.fail("Title is not displaying as expected.");
            }
        }
        waitForSecs(10);

    }

    public void clickingOnSetPasswordHyperlinkFrmWelcomepage() {
     selectFrame(2);
        safeClick(HYPELINK_SET_PASSWRD, "Clicking on set password hyperlink from welcome email", MEDIUMWAIT);
        switchToWindow(1);
        safeTypeUsingChrod(TXTBOX_PASSWRD, "Zen@1234", "Entering password", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_CONFIRM_PASSWRD, "Zen@1234", "Entering password", MEDIUMWAIT);
        safeClick(BTN_UPDATE_PASSWRD, "Clicking on update password button", MEDIUMWAIT);
        String notify = safeGetText(NOTIFY_TEXT, "access request notification", MEDIUMWAIT);
        Assert.assertEquals(notify, "Your password has been updated.");
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeTypeUsingChrod(PASSWORD_FIELD, "Zen@1234", "Entering password", MEDIUMWAIT);
        safeClick(LOGIN_BTN, "Login button", MEDIUMWAIT);
        waitForSecs(20);
        String url = getCurrentURL();
        System.out.println(url);
        String expectedURL = "http://qa.germainapm.com/germainapm/workspace/app/#Explore()";
        Assert.assertEquals(url, expectedURL);
        boolean welText = isElementDisplayed(welcomeText);
        if (welText == true) {
            safeClick(BTN_QUITTOUR, "Close button in welcome popup", MEDIUMWAIT);
        }
        boolean operational_Module = isElementDisplayed(LABEL_OPERATIONAL);
        Assert.assertTrue(operational_Module);
    }


    public void verifyingDataforSqlTests(String name) {
        boolean label = isElementDisplayed(HEADER_IN_MAIL);
        Assert.assertTrue(label);
        waitForSecs(20);
        String attach = safeGetText(EMAIl_ATTACH_LABEL, "Attachment", MEDIUMWAIT);
        System.out.println(attach);
        String expectedText = name + "_0" + ".csv";
        Assert.assertEquals(attach, expectedText);
        waitForSecs(5);
        safeClick(BTN_InBOX, "click on back button", MEDIUMWAIT);
        safeCheck(BTN_SELECT, "Selecting all", MEDIUMWAIT);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        safeCheck(LABEL_MORE, "Selecting all", MEDIUMWAIT);
        safeClick(BTN_TRASH, "Delete button", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(BTN_SELECT).get(1).click();
        safeClick(BTN_DELETE_FOREVER, "Delete button", MEDIUMWAIT);
    }


    public void actionPerformingInMail() {
        driver.switchTo().defaultContent();
        selectFrame(2);
        safeClick(HYPERLINK_ACCEPT_REQUEST, "accept hyper link", MEDIUMWAIT);
        switchToWindow(1);
        waitForSecs(10);
        String url = getCurrentURL();
        System.out.println(url);
        String expectedURL = "http://qa.germainapm.com/germainapm/workspace/app/#logon";
        Assert.assertEquals(url, expectedURL);
        driver.close();
        switchToWindow(0);
        selectFrame(2);
        safeClick(HYPERLINK_REJECT_REQUEST, "Reject hyper link", MEDIUMWAIT);
        switchToWindow(1);
        String Notify = safeGetText(NOTIGY_REJECTED, "Notification Text", MEDIUMWAIT);
        String expectedNotify = "Request Rejected.";
        Assert.assertEquals(Notify, expectedNotify);
    }

    public void closingWindow(){
        driver.close();
    }
    public void clickingOnEmptyInbox() {
        switchToWindow(0);
        safeClick(BTN_InBOX, "Inbox button", MEDIUMWAIT);
        waitForSecs(20);
       /* int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size);
        selectFrame(1);*/
    }

    public void clickingHyperlinksInAlertEmails() {
        safeClick(HYPERLINK_MONITORING_DATALINK, "Monitoring hyper link", MEDIUMWAIT);
        switchToWindow(1);
        waitForSecs(10);
        String url = getCurrentURL();
        System.out.println(url);
        String expectedURL = "http://qa.germainapm.com/germainapm/workspace/app/#TimeRange";
        if (!url.contains(expectedURL)) {
            Assert.assertFalse(false, "Not Navigated to germain apm page");
        }
        String RCATitle = safeGetText(TITLE_RCA_PAGE, "RCA page tile", MEDIUMWAIT);
        String expectedRCA = "RCA for User Click";
        Assert.assertEquals(RCATitle, expectedRCA);
        driver.close();
        switchToWindow(0);
        safeClick(HYPERLINK_ALERT_DATALINK, "Alert hyper link", MEDIUMWAIT);
        switchToWindow(1);
        String AlertTitle = safeGetText(TITLE_RCA_PAGE, "RCA page tile", MEDIUMWAIT);
        String expectedAlert = "RCA for Alert";
        Assert.assertEquals(AlertTitle, expectedAlert);
        driver.close();
        waitForSecs(2);
        switchToWindow(0);
        safeClick(HYPERLINK_TICKET_LINK, "Alert hyper link", MEDIUMWAIT);
        switchToWindow(1);
        String TicketTitle = safeGetText(TITLE_NEW_TICKET, "RCA page tile", MEDIUMWAIT);
        waitForSecs(10);
        String expectedTicket = "New Ticket";
        Assert.assertEquals(TicketTitle, expectedTicket);
        driver.close();
        waitForSecs(2);
        switchToWindow(0);
        safeClick(HYPERLINK_KPI_LINK, "Alert hyper link", MEDIUMWAIT);
        switchToWindow(1);
        waitForSecs(10);
        String KPITitle = safeGetText(TITLE_KPI, "RCA page tile", MEDIUMWAIT);
        String expectedKPI = "Key Performance Indicators";
        Assert.assertEquals(KPITitle, expectedKPI);
        driver.close();
        waitForSecs(2);
        switchToWindow(0);

    }

    public void verifyingDataonRunschedule(String Email, String title) {
        safeTypeUsingChrod(TXTBOX_EMAIl, Email, "Entering yop mail", MEDIUMWAIT);
        safeClick(BTN_FORWARD, "Forward button", MEDIUMWAIT);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size);
        selectFrame(0);
        String day = driver.findElement(By.xpath("//div[@class='mday']")).getText();
        Assert.assertEquals(day, "today");
        String subject = safeGetText(LABEL_RECEIVED_EMAIl, "text", MEDIUMWAIT);
        System.out.println(subject);
        if (!subject.equals(title)) {
            Assert.assertTrue(false);
            safeClick(LABEL_RECEIVED_EMAIl, "clicked on Label", MEDIUMWAIT);
        }
        driver.switchTo().defaultContent();
        selectFrame(2);
    }

    public void deletingemailsfromgmail() {
        waitForSecs(5);
        safeClick(BTN_InBOX, "click on back button", MEDIUMWAIT);
        safeCheck(BTN_SELECT, "Selecting all", MEDIUMWAIT);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        safeCheck(LABEL_MORE, "Selecting all", MEDIUMWAIT);
        safeClick(BTN_TRASH, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElements(BTN_SELECT).get(1).click();
        safeClick(BTN_DELETE_FOREVER, "Delete button", MEDIUMWAIT);
    }

    public void deletingEmails(String email) {
        switchToWindow(0);
        waitForSecs(30);
        safeClick(LABEL_MENU_BUTTON,"Menu button",MEDIUMWAIT);
        safeClick(LABEL_EMPTY_TEXTBOX, "Empty textbox", MEDIUMWAIT);
        acceptAlert();



    }
    public void navigatingToYopMail(String Email,String title){
        safeTypeUsingChrod(TXTBOX_YOPMAIL, Email, "Entering yop mail", MEDIUMWAIT);
        safeClick(BTN_FORWARD, "Forward button", MEDIUMWAIT);
        waitForSecs(10);
        refresh();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size);
        selectFrame(0);
        String day= driver.findElement(By.xpath("//div[@class='mday']")).getText();
        Assert.assertEquals(day,"today");
        String subject = safeGetText(LABEL_RECEIVED_EMAIl, "text", MEDIUMWAIT);
        System.out.println(subject);
        if (!subject.equals(title)) {
            Assert.assertTrue(false);
            safeClick(LABEL_RECEIVED_EMAIl, "clicked on Label", MEDIUMWAIT);
        }
        waitForSecs(20);
        driver.switchTo().defaultContent();
    }

}
