package com.page.locators;

import org.openqa.selenium.By;

public interface InsightsLocators {
    By INSIGHTS_PAGE_SIDE_MENU = By.xpath("//span[contains(@title,'Insights')]");
    By DRILLTHROUGH_ICON_INSIGHTS_TREND = By.xpath("//span[contains(@aria-label,'Trend')]/../../following-sibling::div/div[contains(@aria-label,'Drillthrough')]");
    By PAGE_TITLE = By.xpath("//h5");
    By BREADCRUMB_DRILLTHROUGH = By.xpath("//nav[contains(@aria-label,'breadcrumb')]/descendant::span[2]");
    By SUMMARY_TREND_PORTLET = By.xpath("//div[contains(text(),'Alert')]");
    By RCA_TOOLTIP = By.xpath("//a[text()='View the worst (RCA)']");
    By DRILLTHROUGH_TOOLTIP = By.xpath("//a[contains(text(),'Raw')]");
    By PIVOT_TOOLTIP = By.xpath("//a[contains(text(),'Pivot')]");
    By INSIGHTS_LINK_NAVIGATION_FLOW = By.xpath("//a[contains(@class,'MuiLink-root')]/span");
    By SECOND_BREADCRUMB_FLOW = By.xpath("//nav[contains(@aria-label,'breadcrumb')]/descendant::span[2]");
}
