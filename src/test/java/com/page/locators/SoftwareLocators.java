package com.page.locators;

import org.openqa.selenium.By;

public interface SoftwareLocators {

        By BTN_DATASOURCES = By.xpath("//span[text()='Data Sources']");
        By BTN_SOFTWARE = By.xpath("//span[text()='Software']");
        By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
        By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
        By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
        By LABEL_DESC = By.xpath("//label[@id='description-label']");
        By TXTBOX_DESC = By.xpath("//input[@id='description']");
        By LABEL_CATEGORY = By.xpath("//span[text()='Category']");
        By CATEGORY_GHOSTEXT = By.xpath("//input[@id='category']/../../../div[1]");
        By TXTBOX_CATEGORY = By.xpath("//input[@id='category']");
        By LABEL_TECHSTACK = By.xpath("//span[text()='Technology Stack']");
        By TXTBOX_TECKSTACK = By.xpath("//input[@id='technologyStack']");
        By BTN_ADD_ACCESMEANS  = By.xpath("//span[text()='Access Means']/../../following-sibling::button/span/i");
        By TXTBOX_ACCESMEANS   = By.xpath("//span[text()='Access Means']/../../following-sibling::div/div/div/div/input");
        By BTN_ADD_SEARCHTAGS  = By.xpath("//span[text()='Search Tags']/../../following-sibling::button/span/i");
        By TXTBOX_SEARCHTAGS   = By.xpath("//span[text()='Search Tags']/../../following-sibling::div/div/div/div/input");
        By BTN_FINISH  = By.xpath("//span[text()='Finish']");
        By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
        By BTN_CLOSE = By.xpath("//span[text()='Close']");
        By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
        By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
        By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
        By EDITED_ACESSMEANS = By.xpath("//input[@id='accessMeans']");
        By EDITED_SEARCHTAGS = By.xpath("//input[@id='searchTags']");
        By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
        By BTN_CLEAR = By.xpath("//span[text()='Clear']");
        By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
        By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
        By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");

    }


