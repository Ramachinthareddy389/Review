package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.HTTPLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class HTTPPage extends SafeActions implements HTTPLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String NodeJS = "NodeJs" + " - " + random.nextInt(500);
    String NodeAPM = "NodeAPM"+ random.nextInt(500);
    String Engine = "Engine" + " - " + random.nextInt(500);
    String HttpName = "HttpTest" + random.nextInt(3000);
    String editKPi = "EditedKpis" + random.nextInt(3000);
    String action_Add, sla_add, path_Add, Request_add, content_add, node_add, engine_add, application_add, Server_Add;
    private WebDriver driver1;
    String DbTitle = "Hardware" + " - " + random.nextInt(500);
    String EditTitle = "Andriod" + " - " + random.nextInt(500);
    String HTTPScenario = "test" + "_" + random.nextInt(1000);
    String test = "test"+ random.nextInt(1000);

    public HTTPPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HTTP, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_HTTP, "Add button", MEDIUMWAIT);
    }

    public void addingHTTPPage() {
        safeClick(LABEL_ACTIONS_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_ACTIONS_NAME, HttpName, "Name into textbox", MEDIUMWAIT);
        action_Add = safeGetAttribute(TXTBOX_ACTIONS_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(action_Add);
        safeClick(BTN_SHOWADVANCED,"Show advanced",MEDIUMWAIT);
        safeType(TXTBOX_EXECOUNT,"1","Execution count textbox",MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_PATH, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PATH, "Path Name", "Name into textbox", MEDIUMWAIT);
        path_Add = safeGetAttribute(TXTBOX_PATH, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(path_Add);
        safeClick(LABEL_REQUEST_METHOD, "Server Feild", MEDIUMWAIT);
        safeClick(REQUEST_METHOD_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_REQUEST_METHOD, "FORM", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("FORM")) {

                dbs1.get(i).click();
                break;
            }
        }
        Request_add = safeGetText(REQUEST_METHOD_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Request_add);
        safeClick(LABEL_CONTENT_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(CONTENT_TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CONTENT_TYPE, "application/json", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs2.get(i).getText().equals("application/json")) {

                dbs2.get(i).click();
                break;
            }
        }
        content_add = safeGetText(CONTENT_TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void addingSLA() {
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Native User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Native User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        Assert.assertEquals(sla_add, driver.findElement(HYPERLINK_SLAs).getText());
        waitForSecs(9);
        safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
        waitForSecs(15);
        String s = safeGetText(SLAVALUE_INHTTPPAGE, "SLA Value", MEDIUMWAIT);
        System.out.println(s);
        safeClick(SLAVALUE_INHTTPPAGE, "SLA", MEDIUMWAIT);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = "Service Level Agreements";
        Assert.assertEquals(pageTitle, expectedText);
    }

    public void verifyinghttpPage() {
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = HttpName;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);

        System.out.println(action_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + path_Add + driver.findElement(TXTBOX_EDITED_TARGET_PATH).getAttribute("value") +
                Request_add + driver.findElement(TXTBOX_EDITED_TARGET_METHOD).getText() + content_add + driver.findElement(TXTBOX_EDITED_TARGET_CONTENT_TYPE).getText() );
        if (action_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && path_Add.equals(driver.findElement(TXTBOX_EDITED_TARGET_PATH).getAttribute("value")) &&
                Request_add.equals(driver.findElement(TXTBOX_EDITED_TARGET_METHOD).getText()) && content_add.equals(driver.findElement(TXTBOX_EDITED_TARGET_CONTENT_TYPE).getText())) {
            System.out.println("KPIs details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);


        } else {
            Assert.fail("KPIs details are invalid");
        }
        safeClick(CLOSE_EDITWINDOW, "Closing window", MEDIUMWAIT);
    }

    public void verifyingAddedSLAInHTTP() {
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(15);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = HttpName;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(15);
        safeClick(BTN_SHOW_ADVANCED,"Show advanced button",MEDIUMWAIT);
        safeClick(SLA_ADD_ICON, "SLA Add icon", MEDIUMWAIT);
    }

    public void configuringNodeInAPMModule() {
/*        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(NODES_TAB, "Nodes Tab", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);*/
        waitForSecs(10);
        safeClick(NODE_ADD_ICON,"Node Add icon");
        //safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        safeClearAndType(NODE_NAME, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(NODE_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeClearAndType(TXTBOX_HOSTNAME_NODE, NodeAPM, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void configuringEnginesInAPMModule() {
  /*      waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);*/
        safeClick(ENGINE_ADD_ICON, " Engine Add Icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ENGINE_NODE_ADD_ICON,"engines",MEDIUMWAIT);
        safeClearAndType(ENGINE_NODE_NAME, test, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(ENGINE_NODE_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeClearAndType(TXTBOX_HOSTNAME_NODE, test, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        safeClearAndType(NODE_NAME, Engine, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(NODE_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(1).click();
        driver.findElements(BTN_NEXT).get(1).click();
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void addingHttpScenario() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HTTP, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_HTTP_SCENARIOS, "Http scenarios", MEDIUMWAIT);
        safeClick(LABEL_HTTPSCENARIO, "Http scenario label", MEDIUMWAIT);
        safeClick(LABEL_NAME, "MOonitor name", MEDIUMWAIT);
        safeType(TXTBOX_NAME, HTTPScenario, "Scenario", MEDIUMWAIT);
        configuringNodeInAPMModule();
        configuringEnginesInAPMModule();
       /* waitForSecs(10);
        safeClick(LABEL_MONITORING_NODE, "Server Feild", MEDIUMWAIT);
        safeClick(MONITORING_NODE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONITORING_NODE, NodeJS, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals(NodeJS)) {

                dbs2.get(i).click();
                break;
            }
        }
        node_add = safeGetText(MONITORING_NODE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_ENGINE, "Server Feild", MEDIUMWAIT);
        safeClick(ENGINE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ENGINE, Engine, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals(Engine)) {

                dbs3.get(i).click();
                break;
            }
        }
        engine_add = safeGetText(ENGINE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        waitForSecs(10);*/
        safeClick(LABEL_APPLICATION_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(APPLICATION_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_APPLICATION_NAME, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Android")) {

                dbs4.get(i).click();
                break;
            }
        }
        application_add = safeGetText(APPLICATION_NAME_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClearAndType(TXTBOX_HOSTNAME, "httptest", "Enteering http value", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_SERVERNAME, "Clickinng servername", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, "Http Request", "Entering value", MEDIUMWAIT);
        safeClick(LABEL_PATH, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PATH, "Path Name", "Name into textbox", MEDIUMWAIT);
        path_Add = safeGetAttribute(TXTBOX_PATH, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(path_Add);
        safeClick(LABEL_REQUEST_METHOD, "Server Feild", MEDIUMWAIT);
        safeClick(REQUEST_METHOD_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_REQUEST_METHOD, "CONNECT", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("CONNECT")) {

                dbs1.get(i).click();
                break;
            }
        }
        Request_add = safeGetText(REQUEST_METHOD_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Request_add);

        safeClick(LABEL_CONTENT_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(CONTENT_TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CONTENT_TYPE, "application/json", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs5.get(i).getText().equals("application/json")) {

                dbs5.get(i).click();
                break;
            }
        }
        content_add = safeGetText(CONTENT_TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_THRESHOLD_SLA,"MOonitor name",MEDIUMWAIT);
        safeType(TXTBOX_SLA_THRESHOLD,"5","Threshold value",MEDIUMWAIT);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "QA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs6.size(); i++) {

            if (dbs6.get(i).getText().equals("QA")) {

                dbs6.get(i).click();
                break;
            }
        }
        waitForSecs(20);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void verifyingHttpScenario() {
        safeType(TEXTBOX_TYPESEARCH, HTTPScenario + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(SCENARIO_TARGET_ICON, "Scenario add icon", MEDIUMWAIT);
        safeClick(LABEL_HTTPSCENARIO_TARGET, "Http scenario label", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Clickinng servername", MEDIUMWAIT);
        safeType(TXTBOX_NAME, "Http Request", "Entering value", MEDIUMWAIT);
        safeClick(LABEL_PATH, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PATH, "Path Name", "Name into textbox", MEDIUMWAIT);
        path_Add = safeGetAttribute(TXTBOX_PATH, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(path_Add);
        safeClick(LABEL_REQUEST_METHOD, "Server Feild", MEDIUMWAIT);
        safeClick(REQUEST_METHOD_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_REQUEST_METHOD, "FORM", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("FORM")) {

                dbs1.get(i).click();
                break;
            }
        }
        Request_add = safeGetText(REQUEST_METHOD_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Request_add);

        safeClick(LABEL_CONTENT_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(CONTENT_TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CONTENT_TYPE, "application/json", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs5.get(i).getText().equals("application/json")) {

                dbs5.get(i).click();
                break;
            }
        }
        content_add = safeGetText(CONTENT_TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void addingHttpScenarioUsinharFile() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HTTP, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_HTTP_SCENARIOS, "Http scenarios", MEDIUMWAIT);
        safeClick(LABEL_HTTPSCENARIO_HAR_FILE, "Http scenario label", MEDIUMWAIT);
    }

    public void addingHTTPScenarioUsingharFile() throws InterruptedException, AWTException {
        safeClick(LABEL_NAME, "MOonitor name", MEDIUMWAIT);
        safeType(TXTBOX_NAME, HTTPScenario, "Scenario", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_MONITORING_NODE, "Server Feild", MEDIUMWAIT);
        safeClick(MONITORING_NODE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONITORING_NODE, NodeJS, "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals(NodeJS)) {

                dbs2.get(i).click();
                break;
            }
        }
        node_add = safeGetText(MONITORING_NODE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_ENGINE, "Server Feild", MEDIUMWAIT);
        safeClick(ENGINE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ENGINE, Engine, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals(Engine)) {

                dbs3.get(i).click();
                break;
            }
        }
        engine_add = safeGetText(ENGINE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_APPLICATION_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(APPLICATION_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_APPLICATION_NAME, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Android")) {

                dbs4.get(i).click();
                break;
            }
        }
        application_add = safeGetText(APPLICATION_NAME_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_IMPORT, "Next button", MEDIUMWAIT);
        StringSelection sel = new StringSelection("C:\\Users\\rama.chinthareddy\\OneDrive - ZenQ\\Desktop\\www.google.com (1).har");
        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        System.out.println("selection" + sel);
        // This will scroll down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,350)");
        Thread.sleep(5000);

        System.out.println("Browse button clicked");

        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);
        // Press Enter
        // robot.keyPress(KeyEvent.VK_ENTER);
        // Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);
        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        // Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_THRESHOLD_SLA, "MOonitor name", MEDIUMWAIT);
        safeType(TXTBOX_SLA_THRESHOLD, "5", "Threshold value", MEDIUMWAIT);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "user-login-report", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs6.get(i).getText().equalsIgnoreCase("user-login-report")) {

                dbs6.get(i).click();
                break;
            }
        }
        waitForSecs(20);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingPageIcons() {
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
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
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = HttpName + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        waitForSecs(25);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EDIT, "Edit button", MEDIUMWAIT);
        boolean editTitle = isElementDisplayed(EDIT_HEADER);
        Assert.assertTrue(editTitle);
        List<WebElement> chkboxes = driver.findElements(CHEKBOXES_EDITWINDOW);
        for (int i = 0; i <= chkboxes.size() - 1; i++) {
            chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    public void applyingFiltersInHttpPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + HttpName + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, HttpName);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void VerifyIconsInHttpActionsEditConfigwindow()
    {
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + HttpName + " - Cloned']");
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
    public void viewDataWithFeildsForViewIcon(String sla) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + HttpName + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_SHOW_ADVANCED,"Show advanced button",MEDIUMWAIT);
        safeClick(SLA_ADD_ICON, "SLA Add icon", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Native User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("Native User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla1 = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla1);
        String[] parts = sla1.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        Assert.assertEquals(sla_add, driver.findElement(HYPERLINK_SLAs).getText());
        waitForSecs(9);
        safeClick(HYPERLINK_SLAs, "Added BP Steps", MEDIUMWAIT);
        waitForSecs(10);
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
        waitForSecs(10);
        if(driver.findElement((BTN_SAVE)).isEnabled()==false) {
            safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        }
        waitForSecs(10);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        waitForSecs(5);
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
        safeClick(CLOSE_ICON, "Closing window");
        waitForSecs(10);
        try{
            if(isElementEnabled(BTN_SAVE)) {
                safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
            }
        }
        catch (Exception e)
        {
            System.out.println("Save button is not displaying");
        }

        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(5);
    }
}




