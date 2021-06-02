package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.PortletLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class PortletsFeature extends SafeActions implements PortletLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();

    Random random = new Random();
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);
    String counterPortletName = "Counter Portlet - " + random.nextInt(1000);
    String appliedFilter = null;

    public PortletsFeature(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Adding Gauge Portlet")
    public void addingGaugePortlet() throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(GAUGE_HEADER,"Gauge header in Portlet Interface",MEDIUMWAIT);
        safeClick(GAUGE_HEADER,"Gauge header in Portlet Interface",MEDIUMWAIT);
        safeClick(DROPDOWN_KPI,"Clicking on KPI",MEDIUMWAIT);
        safeType(GAUGE_TEXTBOX_KPI,"User Click","Sending the text",VERYLONGWAIT);
        Thread.sleep(3000);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase("User Click"))
            {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(GAUGE_PORTLET_NAME, "Portlet Name field in Gauge portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del +gaugePortletName);
        safeClick(GAUGE_TEXTBOX_MEASURE,"Measure field",MEDIUMWAIT);
        safeType(GAUGE_TEXTBOX_MEASURE,"Count","Enter Measure",MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Count"))
            {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS,"Portlet filters field",MEDIUMWAIT);
        safeClick(PortletFilters_TypeSearch,"Entering Text into type search",MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS,"Selecting field",MEDIUMWAIT);
        driver.findElement(PortletFilters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER,"Changing to negation filter",MEDIUMWAIT);
        safeClick(BTN_APPLY,"Apply button in Portlet Filters",MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is "+driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET,"Add portlet button",MEDIUMWAIT);
    }

    @Step("Verifying Gauge Portlet in Dashboard page")
    public void verifyingGaugePortlet() throws InterruptedException{
        waitForPageToLoad();
        By GAUGE_PORTLET_TITLE= By.xpath("//span[@aria-label='"+gaugePortletName+"']");
        waitUntilClickable(GAUGE_PORTLET_TITLE,"Gauge Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(GAUGE_PORTLET_TITLE).isDisplayed())
            Assert.fail("Gauge portlet added is not displayed in Dashboard page");
        By FILTER_GAUGE_PORTLET = By.xpath("//span[@aria-label='"+gaugePortletName+"']/../following-sibling::span/i[contains(@class,'filter')]");
        if(!driver.findElement(FILTER_GAUGE_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Gauge Portlet");
        mouseHoverJScript(FILTER_GAUGE_PORTLET,"Filter icon","Filter icon in Gauge Portlet",MEDIUMWAIT);
        By FILTER_MESSAGE_GAUGE_PORTLET = By.xpath("//span[@aria-label='"+appliedFilter+"']");
        if(!driver.findElement(FILTER_MESSAGE_GAUGE_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Gauge portlet");
    }

    @Step("Adding Counter Portlet")
    public void addingCounterPortlet() throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(COUNTER_HEADER,"Counter header in Portlet Interface",MEDIUMWAIT);
        safeClick(COUNTER_HEADER,"Counter header in Portlet Interface",MEDIUMWAIT);
        safeClick(DROPDOWN_KPI,"Clicking on KPI",MEDIUMWAIT);
        safeType(COUNTER_TEXTBOX_KPI,dashBoardData.portletKPI,"Sending the text",VERYLONGWAIT);
        Thread.sleep(3000);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI))
            {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(COUNTER_PORTLET_NAME, "Portlet Name field in Counter portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del +counterPortletName);
        safeClick(COUNTER_TEXTBOX_MEASURE,"Measure field",MEDIUMWAIT);
        safeType(COUNTER_TEXTBOX_MEASURE,"Count","Enter Measure",MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Count"))
            {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS,"Portlet filters field",MEDIUMWAIT);
        safeClick(PortletFilters_TypeSearch,"Entering Text into type search",MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS,"Selecting field",MEDIUMWAIT);
        driver.findElement(PortletFilters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER,"Changing to negation filter",MEDIUMWAIT);
        safeClick(BTN_APPLY,"Apply button in Portlet Filters",MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is "+driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET,"Add portlet button",MEDIUMWAIT);
    }

    @Step("Verifying Counter Portlet in Dashboard page")
    public void verifyingCounterPortlet() {
        waitForPageToLoad();
        By COUNTER_PORTLET_TITLE= By.xpath("//span[@aria-label='"+counterPortletName+"']");
        waitUntilClickable(COUNTER_PORTLET_TITLE,"Counter Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(COUNTER_PORTLET_TITLE).isDisplayed())
            Assert.fail("Counter portlet added is not displayed in Dashboard page");
        By FILTER_COUNTER_PORTLET = By.xpath("//span[@aria-label='"+counterPortletName+"']/../following-sibling::span/i[contains(@class,'filter')]");
        if(!driver.findElement(FILTER_COUNTER_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Counter Portlet");
        mouseHoverJScript(FILTER_COUNTER_PORTLET,"Filter icon","Filter icon in Counter Portlet",MEDIUMWAIT);
        By FILTER_MESSAGE_COUNTER_PORTLET = By.xpath("//span[@aria-label='"+appliedFilter+"']");
        if(!driver.findElement(FILTER_MESSAGE_COUNTER_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Counter portlet");
        By KPI_COUNTER_PORTLET = By.xpath("//span[@aria-label='"+counterPortletName+"']/../../../following-sibling::div/div/div/span/span[contains(text(),'"+dashBoardData.portletKPI+"')]");
        waitUntilClickable(KPI_COUNTER_PORTLET,"",MEDIUMWAIT);
        if(!driver.findElement(KPI_COUNTER_PORTLET).isDisplayed())
            Assert.fail("KPI Name is not displayed in Counter portlet");

    }
}
