package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.PivotLocators;
import com.page.locators.PortletLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PivotPage extends SafeActions implements PivotLocators,PortletLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();

    public PivotPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to Pivot page from tooltip")
    public void navigateToPivotPage(){
        waitForPageToLoad();
        mouseHoverJScript(PORTLET_BAR,"Portlet Bar","Mouse Over on the portlet bar",MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_3,"Pivot",MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip3= safeGetText(Title_DRILLTHROUGH, "Page title for pivot", MEDIUMWAIT);
        System.out.println(Tooltip3);
        Assert.assertEquals(Tooltip3,dashBoardData.tooltip3);
    }

    @Step("Adding Table Portlet in Pivot page")
    public void addTablePortletInPivotPage(){
        safeClick(BTN_ADD_METRIC,"Add Metric button in Pivot Page",MEDIUMWAIT);
        waitUntilClickable(PORTELT_NAME_FIELD,"Portlet Name Field in Table Portlet",MEDIUMWAIT);
        safeClick(PORTELT_NAME_FIELD,"Portlet Name Field in Table Portlet",MEDIUMWAIT);
        safeType(PORTLET_NAME_FIELD_INPUT,dashBoardData.tablePortletName,"Portlet Name Data in Table Portlet",MEDIUMWAIT);
        waitUntilClickable(PIVOT_FIELD,"Pivot Field in Table Portlet",MEDIUMWAIT);
        safeClick(PIVOT_FIELD,"Pivot Field in Table Portlet",MEDIUMWAIT);
        String pivot = Keys.chord(dashBoardData.pivotFieldPivotPage)+Keys.ENTER;
        driver.findElement(PIVOT_FIELD_INPUT).sendKeys(pivot);
        safeClick(ORDER_BY_FIELD,"Order By Field in Table portlet",MEDIUMWAIT);
        safeClick(ORDER_BY_OPTION,"Order By Field option in Table portlet",MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_FIELD,"Order Direction Field in Table portlet",MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_OPTION,"Order Direction Field option in Table portlet",MEDIUMWAIT);
        System.out.println("Measure data is "+safeGetText(MEASURE_DATA_PORTLET,"Data in Measures field",MEDIUMWAIT));
        safeClick(ADD_PORTLET_PIVOT,"Add Portlet button",MEDIUMWAIT);
        By TABLE_PORTLET=By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]");
        scrollIntoElementView(TABLE_PORTLET,"Scroll down to added portlet");
        if(!driver.findElement(TABLE_PORTLET).isDisplayed())
            Assert.fail("Table portlet is not displayed in Pivot page");
    }

    @Step("Verifying table portlet in Pivot page")
    public void verifyTablePortletInPivotPage(){
        waitForPageToLoad();
        By TABLE_PORTLET=By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]");
        scrollIntoElementView(TABLE_PORTLET,"Scroll down to added portlet");
        if(!driver.findElement(TABLE_PORTLET).isDisplayed())
            Assert.fail("Table portlet is not displayed in Pivot page");
        By SLA_TABLE_PORTLET = By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]/../../../following-sibling::div/descendant::div[contains(@title,'By SLA')]");
        if (!driver.findElement(SLA_TABLE_PORTLET).isDisplayed())
            Assert.fail("SLA header is not displayed properly in Table portlet in Pivot page");
        By PIVOT_TABLE_PORTLET = By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]/../../../following-sibling::div/descendant::div[contains(@title,'"+dashBoardData.pivotFieldPivotPage+"')]");
        if (!driver.findElement(PIVOT_TABLE_PORTLET).isDisplayed())
            Assert.fail("Pivot header is not displayed properly in Table portlet in Pivot page");
        By FIRST_MEASURE_TABLE_PORTLET = By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]/../../../following-sibling::div/descendant::div[contains(@title,'Average Duration')]");
        if (!driver.findElement(FIRST_MEASURE_TABLE_PORTLET).isDisplayed())
            Assert.fail("First Measure header is not displayed properly in Table portlet in Pivot page");
        By SECOND_MEASURE_TABLE_PORTLET = By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]/../../../following-sibling::div/descendant::div[contains(@title,'Count')]");
        if (!driver.findElement(SECOND_MEASURE_TABLE_PORTLET).isDisplayed())
            Assert.fail("Second Measure header is not displayed properly in Table portlet in Pivot page");
    }

    @Step("Removing Table portlet in Pivot page")
    public void removeTablePortletInPivotPage(){
        By TABLE_PORTLET=By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]");
        By DELETE_TABLE_PORTLET = By.xpath("//span[contains(@aria-label,'"+dashBoardData.tablePortletName+"')]/../../../descendant::div[contains(@aria-label,'Close')]");
        safeClick(DELETE_TABLE_PORTLET,"Delete icon in Table portlet",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE_PORTLET,"Confirm button in delete popup",MEDIUMWAIT);
        try{
            waitForPageToLoad();
            if(driver.findElement(TABLE_PORTLET).isDisplayed())
                Assert.fail("Table portlet is not deleted in Pivot page");
        }catch (NoSuchElementException e){
            System.out.println("Table Portlet is removed successfully");
        }
    }

    @Step("Adding Chart Portlet in Pivot page")
    public void addChartPortletInPivotPage(){
        safeClick(BTN_ADD_METRIC,"Add Metric button in Pivot Page",MEDIUMWAIT);
        waitUntilClickable(CHART_TAB_PIVOT_PAGE,"Chart tab in Add window",MEDIUMWAIT);
        safeClick(CHART_TAB_PIVOT_PAGE,"Chart tab in Add window",MEDIUMWAIT);
        waitUntilClickable(CHART_PORTELT_NAME_FIELD,"Portlet Name Field in Chart Portlet",MEDIUMWAIT);
        safeClick(CHART_PORTELT_NAME_FIELD,"Portlet Name Field in Chart Portlet",MEDIUMWAIT);
        safeType(CHART_PORTLET_NAME_FIELD_INPUT,dashBoardData.chartPortletName,"Portlet Name Data in Chart Portlet",MEDIUMWAIT);
        waitUntilClickable(CHART_PIVOT_FIELD,"Pivot Field in Chart Portlet",MEDIUMWAIT);
        safeClick(CHART_PIVOT_FIELD,"Pivot Field in Chart Portlet",MEDIUMWAIT);
        String pivot = Keys.chord(dashBoardData.pivotFieldPivotPage)+Keys.ENTER;
        driver.findElement(CHART_PIVOT_FIELD_INPUT).sendKeys(pivot);
        waitUntilClickable(CHART_MEASURE_FIELD,"Measures Field in Chart Portlet",MEDIUMWAIT);
        safeClick(CHART_MEASURE_FIELD,"Measures Field in Chart Portlet",MEDIUMWAIT);
        String measure = Keys.chord(dashBoardData.measurePivotPortlet)+Keys.ENTER;
        driver.findElement(CHART_MEASURE_INPUT).sendKeys(measure);
        safeClick(CHART_TYPE_FIELD,"Chart Type field",MEDIUMWAIT);
        String chartType = Keys.chord(dashBoardData.chartType)+Keys.ENTER;
        driver.findElement(CHART_TYPE_INPUT).sendKeys(chartType);
//        safeClick(SHOW_CHART_LEGEND_CHECKBOX,"Show Chart Legend Checkbox",MEDIUMWAIT);
        safeClick(ADD_PORTLET_PIVOT,"Add Portlet button",MEDIUMWAIT);
        By CHART_PORTLET=By.xpath("//span[contains(@aria-label,'"+dashBoardData.chartPortletName+"')]");
        scrollIntoElementView(CHART_PORTLET,"Scroll down to added portlet");
        if(!driver.findElement(CHART_PORTLET).isDisplayed())
            Assert.fail("Chart portlet is not displayed in Pivot page");
    }

    @Step("Verifying Chart portlet in Pivot page")
    public void verifyChartPortletInPivotPage(){
        waitForPageToLoad();
        By CHART_PORTLET=By.xpath("//span[contains(@aria-label,'"+dashBoardData.chartPortletName+"')]");
        scrollIntoElementView(CHART_PORTLET,"Scroll down to added portlet");
        if(!driver.findElement(CHART_PORTLET).isDisplayed())
            Assert.fail("Chart portlet is not displayed in Pivot page");
        By MEASURE_LEGEND_CHART = By.xpath("//span[contains(@aria-label,'"+dashBoardData.chartPortletName+"')]/../../../../../descendant::*[local-name()='tspan' and contains(text(),'"+dashBoardData.measurePivotPortlet+"')]");
        if(!driver.findElement(MEASURE_LEGEND_CHART).isDisplayed())
            Assert.fail("Measure is not displayed in Legend in Chart portlet");
    }
    @Step("Removing Chart portlet in Pivot page")
    public void removeChartPortletInPivotPage(){
        By CHART_PORTLET=By.xpath("//span[contains(@aria-label,'"+dashBoardData.chartPortletName+"')]");
        By DELETE_CHART_PORTLET = By.xpath("//span[contains(@aria-label,'"+dashBoardData.chartPortletName+"')]/../../../descendant::div[contains(@aria-label,'Close')]");
        safeClick(DELETE_CHART_PORTLET,"Delete icon in Chart portlet",MEDIUMWAIT);
        safeClick(CONFIRM_DELETE_PORTLET,"Confirm button in delete popup",MEDIUMWAIT);
        try{
            waitForPageToLoad();
            if(driver.findElement(CHART_PORTLET).isDisplayed())
                Assert.fail("Chart portlet is not deleted in Pivot page");
        }catch (NoSuchElementException e){
            System.out.println("Chart Portlet is removed successfully");
        }
    }

}
