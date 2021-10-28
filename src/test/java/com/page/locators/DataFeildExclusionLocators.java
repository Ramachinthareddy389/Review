package com.page.locators;

import org.openqa.selenium.By;

public interface DataFeildExclusionLocators {
    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By BTN_DATAFIELD_EXCLUSION = By.xpath("//span[text()='Data Field Exclusions']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By LABEL_KPIS = By.xpath("//input[@id='kpi']/../../../div[1]/../../../../label/p/span[1]");
    By KPIS_GHOSTEXT = By.xpath("//input[@id='kpi']/../../../div[1]");
    By TXTBOX_KPIS = By.xpath("//input[@id='kpi']");
    By LABEL_FIELDNAME= By.xpath("//span[text()='Field Name']");
    By FEILDNAME_GHOSTEXT = By.xpath("//input[@id='fieldName']/../../../div[1]");
    By TXTBOX_FEILDNAME = By.xpath("//input[@id='fieldName']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By CREATE_LABEL = By.xpath("//div[contains(@class,'MuiListItem-button')][contains(@id,'react-select')]");
    By TXTBOX_EDITED_KPIS = By.xpath("//input[@id='kpis']/../../../div[2]/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By LABEL_FACTTYPE = By.xpath("//span[text()='Fact Type']");
    By TXTBOX_FACTTYPE = By.xpath("//input[@id='factType']/../../../div[1]");

    By ICON_INFROMATIONINDRILLTHRGH = By.xpath("//a[contains(@href,'#RCA')][1]/div/div/div[5]/span/div/i");
    By LABEL_SYSTEM = By.xpath("//div[text()='System hostname']");
    By ICON_EYE = By.xpath("//div[text()='System hostname']/following-sibling::span/div/div/div[2]/span/i");
    By ICON_INFORMATION_RCA_PAGE = By.xpath("//i[contains(@class,'fas fa-info-circle')]/../../../../div/span[text()='System']/../following-sibling::div/span/div/i");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS=By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div[2]/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By REMOVE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Remove Configuration']");
    By ENABLED_STATUS =By.xpath("//div[@aria-label='Enable Configuration']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//h5[text()='Exclusions']/..//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//h5[text()='Exclusions']/..//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//h5[text()='Exclusions']/..//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//h5[text()='Exclusions']/..//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//h5[text()='Exclusions']/..//div[@aria-label='Remove Selected Configuration']");

}
