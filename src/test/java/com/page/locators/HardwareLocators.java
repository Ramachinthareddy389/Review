package com.page.locators;

import org.openqa.selenium.By;

public interface HardwareLocators {
    By BTN_DATASOURCES = By.xpath("//span[text()='Data Sources']");
    By BTN_HARDWARE = By.xpath("//span[text()='Hardware']");
    By BTN_COMPONENT = By.xpath("//span[contains(text(),'Components')]");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//span[text()='Server Name']/../../following-sibling::div/input");
    By LABEL_ENVIRONMENT = By.xpath("//span[text()='Environment']");
    By ENVIRONMENT_GHOSTEXT = By.xpath("//input[@id='environment']/../../../div[1]");
    By TXTBOX_ENVIRONMENT = By.xpath("//input[@id='environment']");
    By LABEL_TYPE = By.xpath("//span[text()='Type']");
    By TYPE_GHOSTTEXT = By.xpath("//input[@id='type']/../../../div[1]");
    By TXTBOX_TYPE = By.xpath("//input[@id='type']");
    By LABEL_HOSTNAME = By.xpath("//span[text()='Host Name']");
    By TXTBOX_HOSTNAME = By.xpath("//input[@id='hostname']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_OSFAMILY = By.xpath("//span[text()='OS Family']");
    By OSFAMILY_GHOSTEXT = By.xpath("//input[@id='osFamily']/../../../div[1]");
    By TXTBOX_OSFAMILY = By.xpath("//input[@id='osFamily']");
    By LABEL_OSNAME = By.xpath("//span[text()='OS Name']");
    By OSNAME_GHOSTEXT = By.xpath("//input[@id='osName']/../../../div[1]");
    By TXTBOX_OSNAME = By.xpath("//input[@id='osName']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By SERVERVALUE = By.xpath("//input[@id='server']/../../../div");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By EDITLABEL_HOSTNAME = By.xpath("//span[text()='Hostname']");
    By LOCALAGENTADDICON = By.xpath("//h4[text()='Local Monitoring Agents:']//../following-sibling::button/span/i");
    By LOCALAGENTMONITORINGDROPDOWN = By.xpath("//div[@class='MuiPopover-root'][3]/following-sibling::div/div/ul/li");
    By LABEL_SOFTWARE = By.xpath("//input[@id='monitoredApplication']/../../../../../../label/p/span");
    By SOFTWARE_GHOSTEXT = By.xpath("//input[@id='monitoredApplication']/../../../div[1]");
    By TXTBOX_SOFTWARE = By.xpath("//input[@id='monitoredApplication']");
    By LABEL_AGENT = By.xpath("//div[@class='DynamicFormInput'][3]/div/div/label");
    By TXTBOX_LABEL_AGENT = By.xpath("//div[@class='DynamicFormInput'][3]/div/div/div/input");
    //APM State Locators
    By APMHEADER = By.xpath("//span[text()='APM']");
    By APMSTATE_HEADER = By.xpath("//span[text()='APM State']");
    By NODES_TAB = By.xpath("//span[contains(text(),'Nodes')]");
    By LABEL_HOSTNAME_NODE = By.xpath("//span[text()='Hostname']");
    By TXTBOX_HOSTNAME_NODE = By.xpath("//input[@id='hostname']");
    By MONITORSCRIPTPROFILE_LABEL = By.xpath("//span[text()='Monitoring script profile']");
    By ENGINES_ADDICON = By.xpath("//span[text()='Hostname']/../../../../../div[3]/div/div/button/span/i");
    By LABLE_NAME = By.xpath("//span[text()='Show Advanced']/../../parent::div/div[2]/div/div/label");
    By TXTBOX_NAME= By.xpath("//span[text()='Show Advanced']/../../parent::div/div[2]/div/div/div/input");
    By BTN_SHOW_ADVANCED =By.xpath("//span[text()='Show Advanced']");
    By LABEL_MONITORED_SERVER = By.xpath("//input[@id='monitoredServer']/../../../../../../label/p/span");
    By MONITORED_SERVER_GHOSTEXT = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
    By TXTBOX_MONITORED = By.xpath("//input[@id='monitoredServer']");
    By ENGINE_MONITORIN_GPROFILES = By.xpath("//h4[text()='Engine Monitoring Profiles:']//../following-sibling::button/span/i");
    By APPLYPROFILEDROPDOWN     = By.xpath("//span[text()='Apply']/../../div/div");
    By BTN_APPLY = By.xpath("//span[text()='Apply']");
    By BTN_REMOVE_PROFILE = By.xpath("//div[@aria-label='Remove Profile']");
    By BTN_CONFIRM = By.xpath("//span[text()='Confirm']");
    By LOG_DIRCT_LABEL = By.xpath("//label[@id='logDirectory-label']");
    By TXTBOX_LOG_DIRCT = By.xpath("//input[@id='logDirectory']");
    By SUCESS_MSGS = By.xpath("//div[contains(@class,'WizardSummary')]/div/span/ul/li");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    By DROPDOWN1  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Apache HTTP Server']");
    By DROPDOWN2  = By.xpath("//div[@id='menu-']/div/ul/li[text()='BIP App Server']");
    By DROPDOWN3  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Apache Tomcat Server']");
    By DROPDOWN4  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Microsoft IIS Server']");
    By DROPDOWN5  = By.xpath("//div[@id='menu-']/div/ul/li[text()='MySQL Database Server]");
    By DROPDOWN6  = By.xpath("//div[@id='menu-']/div/ul/li[text()='OBIEE Server']");
    By DROPDOWN7  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Oracle Database Server']");
    By DROPDOWN8  = By.xpath("//div[@id='menu-']/div/ul/li[text()='PHP Server']");
    By DROPDOWN9  = By.xpath("//div[@id='menu-']/div/ul/li[text()='PostgreSQL Database Server']");
    By DROPDOWN10 = By.xpath("//div[@id='menu-']/div/ul/li[text()='SQL Server Database Server']");
    By DROPDOWN11  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Salesforce Application']");
    By DROPDOWN12  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Siebel App Server']");
    By DROPDOWN13  = By.xpath("//div[@id='menu-']/div/ul/li[text()='DB2 Database Server']");
    By TXTBOX_EDITED_SERVERNAME = By.xpath("//input[@id='name']");
    By TXTBOX_EDITED_HOSTNAME = By.xpath("//input[@id='hostname']");
    By TXTBOX_EDITED_ENVIRON = By.xpath("//input[@id='environment']/../../../div[1]");
    By TXTBOX_EDITED_TYPE = By.xpath("//input[@id='type']/../../../div[1]");
    By TXTBOX_EDITED_OSFAMILY = By.xpath("//input[@id='osFamily']/../../../div[1]");
    By TXTBOX_EDITED_OSNAME = By.xpath("//input[@id='osName']/../../../div[1]");
    By DELETE_ALERT = By.xpath("//div[@aria-label='Remove Configuration']");
    By CONFIRM_DELETE = By.xpath("//button/span[contains(text(),'Confirm')]");
    By SELECTROW_CHKBOX = By.xpath("//input[@aria-label='Select Row']");
    By BTN_STATUS = By.xpath("//h5[text()='Hardware']/..//div[@aria-disabled='true']");
    By HEADER_CLONED = By.xpath("//div[@aria-label='Save Configuration']/../../h5");
    By BTN_DELETE = By.xpath("//h5[text()='Hardware']/..//div[@aria-label='Remove Selected Configuration']");

    By BTN_ENABLE = By.xpath("//h5[text()='Hardware']/..//div[@aria-label='Enable Selected Configuration']");
    By BTN_DISABLE = By.xpath("//h5[text()='Hardware']/..//div[@aria-label='Disable Selected Configuration']");
    By BTN_CLONE = By.xpath("//h5[text()='Hardware']/..//div[@aria-label='Clone Selected Configuration']");
    By BTN_EDIT = By.xpath("//h5[text()='Hardware']/..//div[@aria-label='Edit Selected Configuration']");
    By CHEKBOXES_EDITWINDOW = By.xpath("//h6[text() ='Editing 1 Hardware']/parent::div/../../following-sibling::div/descendant::input[@type='checkbox']");
    By BTN_APPLY_PROFILE = By.xpath("//h5[text()='Hardware']/..//div[@aria-label='Apply Profile']");
    By BTN_APPLY_CHANGES = By.xpath("//span[text()='Apply changes']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS = By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div/div[text()='Name']");
    By LABEL_SAVE = By.xpath("//span[text()='Save']");
}