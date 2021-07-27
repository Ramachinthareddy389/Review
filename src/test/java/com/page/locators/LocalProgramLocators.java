package com.page.locators;

import org.openqa.selenium.By;

public interface LocalProgramLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_LOCAL_PRGMS = By.xpath("//span[text()='Local Program']");
    By BTN_ADDICON_LOCAL_PRGMS = By.xpath("//h5[text()='Local Programs']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_PROGRAM = By.xpath("//span[text()='Program']");
    By TXTBOX_PROGRAM = By.xpath("//input[@id='command']");
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
    By HYPERLINK_SLAs = By.xpath("//span[text()='Triggered By SLAs']/../../../div/div/button");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By SCRIPT_ADDICON = By.xpath("//button[@aria-label='view']/preceding-sibling::div/button/span/i");
    By LABEL_TYPE = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span[1]");
    By TXTBOX_TYPE = By.xpath("//input[@id='type']");
    By TYPE_GHOSTTEXT = By.xpath("//input[@id='type']/../../../div[1]");
    By LABEL_CONTENT = By.xpath("//span[text()='Content']");
    By CONTENT_TEXTAREA = By.cssSelector("textarea.inputarea");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By EDITED_SCRIPT = By.xpath("//input[@id='script']/../../../div[1]");

}
