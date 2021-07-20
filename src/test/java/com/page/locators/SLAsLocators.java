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
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='slaName']");
    By EDITED_NAME_LABEl = By.xpath("//span[text()='Name']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
   
}
