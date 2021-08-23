package com.page.locators;

import org.openqa.selenium.By;

public interface PresentationModesLocators {
    By LABEL_SYSTEM= By.xpath("//span[text()='System']");
    By LABEL_PRESENTATION_MODES =By.xpath("//span[text()='Presentation Modes']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_DURATION = By.xpath("//input[@id='duration']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_DASHBOARD    = By.xpath("//span[text()='Dashboard']");
    By DASHBOARD_GHOSTEXT = By.xpath("//input[@id='dashboardName']/../../../div[1]");
    By TXTBOX_DASHBOARD   = By.xpath("//input[@id='dashboardName']");
    By LABEL_TIMERANGE    = By.xpath("//span[text()='Time Range']");
    By TIMERANGE_GHOSTEXT = By.xpath("//input[@id='timerange']/../../../div[1]");
    By TXTBOX_TIMERANGE   = By.xpath("//input[@id='timerange']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By HYPERLINK_DASHBOARDS = By.xpath("//span[text()='Dashboards']/../../../div/div/div/button");
    By TXTBOX_DASHBOARD_VALUE = By.xpath("//input[@id='dashboardName']/.././../../div[1]");
    By CHKBOX_DASHBOARD = By.xpath("//span[text()='Dashboard?']/../../../span/span/input[@type='checkbox']");
    By LABEL_VIEW    = By.xpath("//span[text()='View']");
    By VIEW_GHOSTEXT = By.xpath("//input[@id='contextPath']/../../../div[1]");
    By TXTBOX_VIEW   = By.xpath("//input[@id='contextPath']");
    By TXTBOX_VIEW_VALUE = By.xpath("//input[@id='contextPath']/.././../../div[1]");
}
