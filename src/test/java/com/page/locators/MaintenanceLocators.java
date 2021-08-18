package com.page.locators;

import org.openqa.selenium.By;

public interface MaintenanceLocators {
     By LABEL_SYSTEM= By.xpath("//span[text()='System']");
     By LABEL_MAINTENANCE =By.xpath("//span[text()='Maintenance']");
     By TXTBOX_DURATION = By.xpath("//input[@id='duration']");
     By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
     By LABEL_NAME = By.xpath("//label[@id='name-label']");
     By TXTBOX_NAME = By.xpath("//input[@id='name']");
     By BTN_FINISH = By.xpath("//span[text()='Finish']");
     By BTN_CLOSE = By.xpath("//span[text()='Close']");
     By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
     By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[3]/span/span");
     By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
     By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
     By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
     By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
}
