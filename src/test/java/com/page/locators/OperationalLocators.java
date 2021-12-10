package com.page.locators;

import org.openqa.selenium.By;

public interface OperationalLocators
{
    By BUTTON_OPERATIONAL = By.xpath("//span[text()='Operational']");
    By TRENDCHARTS =   By.cssSelector(".TrendChart>div>svg>defs~rect.highcharts-background");
    By ICONS_DRILLTHROUGH = By.xpath("//i[contains(@class,'fa-search-plus')]");
    By FILTERSKPISTEXTBOX = By.xpath("//input[@placeholder='Filter KPIs']");
    By KPINAMES = By.xpath("//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']/p");
    By ICONS_RAWINSTANCES = By.xpath("//div[@aria-label='Raw instances']");
    By ICONS_PIVOTINSTANCES = By.xpath("//div[@aria-label='Pivot on these instances']");
    By APP_NAMES = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div/span/span");
    By Title_DRILLTHROUGH = By.xpath("//nav[contains(@class,'MuiBreadcrumbs-root')]/following-sibling::div/div/h5");
    By APPNAME_IN_DRILLTHROUGH = By.xpath("//i[@class='fas fa-search-plus']/parent::span");
    By APPNAME_IN_PIVOT = By.xpath("//i[@class='fas fa-th-large']/parent::span");
    By KPI_TOOLTIP = By.xpath("//div[@class='MuiTooltip-tooltip MuiTooltip-tooltipPlacementTop']/div/div[2]/div");
    By COUNT_IN_PIVOT_DRILLTHRHPAGE = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[3]/span/span");
    By TAB_APP_COMPONENTS = By.xpath("//button[@value='appComponents']");
    By TAB_DATABASES = By.xpath("//button[@value='databases']");
    By TAB_ENVIRONMENTS = By.xpath("//button[@value='environments']");
    By TAB_HOSTS = By.xpath("//button[@value='servers']");
    By TAB_SERVICES = By.xpath("//button[@value='serviceProcs']");
    By TAB_BUSINESS_PROCESS = By.xpath("//button[@value='businessProcesses']");
    By TAB_USERS =By.xpath("//button[@value='users']");
    By TAB_TREND = By.xpath("//button[@value='TREND']");
    By TAB_SUMMARY = By.xpath("//button[@value='SUMMARY']");
    By TAB_LAST = By.xpath("//button[@value='LAST']");
    By NO_DATA_AVAILABLE = By.xpath("//div[contains(text(),'No data available')]");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");

}
