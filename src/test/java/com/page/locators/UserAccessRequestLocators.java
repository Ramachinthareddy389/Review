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
    By NOTIFY_MESSAGE= By.xpath("//span[text()='Cancel']/../.././../p");

    //Users Locators
    By LABEL_USERS = By.xpath("//span[text()='Users']");
    By USERS_EMAIL_TXTBOX    = By.xpath("//input[@id='email']");
    By ADD_USERS_ICON = By.xpath("//i[@aria-label='Add New User']");
    By ROLES_ADD_ICON = By.xpath("//i[@aria-label='Add']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By LABEL_USER_ROLES = By.xpath("//span[text()='User Roles']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove User']");
    By TYPE_DRPDOWN = By.xpath("//input[@id='type']");
    By TYPE_GHOSTTEXT = By.xpath("//input[@id='type']/../../../div[1]");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save User']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By BTN_RESET_PASSWORD = By.xpath("//span[text()='Reset Password']");
    By TXT_SEND_WELCOME_EMAIL = By.xpath("//span[text()='Send Welcome Email']");
    By TXTBOX_TYPE = By.xpath("//input[@id ='type']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[contains(text(),'Type')]");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//div[@aria-label='Enable Selected User(s)']");
    By BTN_DISABLE = By.xpath("//div[@aria-label='Disable Selected User(s)']");
    By BTN_CLONE = By.xpath("//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//div[@aria-label='Remove Selected User(s)']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save User']/following-sibling::div[@aria-label='Disable User']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable User']");
    By EYE_ICON = By.xpath("//button[@aria-label='view']");
    By KPIS_TEXT = By.xpath("//h6[text()='Dashboard']");
    By BTN_SAVE_USER = By.xpath("//div[@aria-label='Save User']");
    By BTN_EDIT = By.xpath("//div[@aria-label='Edit Selected Configuration']");
    By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Roles']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER = By.xpath("//h6[text()='Editing 1 Secure Shell']");
    //

    By ICON_USER = By.xpath("//span[@class='MuiIconButton-label']/descendant::i[contains(@class,'fas fa-user')]");
    By BTN_SETTINGS = By.xpath("//span[text()='Settings']");
    By BTN_CHANGEPASSWRD = By.xpath("//span[text()='Change Password']");
    By TXTBOX_PASSWRD = By.xpath("//input[@id='password']");
    By TXTBOX_CONFIRM_PASSWRD = By.xpath("//input[@id='confirmPassword']");
    By BTN_UPDATE_PASSWRD = By.xpath("//span[text()='Update Password']");
    By CHANGPASSWORD_CLOSE = By.xpath("//button[@aria-label='close']");
    By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    By LOGIN_BTN = By.xpath("//span[normalize-space()='Login']");
    By HYPERLINK_FORGOTPASSWD = By.xpath("//a[text()='Forgot Password']");
    By USERNAME_TXTBOX = By.xpath("//input[@type='text']");
    By BTN_RESET = By.xpath("//span[text()='Reset Password']");
    By EMAILADDRESS_FIELD = By.xpath("//input[@type='text']");
    By INVALID_NOTIFY = By.xpath("//h6[text()='Authentication Failed']");
    By LABEL_OPERATIONAL = By.xpath("//span[text()='Operational']");



}
