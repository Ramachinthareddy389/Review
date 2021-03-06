package com.page.locators;

import org.openqa.selenium.By;

public interface SLAsLocators {

    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By BTN_SLAS = By.xpath("//span[text()='SLAs']");
    By BTN_ADDICON_SLAS = By.xpath("//h5[text()='Service Level Agreements']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_KPI_NAME = By.xpath("//span[text()='KPI Name']");
    By KPI_NAME_GHOSTTEXT = By.xpath("//input[@id='name']/../../../div[1]");
    By KPINAME_TXTBOX = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_ALERT = By.xpath("//input[@id='alertTemplate']/../../../div[1]");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_RADIO_SLA_TYPE = By.xpath("//input[@type='radio'][@value='FactBasedSLA']/../../span[2]");
    By LABEL_THRESHOLD  = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='threshold-label']");
    By TXTBOX_THRESHOLD = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='threshold']");
    By LABEL_COLOR = By.xpath("//span[text()='Color if not met']");
    By COLOR_GHOSTTEXT = By.xpath("//input[@id='color']/../../../div[1]");
    By TXTBOX_COLOR = By.xpath("//input[@id='color']");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By LABEL_ALERT_TEMP = By.xpath("//span[text()='Alert Template']");
    By ALERT_GHOSTTEXT = By.xpath("//input[@id='alertTemplate']/../../../div[1]");
    By TXTBOX_ALERT= By.xpath("//input[@id='alertTemplate']");
    By LABEL_ACTIONS = By.xpath("//span[text()='Actions']");
    By ACTIONS_GHOSTTEXT = By.xpath("//input[@id='actions']/../../../div[1]");
    By TXTBOX_ACTIONS= By.xpath("//input[@id='actions']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='slaName']");
    By EDITED_NAME_LABEl = By.xpath("//span[text()='Name']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By HYPERLINK_THRESHOLD = By.xpath("//span[text()='Thresholds']/../../../div/div/div/button");
    By BTN_REMOVE_THRESHOLDS = By.xpath("//span[text()='Thresholds']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By LABEL_THRESHOLD_EDITED = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='thresholdValue-label']");
    By TXTBOX_THRESHOLD_EDITED = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='thresholdValue']");
    By ACTIONS_GHOSTTEXT_EDITED = By.xpath("//input[@id='actionsUsages']/../../../div[1]");
    By ACTIONS_TXTBOX_EDITED = By.xpath("//input[@id='actionsUsages']");
    By THRESHOLDS_ADD_ICON = By.xpath("//span[text()='Thresholds']/../../following-sibling::div/button/span/i");
    By SELECT_ALL_CKHBOX = By.xpath("//input[@type='checkbox'][@aria-label='Select All']");
    By DELETE_SLAS = By.xpath("//div[@aria-label='Remove Selected Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By ACTIONS_ADD_ICON = By.xpath("//span[text()='Actions']/../../following-sibling::div/button/span/i");
    By BTN_REMOVE_ACTIONS = By.xpath("//span[text()='Actions']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By LABEL_ACTIONS_NAME = By.xpath("//span[text()='Action Name']");
    By ACTIONS_NAME_GHOSTTEXT = By.xpath("//input[@id='name']/../../../div[text()='Select or Add...']");
    By TXTBOX_ACTIONS_NAME= By.xpath("//input[@id='name']/../../../div[text()='Select or Add...']/../div[2]/div/input");
    By HYPERLINK_ACTIONS = By.xpath("//span[text()='Actions']/../../../div/div/div/button");
    By ALERT_TEMPLATE_ADDICON = By.xpath("//span[text()='Alert Template']/../../../../../following-sibling::button");
    By Title_DRILLTHROUGH = By.xpath("//div[contains(@class,'MuiContainer-root ')]/div//following-sibling::div/div/h5");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By TITLE_IN_ALERTTEMPLATE = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//div[@aria-label='Remove Selected Configuration']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    By EYE_ICON = By.xpath("//i[@class='far fa-eye']");
    By KPIS_TEXT = By.xpath("//h6[text()='KPIs']");
    By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
    By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
    By HYPERLINK_SLAs = By.xpath("//span[text()='SLAs']/../../../div/div/div/button");
    By BTN_SYSTEM= By.xpath("//span[text()='System']");
    By BTN_ALERT_TEMPLATES = By.xpath("//span[text()='Alert Templates']");
}
