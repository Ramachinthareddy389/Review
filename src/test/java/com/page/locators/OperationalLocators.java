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
    By APPNAME_IN_DRILLTHROUGH = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text']/following-sibling::span/span");
    By KPI_TOOLTIP = By.xpath("//div[@class='MuiTooltip-tooltip MuiTooltip-tooltipPlacementTop']/div/div[2]/div");
    By COUNT_IN_PIVOT_DRILLTHRHPAGE = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a/div/div/div[3]/span/span");

}
