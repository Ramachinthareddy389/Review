package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.KPIsLocators;
import com.page.locators.PortletLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class KPIsPage extends SafeActions implements KPIsLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String KpisName = "KPI" + random.nextInt(3000);
    String Threshold = "Threshold" + random.nextInt(2000);
    String editKPi = "EditedKpis" + random.nextInt(3000);
    String Name_Add, Fact_Type_add, FactCategory_Add, DSCategory_add, Sla_Name_Add, Threshold_Name_Add, Color_add, Alert_add, Edited_Name_Add, Edited_FactType_add, Edited_FactCategory_Add;
    private WebDriver driver1;


    public KPIsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnCorrelation() {
        waitForSecs(10);
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_KPIS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_KPIS, "Add button", MEDIUMWAIT);
    }

    public void addingKPIPage() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, KpisName, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        waitForSecs(10);
        safeClick(LABEL_FACTTYPE, "Server Feild", MEDIUMWAIT);
        safeClick(FACTTYPE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FACTTYPE, "Alert Event", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Alert Event")) {

                dbs1.get(i).click();
                break;
            }
        }
        Fact_Type_add = safeGetText(FACTTYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Fact_Type_add);
        Fact_Type_add = Fact_Type_add.replaceAll("\\s+", "");
        waitForSecs(10);
        safeClick(LABEL_FACT_CATEGORY, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_FACT_CATEGORY, "Fact Category", "Name into textbox", MEDIUMWAIT);
        FactCategory_Add = safeGetAttribute(TXTBOX_FACT_CATEGORY, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(FactCategory_Add);

        safeClick(LABEL_DSCATEGORY, "Server Feild", MEDIUMWAIT);
        safeClick(DSCATEGORY_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DSCATEGORY, "Browser", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs2.get(i).getText().equals("Browser")) {

                dbs2.get(i).click();
                break;
            }
        }
        DSCategory_add = safeGetText(DSCATEGORY_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(DSCategory_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_RADIO_SLA_TYPE, "SLA type", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void addingSLASettingsPage() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, KpisName + "SLA", "Name into textbox", MEDIUMWAIT);
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

    public void addingSLAAction(String SLA) {
        safeClick(LABEL_ALERT_TEMP, "Server Feild", MEDIUMWAIT);
        safeClick(ALERT_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ALERT, SLA, "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals(SLA)) {

                dbs2.get(i).click();
                break;
            }
        }
        Alert_add = safeGetText(ALERT_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Alert_add);
        waitForSecs(10);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "user-login-report", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs3.get(i).getText().equals("user-login-report")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingKPIsPage() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = KpisName;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);

        System.out.println(Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Fact_Type_add + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText() +
                FactCategory_Add + driver.findElement(TXTBOX_EDITED_FACT_CATEGORY).getAttribute("value") + Sla_Name_Add + driver.findElement(HYPERLINK_SLAs).getText());
        if (Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Fact_Type_add.equals(driver.findElement(TXTBOX_EDITED_FACTTYPE).getText()) &&
                FactCategory_Add.equals(driver.findElement(TXTBOX_EDITED_FACT_CATEGORY).getAttribute("value")) && Sla_Name_Add.equals(driver.findElement(HYPERLINK_SLAs).getText())) {
            System.out.println("KPIs details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);


        } else {
            Assert.fail("KPIs details are invalid");
        }
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void editKPISConfig() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(EDITED_NAME_LABEl, "Name Feild", MEDIUMWAIT);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_EDITED_NAME);
        searchField.sendKeys(del5 + editKPi);
        Edited_Name_Add = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_FACTTYPE, "Server Feild", MEDIUMWAIT);
        safeClick(FACTTYPE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_EDITED_FACTTYPE, "FlowNode", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("FlowNode")) {

                dbs1.get(i).click();
                break;
            }
        }
        Edited_FactType_add = safeGetText(FACTTYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Edited_FactType_add);
        waitForSecs(10);
        safeClick(EDITED_FACTCATEGORY_LABEl, "Name Feild", MEDIUMWAIT);
        String del6 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField6 = driver.findElement(TXTBOX_EDITED_FACT_CATEGORY);
        searchField6.sendKeys(del6 + editKPi);
        Edited_FactCategory_Add = safeGetAttribute(TXTBOX_EDITED_FACT_CATEGORY, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
    }


    public void verifyingEditedKPISDetails() {
        safeType(TEXTBOX_TYPESEARCH, editKPi + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = editKPi;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        System.out.println(Edited_Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Edited_FactType_add + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText() +
                Edited_FactCategory_Add + driver.findElement(TXTBOX_EDITED_FACT_CATEGORY).getAttribute("value"));
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Edited_FactType_add.equals(driver.findElement(TXTBOX_EDITED_FACTTYPE).getText())
                && Edited_FactCategory_Add.equals(driver.findElement(TXTBOX_EDITED_FACT_CATEGORY).getAttribute("value"))) {
            System.out.println("Edited Kpis details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);

        } else {
            Assert.fail("Edited Kpis details are invalid");
        }
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
    }

    public void addingSLASInEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVE_SLAS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(SLAS_ADD_ICON, "BP Steps add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_RADIO_SLA_TYPE, "SLA type", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);

    }

    public void verifyingAddedSLASInEditConfigWindow() {
        String actualText = safeGetText(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        String expectedText = KpisName + "SLA";
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVE_SLAS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void addingThresholdValueInEditKPIswindow() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
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
        for (int i = 0; i < dbs3.size(); i++) {

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
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void navigateToDrillThrghPageFrmKpiEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_DRILLTHROUGH, "Drill Through icon", MEDIUMWAIT);
        String actualText = safeGetText(TITLE_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dashBoardData.drillthrghpage + " " + KpisName);
    }

    public void addingActionsInEditSLAConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        safeClick(HYPERLINK_THRESHOLD, "Threshold Hyperlink", MEDIUMWAIT);
        safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ACTIONS_ADD_ICON, "Actions Icon", MEDIUMWAIT);
        safeClick(LABEL_ACTIONS_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS_NAME, "user-login-report", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("user-login-report")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingActionsInEditSLAConfigWindow() {
        String actualText = safeGetText(HYPERLINK_ACTIONS, "Added BP Steps", MEDIUMWAIT);
        String expectedText = "user-login-report";
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close Window", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_ALL_CKHBOX, "All Checkbox", MEDIUMWAIT);
        safeClick(DELETE_SLAS, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void verifyingIconsInEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + KpisName + " - Cloned']");
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

    public void viewDataWithFeildsForViewIcon() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        waitForSecs(10);
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
        waitForSecs(15);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void deleteinAlertTemplate(String dname1) {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingPageIcons() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        //mouseHoverJScript(SELECTROW_CHKBOX, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE,"clone button",MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label","Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = KpisName+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
    public void applyingFilters() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + KpisName + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
       // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, KpisName);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

}