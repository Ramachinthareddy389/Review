package com.page.locators;

import org.openqa.selenium.By;

public interface BusinessProcessLocators {
    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By BTN_BUSIPROCESS = By.xpath("//span[text()='Business Processes']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By LABEL_KPIS = By.xpath("//input[@id='kpis']/../../../div[1]/../../../../label/p/span[1]");
    By KPIS_GHOSTEXT = By.xpath("//input[@id='kpis']/../../../div[1]");
    By TXTBOX_KPIS = By.xpath("//input[@id='kpis']");
    By LABEL_KEYEXP = By.xpath("//span[text()='Key Expression']");
    By KEYEXP_GHOSTEXT = By.xpath("//input[@id='keyExpression']/../../../div[1]");
    By TXTBOX_KEYEXP = By.xpath("//input[@id='keyExpression']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_SLA = By.xpath("//label[@id='threshold-label']");
    By TXTBOX_SLA = By.xpath("//input[@id='threshold']");
    By BTN_SLAADDICON = By.xpath("//span[text()='Filters']/..//../../button[@aria-label='Add']");
    By CREATE_GHOSTEXT = By.xpath("//span[text()='Filters']/../../../../../div[4]/div/div/div/div/div/div/div/div/div/div[text()='Create...']");
    By Filter_GHOSTEXT = By.xpath("//span[text()='Filters']/../../../../../div[4]/div/div/div/div/div/div/div/div/div/div[text()='Select...']");
    By TXTBOX_FILTERS = By.xpath("//input[@id='filters_key_0']");
    By TXTBOX_VALUE = By.xpath("//input[@id='filters_value_0']");
    By BTN_SKIP = By.xpath("//span[text()='Skip']");
    By LABEL_DASHBOARD = By.xpath("//span[text()='Dashboard']");
    By DASHBOARD_GHOSTEXT = By.xpath("//input[@id='dashboard']/../../../div[1]");
    By TXTBOX_DASHBOARD = By.xpath("//input[@id='dashboard']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By SERVERVALUE = By.xpath("//input[@id='server']/../../../div");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By CREATE_LABEL = By.xpath("//div[contains(@class,'MuiListItem-button')][contains(@id,'react-select')]");
    By TXTBOX_EDITED_KPIS = By.xpath("//input[@id='kpis']/../../../div[2]/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
 // Business Process Steps
    By BPSTEPS_ADDICON = By.xpath("//span[text()='BP Steps']/../../following-sibling::div/button/span/i");
    By TXTBOX_BPSTEPS_VALUE = By.xpath("//button[@aria-label='Delete']/preceding-sibling::i/following-sibling::div/input");
    By LABEL_STEPNAME = By.xpath("//span[text()='Step Name']/../../../label[@id='name-label']");
    By TXTBOX_STEPNAME = By.xpath("//span[text()='Step Name']/../../../div/input[@id='name']");
    By ADDED_BPSTEPS = By.xpath("//span[text()='BP Steps']/../../../div/div/div/button");
    By BTN_REMOVEBPSTEPS = By.xpath("//span[text()='BP Steps']/../../../div/div/div/div[@aria-label='Remove Configuration']");


    //BP Step Metrics

    By BPSTEP_METRICS_ADDICON = By.xpath("//span[text()='BP Step Metrics']/../../following-sibling::div/button/span/i");
    By LABEl_METRIC_NAME = By.xpath("//span[text()='Metric name']/../../../label[@id='name-label']");
    By TXTBOX_METRIC_NAME = By.xpath("//span[text()='Metric name']/../../../div/input[@id='name']");
    By TXTBOX_METRIC_EXP = By.cssSelector("textarea.inputarea");
    By BTN_REMOVE_BPSTEP_METRICS = By.xpath("//span[text()='BP Step Metrics']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By ADDED_BPMETRIC =By.xpath("//span[text()='BP Step Metrics']/../../../div/div/div/button");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By EYE_ICON = By.xpath("//i[@class='far fa-eye']");
    By KPIS_TEXT = By.xpath("//h6[text()='KPIs']");
    By LISTOF_KPIS = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p");
    By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
    By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
    By DRILLTHROUGH_LABEL = By.xpath("//a[text()='View Drillthrough']");
    By Title_DRILLTHROUGH=By.xpath("//div[contains(@class,'MuiContainer-root ')]/div//following-sibling::div/div/h5");
    By KPIS_LINKS = By.xpath("//div[@title='Select Row']/../descendant::button[1]");
    By ENABLED_STATUS =By.xpath("//div[@aria-label='Enable Configuration']");
    By DISABLED_STATUS = By.xpath("//input[@value='Disabled']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By REMOVE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Remove Configuration']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS=By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div[2]/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//h5[text()='Business Processes']/..//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//h5[text()='Business Processes']/..//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//h5[text()='Business Processes']/..//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//h5[text()='Business Processes']/..//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//h5[text()='Business Processes']/..//div[@aria-label='Remove Selected Configuration']");
}
