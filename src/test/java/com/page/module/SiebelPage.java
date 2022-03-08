package com.page.module;

import com.page.locators.SalesForceLocators;
import com.page.locators.SiebelLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SiebelPage extends SafeActions implements SiebelLocators {
    private WebDriver driver;

    public SiebelPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void ClickingOnSibel() {
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(HYPERLINK_ALLCONTACTS, "conatcts", MEDIUMWAIT);
        safeClick(FIRST_CONTACT, "Conatct", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_MOREINFO, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(Contact_STATUS_DROPDOWN).clear();
        waitForSecs(5);
        safeType(Contact_STATUS_DROPDOWN, "Inactive", "inactive", MEDIUMWAIT);
        waitForSecs(10);
        //safeClick(CONTACT_LIST_VALUUES,"",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_MENU, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SAVERECORD, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_OPPORTUNITIES, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_OPPORTUNITY, "test", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_GO, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TXTBOX_NAME_TEST).clear();
        waitForSecs(10);
        safeClick(MENU_OPP, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SAVERECORD, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        acceptAlert();
        waitForSecs(10);
        safeType(TXTBOX_NAME_TEST, "testing a workflow", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(MENU_OPP, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SAVERECORD, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_HOME, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);

    }
    public void launchTheApp(){
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_OPPORTUNITIES, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void logoutFromSiebel(){
        safeClick(TAB_FLEET_MANAGEMENT, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_CALENDER,"Tab calender",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void alertPopupInSiebel(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello');");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
    }

    public void windowPopUpInSiebel(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" window.prompt ('User Prompt')");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
    }

    public void recordingUXSessionByUsingAllFunctionKeysinSiebel(){
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F1);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F10);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F11);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F12);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F2);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F3);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F4);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F5);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F6);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F7);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F8);
        waitForSecs(5);
        driver.findElement(TAB_CONTACTS).sendKeys(Keys.F9);
        waitForSecs(5);
        safeClick(BTN_CANCEL,"Cancel button",MEDIUMWAIT);
    }

    public void searchingContentUsingSearchBoxInSiebel(){
        waitForSecs(10);
        safeType(TEXTBOX_OPPORTUNITY, "Test1", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_GO, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void changingTheQueryInSiebel(){
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeSelectListBox(DRPDOWN_QUERIES,"High Probability","Queries Dropdown",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);
    }
}
