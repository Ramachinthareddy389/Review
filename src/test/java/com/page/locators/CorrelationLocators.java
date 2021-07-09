package com.page.locators;

import org.openqa.selenium.By;

public interface CorrelationLocators {
    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By BTN_CORRELATION = By.xpath("//span[text()='Correlation']");
    By BTN_ADDICON_CORRELATION = By.xpath("//h5[text()='Correlation Scenarios']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath(" //div[contains(@class,'WizardStep')]/div/div[2]/div/div/div/input[@id='name']");
    By TXTBOX_NAME_GENERATOR = By.cssSelector("textarea.inputarea");
    By LABEL_RETENSION = By.xpath("//label[@id='retention-label']");
    By TXTBOX_RETENSION = By.xpath("//div[contains(@class,'WizardStep')]/div/div[5]/div/div/div/input[@id='retention']");
    By LABEL_TYPE = By.xpath("//span[text()='Type']");
    By TYPE_GHOSTEXT = By.xpath("//input[@id='factClass']/../../../div[1]");
    By TXTBOX_TYPE= By.xpath("//input[@id='factClass']");
    By LABEL_KPIS = By.xpath("//input[@id='kpis']/../../../div[1]/../../../../label/p/span[1]");
    By KPIS_GHOSTEXT = By.xpath("//input[@id='kpis']/../../../div[1]");
    By TXTBOX_KPIS = By.xpath("//input[@id='kpis']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_KEYEXP = By.xpath("//span[text()='Key Expression']");
    By KEYEXP_GHOSTEXT = By.xpath("//input[@id='keyExpression']/../../../div[1]");
    By TXTBOX_KEYEXP = By.xpath("//input[@id='keyExpression']");
    By LABEL_FIELD_EXCLUSIONS = By.xpath("//span[text()='Field Exclusions']");
    By FIELD_EXCLUSIONS_GHOSTEXT = By.xpath("//input[@id='fieldExclusions']/../../../div[1]");
    By TXTBOX_FIELD_EXCLUSIONS = By.xpath("//input[@id='fieldExclusions']");
    By LABEL_MASK = By.xpath("//label[@id='mask-label']");
    By TXTBOX_MASK = By.xpath("//input[@id='mask']");
    By BTN_SLAADDICON = By.xpath("//span[text()='Filters']/..//../../button[@aria-label='Add']");
    By Filter_GHOSTEXT = By.xpath("//span[text()='Filters']/../../../../../div[4]/div/div/div/div/div/div/div/div/div/div[text()='Select...']");
    By TXTBOX_FILTESR_VALUE = By.xpath("//button[@aria-label='Delete']/preceding-sibling::i/following-sibling::div/input");
    By TXTBOX_FILTERS = By.xpath("//input[@id='filters_key_0']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By ADDED_NAME_GENERATOR = By.xpath("//div[@class='view-lines']/div/span/span");
    By TXTBOX_EDITED_KPIS = By.xpath("//input[@id='kpis']/../../../div/span");
    By TXTBOX_EDITED_FACTTYPE = By.xpath("//input[@id='factClass']/../../../div[1]");
    By HYPERLINK_TYPES = By.xpath("//span[text()='Types']/../../../div/div/div/button");
    By TXTBOX_EDITED_RETENTION = By.xpath("//input[@id='retention']");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='name']");

}
