package com.page.locators;

import org.openqa.selenium.By;

public interface WizardsLocators
{
    By BTN_Wizards  = By.xpath("//span[text()='Wizards']");
    By ALERT_ADD_BUTTON = By.xpath("//span[@aria-label='Alert']/../../following-sibling::div/div/div/button/span[1]");
    By ALERTNAME_TXTBOX = By.xpath("//label[@id='name-label']/following-sibling::div/input");
    By DISTRIBUTION_HEADER = By.xpath("//label[@for='alertGroupName']/p/span[text()='Distribution List']");
    By DISTRIBUTION_TXTBOX = By.xpath("//input[@id='alertGroupName']");
    By DISTRIBUTION_GhOSTTEXT = By.xpath("//div[text()='Select or Add...']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By SLA_HEADER = By.xpath("//label[@for='sla']/p/span[text()='SLA']");
    By SLA_TXTBOX = By.xpath("//input[@id='sla']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By ALERT_HEADER_SIDE_MENU = By.xpath("//span[text()='Automation']/../../following-sibling::div/div/a/span/span[text()='Alert']");
    By DROPDOWN_DASHBOARD_FOLDER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BUTTON_CLOSE = By.xpath("//span[text()='Close']");
    By NOTIFY_TEXT  = By.xpath("//div[contains(@class,'WizardSummary')]/div/span/ul/li");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By CHKBOX_ALERT = By.xpath("//input[@aria-label='Select Row']");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By BTN_MANAGE_ALERT = By.xpath("//span[@aria-label='Alert']/../../following-sibling::div/div/div/a/span[1]");
    By PAGE_TITLE_ALERT = By.xpath("//div[@aria-label='Enable Selected Configuration']/../../../h5");
    By BUTTON_ALL = By.xpath("//button[@type='button']/span[text()='All']");
    By BUTTON_MONITORING = By.xpath("//button[@type='button']/span[text()='Monitoring']");
    By BUTTON_ANALYTICS = By.xpath("//button[@type='button']/span[text()='Analytics']");
    By BUTTON_AUTOMATION = By.xpath("//button[@type='button']/span[text()='Automation']");
    By LISTOFWIZARDS  = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-noWrap']/span");
}
