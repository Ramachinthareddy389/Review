package com.page.locators;

import org.openqa.selenium.By;

public interface PresentationModesNdRulesLocators {
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
    By BTN_REMOVE_DASHBOARDS = By.xpath("//span[text()='Dashboards']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By DASHBOARDS_ADD_ICON = By.xpath("//span[text()='Dashboards']/../../following-sibling::div/button/span/i");
    By PLAY_BTN_ICON = By.xpath("//button[@title='Fullscreen mode']/following-sibling::button/span/i[contains(@class,'far fa-play-circle')]");
    By PLAYMODE_DRPDOWN = By.xpath("//ul/li[@role='menuitem']");

    //Rules Configurations
    By LABEL_ENGINE_SETTINGS = By.xpath("//span[text()='Engine Settings']");
    By LABEL_RULES = By.xpath("//span[text()='Engine Settings']/../../following-sibling::div[1]/div/a[3]/span[2]/span[1]");
    By TEXTAREA_CONTENT = By.xpath("//textarea[@class='inputarea']");
    By CONTENT_VAULUE = By.xpath("//div[@class='view-line']/span/span");

    //TimeRanges
    By LABEL_TIMERANGES = By.xpath("//span[text()='Time Ranges']");
    By BTN_ABSOLUTE_RADIO = By.xpath("//p[text()='Absolute Time Range']/../../span/span/input[1]");
    By TXTBOX_MINUTE = By.xpath("//input[@id='value_minute']");
    By TXTBOX_HOUR = By.xpath("//input[@id='value_hour']");
    By TXTBOX_DAY = By.xpath("//input[@id='value_day']");
    By TXTBOX_YEAR = By.xpath("//input[@id='value_year']");
    By TXTBOX_MONTH = By.xpath("//input[@id='value_month']");
    By TXTBOX_START_EDIT_MINUTE = By.xpath("//input[@id='Start_minute']");
    By TXTBOX_START_EDIT_HOUR = By.xpath("//input[@id='Start_hour']");
    By TXTBOX_START_EDIT_DAY = By.xpath("//input[@id='Start_day']");
    By TXTBOX_START_EDIT_YEAR = By.xpath("//input[@id='Start_year']");
    By TXTBOX_START_EDIT_MONTH = By.xpath("//input[@id='Start_month']");

    By TXTBOX_END_EDIT_MINUTE = By.xpath("//input[@id='End_minute']");
    By TXTBOX_END_EDIT_HOUR = By.xpath("//input[@id='End_hour']");
    By TXTBOX_END_EDIT_DAY = By.xpath("//input[@id='End_day']");
    By TXTBOX_END_EDIT_YEAR = By.xpath("//input[@id='End_year']");
    By TXTBOX_END_EDIT_MONTH = By.xpath("//input[@id='End_month']");

}
