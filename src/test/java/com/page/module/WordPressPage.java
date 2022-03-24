package com.page.module;


import com.opencsv.CSVReader;
import com.page.locators.WordPressLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;


public class WordPressPage extends SafeActions implements WordPressLocators {
    private WebDriver driver;


    //Constructor to define/call methods
    public WordPressPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void ClickingOnContacts() {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        if(!isElementDisplayed(TOGGLE_MENU)) {
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        }
        else {
            safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);

        }
        waitForSecs(20);
        safeType(TXTBOX_NAME, "ZENQ", "Name textbox", MEDIUMWAIT);
        waitForSecs(20);
        safeType(TXTBOX_EMAIL, "test@zenq.com", "Email textbox", MEDIUMWAIT);
        waitForSecs(20);
        safeType(TXTBOX_SUBJECT, "Wordpress", "Subject textbox", MEDIUMWAIT);
        waitForSecs(20);
        safeType(TXTAREA_MESSAGE, "Wordpresstesting", "Message textarea", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_SUBMIT, "Submit button", MEDIUMWAIT);
    }

    public void basicWorkFlow() {
        try {
            if (!isElementDisplayed(TOGGLE_MENU)) {
                safeClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
                waitForSecs(20);
                safeClick(TAB_FASHION, "ZENQ", MEDIUMWAIT);
                waitForSecs(20);
                safeClick(TAB_TRAVEL, "ZENQ", MEDIUMWAIT);
                waitForSecs(20);
                safeClick(TAB_FOOD, "ZENQ", MEDIUMWAIT);
                waitForSecs(20);
                safeClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
                waitForSecs(5);
            } else {
                safeClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                safeClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
                waitForSecs(5);
                safeClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                waitForSecs(5);
                safeJavaScriptClick(TAB_FASHION, "ZENQ", MEDIUMWAIT);
                waitForSecs(5);
                safeJavaScriptClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                waitForSecs(10);
                safeJavaScriptClick(TAB_TRAVEL, "ZENQ", MEDIUMWAIT);
                waitForSecs(5);
                safeJavaScriptClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                waitForSecs(10);
                safeJavaScriptClick(TAB_FOOD, "ZENQ", MEDIUMWAIT);
                waitForSecs(5);
                safeJavaScriptClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                waitForSecs(10);
                safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
                waitForSecs(5);
            }
        }catch (Exception e){

        }
    }

    public void LoginToWordPressSite() {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        waitForSecs(10);
        try {
            if (!isElementDisplayed(TOGGLE_MENU)) {
                safeClick(TAB_NEWS, "Technology", MEDIUMWAIT);
                waitForSecs(20);
                safeClick(TAB_TECH, "Technology", MEDIUMWAIT);
                waitForSecs(15);
            } else {
                safeClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                safeClick(TAB_NEWS, "News", MEDIUMWAIT);
                waitForSecs(15);
                safeClick(TOGGLE_MENU, "Toggle menu", MEDIUMWAIT);
                safeClick(TAB_TECH, "Technology", MEDIUMWAIT);
                waitForSecs(15);
            }
        }catch (Exception e){

        }
    }

    public void alertPopupInWordPress() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello');");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
        if(!isElementDisplayed(TOGGLE_MENU)) {
            safeJavaScriptClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
            waitForSecs(5);
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        }
        else {
            safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
            safeJavaScriptClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
            waitForSecs(5);
            safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
            waitForSecs(5);
        }

    }

    public void windowPopUpinWordPress() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" window.prompt ('User Prompt')");
        waitForSecs(15);
        dismissAlert();
        waitForSecs(5);
        if(!isElementDisplayed(TOGGLE_MENU)) {
            safeJavaScriptClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
            waitForSecs(5);
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        }
        else {
            safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
            safeJavaScriptClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
            waitForSecs(5);
            safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
            waitForSecs(5);
        }
    }

    public void clickingOnFunctionalKeys() {
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F1);
        waitForSecs(10);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F10);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F11);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F12);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F2);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F3);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F4);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F5);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F6);
        waitForSecs(5);
        safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F7);
        waitForSecs(5);
        safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F8);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_TECH).sendKeys(Keys.F9);
        waitForSecs(5);
        safeJavaScriptClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        waitForSecs(10);
        safeJavaScriptClick(LINK_THINGSTONEW_YEAR, "Link", MEDIUMWAIT);
    }

    public void searchingTheApp() {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        waitForSecs(10);
        safeClick(BTN_SEARCH, "Search button", MEDIUMWAIT);
        safeType(TXTBOX_SEARCH, "Company", "Search textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SUBMIT_SEARCH, "Search button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void clickingOnDiffLinksInContactUs(){
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if(!isElementDisplayed(TOGGLE_MENU)) {
            safeClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        }
        else {
            safeClick(TOGGLE_MENU,"Toggle menu",MEDIUMWAIT);
            safeJavaScriptClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);

        }
        waitForSecs(5);
        safeClick(HYPERRLINK_SUPPORT_FORUM,"Hyperlink",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(LABEL_CONTACT,"label contact",MEDIUMWAIT);
        safeJavaScriptClick(HYPERLINK_CONTACTPAGE,"Hyperlink",MEDIUMWAIT);
        switchToWindow(0);

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


    public void downloadingEverestForumPluginInWP() throws IOException {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement toggle_menu = wait.until(ExpectedConditions.elementToBeClickable(TOGGLE_MENU));
        toggle_menu.click();
        WebElement contact_Label = wait.until(ExpectedConditions.elementToBeClickable(LABEL_CONTACT));
        contact_Label.click();
        waitForSecs(5);
        safeClick(LINK_EVENTS_FORUM_PLUGIN,"Forum Plugin",MEDIUMWAIT);
        waitForSecs(10);
        String home = System.getProperty("user.home");
        String file_name = "everest-forms" + ".zip";
        System.out.println(file_name);
        String downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        Assert.assertTrue(fileName.equals(file_name));
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }

    public void openNoninjectedSiteinNewTab(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.co.in/', '_blank');");
        switchToWindow(0);
    }

    public void openInjectedSiteinNewTab(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://gapm-dev-ed.lightning.force.com', '_blank');");
        switchToWindow(0);
    }
}
