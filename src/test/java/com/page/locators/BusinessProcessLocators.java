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
}
