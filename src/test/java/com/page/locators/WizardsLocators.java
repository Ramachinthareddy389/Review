package com.page.locators;

import org.openqa.selenium.By;

public interface WizardsLocators
{

    By BTN_OPERATIONAL  = By.xpath("//span[text()='Wizards']");
    By ALERT_ADD_BUTTON    = By.xpath("//span[@aria-label='Alert']/../../following-sibling::div/div/div/button/span[1]");
    By ALERTNAME_TXTBOX    = By.xpath("//label[@id='name-label']/following-sibling::div/input");
    By DISTRIBUTION_HEADER = By.xpath("//label[@for='alertGroupName']/p/span[text()='Distribution List']");
    By DISTRIBUTION_TXTBOX = By.xpath("//input[@id='alertGroupName']");
    By BTN_NEXT            = By.xpath("//span[text()='Next']");
    By SLA_HEADER          = By.xpath("//span[@aria-label='SLA']");
    By SLA_TXTBOX          = By.xpath("//input[@id='sla']");
    By BTN_FINISH          = By.xpath("//span[text()='Finish']");
    By BTN_AUTOMATION      = By.xpath("//span[text()='Automation']");
    By ALERT_HEADER_SIDE_MENU = By.xpath("//span[text()='Automation']/../../following-sibling::div/div/a/span/span[text()='Alert']");
    By TYPESEARCH_ALERT  =By.xpath("//input[@placeholder='Type or select below']");
}
