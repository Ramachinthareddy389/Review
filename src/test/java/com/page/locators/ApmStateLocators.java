package com.page.locators;

import org.openqa.selenium.By;

public interface ApmStateLocators {
    By APMHEADER = By.xpath("//span[text()='APM']");
    By APMSTATE_HEADER = By.xpath("//span[text()='APM State']");
    By COMPONENTS_TAB = By.xpath("//span[contains(text(),'Components')]");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By COMPONENT_HTTP_SCENARIO = By.xpath("//li[contains(text(),'HTTP Scenario Component Deployment')]");
    By TXTBOX_SERVER = By.xpath("//input[@id='monitoredServer']");
    By TXTBOX_CREDENTIALS = By.xpath("//input[@id='credentials']");
    By TXTBOX_APPNAME = By.xpath("//input[@id='monitoredApplication']");
    By TXTBOX_COMPONENT_TYPE = By.xpath("//input[@id='typeName']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_SKIP = By.xpath("//span[text()='Skip']");
    By TXTBOX_MONIOTOR_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_MONITORING_NAME = By.xpath("//input[@id='nodeAndEngine']");
    By TXTBOX_ENGINE = By.xpath("//input[@id='nodeAndEngine_child']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By SERVER_GHOSTTEXT = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
    By CREDENTIALS_GHOSTTEXT = By.xpath("//input[@id='credentials']/../../../div[1]");
    By APPNAME_GHOSTTEXT = By.xpath("//input[@id='monitoredApplication']/../../../div[1]");
    By MONITOR_NAME_GHOSTTEXT = By.xpath("//input[@id='name']/../../../div[1]");
    By COMPONENTTYPE_GHOSTTEXT = By.xpath("//input[@id='typeName']/../../../div[1]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By TXTBOX_EDITED_APPNAME = By.xpath("//input[@id='monitoredApplication']/../../../div[1]");
    By TXTBOX_EDITED_SERVER = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
}
