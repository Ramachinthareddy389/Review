package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.HTTPLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
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
    String Engine="Engine"  + " - " + random.nextInt(500);
    String HttpName = "HttpTest" + random.nextInt(3000);
    String editKPi = "EditedKpis"+random.nextInt(3000);
    String action_Add,sla_add,path_Add,Request_add,content_add,node_add,engine_add,application_add,Server_Add;
    private WebDriver driver1;
    String DbTitle = "Hardware" + " - " + random.nextInt(500);
    String EditTitle = "Andriod" + " - " + random.nextInt(500);
    String HTTPScenario = "test"+"_"+random.nextInt(1000);

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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);

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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);

    }

    public void addingSLA(){
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Alert - raw - test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Alert - raw - test")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        Assert.assertEquals(sla_add,driver.findElement(HYPERLINK_SLAs).getText());
        safeClick(CLOSE_EDITWINDOW,"Edit window",MEDIUMWAIT);
        waitForSecs(15);
        String s= safeGetText(SLAVALUE_INHTTPPAGE,"SLA Value",MEDIUMWAIT);
        System.out.println(s);
        safeClick(SLAVALUE_INHTTPPAGE,"SLA",MEDIUMWAIT);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText= "Service Level Agreements";
        Assert.assertEquals(pageTitle, expectedText);
    }
    public void verifyinghttpPage(){
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
            Request_add + driver.findElement(TXTBOX_EDITED_TARGET_METHOD).getText() +content_add + driver.findElement(TXTBOX_EDITED_TARGET_CONTENT_TYPE).getText()+ sla_add + driver.findElement(HYPERLINK_SLAs).getText());
       if (action_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && path_Add.equals(driver.findElement(TXTBOX_EDITED_TARGET_PATH).getAttribute("value")) &&
               Request_add.equals(driver.findElement(TXTBOX_EDITED_TARGET_METHOD).getText()) && content_add.equals(driver.findElement(TXTBOX_EDITED_TARGET_CONTENT_TYPE).getText())&& sla_add.equals(driver.findElement(HYPERLINK_SLAs).getText()))
       {
            System.out.println("KPIs details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);


        } else {
            Assert.fail("KPIs details are invalid");
        }
       safeClick(CLOSE_EDITWINDOW,"Closing window",MEDIUMWAIT);
    }

    public void verifyingAddedSLAInHTTP(){
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
        safeClick(SLA_ADD_ICON,"SLA Add icon",MEDIUMWAIT);
    }
    public void configuringNodeInAPMModule() {
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(NODES_TAB, "Nodes Tab", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_HOSTNAME_NODE, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void configuringEnginesInAPMModule() {
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(ENGINES_ADDICON, " Engine Add Icon", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABLE_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Engine, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_SHOW_ADVANCED,"Show advanced");
        safeClick(LABEL_MONITORED_SERVER, "Monitored Server", MEDIUMWAIT);
        safeClick(MONITORED_SERVER_GHOSTEXT, "Monitored Server host text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONITORED, DbTitle, "Monitored name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equals(DbTitle)) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public  void addingHttpScenario(){
            safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
            safeClick(BTN_HTTP, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
            safeClick(BTN_ADDICON_HTTP_SCENARIOS,"Http scenarios",MEDIUMWAIT);
            safeClick(LABEL_HTTPSCENARIO,"Http scenario label",MEDIUMWAIT);
            safeClick(LABEL_NAME,"MOonitor name",MEDIUMWAIT);
            safeType(TXTBOX_NAME,HTTPScenario,"Scenario",MEDIUMWAIT);
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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME,"Clickinng servername",MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME,"Http Request","Entering value",MEDIUMWAIT);
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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_THRESHOLD_SLA,"MOonitor name",MEDIUMWAIT);
        safeType(TXTBOX_SLA_THRESHOLD,"5","Threshold value",MEDIUMWAIT);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "QA Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs6.get(i).getText().equals("QA Alert")) {

                dbs6.get(i).click();
                break;
            }
        }
        waitForSecs(20);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);

    }

    public void verifyingHttpScenario(){
        safeType(TEXTBOX_TYPESEARCH, HTTPScenario + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(SCENARIO_TARGET_ICON,"Scenario add icon",MEDIUMWAIT);
        safeClick(LABEL_HTTPSCENARIO_TARGET,"Http scenario label",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_NAME,"Clickinng servername",MEDIUMWAIT);
        safeType(TXTBOX_NAME,"Http Request","Entering value",MEDIUMWAIT);
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
        waitForSecs(20);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }


    public void addingHTTPScenarioUsingharFile() throws InterruptedException, AWTException {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HTTP, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_HTTP_SCENARIOS,"Http scenarios",MEDIUMWAIT);
        safeClick(LABEL_HTTPSCENARIO_HAR_FILE,"Http scenario label",MEDIUMWAIT);
        safeClick(LABEL_NAME,"MOonitor name",MEDIUMWAIT);
        safeType(TXTBOX_NAME,HTTPScenario,"Scenario",MEDIUMWAIT);
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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_IMPORT,"Next button",MEDIUMWAIT);
        StringSelection sel = new StringSelection("C:\\Users\\rama.chinthareddy\\OneDrive - ZenQ\\Desktop\\www.google.com (1).har");
        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        System.out.println("selection" +sel);
        // This will scroll down the page
        JavascriptExecutor js = (JavascriptExecutor)driver;
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
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_THRESHOLD_SLA,"MOonitor name",MEDIUMWAIT);
        safeType(TXTBOX_SLA_THRESHOLD,"5","Threshold value",MEDIUMWAIT);
        safeClick(LABEL_ACTIONS, "Server Feild", MEDIUMWAIT);
        safeClick(ACTIONS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ACTIONS, "QA Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs6.get(i).getText().equals("QA Alert")) {

                dbs6.get(i).click();
                break;
            }
        }
        waitForSecs(20);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }
    }




