package com.page.locators;

import org.openqa.selenium.By;

public interface DashBoardLocators {
    By DASHBOARd_MODULE=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]");
    By All_FOLDER     =By.xpath("//span[text()='All']");
    By BUTTON_ADD_DASHBOARD =By.xpath("//i[@title='Add new Dashboard or Folder'][@class='fas fa-plus']");
    By LABEL_NEW_DASHBOARD =By.xpath("//li[text()='Dashboard']");
    By LABEL_NEW_FOLDER   =By.xpath("//li[text()='Folder']");
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
    By COLUMN_FOLDER= By.xpath("//div[contains(@class,'MuiContainer-root')]//span[starts-with(text(),'Dashboards')]");
    By TEXTBOX_CHOSE_DASHBOARD=By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]");
    By DROPDOWN_CHOSE_DASHBOARD=By.xpath("//*[@id='dashboardKey']");
    By ICON_RENAME=By.xpath("//div[@aria-label='Rename Dashboard']");
    By TEXTBOX_RENAMEDASHBRD=By.xpath("//input[@id='InputDialog']");
    By BUTTON_RENAME=By.xpath("//span[text()='Rename']");

//DashBoard Locators for cloning

    By FOLDER_TESTAUTOMATION= By.xpath("//span[text()='Dashboards > TestAutomation']");
    By TESTDASHBOARD1= By.xpath("//span[text()='TestDashboard1']");
    By ICON_FILTER= By.xpath("//span[@class='MuiIconButton-label']/i[@class='fas fa-filter']");
    By ICON_BOOKMARK= By.xpath("//span[@class='MuiIconButton-label']/i[@class='far fa-bookmark']");
    By ICON_CLONE= By.xpath("//span[@class='MuiIconButton-label']/i[@class='far fa-clone']");
    By ICON_REMOVE= By.xpath("//span[@class='MuiIconButton-label']/i[@class='fas fa-trash']");
    By DIALOGBOX= By.xpath("//div[@role='dialog']");
    By DIALOG_FOLDER=By.xpath("//div[contains(@class,'MuiTypography-root')]");	
    By DIALOG_DASHBOARD=By.xpath("//input[@id='name']");
    By CLONE_DB_NAME =  By.xpath("//input[@id='InputDialog']");                
    By BTN_CLONE=By.xpath("//span[text()='Clone']"); 
    By BTN_CANCEL=By.xpath("//span[text()='Cancel']");  
    By CLONE_PARENT =By.xpath("//span[text()='CloneParent']/parent::div");
    By DB_TITLE=By.xpath("//*[@class='MuiTypography-root MuiTypography-h5']");
    //Cloning Dashboard
    By BUTTON_CLONE=By.xpath("//div[@aria-label='Clone this dashboard']");


    //Pin and Unpin Dashboard
    By PIN_DASHBOARD= By.xpath("//div[@aria-label='Pin this dashboard']");
    By ICON_PIN=By.xpath("//span[text()='Pin']");
    By UNPIN_DASHBOARD= By.xpath("//div[@aria-label='Unpin Dashboard']");
    By PIN_DASHBOARDPAGE= By.xpath("//div[@aria-label='Pin Dashboard']");

    //Calender Locators
    By DB_SEARCH =By.xpath("//input[@placeholder='Type or select below']");
    By CALENDAR_ICON =By.xpath("//div[contains(@class, 'DateTimePicker')]//i");
    By FROM_DT_TIME = By.xpath("//div[contains(@class, 'DateTimePicker')]/div/div/span[2]/span[1]");
    By TO_DT_TIME = By.xpath("//div[contains(@class, 'DateTimePicker')]/div/div/span[2]/span[2]");
    By DATE= By.cssSelector(":nth-child(3) > :nth-child(4) > .MuiButtonBase-root > .MuiIconButton-label > .MuiTypography-root");
    By HOURS= By.cssSelector("div.MuiPickersClockPointer-pointer~span");
    By MINUTES= By.cssSelector("div.MuiPickersClockPointer-pointer~span");
    By OPT_DB_DISPLAY_NAME= By.xpath("//span[text()='Dashboard Display Name']");

    //Calander locators
    By BTN_CURRENTHOUR=By.xpath("//span[text()='Current Hour']");
    By BTN_LASTHOUR=By.xpath("//span[text()='Last Hour']");
    By BTN_BUSINESS_HOURS=By.xpath("//span[text()='Business Hours']");
    By BTN_Last_12_Hours=By.xpath("//span[text()='Last 12 Hours']");
    By BTN_TODAY=By.xpath("//span[text()='Today']");
    By BTN_YESTERDAY=By.xpath("//span[text()='Yesterday']");
    By BTN_LAST_7_DAYS=By.xpath("//span[text()='Last 7 Days']");
    By BTN_LAST_30_DAYS=By.xpath("//span[text()='Last 30 Days']");
    By BTN_LAST_MONTH=By.xpath("//span[text()='Last Month']");
    By BTN_THIS_MONTH=By.xpath("//span[text()='This Month']");
    By BTN_ABSOLUTECURRENTHOUR_QA_30_MINS=By.xpath("//span[text()='Absolute QA - 30 min']");
    By BTN_ABSOLUTE_ALL_UNITS=By.xpath("//span[text()='Absolute - All Units']");
    By TIMESTAMPTEXTBOX=By.xpath("//div[contains(@class,'DateTimePicker')]/div/div/span[2]/span");

    //Portlet Locators
    By TEXTBOX_FOLDER=By.xpath("//input[@id='folderKey']");
    By LIST_PORTLETS=By.xpath("//div[@title='Dashboards']//ancestor::div[4]/following-sibling::div[4]/div/div/span/div/div/span");
    By BTN_ADD_METRIC=By.xpath("//button[@type='button']/span/i[@title='Add Metric']");
    By LINK_ADD_METRIC=By.xpath("//button[text()='Add Metric']");
    By TEXT_HEADER= By.xpath("//*[text()='Portlet Name']/../../p[contains(@class,'body1')]");
    By TEXTBOX_PORTLET=By.xpath("//input[@id='name']");
    By BTN_ADD_PORTLET=By.xpath("//span[text()='Add Portlet']");
    By CLONE_PORTLET=By.xpath("//div[@aria-label='Clone this portlet']");
    By LISTBOX_FOLDER_PORTLET=By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]");
    By DASHBOARD_COUNT=By.xpath("//span[@aria-label='Count'][@title='Number of unique items']");
     By DROPDOWN_SHOWAS=By.xpath("//*[text()='Show As']/../../../div//div[contains(@class,'body1')]");
     By TEXTBOX_SHOWAS=By.xpath("//input[@id='showAs']");
     By DROPDWON_KPI=By.xpath("//*[text()='KPI']/../../../div//div[contains(@class,'body1')]");
     By TEXTBOX_KPI=By.xpath("//input[@id='kpi_0']");
     By DROPDOWN_MEASURE=By.xpath("//*[text()='Measure']/../../../div//div[contains(@class,'body1')]");
     By TEXTBOX_SUMMARY=By.xpath("//input[@id='kpiSummary_0']");
     By DROPDOWN_CHARTTYPE=By.xpath("//*[text()='Chart Type']/../../../div//div[contains(@class,'body1')]");
    By TEXTBOX_CHARTTYPE=By.xpath("//input[@id='kpi_0_chartType_0']");
     By DROPDOWN_PIVOT=By.xpath("//*[text()='Pivot']/../../../div//div[contains(@class,'body1')]");
     By DROPDWON_TRENDGRATY=By.xpath("//*[text()='Trend Granularity']/../../../div//div[contains(@class,'body1')]");
     By TEXTBOX_TRENDGRATY=By.xpath("//input[@id='trendGranularity']");
     By TEXTBOX_DECIMAL_PLACES=By.xpath("//input[@id='decimalPlaces']");
     By TEXTBOX_PORTLET_FILTERS=By.xpath("//input[@id='portletFilters']");
     By PortletFilters_TypeSearch=By.xpath("//div[contains(@class,'MuiDialogContent-root')]/div/div/input[@placeholder='Type or select below']");
     By DROPDOWN_FEILDS=By.xpath("//div[text()='Color']");
     By BTN_APPLY=By.xpath("//span[text()='Apply']");
    //Ticket on Dashboard
    By TICKET_ICON= By.xpath("//i[@class='fas fa-ticket-alt']");
    By TICKET_TITLE= By.xpath("//textarea[@id='TextArea']");
    By TICKET_ASSIGNEE= By.xpath("//label[@for='assignee']/following-sibling::div/div/div");
    By TICKET_ASSIGNEE_DROPDOWN= By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By TEXTBOX_ASSIGNEE=By.xpath("//input[@id='assignee']");
    By TICKET_SEVERITY= By.xpath("//label[@for='severity']/following-sibling::div/div/div");
    By SEVERITY_OPTION= By.xpath("//span[contains(text(),'Severity')]/../../../following-sibling::div/div/div/div/div[contains(text(),'Medium')]");
    By TICKET_PRIORITY= By.xpath("//label[@for='priority']/following-sibling::div/div/div");
    By PRIORITY_OPTION= By.xpath("//span[contains(text(),'Priority')]/../../../following-sibling::div/div/div/div/div[contains(text(),'Very High')]");
    By TICKET_STATUS= By.xpath("//label[@for='status']/following-sibling::div/div/div");
    By STATUS_OPTION= By.xpath("//div[contains(text(),'Closed')]");
    By TICKET_PARTCIPANTS= By.xpath("//label[@for='participants']/../div");
    By BUTTON_SUBMIT_TICKET= By.xpath("//span[contains(text(),'Submit ticket')]");
    By TICKETS_PAGE_URL= By.xpath("//span[contains(text(),'Tickets')]");
    By STATUS_TICKETS_PAGE= By.xpath("//div[contains(text(),'Status:')]/following-sibling::div[1]//button[@value='ANY']");
    By TICKET_ASSIGNED_TO= By.xpath("//span[contains(text(),'Anyone')]");


    //Dashboard Visibility - Allowed Users
    By ERROR_MESSAGE = By.xpath("//p[contains(text(),'Unable to access Dashboard')]");
    By DASHBAORD_VISIBILITY_ICON = By.xpath("//div[@aria-label='Update Dashboard Visibility']");
    By ALLOWED_USERS_FIELD = By.xpath("//label[@for='allowedUsers']/following-sibling::div/div");
    By BTN_SAVE_DASHBOARD_VISIBILITY = By.xpath("//span[contains(text(),'Save')]");
    By ADD_METRIC_ICON = By.xpath("//i[@aria-label='Add Metric']");

    //Dashboard Visibility - Required Roles
    By BTN_REQUIRED_ROLES = By.xpath("(//label[@for='roles']/following::button[@aria-label='Add'])[1]");//Alternate Locator : //label[@for='roles']/../../../following-sibling::button
    By NAME_ADD_ROLE_WINDOW = By.xpath("//input[contains(@id,'name')]");
    By VIEW_DATA_PRIVILEGE = By.xpath("//span[contains(text(),'View Data')]");
    By BTN_FINISH_ROLE_WINDOW = By.xpath("//span[contains(text(),'Finish')]");
    By BTN_CLOSE_ROLE = By.xpath("//span[contains(text(),'Close')]");
    By REQUIRED_ROLES_FIELD = By.xpath("//label[@for='roles']/following-sibling::div/div");
    By TEXTBOX_REQUIRED_ROLES = By.xpath("//input[@id='roles']");
    By DROPDOWN_REQUIRED_ROLES = By.xpath("//div[contains(@role,'menuitem')]");

    //Dashboard Visibility - Owner Roles
    By BTN_OWNER_ROLES = By.xpath("//label[@for='ownerRoles']/following::button[@aria-label='Add']");
    By SUCCESS_CREATED_MESSAGE = By.xpath("//li[contains(text(),'created')]");
    By OWNER_ROLES_FIELD = By.xpath("//label[@for='ownerRoles']/following-sibling::div/div");
    By DROPDOWN_OWNER_ROLES = By.xpath("//div[contains(@role,'menuitem')]");
    By BTN_RENAME_DASHBOARD = By.xpath("//div[@aria-label='Rename Dashboard']");
    By BTN_CLONE_DASHBOARD = By.xpath("//div[@aria-label='Clone Dashboard']");
    By BTN_PORTLETS_PER_ROW = By.xpath("//div[@aria-label='Portlets Per Row']");
    By BTN_CLONE_PORTLET = By.xpath("//div[contains(@class,'Portlet')]/div/div/div[@aria-label='Clone']");
    By BTN_EDIT_PORTLET = By.xpath("//div[contains(@class,'Portlet')]/div/div/div[@aria-label='Edit']");
    By BTN_CLOSE_PORTLET = By.xpath("//div[contains(@class,'Portlet')]/div/div/div[@aria-label='Close']");

}