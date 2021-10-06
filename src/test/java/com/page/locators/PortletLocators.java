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
    By DROPDOWN_KPI=By.xpath("//span[text()='KPI']");
    By KPI_GHOSTTEXT = By.xpath("//input[@id='kpi']/../../../div[1]");
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
    By BY_LABEL_PIVOT = By.xpath("//div[@aria-label='Label']/../../../following-sibling::div/descendant::span[8]");
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
    By PORTLET_BAR=By.xpath("//div[contains(@class,'GaugeChart')]/../div[1]/*[local-name()='svg']/*[local-name()='text']/*[local-name()='tspan']");
    By TOOLTIPOPTION_1=By.xpath("//a[text()='View the worst (RCA)']");
    By TOOLTIPOPTION_2=By.xpath("//a[contains(text(),'Raw')]");
    By TOOLTIPOPTION_3=By.xpath("//a[contains(text(),'Pivot')]");
    By HYPERLINKDBINDRILLTHROUGH=By.xpath("//a[contains(@class,'MuiLink-root')]/span");
    By DROPDWON_KPI=By.xpath("//*[text()='KPI']/../../../div//div[contains(@class,'body1')]");
    By BTN_CLONE_PORTLET = By.xpath("//div[@aria-label='Clone']");
    By DASHBOARD_FIELD_CLONE_PORTLET = By.xpath("//label[contains(@for,'dashboardKey')]/../div");
    By DROPDOWN_DASHBOARDS = By.xpath("//div[contains(@role,'menuitem')]");
    By DASHBOARD_OPTION_CLONE_PORTLET = By.xpath("//input[contains(@id,'dashboardKey')]");
    By BTN_CLONE_PORTLET_WINDOW = By.xpath("//button/span[contains(text(),'Clone')]");
    By CONFIRM_DELETE_PORTLET = By.xpath("//button/span[contains(text(),'Confirm')]");
    By TEXTBOX_TYPESEARCH=By.xpath("//input[@placeholder='Type or select below']");
    By All_FOLDER    =By.xpath("//span[text()='All']");
    By BTN_EXPORT=By.xpath("//div[@aria-label='Export']");

    //N Tabular Portlet
    By NTABULAR_HEADER = By.xpath("//button/span[contains(text(),'N Tabular')]");
    By NTABULAR_TEXTBOX_KPI = By.xpath("//input[contains(@id,'kpi_0')]");
    By NTABULAR_PORTLET_NAME = By.xpath("//*[text()='Portlet Name']");
    By NTABULAR_ORDER_BY_OPTION = By.xpath("//div[(@role='menuitem')][contains(text(),'By Tally Column')]");
    By NTABULAR_TALLY_COLUMN = By.xpath("//*[text()='Tally Column']/../../../div//div[contains(@class,'body1')]");
    By NTABULAR_TALLY_COLUMN_OPTION = By.xpath("//input[contains(@id,'tallyColumn')]");
    By NTABULAR_TEXTBOX_MEASURE = By.xpath("//input[contains(@id,'Measure_0')]");
    By TEXTBOX_KPI_FILTERS = By.xpath("//input[contains(@id,'kpiFilters')]");
    By NTABULAR_LABEL_FIELD = By.xpath("//label[contains(@for,'label')]");
    By NTABULAR_LABEL_FIELD_TEXTBOX = By.xpath("//input[contains(@id,'label')]");
    By NTABULAR_SHOW_KPI_NAME_CHECKBOX = By.xpath("//span[contains(text(),'Show KPI Name')]");
    By KPI_FILTER_OPTION = By.xpath("//div[text()='Application Name']");
    By NTABULAR_PORTLET_CHART = By.xpath("//div[contains(@class,'Portlet')]/div/following-sibling::div/div[contains(@style,'flex')]");
    By ORDER_BY_FIELD = By.xpath("//label[@for='orderBy']/../div");
    By ORDER_BY_OPTION = By.xpath("//div[(@role='menuitem')][contains(text(),'By Pivot Value')]");
    By ORDER_DIRECTION_FIELD = By.xpath("//label[@for='orderDirection']/../div");
    By ORDER_DIRECTION_OPTION = By.xpath("//div[(@role='menuitem')][contains(text(),'Ascending')]");

    //Tabular Portlet
    By TABULAR_HEADER = By.xpath("//button/span[contains(text(),'Tabular')]");
    By TABULAR_TEXTBOX_KPI = By.xpath("//input[@id='kpi']");
    By TABULAR_PORTLET_NAME = By.xpath("//*[text()='Portlet Name']");
    By SHOW_SLA_COLUMN_CHECKBOX = By.xpath("//span[contains(text(),'Show SLA Column')]");
    By TABULAR_PIVOT_FIELD = By.xpath("//label[contains(@for,'pivots')]/../div");
    By TABULAR_PIVOT_FIELD_INPUT = By.xpath("//input[contains(@id,'pivots')]");
    By TABULAR_MEASURES_FIELD = By.xpath("//label[contains(@for,'measures')]/../div");
    By TABULAR_MEASURES_FIELD_INPUT = By.xpath("//input[contains(@id,'measures')]");

    //Flow Portlet
    By FLOW_HEADER = By.xpath("//button/span[contains(text(),'Flow')]");
    By FLOW_TEXTBOX_KPI = By.xpath("//input[@id='kpi']");
    By FLOW_PORTLET_NAME = By.xpath("//*[text()='Portlet Name']");
    By FLOW_COLUMN_LABEL = By.xpath("//label[contains(@for,'columnLabel')]");
    By FLOW_COLUMN_LABEL_INPUT = By.xpath("//input[contains(@id,'columnLabel')]");
    By FLOW_CLUSTER_BY_LABEL = By.xpath("//label[contains(@for,'clusterBy')]");
    By FLOW_CLUSTER_BY_DATA = By.xpath("//label[contains(@for,'clusterBy')]/../div");
    By FLOW_CLUSTER_BY_INPUT = By.xpath("//input[@id='clusterBy']");
    By FLOW_FILTER_VALUE_LABEL = By.xpath("//label[contains(@for,'filterValue')]");
    By FLOW_FILTER_VALUE = By.xpath("//input[contains(@id,'filterValue')]");
    By FLOW_FILTER_POSITION_LABEL = By.xpath("//label[@for='filterAtStart']/../div");
    By LABEL_FILTER_POSITION_CHART = By.xpath("//span[text()='Filter Position (Chart)']");
    By TXTBOX_FILTER_POSITION_CHART = By.xpath("//input[@id='filterAtStart']");
    By FILTER_POSITION_CHART_GHOSTTEXT = By.xpath("//input[@id='filterAtStart']/../../../div[1]");
    By FLOW_FILTER_POSITION = By.xpath("//div[(@role='menuitem')][contains(text(),'End At')]");
    By FLOW_SHOW_USERS_CHECKBOX = By.xpath("//span[contains(text(),'Show Users')]");
    By BTN_MAXIMIZE_PORTLET = By.xpath("//div[@aria-label='Maximize']");
    By FLOW_PORTLET_GRAPH = By.xpath("//*[local-name()='svg' and contains(@id,'graph')]");

    By SLACOLUMNS=By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a[2]/div/div/div[1]/span/div/div/span[4]");
    By USERNAME_COLUMN_PORTLET=By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a[2]/div/div/div[2]/span/span");
    By SLAFILTERICON=By.xpath("//span[contains(@aria-label,'user.name')]");
    By TABULAR_COLUMN1=By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[1]/span/span");
    By TABULAR_COLUMN2 =By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[2]/span/span");
    By TABULAR_COLUMN3=By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[3]/span/span");

    //Map Portlet
    By MAP_HEADER = By.xpath("//button/span[contains(text(),'Map')]");
    By MAP_TEXTBOX_KPI = By.xpath("//input[@id='kpi']");
    By MAP_PORTLET_NAME = By.xpath("//*[text()='Portlet Name']");
    By MAP_LOCATION_FOR_LABEL = By.xpath("//label[@for='locationFor']");
    By MAP_LOCATION_FOR = By.xpath("//label[@for='locationFor']/../div");
    By MAP_LEVEL_DROPDOWN = By.xpath("//*[text()='Map Level']/../../../div//div[contains(@class,'body1')]");
    By MAP_LEVEL_TEXTBOX = By.xpath("//input[@id='mapLevel']");
    By NtabularFirstRow = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[1]/span/span");
    By NTABULARSENDROW = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[2]/span/span");
    By NTABULARTHIRDROW = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[3]/span/span");
    By CLOSE_PORTLET = By.xpath("//div[@aria-label='Close']");
    By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
    By PORTLET_NOTIFY = By.xpath("//div[text()='No portlets configured, click to add a metric.']");
    By GAUGEPORTLETDATA = By.xpath("//div[contains(@class,'highcharts-label')]/span");
    By COUNTERPORTLETDATA = By.xpath("//div[contains(@class,'CounterChart')]/div/span/span[2]");


    //RCA
    By ICON_MAXMIZE_RCA = By.xpath("//span[contains(@aria-label,'Issue Description')]/../../../descendant::div[contains(@aria-label,'Maximize')]");
    By ICON_RESTORE_RCA = By.xpath("//span[contains(@aria-label,'Issue Description')]/../../../descendant::div[contains(@aria-label,'Restore')]");
    By TIME_SESSION_RCA = By.xpath("//span[contains(text(),'Time')]/../following-sibling::div/span/span");
    By CALENDAR_TIME_RANGE = By.xpath("//div[contains(@class,'DateTimePicker')]/descendant::span[contains(@style,'nowrap')]");

    By EDIT_PENCIL_ICON = By.xpath("//div[@aria-label ='Edit']/span/i");
    By MEASURE_ADD_ICON = By.xpath("//i[@aria-label='Add']");
    By MEASURE_TXTBOX = By.xpath("//input[@id='kpi_0_measure_1']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_SAVE = By.xpath("//span[text()='Save']");
    By CHKBOX_SHOW_LEGEND = By.xpath("//span[text() ='Show Legend']");
    By LEGENDS = By.xpath("//*[local-name()='tspan']");
}
