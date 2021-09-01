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
}
