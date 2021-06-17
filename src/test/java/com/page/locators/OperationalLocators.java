package com.page.locators;

import org.openqa.selenium.By;

public interface OperationalLocators
{
    By BUTTON_OPERATIONAL = By.xpath("//span[text()='Operational']");
    By TRENDCHARTS =   By.cssSelector(".TrendChart>div>svg>defs~rect.highcharts-background");
    By ICONS_DRILLTHROUGH = By.xpath("//i[contains(@class,'fa-search-plus')]");
    By ICONS_RAWINSTANCES=By.xpath("//div[@aria-label='Raw instances']");
}
