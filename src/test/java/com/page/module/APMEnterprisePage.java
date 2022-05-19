package com.page.module;

import com.opencsv.CSVReader;
import com.page.locators.APMEnterpriseLocators;
import com.page.locators.ApmStateLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class APMEnterprisePage extends SafeActions implements APMEnterpriseLocators {
    private WebDriver driver;
    String dname = "HttpScenario";
    Random random = new Random();
    String dname1 = dname + random.nextInt(1500);
    String dnameEdit = "Httpedit" + random.nextInt(1500);
    String Server_Add, AppName_add, Cred_add, Component_add, Edit_Server_add, Edit_MonitorName_add, Edit_App_add;
    String downloadPath;
    String NodeJS = "NodeJs" + " - " + random.nextInt(500);
    String EditNodeJS = "EditNodeJS" + " - " + random.nextInt(500);
    String DbTitle = "Hardware" + " - " + random.nextInt(500);
    String Engine = "TestEngine" + " - " + random.nextInt(500);
    String Cred = "Cred" + " - " + random.nextInt(500);
    String Database = "Database" + " - " + random.nextInt(500);
    String Component = "Component" + random.nextInt(500);
    String JSSCRIPT = "Jsscript" + " - " + random.nextInt(500);

    public APMEnterprisePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void navigateToAPMPage() {
        waitForSecs(10);
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingComponent() {
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(DATABASE_CHANGE_COMPONENT, "Database Change Component", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingDataBaseQueryComponent() {
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(DATABASE_QUERY_COMPONENT, "Database query Component", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingDirectoryMonitorDeploymenComponent() {
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(DIRECTORY_MONITOR_COMPONENT, "Directory Monitor Component", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void addingDirectoryScannerDeploymenComponent() {
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(DIRECTORY_SCANNER_COMPONENT, "Directory Monitor Component", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addinNewMonitorGoLangAppComponent() {
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(MONITOR_GOLANG_COMPONENT, "Directory Monitor Component", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingNewIMAPMonitorDeploymentComponent(){
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(IMAP_MONITOR_COMPONENT, "Directory Monitor Component", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void verifyingNavigateToEnterpriseTab() {
        try {
            if (!isElementDisplayed(INSTANCE_COLUMN)) {
                safeClick(ENTERPRISE_TAB, "Enterprise tab");
                Assert.assertTrue(isElementDisplayed(ENTERPRISE_TAB));
            }
            Assert.assertTrue(isElementDisplayed(ENTERPRISE_TAB));
        } catch (Exception e) {

        }

    }


    public void navigateToDrirllThroughPageFrmFactsProcessedPortlet() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "9f6619421afb" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(HOSTNAME_VALUE, "Host name value", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_FACT_PROCESSED, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_FACT_PROCESSED));
    }

    public void exportingPortlets() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Type", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "ACTION" + "')]");
        waitForSecs(10);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(HOSTNAME_VALUE, "Host name value", MEDIUMWAIT);
        waitForSecs(10);
    }

    @Step("Taking latest file from windows")
    private File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public void clickingOnExportBtnOfFactProcessedPortlet() {
        waitForSecs(7);
        safeClick(EXPORT_FACT_PROCESSED, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfCPUUsagePortlet() {
        waitForSecs(7);
        safeClick(EXPORT_CPU, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfHeapUsagePortlet() {
        waitForSecs(7);
        safeClick(EXPORT_HEAP, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfQueueSizePortlet() {
        waitForSecs(7);
        safeClick(EXPORT_QUEUESIZE, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfQueueHeapUsagePortlet() {
        waitForSecs(7);
        safeClick(EXPORT_QUEUE_HEAP, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfMemoryUsagePortlet() {
        waitForSecs(7);
        safeClick(EXPORT_MEMORY_USAGE, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void downloadedpath() {
        String home = System.getProperty("user.home");
        downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);

    }

    @Step("Export portlets")
    public void validatingExportedPortlet(String file_name, String[] expected) throws IOException {

        downloadedpath();

        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        System.out.println(file_name);
        Assert.assertTrue(fileName.equals(file_name));
        for (int j = 0; j < expected.length; j++) {
            System.out.println("Values are " + expected[j]);
        }
        Reader reader = new FileReader(downloadPath + "\\" + fileName);
        CSVReader csvreader = new CSVReader(reader);
        List<String[]> list = csvreader.readAll();
        Iterator<String[]> ite = list.iterator();
        String[] data = ite.next();
        for (int i = 0; i < data.length; i++) {
            String actualText = data[i];
            Assert.assertEquals(actualText, expected[i]);
            if (actualText.equals(expected[i])) {
                System.out.println(expected[i]);
                System.out.println("passed on: " + actualText);
            } else {
                System.out.println("failed on: " + actualText);
            }
        }
        reader.close();
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }

    }

    public void navigateToDrirllThroughPageFrmCPUUsagePortlet() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "9f6619421afb" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(HOSTNAME_VALUE, "Host name value", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_CPU, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_CPU));
    }

    public void navigateToDrirllThroughPageFrmHeapUsagePortlet() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "9f6619421afb" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(HOSTNAME_VALUE, "Host name value", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_HEAP, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_HEAP));
    }

    public void verifyingNavigateToAPMQueueTab() {
        try {
            if (!isElementDisplayed(ERRORS_COLUMN)) {
                safeClick(QUEUES_TAB, "Queues tab");
                Assert.assertTrue(isElementDisplayed(QUEUES_TAB));
            }
            Assert.assertTrue(isElementDisplayed(QUEUES_TAB));
        } catch (Exception e) {

        }

    }


    public void navigateToDrirllThroughPageFrmQueueSizePortlet() {
        safeClick(QUEUES_TAB, "Queues tab", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "apm.action" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(NAME_QUEUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(NAME_QUEUE, "Host name value", MEDIUMWAIT);

        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_QUEUESIZE, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_QUEUESIZE));
    }

    public void exportingQueueSizePortlet() {
        safeClick(QUEUES_TAB, "Queues tab", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "apm.action" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(NAME_QUEUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(NAME_QUEUE, "Host name value", MEDIUMWAIT);
    }

    public void navigateToDrirllThroughPageFrmQueueHeapUsagePortlet() {
        safeClick(QUEUES_TAB, "Queues tab", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + "apm.action" + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(NAME_QUEUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(NAME_QUEUE, "Host name value", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_QUEUE_HEAP, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_QUEUE_HEAP));
    }

    public void verifyingNavigateToNodeTab() {
        try {
            if (!isElementDisplayed(ENGINES_COLUMN)) {
                safeClick(NODES_TAB, "Queues tab");
                Assert.assertTrue(isElementDisplayed(NODES_TAB));
            }
            Assert.assertTrue(isElementDisplayed(NODES_TAB));
        } catch (Exception e) {

        }

    }

    public void configuringNodeInAPMModule() {
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(NODES_TAB, "Nodes Tab", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_EDITED_SERVERNAME, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_EDITED_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_HOSTNAME_NODE, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void verifyingAddedNodeInNodesPage() {
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = NodeJS;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void verifyingEditedNodeInNodesPage() {
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = NodeJS;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClearAndType(TXTBOX_EDITED_SERVERNAME, EditNodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_EDITED_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        Assert.assertEquals(Server_Add, EditNodeJS);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_HOSTNAME_NODE, EditNodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        Assert.assertEquals(Server_Add, EditNodeJS);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void verifyingAddedEngineinNodeEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(ENGINES_ADD_ICON_IN_NODE, "Engines add icon", MEDIUMWAIT);
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
        waitForSecs(15);
        safeClick(CLOSE_EDITOR, "Close Editor", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String engine_Hyperlink = safeGetText(ENGINE_HYPERLINK, "Added ENgine Hyper link", MEDIUMWAIT);
        Assert.assertEquals(Engine, engine_Hyperlink);
        waitForSecs(10);


    }

    public void verifyingAddedEngineInEnginesTab() {
        safeClick(ENGINES_TAB, "Engines Hyperlink in node edit window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, Engine + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Engine;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(NODES_TAB, "Engines Hyperlink in node edit window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, NodeJS + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void verifyingNavigateToAPMEngineTab() {
        try {
            if (!isElementDisplayed(ERRORS_COLUMN)) {
                safeClick(ENGINES_TAB, "Queues tab");
                Assert.assertTrue(isElementDisplayed(ENGINES_TAB));
            }
            Assert.assertTrue(isElementDisplayed(ENGINES_TAB));
        } catch (Exception e) {

        }

    }

    public void addingNewEngine() {
        safeClick(ENGINES_TAB, "Engines Hyperlink in node edit window", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(NODEADD_ICON_ENGINES, "Node add icon", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_NAME_NODE, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_NAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        waitForSecs(10);
        safeClick(LABEL_HOSTNAME_NODE, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_HOSTNAME_NODE, NodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_HOSTNAME_NODE, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
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
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(20);
        safeClick(DROPDOWN_ENGINE, "Selecting field", MEDIUMWAIT);
        waitForSecs(10);
        By SeachedText = By.xpath("//div[contains(text(),'" + Engine + "')]");
        waitForSecs(10);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SeachedText, "Engine", MEDIUMWAIT);
        // driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        //  mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Engine);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);


    }

    public void deletingAddedEngine() {
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void editingExistingEngine() {
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClearAndType(TXTBOX_SERVERNAME, EditNodeJS, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        Assert.assertEquals(Server_Add, EditNodeJS);
    }

    public void navigateToDrillthruPageFrmCPUUsagePortlet() {
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_CPU, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_CPU));
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ENGINES_TAB, "Engines Hyperlink in node edit window", MEDIUMWAIT);
        waitForSecs(5);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(20);
        safeClick(DROPDOWN_ENGINE, "Selecting field", MEDIUMWAIT);
        waitForSecs(10);
        By SeachedText = By.xpath("//div[contains(text(),'" + Engine + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void navigateToDrillthruPageFrmMemoryUsagePortlet() {
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_MEMORYUSAGE, "Drill through icon", MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_MEMORYUSAGE));
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ENGINES_TAB, "Engines Hyperlink in node edit window", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(20);
        safeClick(DROPDOWN_ENGINE, "Selecting field", MEDIUMWAIT);
        waitForSecs(10);
        By SeachedText = By.xpath("//div[contains(text(),'" + Engine + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void exportingCPUPortletsInAPMEngine() {
        waitForSecs(10);
        safeClick(ENGINES_TAB, "Engines Hyperlink in node edit window", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, "standalone" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);

    }

    public void verifyingNavigateToComponentsTab() {
        try {
            if (!isElementDisplayed(MONITORED_SERVER_COLUMN)) {
                safeClick(COMPONENTS_TAB, "Components tab");
                Assert.assertTrue(isElementDisplayed(COMPONENTS_TAB));
            }
            Assert.assertTrue(isElementDisplayed(COMPONENTS_TAB));
        } catch (Exception e) {

        }

    }

    public void addingNewCollatorDeploymentComponent() {
        waitForSecs(10);
        safeClick(COMPONENTS_TAB, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClick(COLLATOR_COMPONENT, "Collator Component", MEDIUMWAIT);
        safeClearAndType(TXTBOX_COMPONENTTYPE, "MySQL Collator", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("MySQL Collator")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_MONITORED_SERVER, "test_cloud_germainapm_com", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("test_cloud_germainapm_com")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_APPLICATION, "ActiveMQ Broker", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("ActiveMQ Broker")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClearAndType(TXTBOX_NODE, "APM", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("APM")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_ENGINE, "apm-self-monitoring", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("apm-self-monitoring")) {

                dbs5.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedCollatorDeploymentComponent() {
        safeType(TEXTBOX_TYPESEARCH, "Collator" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = "Collator";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm Delete button", MEDIUMWAIT);
    }

    public void editExistingCollatorDeploymentComponent() {
        safeType(TEXTBOX_TYPESEARCH, "Collator" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClearAndType(TXTBOX_SERVERNAME, "Edit Collator", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        Component_add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name", MEDIUMWAIT);
        safeClearAndType(TXTBOX_APPLICATION, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Android")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        Edit_MonitorName_add = safeGetText(TXTBOX_EDITED_MONITOREDSOFTWARE, "Monitored software", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
    }


    public void verifyingEditedValuesInCollatorComponent() {
        String expectedText = "Edit Collator";
        Assert.assertEquals(Component_add, expectedText);
        Assert.assertEquals(Edit_MonitorName_add, "Android");
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm Delete button", MEDIUMWAIT);
    }

    public void injectingJSscript() throws IOException {
        driver.navigate().to("https://pixenio.com/examples/handyman");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Scanner sc = new Scanner(new FileInputStream(new File("D:\\DecProject\\germain-test-automation\\Resources\\germainapm-webux-agent_Latest.js")));
        String inject = "";
        while (sc.hasNext()) {
            String[] s = sc.next().split("\r\n");
            for (int i = 0; i < s.length; i++) {
                inject += s[i];
                inject += " ";
            }
        }
        System.out.println(inject);
        jse.executeScript(inject);
        waitForSecs(15);
        driver.findElement(By.xpath("//a[text()='Create Website']")).click();


    }

    public void addingNewDatabaseChangeMonitorDeploymentComponent() {
        driver.findElements(DATABASEPAGE_ADDBTNS).get(0).click();
        safeClearAndType(DRPDOWN_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA Test")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(DRPDOWN_VENDOR, "ORACLE", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("ORACLE")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        safeType(TXTBOX_SERVERNAME, Database, "Database Name", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(1).click();
        safeType(TXTBOX_PORT, "8080", "Port Number", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElements(DATABASEPAGE_ADDBTNS).get(1).click();
        safeType(TXTBOX_SERVERNAME, Cred, "Cred Name", MEDIUMWAIT);
        waitForSecs(5);
        safeType(TXTBOX_USERNAME, "Test  ", "User Name", MEDIUMWAIT);
        waitForSecs(5);
        safeType(TXTBOX_PASSWORD, "Test@123  ", "Password Name", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(5);
    }


    public void addingNewDatabaseChangeMonitorDeploymentComponent1() {
        safeClearAndType(TXTBOX_APPLICATION, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Android")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_MONITORED_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA Test")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
        safeClick(DATABASEPAGE_ADDBTNS, "Component add button", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, Component, "Component name", MEDIUMWAIT);
        driver.findElements(BTN_NEXT).get(1).click();
        driver.findElements(BTN_NEXT).get(1).click();
        safeType(TXTBOX_SERVERNAME, Component, "Component name", MEDIUMWAIT);
        safeType(TXTBOX_SQL, "sql", "Component name", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
    }

    public void addingDatabaseQueryMonitorDeployment() {
        safeClearAndType(TXTBOX_APPLICATION, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Android")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
        safeClick(DATABASEPAGE_ADDBTNS, "Component add button", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_COMPONENT, Component, "Component name", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(1).click();
        driver.findElements(BTN_NEXT).get(1).click();
        safeType(TXTBOX_QUERYNAME, Component, "Component name", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_SQL, "sql", "Component name", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElements(BTN_NEXT).get(1).click();
        safeClearAndType(TXTBOX_KPI, "ActiveMQ Heap Usage", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs5.get(i).getText().equals("ActiveMQ Heap Usage")) {

                dbs5.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(KPIFEILD_ADDICON, "Finish button", MEDIUMWAIT);
        safeType(KPIFEILD_TXTBOX, "Test", "Test com", MEDIUMWAIT);
        safeClearAndType(KPIFEILD_VALUE, "bucket", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs6.get(i).getText().equals("bucket")) {

                dbs6.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(1).click();
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
    }

    public void addingDirectoryMonitorDeployment(String componentType) {
        safeClearAndType(TXTBOX_COMPONENT_TYPE, componentType, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals(componentType)) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeType(TXTBOX_PATH, "Test", "Monitor Deployment Path");
        safeClearAndType(TXTBOX_MONITORED_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA Test")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.clear();
        searchField.sendKeys(del);

    }
    public void addingNewMonitoringGoLangApp(){
        waitForSecs(10);
        safeClearAndType(TXTBOX_MONITORED_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA Test")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_APPLICATION, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Android")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
        safeClick(BTN_SKIP,"Skip button",MEDIUMWAIT);
        waitForSecs(5);
    }
    public void addingIMAPMonitorDeployment(String componentType){
        safeClearAndType(TXTBOX_COMPONENT_TYPE, componentType, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals(componentType)) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        waitForSecs(10);
        safeClearAndType(TXTBOX_MONITORED_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA Test")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_APPLICATION, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("Android")) {

                dbs5.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        driver.findElements(BTN_NEXT).get(0).click();
        waitForSecs(5);
        safeType(TXTBOX_PORT, "8080", "Port Number", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElements(BTN_NEXT).get(0).click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.clear();
        searchField.sendKeys(del);

    }

    public void DeployementPage() {
        safeClearAndType(TXTBOX_SERVERNAME, Component, "Component name", MEDIUMWAIT);
        safeClearAndType(TXTBOX_NODE, "APM", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("APM")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_ENGINE, "apm-self-monitoring", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("apm-self-monitoring")) {

                dbs5.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedComponent() {
        safeType(TEXTBOX_TYPESEARCH, Component + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Component;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm Delete button", MEDIUMWAIT);
        boolean b = isElementDisplayed(By.xpath("//div[text()='No Results Found']"));
        Assert.assertTrue(b);
    }

    public void editexistingDatabaseChangeMonitorDeploymentComponent() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Component + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Component);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClearAndType(TXTBOX_SERVERNAME, "EditComponent", "Server name into textbox", MEDIUMWAIT);
        Component_add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name", MEDIUMWAIT);
        waitForSecs(5);
        safeClearAndType(TXTBOX_APPLICATION, "AngularJS", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("AngularJS")) {

                dbs4.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        Edit_MonitorName_add = safeGetText(TXTBOX_EDITED_MONITOREDSOFTWARE, "Monitored software", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
    }

    public void verifyingEditedDatabaseChangeConfigs() {
        String expectedText = "EditComponent";
        Assert.assertEquals(Component_add, expectedText);
        Assert.assertEquals(Edit_MonitorName_add, "AngularJS");
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm Delete button", MEDIUMWAIT);
        boolean b = isElementDisplayed(By.xpath("//div[text()='No Results Found']"));
        Assert.assertTrue(b);
    }

    public void editingDirectorymonitoryDeployment() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Component + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Component);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(15);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.clear();
        searchField.sendKeys(del+"EditComponent");
        // safeJavaScriptClearAndType(TXTBOX_SERVERNAME, "EditComponent", "Server name into textbox", MEDIUMWAIT);
        Component_add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
    }

    public void verifyingEditedDirectoryMonitorConfigs() {
        String expectedText = "EditComponent";
        Assert.assertEquals(Component_add, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm Delete button", MEDIUMWAIT);
        boolean b = isElementDisplayed(By.xpath("//div[text()='No Results Found']"));
        Assert.assertTrue(b);
    }

    public void verifyingNavigateToJSScriptsTab() {
        try {
            if (!isElementDisplayed(MONITORED_SERVER_COLUMN)) {
                safeClick(TAB_JSCRIPTS, "Components tab");
                Assert.assertTrue(isElementDisplayed(TAB_JSCRIPTS));
            }
            Assert.assertTrue(isElementDisplayed(TAB_JSCRIPTS));
        } catch (Exception e) {

        }

    }

    public void addingNewJSConfig() {
        waitForSecs(10);
        safeClick(TAB_JSCRIPTS, "Components tab");
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONITORED_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA Test")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TXTBOX_APPLICATION, "ActiveMQ Broker", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("ActiveMQ Broker")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeType(TXTBOX_SERVERNAME, JSSCRIPT, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedJSScripts() {
        safeType(TEXTBOX_TYPESEARCH, JSSCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = JSSCRIPT;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm Delete button", MEDIUMWAIT);
    }
}
