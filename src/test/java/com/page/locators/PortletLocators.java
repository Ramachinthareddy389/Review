package com.page.locators;

import org.openqa.selenium.By;

public interface PortletLocators {

    //Portlet Locators
    By TEXTBOX_FOLDER=By.xpath("//input[@id='folderKey']");
    By LISTOFDASHBOARDS= By.xpath("//div[@title='Dashboards']//ancestor::div[4]//following::div[2]/div/div/span/div/div/span");
    By DROPDOWN_DASHBOARD_FOLDER=By.xpath("//div[contains(@class,'MuiListItem-button')]");
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
    By DROPDOWN_KPI=By.xpath("//*[text()='KPI']/../../../div//div[contains(@class,'body1')]");
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

    //Gauge Portlet
    By GAUGE_HEADER = By.xpath("//button/span[contains(text(),'Gauge')]");
    By GAUGE_TEXTBOX_KPI = By.xpath("//input[@id='kpi']");
    By GAUGE_PORTLET_NAME = By.xpath("//*[text()='Portlet Name']");
    By GAUGE_TEXTBOX_MEASURE =By.xpath("//input[@id='Measure_0']");
    By IS_NOT_PORTLET_FILTER = By.xpath("//button/span[contains(text(),'is')]");

    //Counter Portlet
    By COUNTER_HEADER = By.xpath("//button/span[contains(text(),'Counter')]");
    By COUNTER_TEXTBOX_KPI = By.xpath("//input[@id='kpi']");
    By COUNTER_PORTLET_NAME = By.xpath("//*[text()='Portlet Name']");
    By COUNTER_TEXTBOX_MEASURE =By.xpath("//input[@id='Measure_0']");

    By SEARCH_BAR_ADD_METRIC = By.xpath("//div[contains(@placeholder,'Search insights')]");
    By NO_DATA_AVAILABLE_PORTLET = By.xpath("//div[contains(text(),'No aggregate data available')]");
    By COUNTER_PORTLET_CHART = By.xpath("//div[contains(@class,'CounterChart')]");
    By BTN_DRILLTHROUGH=By.xpath("//div[@aria-label='Drillthrough']");
    By Title_DRILLTHROUGH=By.xpath("//nav[contains(@class,'MuiBreadcrumbs-root')]/following-sibling::div/div/h5");

}
