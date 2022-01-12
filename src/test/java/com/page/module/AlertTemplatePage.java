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
    //String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    //String Alert = "alert" + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);
    String NotifyText = "Unable to delete configuration entry while it is referenced by other objects.";

    //Constructor to define/call methods
    public AlertTemplatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAlertTemplate() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ALERT_TEMPLATES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);

    }

    public void addButtonInAlertTemplatePage() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(30);
    }

    public void addIngAlertTemplate(String dname1) {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_TEXT_TITLE, "Text title label", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        textTitle = driver.findElement(ADDED_TEXT_AREA).getText();
        waitForSecs(10);
        safeClick(LABEL_TEXT_CONTENT, "Text Content", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        textContent = driver.findElement(ADDED_TEXT_CONTENT).getText();
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_HTML_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        htmlTitle = driver.findElement(ADDED_TEXT_HTML_TITLE).getText();
        waitForSecs(10);
        safeClick(LABEL_HTML_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        htmlContent = driver.findElement(ADDED_TEXT_HTM_CONTENT).getText();
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_SMS_TITLE, "Text title label", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(0).sendKeys("test");
        smsTitle = driver.findElement(ADDED_TEXT_SMS_TITLE).getText();
        waitForSecs(10);
        safeClick(LABEL_SMS_CONTENT, "Text Content", MEDIUMWAIT);
        driver.findElements(TXTBOX_USERNAME_QUERY).get(1).sendKeys("testcontent");
        smsContent = driver.findElement(ADDED_TEXT_SMS_CONTENT).getText();
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAlertTemplateDetails(String dname1) {
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


    public void EditingAlertTemplateConfig(String dname1) {
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

    public void verifyingEditedConfiguraions(String dname1) {
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

    public void verifyingPageIcons(String AlertTemplate) {
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + AlertTemplate + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
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
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = AlertTemplate + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(25);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);

    }

    public void verifyingEditIconFunctionalityInAlerts() {
        waitForSecs(10);
        safeClick(BTN_EDIT, "Edit button", MEDIUMWAIT);
        boolean editTitle = isElementDisplayed(EDIT_HEADER_WMI);
        Assert.assertTrue(editTitle);
        List<WebElement> chkboxes = driver.findElements(CHEKBOXES_EDITWINDOW_WMI);
        for (int i = 0; i <= chkboxes.size() - 1; i++) {
            chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES_WMI, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EXECUTE, "Button execute", MEDIUMWAIT);
        String actualText = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Action(s) queued");
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE1, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        try {
            String Notify = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
            System.out.println(Notify);
            if (Notify.equals(NotifyText)) {
                mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
                safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
                waitForSecs(9);
                safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
                waitForSecs(5);
                safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
                waitForSecs(10);
                safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
                waitForSecs(10);

            }
        } catch (Exception e) {

        }
    }

    public void applyingFilters(String alertTemplate) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + alertTemplate + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        //driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, alertTemplate);
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
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }

    }

    public void verifyingIconsInEditWindow(String dname1) {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
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
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + dname1 + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
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
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }

    }

    public void NavigateToSLAsPageFromAlertTemplateEditwindow(String dname1) {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(SLAS_HYPER_LINK, "Slas hyper link", MEDIUMWAIT);


    }

    //Alerts

    public void clickingOnAlerts() {
        waitForSecs(10);
        safeClick(LABEL_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_ALERT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
    }

    public void navigatingToAlertPage() {
        safeClick(LABEL_ALERT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingAlerts(String Alert) {
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
        safeClearAndType(DRPDOWN_SLA, "Native Mouse Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_LIST);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equalsIgnoreCase("Native Mouse Click - raw - User Click SLA")) {

                dbs2.get(i).click();
                break;
            }
        }

        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void deletingAlert(String Alert) {
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
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }


    }

    public void VerifyingEmailSubject(String Subject) {
        String EmailSubject = safeGetText(EMAIL_SUBJECT, "Alert subject", MEDIUMWAIT);
        if (EmailSubject.contains(Subject)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

    }

    public void verifyingAddedAlertInInsightPage() {
        safeClick(LABEL_DAILY_INSIGHT, "Daily tal", MEDIUMWAIT);
        boolean sla = driver.findElement(By.xpath("//div[text()='User Click']")).isDisplayed();
        System.out.println(sla);
        Assert.assertTrue(sla);
        waitForSecs(30);
        safeClick(LABEL_ALERT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }


    public void triggeringAnAlertWithNotify(String Alert) {
        safeType(TEXTBOX_TYPESEARCH, Alert + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SHOW_ADVANCED, "Advanced button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_NOTIFY_ON_SUCCESS, "Success label", MEDIUMWAIT);
        safeClick(LABEL_NOTIFY_ON_FAILURE, "Failure Label", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);

    }

    public void deletingEmails() {

        waitForSecs(30);
        safeClick(LABEL_MENU_BUTTON, "Menu button", MEDIUMWAIT);
        safeClick(LABEL_EMPTY_TEXTBOX, "Empty textbox", MEDIUMWAIT);
        acceptAlert();
    }

    public void triggeringAlertBasedOnExecutionCount(String Alert) {
        safeType(TEXTBOX_TYPESEARCH, Alert + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SHOW_ADVANCED, "Advanced button", MEDIUMWAIT);
        waitForSecs(10);
        safeTypeUsingChrod(TXTBOX_EXECUTION_COUNT, "3", "Execution count", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, Alert + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
    }

    public void triggeringAnAlertWithSpecifiedquiteTime(String Alert) {
        safeType(TEXTBOX_TYPESEARCH, Alert + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SHOW_ADVANCED, "Advanced button", MEDIUMWAIT);
        waitForSecs(10);
        safeTypeUsingChrod(TXTBOX_EXECUTION_COUNT, "3", "Execution count", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_QUITE_TIME, "4000", "quite time", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);

    }

    public void navigateToAlertTemplateWindow() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ALERT_TEMPLATES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void NavigateToSLAsPageFromAlertEditwindow(String dname1) {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(SLAS_HYPERLINK, "Slas hyper link", MEDIUMWAIT);


    }

    public void validatingSLAsEditWindow() {
        By SLATitle = By.xpath("//h5[text()='User Click SLA']");
        System.out.println(SLATitle);
        boolean b = isElementDisplayed(SLATitle);
        Assert.assertTrue(b);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        Assert.assertEquals(Name_Add, "User Click SLA");
        safeClick(CLOSE_EDITWINDOW, "Alert Edit window", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }

    }

    public void verifyingTheViewDataForFeidlsInAlertsEditWindow(String Alert) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Alert + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        String actTxt = safeGetText(LIST_OF_KPIS_VALUES, "Alert View Icon Value", MEDIUMWAIT);
        String expectedTxt = "DistributionList";
        Assert.assertEquals(actTxt, expectedTxt);
        waitForSecs(5);
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }
    }

    public void navigateToSLAPageFrmAlertspage(String Alert) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Alert + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(SLA_LINK, "Sla Hyper link", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Service Level Agreements");
        waitForSecs(10);
        String SLAname = safeGetAttribute(SLA_TXTBOX, "value", "Script", MEDIUMWAIT);
        System.out.println(SLAname);
        Assert.assertEquals(SLAname, "User Click SLA");
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);
        waitForSecs(5);

    }

    public void deletingCreatedAlerts(String Alert) {
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Alert + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_REMOVE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        String Notify = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(Notify);
        Assert.assertEquals(Notify, NotifyText);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }
    }
}

