package com.page.locators;

import org.openqa.selenium.By;

public interface AlertTemplateLocators
{
    By BTN_SYSTEM= By.xpath("//span[text()='System']");
    By BTN_ALERT_TEMPLATES = By.xpath("//span[text()='Alert Templates']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By LABEL_TEXT_TITLE = By.xpath("//span[text()='Text Title']");
    By TXTBOX_USERNAME_QUERY = By.xpath("//textarea[@class='inputarea']");
    By LABEL_TEXT_CONTENT = By.xpath("//span[text()='Text Content']");
    By LABEL_HTML_TITLE = By.xpath("//span[text()='HTML Title']");
    By LABEL_HTML_CONTENT = By.xpath("//span[text()='HTML Content']");
    By LABEL_SMS_TITLE = By.xpath("//span[text()='SMS Title']");
    By LABEL_SMS_CONTENT = By.xpath("//span[text()='SMS Content']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By ADDED_TEXT_AREA = By.xpath("(//div[@class='view-line']/span/span)[1]");
    By ADDED_TEXT_CONTENT = By.xpath("(//div[@class='view-line']/span/span)[2]");
    By ADDED_TEXT_HTML_TITLE = By.xpath("(//div[@class='view-line']/span/span)[1]");
    By ADDED_TEXT_HTM_CONTENT = By.xpath("(//div[@class='view-line']/span/span)[2]");
    By ADDED_TEXT_SMS_TITLE = By.xpath("(//div[@class='view-line']/span/span)[1]");
    By ADDED_TEXT_SMS_CONTENT = By.xpath("(//div[@class='view-line']/span/span)[2]");
    By EDITED_TEXT_AREA = By.xpath("//div[@class='view-line']/span/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE1 = By.xpath("//div[@aria-label='Remove Selected Configuration']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    By SLAS_HYPER_LINK = By.xpath("//span[text()='Used By SLAs']/../../following-sibling::div/descendant::button");

    //Alert Locators
    By LABEL_AUTOMATION = By.xpath("//span[text()='Automation']");
    By LABEL_ALERT = By.xpath("//span[text() ='Alert']");
    By DISTRIBUTION_LIST_TXTBOX = By.xpath("//span[text()='Distribution List Name']/../../following-sibling::div/input");

    By DISTRIBUTION_ADD = By.xpath("//button[@aria-label='Add']");
    By LABEL_EMAIL_ADDRESS = By.xpath("//input[@id='name']/../../../div[1]/../../../../label/p/span[1]");
    By EMAIL_ADDRESS_GHOSTEXT = By.xpath("//input[@id='name']/../../../div[1]");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By TXTBOX_EMAIL_ADDRESS = By.xpath("//span[text()='Member Email Address']/../../following-sibling::div/descendant::input");
    By DISTRIBUTION_LIST_NEXT = By.xpath("(//span[text()='Next'])[2]");
    By TXTBOX_EXECUTION_COUNT = By.xpath("//input[@id='limitCount']");
    By SLA_GHOSTTEXT = By.xpath("//input[@id='sla']/../../../div[1]");
    By DRPDOWN_SLA = By.xpath("//input[@id='sla']");
    By DROPDOWN_LIST=By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By EMAIL_SUBJECT = By.xpath("//div[contains(@class,'ellipsis nw')]");
    By BTN_DELETE = By.xpath("//span[text()='Delete']");
    By BTN_REMOVE = By.xpath("//div[@aria-label='Remove Selected Configuration']");
    By LABEL_DAILY_INSIGHT = By.xpath("//span[text()='Daily']");
    By INSIGHTS_PAGE_SIDE_MENU = By.xpath("//span[@title='Insights']/span");
    By BTN_SHOW_ADVANCED = By.xpath("//span[text()='Show Advanced']");
    By LABEL_NOTIFY_ON_SUCCESS = By.xpath("//span[text()='Notify On Success']");
    By LABEL_NOTIFY_ON_FAILURE = By.xpath("//span[text()='Notify On Failure']");
    By LABEL_MENU_BUTTON = By.xpath("//button[@id='delsel']/../../div[1]/button");
    By LABEL_EMPTY_TEXTBOX = By.xpath("//span[text()='Empty Inbox']");
    By TXTBOX_QUITE_TIME = By.xpath("//input[@id='quietTimePeriod']");

    By BTN_EDIT = By.xpath("//div[@aria-label='Edit Selected Configuration']");
    By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Alerts']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER = By.xpath("//h6[text()='Editing 1 Secure Shell']");
    By CHEKBOXES_EDITWINDOW_WMI = By.xpath("//h6[text() ='Editing 1 Alerts']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES_WMI = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER_WMI = By.xpath("//h6[text()='Editing 1 Alerts']");
    By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
    By BTN_EXECUTE = By.xpath("//div[@aria-label='Execute']");
    By BTN_PLAY = By.xpath("//div[@aria-label='Play']");
    By FOOTERTEXT = By.xpath("//span[@id='client-snackbar']");
    By SLAS_HYPERLINK = By.xpath("//span[text()='Triggered By SLAs']/../../following-sibling::div/descendant::button[2]");
    By EYE_ICON = By.xpath("//i[@class='far fa-eye']");
    By KPIS_TEXT = By.xpath("//h6[text()='Distribution List']");
    By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
    By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
    By SLA_LINK = By.xpath("//div[@title='Select Row']/../descendant::button[text()='User Click SLA']");
    By Title_DRILLTHROUGH=By.xpath("//div[contains(@class,'MuiContainer-root ')]/div//following-sibling::div/div/h5");
    By SLA_TXTBOX = By.xpath("//input[@id='slaName']");
}
