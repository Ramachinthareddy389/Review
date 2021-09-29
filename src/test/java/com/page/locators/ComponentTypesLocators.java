package com.page.locators;

import org.openqa.selenium.By;

public interface ComponentTypesLocators
{
    By BTN_SYSTEM= By.xpath("//span[text()='System']");
    By BTN_ENGINE_SETTINGS = By.xpath("//span[text()='Engine Settings']");
    By BTN_COMPONENT_TYPES = By.xpath("//span[text()='Component Types']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LIST_COMPONENT_TYPES = By.xpath("//li[@role='menuitem']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TXTBOX_USERNAME_QUERY = By.xpath("//textarea[@class='inputarea']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By DASHBOARD_LABEL=By.xpath("//div[contains(@class,'MuiListItem-button')][contains(@id,'react-select')]");

   // By ADDED_TEXT_HTML_TITLE = By.xpath("//span[text()='HTML Title']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");


    //2nd Component
    By LABEL_COMPONENT_NAME = By.xpath("//label[@id='componentName-label']");
    By TXTBOX_COMPONENT_NAME = By.xpath("//input[@id='componentName']");
    By LABEL_QUERY_NAME = By.xpath("//span[text()='Query Name']");
    By TXTBOX_QUERY_NAME = By.xpath("//input[@id='queryName']");
    By LABEL_KPIS = By.xpath("//input[@id='kpi']/../../../div[1]/../../../../label/p/span[1]");
    By KPIS_GHOSTEXT = By.xpath("//input[@id='kpi']/../../../div[1]");
    By TXTBOX_KPIS = By.xpath("//input[@id='kpi']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By CUSTOMRULE_CHKBOX = By.xpath("//span[text()='Custom Rule']/../../../span/span/input");

//3rd component
    By TXTBOX_FILE_PATTERN = By.xpath("//input[@id='pattern']");
    By TXTBOX_TARGET_QUEUE = By.xpath("//input[@id='queueName']");
    By TXTBOX_EXECUTABLE = By.xpath("//input[@id='command']");
    By TXTBOX_ROOT = By.xpath("//input[@id='root']");
    By TXTBOX_PATH = By.xpath("//input[@id='path']");
    By TXTBOX_OID = By.xpath("//input[@id='oid']");
    By TXTBOX_DRIVER_PATH = By.xpath("//input[@id='driverPath']");
    By LABEL_DRIVER = By.xpath("//input[@id='driver']/../../../div[1]/../../../../label/p/span[1]");
    By DRIVER_GHOSTEXT = By.xpath("//input[@id='driver']/../../../div[1]");
    By TXTBOX_DRIVER = By.xpath("//input[@id='driver']");

    //Credentials
    By BTN_CREDENTIALS = By.xpath("//span[text()='Credentials']");
    By LABEL_USERNAME = By.xpath("//label[@id='username-label']");
    By TXTBOX_USERNAME = By.xpath("//input[@id='username']");
    By LABEL_PASSWORD = By.xpath("//label[@id='password-label']");
    By TXTBOX_PASSWORD = By.xpath("//input[@id='password']");
    By TXTBOX_CONFIRM_PASSWRD = By.xpath("//input[@id='confirmPassword']");
    By BTN_UPDATE_PASSWRD = By.xpath("//span[text()='Update Password']");
    By BTN_CHNAGE_PASSWORD = By.xpath("//span[text()='Change Password']");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    //Display Settings
     By LABEL_DISPLAY_SETTINGS = By.xpath("//span[text()='Display Settings']");
     By TXTBOX_IDENTIFIER = By.xpath("//input[@id='identifier']");
     By EDITWINDOW_TITLE = By.xpath("//div[@aria-label='Save Configuration']/../../h5");

     //Distribution List
     By BTN_DISTRIBUTION_LISTS = By.xpath("//span[text()='Distribution Lists']");
     By LABEL_EMAIL_ADDRESS = By.xpath("//input[@id='name']/../../../div[1]/../../../../label/p/span[1]");
     By EMAIL_ADDRESS_GHOSTEXT = By.xpath("//input[@id='name']/../../../div[1]");
     By TXTBOX_EMAIL_ADDRESS = By.xpath("//input[@id='name']");
     By MEMBERS_HYPERLINK = By.xpath("//span[text()='Members']/../../../div/div/div/button");
    By MEMBER_ADDICON = By.xpath("//span[text()='Members']/../../following-sibling::div/button/span/i");
    By BTN_REMOVE_MEMBER = By.xpath("//span[text()='Members']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By EMAIL_ADDRESS_GHOSTTEXT_EDIT_WINDOW = By.xpath("//input[@id='name']/../../../div[2]/../div[1]");
    By TXTBOX_EMAIL_ADDRESSS_EDIT_WINDOW = By.xpath("//input[@id='name']/../../../div[2]/../div[2]/div/input");
    By TXTBOX_SOFT_NAME = By.xpath("//h6[text()='Credentials']/../../../../../div[2]/descendant::input[1]");
}
