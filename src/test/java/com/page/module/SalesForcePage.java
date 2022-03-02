package com.page.module;

import com.page.locators.SalesForceLocators;
import com.page.locators.WordPressLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SalesForcePage  extends SafeActions implements SalesForceLocators {
    private WebDriver driver;

    public SalesForcePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void loginIntoSalesForceApp(){
        waitForSecs(20);
        driver.navigate().to("chrome-extension://fkcljfeejffnjajnpjflfammljcmdfnh/settings/index.html");
        waitForSecs(10);
        safeClick(BTN_ADD_NEW_WEBSITE, "Add new website button", MEDIUMWAIT);
        safeType(TXTBOX_WEBSITE_URL,"https://gapm-dev-ed.lightning.force.com","Settings url",MEDIUMWAIT);
        safeType(TXTBOX_WEBSITE_APPNAME,"Salesforce","Settings url",MEDIUMWAIT);
        safeType(TXTBOX_WEBSITE_PROFILENAME,"Salesforce","Settings url",MEDIUMWAIT);
        safeClick(BTN_SAVE_NEW_WEBSITE, "Add new website button", MEDIUMWAIT);
        safeType(TXTBOX_SETTING_URL,"https://qa.cloud.germainapm.com","Settings url",MEDIUMWAIT);
        safeClick(URL_SAVE, "Add new website button", MEDIUMWAIT);
        waitForSecs(15);
        driver.navigate().refresh();
        driver.navigate().to("https://gapm-dev-ed.lightning.force.com");
        safeType(USERNAME, "vivek.chavhan@zenq.com", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD_SALES, "Second$123", "Email textbox", MEDIUMWAIT);
        safeCheck(CHKBOX_REMEMBER,"Checkbox",MEDIUMWAIT);
        safeClick(LOGIN_SALES, "Sales force", MEDIUMWAIT);
    }

    public void clickingOnSalesForce(){
        waitForSecs(30);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ESCAPE).build().perform();
        safeClick(BTN_APP_LAUNCHER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(HYPERLINK_HOME, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(HYPERLINK_VIEWCALENDER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(TODAY_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);

    }


    public void addingAlertPopup(){
        waitForSecs(30);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ESCAPE).build().perform();
        safeClick(BTN_APP_LAUNCHER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(HYPERLINK_HOME, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(HYPERLINK_VIEWCALENDER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello');");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(TODAY_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void addingWindowPopup(){
        waitForSecs(30);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ESCAPE).build().perform();
        safeClick(BTN_APP_LAUNCHER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(HYPERLINK_HOME, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(HYPERLINK_VIEWCALENDER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" window.prompt ('User Prompt')");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(TODAY_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);

    }
}
