package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.InsightsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class InsightsPage extends SafeActions implements InsightsLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();

    public InsightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigate to Insights page")
    public void navigateToInsightsPage() {
        waitForPageToLoad();
        waitUntilClickable(INSIGHTS_PAGE_SIDE_MENU, "Insights Page in side menu", LONGWAIT);
        safeClick(INSIGHTS_PAGE_SIDE_MENU, "Insights Page in side menu", LONGWAIT);
        waitUntilClickable(INSIGHTS_PAGE_TITLE, "Insights page title", MEDIUMWAIT);
        if (!driver.findElement(INSIGHTS_PAGE_TITLE).isDisplayed())
            Assert.fail("Insights page is not displayed properly");
    }

    @Step("Navigate to Drillthrough page from Insights page")
    public void navigateToDrillthroughFromInsightsPage() {
        waitForPageToLoad();
        waitUntilClickable(DRILLTHROUGH_ICON_INSIGHTS_TREND, "Drillthrough icon in 'Trend' portlet in Insights Page", MEDIUMWAIT);
        safeClick(DRILLTHROUGH_ICON_INSIGHTS_TREND, "Drillthrough icon in 'Trend' portlet in Insights Page", MEDIUMWAIT);
    }

    @Step("Verify Drillthrough page after navigating from Insights page")
    public void verifyDrillthroughPageNavigatedFromInsightsPage() {
        waitForPageToLoad();
        waitUntilClickable(PAGE_TITLE, "Drillthrough Title", MEDIUMWAIT);
        System.out.println("Drillthrough Title is " + driver.findElement(PAGE_TITLE).getText());
        if (!driver.findElement(PAGE_TITLE).getText().contains(dashBoardData.trendPortlet_InsightsPage))
            Assert.fail("Drillthrough title is not displayed properly");
        if (!driver.findElement(BREADCRUMB_DRILLTHROUGH).getText().equalsIgnoreCase(dashBoardData.trendPortlet_InsightsPage))
            Assert.fail("Breadcrumb in Drillthrough page is not displayed properly");
    }

    @Step("Navigate to RCA/Pivot/Drillthrough page using '3 option' tooltip")
    public void navigationUsingTooltipOptions() {
        waitForPageToLoad();
        mouseHoverJScript(SUMMARY_TREND_PORTLET, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(RCA_TOOLTIP, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(SECOND_BREADCRUMB_FLOW, "", MEDIUMWAIT);
        String Tooltip1 = safeGetText(PAGE_TITLE, "Page title for RCA", MEDIUMWAIT);
        System.out.println(Tooltip1);
        Assert.assertEquals(Tooltip1, "RCA for Alert");
        safeClick(INSIGHTS_LINK_NAVIGATION_FLOW, "Dashboard Name Hyper link in Drillthrough Page", MEDIUMWAIT);
        mouseHoverJScript(SUMMARY_TREND_PORTLET, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(DRILLTHROUGH_TOOLTIP, "Drillthrough", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(SECOND_BREADCRUMB_FLOW, "", MEDIUMWAIT);
        String Tooltip2 = safeGetText(PAGE_TITLE, "Page title for Drillthrough", MEDIUMWAIT);
        System.out.println(Tooltip2);
        Assert.assertEquals(Tooltip2, "Drillthrough on " + dashBoardData.trendPortlet_InsightsPage);
        waitForPageToLoad();
        safeClick(INSIGHTS_LINK_NAVIGATION_FLOW, "Dashboard Name Hyper link in Drillthrough Page", MEDIUMWAIT);
        mouseHoverJScript(SUMMARY_TREND_PORTLET, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(PIVOT_TOOLTIP, "Pivot", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(SECOND_BREADCRUMB_FLOW, "", MEDIUMWAIT);
        String Tooltip3 = safeGetText(PAGE_TITLE, "Page title for pivot", MEDIUMWAIT);
        System.out.println(Tooltip3);
        Assert.assertEquals(Tooltip3, "Pivot on " + dashBoardData.trendPortlet_InsightsPage);
    }

    @Step("Verify Group By in Insights page")
    public void verifyGroupByInInsightsPage() {
        waitForPageToLoad();
        waitUntilClickable(GROUP_BY_LABEL, "Group By label", MEDIUMWAIT);
        for (int i = 0; i < dashBoardData.groupByOptions.length; i++) {
            By OPTION_GROUPBY = By.xpath("//button[contains(@value,'" + dashBoardData.groupByOptions[i] + "')]");
            waitUntilClickable(OPTION_GROUPBY, "Option in Group By", MEDIUMWAIT);
            safeClick(OPTION_GROUPBY, "Option in Group By", MEDIUMWAIT);
            String firstcolumn = driver.findElement(FIRST_COLUMN_GROUPBY).getText();
            String selectedGroupBy = driver.findElement(OPTION_GROUPBY).getAttribute("value");
            System.out.println("First column: " + firstcolumn + " Selected option: " + selectedGroupBy);
            if (!selectedGroupBy.contains(firstcolumn.toLowerCase()))
                Assert.fail("Column is not displayed as per Group By in Insights page");
        }
    }
}
