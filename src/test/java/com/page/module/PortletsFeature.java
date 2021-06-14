package com.page.module;

import com.datamanager.ConfigManager;
import com.opencsv.CSVReader;
import com.page.data.DashBoardData;
import com.page.locators.PortletLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.util.*;

public class PortletsFeature extends SafeActions implements PortletLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();

    Random random = new Random();
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);
    String counterPortletName = "Counter Portlet - " + random.nextInt(1000);
    String appliedFilter = null;
    String file_name;
    String downloadPath;
    By Filters_TypeSearch = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/div/div/input[@placeholder='Type or select below']");
    String appliedKPIFilter = null;
    //String nTabularPortletName = "N Tabular Portlet - " + random.nextInt(1000);
    //String tabularPortletName = "Tabular Portlet - " + random.nextInt(1000);
    //String flowPortletName = "Flow Portlet - " +random.nextInt(1000);
   // String mapPortletName = "Map Portlet - " + random.nextInt(1000);

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
        waitUntilClickable(GAUGE_HEADER, "Gauge header in Portlet Interface", MEDIUMWAIT);
        safeClick(GAUGE_HEADER, "Gauge header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeType(GAUGE_TEXTBOX_KPI, "User Click", "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase("User Click")) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(GAUGE_PORTLET_NAME, "Portlet Name field in Gauge portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + gaugePortletName);
        safeClick(GAUGE_TEXTBOX_MEASURE, "Measure field", MEDIUMWAIT);
        safeType(GAUGE_TEXTBOX_MEASURE, "Count", "Enter Measure", MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Count")) {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(PortletFilters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Gauge Portlet in Dashboard page")
    public void verifyingGaugePortlet() throws InterruptedException {
        waitForPageToLoad();
        By GAUGE_PORTLET_TITLE = By.xpath("//span[@aria-label='" + gaugePortletName + "']");
        waitUntilClickable(GAUGE_PORTLET_TITLE, "Gauge Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(GAUGE_PORTLET_TITLE).isDisplayed())
            Assert.fail("Gauge portlet added is not displayed in Dashboard page");
        By FILTER_GAUGE_PORTLET = By.xpath("//span[@aria-label='" + gaugePortletName + "']/../following-sibling::span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_GAUGE_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Gauge Portlet");
        mouseHoverJScript(FILTER_GAUGE_PORTLET, "Filter icon", "Filter icon in Gauge Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_GAUGE_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        if (!driver.findElement(FILTER_MESSAGE_GAUGE_PORTLET).isDisplayed())
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
        waitUntilClickable(COUNTER_HEADER, "Counter header in Portlet Interface", MEDIUMWAIT);
        safeClick(COUNTER_HEADER, "Counter header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeType(COUNTER_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(COUNTER_PORTLET_NAME, "Portlet Name field in Counter portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + counterPortletName);
        safeClick(COUNTER_TEXTBOX_MEASURE, "Measure field", MEDIUMWAIT);
        safeType(COUNTER_TEXTBOX_MEASURE, "Count", "Enter Measure", MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Count")) {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(PortletFilters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Counter Portlet in Dashboard page")
    public void verifyingCounterPortlet() {
        waitForPageToLoad();
        By COUNTER_PORTLET_TITLE = By.xpath("//span[@aria-label='" + counterPortletName + "']");
        waitUntilClickable(COUNTER_PORTLET_TITLE, "Counter Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(COUNTER_PORTLET_TITLE).isDisplayed())
            Assert.fail("Counter portlet added is not displayed in Dashboard page");
        By FILTER_COUNTER_PORTLET = By.xpath("//span[@aria-label='" + counterPortletName + "']/../following-sibling::span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_COUNTER_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Counter Portlet");
        mouseHoverJScript(FILTER_COUNTER_PORTLET, "Filter icon", "Filter icon in Counter Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_COUNTER_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        if (!driver.findElement(FILTER_MESSAGE_COUNTER_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Counter portlet");
        try {
            waitForSecs(5);
            if (driver.findElement(COUNTER_PORTLET_CHART).isDisplayed()) {
                By KPI_COUNTER_PORTLET = By.xpath("//span[@aria-label='" + counterPortletName + "']/../../../following-sibling::div/div/div/span/span[contains(text(),'" + dashBoardData.portletKPI + "')]");
                waitUntilClickable(KPI_COUNTER_PORTLET, "", MEDIUMWAIT);
                if (!driver.findElement(KPI_COUNTER_PORTLET).isDisplayed())
                    Assert.fail("KPI Name is not displayed in Counter portlet");
            }
        } catch (Exception e) {
            if (!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in Counter portlet");
            System.out.println("Data is not available in Counter Portlet");
        }
    }

    @Step("Adding Portlet from search bar in Dashboard page")
    public void addingPortletFromSearchBar() throws InterruptedException {
        Thread.sleep(15000);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(SEARCH_BAR_ADD_METRIC, "Search bar in Add Metric Window", MEDIUMWAIT);
        safeClick(SEARCH_BAR_ADD_METRIC, "Search bar in Add Metric Window", MEDIUMWAIT);
        driver.findElement(SEARCH_BAR_ADD_METRIC).sendKeys(dashBoardData.portletQuery, Keys.ENTER, Keys.ENTER);
    }

    @Step("Verifying portlet added from search bar")
    public void verifyingPortletAddedFromSearchBar() {
        waitForPageToLoad();
        By PORTLET_TITLE = By.xpath("//span[@aria-label='" + dashBoardData.portletQuery + "']");
        waitUntilClickable(PORTLET_TITLE, "Counter Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(PORTLET_TITLE).isDisplayed())
            Assert.fail("Counter portlet added is not displayed in Dashboard page");
    }


    @Step("Verifying portlet added from search bar")
    public void navigatingToDrillThroughPage() {
        waitForPageToLoad();
        safeClick(BTN_DRILLTHROUGH, "Drillthrough button", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dashBoardData.drillthrghpage);

    }

    @Step("Cloning Portlet in Dashboard page")
    public void cloningPortletInDashboardPage() {
        waitForPageToLoad();
        safeClick(BTN_CLONE_PORTLET, "Clone Portlet icon", MEDIUMWAIT);
        waitUntilClickable(DASHBOARD_FIELD_CLONE_PORTLET, "Dashboard Field in Clone Portlet window", MEDIUMWAIT);
        safeClick(DASHBOARD_FIELD_CLONE_PORTLET, "Dashboard Field in Clone Portlet window", MEDIUMWAIT);
        waitUntilClickable(DROPDOWN_DASHBOARDS, "Dropdown list of Dashboards", MEDIUMWAIT);
        String clonedPortlet = Keys.chord(dashBoardData.DB_clonedPortlet) + Keys.ENTER;
        driver.findElement(DASHBOARD_OPTION_CLONE_PORTLET).sendKeys(clonedPortlet);
        safeClick(BTN_CLONE_PORTLET_WINDOW, "Clone button in Clone Portlet window", MEDIUMWAIT);
        waitUntilElementDisappears(DASHBOARD_FIELD_CLONE_PORTLET, "Dashboard Field in Clone Portlet window", LONGWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section", MEDIUMWAIT);
    }

    @Step("Verifying Cloned portlet in Dashboard page")
    public void verifyingClonedPortlet() {
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dashBoardData.DB_clonedPortlet + "\n", "Search box in Dashboards Overview page", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        By CLONED_PORTLET_DASHBOARD = By.xpath("//span[contains(@aria-label,'" + dashBoardData.portletQuery + "')]");
        waitUntilClickable(CLONED_PORTLET_DASHBOARD, "Cloned portlet in Dashboard page", MEDIUMWAIT);
        if (!driver.findElement(CLONED_PORTLET_DASHBOARD).isDisplayed())
            Assert.fail("Cloned Portlet is not displayed in Dashboard page");
        By REMOVE_CLONED_PORTLET = By.xpath("//span[contains(@aria-label,'" + dashBoardData.portletQuery + "')]/../../following-sibling::div/div[contains(@aria-label,'Close')]");
        safeClick(REMOVE_CLONED_PORTLET, "Remove icon of Cloned Portlet", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE_PORTLET, "Confirm button in Delete popup", MEDIUMWAIT);
        try {
            if (driver.findElement(CLONED_PORTLET_DASHBOARD).isDisplayed())
                Assert.fail("Cloned Portlet is not removed in Dashboard page");
        } catch (NoSuchElementException e) {
            System.out.println("Cloned portlet is not displayed after removing, as expected");
        }
    }

    @Step("Adding General Health portlet")
    public void addingPortlet(String dname1) throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitUntilClickable(BTN_ADD_METRIC, "Waiting for an Add metric icon");
        safeClick(BTN_ADD_METRIC, "Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Waiting for an Add metric link");
        safeClick(LINK_ADD_METRIC, "Add metric link");
        safeClick(DROPDWON_KPI, "KPI Label", MEDIUMWAIT);
        safeType(TEXTBOX_KPI, "User Click", "Sending the text", VERYLONGWAIT);
        waitForSecs(7);
        List<WebElement> kpi12 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpi12.size(); i++) {
            System.out.println(kpi12.get(i).getText());
            if (kpi12.get(i).getText().equals("User Click")) {
                kpi12.get(i).click();
                break;
            }
        }
        safeClick(TEXT_HEADER, "Portlet Name");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + dname1);
        WebElement rle = driver.findElement(By.xpath("//*[text()='Show As']/../../../div//div[contains(@class,'body1')]"));
        safeClick(DROPDOWN_SHOWAS, "ShowAs Dropdown", MEDIUMWAIT);
        safeType(TEXTBOX_SHOWAS, "Trend Chart", "Chart from show as dropdown", MEDIUMWAIT);
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
        for (int i = 0; i < kpi1.size(); i++) {

            if (kpi1.get(i).getText().contains("Color Distribution - Trend Chart")) {

                kpi1.get(i).click();
                break;
            }
        }

        safeClick(TEXTBOX_SUMMARY, "KPI", MEDIUMWAIT);
        safeType(TEXTBOX_SUMMARY, "Avg Color", "Summary", MEDIUMWAIT);
        safeClick(DROPDOWN_CHARTTYPE, "Chart type", MEDIUMWAIT);
        Actions a = new Actions(driver);
        a.sendKeys("area");
        List<WebElement> Charts = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f Charts:::====> " + Charts.size());
        for (int i = 0; i < Charts.size(); i++) {

            if (Charts.get(i).getText().contains("Area")) {

                Charts.get(i).click();
                break;
            }
        }
        safeClick(DROPDWON_TRENDGRATY, "Trend granularity", MEDIUMWAIT);
        safeType(TEXTBOX_TRENDGRATY, "By Minute", " Trend granularity", MEDIUMWAIT);
        List<WebElement> tdList = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f tdlist:::====> " + tdList.size());
        for (int i = 0; i < tdList.size(); i++) {

            if (tdList.get(i).getText().contains("By Minute")) {

                tdList.get(i).click();
                break;
            }
        }
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        searchField1.sendKeys(del + 5);
        waitForSecs(10);
        safeClick(BTN_ADD_PORTLET, "Add Portlet", MEDIUMWAIT);
    }


    @Step("Verifying GHPortlet")
    public void VerifyingGHPortlet(String dname1) {
        waitForSecs(15);
        waitUntilClickable(All_FOLDER, "Add metric link");
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForSecs(5);
        safeType(TEXTBOX_TYPESEARCH, dname1, "Dashboard Name in textbox", VERYLONGWAIT);
        WebElement type = driver.findElement(TEXTBOX_TYPESEARCH);
        type.sendKeys(Keys.ENTER);
        waitForSecs(10);
        mouseHoverJScript(LIST_PORTLETS, "text", "mouse", MEDIUMWAIT);
        String text = safeGetText(LIST_PORTLETS, "List of Portlets", MEDIUMWAIT);
        Assert.assertEquals(text, dname1);
    }


    @Step("Adding N Tabular Portlet")
    public void addingNTabularPortlet(String nTabularPortletName) throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(NTABULAR_HEADER, "N Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(NTABULAR_HEADER, "N Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeType(NTABULAR_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        waitForSecs(2);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(NTABULAR_PORTLET_NAME, "Portlet Name field in N Tabular portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + nTabularPortletName);
        safeClick(DROPDWON_TRENDGRATY, "Clicking on Trend granulaity", MEDIUMWAIT);
        safeType(TEXTBOX_TRENDGRATY, dashBoardData.nTabularPortletTrendGranularity, "Entering text into trendgranularity", MEDIUMWAIT);
        List<WebElement> trend = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + trend.size());
        for (int i = 0; i < trend.size(); i++) {
            if (trend.get(i).getText().contains(dashBoardData.nTabularPortletTrendGranularity)) {
                trend.get(i).click();
                break;
            }
        }
        safeClick(NTABULAR_TALLY_COLUMN, "", MEDIUMWAIT);
        safeType(NTABULAR_TALLY_COLUMN_OPTION, "Total", "", MEDIUMWAIT);
        List<WebElement> tally = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f tally options:::====> " + tally.size());
        for (int i = 0; i < tally.size(); i++) {
            if (tally.get(i).getText().contains("Total")) {
                tally.get(i).click();
                break;
            }
        }
        safeClick(NTABULAR_TEXTBOX_MEASURE, "Measure field", MEDIUMWAIT);
        safeType(NTABULAR_TEXTBOX_MEASURE, dashBoardData.portletMeasureData, "Enter Measure", MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase(dashBoardData.portletMeasureData)) {
                measures.get(i).click();
                break;
            }
        }
        safeClick(TEXTBOX_KPI_FILTERS, "KPI filters field", MEDIUMWAIT);
        safeClick(Filters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(Filters_TypeSearch, "Application Name", "Enter Text in KPI Filters field");
        safeClick(KPI_FILTER_OPTION, "Selecting field", MEDIUMWAIT);
        driver.findElement(Filters_TypeSearch).sendKeys(Keys.ENTER);
        appliedKPIFilter = driver.findElement(TEXTBOX_KPI_FILTERS).getAttribute("value");
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        safeClick(NTABULAR_LABEL_FIELD, "Label Field", MEDIUMWAIT);
        safeType(NTABULAR_LABEL_FIELD_TEXTBOX, dashBoardData.nTabularPortletLabel, "Label Field", MEDIUMWAIT);
        safeClick(ORDER_BY_FIELD, "Order By Field in N Tabular portlet", MEDIUMWAIT);
        safeClick(NTABULAR_ORDER_BY_OPTION, "Order By Field option in N Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_FIELD, "Order Direction Field in N Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_OPTION, "Order Direction Field option in N Tabular portlet", MEDIUMWAIT);
        safeClick(NTABULAR_SHOW_KPI_NAME_CHECKBOX, "Show KPI Name checkbox", MEDIUMWAIT);
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeClick(Filters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(Filters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(Filters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying N Tabular Portlet in Dashboard page")
    public void verifyingNTabularPortlet(String nTabularPortletName) throws InterruptedException {
        waitForPageToLoad();
        By NTABULAR_PORTLET_TITLE = By.xpath("//span[@aria-label='" + nTabularPortletName + "']");
        waitUntilClickable(NTABULAR_PORTLET_TITLE, "N Tabular Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(NTABULAR_PORTLET_TITLE).isDisplayed())
            Assert.fail("N Tabular portlet added is not displayed in Dashboard page");
        By FILTER_NTABULAR_PORTLET = By.xpath("//span[@aria-label='" + nTabularPortletName + "']/../following-sibling::span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_NTABULAR_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for N Tabular Portlet");
        mouseHoverJScript(FILTER_NTABULAR_PORTLET, "Filter icon", "Filter icon in N Tabular Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_NTABULAR_PORTLET = By.xpath("//span[contains(@aria-label,'" + appliedFilter + "')]");
        if (!driver.findElement(FILTER_MESSAGE_NTABULAR_PORTLET).isDisplayed())
            Assert.fail("Portlet Filter Message is not displayed properly in N Tabular portlet");
        By KPI_FILTER_MESSAGE_NTABULAR_PORTLET = By.xpath("//span[contains(@aria-label,'" + appliedKPIFilter + "')]");
        if (!driver.findElement(KPI_FILTER_MESSAGE_NTABULAR_PORTLET).isDisplayed())
            Assert.fail("KPI Filter Message is not displayed properly in N Tabular portlet");
        try {
            waitForSecs(5);
            if (driver.findElement(NTABULAR_PORTLET_CHART).isDisplayed()) {
                By TREND_GRAN_NTABULAR = By.xpath("//div[contains(@title,'" + dashBoardData.nTabularPortletTrendGranularity + "')]");
                if (!driver.findElement(TREND_GRAN_NTABULAR).isDisplayed())
                    Assert.fail("Applied Trend Granularity is not displayed properly in N Tabular portlet");
                By LABEL_NTABULAR_PORTLET = By.xpath("//span[contains(text(),'" + dashBoardData.nTabularPortletLabel + "')]");
                if (!driver.findElement(LABEL_NTABULAR_PORTLET).isDisplayed())
                    Assert.fail("Label is not displayed properly in N Tabular portlet");
            }
        } catch (Exception e) {
            if (!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in N Tabular portlet");
            System.out.println("Data is not available in N Tabular Portlet");
        }

    }


    @Step("Navigate to RCA/Pivot/Drillthrough page using '3 option' tooltip")
    public void navigatingToDrilthroughPagesUsingTooltipOptions() {
        waitForPageToLoad();
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_1, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip1 = safeGetText(Title_DRILLTHROUGH, "Drill through page title for RCA", MEDIUMWAIT);
        System.out.println(Tooltip1);
        Assert.assertEquals(Tooltip1, dashBoardData.tooltip1);
        safeClick(HYPERLINKDBINDRILLTHROUGH, "Dashboard Name Hyper link in Drillthrough Page", MEDIUMWAIT);
        waitForSecs(5);
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_2, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip2 = safeGetText(Title_DRILLTHROUGH, "Drill through page title for Raw instances", MEDIUMWAIT);
        System.out.println(Tooltip2);
        Assert.assertEquals(Tooltip2, dashBoardData.tooltip2);
        waitForPageToLoad();
        safeClick(HYPERLINKDBINDRILLTHROUGH, "Dashboard Name Hyper link in Drillthrough Page", MEDIUMWAIT);
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_3, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip3 = safeGetText(Title_DRILLTHROUGH, "Drill through page title for pivot instances", MEDIUMWAIT);
        System.out.println(Tooltip3);
        Assert.assertEquals(Tooltip3, dashBoardData.tooltip3);

    }

    @Step("Adding Tabular Portlet")
    public void addingTabularPortlet() throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(TABULAR_HEADER, "Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(TABULAR_HEADER, "Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeType(TABULAR_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        waitForSecs(2);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(TABULAR_MEASURES_FIELD, "Pivots Field", MEDIUMWAIT);
        String measureData = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        driver.findElement(TABULAR_MEASURES_FIELD_INPUT).sendKeys(measureData + dashBoardData.portletMeasureData, Keys.ENTER);
        safeClick(TABULAR_PIVOT_FIELD, "Pivots Field", MEDIUMWAIT);
        String pivotdata = Keys.chord(dashBoardData.tabularPortletPivotData) + Keys.ENTER;
        driver.findElement(TABULAR_PIVOT_FIELD_INPUT).sendKeys(pivotdata);
        safeClick(ORDER_BY_FIELD, "Order By Field in Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_BY_OPTION, "Order By Field option in Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_FIELD, "Order Direction Field in Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_OPTION, "Order Direction Field option in Tabular portlet", MEDIUMWAIT);
    }

    @Step("adding Tabular portlet1")
    public void addingtabularPortlet1(String tabularPortletName) {
        safeClick(SHOW_SLA_COLUMN_CHECKBOX, "Show SLA column checkbox", MEDIUMWAIT);
        safeClick(TABULAR_PORTLET_NAME, "Portlet Name field in Tabular portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + tabularPortletName);
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeClick(Filters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(Filters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(Filters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Tabular Portlet in Dashboard page")
    public void verifyingTabularPortlet(String tabularPortletName) throws InterruptedException {
        waitForPageToLoad();
        By TABULAR_PORTLET_TITLE = By.xpath("//span[@aria-label='" + tabularPortletName + "']");
        waitUntilClickable(TABULAR_PORTLET_TITLE, "Tabular Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(TABULAR_PORTLET_TITLE).isDisplayed())
            Assert.fail("Tabular portlet added is not displayed in Dashboard page");
        By FILTER_TABULAR_PORTLET = By.xpath("//span[@aria-label='" + tabularPortletName + "']/../following-sibling::span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_TABULAR_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Tabular Portlet");
        mouseHoverJScript(FILTER_TABULAR_PORTLET, "Filter icon", "Filter icon in Tabular Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_TABULAR_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        if (!driver.findElement(FILTER_MESSAGE_TABULAR_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Tabular portlet");
        try {
            By PIVOT_HEADER_PORTLET = By.xpath("//div[@aria-label='" + dashBoardData.tabularPortletPivotData + "']");
            waitForSecs(5);
            if (!driver.findElement(PIVOT_HEADER_PORTLET).isDisplayed())
                Assert.fail("Pivot Field is not displayed properly in Tabular portlet");
            By MEASURE_HEADER_PORTLET = By.xpath("//div[@title='" + dashBoardData.portletMeasureData + "']");
            if (!driver.findElement(MEASURE_HEADER_PORTLET).isDisplayed())
                Assert.fail("Measure field is not displayed properly in Tabular portlet");
        } catch (Exception e) {
            if (!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in Tabular portlet");
            System.out.println("Data is not available in Tabular Portlet");
        }
    }


    public void downloadedpath(){
        waitForSecs(7);
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(7);
        //String downloadPath = "C:\\Users\\rama.chinthareddy\\Downloads";
        String home = System.getProperty("user.home");
        downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);

    }

    @Step("Export GH Portlet")
    public void validatingExportedGHPortlet(String file_name,String[] expected) throws IOException {

        downloadedpath();
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        System.out.println(file_name);
        Assert.assertTrue(fileName.equals(file_name));
        for(int j=0; j<expected.length;j++){
            System.out.println("Values are "+expected[j]);
        }
        Reader reader = new FileReader(downloadPath + "\\" + fileName);
        CSVReader csvreader = new CSVReader(reader);
        List<String[]> list = csvreader.readAll();
        Iterator<String[]> ite = list.iterator();
        String[] data = ite.next();
        for (int i = 0; i < 7; i++) {
            String actualText = data[i];
            Assert.assertEquals(actualText, expected[i]);
            if (actualText.equals(expected[i])) {
                System.out.println(expected[i]);
                System.out.println("passed on: " + actualText);
            } else {
                System.out.println("failed on: " + actualText);
            }
        }
        reader.close();
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }


    private File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    @Step("Verify hover message in filter icon in Analysis portlet in Tabular portlet")
    public void verifyinghovermessageinfiltericoninAnalysisportletinTabularportlet(String tabularPortletName) {
        safeClick(TABULAR_PORTLET_NAME, "Portlet Name field in Tabular portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + tabularPortletName);
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeClick(Filters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(Filters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(Filters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
        waitForSecs(5);
        mouseHoverJScript(SLACOLUMNS, "", "first sla", MEDIUMWAIT);
        safeClick(SLAFILTERICON, "Filter ICON", MEDIUMWAIT);
        String filtervalue = getAttributeValue(SLAFILTERICON, "aria-label", "Tooltip", MEDIUMWAIT);
        System.out.println(filtervalue);
        String usrColum = safeGetText(USERNAME_COLUMN_PORTLET, "UserName column value", MEDIUMWAIT);
        System.out.println(usrColum);
        String usercolumText = "user.name == " + usrColum;
        System.out.println(usercolumText);
        Assert.assertEquals(filtervalue, usercolumText);
    }

    @Step("Adding Flow Portlet")
    public void addingFlowPortlet(String flowPortletName) throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(FLOW_HEADER,"Flow header in Portlet Interface",MEDIUMWAIT);
        safeClick(FLOW_HEADER,"Flow header in Portlet Interface",MEDIUMWAIT);
        safeClick(DROPDOWN_KPI,"Clicking on KPI",MEDIUMWAIT);
        safeType(FLOW_TEXTBOX_KPI,dashBoardData.portletKPI,"Sending the text",VERYLONGWAIT);
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
        safeClick(FLOW_PORTLET_NAME, "Portlet Name field in Flow portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del +flowPortletName);
        safeClick(FLOW_COLUMN_LABEL,"Column Label Field",MEDIUMWAIT);
        String deleteColumnLabelData = Keys.chord(Keys.CONTROL,"a") +Keys.DELETE;
        driver.findElement(FLOW_COLUMN_LABEL_INPUT).sendKeys(deleteColumnLabelData,dashBoardData.flowPortletColumnLabel);
        safeClick(FLOW_CLUSTER_BY_LABEL,"Cluster By Field",MEDIUMWAIT);
        String clusterdata = Keys.chord("Color") + Keys.ENTER;
        driver.findElement(FLOW_CLUSTER_BY_INPUT).sendKeys(clusterdata);
        safeClick(FLOW_SHOW_USERS_CHECKBOX,"Show Users checkbox",MEDIUMWAIT);
        safeClick(TEXTBOX_PORTLET_FILTERS,"Portlet filters field",MEDIUMWAIT);
        safeClick(Filters_TypeSearch,"Entering Text into type search",MEDIUMWAIT);
        safeType(Filters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS,"Selecting field",MEDIUMWAIT);
        driver.findElement(Filters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER,"Changing to negation filter",MEDIUMWAIT);
        safeClick(BTN_APPLY,"Apply button in Portlet Filters",MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is "+driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(FLOW_FILTER_VALUE_LABEL,"",MEDIUMWAIT);
        safeType(FLOW_FILTER_VALUE,"Sample","Filter value field input",MEDIUMWAIT);
        safeClick(FLOW_FILTER_POSITION_LABEL,"Filter Position Field",MEDIUMWAIT);
        safeClick(FLOW_FILTER_POSITION,"Filter Position Dropdown Option",MEDIUMWAIT);
        safeClick(BTN_ADD_PORTLET,"Add portlet button",MEDIUMWAIT);
    }
    @Step("Verifying Flow Portlet in Dashboard page")
    public void verifyingFlowPortlet(String flowPortletName) throws InterruptedException{
        waitForPageToLoad();
        By FLOW_PORTLET_TITLE= By.xpath("//span[@aria-label='"+flowPortletName+"']");
        waitUntilClickable(FLOW_PORTLET_TITLE,"Flow Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(FLOW_PORTLET_TITLE).isDisplayed())
            Assert.fail("Flow portlet added is not displayed in Dashboard page");
        By FILTER_FLOW_PORTLET = By.xpath("//span[@aria-label='"+flowPortletName+"']/../following-sibling::span/i[contains(@class,'filter')]");
        if(!driver.findElement(FILTER_FLOW_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Flow Portlet");
        mouseHoverJScript(FILTER_FLOW_PORTLET,"Filter icon","Filter icon in Flow Portlet",MEDIUMWAIT);
        By FILTER_MESSAGE_FLOW_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        if (!driver.findElement(FILTER_MESSAGE_FLOW_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Flow portlet");
        try {
            waitForSecs(5);
            if (driver.findElement(FLOW_PORTLET_GRAPH).isDisplayed()) {
                safeClick(BTN_MAXIMIZE_PORTLET, "Maximise portlet button", MEDIUMWAIT);
                By COLUMN_LABEL = By.xpath("//span[@title='" + dashBoardData.flowPortletColumnLabel + "']");
                waitUntilClickable(COLUMN_LABEL, "Column label Field", MEDIUMWAIT);
                if (!driver.findElement(COLUMN_LABEL).isDisplayed())
                    Assert.fail("Column Label is not displayed properly in Flow portlet");
            }
        }
        catch(Exception e){
            if(!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in flow portlet");
            System.out.println("Data is not available in Flow Portlet");
        }
    }

    @Step("Export Tabular portlet")
    public void validatingExportedATabularPortlet(String tabularPortletName) throws IOException {

        waitForSecs(10);
        List<WebElement> list = driver.findElements(TABLEDATA);
        for (int i = 1; i < list.size(); i++) {
            String data = list.get(i).getText();
            System.out.println("Table Data   :" +data);
        }

        waitForSecs(7);
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
        //String downloadPath = "C:\\Users\\rama.chinthareddy\\Downloads";
        String home = System.getProperty("user.home");
        String file_name = tabularPortletName + ".csv";
        System.out.println(file_name);
        String downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        Assert.assertTrue(fileName.equals(file_name));
        Reader reader = new FileReader(downloadPath + "\\" + fileName);
        CSVReader csvreader = new CSVReader(reader);
        String[] cell;
        String s = "";
        while ((cell = csvreader.readNext()) != null)
        {
            int i = 0;
            s = s + cell[i] + ":";
           // String emails = cell[i + 1];
            //String message = cell[i + 2];

        }

        String[] labels = s.split(":");
        Arrays.sort(labels);
        Arrays.toString(labels);
        for(int i=1;i<labels.length-1;i++){
            if(labels[i+1].equals(list.get(i).getText()))
            {
                System.out.println("Exported CSV values  :"+labels[i+1] + "  Table Column Values:"+list.get(i).getText());
                Assert.assertEquals(labels[i+1],list.get(i).getText());
            }
        }
        reader.close();
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }


    @Step("Adding Map Portlet")
    public void addingMapPortlet(String mapPortletName) throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(MAP_HEADER,"Map header in Portlet Interface",MEDIUMWAIT);
        safeClick(MAP_HEADER,"Map header in Portlet Interface",MEDIUMWAIT);
        safeClick(DROPDOWN_KPI,"Clicking on KPI",MEDIUMWAIT);
        safeType(MAP_TEXTBOX_KPI,dashBoardData.portletKPI,"Sending the text",VERYLONGWAIT);
        Thread.sleep(1000);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI))
            {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(MAP_PORTLET_NAME, "Portlet Name field in Map portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del +mapPortletName);
        safeClick(MAP_LOCATION_FOR_LABEL,"Location field",MEDIUMWAIT);
        Thread.sleep(2000);
        safeClick(MAP_LOCATION_FOR,"Location field",MEDIUMWAIT);
        Actions action1 = new Actions(driver);
        action1.sendKeys("System");
        Thread.sleep(2000);
        List<WebElement> locations = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < locations.size(); i++) {
            System.out.println(locations.get(i).getText());
            if (locations.get(i).getText().equalsIgnoreCase("System"))
            {
                locations.get(i).click();
                break;
            }
        }
        safeClick(MAP_LEVEL_DROPDOWN,"Map Level Field",MEDIUMWAIT);
        safeType(MAP_LEVEL_TEXTBOX,"Country","Sending the text",VERYLONGWAIT);
        List<WebElement> levels = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < levels.size(); i++) {
            System.out.println(levels.get(i).getText());
            if (levels.get(i).getText().equalsIgnoreCase("Country"))
            {
                levels.get(i).click();
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
    @Step("Verifying Map Portlet in Dashboard page")
    public void verifyingMapPortlet(String mapPortletName) {
        waitForPageToLoad();
        By MAP_PORTLET_TITLE= By.xpath("//span[@aria-label='"+mapPortletName+"']");
        waitUntilClickable(MAP_PORTLET_TITLE,"Map Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(MAP_PORTLET_TITLE).isDisplayed())
            Assert.fail("Map portlet added is not displayed in Dashboard page");
        By FILTER_MAP_PORTLET = By.xpath("//span[@aria-label='"+mapPortletName+"']/../following-sibling::span/i[contains(@class,'filter')]");
        if(!driver.findElement(FILTER_MAP_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Map Portlet");
        mouseHoverJScript(FILTER_MAP_PORTLET,"Filter icon","Filter icon in Map Portlet",MEDIUMWAIT);
        By FILTER_MESSAGE_MAP_PORTLET = By.xpath("//span[@aria-label='"+appliedFilter+"']");
        if(!driver.findElement(FILTER_MESSAGE_MAP_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Map portlet");
    }


    @Step("Validating NTabular Portlet")
    public  void verifyingExportedNtabularPortlet(String tabularPortletName) throws IOException {
        waitForSecs(10);
        List<WebElement> list = driver.findElements(NtabularFirstRow);
        for (int i = 0; i < list.size(); i++) {
            String data = list.get(i).getText();
            System.out.println("Table Data   :" +data);
        }
        waitForSecs(7);
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
        //String downloadPath = "C:\\Users\\rama.chinthareddy\\Downloads";
        String home = System.getProperty("user.home");
        String file_name = tabularPortletName + ".csv";
        System.out.println(file_name);
        String downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        Assert.assertTrue(fileName.equals(file_name));
        Reader reader = new FileReader(downloadPath + "\\" + fileName);
        CSVReader csvreader = new CSVReader(reader);
        String [] nextLine;
        int lineNumber = 0;
        while ((nextLine = csvreader.readNext()) != null) {
            lineNumber++;
            System.out.println("Line # " + lineNumber);

            // nextLine[] is an array of values from the line
            System.out.println(nextLine[2] + "etc...");
        }

        reader.close();
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }


    @Step("Removing portlet")
     public  void removingPortlet()
    {
        safeClick(CLOSE_PORTLET,"Close button",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CONFIRM,"Confirm Button",MEDIUMWAIT);
        waitForSecs(2);
        String actualText= safeGetText(PORTLET_NOTIFY,"Empty portlet Notigication",MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText,dashBoardData.noPorteltNotify);
    }
}
