package com.page.locators;

import org.openqa.selenium.By;

public  interface  APMEnterpriseLocators {
    By APMHEADER = By.xpath("//span[text()='APM']");
    By APMSTATE_HEADER = By.xpath("//span[text()='APM State']");
    By ENTERPRISE_TAB = By.xpath("//span[contains(text(),'Enterprise')]");
    By INSTANCE_COLUMN = By.xpath("//div[text()='Instance ID']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS=By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div[2]/div[text()='Type']");
    By HOSTNAME_VALUE = By.xpath("(//span[contains(text(),'Action')])[1]");
    By DRILLTHRUGH_FACT_PROCESSED = By.xpath("//span[text()='Facts Processed (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_FACT_PROCESSED = By.xpath("//h5[text()='Drillthrough on Facts Processed']");
    By DRILLTHRUGH_CPU = By.xpath("//span[text()='CPU Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_CPU = By.xpath("//h5[text()='Drillthrough on CPU Usage']");
    By DRILLTHRUGH_HEAP = By.xpath("//span[text()='Heap Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_HEAP = By.xpath("//h5[text()='Drillthrough on Heap Usage']");
    By EXPORT_FACT_PROCESSED = By.xpath("//span[text()='Facts Processed (Auto)']/../../following-sibling::div/descendant::span//i[@class='fas fa-file-csv']");
    By EXPORT_CPU = By.xpath("//span[text()='CPU Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-file-csv']");
    By EXPORT_HEAP = By.xpath("//span[text()='Heap Usage (Auto)']/../../following-sibling::div/descendant::span//i[@class='fas fa-file-csv']");
    By QUEUES_TAB = By.xpath("//span[contains(text(),'Queues')]");
    By ERRORS_COLUMN = By.xpath("//div[text()='Errors']");
    By DROPDOWN_FEILDS_QUEUES=By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div[2]/div[text()='Name']");
    By NAME_QUEUE = By.xpath("(//span[text()='apm.action'])[2]");
    By DRILLTHRUGH_QUEUESIZE = By.xpath("//span[text()='Queue Size (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_QUEUESIZE = By.xpath("//h5[text()='Drillthrough on Queue Size']");
    By EXPORT_QUEUESIZE = By.xpath("//span[text()='Queue Size (Auto)']/../../following-sibling::div/descendant::span//i[@class='fas fa-file-csv']");
    By EXPORT_QUEUE_HEAP = By.xpath("//span[text()='Queue Heap Usage (Auto)']/../../following-sibling::div/descendant::span//i[@class='fas fa-file-csv']");
    By TITLE_DRILLTHRUGH_QUEUE_HEAP = By.xpath("//h5[text()='Drillthrough on Queue Heap Usage']");
    By DRILLTHRUGH_QUEUE_HEAP = By.xpath("//span[text()='Queue Heap Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By NODES_TAB = By.xpath("//span[contains(text(),'Nodes')]");
    By ENGINES_COLUMN = By.xpath("//div[text()='Engines']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_SERVERNAME = By.xpath("//input[@id='name']");
    By LABEL_HOSTNAME_NODE = By.xpath("//span[text()='Hostname']");
    By TXTBOX_HOSTNAME_NODE = By.xpath("//input[@id='hostname']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By ENGINES_ADD_ICON_IN_NODE = By.xpath("//i[contains(@aria-label,'A list of Germain engines that will be run on this node.')]/../../following-sibling::div/button/span/i");
    By LABLE_NAME = By.xpath("//span[text()='Show Advanced']/../../parent::div/div[2]/div/div/label");
    By TXTBOX_NAME= By.xpath("//span[text()='Show Advanced']/../../parent::div/div[2]/div/div/div/input");
    By BTN_SHOW_ADVANCED =By.xpath("//span[text()='Show Advanced']");
    By LABEL_MONITORED_SERVER = By.xpath("//input[@id='monitoredServer']/../../../../../../label/p/span");
    By MONITORED_SERVER_GHOSTEXT = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
    By TXTBOX_MONITORED = By.xpath("//input[@id='monitoredServer']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By CLOSE_EDITOR = By.xpath("//div[@aria-label='Close Editor']");
    By ENGINE_HYPERLINK = By.xpath("//i[contains(@aria-label,'A list of Germain engines that will be run on this node.')]/../../following-sibling::div/div/descendant::button");
    By NODEADD_ICON_ENGINES = By.xpath("(//button[@aria-label='Add'])[1]");
    By ENGINES_TAB = By.xpath("//span[contains(text(),'Engines')]");
    By TXTBOX_NAME_NODE = By.xpath("(//input[@id='name'])[2]");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By DROPDOWN_ENGINE=By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div[3]/div[text()='Name']");


}
