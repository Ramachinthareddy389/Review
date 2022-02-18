package com.page.module;

import com.page.locators.AlertTemplateLocators;
import com.page.locators.AuthenticationLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

public class AuthenticationPage extends SafeActions implements AuthenticationLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    static int j;
    String Name_Add, KPIS_add, KeyExp_add, StepName_Add, SLA_Add, EditKey_Exp_add, Edited_KPIS_add, Edited_Name_Add;
    Random random = new Random();
    String dname = "BP";
    String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    String editBP1 = editBP + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);

    //Constructor to define/call methods
    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAuthentication() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_AUTH_SETTINGS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_AUTHENTICTION, "Datasources label from left side pane", MEDIUMWAIT);

    }

    public void navigatingToAuthPage() {
        safeClick(BTN_AUTHENTICTION, "Datasources label from left side pane", MEDIUMWAIT);
    }

    public void addingJDBCAuthentication() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(BTN_JDBC_RADIO, "Name Feild", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_PROVIDER_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROVIDER_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }


    public void verifyingAddedAuthentication() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingLADPAuthentication() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(BTN_LDAP_RADIO, "Name Feild", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_PROVIDER_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROVIDER_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_MANAGER_PASS, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_MANAGER_PASS, dname1, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void addingOauthAuthentication() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(BTN_OATH_RADIO, "Name Feild", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_PROVIDER_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROVIDER_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_CLIENT_ID, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_CLIENT_ID, "Test", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_CLIENT_SECRET, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_CLIENT_SECRET, "Test123", "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_SHOW_ADVANCED, "Show advanced button", MEDIUMWAIT);
        safeClick(LABEL_GRANT_TYPE, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_GRANT_TYPE, "Test123", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_URI_TEMP, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_URI_TEMP, "https://google.com", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_AUTH_URI, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_AUTH_URI, "https://google.com", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_TOKEN_URI, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_TOKEN_URI, "https://google.com", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_USER_INFO_URI, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_USER_INFO_URI, "https://google.com", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_JSK_SET_URI, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_JSK_SET_URI, "https://google.com", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_USR_NAME_ATTR, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_USR_NAME_ATTR, "Test123", "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void editAuthenticationConfigurations() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
     /*   safeClick(TXTBOX_NAME, "Text title label", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + "test");*/
        safeJavaScriptClearAndType(TXTBOX_NAME,"test","Name textbox",MEDIUMWAIT);
       /* safeClick(LABEL_AUTHORITIES_BY_USERNAME, "Text title label", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElements(TXTBOX_USERNAME_QUERY).get(1);
        searchField1.sendKeys(del + "test1");*/
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        String exp = safeGetText(TXTBOX_NAME, "user name qury", MEDIUMWAIT);
        Assert.assertEquals("test", exp);
/*        String exp2 = safeGetText(ADDED_AUTHORITIES_QUALITY, "Authorities quality", MEDIUMWAIT);
        Assert.assertEquals("test1", exp2);*/
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editLDAPConfig() {

        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_URL);
        searchField.sendKeys(del + "URLs");
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        String exp = safeGetAttribute(TXTBOX_URL, "value", "url value", MEDIUMWAIT);
        Assert.assertEquals(exp, "URLs");
        safeClick(CLOSE_EDITWINDOW, "Close edit window", MEDIUMWAIT);
    }

    public void updatingManagerPassword() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeClick(BTN_MANAGE_PASSWORD, "Manage password", MEDIUMWAIT);
        safeType(TXTBOX_PASSWORD, "test1", "Password Textbox", MEDIUMWAIT);
        safeType(TXTBOX_CONFIRM_PASSWORD, "test1", "Confirm password", MEDIUMWAIT);
        safeClick(BTN_UPDATE_PASSWORD, "Update password", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void verifyingPageIcons() {
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + dname1 + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        waitForSecs(10);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        waitForSecs(10);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1 + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        waitForSecs(25);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        safeClick(BTN_DELETE, "Delete Slas", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void applyingFiltersInAlertsPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + dname1 + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, dname1);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void verifyingIconsInEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + dname1 + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }

    }
}