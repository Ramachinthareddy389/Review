package com.page.module;


import com.page.locators.WordPressLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
        WebElement toggle_menu = wait.until(ExpectedConditions.elementToBeClickable(TOGGLE_MENU));
        toggle_menu.click();
        WebElement contact_Label = wait.until(ExpectedConditions.elementToBeClickable(LABEL_CONTACT));
        contact_Label.click();
        safeType(TXTBOX_NAME, "ZENQ", "Name textbox", MEDIUMWAIT);
        safeType(TXTBOX_EMAIL, "test@zenq.com", "Email textbox", MEDIUMWAIT);
        safeType(TXTBOX_SUBJECT, "Wordpress", "Subject textbox", MEDIUMWAIT);
        safeType(TXTAREA_MESSAGE, "Wordpresstesting", "Message textarea", MEDIUMWAIT);

    }

    public void basicWorkFlow(){
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        safeClick(TAB_NEWS, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_NEWS, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_TECH, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
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

    public  void alertPopupInWordPress(){
        driver.navigate().to("http://qa.germainapm.com/wordpress/index.php");
        safeClick(TAB_NEWS, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_NEWS, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(TAB_TECH, "ZENQ", MEDIUMWAIT);
        waitForSecs(5);
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




}
