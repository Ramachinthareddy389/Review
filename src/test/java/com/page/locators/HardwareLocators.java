package com.page.locators;

import org.openqa.selenium.By;

public interface HardwareLocators
{
    By BTN_DATASOURCES       = By.xpath("//span[text()='Data Sources']");
    By BTN_HARDWARE          = By.xpath("//span[text()='Hardware']");
    By BTN_ADDICON           = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME      = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME     = By.xpath("//input[@id='name']");
    By LABEL_ENVIRONMENT     = By.xpath("//span[text()='Environment']");
    By ENVIRONMENT_GHOSTEXT  = By.xpath("//input[@id='environment']/../../../div[1]");
    By TXTBOX_ENVIRONMENT    = By.xpath("//input[@id='environment']");
    By LABEL_TYPE            = By.xpath("//span[text()='Type']");
    By TYPE_GHOSTTEXT        = By.xpath("//input[@id='type']/../../../div[1]");
    By TXTBOX_TYPE           = By.xpath("//input[@id='type']");
    By LABEL_HOSTNAME        = By.xpath("//span[text()='Host Name']");
    By TXTBOX_HOSTNAME       = By.xpath("//input[@id='hostname']");
    By BTN_NEXT              = By.xpath("//span[text()='Next']");
    By LABEL_OSFAMILY        = By.xpath("//span[text()='OS Family']");
    By OSFAMILY_GHOSTEXT     = By.xpath("//input[@id='osFamily']/../../../div[1]");
    By TXTBOX_OSFAMILY       = By.xpath("//input[@id='osFamily']");
    By LABEL_OSNAME          = By.xpath("//span[text()='OS Name']");
    By OSNAME_GHOSTEXT       = By.xpath("//input[@id='osName']/../../../div[1]");
    By TXTBOX_OSNAME         = By.xpath("//input[@id='osName']");
    By BTN_FINISH            = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER       = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE             = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH    = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS             = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By SERVERVALUE = By.xpath("//input[@id='server']/../../../div");
    By BTN_SAVE =By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By EDITLABEL_HOSTNAME =By.xpath("//span[text()='Hostname']");
}
