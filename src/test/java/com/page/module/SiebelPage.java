package com.page.module;

import com.page.locators.SalesForceLocators;
import com.page.locators.SiebelLocators;
import com.selenium.SafeActions;
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

    public void basicNavigationFlow(){
        driver.navigate().to("http://qa.germainapm.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=qa.germainapm.com");
        safeType(USERID, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeType(PASSWORD, "SADMIN", "Email textbox", MEDIUMWAIT);
        safeClick(LOGIN, "ZENQ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(TAB_CONTACTS, "conatcts", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_OPPORTUNITIES, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_FLEET_MANAGEMENT, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(TAB_CALENDER,"Tab calender",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(FILE_LABEL, "ZENQ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LOGOUT, "Logout button", MEDIUMWAIT);
        waitForSecs(10);

    }
}
