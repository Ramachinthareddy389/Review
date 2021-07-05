package com.page.locators;

import org.openqa.selenium.By;

public interface HardwareLocators {
    By BTN_DATASOURCES = By.xpath("//span[text()='Data Sources']");
    By BTN_HARDWARE = By.xpath("//span[text()='Hardware']");
    By BTN_ADDICON = By.xpath("//i[@aria-label='Add New Configuration']");
    By LABEL_SERVERNAME = By.xpath("//label[@id='name-label']");
    By TXTBOX_SERVERNAME = By.xpath("//input[@id='name']");
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
    By JSSCRPTS_TAB = By.xpath("//span[@title='Germain APM JavaScript scripts for UX monitoring']");
    By LABEL_HOSTMACHINE = By.xpath("//span[text()='Host Machine']");
    By HOSTMACHINE_GHOSTEXT = By.xpath("//input[@id='monitoredServer']/../../../div[1]");
    By TXTBOX_HOSTMACHINE = By.xpath("//input[@id='monitoredServer']");
    By MONITORSCRIPTPROFILE_LABEL = By.xpath("//span[text()='Monitoring script profile']");
    By MONITORINGPROFILEADDICON = By.xpath("//h4[text()='Engine Monitoring Profiles:']//../following-sibling::button/span/i");
    By APPLYPROFILEDROPDOWN     = By.xpath("//span[text()='Apply']/../../div/div");
    By BTN_APPLY       =By.xpath("//span[text()='Apply']");
    By DROPDOWN1  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Apache Tomcat Server']");
    By DROPDOWN2  = By.xpath("//div[@id='menu-']/div/ul/li[text()='BIP App Server']");
    By DROPDOWN3  = By.xpath("//div[@id='menu-']/div/ul/li[text()='DB2 Database Server']");
    By DROPDOWN4  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Microsoft IIS Server']");
    By DROPDOWN5  = By.xpath("//div[@id='menu-']/div/ul/li[text()='MySQL Database Server]");
    By DROPDOWN6  = By.xpath("//div[@id='menu-']/div/ul/li[text()='OBIEE Server']");
    By DROPDOWN7  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Oracle Database Server']");
    By DROPDOWN8  = By.xpath("//div[@id='menu-']/div/ul/li[text()='PHP Server']");
    By DROPDOWN9  = By.xpath("//div[@id='menu-']/div/ul/li[text()='PostgreSQL Database Server']");
    By DROPDOWN10 = By.xpath("//div[@id='menu-']/div/ul/li[text()='SQL Server Database Server']");
    By DROPDOWN11  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Salesforce Application']");
    By DROPDOWN12  = By.xpath("//div[@id='menu-']/div/ul/li[text()='Siebel App Server']");

}