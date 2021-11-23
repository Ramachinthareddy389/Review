package com.page.locators;

import org.openqa.selenium.By;

public interface UXSettingsLocators {
    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By LABEL_UXSETTINGS = By.xpath("//span[text()='UX Settings']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By WEBXAGENT_HYPERLINK = By.xpath("//h4[text()='Web-UX Agents that are using this profile']/following-sibling::ul/li/button");
    By WEBXAGENT_TITLE = By.xpath("//h5[text()='sample wizard 1']");
    By TXTBOX_APP_PROFILE = By.xpath("//input[@id='monitoringProfileName']/../../parent::div/div[1]");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By BTN_ENABLE = By.xpath("//h5[text()='Application Profiles']/..//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//h5[text()='Application Profiles']/..//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//h5[text()='Application Profiles']/..//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//h5[text()='Application Profiles']/..//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By BTN_EDIT = By.xpath("//h5[text()='Application Profiles']/..//div[@aria-label='Edit Selected Configuration']");
    By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Application Profiles']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER = By.xpath("//h6[text()='Editing 1 Application Profiles']");
    By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    By EYE_ICON = By.xpath("//label[@for='monitoringProfileName']/../../../../following-sibling::button/span/i[@class='far fa-eye']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By KPIS_TEXT = By.xpath("//h6[text()='Application Profile']");
    By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
    By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
}
