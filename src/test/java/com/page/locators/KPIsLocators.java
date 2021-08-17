package com.page.locators;

import org.openqa.selenium.By;

public interface KPIsLocators {
    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By BTN_KPIS = By.xpath("//span[text()='KPIs']");
    By BTN_ADDICON_KPIS = By.xpath("//h5[text()='Key Performance Indicators']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By LABEL_FACTTYPE = By.xpath("//span[text()='Fact Type']");
    By FACTTYPE_GHOSTEXT = By.xpath("//input[@id='factClass']/../../../div[1]");
    By TXTBOX_FACTTYPE= By.xpath("//input[@id='factClass']");
    By LABEL_FACT_CATEGORY = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='factCategory-label']");
    By TXTBOX_FACT_CATEGORY = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='factCategory']");
    By LABEL_DSCATEGORY = By.xpath("//span[text()='Data Source Category']");
    By DSCATEGORY_GHOSTTEXT = By.xpath("//input[@id='dataSourceCategory']/../../../div[1]");
    By TXTBOX_DSCATEGORY = By.xpath("//input[@id='dataSourceCategory']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_RADIO_SLA_TYPE = By.xpath("//input[@type='radio'][@value='FactBasedSLA']/../../span[2]");
    By LABEL_THRESHOLD  = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='threshold-label']");
    By TXTBOX_THRESHOLD = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='threshold']");
    By LABEL_COLOR = By.xpath("//span[text()='Color if not met']");
    By COLOR_GHOSTTEXT = By.xpath("//input[@id='color']/../../../div[1]");
    By TXTBOX_COLOR = By.xpath("//input[@id='color']");
    By LABEL_ALERT_TEMP = By.xpath("//span[text()='Alert Template']");
    By ALERT_GHOSTTEXT = By.xpath("//input[@id='alertTemplate']/../../../div[1]");
    By TXTBOX_ALERT= By.xpath("//input[@id='alertTemplate']");
    By LABEL_ACTIONS = By.xpath("//span[text()='Actions']");
    By ACTIONS_GHOSTTEXT = By.xpath("//input[@id='actions']/../../../div[1]");
    By TXTBOX_ACTIONS= By.xpath("//input[@id='actions']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By HYPERLINK_SLAs = By.xpath("//span[text()='SLAs']/../../../div/div/div/button");
    By TXTBOX_EDITED_FACTTYPE = By.xpath("//input[@id='factClass']/../../../div[1]");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_FACT_CATEGORY = By.xpath("//input[@id='factCategory']");
    By EDITED_NAME_LABEl = By.xpath("//span[text()='Name']");
    By EDITED_FACTCATEGORY_LABEl = By.xpath("//span[text()='Fact Category']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By BTN_REMOVE_SLAS = By.xpath("//span[text()='SLAs']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By SLAS_ADD_ICON = By.xpath("//span[text()='SLAs']/../../following-sibling::div/button/span/i");
    By BTN_REMOVE_THRESHOLDS = By.xpath("//span[text()='Thresholds']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By THRESHOLDS_ADD_ICON = By.xpath("//span[text()='Thresholds']/../../following-sibling::div/button/span/i");
    By LABEL_THRESHOLD_EDITED = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='thresholdValue-label']");
    By TXTBOX_THRESHOLD_EDITED = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='thresholdValue']");
    By ACTIONS_GHOSTTEXT_EDITED = By.xpath("//input[@id='actionsUsages']/../../../div[1]");
    By ACTIONS_TXTBOX_EDITED = By.xpath("//input[@id='actionsUsages']");
    By HYPERLINK_THRESHOLD = By.xpath("//span[text()='Thresholds']/../../../div/div/div/button");
    By HYPERLINK_DRILLTHROUGH = By.xpath("//a[contains(@href,'#Drillthrough')]");
    By TITLE_DRILLTHROUGH = By.xpath("//form[@id='export']/../../../h5");
    By ACTIONS_ADD_ICON = By.xpath("//span[text()='Actions']/../../following-sibling::div/button/span/i");
    By BTN_REMOVE_ACTIONS = By.xpath("//span[text()='Actions']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By LABEL_ACTIONS_NAME = By.xpath("//span[text()='Action Name']");
    By ACTIONS_NAME_GHOSTTEXT = By.xpath("//input[@id='name']/../../../div[text()='Select or Add...']");
    By TXTBOX_ACTIONS_NAME= By.xpath("//input[@id='name']/../../../div[text()='Select or Add...']/../div[2]/div/input");
    By HYPERLINK_ACTIONS = By.xpath("//span[text()='Actions']/../../../div/div/div/button");
    By SELECT_ALL_CKHBOX = By.xpath("//input[@type='checkbox'][@aria-label='Select All']");
    By DELETE_SLAS = By.xpath("//div[@aria-label='Remove Selected Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
}