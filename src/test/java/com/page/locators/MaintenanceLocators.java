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
     By ACTIONS_ADD_ICON = By.xpath("//span[text()='Actions']/../../../../../../button/span/i");
     By ALERT_LABEL = By.xpath("//li[text()='Alert']");
     By HTTP_ACTION_LABEL = By.xpath("//li[text()='HTTP Action']");
     By LOCALPROGRAM_LABEL = By.xpath("//li[text()='Local Program']");
     By SQL_ACTION_LABEL = By.xpath("//li[text()='SQL Action']");
     By SSH_ACTION_LABEL = By.xpath("//li[text()='SSH Action']");
     By WMI_ACTION_LABEL = By.xpath("//li[text()='WMI Action']");
     By LABEL_NAME_ALERT = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
     By TXTBOX_NAME_ALERT = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
     By LABEL_DISTRIBUTION_LIST = By.xpath("//span[text()='Distribution List']");
     By DISTRIBUTION_LIST_GHOSTEXT = By.xpath("//input[@id='alertGroupName']/../../../div[1]");
     By TXTBOX_DISTRIBUTION_LIST = By.xpath("//input[@id='alertGroupName']");
     By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
     By BTN_NEXT = By.xpath("//span[text()='Next']");
     By LABEL_PATH = By.xpath("//label[@id='path-label']/p/span[text()='Path']");
     By TXTBOX_PATH= By.xpath("//input[@id='path']/../../../../div/div/div/input");
     By LABEL_REQUEST_METHOD = By.xpath("//span[text()='Request Method']");
     By REQUEST_METHOD_GHOSTTEXT = By.xpath("//input[@id='method']/../../../div[1]");
     By TXTBOX_REQUEST_METHOD= By.xpath("//input[@id='method']");
     By LABEL_CONTENT_TYPE = By.xpath("//span[text()='Content Type']");
     By CONTENT_TYPE_GHOSTTEXT = By.xpath("//input[@id='contentType']/../../../div[1]");
     By TXTBOX_CONTENT_TYPE = By.xpath("//input[@id='contentType']");
     By LABEL_SLA = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span");
     By TXTBOX_SLA = By.xpath("//input[@id='names']");
     By LABEL_PROGRAM = By.xpath("//span[text()='Program']");
     By TXTBOX_PROGRAM = By.xpath("//input[@id='command']");
     By SLA_GHOSTTEXT = By.xpath("//input[@id='sla']/../../../div[1]");
     By CHKBOX_RUNSCHEDULE = By.xpath("//span[text()='Run on schedule?']/../../../span/span/input[@type='checkbox']");
     By CHKBOX_RECURRING = By.xpath("//span[text()='Recurring']/../../../span/span/input");
     By ICON_REFRESH_ICON = By.xpath("//div[@class='MuiCircularProgress-root MuiCircularProgress-colorPrimary MuiCircularProgress-indeterminate']");
     By BTN_PLAY = By.xpath("//i[@class='fas fa-play-circle']");
     By BTN_PAUSE = By.xpath("//i[@class='fas fa-stop-circle']");
     By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");

}
