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
    String Server_Add, Type_add, OSFamily_add, Host_Add, OSName_add, Environment_add;
    String DbTitle = "Hardware" + " - " + random.nextInt(500);
    String EditTitle = "Andriod" + " - " + random.nextInt(500);
    String NodeJS ="NodeJs" + " - " + random.nextInt(500);
    String WebUXAgent ="WebUXAgent" + " - " + random.nextInt(500);

    public HardwarePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnHardware() {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HARDWARE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingNewHardware() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, DbTitle, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_ENVIRONMENT, "Server Feild", MEDIUMWAIT);
        safeClick(ENVIRONMENT_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ENVIRONMENT, "AWS", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("AWS")) {

                dbs1.get(i).click();
                break;
            }
        }
        Environment_add = safeGetText(ENVIRONMENT_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Environment_add);
        safeClick(LABEL_TYPE, "Vendor Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "App Server", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db.size());
        for (int i = 0; i < db.size(); i++) {

            if (db.get(i).getText().equals("App Server")) {

                db.get(i).click();
                break;
            }
        }
        Type_add = safeGetText(TYPE_GHOSTTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(Type_add);
        safeClick(LABEL_HOSTNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_HOSTNAME, DbTitle, "Name into textbox", MEDIUMWAIT);
        Host_Add = safeGetAttribute(TXTBOX_HOSTNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Host_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_OSFAMILY, "Vendor Feild", MEDIUMWAIT);
        safeClick(OSFAMILY_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_OSFAMILY, "ANDROID", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equals("ANDROID")) {

                db1.get(i).click();
                break;
            }
        }
        OSFamily_add = safeGetText(OSFAMILY_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSFamily_add);
        safeClick(LABEL_OSNAME, "Vendor Feild", MEDIUMWAIT);
        safeClick(OSNAME_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_OSNAME, "Windows 10", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equals("Windows 10")) {

                db2.get(i).click();
                break;
            }
        }
        OSName_add = safeGetText(OSNAME_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSName_add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void verifyingHardwareNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = DbTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Server_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && Host_Add.equals(driver.findElement(TXTBOX_HOSTNAME).getAttribute("value")) &&
                Environment_add.equals(driver.findElement(ENVIRONMENT_GHOSTEXT).getText()) && Type_add.equals(driver.findElement(TYPE_GHOSTTEXT).getText()) &&
                OSName_add.equals(driver.findElement(OSNAME_GHOSTEXT).getText()) && OSFamily_add.equals(driver.findElement(OSFAMILY_GHOSTEXT).getText())) {
            System.out.println("Ticket details are valid");
            String text = driver.findElement(TXTBOX_SERVERNAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_HOSTNAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(ENVIRONMENT_GHOSTEXT).getText() + " Port: " + driver.findElement(TYPE_GHOSTTEXT).getText() +
                    " Vendor: " + driver.findElement(OSNAME_GHOSTEXT).getText() + "Server Name :" + driver.findElement(OSFAMILY_GHOSTEXT).getText());
        } else {
            Assert.fail("Ticket details are invalid");
        }
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
        safeClick(LABEL_ENVIRONMENT, "Server Feild", MEDIUMWAIT);
        safeClick(ENVIRONMENT_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_ENVIRONMENT, "Lab", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Lab")) {

                dbs1.get(i).click();
                break;
            }
        }
        Environment_add = safeGetText(ENVIRONMENT_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Environment_add);
        safeClick(LABEL_TYPE, "Vendor Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "Desktop", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db.size());
        for (int i = 0; i < db.size(); i++) {

            if (db.get(i).getText().equals("Desktop")) {

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

            if (db1.get(i).getText().equals("IOS")) {

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

            if (db2.get(i).getText().equals("Linux")) {

                db2.get(i).click();
                break;
            }
        }
        OSName_add = safeGetText(OSNAME_GHOSTEXT, "OS Family value", MEDIUMWAIT);
        System.out.println(OSName_add);
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
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = EditTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Server_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && Host_Add.equals(driver.findElement(TXTBOX_HOSTNAME).getAttribute("value")) &&
                Environment_add.equals(driver.findElement(ENVIRONMENT_GHOSTEXT).getText()) && Type_add.equals(driver.findElement(TYPE_GHOSTTEXT).getText()) &&
                OSName_add.equals(driver.findElement(OSNAME_GHOSTEXT).getText()) && OSFamily_add.equals(driver.findElement(OSFAMILY_GHOSTEXT).getText())) {
            System.out.println("Ticket details are valid");
            String text = driver.findElement(TXTBOX_SERVERNAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_HOSTNAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(ENVIRONMENT_GHOSTEXT).getText() + " Port: " + driver.findElement(TYPE_GHOSTTEXT).getText() +
                    " Vendor: " + driver.findElement(OSNAME_GHOSTEXT).getText() + "Server Name :" + driver.findElement(OSFAMILY_GHOSTEXT).getText());
        } else {
            Assert.fail("Ticket details are invalid");
        }
    }

    public void addingLocalMonitoringAgentsUsingJVMAgentInEditConfiguration() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LOCALAGENTADDICON,"Local agent icon",MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(LOCALAGENTMONITORINGDROPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equals("JVM (Java, etc) Agent")) {

                db2.get(i).click();
                break;
            }
        }
        safeClick(LABEL_SOFTWARE, "Vendor Feild", MEDIUMWAIT);
        safeClick(SOFTWARE_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SOFTWARE, ".NET", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equals(".NET")) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(LABEL_AGENT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_LABEL_AGENT,DbTitle,"Entering the label name",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish Button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(3);
        By ADDEDAGENT_LABEL = By.xpath("//h4[text()='Local Monitoring Agents:']//../div/ul/li/mark[contains(text(),'" + DbTitle + "')]");
        boolean Monitoring_Agents=driver.findElement(ADDEDAGENT_LABEL).isDisplayed();
        //String Monitoring_Agents=safeGetText(ADDEDAGENT_LABEL,"Added Local Monitoring Agents",MEDIUMWAIT);
        System.out.println(Monitoring_Agents);
        Assert.assertTrue(Monitoring_Agents);
        String label="germain.apm.monitoringAgents";
        By ADDEDREFERENCES_LABEl = By.xpath("//button[@aria-label='" +label+'('+DbTitle+')'+"']");
        boolean Monitoring_Agents_Ref=driver.findElement(ADDEDREFERENCES_LABEl).isDisplayed();
        System.out.println(Monitoring_Agents_Ref);
        Assert.assertTrue(Monitoring_Agents_Ref);

    }


    public void addingLocalMonitoringAgentsUsingNodeJSInEditConfiguration() {
        safeClick(LOCALAGENTADDICON,"Local agent icon",MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(LOCALAGENTMONITORINGDROPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equals("NodeJS")) {

                db2.get(i).click();
                break;
            }
        }
        safeClick(LABEL_SOFTWARE, "Vendor Feild", MEDIUMWAIT);
        safeClick(SOFTWARE_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SOFTWARE, ".NET", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equals(".NET")) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(LABEL_AGENT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_LABEL_AGENT,NodeJS,"Entering the label name",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish Button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(3);
        By ADDEDAGENT_LABEL = By.xpath("//h4[text()='Local Monitoring Agents:']//../div/ul/li[contains(text(),'" + NodeJS + "')]");
        boolean Monitoring_Agents=driver.findElement(ADDEDAGENT_LABEL).isDisplayed();
        //String Monitoring_Agents=safeGetText(ADDEDAGENT_LABEL,"Added Local Monitoring Agents",MEDIUMWAIT);
        System.out.println(Monitoring_Agents);
        Assert.assertTrue(Monitoring_Agents);
        String label="germain.apm.monitoringAgents";
        By ADDEDREFERENCES_LABEl = By.xpath("//button[@aria-label='" +label+'('+NodeJS+')'+"']");
        boolean Monitoring_Agents_Ref=driver.findElement(ADDEDREFERENCES_LABEl).isDisplayed();
        System.out.println(Monitoring_Agents_Ref);
        Assert.assertTrue(Monitoring_Agents_Ref);
    }
    public void addingLocalMonitoringAgentsUsingWebUXAgentInEditConfiguration() {
        safeClick(LOCALAGENTADDICON,"Local agent icon",MEDIUMWAIT);
        List<WebElement> db2 = driver.findElements(LOCALAGENTMONITORINGDROPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + db2.size());
        for (int i = 0; i < db2.size(); i++) {

            if (db2.get(i).getText().equals("Web UX Agent")) {

                db2.get(i).click();
                break;
            }
        }
        safeClick(LABEL_SOFTWARE, "Vendor Feild", MEDIUMWAIT);
        safeClick(SOFTWARE_GHOSTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SOFTWARE, ".NET", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db1.size());
        for (int i = 0; i < db1.size(); i++) {

            if (db1.get(i).getText().equals(".NET")) {

                db1.get(i).click();
                break;
            }
        }
        safeClick(LABEL_AGENT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_LABEL_AGENT,WebUXAgent,"Entering the label name",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish Button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(3);
        By ADDEDAGENT_LABEL = By.xpath("//h4[text()='Local Monitoring Agents:']//../div/ul/li[contains(text(),'" + WebUXAgent + "')]");
        boolean Monitoring_Agents=driver.findElement(ADDEDAGENT_LABEL).isDisplayed();
        //String Monitoring_Agents=safeGetText(ADDEDAGENT_LABEL,"Added Local Monitoring Agents",MEDIUMWAIT);
        System.out.println(Monitoring_Agents);
        Assert.assertTrue(Monitoring_Agents);
        String label="germain.apm.monitoringAgents";
        By ADDEDREFERENCES_LABEl = By.xpath("//button[@aria-label='" +label+'('+WebUXAgent+')'+"']");
        boolean Monitoring_Agents_Ref=driver.findElement(ADDEDREFERENCES_LABEl).isDisplayed();
        System.out.println(Monitoring_Agents_Ref);
        Assert.assertTrue(Monitoring_Agents_Ref);
    }

}

