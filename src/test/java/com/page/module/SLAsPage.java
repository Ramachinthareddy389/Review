package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.KPIsLocators;
import com.page.locators.SLAsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SLAsPage extends SafeActions implements SLAsLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String slasName = "SLAs" + random.nextInt(3000);
    String Threshold = "Threshold" + random.nextInt(2000);
    String editedSLA = "editedSLA" + random.nextInt(3000);
    String Name_Add, Fact_Type_add, Edited_Alert_add, DSCategory_add, Sla_Name_Add, Threshold_Name_Add, Color_add, Alert_add, Edited_Name_Add, Edited_FactType_add, Edited_FactCategory_Add, Threshold_New_Name_Add;
    private WebDriver driver1;


    public SLAsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
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

    public void addingSLASettingsPage() {
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

    public void addingSLAAction() {
        safeClick(LABEL_ALERT_TEMP, "Server Feild", MEDIUMWAIT);
        safeClick(ALERT_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ALERT, "SLA", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("SLA")) {

                dbs2.get(i).click();
                break;
            }
        }
        Alert_add = safeGetText(ALERT_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Alert_add);
        waitForSecs(5);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "QA Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs3.get(i).getText().equals("QA Alert")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingSLAsPage() {
        safeType(TEXTBOX_TYPESEARCH, slasName + "SLA" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
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

    public void editSLAsConfig() {
        safeType(TEXTBOX_TYPESEARCH, slasName + "SLA" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
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
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
    }


    public void verifyingEditedSLADetails() {
        safeType(TEXTBOX_TYPESEARCH, editedSLA + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
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
    }


    public void addingThresholdValueInEditSLAswindow() {
        safeType(TEXTBOX_TYPESEARCH, slasName + "SLA" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
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
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs3.get(i).getText().equals("QA Test")) {

                dbs3.get(i).click();
                break;
            }
        }
        Alert_add = safeGetText(ALERT_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Alert_add);
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

    public void addingActionsInEditSLAConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, slasName + "SLA" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_THRESHOLD, "Threshold Hyperlink", MEDIUMWAIT);
        safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ACTIONS_ADD_ICON, "Actions Icon", MEDIUMWAIT);
        safeClick(LABEL_ACTIONS_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS_NAME, "QA HTTP", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("QA HTTP")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingActionsInEditSLAConfigWindow() {
        String actualText = safeGetText(HYPERLINK_ACTIONS, "Added BP Steps", MEDIUMWAIT);
        String expectedText = "QA HTTP";
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
        safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void addingAlertTemplateInEditSLAConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, slasName + "SLA" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, slasName + "SLA");
        safeClick(ALERT_TEMPLATE_ADDICON, "Add icon of Alert template", MEDIUMWAIT);
    }

    public void verifyingAddedAlertTemplateInSLAEditWindow(String AlertTemplate) {
        String alertName = safeGetText(TXTBOX_EDITED_ALERT, "Added Alert template", MEDIUMWAIT);
        System.out.println(alertName);
        Assert.assertEquals(alertName, AlertTemplate);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
        safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void navigateToKPIPageFromSLAPage(){
        safeType(TEXTBOX_TYPESEARCH, slasName + "SLA" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(30);
        By locator = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span[text()='" + slasName +"SLA"+ "']");
        mouseHoverJScript(locator, "Database Name", "Mouse hover", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(KPIS_LINKS, "KPi Hyper Link", MEDIUMWAIT);
        waitForSecs(15);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Key Performance Indicators");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW,"Close edit window",MEDIUMWAIT);
    }
}