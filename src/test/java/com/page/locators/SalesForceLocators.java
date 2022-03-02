package com.page.locators;

import org.openqa.selenium.By;

public interface SalesForceLocators {
    By USERNAME = By.xpath("//input[@id='username']");
    By PASSWORD_SALES = By.xpath("//input[@id='password']");
    By LOGIN_SALES = By.xpath("//input[@id='Login']");
    By CHATTER_TAB = By.xpath("//a[text()='Chatter']");
    By REPORTS_TAB = By.xpath("//a[text()='Reports']");
    By DASHBOARDS_TAB = By.xpath("//a[text()='Dashboards']");
    By SEARCH_COMBO_BOX  = By.xpath("//input[@id='x-auto-0-input']");
    By BTN_REFRESH = By.xpath("//input[@id='refreshInput']");
    By BTN_SEARCH_TOP = By.xpath("//input[@id='phSearchButton']");
    By DOWN_ARR_BTN = By.xpath("//div[@id='userNav-arrow']");
    By BTN_LOGOUT = By.xpath("//a[text()='Log Out']");
    By TXTBOX_SETTING_URL = By.xpath("//input[@id='settings-url']");
    By BTN_ADD_NEW_WEBSITE = By.xpath("//button[text()=' Add New Website ']");
    By TXTBOX_WEBSITE_URL = By.xpath("//input[@id='website-url']");
    By TXTBOX_WEBSITE_APPNAME = By.xpath("//input[@id='website-app-name']");
    By TXTBOX_WEBSITE_PROFILENAME = By.xpath("//input[@id='website-profile-name']");
    By BTN_SAVE_NEW_WEBSITE = By.xpath("(//button[text()=' Save '])[2]");
    By URL_SAVE = By.xpath("(//button[text()=' Save '])[1]");
    By CHKBOX_REMEMBER = By.xpath("//input[@id='rememberUn']");
    By BTN_APP_LAUNCHER = By.xpath("//button[@class='slds-button slds-show']");
    By BTN_VIEW_ALL = By.xpath("//button[text()='View All']");
    By HYPERLINK_HOME = By.xpath("//p[text()='Home']");
    By HYPERLINK_VIEWCALENDER = By.xpath("//span[text()='View Calendar']");
    By HOME_TAB = By.xpath("//span[text()='Home']");
    By PROFILE_ICON = By.xpath("//div[contains(@class,'profileTrigger')]");
    By TODAY_VIEW_ALL = By.xpath("//span[text()='View All']");

}
