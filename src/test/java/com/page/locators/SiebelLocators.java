package com.page.locators;

import org.openqa.selenium.By;

public interface SiebelLocators {
    By USERID = By.xpath("//input[@title='User ID']");
    By PASSWORD = By.xpath("//input[@type='password']");
    By LOGIN= By.xpath("//a[text()='Login']");
    By TAB_CONTACTS = By.xpath("//a[text()='Contacts']");
    By HYPERLINK_ALLCONTACTS = By.xpath("//a[text()='All Contacts']");
    By FIRST_CONTACT = By.xpath("//a[text()='Administrator']");
    By TAB_MOREINFO = By.xpath("//a[text()='More Info']");
    By Contact_STATUS_DROPDOWN = By.xpath("//input[@aria-label='Contact Status']");
    By CONTACT_LIST_VALUUES = By.xpath("//div[@id='mask']/following-sibling::ul[1]/li/a[text()='Inactive']");
    By BTN_MENU = By.xpath("(//button[@title='Contact Menu'])[2]");
    By BTN_SAVERECORD = By.xpath("(//a[contains(text(),'Save Record')])[2]");
    By TAB_OPPORTUNITIES = By.xpath("//a[text()='Opportunities']");
    By TAB_FLEET_MANAGEMENT = By.xpath("//a[text()='Fleet Management']");
    By TEXTBOX_OPPORTUNITY =By.xpath("(//input[@aria-label='Opportunity'])[1]");
    By BTN_GO = By.xpath("//button[text()='Go']");
    By TXTBOX_NAME_TEST = By.xpath("//input[@aria-label='Name']");
    By TAB_HOME = By.xpath("//a[text()='Home']");
    By FILE_LABEL = By.xpath("//span[text()='File']");
    By LOGOUT = By.xpath("//a[contains(text(),'Log Out')]");
    By MENU_OPP= By.xpath("//button[@title='Opportunity Menu']");
    By TAB_CALENDER = By.xpath("//a[text()='Calendar']");
    By BTN_CANCEL = By.xpath("//button[text()='Cancel']");
    By DRPDOWN_QUERIES = By.xpath("//select[@title='Saved Queries']");
    By TAB_ACCOUNTS = By.xpath("//a[text()='Accounts']");
    By TAB_ADMINISTRATIVE_PRODUCT = By.xpath("//a[text()='Administration - Product']");
    By SEARCH_ICON = By.xpath("//div[@id='srch_icon']");
    By COMBOX_BOX = By.xpath("//select[@id='lookinCombo']");
    By SEARCH_TXTBOX = By.xpath("//*[@id='text-box']");
    By BTN_SEARCH = By.xpath("//button[@id='srch-button']");
    By TXTBOX_NAME = By.xpath("//input[@title='Name']");
    By OPP_SEARCH_BTN = By.xpath("//button[@id='inner-adv-find-button']");
    By BTN_CLOSE = By.xpath("i[class*='largeBannerCloser']");

}
