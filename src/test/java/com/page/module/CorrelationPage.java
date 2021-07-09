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
    String Name_Add, KPIS_add, KeyExp_add, StepName_Add, FeildExclusion_add, Name_Add1, Type_add, Genarator_add, Retention_add, Type_add1, Retension_Name_Add, Edited_Name_Add;
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
        //safeJavaScriptClearAndType(TXTBOX_RETENSION, "5000", "Name into textbox", MEDIUMWAIT);
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
       /* KeyExp_add = safeGetText(KEYEXP_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KeyExp_add);*/
        safeClick(LABEL_MASK, "Name Feild", MEDIUMWAIT);
        //safeJavaScriptClearAndType(TXTBOX_MASK, "2", "Name into textbox", MEDIUMWAIT);
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
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_EDITED_NAME);
        searchField.sendKeys(del + editBP1);
        Edited_Name_Add = safeGetAttribute(TXTBOX_EDITED_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_RETENSION, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_RETENSION);
        searchField1.sendKeys(del1 + "5000");
        Retension_Name_Add = safeGetAttribute(TXTBOX_RETENSION, "value", "Name textbox value", MEDIUMWAIT);

        safeClick(LABEL_KEYEXP, "Server Feild", MEDIUMWAIT);
        safeClick(KEYEXP_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KEYEXP, "node", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("node")) {

                dbs2.get(i).click();
                break;
            }
        }
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
}
