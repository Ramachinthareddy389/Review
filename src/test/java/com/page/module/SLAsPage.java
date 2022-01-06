package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.KPIsLocators;
import com.page.locators.SLAsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SLAsPage extends SafeActions implements SLAsLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();

    String Threshold = "Threshold" + random.nextInt(2000);
    String editedSLA = "editedSLA" + random.nextInt(3000);
    String Name_Add, Fact_Type_add, Edited_Alert_add, DSCategory_add, Sla_Name_Add, Threshold_Name_Add, Color_add, Alert_add, Edited_Name_Add, Edited_FactType_add, Edited_FactCategory_Add, Threshold_New_Name_Add;
    private WebDriver driver1;


    public SLAsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingSLAsPage() {
        safeClick(BTN_SLAS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void clickingOnSLAs() {
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SLAS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_SLAS, "Add SLAS button", MEDIUMWAIT);
        safeClick(LABEL_KPI_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(KPI_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(KPINAME_TXTBOX, "CPU Usage", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("CPU Usage")) {

                dbs1.get(i).click();
                break;
            }
        }
        Fact_Type_add = safeGetText(KPI_NAME_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_RADIO_SLA_TYPE, "SLA type", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(9);
    }

    public void navigatingToSLAsPage() {
        waitForSecs(9);
        safeClick(BTN_SLAS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingSLASettingsPage(String slasName) {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, slasName + "SLA", "Name into textbox", MEDIUMWAIT);
        Sla_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Sla_Name_Add);

        safeClick(LABEL_THRESHOLD, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_THRESHOLD, "5", "Name into textbox", MEDIUMWAIT);
        Threshold_Name_Add = safeGetAttribute(TXTBOX_THRESHOLD, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Threshold_Name_Add);


        safeClick(LABEL_COLOR, "Server Feild", MEDIUMWAIT);
        safeClick(COLOR_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_COLOR, "Blue", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Blue")) {

                dbs2.get(i).click();
                break;
            }
        }
        Color_add = safeGetText(COLOR_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Color_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void addingSLAAction(String sla) {
        safeClick(LABEL_ALERT_TEMP, "Server Feild", MEDIUMWAIT);
        safeClick(ALERT_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ALERT, sla, "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals(sla)) {

                dbs2.get(i).click();
                break;
            }
        }
        Alert_add = safeGetText(ALERT_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Alert_add);
        waitForSecs(10);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "QA Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("QA Alert")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingSLAsPage(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = slasName + "SLA";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        String Threshold_New_Name_Add = "Threshold 1";
        waitForSecs(5);
        System.out.println(Sla_Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Alert_add + (driver.findElement(TXTBOX_EDITED_ALERT).getText()));
        if (Sla_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Alert_add.equals(driver.findElement(TXTBOX_EDITED_ALERT).getText())
                && Threshold_New_Name_Add.equals(driver.findElement(HYPERLINK_THRESHOLD).getText())) {
            System.out.println("KPIs details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);


        } else {
            Assert.fail("KPIs details are invalid");
        }
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
        safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void editSLAsConfig(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        waitForSecs(9);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        try {
            safeClick(EDITED_NAME_LABEl, "Name Feild", MEDIUMWAIT);
            String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
            WebElement searchField = driver.findElement(TXTBOX_EDITED_NAME);
            searchField.sendKeys(del5 + editedSLA);
            Edited_Name_Add = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
            waitForSecs(5);
            safeClick(LABEL_ALERT_TEMP, "Server Feild", MEDIUMWAIT);
            safeClick(ALERT_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
            safeJavaScriptClearAndType(TXTBOX_EDITED_ALERT, "CPU Usage", "Server name into textbox", MEDIUMWAIT);
            List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
            System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
            for (int i = 0; i < dbs1.size(); i++) {

                if (dbs1.get(i).getText().equals("CPU Usage")) {

                    dbs1.get(i).click();
                    break;
                }
            }
            Edited_Alert_add = safeGetText(ALERT_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
            System.out.println(Edited_Alert_add);
            safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
            waitForSecs(5);
           // safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        } catch (Exception e) {

        }
    }


    public void verifyingEditedSLADetails() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + editedSLA + "SLA" + "')]");
        safeClick(SeachedText,"Searched Text",MEDIUMWAIT);
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        try {
            String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
            System.out.println(pageTitle);
            String expectedText = editedSLA;
            Assert.assertEquals(pageTitle, expectedText);
            waitForSecs(5);
            System.out.println(Edited_Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Edited_Alert_add + driver.findElement(TXTBOX_EDITED_ALERT).getText());
            if (Edited_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Edited_Alert_add.equals(driver.findElement(TXTBOX_EDITED_ALERT).getText())) {
                System.out.println("Edited SLAS details are valid");
                String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
                System.out.println(text);
                waitForSecs(7);

            } else {
                Assert.fail("Edited Kpis details are invalid");
            }
            waitForSecs(10);
            safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
            safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
            safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
            safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        } catch (UnhandledAlertException e) {

        }
    }


    public void addingThresholdValueInEditSLAswindow(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVE_THRESHOLDS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(THRESHOLDS_ADD_ICON, "BP Steps add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Threshold, "Name into textbox", MEDIUMWAIT);
        Sla_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Sla_Name_Add);

        safeClick(LABEL_THRESHOLD_EDITED, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_THRESHOLD_EDITED, "7", "Name into textbox", MEDIUMWAIT);
        Threshold_Name_Add = safeGetAttribute(TXTBOX_THRESHOLD_EDITED, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Threshold_Name_Add);
        safeClick(LABEL_COLOR, "Server Feild", MEDIUMWAIT);
        safeClick(COLOR_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_COLOR, "Green", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Green")) {

                dbs2.get(i).click();
                break;
            }
        }
        Color_add = safeGetText(COLOR_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Color_add);

        waitForSecs(5);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT_EDITED, "Server textbox", MEDIUMWAIT);
        safeClearAndType(ACTIONS_TXTBOX_EDITED, "QA Test", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("QA Test")) {

                dbs3.get(i).click();
                break;
            }
        }
/*        Alert_add = safeGetText(ACTIONS_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Alert_add);
        waitForSecs(10);*/
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void verifyingAddedThresholdInEditWindow() {
        String actualText = safeGetText(HYPERLINK_THRESHOLD, "Added BP Steps", MEDIUMWAIT);
        String expectedText = Threshold;
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVE_THRESHOLDS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close window", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
        safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void addingActionsInEditSLAConfigWindow(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_THRESHOLD, "Threshold Hyperlink", MEDIUMWAIT);
        waitForSecs(10);
        try {
            if (isElementDisplayed(BTN_REMOVE_ACTIONS)) {
                safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
                waitForSecs(10);
                safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
            }
        } catch (Exception e) {
            System.out.println("Remove actions button not clickable.");
        }
        waitForSecs(5);
        safeClick(ACTIONS_ADD_ICON, "Actions Icon", MEDIUMWAIT);
        safeClick(LABEL_ACTIONS_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS_NAME, "QA HTTP", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("QA HTTP")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }


    public void verifyingActionsInEditSLAConfigWindow() {
        try {
            String actualText = safeGetText(HYPERLINK_ACTIONS, "Added BP Steps", MEDIUMWAIT);
            String expectedText = "QA Http";
            Assert.assertEquals(actualText, expectedText);
            safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
            safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
            waitForSecs(10);
            safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
            safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
            safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
            safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
            safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        } catch (UnhandledAlertException e) {
        }
    }

    public void addingAlertTemplateInEditSLAConfigWindow(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(ALERT_TEMPLATE_ADDICON, "Add icon of Alert template", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void verifyingAddedAlertTemplateInSLAEditWindow(String AlertTemplate) {
        waitForSecs(10);
        String alertName = safeGetText(TXTBOX_EDITED_ALERT, "Added Alert template", MEDIUMWAIT);
        System.out.println(alertName);
        Assert.assertEquals(alertName, AlertTemplate);
        waitForSecs(10);
        safeClick(BTN_SAVE, "Save buuton", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
        safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void navigateToKPIPageFromSLAPage(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        By locator = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span[text()='" + slasName + "SLA" + "']/../../following-sibling::div[2]/span/button");
        // mouseHoverJScript(locator, "Database Name", "Mouse hover", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(locator, "KPi Hyper Link", MEDIUMWAIT);
        waitForSecs(15);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Key Performance Indicators");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close edit window", MEDIUMWAIT);
    }

    public void deletingCreatedSLAs(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void navigateToAlertTemplatePageFrmSLAPage(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        By locator = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span[text()='" + slasName + "SLA" + "']/../../following-sibling::div[3]/span/button");
        // mouseHoverJScript(locator, "Database Name", "Mouse hover", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(locator, "KPi Hyper Link", MEDIUMWAIT);
        waitForSecs(15);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Alert Templates");
        waitForSecs(10);
        String pageTitle = safeGetText(TITLE_IN_ALERTTEMPLATE, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String alertName = safeGetAttribute(KPINAME_TXTBOX, "value", "Added Alert template", MEDIUMWAIT);
        System.out.println(alertName);
        Assert.assertEquals(pageTitle, alertName);
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);
    }

    public void verifyingPageIconsInSLApage(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        waitForSecs(30);
        mouseHoverJScript(SeachedText,"Slas page","searching config",MEDIUMWAIT);
        safeClick(SeachedText,"Slas page",MEDIUMWAIT);
        By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        By ELEMENT_STATUS = By.xpath("//div[@aria-label='Select Row']/following-sibling::div[2]/span//span[text()='" + slasName + "SLA" + "']/../../..//parent::div/div[1]/span/span/input");
        boolean b1 = isElementSelected(ELEMENT_STATUS);
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(ELEMENT_STATUS);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = "CPU Usage - raw - "+slasName + "SLA" + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    public void applyingFilters(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        //  mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, slasName + "SLA");
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);


    }


    public void verifyingIconsInEditWindow(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + slasName + "SLA" + " - Cloned']");
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
    }

    public void viewDataWithFeildsForViewIcon(String slasName) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + slasName + "SLA" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        // safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        //waitForSecs(10);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.SLA_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.SLA_VALUES.length - 1; j++) {
            System.out.println("Values are " + dashBoardData.SLA_VALUES[j]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    public void validatingSLATitleInSlAPAge(String slasName) {
        By SLATitle = By.xpath("//h5[text()='CPU Usage - raw - " + slasName + "SLA" + "']");
        System.out.println(SLATitle);
        boolean b = isElementDisplayed(SLATitle);
        Assert.assertTrue(b);
        By SLAPageTitle = By.xpath("//h5[text()='Service Level Agreements']");
        System.out.println(SLAPageTitle);
        boolean b1 = isElementDisplayed(SLAPageTitle);
        Assert.assertTrue(b1);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
    }

    public void deleteinAlertTemplate(String dname1) {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ALERT_TEMPLATES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void serchingForCreatedConfig(String DbTitle) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
    }
}