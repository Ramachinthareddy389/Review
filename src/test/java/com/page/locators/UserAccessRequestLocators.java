package com.page.locators;

import org.openqa.selenium.By;

public interface UserAccessRequestLocators {
    By LABEL_SYSTEM= By.xpath("//span[text()='System']");
    By LABEL_AUTH_SETTINGS = By.xpath("//span[text()='Auth Settings']");
    By LABEL_USER_ACCESS_REQUESTS = By.xpath("//span[text()='User Access Requests']");
    By LABEL_REQUEST_ACCESS = By.xpath("//span[text()='Request Access']");
    By TXTBOX_EMAIL = By.xpath("//input[@class='MuiInputBase-input MuiInput-input']");
    By USERICON=By.xpath("//button[@title='Presentation mode']/following-sibling::button[2]");
    By LOGOUT=By.xpath("//span[text()='Logout']");
    By NOTIFY_TEXT = By.xpath("//span[text()='Close']/../.././../p");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TXT_EMAIL_IN_REQUEST_PAGE = By.xpath("//div[@aria-label='grid']/div/a/div/div/div/span/span");
    By BTN_ACCEPT = By.xpath("//span[text()='Accept']");
    By BTN_REJECT = By.xpath("//span[text()='Reject']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");

    //Users Locators
    By LABEL_USERS = By.xpath("//span[text()='Users']");
    By USERS_EMAIL_TXTBOX    = By.xpath("//input[@id='email']");
    By ADD_USERS_ICON = By.xpath("//i[@aria-label='Add New User']");
    By ROLES_ADD_ICON = By.xpath("//i[@aria-label='Add']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By LABEL_USER_ROLES = By.xpath("//span[text()='User Roles']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
}
