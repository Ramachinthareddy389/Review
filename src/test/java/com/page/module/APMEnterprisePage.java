package com.page.module;

import com.opencsv.CSVReader;
import com.page.locators.APMEnterpriseLocators;
import com.page.locators.ApmStateLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class APMEnterprisePage extends SafeActions implements APMEnterpriseLocators {
    private WebDriver driver;
    String dname = "HttpScenario";
    Random random = new Random();
    String dname1 = dname + random.nextInt(1500);
    String dnameEdit = "Httpedit" + random.nextInt(1500);
    String Server_add, AppName_add, Cred_add, Component_add, Edit_Server_add, Edit_MonitorName_add, Edit_App_add;
    String downloadPath;
    public APMEnterprisePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void navigateToAPMPage(){
        waitForSecs(10);
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
    }
    public  void verifyingNavigateToEnterpriseTab(){
        try {
            if (!isElementDisplayed(INSTANCE_COLUMN)) {
             safeClick(ENTERPRISE_TAB,"Enterprise tab");
                Assert.assertTrue(isElementDisplayed(ENTERPRISE_TAB));
            }
            Assert.assertTrue(isElementDisplayed(ENTERPRISE_TAB));
        }catch (Exception e){

        }

    }


    public  void navigateToDrirllThroughPageFrmFactsProcessedPortlet(){
           waitForSecs(10);
            safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
            safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
            waitForSecs(10);
            safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
            waitForSecs(10);
            safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
            By SeachedText = By.xpath("//div[contains(text(),'"+"9f6619421afb"+"')]");
            mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
            driver.findElement(SeachedText).click();
            mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
            safeClick(HOSTNAME_VALUE,"Host name value",MEDIUMWAIT);
            waitForSecs(10);
            safeJavaScriptClick(DRILLTHRUGH_FACT_PROCESSED,"Drill through icon",MEDIUMWAIT);
            waitForSecs(5);
            Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_FACT_PROCESSED));
    }

    public void exportingPortlets() {
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
    public void clickingOnExportBtnOfFactProcessedPortlet(){
        waitForSecs(7);
        safeClick(EXPORT_FACT_PROCESSED, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void clickingOnExportBtnOfCPUUsagePortlet(){
        waitForSecs(7);
        safeClick(EXPORT_CPU, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void clickingOnExportBtnOfHeapUsagePortlet(){
        waitForSecs(7);
        safeClick(EXPORT_HEAP, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfQueueSizePortlet(){
        waitForSecs(7);
        safeClick(EXPORT_QUEUESIZE, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void clickingOnExportBtnOfQueueHeapUsagePortlet(){
        waitForSecs(7);
        safeClick(EXPORT_QUEUE_HEAP, "Export Button", MEDIUMWAIT);
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
    public void navigateToDrirllThroughPageFrmCPUUsagePortlet(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'"+"9f6619421afb"+"')]");
        mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(HOSTNAME_VALUE,"Host name value",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_CPU,"Drill through icon",MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_CPU));
    }
    public void navigateToDrirllThroughPageFrmHeapUsagePortlet(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'"+"9f6619421afb"+"')]");
        mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(HOSTNAME_VALUE,"Host name value",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_HEAP,"Drill through icon",MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_HEAP));
    }

    public  void verifyingNavigateToAPMQueueTab(){
        try {
            if (!isElementDisplayed(ERRORS_COLUMN)) {
                safeClick(QUEUES_TAB,"Queues tab");
                Assert.assertTrue(isElementDisplayed(QUEUES_TAB));
            }
            Assert.assertTrue(isElementDisplayed(QUEUES_TAB));
        }catch (Exception e){

        }

    }


    public  void navigateToDrirllThroughPageFrmQueueSizePortlet(){
        safeClick(QUEUES_TAB,"Queues tab",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'"+"apm.action"+"')]");
        mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(NAME_QUEUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(NAME_QUEUE,"Host name value",MEDIUMWAIT);

        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_QUEUESIZE,"Drill through icon",MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_QUEUESIZE));
    }
    public  void exportingQueueSizePortlet(){
        safeClick(QUEUES_TAB,"Queues tab",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'"+"apm.action"+"')]");
        mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(NAME_QUEUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(NAME_QUEUE,"Host name value",MEDIUMWAIT);
    }
    public  void navigateToDrirllThroughPageFrmQueueHeapUsagePortlet(){
        safeClick(QUEUES_TAB,"Queues tab",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS_QUEUES, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'"+"apm.action"+"')]");
        mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(NAME_QUEUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(NAME_QUEUE,"Host name value",MEDIUMWAIT);

        waitForSecs(10);
        safeJavaScriptClick(DRILLTHRUGH_QUEUE_HEAP,"Drill through icon",MEDIUMWAIT);
        waitForSecs(5);
        Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_QUEUE_HEAP));
    }
}
