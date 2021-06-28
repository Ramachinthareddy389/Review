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
   By LISTOFDBS  =By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
   By HEADER_DB = By.xpath("//h5[@aria-label='Dbinstancename']");
   By SERVERVALUE=By.xpath("//input[@id='server']/../../../div");
   By BTN_SAVE =By.xpath("//div[@aria-label='Save Configuration']");
   By BTN_CLEAR = By.xpath("//span[text()='Clear']");




}
