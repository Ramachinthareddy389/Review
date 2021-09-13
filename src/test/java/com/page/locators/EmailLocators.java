package com.page.locators;

import org.openqa.selenium.By;

public interface EmailLocators {
   By TXTBOX_EMAIl = By.xpath("//input[@id='identifierId']");
   By BTN_NEXT = By.xpath("//span[text()='Next']");
   By TXTBOX_PASSWORD = By.xpath("//div[text()='Enter your password']");
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
}