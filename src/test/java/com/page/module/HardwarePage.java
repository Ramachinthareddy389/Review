package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.HardwareLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

public class HardwarePage extends SafeActions implements HardwareLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Server_Add, Type_add, OSFamily_add, Host_Add, OSName_add, Environment_add, Hostmachine_add, software_add;
    String DbTitle = "Hardware" + " - " + random.nextInt(500);
    String EditTitle = "Andriod" + " - " + random.nextInt(500);
    String NodeJS = "NodeJs" + " - " + random.nextInt(500);
    String NodeAPM = "NodeJs" + random.nextInt(500);
    String Engine = "Engine" + " - " + random.nextInt(500);
    String WebUXAgent = "WebUXAgent" + " - " + random.nextInt(500);

    public HardwarePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnHardware() {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HARDWARE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);

    }

    public void addingNewHardware(String Hostname) {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_SERVERNAME, DbTitle, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_ENVIRONMENT, "Server Feild", MEDIUMWAIT);
        safeClick(ENVIRONMENT_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ENVIRONMENT, "Default", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Default")) {

                dbs1.get(i).click();
                break;
            }
        }
        Environment_add = safeGetText(ENVIRONMENT_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Environment_add);
        safeClick(LABEL_TYPE, "Vendor Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "Web Server", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db.size());
        for (int i = 0; i < db.size(); i++) {

            if (db.get(i).getText().equals("Web Server")) {

                db.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        Type_add = safeGetText(TYPE_GHOSTTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(Type_add);
        safeClick(LABEL_HOSTNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_HOSTNAME, Hostname, "Name into textbox", MEDIUMWAIT);
        Host_Add = safeGetAttribute(TXTBOX_HOSTNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Host_Add);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_OSFAMILY, "Vendor Feild", MEDIUMWAIT);
        safeClick(OSFAMILY_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_OSFAMILY, "ANDROID", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equalsIgnoreCase("ANDROID")) {

                db1.get(i).click();
                break;
            }
        }
        OSFamily_add = safeGetText(OSFAMILY_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSFamily_add);
        safeClick(LABEL_OSNAME, "Vendor Feild", MEDIUMWAIT);
        safeClick(OSNAME_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_OSNAME, "Linux", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equalsIgnoreCase("Linux")) {

                db2.get(i).click();
                break;
            }
        }
        OSName_add = safeGetText(OSNAME_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSName_add);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void verifyingHardwareNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, DbTitle);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = DbTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        System.out.println(Server_Add.equals(driver.findElement(TXTBOX_EDITED_SERVERNAME).getAttribute("value")));
        System.out.println(Host_Add.equals(driver.findElement(TXTBOX_EDITED_HOSTNAME).getAttribute("value")));
     //   System.out.println(OSName_add.equals(driver.findElement(TXTBOX_EDITED_OSNAME).getText()));
        System.out.println(Environment_add.equals(driver.findElement(TXTBOX_EDITED_ENVIRON).getText()));
        System.out.println(OSFamily_add.equals(driver.findElement(TXTBOX_EDITED_OSFAMILY).getText()));
        System.out.println(Type_add.equals(driver.findElement(TXTBOX_EDITED_TYPE).getText()));

        if (Server_Add.equals(driver.findElement(TXTBOX_EDITED_SERVERNAME).getAttribute("value")) && Host_Add.equals(driver.findElement(TXTBOX_EDITED_HOSTNAME).getAttribute("value")) &&
                Environment_add.equals(driver.findElement(TXTBOX_EDITED_ENVIRON).getText()) && Type_add.equals(driver.findElement(TXTBOX_EDITED_TYPE).getText()) &&
              OSFamily_add.equals(driver.findElement(TXTBOX_EDITED_OSFAMILY).getText())) {
            System.out.println("Ticket details are valid");
            String text = driver.findElement(TXTBOX_EDITED_SERVERNAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_EDITED_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_EDITED_HOSTNAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(TXTBOX_EDITED_ENVIRON).getText() + " Port: " + driver.findElement(TXTBOX_EDITED_TYPE).getText() +
                    " Vendor: " + driver.findElement(TXTBOX_EDITED_OSNAME).getText() + "Server Name :" + driver.findElement(TXTBOX_EDITED_OSFAMILY).getText());
        } else {
            Assert.fail("Ticket details are invalid");
        }
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }

    public void ediingConfiguration() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del + EditTitle);
        waitForSecs(5);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
   /*     safeClick(LABEL_ENVIRONMENT, "Server Feild", MEDIUMWAIT);
        safeClick(ENVIRONMENT_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ENVIRONMENT, "Lab", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Create"+"Lab")) {

                dbs1.get(i).click();
                break;
            }
        }
        Environment_add = safeGetText(ENVIRONMENT_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Environment_add);*/
        waitForSecs(10);
        safeClick(LABEL_TYPE, "Vendor Feild", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "Unknown", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db.size());
        for (int i = 0; i < db.size(); i++) {

            if (db.get(i).getText().equalsIgnoreCase("Unknown")) {

                db.get(i).click();
                break;
            }
        }
        Type_add = safeGetText(TYPE_GHOSTTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(Type_add);
        waitForSecs(5);
        safeClick(EDITLABEL_HOSTNAME, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_HOSTNAME);
        searchField1.sendKeys(del1 + EditTitle);
        waitForSecs(5);
        Host_Add = safeGetAttribute(TXTBOX_HOSTNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Host_Add);
        safeClick(LABEL_OSFAMILY, "Vendor Feild", MEDIUMWAIT);
        safeClick(OSFAMILY_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_OSFAMILY, "IOS", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equalsIgnoreCase("IOS")) {

                db1.get(i).click();
                break;
            }
        }
        OSFamily_add = safeGetText(OSFAMILY_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSFamily_add);
      /*  safeClick(LABEL_OSNAME, "Vendor Feild", MEDIUMWAIT);
        safeClick(OSNAME_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_OSNAME, "Linux", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equals("Linux")) {

                db2.get(i).click();
                break;
            }
        }
        OSName_add = safeGetText(OSNAME_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSName_add);*/
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, EditTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String EditedText = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(EditedText);
        Assert.assertEquals(EditedText, EditTitle);
    }


    public void verifyingEditedHardwareNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, EditTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, EditTitle);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = EditTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Server_Add.equals(driver.findElement(TXTBOX_EDITED_SERVERNAME).getAttribute("value")) && Host_Add.equals(driver.findElement(TXTBOX_HOSTNAME).getAttribute("value")) &&
              Type_add.equals(driver.findElement(TYPE_GHOSTTEXT).getText()) && OSFamily_add.equals(driver.findElement(OSFAMILY_GHOSTEXT).getText())) {
            System.out.println("Ticket details are valid");
            String text = driver.findElement(TXTBOX_EDITED_SERVERNAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_HOSTNAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(ENVIRONMENT_GHOSTEXT).getText() + " Port: " + driver.findElement(TYPE_GHOSTTEXT).getText() +
                    " Vendor: " + driver.findElement(OSNAME_GHOSTEXT).getText() + "Server Name :" + driver.findElement(OSFAMILY_GHOSTEXT).getText());
        } else {
            Assert.fail("Ticket details are invalid");
        }
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }

    public void addingLocalMonitoringAgentsUsingJVMAgentInEditConfiguration() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, DbTitle);
        safeClick(LOCALAGENTADDICON, "Local agent icon", MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(LOCALAGENTMONITORINGDROPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equalsIgnoreCase("JVM (Java, etc) Agent")) {

                db2.get(i).click();
                break;
            }
        }
        safeClick(LABEL_SOFTWARE, "Vendor Feild", MEDIUMWAIT);
        safeClick(SOFTWARE_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SOFTWARE, "Android", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equalsIgnoreCase("Android")) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(LABEL_AGENT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_LABEL_AGENT, DbTitle, "Entering the label name", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        By ADDEDAGENT_LABEL = By.xpath("//h4[text()='Local Monitoring Agents:']//../div/ul/li/mark[contains(text(),'" + DbTitle + "')]");
        boolean Monitoring_Agents = driver.findElement(ADDEDAGENT_LABEL).isDisplayed();
        System.out.println(Monitoring_Agents);
        Assert.assertTrue(Monitoring_Agents);
        String label = "germain.apm.monitoringAgents";
        By ADDEDREFERENCES_LABEl = By.xpath("//button[@aria-label='" + label + '(' + DbTitle + ')' + "']");
        boolean Monitoring_Agents_Ref = driver.findElement(ADDEDREFERENCES_LABEl).isDisplayed();
        System.out.println(Monitoring_Agents_Ref);
        Assert.assertTrue(Monitoring_Agents_Ref);
        waitForSecs(5);


    }


    public void addingLocalMonitoringAgentsUsingNodeJSInEditConfiguration() {
        safeClick(LOCALAGENTADDICON, "Local agent icon", MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(LOCALAGENTMONITORINGDROPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equalsIgnoreCase("NodeJS")) {

                db2.get(i).click();
                break;
            }
        }
        safeClick(LABEL_SOFTWARE, "Vendor Feild", MEDIUMWAIT);
        safeClick(SOFTWARE_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SOFTWARE, "Android", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equalsIgnoreCase("Android")) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(LABEL_AGENT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_LABEL_AGENT, NodeJS, "Entering the label name", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        By ADDEDAGENT_LABEL = By.xpath("//h4[text()='Local Monitoring Agents:']//../div/ul/li[contains(text(),'" + NodeJS + "')]");
        boolean Monitoring_Agents = driver.findElement(ADDEDAGENT_LABEL).isDisplayed();
        System.out.println(Monitoring_Agents);
        Assert.assertTrue(Monitoring_Agents);
        String label = "germain.apm.monitoringAgents";
        By ADDEDREFERENCES_LABEl = By.xpath("//button[@aria-label='" + label + '(' + NodeJS + ')' + "']");
        boolean Monitoring_Agents_Ref = driver.findElement(ADDEDREFERENCES_LABEl).isDisplayed();
        System.out.println(Monitoring_Agents_Ref);
        Assert.assertTrue(Monitoring_Agents_Ref);
    }

    public void addingLocalMonitoringAgentsUsingWebUXAgentInEditConfiguration() {
        safeClick(LOCALAGENTADDICON, "Local agent icon", MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(LOCALAGENTMONITORINGDROPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equalsIgnoreCase("Web UX Agent")) {

                db2.get(i).click();
                break;
            }
        }
        safeClick(LABEL_SOFTWARE, "Vendor Feild", MEDIUMWAIT);
        safeClick(SOFTWARE_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SOFTWARE, "Android", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equalsIgnoreCase("Android")) {

                db1.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(LABEL_AGENT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_LABEL_AGENT, WebUXAgent, "Entering the label name", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(15);
        By ADDEDAGENT_LABEL = By.xpath("//h4[text()='Local Monitoring Agents:']//../div/ul/li[contains(text(),'" + WebUXAgent + "')]");
        boolean Monitoring_Agents = driver.findElement(ADDEDAGENT_LABEL).isDisplayed();
        //String Monitoring_Agents=safeGetText(ADDEDAGENT_LABEL,"Added Local Monitoring Agents",MEDIUMWAIT);
        System.out.println(Monitoring_Agents);
        Assert.assertTrue(Monitoring_Agents);
        String label = "germain.apm.monitoringAgents";
        By ADDEDREFERENCES_LABEl = By.xpath("//button[@aria-label='" + label + '(' + WebUXAgent + ')' + "']");
        boolean Monitoring_Agents_Ref = driver.findElement(ADDEDREFERENCES_LABEl).isDisplayed();
        System.out.println(Monitoring_Agents_Ref);
        Assert.assertTrue(Monitoring_Agents_Ref);
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }

    public void configuringNodeInAPMModule() {
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(NODES_TAB, "Nodes Tab", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_EDITED_SERVERNAME, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_EDITED_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_HOSTNAME_NODE, NodeAPM, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void configuringEnginesInAPMModule() {
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, NodeJS);
        safeClick(ENGINES_ADDICON, " Engine Add Icon", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABLE_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Engine, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_SHOW_ADVANCED, "Show advanced");
        safeClick(LABEL_MONITORED_SERVER, "Monitored Server", MEDIUMWAIT);
        safeClick(MONITORED_SERVER_GHOSTEXT, "Monitored Server host text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONITORED, DbTitle, "Monitored name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equalsIgnoreCase(DbTitle)) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(3);
    }


    public void validatingHttpProfiles() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, DbTitle);
        safeClick(ENGINE_MONITORIN_GPROFILES, "Monitoring profile add icon", MEDIUMWAIT);
        safeClick(APPLYPROFILEDROPDOWN, "Monitoring profiles dropdown", MEDIUMWAIT);
        safeClick(DROPDOWN1, "Apache HTTP Server", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button", MEDIUMWAIT);
        waitForSecs(4);
        safeClick(LOG_DIRCT_LABEL, "Log Direct Label", MEDIUMWAIT);
        safeType(TXTBOX_LOG_DIRCT, "Log Directory", "Access log directory", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(SUCESS_MSGS);
        for (int i = 0; i <= 2; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (DbTitle + " - " + dashBoardData.HttpServer[i]));
            System.out.println(DbTitle + " - " + dashBoardData.HttpServer[i]);
            System.out.println(wizardName);
            wizards.get(i).click();
            String color = wizards.get(i).getCssValue("color");
            System.out.println(color);
        }

        safeClick(BTN_CLOSE, "Close Button", MEDIUMWAIT);
        safeClick(BTN_REMOVE_PROFILE, "Delete Profile", MEDIUMWAIT);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
    }

    public void validatingBIPApServer() {
        waitForSecs(10);
        safeClick(ENGINE_MONITORIN_GPROFILES, "Monitoring profile add icon", MEDIUMWAIT);
        safeClick(APPLYPROFILEDROPDOWN, "Monitoring profiles dropdown", MEDIUMWAIT);
        safeClick(DROPDOWN2, "BIP App Server", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button", MEDIUMWAIT);
        safeClick(LOG_DIRCT_LABEL, "Log Direct Label", MEDIUMWAIT);
        safeType(TXTBOX_LOG_DIRCT, "Log Directory", "Access log directory", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(5);

        List<WebElement> wizards = driver.findElements(SUCESS_MSGS);
        for (int i = 0; i <= 4; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (DbTitle + " - " + dashBoardData.Bpsever[i]));
            System.out.println(DbTitle + " - " + dashBoardData.Bpsever[i]);
            System.out.println(wizardName);
            wizards.get(i).click();
            String color = wizards.get(i).getCssValue("color");
            System.out.println(color);
        }
        safeClick(BTN_CLOSE, "Close Button", MEDIUMWAIT);
        safeClick(BTN_REMOVE_PROFILE, "Delete Profile", MEDIUMWAIT);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
    }


    public void validatingApacheTomcatServer() {
        waitForSecs(10);
        safeClick(ENGINE_MONITORIN_GPROFILES, "Monitoring profile add icon", MEDIUMWAIT);
        safeClick(APPLYPROFILEDROPDOWN, "Monitoring profiles dropdown", MEDIUMWAIT);
        safeClick(DROPDOWN3, "BIP App Server", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button", MEDIUMWAIT);
        safeClick(LOG_DIRCT_LABEL, "Log Direct Label", MEDIUMWAIT);
        safeType(TXTBOX_LOG_DIRCT, "Log Directory", "Access log directory", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(5);

        List<WebElement> wizards = driver.findElements(SUCESS_MSGS);
        for (int i = 0; i <= 3; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (DbTitle + " - " + dashBoardData.TomcatServer[i]));
            System.out.println(DbTitle + " - " + dashBoardData.TomcatServer[i]);
            System.out.println(wizardName);
            wizards.get(i).click();
            String color = wizards.get(i).getCssValue("color");
            System.out.println(color);
        }
        safeClick(BTN_CLOSE, "Close Button", MEDIUMWAIT);
        safeClick(BTN_REMOVE_PROFILE, "Delete Profile", MEDIUMWAIT);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }

    public void navigatingToHardwarePage() {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HARDWARE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        safeClickingOnSearchingConfig(LISTOFDBS, DbTitle);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = DbTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }


    public void verifyingPageIconsInHardwarePage() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(30);
        By SELECTROW_CHKBOX1 = By.xpath("//div[@aria-label='Select Row']/following-sibling::div[2]/span/span/mark[text()='" + DbTitle + "']/../../../parent::div/descendant::input[1]");
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        By ELEMENT_STATUS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span/mark[text()='" + DbTitle + "']/../../..//parent::div/div[1]/descendant::input");
        // isElementSelected(ELEMENT_STATUS);
        boolean b1 = driver.findElement(ELEMENT_STATUS).isSelected();
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(ELEMENT_STATUS);
        System.out.println(row);
        Assert.assertFalse(row);
        waitForSecs(9);
        By SELECTROW_CHKBOX2 = By.xpath("//div[@aria-label='Select Row']/following-sibling::div[2]/span/span/mark[text()='" + DbTitle + "']/../../../parent::div/descendant::input[1]");
        safeJavaScriptClick(SELECTROW_CHKBOX2, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = DbTitle + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_EDIT, "Edit button", MEDIUMWAIT);
        safeClick(BTN_SHOW_ADVANCED,"Show Advanced button",MEDIUMWAIT);
        List<WebElement> chkboxes =driver.findElements(CHEKBOXES_EDITWINDOW);
        for(int i=0;i<=chkboxes.size()-1;i++) {
          chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES, "Apply changes", MEDIUMWAIT);
        safeClick(BTN_CONFIRM,"Confirm button",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_APPLY_PROFILE,"Apply profile button",MEDIUMWAIT);
        safeClick(APPLYPROFILEDROPDOWN, "Monitoring profiles dropdown", MEDIUMWAIT);
        safeClick(DROPDOWN1, "Apache HTTP Server", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button", MEDIUMWAIT);
        waitForSecs(4);
        By popup = By.xpath("//p[text()='Please select the node and engine that are responsible for monitoring the Apache HTTP Server']");
        boolean nodePopup=  isElementDisplayed(popup);
        Assert.assertTrue(nodePopup);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LISTOFDBS,"added Hardware",MEDIUMWAIT);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }


    public void applyingFiltersInHarwarePage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        //  mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, DbTitle);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void VerifyIconsInHardwareEditConfigWindow(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + DbTitle + " - Cloned']");
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

    public void VerifyViewDataforFieldswithViewIconInHardwareEditConfigWindow(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        waitForSecs(9);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        boolean b=isElementDisplayed(KPIS_TEXT);
        Assert.assertTrue(b);
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
    public void navigateToReferenceWindowFromSoftwareEditWindow(){
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HARDWARE, "Software label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + dashBoardData.HardwareConfigRcrd +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String refName =safeGetText(REFERENCED_TEXT,"Referneced item name",MEDIUMWAIT);
        System.out.println(refName);
        if(refName.contains(">")) {
            String splititem[] = refName.split(">");
            String cpName = splititem[2];
            System.out.println(cpName);
            waitForSecs(10);

            safeClick(REFERENCED_ITEM_LINK, "referenced item", MEDIUMWAIT);
            waitForSecs(10);
            String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
            pageTitle = " " + pageTitle;
            System.out.println(pageTitle);
            Assert.assertEquals(cpName, pageTitle);
        }
        safeClick(REFERENCED_TEXT, "referenced item", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        Assert.assertEquals(refName, pageTitle);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
    }

    public void verifyingViewDataForDataFeildsWithviewIconInreferWindow(){
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HARDWARE, "Software label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(15);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + dashBoardData.HardwareConfigRcrd +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String refName =safeGetText(REFERENCED_TEXT,"Referneced item name",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(REFERENCED_TEXT,"referenced item",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        boolean b=isElementDisplayed(KPIS_TEXT);
        Assert.assertTrue(b);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size()-1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.HARDWARE_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.HARDWARE_VALUES.length-1; j++) {
            System.out.println("Values are " + dashBoardData.HARDWARE_VALUES[j]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
    }



}

