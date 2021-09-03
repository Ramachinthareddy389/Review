package com.page.locators;

import org.openqa.selenium.By;

public interface AlertTemplateLocators
{
    By BTN_SYSTEM= By.xpath("//span[text()='System']");
    By BTN_ALERT_TEMPLATES = By.xpath("//span[text()='Alert Templates']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By LABEL_TEXT_TITLE = By.xpath("//span[text()='Text Title']");
    By TXTBOX_USERNAME_QUERY = By.xpath("//textarea[@class='inputarea']");
    By LABEL_TEXT_CONTENT = By.xpath("//span[text()='Text Content']");
    By LABEL_HTML_TITLE = By.xpath("//span[text()='HTML Title']");
    By LABEL_HTML_CONTENT = By.xpath("//span[text()='HTML Content']");
    By LABEL_SMS_TITLE = By.xpath("//span[text()='SMS Title']");
    By LABEL_SMS_CONTENT = By.xpath("//span[text()='SMS Content']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By ADDED_TEXT_AREA = By.xpath("//span[text()='Text Title']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By ADDED_TEXT_CONTENT = By.xpath("//span[text()='Text Content']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By ADDED_TEXT_HTML_TITLE = By.xpath("//span[text()='HTML Title']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By ADDED_TEXT_HTM_CONTENT = By.xpath("//span[text()='HTML Content']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By ADDED_TEXT_SMS_TITLE = By.xpath("//span[text()='SMS Title']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By ADDED_TEXT_SMS_CONTENT = By.xpath("//span[text()='SMS Content']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By EDITED_TEXT_AREA = By.xpath("//div[@class='view-line']/span/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");

    //Alert Locators
    By LABEL_AUTOMATION = By.xpath("//span[text()='Automation']");
    By LABEL_ALERT = By.xpath("//span[text() ='Alert']");
    By DISTRIBUTION_LIST_GHOSTTEXT = By.xpath("//input[@id='alertGroupName']/../../../div[1]");
    By DRPDOWN_DISTRIBUTION_LIST = By.xpath("//input[@id='alertGroupName']");
    By SLA_GHOSTTEXT = By.xpath("//input[@id='sla']/../../../div[1]");
    By DRPDOWN_SLA = By.xpath("//input[@id='sla']");
    By DROPDOWN_LIST=By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By EMAIL_SUBJECT = By.xpath("//div[contains(@class,'ellipsis nw')]");
    By BTN_DELETE = By.xpath("//span[text()='Delete']");
    By LABEL_DAILY_INSIGHT = By.xpath("//span[text()='Daily']");
    By INSIGHTS_PAGE_SIDE_MENU = By.xpath("//span[@title='Insights']/span");


}
