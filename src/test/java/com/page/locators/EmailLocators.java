package com.page.locators;

import org.openqa.selenium.By;

public interface EmailLocators {
   By TXTBOX_EMAIl = By.xpath("//input[@placeholder='Enter your inbox here']");
   By BTN_FORWARD = By.xpath("//button[@class='md']/i");
   By LABEL_RECEIVED_EMAIl = By.xpath("//span[text()='alert@germainapm.com']/../../div[text()='Germain APM User Access Requested']");
   By FRAME = By.xpath("//iframe[@id='ifnoinb']");
   By HYPERLINK_ACCEPT_REQUEST = By.xpath("//strong[text()='accept']/../a[@href='http://qa.germainapm.com/germainapm/workspace/app/#UserAccessRequests']");
   By HYPERLINK_REJECT_REQUEST = By.xpath("//strong[text()='reject']/../a[contains(@href,'http://qa.germainapm.com/authentication/public/access/reject')]");
   By NOTIGY_REJECTED = By.xpath("//body/pre");
}
