package com.page.locators;

import org.openqa.selenium.By;

public interface AuthenticationLocators {
    By BTN_SYSTEM= By.xpath("//span[text()='System']");
    By BTN_AUTH_SETTINGS = By.xpath("//span[text()='Auth Settings']");
    By BTN_AUTHENTICTION  = By.xpath("//span[text()='Authentication']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By BTN_JDBC_RADIO = By.xpath("//p[text()='JDBC Provider']");
    By BTN_LDAP_RADIO = By.xpath("//p[text()='LDAP Provider']");
    By BTN_OATH_RADIO = By.xpath("//p[text()='OAuth Provider']");
    By LABEL_PROVIDER_NAME = By.xpath("//span[text()='Provider Name']");
    By TXTBOX_PROVIDER_NAME = By.xpath("//span[text()='Provider Name']/../../../div/input");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By LABEL_MANAGER_PASS = By.xpath("//label[@id='managerPassword-label']");
    By TXTBOX_MANAGER_PASS = By.xpath("//input[@id='managerPassword']");
    By LABEL_CLIENT_ID= By.xpath("//label[@id='clientId-label']");
    By TXTBOX_CLIENT_ID = By.xpath("//input[@id='clientId']");
    By LABEL_CLIENT_SECRET = By.xpath("//label[@id='clientSecret-label']");
    By TXTBOX_CLIENT_SECRET = By.xpath("//input[@id ='clientSecret']");
    By LABEL_GRANT_TYPE = By.xpath("//span[text()='Authorization Grant Type']");
    By TXTBOX_GRANT_TYPE = By.xpath("//input[@id='authorizationGrantType']");
    By LABEL_URI_TEMP = By.xpath("//span[text()='Redirect URI Template']");
    By TXTBOX_URI_TEMP = By.xpath("//input[@id='redirectUriTemplate']");
    By LABEL_AUTH_URI = By.xpath("//span[text()='Authorization URI']");
    By TXTBOX_AUTH_URI = By.xpath("//input[@id='authorizationUri']");
    By LABEL_TOKEN_URI = By.xpath("//span[text()='Token URI']");
    By TXTBOX_TOKEN_URI = By.xpath("//input[@id='tokenUri']");
    By LABEL_USER_INFO_URI = By.xpath("//span[text()='User Info URI']");
    By TXTBOX_USER_INFO_URI = By.xpath("//input[@id='userInfoUri']");
    By LABEL_JSK_SET_URI = By.xpath("//span[text()='JWK Set URI']");
    By TXTBOX_JSK_SET_URI = By.xpath("//input[@id='jwkSetUri']");
    By LABEL_USR_NAME_ATTR = By.xpath("//span[text()='User Name Attribute']");
    By TXTBOX_USR_NAME_ATTR  = By.xpath("//input[@id='userNameAttribute']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By BTN_SHOW_ADVANCED = By.xpath("//span[text()='Show Advanced']");
    By TXTBOX_USERNAME_QUERY = By.xpath("//textarea[@class='inputarea']");
    By LABEL_USED_BY_USERNAME_QUERY = By.xpath("//span[text()='User By Username Query']");
    By LABEL_AUTHORITIES_BY_USERNAME = By.xpath("//span[text()='Authorities By Username Query']");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By ADDED_USERNAME_QUALITY = By.xpath("//span[text()='User By Username Query']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By ADDED_AUTHORITIES_QUALITY = By.xpath("//span[text()='Authorities By Username Query']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By TXTBOX_URL = By.xpath("//input[@id='url']");
    By BTN_MANAGE_PASSWORD = By.xpath("//span[text()='Manager Password']");
    By TXTBOX_PASSWORD = By.xpath("//input[@id='password']");
    By TXTBOX_CONFIRM_PASSWORD = By.xpath("//input[@id='confirmPassword']");
    By BTN_UPDATE_PASSWORD = By.xpath("//span[text()='Update Password']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//div[@aria-label='Remove Selected Configuration']");
}
