package com.page.locators;

import org.openqa.selenium.By;

public interface DashBoardLocators {
    By DASHBOARd_MODULE=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]");
    By All_FOLDER     =By.xpath("//span[text()='All']");
    By BUTTON_ADD_DASHBOARD =By.xpath("//i[@title='Add new Dashboard or Folder'][@class='fas fa-plus']");
    By LABEL_NEW_DASHBOARD =By.xpath("//li[text()='Dashboard']");
    By TEXTBOX_DASHBOARD_WINDOW=By.id("name");
    By LISTBOX_Folder=By.xpath("//*[text()='Folder']/../../../div//div[contains(@class,'body1')]");
    By TEXTBOX_Folder=By.xpath("//div[text()='Select or Add...']");
    By DROPDOWN_DASHBOARD_FOLDER=By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BUTTON_FINISH=By.xpath("//span[text()='Finish']");
    By TEXT_NOTIFY=By.xpath("//li[text()='Dashboard created.']");
    By BUTTON_CLOSE=By.xpath("//span[text()='Close']");
    By ROWPERPAGE_DROPDOWN=By.className("MuiSvgIcon-root MuiSelect-icon MuiTablePagination-selectIcon");
    By ROWS_DROPDOWN_Label_All=By.xpath("#menu->div>ul>li:nth-child(4)");
    By LISTOFDASHBOARDS= By.xpath("//div[@title='Dashboards']//ancestor::div[4]//following::div[2]/div/div/span/div/div/span");
    By TEXTBOX_TYPESEARCH=By.xpath("//input[@placeholder='Type or select below']");
    By FOLDER_DELETE=By.xpath("//div[@aria-label='Remove from this folder']");
    By DASHBOARD_LABEL=By.xpath("//div[contains(@class,'MuiListItem-button')][contains(@id,'react-select')]");
    By USERICON=By.xpath("//button[@title='Presentation mode']/following-sibling::button");
    By LOGOUT=By.xpath("//span[text()='Logout']");

    //Removing and Deleting of dashboards
    By BUTTON_REMOVE= By.xpath("//span[text()='Remove']");
    By BUTTON_DELETE=By.xpath("//span[text()='Delete']");
    By BUTTON_CANCEL=By.xpath("//span[text()='Cancel']");
    By BUTTON_ADDFOLDER=By.xpath("//div[@aria-label='Add folder or dashboard']");
    By COLUMN_FOLDER= By.xpath("//div[contains(@class,'MuiContainer-root')]//span[text()='Dashboards']");
    By TEXTBOX_CHOSE_DASHBOARD=By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]");
    By DROPDOWN_CHOSE_DASHBOARD=By.xpath("//*[@id='dashboardKey']");


}