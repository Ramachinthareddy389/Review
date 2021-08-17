package com.page.locators;

import org.openqa.selenium.By;

public interface ScriptLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_SCRIPT= By.xpath("//span[text()='Script']");
    By BTN_ADDICON_SCRIPT= By.xpath("//h5[text()='Scripts']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEl_TYPE = By.xpath("//span[text()='Type']");
    By TYPE_GHOSTTEXT = By.xpath("//input[@id ='type']/../../../div[1]");
    By TXTBOX_TYPE = By.xpath("//input[@id ='type']");
    By LABEL_CONTENT = By.xpath("//span[text()='Content']");
    By CONTENT_TEXTAREA = By.cssSelector("textarea.inputarea");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By CHKBOX_RUNSCHEDULE = By.xpath("//span[text()='Run on schedule?']/../../../span/span/input[@type='checkbox']");
    By LABEL_SLA = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span");
    By SLA_GHOSTTEXT = By.xpath("//input[@id='sla']/../../../div[1]");
    By TXTBOX_SLA = By.xpath("//input[@id='sla']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By USED_BY_ACTIONS_HYPERLINK = By.xpath("//span[text()='Used By Actions']/../../../div/div/button");
    By TARGET_BY_SLA_ADD_ICON = By.xpath("//span[text()='Triggered By SLAs']/../../../div/button/span/i");
    By ACTION_SLA_GHOSTTEXT = By.xpath("//input[@id='names']/../../../div[1]");
    By ACTION_SLA_TXTBOX = By.xpath("//input[@id='names']");
    By HYPERLINK_SLAs = By.xpath("//span[text()='Triggered By SLAs']/../../../div/div/button");

}