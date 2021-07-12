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
    String Correlation_Name_Add, Correlation_LStream_Add, TimeToLive_LStream_add, Lstream_KPIS_add,Lstream_PartitionKey_add,Lstream_OrderKey_add;
    String Correlation_RStream_Add, TimeToLive_RStream_add, Rstream_KPIS_add, Rstream_PartitionKey_add, Rstream_OrderKey_add,CostFun_add,PairFun_add;

    Random random = new Random();
    String dname = "BP";
    String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    String editBP1 = editBP + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);

    //Constructor to define/call methods
    public CorrelationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnCorrelation() {
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_CORRELATION, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingNewCorrelation() {
        safeClick(BTN_ADDICON_CORRELATION, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(LABEL_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "Alert Event", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Alert Event")) {

                dbs1.get(i).click();
                break;
            }
        }
        Type_add = safeGetText(TYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Type_add);
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
        safeClearAndType(TXTBOX_KPIS, "ActiveMQ Heap Usage", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("ActiveMQ Heap Usage")) {

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
        safeClearAndType(TXTBOX_KEYEXP, "bucket", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("bucket")) {

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
        waitForSecs(9);
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
    }


    public void editCorrelationConfig() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
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
    }


    public void verifyingTypesInCorrelationScenarioWindow() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVETYPES, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
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
    }


    public void validatingEditTypeinEditCorrelationScenariowindow()
    {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String beforeEdit =  driver.findElement(TXTBOX_EDITED_FACTTYPE).getText();
        System.out.println(beforeEdit);
        expectedText = "AlertEvent" ;
        Assert.assertEquals(beforeEdit,expectedText);
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
        After_Edit_Type= safeGetText(TYPE_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(After_Edit_Type);
       String expectedTextAfterEdit ="FactCounter";
       Assert.assertEquals(After_Edit_Type,expectedTextAfterEdit);
    }

    public void AddingCorrrlationStreamPage(){
        safeClick(BTN_ADDICON_STREAM_CORRELATION, "Add button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, "Correlation", "Name into textbox", MEDIUMWAIT);
        Correlation_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Correlation_Name_Add);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
    }

    public void AddingLeftStreamPage(){
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
        safeClearAndType(TXTBOX_KPIS, "0 KPI Threshold", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("0 KPI Threshold")) {

                dbs2.get(i).click();
                break;
            }
        }
        Lstream_KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Lstream_KPIS_add);

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

        safeClick(LABEL_ORDER_BY, "Server Feild", MEDIUMWAIT);
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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);

    }

    public void AddingRightStreamPage(){
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

        safeClick(LABEL_RSTREAM_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_KPIS_RSTREAM, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(DROPDOWN_KPIS_RSTREAM, "0 KPI Threshold", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("0 KPI Threshold")) {

                dbs2.get(i).click();
                break;
            }
        }
        Rstream_KPIS_add = safeGetText(RSTREAM_KPIS_VALUE, "Server textbox value", MEDIUMWAIT);
        System.out.println(Rstream_KPIS_add);

        safeClick(LABEL_PARTITION_KEY, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_PARTITION_KEY, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(DROPDOWN_PARTITION_KEY, "bucket", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("bucket")) {

                dbs3.get(i).click();
                break;
            }
        }
        Rstream_PartitionKey_add = safeGetText(GHOSTTEXT_PARTITION_KEY, "Server textbox value", MEDIUMWAIT);
        System.out.println(Rstream_PartitionKey_add);

        safeClick(LABEL_ORDER_BY, "Server Feild", MEDIUMWAIT);
        safeClick(GHOSTTEXT_ORDER_BY, "Server textbox", MEDIUMWAIT);
        safeClearAndType(DROPDOWN_ORDER_BY, "bucket", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("bucket")) {

                dbs4.get(i).click();
                break;
            }
        }
        Rstream_OrderKey_add = safeGetText(GHOSTTEXT_PARTITION_KEY, "Server textbox value", MEDIUMWAIT);
        System.out.println(Rstream_OrderKey_add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
    }

    public void AddingStreamFunction()
    {
        safeClick(TEXT_AREA_COST_FUNCTION, "Metric Exp", MEDIUMWAIT);
        WebElement metric = driver.findElement(TEXT_AREA_COST_FUNCTION);
        metric.sendKeys("test");
        CostFun_add = safeGetText(ADDED_NAME_GENERATOR, "Server textbox value", MEDIUMWAIT);
        System.out.println(CostFun_add);

        safeClick(TEXT_AREA_PAIR_FUNCTION, "Metric Exp", MEDIUMWAIT);
        WebElement pair = driver.findElement(TEXT_AREA_PAIR_FUNCTION);
        pair.sendKeys("pair1");
         PairFun_add = safeGetText(ADDED_NAME_GENERATOR, "Server textbox value", MEDIUMWAIT);
        System.out.println(PairFun_add);
        safeClick(BTN_FINISH,"Finish Button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void  verifyingAddedStreamCorrelationScenarios()
    {
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
        System.out.println(Name_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + KPIS_add + driver.findElement(TXTBOX_EDITED_KPIS).getText() +
                Retention_add + driver.findElement(TXTBOX_EDITED_RETENTION).getAttribute("value") + Type_add1 + driver.findElement(TXTBOX_EDITED_FACTTYPE).getText() + Name_Add1 + driver.findElement(HYPERLINK_TYPES).getText());
        /*if (Name_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && KPIS_add.equals(driver.findElement(TXTBOX_EDITED_KPIS).getText()) &&
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
    }*/
    }
}
