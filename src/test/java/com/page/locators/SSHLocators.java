package com.page.locators;

import org.openqa.selenium.By;

public interface SSHLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_SSH= By.xpath("//span[text()='SSH']");
    By BTN_ADDICON_SSH= By.xpath("//h5[text()='Secure Shell']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEl_SERVER = By.xpath("//span[text()='Server']");
    By SERVER_GHOSTTEXT = By.xpath("//input[@id ='monitoredServer']/../../../div[1]");
    By TXTBOX_SERVER = By.xpath("//input[@id ='monitoredServer']");
    By LABEl_CREDENTIALS = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span[text()='Credentials']");
    By CREDENTIALS_GHOSTTEXT = By.xpath("//input[@id ='credentials']/../../../div[1]");
    By TXTBOX_CREDENTIALS = By.xpath("//input[@id ='credentials']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By LABEL_PROGRAM = By.xpath("//span[text()='Program']");
    By TXTBOX_PROGRAM = By.xpath("//input[@id='command']");
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
    By EDITED_MONITORED_TXTBOX = By.xpath("//input[@id ='monitoredServer']/../../../div[1]");
    By EDITED_CREDENTIALS_TXTBOX = By.xpath("//input[@id ='credentials']/../../../div[1]");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By LABEL_TYPE = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span[1]");
    By TXTBOX_TYPE = By.xpath("//input[@id='type']");
    By TYPE_GHOSTTEXT = By.xpath("//input[@id='type']/../../../div[1]");
    By LABEL_CONTENT = By.xpath("//span[text()='Content']");
    By CONTENT_TEXTAREA = By.cssSelector("textarea.inputarea");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By EDITED_SCRIPT = By.xpath("//input[@id='script']/../../../div[1]");
    By TARGET_BY_SLA_ADD_ICON = By.xpath("//span[text()='Triggered By SLAs']/../../../div/button/span/i");
    By ACTION_SLA_GHOSTTEXT = By.xpath("//input[@id='names']/../../../div[1]");
    By ACTION_SLA_TXTBOX = By.xpath("//input[@id='names']");
    By SCRIPT_ADDICON = By.xpath("//i[@aria-label='Script to execute.']/../../../../../../button/span/i");
    By BTN_SCRIPT= By.xpath("//span[text()='Script']");
    By LABEL_MONITORED_SERVER = By.xpath("//span[text()='Monitored Server']");
    By LABEL_EDITED_CREDENTIALS = By.xpath("//label/p/span[text()='Credentials']");

    //WMI Locators

    By BTN_WMI = By.xpath("//span[text()='WMI']");
    By BTN_ADDICON_WMI = By.xpath("//h5[text()='Windows Management Instrumentation']/../div/div/button/span/i[@aria-label='Add New Configuration']");

    //Click Locators
    By BTN_CLICK = By.xpath("//span[text()='Click']");
    By BTN_ADDICON_CLICK = By.xpath("//h5[text()='Click']/../div/div/button/span/i");
    By LABEL_RECORD = By.xpath("//li[text()='Record (with click recorder)']");
    By BTN_STOP = By.xpath("//button[text()=' Stop ']");
    By BTN_EXPORT = By.xpath("//button[text()=' Export ']");
    By LABEL_BRWSER_DRIVER_PATH = By.xpath("//span[text()='Browser Driver Path']");
    By TXTBOX_BRSER_DRIVER_PATH = By.xpath("//input[@id='browserDriver']");
    By LABEL_APP_NAME = By.xpath("//span[text()='Application Name']");
    By LABEL_APP_NAME_GHOSTTEXT = By.xpath("//input[@id ='applicationName']/../../../div[1]");
    By TXTBOX_APP_NAME = By.xpath("//input[@id ='applicationName']");
    By BTN_SKIP = By.xpath("//span[text()='Skip']");
    By BTN_CLOSE_CLICK_WINDOW = By.xpath("//button[@aria-label='close']");
    By HYPERLINK_BROWSER_RESIZE = By.xpath("//span[text()='Scenario Steps']/../../../div/div/div[2]/button");
    By HYPERLINK_CLICK_IN_INPUT = By.xpath("//span[text()='Scenario Steps']/../../../div/div/div[3]/button");
    By LABEL_IMPORT_RECORD = By.xpath("//li[text()='Import (from click recorder)']");
    By ICON_IMPORT = By.xpath("//i[@aria-label='Select .json file to import']");
    By LABEL_CUSTOM_ROLE = By.xpath("//li[text()='Custom (Rule)']");
    By LABEL_URL = By.xpath("//span[text()='URL']");
    By TXTBOX_URL  = By.xpath("//input[@id ='url']");
    By RULES_HYPERLINK = By.xpath("//label/p/span[text()='Rules']/../../../div/div/div/button");
    By SCENARIO_STEP_ADD_ICON = By.xpath("//span[text()='Scenario Steps']/../../../div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_STEPNAME = By.xpath("//span[text()='Step Name']");
    By TXTBOX_STEPNAME = By.xpath("//label/p/span[text()='Step Name']/../../../div/input");
    By LABEL_STEPTYPE = By.xpath("//span[text()='Step Type']");
    By STEPTYPE_GHOSTTEXT = By.xpath("//label/p/span[text()='Step Type']/../../../div/div/div/div/div/input[@id ='type']/../../../div[1]");
    By TXTBOX_STEPTYPE= By.xpath("//label/p/span[text()='Step Type']/../../../div/div/div/div/div/input[@id ='type']");
    By LABEL_SELECTOR_TYPE = By.xpath("//span[text()='Primary element selector type']");
    By SELECTOR_TYPE_GHOSTTEXT = By.xpath("//label/p/span[text()='Primary element selector type']/../../../div/div/div/div/div/input[@id ='primaryBy']/../../../div[1]");
    By TXTBOX_SELECTOR_TYPE = By.xpath("//label/p/span[text()='Primary element selector type']/../../../div/div/div/div/div/input[@id ='primaryBy']");
    By HYPERLINK_ADDED_SELECTOR = By.xpath("//span[text()='Scenario Steps']/../../../div/div/div[4]/button");
}