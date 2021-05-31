package com.page.locators;

import org.openqa.selenium.By;

public interface LogInPageLocators 
{
	 By EMAILADDRESS_FIELD = By.xpath("//input[@type='text']");
	 By PASSWORD_FIELD = By.xpath("//input[@type='password']");
	 By LOGIN_BTN=By.xpath("//span[normalize-space()='Login']");
	 By USERICON=By.xpath("//button[@title='Presentation mode']/following-sibling::button");
  	 By LOGOUT=By.xpath("//span[text()='Logout']");

}