package com.page.module;

import com.page.locators.AlertTemplateLocators;
import com.page.locators.AuthenticationLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
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
        safeClick(LABEL_USED_BY_USERNAME_QUERY, "Text title label", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElements(TXTBOX_USERNAME_QUERY).get(0);
        searchField.sendKeys(del + "test");
        safeClick(LABEL_AUTHORITIES_BY_USERNAME, "Text title label", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElements(TXTBOX_USERNAME_QUERY).get(1);
        searchField1.sendKeys(del + "test1");
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        String exp = safeGetText(ADDED_USERNAME_QUALITY, "user name qury", MEDIUMWAIT);
        Assert.assertEquals("test", exp);
        String exp2 = safeGetText(ADDED_AUTHORITIES_QUALITY, "Authorities quality", MEDIUMWAIT);
        Assert.assertEquals("test1", exp2);
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
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        String exp=  safeGetAttribute(TXTBOX_URL,"value","url value",MEDIUMWAIT);
        Assert.assertEquals(exp,"URLs");
    }

    public  void updatingManagerPassword()
    {
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
        safeClick(BTN_MANAGE_PASSWORD,"Manage password",MEDIUMWAIT);
        safeType(TXTBOX_PASSWORD,"test1","Password Textbox",MEDIUMWAIT);
        safeType(TXTBOX_CONFIRM_PASSWORD,"test1","Confirm password",MEDIUMWAIT);
        safeClick(BTN_UPDATE_PASSWORD,"Update password",MEDIUMWAIT);
        waitForSecs(15);
        driver.switchTo().alert().accept();
        System.out.println("Updated Password");
        waitForSecs(30);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
}