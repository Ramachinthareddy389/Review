package com.page.module;

import Fillo.Select;
import com.page.locators.SalesForceLocators;
import com.page.locators.SiebelLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiebelPage extends SafeActions implements SiebelLocators {
    private WebDriver driver;

    public SiebelPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void ChangingInContactNdOpportunitiesOnSibel(String testcaseID) throws InterruptedException {
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        waitForSecs(10);
        safeJavaScriptType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(PASSWORD).sendKeys("SADMIN");
        // safeJavaScriptType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(LOGIN).click();
        // safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(30);
        safeJavaScriptClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(HYPERLINK_ALLCONTACTS, "conatcts", MEDIUMWAIT);
        safeJavaScriptClick(FIRST_CONTACT, "Conatct", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_MOREINFO, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(Contact_STATUS_DROPDOWN).clear();
        waitForSecs(5);
        safeType(Contact_STATUS_DROPDOWN, "Inactive", "inactive", MEDIUMWAIT);
        waitForSecs(10);
        //safeClick(CONTACT_LIST_VALUUES,"",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(BTN_MENU, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(BTN_SAVERECORD, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(TAB_OPPORTUNITIES, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClearAndType(TEXTBOX_OPPORTUNITY, "test123", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(BTN_GO, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(TXTBOX_NAME_TEST).clear();
        waitForSecs(10);
        safeJavaScriptClick(MENU_OPP, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(BTN_SAVERECORD, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
    /*  acceptAlert();
        waitForSecs(10);*/
        safeJavaScriptClearAndType(TXTBOX_NAME_TEST, "testing a workflow123", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(MENU_OPP, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(BTN_SAVERECORD, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeJavaScriptClick(TAB_HOME, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        addingTestcaseUsingSearchFun(testcaseID);
        safeJavaScriptClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void launchTheApp() {
        waitForSecs(10);
        driver.get("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        waitForSecs(10);
        safeJavaScriptType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(PASSWORD).sendKeys("SADMIN");
       // safeJavaScriptType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(LOGIN).click();
       // safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(30);
        safeJavaScriptClick(TAB_ADMINISTRATIVE_PRODUCT, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(TAB_ACCOUNTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(20);
        safeJavaScriptClick(TAB_OPPORTUNITIES, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void logoutFromSiebel() {
        safeJavaScriptClick(TAB_FLEET_MANAGEMENT, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
       safeSelectListBox(By.xpath("//select[@aria-label='First Level View Bar']"), "Calendar", "test", MEDIUMWAIT);
       //safeJavaScriptClick(TAB_CALENDER,"Tab calender",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeJavaScriptClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void alertPopupInSiebel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello');");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
    }

    public void windowPopUpInSiebel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" window.prompt ('User Prompt')");
        waitForSecs(10);
        dismissAlert();
        waitForSecs(5);
    }

    public void recordingUXSessionByUsingAllFunctionKeysinSiebel(String testID) throws InterruptedException {
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        addingTestcaseUsingSearchFun(testID);
        safeJavaScriptClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
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
        safeClick(BTN_CANCEL, "Cancel button", MEDIUMWAIT);
    }

    public void searchingContentUsingSearchBoxInSiebel(String testID) {
        waitForSecs(10);
        driver.get("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        waitForSecs(10);
        safeJavaScriptType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(PASSWORD).sendKeys("SADMIN");
        // safeJavaScriptType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(LOGIN).click();
        waitForSecs(10);
        safeJavaScriptClick(SEARCH_ICON, "Search button", MEDIUMWAIT);
        waitForSecs(30);
        safeSelectOptionInDropDownByVisibleText(COMBOX_BOX, "  Opportunities", "value", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptType(TXTBOX_NAME, "Test1", "Search", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(OPP_SEARCH_BTN, "Search button", MEDIUMWAIT);
        waitForSecs(10);
        safeSelectOptionInDropDownByVisibleText(COMBOX_BOX, "  All", "value", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptType(SEARCH_TXTBOX, testID, "serch", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(BTN_SEARCH, "Search button", MEDIUMWAIT);
        waitForSecs(20);
        System.out.println(isAlertPresent(10));
        try {
            if (isAlertPresent(30)) {
                dismissAlert();
            }

        } catch (Exception e) {

        }

    }


    public void changingTheQueryInSiebel(String testcaseID) throws InterruptedException {
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeJavaScriptType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(PASSWORD).sendKeys("SADMIN");
        // safeJavaScriptType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(LOGIN).click();
        waitForSecs(30);
        safeSelectListBox(DRPDOWN_QUERIES, "High Probability", "Queries Dropdown", MEDIUMWAIT);
        waitForSecs(10);
        addingTestcaseUsingSearchFun(testcaseID);
        waitForSecs(10);
        safeJavaScriptClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeJavaScriptClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void openNoninjectedSiteinNewTab(String testId) throws InterruptedException {
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        waitForSecs(10);
        safeJavaScriptType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(PASSWORD).sendKeys("SADMIN");
        // safeJavaScriptType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(LOGIN).click();
        waitForSecs(30);
        //addingTestcaseUsingSearchFun(testId);
        safeJavaScriptClick(TAB_ACCOUNTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(20);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.co.in/', '_blank');");
        waitForSecs(20);
        try{
            switchToWindow(0);
        }catch (InvalidArgumentException i)
        {

        }
      waitForSecs(10);
        safeJavaScriptClick(TAB_ADMINISTRATIVE_PRODUCT, "Administrative product", MEDIUMWAIT);
        waitForSecs(30);
        safeJavaScriptClick(TAB_OPPORTUNITIES, "Opportunities", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void openInjectedSiteinNewTab(String testID) throws InterruptedException {
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        waitForSecs(10);
        safeJavaScriptType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(PASSWORD).sendKeys("SADMIN");
        // safeJavaScriptType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(LOGIN).click();
        waitForSecs(30);
        addingTestcaseUsingSearchFun(testID);
        safeJavaScriptClick(TAB_ACCOUNTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(20);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://qa.germainapm.com/wordpress/index.php', '_blank');");
        waitForSecs(20);
        switchToWindow(0);
        waitForSecs(10);
        safeJavaScriptClick(TAB_ADMINISTRATIVE_PRODUCT, "Administrative product", MEDIUMWAIT);
        waitForSecs(30);
        safeJavaScriptClick(TAB_OPPORTUNITIES, "Opportunities", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingTestcaseUsingSearchFun(String testcaseID) throws InterruptedException {
        safeJavaScriptClick(SEARCH_ICON, "Search button", MEDIUMWAIT);
        waitForSecs(20);
        safeJavaScriptType(SEARCH_TXTBOX, testcaseID, "serch", MEDIUMWAIT);
        waitForSecs(20);
       /* WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BTN_SEARCH));*/
        safeJavaScriptClick(BTN_SEARCH, "Search button", MEDIUMWAIT);
        Thread.sleep(5000);
        try {
            Alert alert = driver.switchTo().alert(); // switch to alert
            String alertMessage = driver.switchTo().alert().getText(); // capture alert message

            System.out.println(alertMessage); // Print Alert Message
            Thread.sleep(5000);
            alert.dismiss();
        }catch (Exception e)
        {

        }
    }
}
