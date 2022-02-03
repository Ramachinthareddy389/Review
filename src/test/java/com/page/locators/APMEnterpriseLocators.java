package com.page.locators;

import org.openqa.selenium.By;

public  interface  APMEnterpriseLocators {
    By APMHEADER = By.xpath("//span[text()='APM']");
    By APMSTATE_HEADER = By.xpath("//span[text()='APM State']");
    By ENTERPRISE_TAB = By.xpath("//span[contains(text(),'Enterprise')]");
    By INSTANCE_COLUMN = By.xpath("//div[text()='Instance ID']");
    By SEARCH_ICON = By.xpath("//i[@class='fas fa-search']");
    By TYPE_SEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By DROPDOWN_FEILDS=By.xpath("//div[contains(text(),'Free-text search for')]/following-sibling::div[2]/div[text()='Hostname']");
    By HOSTNAME_VALUE = By.xpath("(//span[text()='9f6619421afb'])[2]");
    By DRILLTHRUGH_FACT_PROCESSED = By.xpath("//span[text()='Facts Processed (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_FACT_PROCESSED = By.xpath("//h5[text()='Drillthrough on Facts Processed']");
    By DRILLTHRUGH_CPU = By.xpath("//span[text()='CPU Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_CPU = By.xpath("//h5[text()='Drillthrough on CPU Usage']");
    By DRILLTHRUGH_HEAP = By.xpath("//span[text()='Heap Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-search-plus']");
    By TITLE_DRILLTHRUGH_HEAP = By.xpath("//h5[text()='Drillthrough on Heap Usage']");
    By EXPORT_FACT_PROCESSED = By.xpath("//span[text()='Facts Processed (Auto)']/../../following-sibling::div/descendant::span//i[@class='fas fa-file-csv']");
    By EXPORT_CPU = By.xpath("//span[text()='CPU Usage (Auto)']/../../following-sibling::div/descendant::span/i[@class='fas fa-file-csv']");
    By EXPORT_HEAP = By.xpath("//span[text()='Heap Usage (Auto)']/../../following-sibling::div/descendant::span//i[@class='fas fa-file-csv']");
}
