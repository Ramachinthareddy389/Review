package com.page.locators;

import org.openqa.selenium.By;

public interface DBInstancesLocators
{
   By BTN_DATASOURCES = By.xpath("//span[text()='Data Sources']");
   By BTN_DBINSTANCES = By.xpath("//span[text()='DB Instances']");
   By BTN_ADDICON     = By.xpath("//i[@aria-label='Add New Configuration']");
   By LABEL_NAME      = By.xpath("//label[@id='name-label']");
   By TXTBOX_NAME     = By.xpath("//input[@id='name']");
   By LABEL_SERVER    = By.xpath("//span[text()='Server']");
   By SERVER_GHOSTEXT = By.xpath("//input[@id='server']/../../../div[1]");
   By TXTBOX_SERVER   = By.xpath("//input[@id='server']");
   By LABEL_VENDOR_NAME = By.xpath("//span[text()='Database Vendor Name']");
   By VENDOR_NAME_GHOSTTEXT = By.xpath("//input[@id='vendor']/../../../div[1]");
   By TXTBOX_VENDOR_NAME = By.xpath("//input[@id='vendor']");
   By BTN_NEXT           = By.xpath("//span[text()='Next']");
   By LABEL_PORTNUMBER   = By.xpath("//span[text()='Database Port Number']");
   By LABEL_DATABASENAME = By.xpath("//span[text()='Database Name']");
   By LABEL_INSTANCENAME = By.xpath("//span[text()='Instance Name']");
   By TXTBOX_PORTNUMBER  = By.xpath("//input[@id='port']");
   By TXTBOX_DATABASENAME = By.xpath("//input[@id='databaseName']");
   By TXTBOX_INSTANCENAME = By.xpath("//input[@id='instanceName']");
   By BTN_FINISH          = By.xpath("//span[text()='Finish']");
   By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
   By BTN_CLOSE    = By.xpath("//span[text()='Close']");
   By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
   By LISTOFDBS  = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
   By HEADER_DB = By.xpath("//h5[@aria-label='Dbinstancename']");
   By SERVERVALUE = By.xpath("//input[@id='server']/../../../div");
   By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
   By BTN_CLEAR = By.xpath("//span[text()='Clear']");
   By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
   By BTN_ENABLE = By.xpath("//h5[text()='Databases']/..//div[@aria-label='Enable Selected Configuration']");
   By BTN_DISABLE = By.xpath("//h5[text()='Databases']/..//div[@aria-label='Disable Selected Configuration']");
   By BTN_CLONE = By.xpath("//h5[text()='Databases']/..//div[@aria-label='Clone Selected Configuration']");
   By BTN_STATUS = By.xpath("//h5[text()='Databases']/..//div[@aria-disabled='true']");
   By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
   By BTN_DELETE = By.xpath("//h5[text()='Databases']/..//div[@aria-label='Remove Selected Configuration']");
   By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
   By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
   By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
   By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
   By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
   By LABEL_SAVE = By.xpath("//span[text()='Save']");
   By Title_DRILLTHROUGH = By.xpath("//div[contains(@class,'MuiContainer-root ')]/div//following-sibling::div/div/h5");
   By TITLE_IN_ALERTTEMPLATE = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
   By KPINAME_TXTBOX = By.xpath("//input[@id='name']");
   By EYE_ICON = By.xpath("//i[@class='far fa-eye']");
   By SERVER_TEXT = By.xpath("//h6[text()='Server']");
   By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
   By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
   By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
   By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
   By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");



}
