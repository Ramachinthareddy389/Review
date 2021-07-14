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

}
