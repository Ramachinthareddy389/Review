package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.LocalProgramLocators;
import com.page.locators.ScriptLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ScriptPage extends SafeActions implements ScriptLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String EDITSCRIPT = "EDITSCRIPT" + " - " + random.nextInt(500);
    String SCRIPT = "SCRIPT" + "-" + random.nextInt(500);
    String script_add, server_Add, type_add, sla_add, script_Add, content_add;


    public ScriptPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SCRIPT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_SCRIPT, "Add button", MEDIUMWAIT);
    }

    public void addingScripts() {
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SCRIPT, "Name Textbox", MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEl_TYPE, "Type Label", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Type", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "bat", "Entering type", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("bat")) {

                dbs3.get(i).click();
                break;
            }
        }
        type_add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(type_add);
        safeClick(LABEL_CONTENT, "Server Feild", MEDIUMWAIT);
        safeClearAndType(CONTENT_TEXTAREA, "test", "Server name into textbox", MEDIUMWAIT);
        content_add = safeGetText(CONTENT_TEXTAREA, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "NExt button", MEDIUMWAIT);
        safeCheck(CHKBOX_RUNSCHEDULE, "Run Schedule checkbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Alert - raw - test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Alert - raw - test")) {

                dbs4.get(i).click();
                break;
            }
        }
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = SCRIPT;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
    }

    public void verifyingAddedScript() {
        if (server_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && type_add.equals(driver.findElement(TYPE_GHOSTTEXT).getText()))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editScriptConfigurationWindow(){
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
       // safeType(TXTBOX_SERVERNAME, EDITSCRIPT, "Name Textbox", MEDIUMWAIT);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del5 + EDITSCRIPT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEl_TYPE, "Type Label", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Type", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "PYTHON", "Entering type", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("PYTHON")) {

                dbs3.get(i).click();
                break;
            }
        }
        type_add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(type_add);
        safeClick(LABEL_CONTENT, "Server Feild", MEDIUMWAIT);
        String del6 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(CONTENT_TEXTAREA);
        searchField2.sendKeys(del5 + "test123");
        content_add = safeGetText(CONTENT_TEXTAREA, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
    }

    public void addinSLA(){
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SCRIPT, "Name Textbox", MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEl_TYPE, "Type Label", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Type", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "bat", "Entering type", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("bat")) {

                dbs3.get(i).click();
                break;
            }
        }
        type_add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(type_add);
        safeClick(LABEL_CONTENT, "Server Feild", MEDIUMWAIT);
        safeClearAndType(CONTENT_TEXTAREA, "test", "Server name into textbox", MEDIUMWAIT);
        content_add = safeGetText(CONTENT_TEXTAREA, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "NExt button", MEDIUMWAIT);
        safeCheck(CHKBOX_RUNSCHEDULE, "Run Schedule checkbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = SCRIPT;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeClick(USED_BY_ACTIONS_HYPERLINK,"Used by actions hyper link",MEDIUMWAIT);
    }

    public void verifyingAddedSLAsScriptWindow(){
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(TARGET_BY_SLA_ADD_ICON,"Add icon",MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(ACTION_SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(ACTION_SLA_TXTBOX, "Alert - raw - test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Alert - raw - test")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(ACTION_SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        Assert.assertEquals(sla_add, driver.findElement(HYPERLINK_SLAs).getText());
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }
}