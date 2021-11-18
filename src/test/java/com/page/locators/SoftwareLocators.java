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
        By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
        By BTN_ENABLE = By.xpath("//h5[text()='Software']/..//div[@aria-label='Enable Selected Configuration']");
        By BTN_DISABLE = By.xpath("//h5[text()='Software']/..//div[@aria-label='Disable Selected Configuration']");
        By BTN_CLONE = By.xpath("//h5[text()='Software']/..//div[@aria-label='Clone Selected Configuration']");
        By BTN_STATUS = By.xpath("//h5[text()='Software']/..//div[@aria-disabled='true']");
        By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
        By BTN_DELETE = By.xpath("//h5[text()='Software']/..//div[@aria-label='Remove Selected Configuration']");
        By BTN_EDIT = By.xpath("//h5[text()='Software']/..//div[@aria-label='Edit Selected Configuration']");
        By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Software']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
        By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
        By EDIT_HEADER = By.xpath("//h6[text()='Editing 1 Software']");
        By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
        By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
        By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
        By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
        By LABEL_SAVE = By.xpath("//span[text()='Save']");
        By REFERENCED_ITEM_LINK = By.xpath("//h4[text()='References To This Item']/following-sibling::ul/li[1]");
        By REFERENCED_TEXT = By.xpath("//h4[text()='References To This Item']/following-sibling::ul/li[1]/button");
        By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
        By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
        By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    }


