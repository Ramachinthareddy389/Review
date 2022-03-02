package com.page.locators;

import org.openqa.selenium.By;

public interface WordPressLocators {
By LABEL_CONTACT = By.xpath("//a[text()='Contact']");
By TXTBOX_NAME = By.xpath("//span[text()='Name']/../following-sibling::input");
By TXTBOX_EMAIL = By.xpath("//span[text()='Email']/../following-sibling::input");
By TXTBOX_SUBJECT = By.xpath("//span[text()='Subject']/../following-sibling::input");
By TXTAREA_MESSAGE = By.xpath("//span[text()='Message']/../following-sibling::textarea");
By BTN_SUBMIT = By.xpath("//button[text()='Submit']");
By TOGGLE_MENU = By.xpath("//p[@class ='menu-toggle']");
By TAB_NEWS = By.xpath("//a[text()='News']");
By TAB_TECH = By.xpath("(//a[text()='Technology'])[1]");
By TAB_ENTER = By.xpath("(//a[text()='Entertainment'])[1]");
By TAB_FASHION = By.xpath("(//a[text()='Fashion'])[1]");
By TAB_TRAVEL = By.xpath("(//a[text()='Travel'])[1]");
By TAB_FOOD = By.xpath("(//a[text()='Food & Health'])[1]");



}
