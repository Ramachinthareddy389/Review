package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.DBInstancesLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class DBInstancesPage extends SafeActions implements DBInstancesLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Name_Add, DatabaseName_Add, InstanceName_Add, Port_Add, Server_Add, Vendor_add;
    String DbTitle = dashBoardData.ticketTitle
            + " - " + random.nextInt(500);

    public DBInstancesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnDbInstances() {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DBINSTANCES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingNewDbinstances() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, "Dbinstancename", "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEL_SERVER, "Server Feild", MEDIUMWAIT);
        safeClick(SERVER_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SERVER, "Oracle Database Server", "Server name into textbox", MEDIUMWAIT);

        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);

        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Oracle Database Server")) {

                dbs1.get(i).click();
                break;
            }
        }
        Server_Add = safeGetText(SERVER_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        safeClick(LABEL_VENDOR_NAME, "Vendor Feild", MEDIUMWAIT);
        safeClick(VENDOR_NAME_GHOSTTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_VENDOR_NAME, "ORACLE", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db.size());
        for (int i = 0; i < db.size(); i++) {

            if (db.get(i).getText().equals("ORACLE")) {

                db.get(i).click();
                break;
            }
        }
        String vendor = safeGetText(VENDOR_NAME_GHOSTTEXT, "Name textbox value", MEDIUMWAIT);
        String vendor1 = vendor.toLowerCase() + " " + "DB";
        Vendor_add = vendor1.replaceFirst("o", "O");
        System.out.println(vendor);
        System.out.println("Before adding db :" + Vendor_add);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_PORTNUMBER, "Port number feild", MEDIUMWAIT);
        safeType(TXTBOX_PORTNUMBER, "5040", "Portnumber", MEDIUMWAIT);
        Port_Add = safeGetAttribute(TXTBOX_PORTNUMBER, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEL_DATABASENAME, "Dabase name Feild", MEDIUMWAIT);
        safeType(TXTBOX_DATABASENAME, "Oracle", "Database");
        DatabaseName_Add = safeGetAttribute(TXTBOX_DATABASENAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEL_INSTANCENAME, "Instance Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_INSTANCENAME, "Instance", "Instance Name", MEDIUMWAIT);
        InstanceName_Add = safeGetAttribute(TXTBOX_INSTANCENAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void verifyingDbInstanceNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = "Dbinstancename";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && DatabaseName_Add.equals(driver.findElement(TXTBOX_DATABASENAME).getAttribute("value")) &&
                InstanceName_Add.equals(driver.findElement(TXTBOX_INSTANCENAME).getAttribute("value")) && Port_Add.equals(driver.findElement(TXTBOX_PORTNUMBER).getAttribute("value")) &&
                Vendor_add.equals(driver.findElement(VENDOR_NAME_GHOSTTEXT).getText()) && Server_Add.equals(driver.findElement(SERVER_GHOSTEXT).getText())) {
            System.out.println("Ticket details are valid");
            String text = driver.findElement(TXTBOX_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_NAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_DATABASENAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(TXTBOX_INSTANCENAME).getAttribute("value") + " Port: " + driver.findElement(TXTBOX_PORTNUMBER).getAttribute("value") +
                    " Vendor: " + driver.findElement(VENDOR_NAME_GHOSTTEXT).getText() + "Server Name :" + driver.findElement(SERVER_GHOSTEXT).getText());
        } else {
            Assert.fail("Ticket details are invalid");
        }
        safeClick(CLOSE_EDITWINDOW,"Edit window",MEDIUMWAIT);
    }

    public void ediingConfiguration() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(TXTBOX_NAME, "Name textbox", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + "test" + 123);
        waitForSecs(5);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, "test123" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String EditedText = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(EditedText);
        Assert.assertEquals(EditedText, "test123");
    }
}
