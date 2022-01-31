package com.page.locators;

import org.openqa.selenium.By;

public interface HTTPLocators {
    By BTN_AUTOMATION = By.xpath("//span[text()='Automation']");
    By BTN_HTTP = By.xpath("//span[text()='HTTP']");
    By BTN_ADDICON_HTTP = By.xpath("//h5[text()='Http Actions']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_ACTIONS_NAME = By.xpath("//span[text()='Action Name']");
    By TXTBOX_ACTIONS_NAME= By.xpath("//input[@id='name']/../../../../div/div/div/input");
    By LABEL_PATH = By.xpath("//label[@id='path-label']/p/span[text()='Path']");
    By TXTBOX_PATH= By.xpath("//input[@id='path']/../../../../div/div/div/input");
    By LABEL_REQUEST_METHOD = By.xpath("//span[text()='Request Method']");
    By REQUEST_METHOD_GHOSTTEXT = By.xpath("//input[@id='method']/../../../div[1]");
    By TXTBOX_REQUEST_METHOD= By.xpath("//input[@id='method']");
    By LABEL_CONTENT_TYPE = By.xpath("//span[text()='Content Type']");
    By CONTENT_TYPE_GHOSTTEXT = By.xpath("//input[@id='contentType']/../../../div[1]");
    By TXTBOX_CONTENT_TYPE = By.xpath("//input[@id='contentType']");
    By LABEL_SLA = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/div/label/p/span");
    By SLA_GHOSTTEXT = By.xpath("//input[@id='names']/../../../div[1]");
    By TXTBOX_SLA = By.xpath("//input[@id='names']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_SAVE_DISABLED = By.xpath("//div[@aria-label='Save Configuration'][@aria-disabled ='true']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By TXTBOX_HOSTNAME = By.xpath("//input[@id='hostname']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By CLOSE_ICON = By.xpath("//button[@aria-label='close']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By HYPERLINK_SLAs = By.xpath("//span[text()='Triggered By SLAs']/../../../div/div/button");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_TARGET_PATH = By.xpath("//input[@id='target.path']");
    By TXTBOX_EDITED_TARGET_METHOD = By.xpath("//input[@id='target.method']/../../../div[1]");
    By TXTBOX_EDITED_TARGET_CONTENT_TYPE = By.xpath("//input[@id='target.contentType']/../../../div[1]");
    By SLA_ADD_ICON = By.xpath("//span[text()='Triggered By SLAs']/../../../div/button/span/i[@aria-label='Add New Configuration']");
    By SLAVALUE_INHTTPPAGE = By.xpath("//div[text()='Triggered By SLAs']/following-sibling::span/button");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_ENABLE = By.xpath("//h5[text()='Http Actions']/..//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//h5[text()='Http Actions']/..//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//h5[text()='Http Actions']/..//div[@aria-label='Clone Selected Configuration']");
    By BTN_STATUS = By.xpath("//h5[text()='Http Actions']/..//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//h5[text()='Http Actions']/..//div[@aria-label='Remove Selected Configuration']");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By BTN_DELETE_SCENARIO = By.xpath("//h5[text()='Http Scenarios']/..//div[@aria-label='Remove Selected Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By BTN_EDIT = By.xpath("//h5[text()='Http Actions']/..//div[@aria-label='Edit Selected Configuration']");
    By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Http Actions']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
    By EDIT_HEADER = By.xpath("//h6[text()='Editing 1 Http Actions']");
    By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By DISABLE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Disable Configuration']");
    By CLONE_ICON = By.xpath("//div[@aria-label='Save Configuration']/following-sibling::div[@aria-label='Clone Configuration']");
    By ENABLED_STATUS = By.xpath("//div[@aria-label='Enable Configuration']");
    By LABEL_ALERT_TEMP = By.xpath("//span[text()='Alert Template']");
    By ALERT_GHOSTTEXT = By.xpath("//input[@id='alertTemplate']/../../../div[1]");
    By TXTBOX_ALERT= By.xpath("//input[@id='alertTemplate']");
    By EYE_ICON = By.xpath("//i[@class='far fa-eye']");
    By KPIS_TEXT = By.xpath("//h6[text()='Alert Template']");
    By LIST_OF_KPIS_VALUES = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/descendant::p/following-sibling::span/span");
    By CLOSE_WINDOW = By.xpath("//button[@aria-label='close']");
    By BTN_SHOWADVANCED = By.xpath("//span[text()='Show Advanced']");
    By TXTBOX_EXECOUNT = By.xpath("//input[@id='limitCount']");
    //HTTP SCENARIOS
    By BTN_ADDICON_HTTP_SCENARIOS = By.xpath("//h5[text()='Http Scenarios']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_HTTPSCENARIO = By.xpath("//li[text()='HTTP Scenario']");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By LABEL_ENGINE = By.xpath("//span[text()='Engine']");
    By ENGINE_GHOSTTEXT = By.xpath("//input[@id='nodeAndEngine_child']/../../../div[1]");
    By TXTBOX_ENGINE = By.xpath("//input[@id='nodeAndEngine_child']");
    By LABEL_MONITORING_NODE= By.xpath("//span[text()='Monitoring Node']");
    By MONITORING_NODE_GHOSTTEXT = By.xpath("//input[@id='nodeAndEngine']/../../../div[1]");
    By TXTBOX_MONITORING_NODE = By.xpath("//input[@id='nodeAndEngine']");
    By LABEL_APPLICATION_NAME= By.xpath("//span[text()='Application Name']");
    By APPLICATION_NAME_GHOSTTEXT = By.xpath("//input[@id='monitoredApplication']/../../../div[1]");
    By TXTBOX_APPLICATION_NAME = By.xpath("//input[@id='monitoredApplication']");
    By APMHEADER = By.xpath("//span[text()='APM']");
    By APMSTATE_HEADER = By.xpath("//span[text()='APM State']");
    By NODES_TAB = By.xpath("//span[contains(text(),'Nodes')]");
    By LABEL_HOSTNAME_NODE = By.xpath("//span[text()='Hostname']");
    By TXTBOX_HOSTNAME_NODE = By.xpath("//input[@id='hostname']");
    By MONITORSCRIPTPROFILE_LABEL = By.xpath("//span[text()='Monitoring script profile']");
    By ENGINES_ADDICON = By.xpath("//span[text()='Hostname']/../../../../../div[3]/div/div/button/span/i");
    By LABLE_NAME = By.xpath("//span[text()='Show Advanced']/../../parent::div/div[2]/div/div/label");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By BTN_SHOW_ADVANCED =By.xpath("//span[text()='Show Advanced']");
    By LABEL_MONITORED_SERVER = By.xpath("//input[@id='monitoredServer']/../../../../../../label/p/span");
    By MONITORED_SERVER_GHOSTEXT = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
    By TXTBOX_MONITORED = By.xpath("//input[@id='monitoredServer']");
    By ENGINE_MONITORIN_GPROFILES = By.xpath("//h4[text()='Engine Monitoring Profiles:']//../following-sibling::button/span/i");
    By APPLYPROFILEDROPDOWN     = By.xpath("//span[text()='Apply']/../../div/div");
    By LABEL_THRESHOLD_SLA = By.xpath("//label[@id='threshold-label']");
    By TXTBOX_SLA_THRESHOLD = By.xpath("//input[@id='threshold']");
    By LABEL_ACTIONS = By.xpath("//span[text()='SLA Actions']");
    By ACTIONS_GHOSTTEXT = By.xpath("//input[@id='actions']/../../../div[1]");
    By TXTBOX_ACTIONS= By.xpath("//input[@id='actions']");
    By LABEL_HTTPSCENARIO_HAR_FILE = By.xpath("//li[text()='HTTP Scenario (from .har file)']");
    By BTN_IMPORT = By.xpath("//i[@aria-label='Select .har file to import']");
    By SCENARIO_TARGET_ICON = By.xpath("//span[text()='Scenario Targets']/../../../div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_HTTPSCENARIO_TARGET = By.xpath("//li[text()='HTTP Scenario Target']");

}
