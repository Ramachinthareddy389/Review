package com.page.module;

import com.page.locators.AlertTemplateLocators;
import com.page.locators.BusinessProcessLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlertTemplatePage extends SafeActions implements AlertTemplateLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    static int j;
    String Name_Add, textTitle, textContent, htmlTitle, htmlContent, smsTitle, smsContent, Edited_Name_Add;
    Random random = new Random();
    String dname = "BP";
    String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    String Alert = "alert" + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);

    //Constructor to define/call methods
    public AlertTemplatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAlertTemplate() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ALERT_TEMPLATES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
    }

    public void addIngAlertTemplate() {
        waitForSecs(30);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(40);
        safeClick(LABEL_TEXT_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        textTitle = driver.findElement(ADDED_TEXT_AREA).getText();
        safeClick(LABEL_TEXT_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        textContent = driver.findElement(ADDED_TEXT_CONTENT).getText();
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_HTML_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        htmlTitle = driver.findElement(ADDED_TEXT_HTML_TITLE).getText();
        safeClick(LABEL_HTML_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        htmlContent = driver.findElement(ADDED_TEXT_HTM_CONTENT).getText();
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_SMS_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        smsTitle = driver.findElement(ADDED_TEXT_SMS_TITLE).getText();
        safeClick(LABEL_SMS_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        smsContent = driver.findElement(ADDED_TEXT_SMS_CONTENT).getText();
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAlertTemplateDetails() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && textTitle.equals(driver.findElements(EDITED_TEXT_AREA).get(0).getText()) &&
                textContent.equals(driver.findElements(EDITED_TEXT_AREA).get(1).getText()) && htmlTitle.equals(driver.findElements(EDITED_TEXT_AREA).get(2).getText()) && htmlContent.equals(driver.findElements(EDITED_TEXT_AREA).get(3).getText()) && smsTitle.equals(driver.findElements(EDITED_TEXT_AREA).get(4).getText()) && smsContent.equals(driver.findElements(EDITED_TEXT_AREA).get(5).getText())) {
            System.out.println("Business process details are valid");

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void EditingAlertTemplateConfig() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + dname1);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(40);
        safeClick(LABEL_TEXT_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        textTitle = driver.findElement(ADDED_TEXT_AREA).getText();
        safeClick(LABEL_TEXT_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        textContent = driver.findElement(ADDED_TEXT_CONTENT).getText();
        waitForSecs(10);
        safeClick(LABEL_HTML_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(2).sendKeys("test");
        htmlTitle = driver.findElement(ADDED_TEXT_HTML_TITLE).getText();
        safeClick(LABEL_HTML_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(3).sendKeys("testcontent");
        htmlContent = driver.findElement(ADDED_TEXT_HTM_CONTENT).getText();
        safeClick(LABEL_SMS_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(4).sendKeys("test");
        smsTitle = driver.findElement(ADDED_TEXT_SMS_TITLE).getText();
        safeClick(LABEL_SMS_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(5).sendKeys("testcontent");
        smsContent = driver.findElement(ADDED_TEXT_SMS_CONTENT).getText();
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);

    }

    public void verifyingEditedConfiguraions() {
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && textTitle.equals(driver.findElements(EDITED_TEXT_AREA).get(0).getText()) &&
                textContent.equals(driver.findElements(EDITED_TEXT_AREA).get(1).getText()) && htmlTitle.equals(driver.findElements(EDITED_TEXT_AREA).get(2).getText()) && htmlContent.equals(driver.findElements(EDITED_TEXT_AREA).get(3).getText()) && smsTitle.equals(driver.findElements(EDITED_TEXT_AREA).get(4).getText()) && smsContent.equals(driver.findElements(EDITED_TEXT_AREA).get(5).getText())) {
            System.out.println("Business process details are valid");

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    //Alerts

    public void clickingOnAlerts() {
        waitForSecs(10);
        safeClick(LABEL_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_ALERT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
    }

    public void addingAlerts() {
        waitForSecs(30);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Alert, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(DISTRIBUTION_LIST_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(DRPDOWN_DISTRIBUTION_LIST, "DistributionList", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs = driver.findElements(DROPDOWN_LIST);
        System.out.println("Total no 0f dashboards:::====> " + dbs.size());
        for (int i = 0; i < dbs.size(); i++) {

            if (dbs.get(i).getText().contains("DistributionList")) {

                dbs.get(i).click();
                break;
            }
        }

        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(DRPDOWN_SLA, "User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_LIST);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().contains("User Click - raw - User Click SLA")) {

                dbs2.get(i).click();
                break;
            }
        }

        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void deletingAlert(){
        safeType(TEXTBOX_TYPESEARCH, Alert + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void VerifyingEmailSubject(String Subject) {
        String EmailSubject = safeGetText(EMAIL_SUBJECT, "Alert subject", MEDIUMWAIT);
        if(EmailSubject.contains(Subject))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }

        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
    }

    public void verifyingAddedAlertInInsightPage(){
        safeClick(LABEL_DAILY_INSIGHT,"Daily tal",MEDIUMWAIT);
        boolean sla= driver.findElement(By.xpath("//div[text()='User Click']")).isDisplayed();
        System.out.println(sla);
        Assert.assertTrue(sla);
        waitForSecs(30);
        safeClick(INSIGHTS_PAGE_SIDE_MENU,"Insight page",MEDIUMWAIT);
        waitForSecs(20);
        safeClick(LABEL_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_ALERT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

}
