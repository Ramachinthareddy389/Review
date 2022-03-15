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
      //  safeCheck(CHKBOX_REMEMBER,"Checkbox",MEDIUMWAIT);
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

    public void clickingOnFunctionalKeys(){
        safeJavaScriptClick(HYPERLINK_VIEWCALENDER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F1);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F10);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F11);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F12);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F2);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F3);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F4);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F5);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F6);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F7);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F8);
        waitForSecs(5);
        driver.findElement(HYPERLINK_VIEWCALENDER).sendKeys(Keys.F9);
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

    public void openNoninjectedSiteinNewTab(){
        safeJavaScriptClick(HYPERLINK_VIEWCALENDER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.co.in/', '_blank');");
        switchToWindow(0);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(TODAY_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void openInjectedSiteinNewTab(){
        safeJavaScriptClick(HYPERLINK_VIEWCALENDER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://qa.germainapm.com/wordpress/index.php', '_blank');");
        switchToWindow(0);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(TODAY_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }
    public void  searchingContentUsingTheSearchBoxInSalesforce()
    {
        safeClearAndType(SEARCHBAR_TXTBOX,"QA dashboard","Qa dashboard",MEDIUMWAIT);
        mouseHoverJScript(TXT_QADASHBOARD,"Dashboard","Da",MEDIUMWAIT);
        safeJavaScriptClick(TXT_QADASHBOARD,"searched Dashboard",MEDIUMWAIT);
        isElementDisplayed(TAB_QADASHBOARD);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);

    }
    public void  addingANewEventInSalesforceSite()
    {
        safeClick(GLOBAL_KEY_ICON,"Global key",MEDIUMWAIT);
        safeClick(NEW_EVENT_LINK,"Event link",MEDIUMWAIT);
        safeClearAndType(TXTBOX_SUBJECT,"New Event","Event link",MEDIUMWAIT);
        driver.findElements(TXTBOX_DATE).get(0).sendKeys("Mar 20, 2022");
        driver.findElements(TXTBOX_DATE).get(1).sendKeys("Mar 21, 2022");
        driver.findElements(TXTBOX_TIME).get(0).sendKeys("7:00 PM");
        driver.findElements(TXTBOX_DATE).get(1).sendKeys("8:00 PM");
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void  addingANewTaskInSalesforceSite()
    {
        safeClick(GLOBAL_KEY_ICON,"Global key",MEDIUMWAIT);
        safeClick(NEW_TASK_LINK,"Event link",MEDIUMWAIT);
        safeClearAndType(TXTBOX_SUBJECT,"New Task","Event link",MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }
    public void addingNewContactInSalesForce(){
        safeClick(GLOBAL_KEY_ICON,"Global key",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(NEW_CONTACT_LINK,"Contact link",MEDIUMWAIT);
        safeClearAndType(FIRSTNAME_TXTBOX,"Test","Event link",MEDIUMWAIT);
        waitForSecs(5);
        safeClearAndType(LASTNAME_TXTBOX,"Salesforce","Event link",MEDIUMWAIT);
        waitForSecs(5);
        safeClearAndType(TXTBOX_EMAIL,"TestSalesforce@gmail.com","Event link",MEDIUMWAIT);
        waitForSecs(5);
        safeClearAndType(TXTBOX_PHONE,"999999999","Event link",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);

    }

    public void  addingALoggingacallInSalesforce(){
        safeClick(GLOBAL_KEY_ICON,"Global key",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(NEW_LOG_A_CAll_LINK,"Log a link",MEDIUMWAIT);
        waitForSecs(5);
        safeClearAndType(SUBJECT_CONTACTS,"Logging a call","Event link",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);

    }

    public void  addingaFavoriteListInSalesforce(){
        safeClearAndType(SEARCHBAR_TXTBOX,"QA dashboard","Qa dashboard",MEDIUMWAIT);
        mouseHoverJScript(TXT_QADASHBOARD,"Dashboard","Da",MEDIUMWAIT);
        safeJavaScriptClick(TXT_QADASHBOARD,"searched Dashboard",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ICON_FAVORITE,"Favorite Icon",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void accessingtheRecentRecordsFromSalesforce(){
        waitForSecs(30);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ESCAPE).build().perform();
        safeClick(BTN_APP_LAUNCHER, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_VIEW_ALL, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(HYPERLINK_HOME, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(QADASHBOARD_LINK, "Sales force", MEDIUMWAIT);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LOGIN_ID,"Login",MEDIUMWAIT);
        safeJavaScriptClick(HOME_TAB, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(SAMPLEREPORT_HYPERLINK,"Report Hyperlink",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(PROFILE_ICON, "Sales force", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_LOGOUT, "Sales force", MEDIUMWAIT);
        waitForSecs(5);
    }
}
