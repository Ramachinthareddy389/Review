package com.page.module;


import com.page.locators.WordPressLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WordPressPage extends SafeActions implements WordPressLocators {
    private WebDriver driver;


    //Constructor to define/call methods
    public WordPressPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void ClickingOnContacts() {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        final WebDriverWait wait = new WebDriverWait(driver, 10);
    /*    WebElement toggle_menu = wait.until(ExpectedConditions.elementToBeClickable(TOGGLE_MENU));
        toggle_menu.click();*/
        WebElement contact_Label = wait.until(ExpectedConditions.elementToBeClickable(LABEL_CONTACT));
        contact_Label.click();
        safeType(TXTBOX_NAME, "ZENQ", "Name textbox", MEDIUMWAIT);
        safeType(TXTBOX_EMAIL, "test@zenq.com", "Email textbox", MEDIUMWAIT);
        safeType(TXTBOX_SUBJECT, "Wordpress", "Subject textbox", MEDIUMWAIT);
        safeType(TXTAREA_MESSAGE, "Wordpresstesting", "Message textarea", MEDIUMWAIT);
        safeClick(BTN_SUBMIT, "Submit button", MEDIUMWAIT);
    }

    public void basicWorkFlow() {
        safeClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_FASHION, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_TRAVEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_FOOD, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void LoginToWordPressSite() {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        safeClick(TAB_NEWS, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_NEWS, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_TECH, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void alertPopupInWordPress() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello');");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
        safeClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void windowPopUpinWordPress() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" window.prompt ('User Prompt')");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
        safeClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_CONTACT, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void clickingOnFunctionalKeys() {
        driver.findElement(TAB_TECH).sendKeys(Keys.F1);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F10);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F11);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F12);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F2);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F3);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F4);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F5);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F6);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F7);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F8);
        waitForSecs(5);
        driver.findElement(TAB_TECH).sendKeys(Keys.F9);
        waitForSecs(5);
        safeClick(TAB_ENTER, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        waitForSecs(10);
        safeClick(LINK_THINGSTONEW_YEAR, "Link", MEDIUMWAIT);
    }

    public void searchingTheApp() {
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        safeClick(BTN_SEARCH, "Search button", MEDIUMWAIT);
        safeType(TXTBOX_SEARCH, "Company", "Search textbox", MEDIUMWAIT);
        safeClick(BTN_SUBMIT_SEARCH, "Search button", MEDIUMWAIT);
    }
}
