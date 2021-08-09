package com.page.locators;

import org.openqa.selenium.By;

public interface AuthenticationLocators {
    By BTN_SYSTEM= By.xpath("//span[text()='System']");
    By BTN_AUTH_SETTINGS = By.xpath("//span[text()='Auth Settings']");
    By BTN_AUTHENTICTION  = By.xpath("//span[text()='Authentication']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By BTN_JDBC_RADIO = By.xpath("//p[text()='JDBC Provider']");
    By BTN_LDAP_RADIO = By.xpath("//input[@value='LDAP']");
    By BTN_OATH_RADIO = By.xpath("//input[@value='OAUTH']");
    By LABEL_PROVIDER_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_PROVIDER_NAME = By.xpath("//input[@id='name']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By LABEL_MANAGER_PASS = By.xpath("//label[@id='managerPassword-label']");
    By TXTBOX_MANAGER_PASS = By.xpath("//input[@id='managerPassword']");
    By LABEL_CLIENT_ID= By.xpath("//label[@id='clientId-label']");
    By TXTBOX_CLIENT_ID = By.xpath("//input[@id='clientId']");
    By LABEL_CLIENT_SECRET = By.xpath("//label[@id='clientSecret-label']");
    By TXTBOX_CLIENT_SECRET = By.xpath("//input[@id ='clientSecret']");
    By TXTBOX_USERNAME_QUERY = By.xpath("//textarea[@class='inputarea']");
}
