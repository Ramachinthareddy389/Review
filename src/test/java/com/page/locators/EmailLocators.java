package com.page.locators;

import org.openqa.selenium.By;

public interface EmailLocators {
   By TXTBOX_EMAIl = By.xpath("//input[@id='identifierId']");
   By BTN_NEXT = By.xpath("//span[text()='Next']");
   By TXTBOX_PASSWORD = By.xpath("//input[@aria-label='Enter your password']");
   By EMAIL_SUBJECT = By.xpath("//div[@class='y6']/span/span");
   By BTN_SELECT = By.xpath("//div[@aria-label='Select']/div/span");
   By EMAIl_ATTACH_LABEL = By.xpath("//div[@class='aQA']/span");
   By HEADER_IN_MAIL = By.xpath("//h3[text()='Daily User Login Report']");
   By BTN_InBOX = By.xpath("//a[text()='Inbox']");
   By BTN_DELETE = By.xpath("//div[@aria-label='Delete']/div");
   By LABEL_MORE = By.xpath("//span[text()='More']");
   By BTN_TRASH=  By.xpath("//a[text()='Trash']");
   By BTN_DELETE_FOREVER = By.xpath("//div[text()='Delete forever']");
   By HYPELINK_SET_PASSWRD = By.xpath("//a[text()='here']");
   By TXTBOX_PASSWRD = By.xpath("//input[@id='password']");
   By TXTBOX_CONFIRM_PASSWRD = By.xpath("//input[@id='confirmPassword']");
   By BTN_UPDATE_PASSWRD = By.xpath("//span[text()='Update Password']");
   By NOTIFY_TEXT = By.xpath("//span[text()='Close']/../.././../p");
   By BTN_CLOSE = By.xpath("//span[text()='Close']");
   By PASSWORD_FIELD = By.xpath("//input[@type='password']");
   By LOGIN_BTN = By.xpath("//span[normalize-space()='Login']");
   By LABEL_OPERATIONAL = By.xpath("//span[text()='Operational']");
   By BTN_QUITTOUR = By.xpath("//button[@title ='Quit Tour']");
   By welcomeText = By.xpath("//p[text()='Welcome and THANK YOU! :)']");
   By BTN_FORWARD = By.xpath("//button[@class='md']/i");
   By LABEL_RECEIVED_EMAIl = By.xpath("//div[@class='lms']");
   By FRAME = By.xpath("//iframe[@id='ifnoinb']");
   By HYPERLINK_ACCEPT_REQUEST = By.xpath("//strong[text()='accept']/../a[@href='http://qa.germainapm.com/germainapm/workspace/app/#UserAccessRequests']");
   By HYPERLINK_REJECT_REQUEST = By.xpath("//strong[text()='reject']/../a[contains(@href,'http://qa.germainapm.com/authentication/public/access/reject')]");
   By NOTIGY_REJECTED = By.xpath("//body/pre");
   By HYPERLINK_MONITORING_DATALINK = By.xpath("//a[text()='View the monitoring data that triggered this alert on the germain APM dashboard']");
   By HYPERLINK_ALERT_DATALINK = By.xpath("//a[text()='View this alert on the germain APM dashboard']");
   By HYPERLINK_TICKET_LINK = By.xpath("//a[text()='Create a ticket for this alert']");
   By HYPERLINK_KPI_LINK = By.xpath("//a[text()='User Click']");
   By TITLE_RCA_PAGE = By.xpath("//div[@aria-label='Print']/../../../h5");
   By TITLE_NEW_TICKET = By.xpath("//button[@aria-label='close']/../div/h6");
   By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
   By TITLE_KPI = By.xpath("//i[@aria-label='Add New Configuration']/../../../../../h5");
   By TXTBOX_YOPMAIL = By.xpath("//input[@id='login']");
   By LABEL_MENU_BUTTON = By.xpath("//button[@id='delsel']/../../div[1]/button");
   By LABEL_EMPTY_TEXTBOX = By.xpath("//span[text()='Empty Inbox']");

}
