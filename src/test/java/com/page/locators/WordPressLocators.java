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
By LINK_THINGSTONEW_YEAR = By.xpath("//a[@href='http://qa.germainapm.com/wordpress/index.php/2017/12/26/things-to-do-new-years-eve-2017-best-nye-events-parties-and-fireworks-displays-in-new-york-and-across-the-usa/']");
By BTN_SEARCH = By.xpath("//i[@class='fa fa-search search-top']");
By TXTBOX_SEARCH = By.xpath("//input[@class='s field']");
By BTN_SUBMIT_SEARCH = By.xpath("//button[@type='submit']");
By HYPERRLINK_SUPPORT_FORUM = By.xpath("//a[@href='http://themegrill.com/support-forum/']");
By HYPERLINK_CONTACTPAGE = By.xpath("//a[@href='http://themegrill.com/contact/']");
By LINK_EVENTS_FORUM_PLUGIN = By.xpath("//a[@href='https://downloads.wordpress.org/plugin/everest-forms.zip']");



}
