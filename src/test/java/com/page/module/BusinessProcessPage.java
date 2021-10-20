package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.BusinessProcessLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class BusinessProcessPage extends SafeActions implements BusinessProcessLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    private DashBoardData dashBoardData = new DashBoardData();
    static int j;
    String Name_Add, KPIS_add, KeyExp_add, StepName_Add, SLA_Add, EditKey_Exp_add, Edited_KPIS_add, Edited_Name_Add;
    Random random = new Random();
    String dname = "BP";
    String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    String editBP1 = editBP + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);

    //Constructor to define/call methods
    public BusinessProcessPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnBP() {
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_BUSIPROCESS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingNewBusinessProcess() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, dname1, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Alert")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(20);
        KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KPIS_add);
        safeClick(LABEL_KEYEXP, "Server Feild", MEDIUMWAIT);
        safeClick(KEYEXP_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KEYEXP, "name", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("name")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        KeyExp_add = safeGetText(KEYEXP_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KeyExp_add);
        waitForSecs(15);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, dname1, "Name into textbox", MEDIUMWAIT);
        StepName_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_SLAADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(Filter_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FILTERS, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("color")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(CREATE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_VALUE, "test", "Server name into textbox", MEDIUMWAIT);
        safeClick(CREATE_LABEL, "Select or create dashboard text box", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SLA, dname1, "Name into textbox", MEDIUMWAIT);
        SLA_Add = safeGetAttribute(TXTBOX_SLA, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_SKIP, "Skip", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_DASHBOARD, "Server Feild", MEDIUMWAIT);
        safeClick(DASHBOARD_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DASHBOARD, "ActiveMQ", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("ActiveMQ")) {

                dbs5.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void verifyingBusinessProcessDetails() {
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
        waitForSecs(5);
        if (Name_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && KPIS_add.equals(driver.findElement(KPIS_GHOSTEXT).getText()) &&
                KeyExp_add.equals(driver.findElement(KEYEXP_GHOSTEXT).getText())) {
            System.out.println("Business process details are valid");
            String text = driver.findElement(TXTBOX_SERVERNAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(KPIS_GHOSTEXT).getText() +
                    " Instance Name: " + driver.findElement(KEYEXP_GHOSTEXT).getText());
        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }


    public void editBusinessConfig() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del + editBP1);
        Edited_Name_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "Database DB Time", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Database DB Time")) {

                dbs1.get(i).click();
                break;
            }
        }
        Edited_KPIS_add = safeGetText(TXTBOX_EDITED_KPIS, "Server textbox value", MEDIUMWAIT);
        safeClick(LABEL_KEYEXP, "Server Feild", MEDIUMWAIT);
        safeClick(KEYEXP_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KEYEXP, "bucket", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("bucket")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        EditKey_Exp_add = safeGetText(KEYEXP_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(EditKey_Exp_add);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, editBP1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String EditedText = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(EditedText);
        Assert.assertEquals(EditedText, editBP1);

    }

    public void verifyingEditedBusinessProcessNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, editBP1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = editBP1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && Edited_KPIS_add.equals(driver.findElement(TXTBOX_EDITED_KPIS).getText()) &&
                EditKey_Exp_add.equals(driver.findElement(KEYEXP_GHOSTEXT).getText())) {
            System.out.println("Business process details are valid");
            String text = driver.findElement(TXTBOX_SERVERNAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(10);
            System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_EDITED_KPIS).getText() +
                    " Instance Name: " + driver.findElement(KEYEXP_GHOSTEXT).getText());
        } else {
            Assert.fail("Business process details are invalid");
        }
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void addingBPStepInEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVEBPSTEPS, "Delete button", MEDIUMWAIT);
        // safeClick(BTN_CLOSE,"Close after deleting BPs steps",MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BPSTEPS_ADDICON, "BP Steps add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_STEPNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_STEPNAME, editBP1, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_STEPNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        waitForSecs(5);
        safeClick(Filter_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FILTERS, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("color")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClearAndType(TXTBOX_BPSTEPS_VALUE, "test", "Server name into textbox", MEDIUMWAIT);
        //  safeClick(LABEL_SLA, "Name Feild", MEDIUMWAIT);
        //safeType(TXTBOX_SLA, "2", "Name into textbox", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedBPStepsInEditConfigWindow() {
        String actualText = safeGetText(ADDED_BPSTEPS, "Added BP Steps", MEDIUMWAIT);
        expectedText = editBP1;
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVEBPSTEPS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }


    public void validatingBPStepMetrics() {
        String actualText = safeGetText(ADDED_BPSTEPS, "Added BP Steps", MEDIUMWAIT);
        expectedText = editBP1;
        Assert.assertEquals(actualText, expectedText);
        safeClick(ADDED_BPSTEPS, "Added Bp steps");
        safeClick(BPSTEP_METRICS_ADDICON, "Added BP Metric icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEl_METRIC_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_METRIC_NAME, "BP Metric", "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_METRIC_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        waitForSecs(5);
        safeClick(TXTBOX_METRIC_EXP, "Metric Exp", MEDIUMWAIT);
        WebElement metric = driver.findElement(TXTBOX_METRIC_EXP);
        metric.sendKeys("test");
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close Button", MEDIUMWAIT);
        waitForSecs(5);
        String actualText1 = safeGetText(ADDED_BPMETRIC, "Added BP Steps", MEDIUMWAIT);
        expectedText = "BP Metric";
        Assert.assertEquals(actualText1, expectedText);
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

    public void viewDataWithFeildsForViewIcon() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.KPIS_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.KPIS_VALUES.length; j++) {
            System.out.println("Values are " + dashBoardData.KPIS_VALUES[j]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void navigateToDrillThroughPage() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DRILLTHROUGH_LABEL, "Drill through label", MEDIUMWAIT);
        waitForSecs(9);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dashBoardData.drillthrghpage + " " + dname1 + " BP");
        safeClick(BTN_BUSIPROCESS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void navigateToKpiPageByClickingOnKPIS() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClick(KPIS_LINKS, "KPi Hyper Link", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Key Performance Indicators");
        safeClick(BTN_BUSIPROCESS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void verifyingIconsInEditWindow() {
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
        waitForSecs(10);
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


    public void applyingFilters(){
        safeClick(TYPE_SEARCH, "Text",MEDIUMWAIT);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
    }
}




