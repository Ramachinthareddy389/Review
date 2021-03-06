package com.page.locators;

import org.openqa.selenium.By;

public interface PresentationModesNdRulesLocators {
    By LABEL_SYSTEM= By.xpath("//span[text()='System']");
    By LABEL_PRESENTATION_MODES =By.xpath("//span[text()='Presentation Modes']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_DURATION = By.xpath("//input[@id='duration']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_DASHBOARD    = By.xpath("//span[text()='Dashboard']");
    By DASHBOARD_GHOSTEXT = By.xpath("//input[@id='dashboardName']/../../../div[1]");
    By TXTBOX_DASHBOARD   = By.xpath("//input[@id='dashboardName']");
    By LABEL_TIMERANGE    = By.xpath("//span[text()='Time Range']");
    By TIMERANGE_GHOSTEXT = By.xpath("//input[@id='timerange']/../../../div[1]");
    By TXTBOX_TIMERANGE   = By.xpath("//input[@id='timerange']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[1]/span/span");
    By LISTOFDBS1= By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By HYPERLINK_DASHBOARDS = By.xpath("//span[text()='Dashboards']/../../../div/div/div/button");
    By TXTBOX_DASHBOARD_VALUE = By.xpath("//input[@id='dashboardName']/.././../../div[1]");
    By CHKBOX_DASHBOARD = By.xpath("//span[text()='Dashboard?']/../../../span/span/input[@type='checkbox']");
    By LABEL_VIEW    = By.xpath("//span[text()='View']");
    By VIEW_GHOSTEXT = By.xpath("//input[@id='contextPath']/../../../div[1]");
    By TXTBOX_VIEW   = By.xpath("//input[@id='contextPath']");
    By TXTBOX_VIEW_VALUE = By.xpath("//input[@id='contextPath']/.././../../div[1]");
    By BTN_REMOVE_DASHBOARDS = By.xpath("//span[text()='Dashboards']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By DASHBOARDS_ADD_ICON = By.xpath("//span[text()='Dashboards']/../../following-sibling::div/button/span/i");
    By PLAY_BTN_ICON = By.xpath("//button[@title='Fullscreen mode']/following-sibling::button/span/i[contains(@class,'far fa-play-circle')]");
    By PLAYMODE_DRPDOWN = By.xpath("//ul/li[@role='menuitem']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//div[@aria-label='Remove Selected Configuration']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    By EYE_ICON = By.xpath("//button[@aria-label='view']");
    By KPIS_TEXT = By.xpath("//h6[text()='Dashboard']");
    By DASHBOARDNAME_VALUE = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
    By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span");
    By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
    By BTN_EDIT = By.xpath("//div[@aria-label='Edit Selected Configuration']");
    By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Roles']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER = By.xpath("//h6[text()='Editing 1 Secure Shell']");
    By CHEKBOXES_EDITWINDOW_WMI = By.xpath("//h6[text() ='Editing 1 Roles']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By EDIT_HEADER_CLICK = By.xpath("//h6[text()='Editing 1 Click']");
    By CHEKBOXES_EDITWINDOW_CLICK = By.xpath("//h6[text() ='Editing 1 Click']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES_WMI = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER_WMI = By.xpath("//h6[text()='Editing 1 Roles']");
    By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
    //Rules Configurations
    By LABEL_ENGINE_SETTINGS = By.xpath("//span[text()='Engine Settings']");
    By LABEL_RULES = By.xpath("//span[text()='Engine Settings']/../../following-sibling::div[1]/div/a[3]/span[2]/span[1]");
    By TEXTAREA_CONTENT = By.xpath("//textarea[@class='inputarea']");
    By CONTENT_VAULUE = By.xpath("//div[@class='view-line']/span/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By BTN_VALIDATERULE = By.xpath("//span[text()='Validate Rule']");
    By NOTIFYTEXT = By.xpath("//p[text()='Validation passed']");

    //TimeRanges
    By LABEL_TIMERANGES = By.xpath("//span[text()='Time Ranges']");
    By BTN_ABSOLUTE_RADIO = By.xpath("//p[text()='Absolute Time Range']/../../span/span/input[1]");
    By BTN_RELATIVE_RADIO = By.xpath("//p[text()='Relative Time Range']/../../span/span/input[1]");
    By TXTBOX_MINUTE = By.xpath("//input[@id='value_minute']");
    By TXTBOX_HOUR = By.xpath("//input[@id='value_hour']");
    By TXTBOX_DAY = By.xpath("//input[@id='value_day']");
    By TXTBOX_YEAR = By.xpath("//input[@id='value_year']");
    By TXTBOX_MONTH = By.xpath("//input[@id='value_month']");
    By TXTBOX_START_EDIT_MINUTE = By.xpath("//input[@id='Start_minute']");
    By TXTBOX_START_EDIT_HOUR = By.xpath("//input[@id='Start_hour']");
    By TXTBOX_START_EDIT_DAY = By.xpath("//input[@id='Start_day']");
    By TXTBOX_START_EDIT_YEAR = By.xpath("//input[@id='Start_year']");
    By TXTBOX_START_EDIT_MONTH = By.xpath("//input[@id='Start_month']");

    By TXTBOX_END_EDIT_MINUTE = By.xpath("//input[@id='End_minute']");
    By TXTBOX_END_EDIT_HOUR = By.xpath("//input[@id='End_hour']");
    By TXTBOX_END_EDIT_DAY = By.xpath("//input[@id='End_day']");
    By TXTBOX_END_EDIT_YEAR = By.xpath("//input[@id='End_year']");
    By TXTBOX_END_EDIT_MONTH = By.xpath("//input[@id='End_month']");

    By TXTBOX_START_VALUE = By.xpath("//input[@id='value']");
    By TXTBOX_START_UNIT = By.xpath("//input[@id='unit']");
    By CHKBOX_START_OF_TIME = By.xpath("//span[text()='Start of Time']/../../../span/span/input");
    By TXTBOX_START_EDIT_VALUE = By.xpath("//input[@id='start.value']");
    By TXTBOX_START_EDIT_UNIT = By.xpath("//input[@id='start.unit']");
    By CHKBOX_START_TIME_IN_EDIT = By.xpath("//span[text()='Start - Start of Time']/../../../span/span/input");
    By TXTBOX_END_EDIT_VALUE = By.xpath("//input[@id='end.value']");
    By TXTBOX_END_EDIT_UNIT = By.xpath("//input[@id='end.unit']");
    By CHKBOX_END_TIME_IN_EDIT = By.xpath("//span[text()='End - Start of Time']/../../../span/span/input");
    By CALENDAR_ICON =By.xpath("//div[contains(@class, 'DateTimePicker')]//i");
    By PREDEFINED_TIMERANGES = By.xpath("//button[contains(@class,'MuiButton-outlined')]/span[@class='MuiButton-label']");
    By EXPLORE_LABEL = By.xpath("//span[text()='Explore your data']");
    By EXPLORE_SEARCH_TEXTBOX = By.xpath("//div[@placeholder='Search insights (free text or select keywords)']");
    By TIMERANGES_IN_EXPLORE_PAGE = By.xpath("//i[contains(@class,'far fa-calendar-alt')]/parent::div");


    //Role Locators
    By LABEL_AUTH_SETTINGS = By.xpath("//span[text()='Auth Settings']");
    By LABEL_USER_ROLES = By.xpath("//span[text()='User Roles']");
    By CHECKBOX1 = By.xpath("//span[text()='Create Inactive Config']/../../../span/span/input");
    By CHECKBOX2 = By.xpath("//span[text()='Create/Edit Config']/../../../span/span/input");
    By CHECKBOX3 = By.xpath("//span[text()='Create Dashboards']/../../../span/span/input");
    By CHECKBOX4 = By.xpath("//span[text()='Edit UI Fields/Columns']/../../../span/span/input");
    By CHECKBOX5 = By.xpath("//span[text()='View Data']/../../../span/span/input");
    By CHECKBOX6 = By.xpath("//span[text()='View User Replay']/../../../span/span/input");
    By CHECKBOX7 = By.xpath("//span[text()='Manage Users']/../../../span/span/input");
    By CHECKBOX8 = By.xpath("//span[text()='Monitor']/../../../span/span/input");
    By RECORD_IN_ROLE_PAGE = By.xpath("//div[@title='Select Row']/following-sibling::div/span/span");
    By BTN_FINISH_ROLE = By.xpath("//span[text()='Monitor']/../../../span/span/input/../../../../../../../../div[3]/div/button/span");

}
