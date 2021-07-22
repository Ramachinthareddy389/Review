package com.page.locators;

import org.openqa.selenium.By;

public interface HTTPLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_HTTP = By.xpath("//span[text()='HTTP']");
    By BTN_ADDICON_HTTP = By.xpath("//h5[text()='Http Actions']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_KPI_NAME = By.xpath("//span[text()='KPI Name']");
    By KPI_NAME_GHOSTTEXT = By.xpath("//input[@id='name']/../../../div[1]");
    By KPINAME_TXTBOX = By.xpath("//input[@id='name']");
    By LABEL_ACTIONS_NAME = By.xpath("//span[text()='Action Name']");
    By ACTIONS_NAME_GHOSTTEXT = By.xpath("//input[@id='name']/../../../div");
    By TXTBOX_ACTIONS_NAME= By.xpath("//input[@id='name']/../../../../div/div/div/input");
    By LABEL_PATH = By.xpath("//label[@id='path-label']/p/span[text()='Path']");
    By PATH_GHOSTTEXT = By.xpath("//input[@id='path']/../../../div");
    By TXTBOX_PATH= By.xpath("//input[@id='path']/../../../../div/div/div/input");
    By LABEL_REQUEST_METHOD = By.xpath("//span[text()='Request Method']");
    By REQUEST_METHOD_GHOSTTEXT = By.xpath("//input[@id='method']/../../../div[1]");
    By TXTBOX_REQUEST_METHOD= By.xpath("//input[@id='method']");
    By LABEL_CONTENT_TYPE = By.xpath("//span[text()='Content Type']");
    By CONTENT_TYPE_GHOSTTEXT = By.xpath("//input[@id='contentType']/../../../div[1]");
    By TXTBOX_CONTENT_TYPE = By.xpath("//input[@id='contentType']");
    By LABEL_SLA = By.xpath("//span[text()='SLA']");
    By SLA_GHOSTTEXT = By.xpath("//input[@id='sla']/../../../div[1]");
    By TXTBOX_SLA = By.xpath("//input[@id='sla']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By HYPERLINK_SLAs = By.xpath("//span[text()='Triggered By SLAs']/../../../div/div/button");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_TARGET_PATH = By.xpath("//input[@id='target.path']");
    By TXTBOX_EDITED_TARGET_METHOD = By.xpath("//input[@id='target.method']/../../../div[1]");
    By TXTBOX_EDITED_TARGET_CONTENT_TYPE = By.xpath("//input[@id='target.contentType']/../../../div[1]");

}
