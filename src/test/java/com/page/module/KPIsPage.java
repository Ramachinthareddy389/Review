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
    String KpisName = "KPI's" + random.nextInt(3000);
    String Threshold = "Threshold"+random.nextInt(2000);
    String editKPi = "EditedKpis"+random.nextInt(3000);
    String Name_Add, Fact_Type_add,FactCategory_Add,DSCategory_add,Sla_Name_Add,Threshold_Name_Add,Color_add,Alert_add,Edited_Name_Add,Edited_FactType_add,Edited_FactCategory_Add;
    private WebDriver driver1;


    public KPIsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnCorrelation() {
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_KPIS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_KPIS, "Add button", MEDIUMWAIT);
    }

    public void addingKPIPage() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, KpisName, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);

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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_RADIO_SLA_TYPE,"SLA type",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
    }

    public void addingSLASettingsPage() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, KpisName+"SLA", "Name into textbox", MEDIUMWAIT);
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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
    }

    public void addingSLAAction(){
        safeClick(LABEL_ALERT_TEMP, "Server Feild", MEDIUMWAIT);
        safeClick(ALERT_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ALERT, "SLA", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
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
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingKPIsPage(){
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
                FactCategory_Add + driver.findElement(TXTBOX_EDITED_FACT_CATEGORY).getAttribute("value") +Sla_Name_Add + driver.findElement(HYPERLINK_SLAs).getText());
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
        safeClick(CLOSE_EDITWINDOW,"Edit window",MEDIUMWAIT);
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
                Edited_FactCategory_Add + driver.findElement(TXTBOX_EDITED_FACT_CATEGORY).getAttribute("value") );
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
        safeClick(CLOSE_EDITWINDOW,"Edit window",MEDIUMWAIT);
    }

    public void addingSLASInEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVE_SLAS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save Button",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(SLAS_ADD_ICON, "BP Steps add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_RADIO_SLA_TYPE,"SLA type",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);

    }

    public void verifyingAddedSLASInEditConfigWindow() {
        String actualText = safeGetText(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
       String expectedText = KpisName+"SLA";
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVE_SLAS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW,"Close window",MEDIUMWAIT);
    }

    public void addingThresholdValueInEditKPIswindow(){
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        safeClick(BTN_REMOVE_THRESHOLDS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(THRESHOLDS_ADD_ICON, "BP Steps add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
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
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);

    }

    public void verifyingAddedThresholdInEditWindow(){
        String actualText = safeGetText(HYPERLINK_THRESHOLD, "Added BP Steps", MEDIUMWAIT);
        String expectedText = Threshold;
        Assert.assertEquals(actualText, expectedText);
        safeClick(BTN_REMOVE_THRESHOLDS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW,"Close window",MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW,"Close window",MEDIUMWAIT);
    }

    public void navigateToDrillThrghPageFrmKpiEditWindow(){
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_DRILLTHROUGH,"Drill Through icon",MEDIUMWAIT);
        String actualText = safeGetText(TITLE_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dashBoardData.drillthrghpage + " " +KpisName);
    }

    public void addingActionsInEditSLAConfigWindow(){
        safeType(TEXTBOX_TYPESEARCH, KpisName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        safeClick(HYPERLINK_THRESHOLD,"Threshold Hyperlink",MEDIUMWAIT);
        safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save Button",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ACTIONS_ADD_ICON,"Actions Icon",MEDIUMWAIT);
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
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

      public void verifyingActionsInEditSLAConfigWindow(){
          String actualText = safeGetText(HYPERLINK_ACTIONS, "Added BP Steps", MEDIUMWAIT);
          String expectedText = "QA HTTP";
          Assert.assertEquals(actualText, expectedText);
          safeClick(BTN_REMOVE_ACTIONS, "Delete button", MEDIUMWAIT);
          safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
          waitForSecs(10);
          safeClick(CLOSE_EDITWINDOW,"Close Window",MEDIUMWAIT);
          safeClick(CLOSE_EDITWINDOW,"Close Window",MEDIUMWAIT);
          safeClick(CLOSE_EDITWINDOW,"Close Window",MEDIUMWAIT);
          safeJavaScriptClick(SELECT_ALL_CKHBOX,"All Checkbox",MEDIUMWAIT);
          safeClick(DELETE_SLAS,"Delete Slas",MEDIUMWAIT);
          safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);
      }

}