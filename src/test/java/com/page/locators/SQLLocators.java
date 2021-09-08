package com.page.locators;

import org.openqa.selenium.By;

public interface SQLLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_SQL= By.xpath("//span[@title='SQL'][text()='SQL']");
    By BTN_ADDICON_SQL= By.xpath("//h5[text()='SQL Report']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By DISTRIBUTION_LIST_GHOSTTEXT = By.xpath("//input[@id ='alertGroupName']/../../../div[1]");
    By TXTBOX_DISTRIBUTION_LIST = By.xpath("//input[@id ='alertGroupName']");
    By REPORT_TEMPLATE_GHOSTTEXT = By.xpath("//input[@id ='templateName']/../../../div[1]");
    By TXTBOX_REPORT_TEMPLATE = By.xpath("//input[@id ='templateName']");
    By DATABASE_GHOSTTEXT = By.xpath("//input[@id ='monitoredDatabase']/../../../div[1]");
    By TXTBOX_DATABASE = By.xpath("//input[@id ='monitoredDatabase']");
    By CREDENTIALS_GHOSTTEXT = By.xpath("//input[@id ='credentials']/../../../div[1]");
    By TXTBOX_CREDENTIALS = By.xpath("//input[@id ='credentials']");
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
    By CHKBOX_ATTACH_RESULT = By.xpath("//span[text()='Attach Result?']/../../../span/span/input[@type='checkbox']");
    By SQL_TEXTAREA = By.cssSelector("textarea.inputarea");
    By SQLQUERY_TIMERANGE_GHOSTTEXT = By.xpath("//input[@id ='intervalType']/../../../div[1]");
    By TXTBOX_SQL_QUERY_TIMERANGE = By.xpath("//input[@id='intervalType']");
    By BTN_VALIDATE = By.xpath("//span[text()='Validate']");
    By CHKBOX_DATAMART_QUERY = By.xpath("//span[text()='Datamart Query?']/../../../span/span/input[@type='checkbox']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By LABEL_DAILY_REPORT = By.xpath("//div[@id='mail']/div/h3");
    By LABEL_MENU_BUTTON = By.xpath("//button[contains(@class,'md but textu')]/i");
    By LABEL_EMPTY_TEXTBOX = By.xpath("//span[text()='Empty Inbox']");
    By SQL_QUERIES_ADD_ICON = By.xpath("//span[text()='SQL Queries']/../../following-sibling::div/button/span/i");
    By LABEL_SQL_QUERY = By.xpath("//span[text()='Name For SQL Query']");
    By TXTBOX_SQL_QUERY = By.xpath("//span[text()='Name For SQL Query']/../../following-sibling::div/input");

}

