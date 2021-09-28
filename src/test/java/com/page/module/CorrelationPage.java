package com.page.module;

import com.page.locators.CorrelationLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CorrelationPage extends SafeActions implements CorrelationLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    static int j;
    String Name_Add, KPIS_add, KeyExp_add, StepName_Add, FeildExclusion_add, Name_Add1, Type_add, Genarator_add, Retention_add, Type_add1, Retension_Name_Add, Edited_Name_Add, Edited_Type_add, Edited_KPIS_add, After_Edit_Type;
    String Correlation_Name_Add, Correlation_LStream_Add, TimeToLive_LStream_add, Lstream_KPIS_add, Lstream_PartitionKey_add, Lstream_OrderKey_add;
    String Correlation_RStream_Add, TimeToLive_RStream_add, Rstream_KPIS_add, Rstream_PartitionKey_add, Rstream_OrderKey_add, CostFun_add, PairFun_add;
    String Edited_Correlation_Name_Add, Edited_LStreamName_Add, Edited_LStreamTimeToLive_Add, Edited_LStreamKpis_Add, Edited_LStreamPartition_Add, Edited_LStreamOrderby_Add, Edited_RStreamName_Add, Edited_RStreamTimeToLive_Add, Edited_RStreamKpis_Add, Edited_RStreamPartition_Add, Edited_RStreamOrderby_Add, EditedCostFun_add, EditedPairFun_add;
    Random random = new Random();
    String dname = "BP";
    String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    String editBP1 = editBP + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);
    String Stream_Correlation = "Correaltion" + random.nextInt(1500);
    String Edited_Stream_Correlation = "Edit_Stream" + random.nextInt(1500);

    //Constructor to define/call methods
    public CorrelationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnCorrelation() {
        waitForSecs(30);
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_CORRELATION, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingNewCorrelation() {
        safeClick(BTN_ADDICON_CORRELATION, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        waitForSecs(10);
        safeClick(LABEL_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "Flow Node", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(30);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Flow Node")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        Type_add = safeGetText(TYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Type_add);
        waitForSecs(20);
        Type_add1 = Type_add.replaceAll("\\s+", "");
        waitForSecs(5);
        safeClick(TXTBOX_NAME_GENERATOR, "Metric Exp", MEDIUMWAIT);
        WebElement metric = driver.findElement(TXTBOX_NAME_GENERATOR);
        metric.sendKeys("test");
        Genarator_add = safeGetText(ADDED_NAME_GENERATOR, "Server textbox value", MEDIUMWAIT);
        safeClick(LABEL_RETENSION, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_RETENSION);
        searchField1.sendKeys(del + "5000");
        Retention_add = safeGetAttribute(TXTBOX_RETENSION, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Retention_add);
        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Alert")) {

                dbs2.get(i).click();
                break;
            }
        }
        KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KPIS_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_EDITED_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        Name_Add1 = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add1);
        safeClick(LABEL_KEYEXP, "Server Feild", MEDIUMWAIT);
        safeClick(KEYEXP_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KEYEXP, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("color")) {

                dbs5.get(i).click();
                break;
            }
        }
        safeClick(LABEL_MASK, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_MASK);
        searchField.sendKeys(del1 + "2");
        StepName_Add = safeGetAttribute(TXTBOX_MASK, "value", "Name textbox value", MEDIUMWAIT);
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
        safeClearAndType(TXTBOX_FILTESR_VALUE, "test", "Server name into textbox", MEDIUMWAIT);
        safeClick(LABEL_FIELD_EXCLUSIONS, "Server Feild", MEDIUMWAIT);
        safeClick(FIELD_EXCLUSIONS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FIELD_EXCLUSIONS, "pid", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs6.size(); i++) {

            if (dbs6.get(i).getText().equals("pid")) {

                dbs6.get(i).click();
                break;
            }
        }
        FeildExclusion_add = safeGetText(FIELD_EXCLUSIONS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(FeildExclusion_add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void verifyingCorrelationDetails() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(30);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        System.out.println(Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + KPIS_add + driver.findElement(TXTBOX_EDITED_KPIS).getText() +
                Retention_add + driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value") + Type_add1 + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText() + Name_Add1 + driver.findElement(HYPERLINK_TYPES).getText());
        if (Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && KPIS_add.equals(driver.findElement(TXTBOX_EDITED_KPIS).getText()) &&
                Retention_add.equals(driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value")) && Type_add1.equals(driver.findElement(TXTBOX_EDITED_FACTTYPE).getText()) && Name_Add1.equals(driver.findElement(HYPERLINK_TYPES).getText())) {
            System.out.println("Business process details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_EDITED_KPIS).getText() +
                    " Instance Name: " + driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value") + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText() + driver.findElement(HYPERLINK_TYPES).getText());

        } else {
            Assert.fail("Business process details are invalid");
        }
        waitForSecs(10);
        safeClick(DELETE_ALERT,"Delete Slas",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);
        waitForSecs(10);

    }


    public void editCorrelationConfig() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(EDITED_NAME_LABEl, "Name Feild", MEDIUMWAIT);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_EDITED_NAME);
        searchField.sendKeys(del5 + editBP1);
        Edited_Name_Add = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_RETENSION, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_EDITED_RETENTION);
        searchField1.sendKeys(del1 + "4000");
        Retension_Name_Add = safeGetAttribute(TXTBOX_EDITED_RETENTION, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Retension_Name_Add);
        safeClick(LABEL_EDITED_FACTTYPE, "Server Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_EDITED_FACTTYPE, "FlowNode", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("FlowNode")) {

                dbs1.get(i).click();
                break;
            }
        }
        Edited_Type_add = safeGetText(TYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Edited_Type_add);
        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "ActiveMQ Heap Usage", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("ActiveMQ Heap Usage")) {

                dbs2.get(i).click();
                break;
            }
        }
        Edited_KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KPIS_add);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
    }


    public void verifyingEditedCorrelationDetails() {
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
        System.out.println(Edited_Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Edited_KPIS_add + driver.findElement(TXTBOX_EDITED_KPIS).getText() +
                Retension_Name_Add + driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value") + Edited_Type_add + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText());
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Edited_KPIS_add.equals(driver.findElement(TXTBOX_EDITED_KPIS).getText())
                && Retension_Name_Add.equals(driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value")) && Edited_Type_add.equals(driver.findElement(TXTBOX_EDITED_FACTTYPE).getText())) {
            System.out.println("Business process details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_EDITED_KPIS).getText() +
                    " Instance Name: " + driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value") + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText() + driver.findElement(HYPERLINK_TYPES).getText());

        } else {
            Assert.fail("Business process details are invalid");
        }
        waitForSecs(10);
        safeClick(DELETE_ALERT,"Delete Slas",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);
        waitForSecs(10);
    }


    public void verifyingTypesInCorrelationScenarioWindow() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_REMOVETYPES, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(TYPES_ADDICON, "BP Steps add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, dname1 + 123, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(LABEL_KEYEXP, "Server Feild", MEDIUMWAIT);
        safeClick(KEYEXP_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KEYEXP, "name", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("name")) {

                dbs5.get(i).click();
                break;
            }
        }
        safeClick(LABEL_MASK, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_MASK);
        searchField.sendKeys(del1 + "2");
        StepName_Add = safeGetAttribute(TXTBOX_MASK, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_SLAADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(FILTERS_GHOSTTEXT_IN_TYPES, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FILTERS, "pid", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("pid")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClearAndType(TXTBOX_FILTESR_VALUE, "test", "Server name into textbox", MEDIUMWAIT);
        safeClick(LABEL_FIELD_EXCLUSIONS, "Server Feild", MEDIUMWAIT);
        safeClick(FIELD_EXCLUSIONS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FIELD_EXCLUSIONS, "tid", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs6.size(); i++) {

            if (dbs6.get(i).getText().equals("tid")) {

                dbs6.get(i).click();
                break;
            }
        }
        FeildExclusion_add = safeGetText(FIELD_EXCLUSIONS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(FeildExclusion_add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        String actualText = safeGetText(HYPERLINK_TYPES, "Types hyperlink name", MEDIUMWAIT);
        expectedText = dname1 + "123";
        Assert.assertEquals(actualText, expectedText);
        waitForSecs(10);
        waitForSecs(10);
        safeClick(DELETE_ALERT,"Delete Slas",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);
        waitForSecs(10);
    }


    public void validatingEditTypeinEditCorrelationScenariowindow() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String beforeEdit = driver.findElement(TXTBOX_EDITED_FACTTYPE).getText();
        System.out.println(beforeEdit);
        expectedText = "FlowNode";
        Assert.assertEquals(beforeEdit, expectedText);
        safeClick(LABEL_EDITED_FACTTYPE, "Server Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_EDITED_FACTTYPE, "FactCounter", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("FactCounter")) {

                dbs1.get(i).click();
                break;
            }
        }
        After_Edit_Type = safeGetText(TYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(After_Edit_Type);
        String expectedTextAfterEdit = "FactCounter";
        Assert.assertEquals(After_Edit_Type, expectedTextAfterEdit);
        waitForSecs(10);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT,"Delete Slas",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);
        waitForSecs(10);
    }

    public void AddingCorrrlationStreamPage() {
        safeClick(BTN_ADDICON_STREAM_CORRELATION, "Add button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Stream_Correlation, "Name into textbox", MEDIUMWAIT);
        Correlation_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Correlation_Name_Add);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
    }

    public void AddingLeftStreamPage() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, "LeftStream", "Name into textbox", MEDIUMWAIT);
        Correlation_LStream_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Correlation_LStream_Add);

        safeClick(LABEL_TIME_TO_LIVE, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXT_BOX_TIME_TO_LIVE);
        searchField1.sendKeys(del + "5000");
        TimeToLive_LStream_add = safeGetAttribute(TXT_BOX_TIME_TO_LIVE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(TimeToLive_LStream_add);

        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Alert")) {

                dbs2.get(i).click();
                break;
            }
        }
        Lstream_KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Lstream_KPIS_add);
        waitForSecs(20);
        safeClick(LABEL_PARTITION_KEY, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_PARTITION_KEY, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(DROPDOWN_PARTITION_KEY, "application.name", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("application.name")) {

                dbs3.get(i).click();
                break;
            }
        }
        Lstream_PartitionKey_add = safeGetText(GHOSTTEXT_PARTITION_KEY, "Server textbox value", MEDIUMWAIT);
        System.out.println(Lstream_PartitionKey_add);
        waitForSecs(5);
        safeClick(LABEL_ORDER_BY, "Server Feild", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(GHOSTTEXT_ORDER_BY, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(DROPDOWN_ORDER_BY, "application.name", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("application.name")) {

                dbs4.get(i).click();
                break;
            }
        }
        Lstream_OrderKey_add = safeGetText(GHOSTTEXT_PARTITION_KEY, "Server textbox value", MEDIUMWAIT);
        System.out.println(Lstream_OrderKey_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);

    }

    public void AddingRightStreamPage() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, "RightStream", "Name into textbox", MEDIUMWAIT);
        Correlation_RStream_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Correlation_RStream_Add);

        safeClick(LABEL_TIME_TO_LIVE_IN_SECONDS, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXT_BOX_TIME_TO_LIVE);
        searchField1.sendKeys(del + "5000");
        TimeToLive_RStream_add = safeGetAttribute(TXT_BOX_TIME_TO_LIVE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(TimeToLive_RStream_add);
        waitForSecs(10);
        safeClick(LABEL_RSTREAM_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_KPIS_RSTREAM, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(DROPDOWN_KPIS_RSTREAM, "Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Alert")) {

                dbs2.get(i).click();
                break;
            }
        }
        Rstream_KPIS_add = safeGetText(RSTREAM_KPIS_VALUE, "Server textbox value", MEDIUMWAIT);
        System.out.println(Rstream_KPIS_add);
        waitForSecs(20);
        safeClick(LABEL_PARTITION_KEY, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_PARTITION_KEY, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(DROPDOWN_PARTITION_KEY, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("color")) {

                dbs3.get(i).click();
                break;
            }
        }
        Rstream_PartitionKey_add = safeGetText(GHOSTTEXT_PARTITION_KEY, "Server textbox value", MEDIUMWAIT);
        System.out.println(Rstream_PartitionKey_add);
        waitForSecs(5);
        safeClick(LABEL_ORDER_BY, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_ORDER_BY, "Server textbox", MEDIUMWAIT);
        safeClearAndType(DROPDOWN_ORDER_BY, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("color")) {

                dbs4.get(i).click();
                break;
            }
        }
        Rstream_OrderKey_add = safeGetText(GHOSTTEXT_PARTITION_KEY, "Server textbox value", MEDIUMWAIT);
        System.out.println(Rstream_OrderKey_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void AddingStreamFunction() {
        safeClick(TEXT_AREA_COST_FUNCTION, "Metric Exp", MEDIUMWAIT);
        WebElement metric = driver.findElement(TEXT_AREA_COST_FUNCTION);
        metric.sendKeys("test");
        CostFun_add = safeGetText(EDITED_COST_FUNCTION, "Server textbox value", MEDIUMWAIT);
        System.out.println(CostFun_add);

        safeClick(TEXT_AREA_PAIR_FUNCTION, "Metric Exp", MEDIUMWAIT);
        WebElement pair = driver.findElement(TEXT_AREA_PAIR_FUNCTION);
        pair.sendKeys("pair1");
        PairFun_add = safeGetText(EDITED_PAIR_FUNCTION, "Server textbox value", MEDIUMWAIT);
        System.out.println(PairFun_add);
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedStreamCorrelationScenarios() {
        safeType(TEXTBOX_TYPESEARCH, Stream_Correlation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(15);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Stream_Correlation;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        System.out.println(Correlation_Name_Add + ":" + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Correlation_LStream_Add + ":" + driver.findElement(EDITED_LSTREAM_NAME_TXTBOX).getAttribute("value") +
                TimeToLive_LStream_add + driver.findElement(EDITED_LSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value") + Lstream_KPIS_add + ":"+driver.findElement(EDITED_LSTREAM_KPI_VALUE).getText() + Lstream_PartitionKey_add + driver.findElement(EDITED_LSTREAM_PARTITION_KEY).getText() + Lstream_OrderKey_add + driver.findElement(EDITED_LSTREAM_ORDER_BY).getText() + Correlation_RStream_Add + ":" + driver.findElement(EDITED_RSTREAM_NAME_TXTBOX).getAttribute("value") + TimeToLive_RStream_add + ":" + driver.findElement(EDITED_RSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value") + Rstream_KPIS_add + ":" + driver.findElement(EDITED_RSTREAM_KPI_VALUE).getText() + Rstream_PartitionKey_add + ":" + driver.findElement(EDITED_RSTREAM_PARTITION_KEY).getText() + Rstream_OrderKey_add + ":" + driver.findElement(EDITED_RSTREAM_ORDER_BY).getText() + CostFun_add + ":" + driver.findElement(EDITED_COST_FUNCTION).getText() + PairFun_add + ":" + driver.findElement(EDITED_PAIR_FUNCTION).getText());
        if (Correlation_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Correlation_LStream_Add.equals(driver.findElement(EDITED_LSTREAM_NAME_TXTBOX).getAttribute("value")) &&
                TimeToLive_LStream_add.equals(driver.findElement(EDITED_LSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value")) && Lstream_KPIS_add.equals(driver.findElement(EDITED_LSTREAM_KPI_VALUE).getText()) && Lstream_PartitionKey_add.equals(driver.findElement(EDITED_LSTREAM_PARTITION_VALUE).getText()) && Lstream_OrderKey_add.equals(driver.findElement(EDITED_LSTREAM_ORDER_VALUE).getText()) && Correlation_RStream_Add.equals(driver.findElement(EDITED_RSTREAM_NAME_TXTBOX).getAttribute("value")) && TimeToLive_RStream_add.equals(driver.findElement(EDITED_RSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value")) && Rstream_KPIS_add.equals(driver.findElement(EDITED_RSTREAM_KPI_VALUE).getText()) && Rstream_PartitionKey_add.equals(driver.findElement(EDITED_RSTREAM_PARTITION_VALUE).getText()) && Rstream_OrderKey_add.equals(driver.findElement(EDITED_RSTREAM_ORDER_VALUE).getText()) && CostFun_add.equals(driver.findElement(EDITED_COST_FUNCTION).getText()) && PairFun_add.equals(driver.findElement(EDITED_PAIR_FUNCTION).getText()))
        {
            System.out.println("Valid Details");
        } else {
            Assert.fail("Stream Correlation process details are invalid");
        }
        waitForSecs(10);
        safeClick(DELETE_ALERT,"Delete Slas",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);

    }

    public void EditStreamCorrelationScenarios() {
        safeType(TEXTBOX_TYPESEARCH, Stream_Correlation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Stream_Correlation;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
    }

    public void EditLeftStreamFeildsWithNewValues() {
        safeClick(EDITED_NAME_LABEl, "Name Feild", MEDIUMWAIT);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_EDITED_NAME);
        searchField.sendKeys(del5 + Edited_Stream_Correlation);
        Edited_Name_Add = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(EDITED_LSTREAM_LABEL, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(EDITED_LSTREAM_NAME_TXTBOX);
        searchField1.sendKeys(del1 + "EditLSTREAm");
        Edited_LStreamName_Add = safeGetAttribute(EDITED_LSTREAM_NAME_TXTBOX, "value", "Timetolive", MEDIUMWAIT);
        System.out.println(Edited_LStreamName_Add);

        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(EDITED_LSTREAM_TIMETOLIVE_TXTBOX);
        searchField2.sendKeys(del2 + "7000");
        Edited_LStreamTimeToLive_Add = safeGetAttribute(EDITED_LSTREAM_TIMETOLIVE_TXTBOX, "value", "Timetolive", MEDIUMWAIT);
        System.out.println(Edited_LStreamTimeToLive_Add);

        safeClick(EDITED_LSTREAM_KPIS_LABEL, "Server Feild", MEDIUMWAIT);
        safeClick(CLOSINGADDED_KPIS, "ClosingKpis's", MEDIUMWAIT);
        safeClick(EDITED_LEFT_KPIS_GHSOTTXET, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(EDITED_LSTREAM_KPIS, "Agent Status", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Agent Status")) {

                dbs1.get(i).click();
                break;
            }
        }
        Edited_LStreamKpis_Add = safeGetText(EDITED_LSTREAM_KPI_VALUE, "Kpis", MEDIUMWAIT);
        System.out.println(Edited_LStreamKpis_Add);

        safeClick(EDITED_LSTREAM_PARTITION_LABEL, "Server Feild", MEDIUMWAIT);
        waitForSecs(7);
        safeType(EDITED_LSTREAM_PARTITION_KEY, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("color")) {

                dbs2.get(i).click();
                break;
            }
        }
        Edited_LStreamPartition_Add = safeGetText(EDITED_LSTREAM_PARTITION_KEY, "Partition key", MEDIUMWAIT);
        System.out.println(Edited_LStreamPartition_Add);

        safeClick(EDITED_LSTREAM_ORDER_LABEL, "Server Feild", MEDIUMWAIT);
        waitForSecs(7);
        safeType(EDITED_LSTREAM_ORDER_BY, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("color")) {

                dbs3.get(i).click();
                break;
            }
        }

        Edited_LStreamOrderby_Add = safeGetText(EDITED_LSTREAM_ORDER_BY, "Order by", MEDIUMWAIT);
        System.out.println(Edited_LStreamOrderby_Add);
    }


    public void EditRightStreamFeildsWithNewValues() {
        waitForSecs(5);
        safeClick(EDITED_RSTREAM_LABEL, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(EDITED_RSTREAM_NAME_TXTBOX);
        searchField1.sendKeys(del1 + "EditLSTREAm");
        Edited_RStreamName_Add = safeGetAttribute(EDITED_RSTREAM_NAME_TXTBOX, "value", "Timetolive", MEDIUMWAIT);
        System.out.println(Edited_RStreamName_Add);

        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(EDITED_RSTREAM_TIMETOLIVE_TXTBOX);
        searchField2.sendKeys(del2 + "7000");
        Edited_RStreamTimeToLive_Add = safeGetAttribute(EDITED_RSTREAM_TIMETOLIVE_TXTBOX, "value", "Timetolive", MEDIUMWAIT);
        System.out.println(Edited_RStreamTimeToLive_Add);
        waitForSecs(7);
        safeClick(EDITED_RSTREAM_KPIS_LABEL, "Server Feild", MEDIUMWAIT);
        safeClick(CLOSINGADDED_KPIS, "ClosingKpis's", MEDIUMWAIT);
        safeClick(EDITED_RIGHT_KPIS_GHSOTTXET, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(EDITED_RSTREAM_KPIS, "Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Alert")) {

                dbs1.get(i).click();
                break;

            }
        }
        Edited_RStreamKpis_Add = safeGetText(EDITED_RSTREAM_KPI_VALUE, "Kpis", MEDIUMWAIT);
        System.out.println(Edited_RStreamKpis_Add);

        safeClick(EDITED_RSTREAM_PARTITION_LABEL, "Server Feild", MEDIUMWAIT);
        waitForSecs(7);
        safeType(EDITED_RSTREAM_PARTITION_KEY, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("color")) {

                dbs2.get(i).click();
                break;
            }
        }
        Edited_RStreamPartition_Add = safeGetText(EDITED_RSTREAM_PARTITION_KEY, "Partition key", MEDIUMWAIT);
        System.out.println(Edited_RStreamPartition_Add);

        safeClick(EDITED_RSTREAM_ORDER_LABEL, "Server Feild", MEDIUMWAIT);
        waitForSecs(7);
        safeType(EDITED_RSTREAM_ORDER_BY, "color", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("color")) {

                dbs3.get(i).click();
                break;
            }
        }
        Edited_RStreamOrderby_Add = safeGetText(EDITED_RSTREAM_ORDER_BY, "Order by", MEDIUMWAIT);
        System.out.println(Edited_RStreamOrderby_Add);

        safeClick(TEXT_AREA_COST_FUNCTION, "Metric Exp", MEDIUMWAIT);
        String del7 = Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE;
        WebElement searchField7 = driver.findElement(TEXT_AREA_COST_FUNCTION);
        searchField7.sendKeys(del7 + "testingCostfunction");

        EditedCostFun_add = safeGetText(EDITED_COST_FUNCTION, "Server textbox value", MEDIUMWAIT);
        System.out.println(EditedCostFun_add);

        safeClick(TEXT_AREA_PAIR_FUNCTION, "Metric Exp", MEDIUMWAIT);
        String del8 = Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE;
        WebElement searchField8 = driver.findElement(TEXT_AREA_PAIR_FUNCTION);
        searchField8.sendKeys(del8 + "testingPairfunction");
        EditedPairFun_add = safeGetText(EDITED_PAIR_FUNCTION, "Server textbox value", MEDIUMWAIT);
        System.out.println(EditedPairFun_add);
        safeClick(BTN_SAVE, "Saave button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW, "Edited Close window", MEDIUMWAIT);
        safeClick(BTN_CLEAR,"Clear Button",MEDIUMWAIT);
    }

    public void verifyingEditedStreamCorrelationValues() {

        safeType(TEXTBOX_TYPESEARCH, Edited_Stream_Correlation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Edited_Stream_Correlation;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        System.out.println(Edited_Name_Add + ":" + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + Edited_LStreamName_Add + ":" + driver.findElement(EDITED_LSTREAM_NAME_TXTBOX).getAttribute("value") +
            Edited_LStreamTimeToLive_Add + driver.findElement(EDITED_LSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value") + Edited_LStreamKpis_Add + driver.findElement(EDITED_LSTREAM_KPI_VALUE).getText() + Edited_LStreamPartition_Add + driver.findElement(EDITED_LSTREAM_PARTITION_KEY).getText() + Edited_LStreamOrderby_Add + driver.findElement(EDITED_LSTREAM_ORDER_BY).getText() + Edited_RStreamName_Add + ":" + driver.findElement(EDITED_RSTREAM_NAME_TXTBOX).getAttribute("value") + Edited_RStreamTimeToLive_Add + ":" + driver.findElement(EDITED_RSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value") + Edited_RStreamKpis_Add+ ":" + driver.findElement(EDITED_RSTREAM_KPI_VALUE).getText() + Edited_RStreamPartition_Add+ ":" + driver.findElement(EDITED_RSTREAM_PARTITION_KEY).getText() + Edited_RStreamOrderby_Add + ":" + driver.findElement(EDITED_RSTREAM_ORDER_BY).getText() + EditedCostFun_add + ":" + driver.findElement(EDITED_COST_FUNCTION).getText() +EditedPairFun_add+ ":" + driver.findElement(EDITED_PAIR_FUNCTION).getText());
        System.out.println(Edited_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Edited_LStreamName_Add.equals(driver.findElement(EDITED_LSTREAM_NAME_TXTBOX).getAttribute("value")) &&
                Edited_LStreamTimeToLive_Add.equals(driver.findElement(EDITED_LSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value")) && Edited_LStreamKpis_Add.equals(driver.findElement(EDITED_LSTREAM_KPI_VALUE).getText()) && Edited_LStreamPartition_Add.equals(driver.findElement(EDITED_LSTREAM_PARTITION_KEY).getText()) && Edited_LStreamOrderby_Add.equals(driver.findElement(EDITED_LSTREAM_ORDER_BY).getText()) && Edited_RStreamName_Add.equals(driver.findElement(EDITED_RSTREAM_NAME_TXTBOX).getAttribute("value")) && Edited_RStreamTimeToLive_Add.equals(driver.findElement(EDITED_RSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value")) && Edited_RStreamKpis_Add.equals(driver.findElement(EDITED_RSTREAM_KPI_VALUE).getText()) && Edited_RStreamPartition_Add.equals(driver.findElement(EDITED_RSTREAM_PARTITION_KEY).getText()) && Edited_RStreamOrderby_Add.equals(driver.findElement(EDITED_RSTREAM_ORDER_BY).getText()) && EditedCostFun_add.equals(driver.findElement(EDITED_COST_FUNCTION).getText()) && EditedPairFun_add.equals(driver.findElement(EDITED_PAIR_FUNCTION).getText()));

        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && Edited_LStreamName_Add.equals(driver.findElement(EDITED_LSTREAM_NAME_TXTBOX).getAttribute("value")) &&
                Edited_LStreamTimeToLive_Add.equals(driver.findElement(EDITED_LSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value")) && Edited_LStreamKpis_Add.equals(driver.findElement(EDITED_LSTREAM_KPI_VALUE).getText()) && Edited_LStreamPartition_Add.equals(driver.findElement(EDITED_LSTREAM_PARTITION_KEY).getText()) && Edited_LStreamOrderby_Add.equals(driver.findElement(EDITED_LSTREAM_ORDER_BY).getText()) && Edited_RStreamName_Add.equals(driver.findElement(EDITED_RSTREAM_NAME_TXTBOX).getAttribute("value")) && Edited_RStreamTimeToLive_Add.equals(driver.findElement(EDITED_RSTREAM_TIMETOLIVE_TXTBOX).getAttribute("value")) && Edited_RStreamKpis_Add.equals(driver.findElement(EDITED_RSTREAM_KPI_VALUE).getText()) && Edited_RStreamPartition_Add.equals(driver.findElement(EDITED_RSTREAM_PARTITION_KEY).getText()) && Edited_RStreamOrderby_Add.equals(driver.findElement(EDITED_RSTREAM_ORDER_BY).getText()) && EditedCostFun_add.equals(driver.findElement(EDITED_COST_FUNCTION).getText()) && EditedPairFun_add.equals(driver.findElement(EDITED_PAIR_FUNCTION).getText())) {
            System.out.println("ValidEdited_Correlation_Name_Add Details");
        } else {
            Assert.fail("Stream Correlation process details are invalid");
        }
        waitForSecs(10);
        safeClick(DELETE_ALERT,"Delete Slas",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE,"Confirm delete",MEDIUMWAIT);
        waitForSecs(10);

    }


}