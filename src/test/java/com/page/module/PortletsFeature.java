package com.page.module;

import com.datamanager.ConfigManager;
import com.opencsv.CSVReader;
import com.page.data.DashBoardData;
import com.page.locators.DashBoardLocators;
import com.page.locators.PortletLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PortletsFeature extends SafeActions implements PortletLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String appliedFilter = "Cumulative transaction duration of all requests between 2 consecutive clicks (in seconds). It will contain async and sync transactions.";
    String appliedFilterBPKPI = "No description provided";
    String file_name;
    String downloadPath;
    String appliedBPFilter = "No description provided";
    By Filters_TypeSearch = By.xpath("//div[contains(@class,'MuiDialogContent-root')]/div/div/input[@placeholder='Type or select below']");
    String appliedKPIFilter = null;
    private WebDriver driver1;
    String sessionTime = null;
    String expectedText;


    public PortletsFeature(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Adding Gauge Portlet")
    public void addingGaugePortlet(String gaugePortletName) throws InterruptedException {
        waitForSecs(10);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForSecs(10);
        //waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
     /*   waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
     //   safeClick(LINK_ADD_METRIC, "Clicking on add metric link");*/
        waitUntilClickable(GAUGE_HEADER, "Gauge header in Portlet Interface", MEDIUMWAIT);
        safeClick(GAUGE_HEADER, "Gauge header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        //safeType(GAUGE_TEXTBOX_KPI, "User Click", "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
        safeClearAndType(GAUGE_TEXTBOX_KPI,"User Click","Gauge textbx",MEDIUMWAIT);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase("User Click")) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(GAUGE_PORTLET_NAME, "Portlet Name field in Gauge portlet Interface");
     /*   String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);*/
        safeClearAndType(TEXTBOX_PORTLET,gaugePortletName,"gauge portelt",MEDIUMWAIT);

        safeClick(GAUGE_TEXTBOX_MEASURE, "Measure field", MEDIUMWAIT);
        safeType(GAUGE_TEXTBOX_MEASURE, "Avg Color Threshold", "Enter Measure", MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Avg Color Threshold")) {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
        safeJavaScriptClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        // safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        // safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Gauge Portlet in Dashboard page")
    public void verifyingGaugePortlet(String gaugePortletName) throws InterruptedException {
        waitForPageToLoad();
        By GAUGE_PORTLET_TITLE = By.xpath("//span[@aria-label='" +"User Click"+gaugePortletName + "']");
        waitUntilClickable(GAUGE_PORTLET_TITLE, "Gauge Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(GAUGE_PORTLET_TITLE).isDisplayed())
            Assert.fail("Gauge portlet added is not displayed in Dashboard page");
        By FILTER_GAUGE_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+gaugePortletName + "']/../following-sibling::div/span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_GAUGE_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Gauge Portlet");
        mouseHoverJScript(FILTER_GAUGE_PORTLET, "Filter icon", "Filter icon in Gauge Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_GAUGE_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        if (!driver.findElement(FILTER_MESSAGE_GAUGE_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Gauge portlet");
    }


    @Step("Adding Counter Portlet")
    public void addingCounterPortlet(String counterPortletName) throws InterruptedException {
        waitForSecs(10);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForSecs(10);
      // waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
/*        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");*/
        waitUntilClickable(COUNTER_HEADER, "Counter header in Portlet Interface", MEDIUMWAIT);
        safeClick(COUNTER_HEADER, "Counter header in Portlet Interface", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeClearAndType(COUNTER_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
/*        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(COUNTER_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + dashBoardData.portletKPI);*/
        waitForSecs(5);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(COUNTER_PORTLET_NAME, "Portlet Name field in Counter portlet Interface");
     /*   String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + counterPortletName);*/
        safeClearAndType(TEXTBOX_PORTLET,counterPortletName,"Counter portlet",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(COUNTER_TEXTBOX_MEASURE, "Measure field", MEDIUMWAIT);
        safeClearAndType(COUNTER_TEXTBOX_MEASURE, "Avg Color Threshold", "Enter Measure", MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Avg Color Threshold")) {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        // safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        // safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Counter Portlet in Dashboard page")
    public void verifyingCounterPortlet(String counterPortletName) {
        waitForPageToLoad();
        By COUNTER_PORTLET_TITLE = By.xpath("//span[@aria-label='" + "User Click"+counterPortletName + "']");
        waitUntilClickable(COUNTER_PORTLET_TITLE, "Counter Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(COUNTER_PORTLET_TITLE).isDisplayed())
            Assert.fail("Counter portlet added is not displayed in Dashboard page");
        By FILTER_COUNTER_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+ counterPortletName + "']/../following-sibling::div/span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_COUNTER_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Counter Portlet");
        By FILTER_MESSAGE_COUNTER_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        mouseHoverJScript(FILTER_MESSAGE_COUNTER_PORTLET, "Filter icon", "Filter icon in Counter Portlet", MEDIUMWAIT);
        if (!driver.findElement(FILTER_MESSAGE_COUNTER_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Counter portlet");
        try {
            waitForSecs(20);
            if (driver.findElement(COUNTER_PORTLET_CHART).isDisplayed()) {
                By KPI_COUNTER_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+ counterPortletName + "']/../../../following-sibling::div/div/div/div/div/*[local-name()='svg']/*[local-name()='text']/*[local-name()='tspan'][1]");
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
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(SEARCH_BAR_ADD_METRIC, "Search bar in Add Metric Window", MEDIUMWAIT);
        safeClick(SEARCH_BAR_ADD_METRIC, "Search bar in Add Metric Window", MEDIUMWAIT);
        driver.findElement(SEARCH_BAR_ADD_METRIC).sendKeys(dashBoardData.portletQuery, Keys.ENTER, Keys.ENTER);
    }
/*
    @Step("Verifying portlet added from search bar")
    public void verifyingPortletAddedFromSearchBar() {
        waitForPageToLoad();
        By PORTLET_TITLE = By.xpath("//span[@aria-label='" + dashBoardData.portletQuery + "']");
        waitUntilClickable(PORTLET_TITLE, "Counter Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(PORTLET_TITLE).isDisplayed())
            Assert.fail("Counter portlet added is not displayed in Dashboard page");
    }*/


    @Step("Verifying portlet added from search bar")
    public void navigatingToDrillThroughPage(String dname1) {
        waitForSecs(20);
        safeJavaScriptClick(BTN_DRILLTHROUGH, "Drillthrough button", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dashBoardData.drillthrghpage + " " + dname1);

    }

    @Step("Cloning Portlet in Dashboard page")
    public void cloningPortletInDashboardPage() {
        waitForPageToLoad();
        safeClick(BTN_CLONE_PORTLET, "Clone Portlet icon", MEDIUMWAIT);
        waitUntilClickable(DASHBOARD_FIELD_CLONE_PORTLET, "Dashboard Field in Clone Portlet window", MEDIUMWAIT);
        safeClick(DASHBOARD_FIELD_CLONE_PORTLET, "Dashboard Field in Clone Portlet window", MEDIUMWAIT);
        waitUntilClickable(DROPDOWN_DASHBOARDS, "Dropdown list of Dashboards", MEDIUMWAIT);
        waitForSecs(10);
        String clonedPortlet = Keys.chord(dashBoardData.DB_clonedPortlet) + Keys.ENTER;
        driver.findElement(DASHBOARD_OPTION_CLONE_PORTLET).sendKeys(clonedPortlet);
        safeClickingOnSearchingConfig(DROPDOWN_DASHBOARD_FOLDER, dashBoardData.DB_clonedPortlet);
        safeClick(BTN_CLONE_PORTLET_WINDOW, "Clone button in Clone Portlet window", MEDIUMWAIT);
        waitUntilElementDisappears(DASHBOARD_FIELD_CLONE_PORTLET, "Dashboard Field in Clone Portlet window", LONGWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section", MEDIUMWAIT);
    }

    @Step("Verifying Cloned portlet in Dashboard page")
    public void verifyingClonedPortlet(String gaugePortletName) {
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dashBoardData.DB_clonedPortlet + "\n", "Search box in Dashboards Overview page", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        By CLONED_PORTLET_DASHBOARD = By.xpath("//span[contains(@aria-label,'" + gaugePortletName + "')]");
        waitUntilClickable(CLONED_PORTLET_DASHBOARD, "Cloned portlet in Dashboard page", MEDIUMWAIT);
        if (!driver.findElement(CLONED_PORTLET_DASHBOARD).isDisplayed())
            Assert.fail("Cloned Portlet is not displayed in Dashboard page");
        By REMOVE_CLONED_PORTLET = By.xpath("//span[contains(@aria-label,'" + gaugePortletName + "')]/../../following-sibling::div/div[contains(@aria-label,'Close')]");
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
    public void addingPortlet(String dname1, String KPI) throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitUntilClickable(BTN_ADD_METRIC, "Waiting for an Add metric icon");
        safeClick(BTN_ADD_METRIC, "Add metric icon");
/*        waitUntilClickable(LINK_ADD_METRIC, "Waiting for an Add metric link");
        safeClick(LINK_ADD_METRIC, "Add metric link");*/
      //  safeClick(DROPDWON_KPI, "KPI Label", MEDIUMWAIT);
        // safeType(TEXTBOX_KPI, "User Click", "Sending the text", VERYLONGWAIT);
        waitForSecs(15);
        safeClearAndType(TEXTBOX_KPI,KPI,"KPI Name",MEDIUMWAIT);
      /*  String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(TEXTBOX_KPI);
        searchField2.sendKeys(del2 + KPI);*/
        waitForSecs(10);
        List<WebElement> kpi12 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpi12.size(); i++) {
            System.out.println(kpi12.get(i).getText());
            if (kpi12.get(i).getText().equals(KPI)) {
                kpi12.get(i).click();
                break;
            }
        }
        safeClick(TEXT_HEADER, "Portlet Name");
        waitForSecs(10);
        safeClearAndType(TEXTBOX_PORTLET,dname1,"KPI Name",MEDIUMWAIT);
       /* String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + dname1);*/
        WebElement rle = driver.findElement(By.xpath("//*[text()='Show As']/../../../div//div[contains(@class,'body1')]"));
        safeClick(DROPDOWN_SHOWAS, "ShowAs Dropdown", MEDIUMWAIT);
        safeType(TEXTBOX_SHOWAS, "Trend Chart", "Chart from show as dropdown", MEDIUMWAIT);
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
        for (int i = 0; i < kpi1.size(); i++) {

            if (kpi1.get(i).getText().contains("Measure - Trend Chart")) {

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
        searchField1.sendKeys(del1 + 5);
        waitForSecs(10);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        waitForSecs(10);
        safeClick(BTN_ADD_PORTLET, "Add Portlet", MEDIUMWAIT);
    }


    @Step("Verifying GHPortlet")
    public void VerifyingGHPortlet(String dname1,String KPI) {
        waitForSecs(10);
        By NTABULAR_PORTLET_TITLE = By.xpath("//span[@aria-label='" +KPI+ dname1 +" (Minute)"+"']");
        System.out.println(NTABULAR_PORTLET_TITLE);
        waitUntilClickable(NTABULAR_PORTLET_TITLE, "GH Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(NTABULAR_PORTLET_TITLE).isDisplayed())
            Assert.fail("GH portlet added is not displayed in Dashboard page");
        By FILTER_NTABULAR_PORTLET = By.xpath("//span[@aria-label='" +KPI+ dname1  +" (Minute)"+"']/../following-sibling::div/span/i[contains(@class,'filter')]");
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
                System.out.println("Data is displaying in GH Portlet");
            }
        } catch (Exception e) {
            if (!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in N Tabular portlet");
            System.out.println("Data is not available in N Tabular Portlet");
        }

    }


    @Step("Adding N Tabular Portlet")
    public void addingNTabularPortlet(String nTabularPortletName) throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
/*        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");*/
        waitUntilClickable(NTABULAR_HEADER, "N Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(NTABULAR_HEADER, "N Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeClearAndType(NTABULAR_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        waitForSecs(2);
     /*   String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(NTABULAR_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + dashBoardData.portletKPI);*/
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(NTABULAR_PORTLET_NAME, "Portlet Name field in N Tabular portlet Interface");
        safeClearAndType(TEXTBOX_PORTLET,nTabularPortletName,"ntabular portlet",MEDIUMWAIT);
        /* String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + nTabularPortletName);*/
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
        safeType(Filters_TypeSearch, "Color", "Enter Text in KPI Filters field");
        //safeClick(KPI_FILTER_OPTION, "Selecting field", MEDIUMWAIT);
       waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        safeClick(NTABULAR_LABEL_FIELD, "Label Field", MEDIUMWAIT);
        safeType(NTABULAR_LABEL_FIELD_TEXTBOX, dashBoardData.nTabularPortletLabel, "Label Field", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ORDER_BY_FIELD, "Order By Field in N Tabular portlet", MEDIUMWAIT);
        safeClick(NTABULAR_ORDER_BY_OPTION, "Order By Field option in N Tabular portlet", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ORDER_DIRECTION_FIELD, "Order Direction Field in N Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_OPTION, "Order Direction Field option in N Tabular portlet", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(NTABULAR_SHOW_KPI_NAME_CHECKBOX, "Show KPI Name checkbox", MEDIUMWAIT);
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        // safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        // safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying N Tabular Portlet in Dashboard page")
    public void verifyingNTabularPortlet(String nTabularPortletName) throws InterruptedException {
        waitForPageToLoad();
        By NTABULAR_PORTLET_TITLE = By.xpath("//span[@aria-label='" + "User Click"+nTabularPortletName +" (Day)"+"']");
        System.out.println(NTABULAR_PORTLET_TITLE);
        waitUntilClickable(NTABULAR_PORTLET_TITLE, "GH Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(NTABULAR_PORTLET_TITLE).isDisplayed())
            Assert.fail("GH portlet added is not displayed in Dashboard page");
        By FILTER_NTABULAR_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+ nTabularPortletName  +" (Day)"+"']/../following-sibling::div/span/i[contains(@class,'filter')]");
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
    public void navigatingToDrilthroughPagesUsingTooltipOptions(String gaugePortletName) {
        waitForSecs(10);
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
        Assert.assertEquals(Tooltip2, dashBoardData.tooltip2+" "+gaugePortletName);
        waitForPageToLoad();
        safeClick(HYPERLINKDBINDRILLTHROUGH, "Dashboard Name Hyper link in Drillthrough Page", MEDIUMWAIT);
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_3, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip3 = safeGetText(Title_DRILLTHROUGH, "Drill through page title for pivot instances", MEDIUMWAIT);
        System.out.println(Tooltip3);
        Assert.assertEquals(Tooltip3, dashBoardData.tooltip3+" "+gaugePortletName);
        safeClick(HYPERLINKDBINDRILLTHROUGH, "Dashboard Name Hyper link in Drillthrough Page", MEDIUMWAIT);

    }

    @Step("Adding Tabular Portlet page1")
    public void addingTabularPortlet() throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(TABULAR_HEADER, "Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(TABULAR_HEADER, "Tabular header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        waitForSecs(10);
        safeClearAndType(TABULAR_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
/*        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(TABULAR_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + dashBoardData.portletKPI);*/
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(TABULAR_MEASURES_FIELD, "Pivots Field", MEDIUMWAIT);
        safeClearAndType(TABULAR_MEASURES_FIELD_INPUT,dashBoardData.portletMeasureData,"measure",MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> kpi2 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpi2.size(); i++) {
            System.out.println(kpi2.get(i).getText());
            if (kpi2.get(i).getText().equalsIgnoreCase(dashBoardData.portletMeasureData)) {
                kpi2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClearAndType(TABULAR_PIVOT_FIELD_INPUT,dashBoardData.tabularPortletPivotData,"Count",MEDIUMWAIT);
        List<WebElement> kpi3 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpi3.size(); i++) {
            System.out.println(kpi3.get(i).getText());
            if (kpi3.get(i).getText().equalsIgnoreCase(dashBoardData.tabularPortletPivotData)) {
                kpi3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(ORDER_BY_FIELD, "Order By Field in Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_BY_OPTION, "Order By Field option in Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_FIELD, "Order Direction Field in Tabular portlet", MEDIUMWAIT);
        safeClick(ORDER_DIRECTION_OPTION, "Order Direction Field option in Tabular portlet", MEDIUMWAIT);
    }

    @Step("adding Tabular page2")
    public void addingtabularPortlet1(String tabularPortletName) {
        safeClick(SHOW_SLA_COLUMN_CHECKBOX, "Show SLA column checkbox", MEDIUMWAIT);
        safeClick(TABULAR_PORTLET_NAME, "Portlet Name field in Tabular portlet Interface");
    safeClearAndType(TEXTBOX_PORTLET,tabularPortletName,"tabular portlet",MEDIUMWAIT);
     /*   String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + tabularPortletName);*/
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        // safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Tabular Portlet in Dashboard page")
    public void verifyingTabularPortlet(String tabularPortletName) throws InterruptedException {
        waitForSecs(15);
        By TABULAR_PORTLET_TITLE = By.xpath("//span[@aria-label='"+"User Click"+tabularPortletName +"']");
       // waitUntilClickable(TABULAR_PORTLET_TITLE, "Tabular Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(TABULAR_PORTLET_TITLE).isDisplayed())
            Assert.fail("Tabular portlet added is not displayed in Dashboard page");
        By FILTER_TABULAR_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+ tabularPortletName + "']/../following-sibling::div/span/i[contains(@class,'filter')]");
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


    public void downloadedpath() {
        waitForSecs(7);
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
        String home = System.getProperty("user.home");
        downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);

    }

    @Step("Export GH Portlet")
    public void validatingExportedGHPortlet(String file_name, String[] expected) throws IOException {

        downloadedpath();
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        System.out.println(file_name);
        Assert.assertTrue(fileName.equals(file_name));
        for (int j = 0; j < expected.length; j++) {
            System.out.println("Values are " + expected[j]);
        }
        Reader reader = new FileReader(downloadPath + "\\" + fileName);
        CSVReader csvreader = new CSVReader(reader);
        List<String[]> list = csvreader.readAll();
        Iterator<String[]> ite = list.iterator();
        String[] data = ite.next();
        for (int i = 0; i < data.length; i++) {
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

    @Step("Taking latest file from windows")
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

    @Step("adding  Tabular portlet")
    public void verifyingHoverMessageinFilterTabularportlet(String tabularPortletName) {
        safeClick(TABULAR_PORTLET_NAME, "Portlet Name field in Tabular portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + tabularPortletName);
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
        safeJavaScriptClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeJavaScriptClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeJavaScriptClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeJavaScriptClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeJavaScriptClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeJavaScriptClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
       waitForSecs(10);
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
        waitForSecs(5);

    }

    @Step("Verify hover message in filter icon in Analysis portlet in Tabular portlet")
    public void verifyhoverFiltermessage() {
        waitForSecs(2);
        mouseHoverJScript(SLACOLUMNS, "", "first sla", MEDIUMWAIT);
        waitForSecs(7);
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
       /* waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");*/
        waitUntilClickable(FLOW_HEADER, "Flow header in Portlet Interface", MEDIUMWAIT);
        safeClick(FLOW_HEADER, "Flow header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeClick(KPI_GHOSTTEXT, "KPI ghost text", MEDIUMWAIT);
        safeClearAndType(FLOW_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
      /*  String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(FLOW_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + dashBoardData.portletKPI);*/
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equals(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(FLOW_PORTLET_NAME, "Portlet Name field in Flow portlet Interface");
       safeClearAndType(TEXTBOX_PORTLET,flowPortletName,"Flow portlet name",MEDIUMWAIT);
      /*  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + flowPortletName);*/
        waitForSecs(20);
        safeClick(FLOW_COLUMN_LABEL, "Column Label Field", MEDIUMWAIT);
       // String deleteColumnLabelData = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        driver.findElement(FLOW_COLUMN_LABEL_INPUT).sendKeys(dashBoardData.flowPortletColumnLabel);
        safeClick(FLOW_CLUSTER_BY_LABEL, "Cluster By Field", MEDIUMWAIT);
       // String clusterdata = Keys.chord("Name");
        driver.findElement(FLOW_CLUSTER_BY_INPUT).sendKeys("Name");
        List<WebElement> kpis1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis1.size(); i++) {
            System.out.println(kpis1.get(i).getText());
            if (kpis1.get(i).getText().equals("Name")) {
                kpis1.get(i).click();
                break;
            }
        }

        safeClick(FLOW_SHOW_USERS_CHECKBOX, "Show Users checkbox", MEDIUMWAIT);
      /*  safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        safeClick(Filters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(Filters_TypeSearch, "Name", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        driver.findElement(Filters_TypeSearch).sendKeys(Keys.ENTER);
        safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));*/
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
    /*    safeClick(FLOW_FILTER_VALUE_LABEL, "", MEDIUMWAIT);
        safeType(FLOW_FILTER_VALUE, "Sample", "Filter value field input", MEDIUMWAIT);
        safeClick(FLOW_FILTER_POSITION_LABEL, "Filter Position Field", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_FILTER_POSITION_CHART, "Clicking on KPI", MEDIUMWAIT);
        safeClick(FILTER_POSITION_CHART_GHOSTTEXT,"KPI ghost text",MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_FILTER_POSITION_CHART, "End At", "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
        List<WebElement> kpis1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis1.size(); i++) {
            System.out.println(kpis1.get(i).getText());
            if (kpis1.get(i).getText().equals("End At")) {
                kpis1.get(i).click();
                break;
            }
        }*/
        // safeClick(FLOW_FILTER_POSITION, "Filter Position Dropdown Option", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Flow Portlet in Dashboard page")
    public void verifyingFlowPortlet(String flowPortletName) throws InterruptedException {
        waitForSecs(20);
        By FLOW_PORTLET_TITLE = By.xpath("//span[@aria-label='" + "User Click"+flowPortletName + "']");
        waitUntilClickable(FLOW_PORTLET_TITLE, "Flow Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(FLOW_PORTLET_TITLE).isDisplayed())
            Assert.fail("Flow portlet added is not displayed in Dashboard page");
        By FILTER_FLOW_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+ flowPortletName + "']/../following-sibling::div/i");
        if (!driver.findElement(FILTER_FLOW_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Flow Portlet");
        mouseHoverJScript(FILTER_FLOW_PORTLET, "Filter icon", "Filter icon in Flow Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_FLOW_PORTLET = By.cssSelector(".MuiTooltip-tooltip.MuiTooltip-tooltipPlacementTop>div>div>div:nth-child(2)");
        String text = safeGetText(FILTER_MESSAGE_FLOW_PORTLET, "Information text", MEDIUMWAIT);
        System.out.println(text);
        if (!text.contains(appliedFilter))
            Assert.fail("Filter Message is not displayed properly in Flow portlet");
        try {
            waitForSecs(5);
            if (driver.findElement(FLOW_PORTLET_GRAPH).isDisplayed()) {
                safeClick(BTN_MAXIMIZE_PORTLET, "Maximise portlet button", MEDIUMWAIT);
                By COLUMN_LABEL = By.cssSelector("text.headerText:nth-child(1)");
                waitUntilClickable(COLUMN_LABEL, "Column label Field", MEDIUMWAIT);
                if (!driver.findElement(COLUMN_LABEL).isDisplayed())
                    Assert.fail("Column Label is not displayed properly in Flow portlet");
            }
        } catch (Exception e) {
            if (!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in flow portlet");
            System.out.println("Data is not available in Flow Portlet");
        }
    }

    @Step("Export Tabular portlet")
    public void validatingExportedATabularPortlet(String tabularPortletName) throws IOException {

        waitForSecs(10);
        List<WebElement> list = driver.findElements(TABULAR_COLUMN1);
        for (int i = 1; i < list.size(); i++) {
            String data = list.get(i).getText();
            System.out.println("Table Data   :" + data);
        }
        List<WebElement> list2 = driver.findElements(TABULAR_COLUMN2);
        List<Double> testList = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            String data2 = list2.get(i).getText();
            double d = Double.parseDouble(data2);
            System.out.println("Table Data   :" + d);
            testList.add(d);
        }
        Collections.sort(testList);
        Collections.reverse(testList);
        List<WebElement> list3 = driver.findElements(TABULAR_COLUMN3);
        for (int i = 1; i < list.size(); i++) {
            String data3 = list3.get(i).getText();
            System.out.println("Table Data   :" + data3);
        }
        waitForSecs(7);
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
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
        String s1 = "";
        String s2 = "";
        String s3 = "";
        while ((cell = csvreader.readNext()) != null) {
            int i = 0;
            s1 = s1 + cell[i] + ":";
            s2 = s2 + cell[i + 1] + ":";
            s3 = s3 + cell[i + 2] + ":";
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String[] labels = s1.split(":");
        Arrays.sort(labels);
        Arrays.toString(labels);
        for (int i = 1; i < labels.length - 1; i++) {
            if (labels[i + 1].equals(list.get(i).getText())) {
                System.out.println("Exported CSV values  :" + labels[i + 1] + "  Table Column Values:" + list.get(i).getText());
                Assert.assertEquals(labels[i + 1], list.get(i).getText());
            }
        }
        String[] column2 = s2.split(":");
        Arrays.sort(column2);
        Arrays.toString(column2);
        for (int i = 1; i <= column2.length - 1; i++) {
            double value = Double.parseDouble(column2[i + 2]);
            String Double = String.format("%.2f", value);
            System.out.println("Exported CSV values  :" + Double + "  Table Column Values:" + list2.get(i).getText());
            // Assert.assertEquals(Double, list2.get(i).getText());


        }
        String[] column3 = s3.split(":");
        Arrays.sort(column3);
        Arrays.toString(column3);
        for (int i = 0; i < column3.length - 1; i++) {
            double value = Double.parseDouble(column3[i + 3]);
            String Double = String.format("%.0f", value);
            System.out.println("Exported CSV values  :" + Double + "  Table Column Values:" + testList.get(i));

        }


        reader.close();
      /*  File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }*/
    }


    @Step("Adding Map Portlet")
    public void addingMapPortlet(String mapPortletName) throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        //waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        //safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        waitUntilClickable(MAP_HEADER, "Map header in Portlet Interface", MEDIUMWAIT);
        safeClick(MAP_HEADER, "Map header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeClearAndType(MAP_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        Thread.sleep(1000);
     /*   String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(MAP_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + dashBoardData.portletKPI);*/
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(MAP_PORTLET_NAME, "Portlet Name field in Map portlet Interface");
        safeClearAndType(TEXTBOX_PORTLET,mapPortletName,"Portelet name",MEDIUMWAIT);
    /*    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + mapPortletName);*/
        safeClick(MAP_LOCATION_FOR_LABEL, "Location field", MEDIUMWAIT);
        Thread.sleep(2000);
        safeClick(MAP_LOCATION_FOR, "Location field", MEDIUMWAIT);
        Actions action1 = new Actions(driver);
        action1.sendKeys("System");
        Thread.sleep(2000);
        List<WebElement> locations = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < locations.size(); i++) {
            System.out.println(locations.get(i).getText());
            if (locations.get(i).getText().equalsIgnoreCase("System")) {
                locations.get(i).click();
                break;
            }
        }
        safeClick(MAP_LEVEL_DROPDOWN, "Map Level Field", MEDIUMWAIT);
        safeType(MAP_LEVEL_TEXTBOX, "Country", "Sending the text", VERYLONGWAIT);
        List<WebElement> levels = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < levels.size(); i++) {
            System.out.println(levels.get(i).getText());
            if (levels.get(i).getText().equalsIgnoreCase("Country")) {
                levels.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
        safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        // safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeClick(DROPDOWN_VALUE, "Apply filters text", MEDIUMWAIT);
        safeClick(LABEl_IS, "Is label", MEDIUMWAIT);
        safeClick(SELECT_DRPDOWN, "is not", MEDIUMWAIT);
        // safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying Map Portlet in Dashboard page")
    public void verifyingMapPortlet(String mapPortletName) {
        waitForPageToLoad();
        By MAP_PORTLET_TITLE = By.xpath("//span[@aria-label='" +"User Click"+ mapPortletName + "']");
        waitUntilClickable(MAP_PORTLET_TITLE, "Map Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(MAP_PORTLET_TITLE).isDisplayed())
            Assert.fail("Map portlet added is not displayed in Dashboard page");
        By FILTER_MAP_PORTLET = By.xpath("//span[@aria-label='" +"User Click"+ mapPortletName + "']/../following-sibling::div/span/i[contains(@class,'filter')]");
        if (!driver.findElement(FILTER_MAP_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Map Portlet");
        mouseHoverJScript(FILTER_MAP_PORTLET, "Filter icon", "Filter icon in Map Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_MAP_PORTLET = By.xpath("//span[@aria-label='" + appliedFilter + "']");
        if (!driver.findElement(FILTER_MESSAGE_MAP_PORTLET).isDisplayed())
            Assert.fail("Filter Message is not displayed properly in Map portlet");
    }


    @Step("Validating NTabular Portlet")
    public void verifyingExportedNtabularPortlet(String tabularPortletName) throws IOException {
        waitForSecs(10);
        String firstRow = driver.findElement(NtabularFirstRow).getText();
        String secndRow = driver.findElement(NTABULARSENDROW).getText();
        String thirdRow = driver.findElement(NTABULARTHIRDROW).getText();
        String secnd2 = secndRow + ".00";
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
        String s1 = "";
        String s2 = "";
        String s3 = "";
        while ((cell = csvreader.readNext()) != null) {
            int i = 0;
            s1 = s1 + cell[i] + ":";
            s2 = s2 + cell[i + 1] + ":";
            s3 = s3 + cell[i + 2] + ":";
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String[] labels = s1.split(":");
        Arrays.sort(labels);
        Arrays.toString(labels);
        for (int i = 1; i < labels.length - 1; i++) {
            if (labels[i + 2].equals(firstRow)) {
                System.out.println("Exported 1st CSV values  :" + labels[i + 2] + "  Table Column Values:" + firstRow);
                //Assert.assertEquals(labels[i + 1], firstRow);
            }
        }
        String[] column2 = s2.split(":");
        Arrays.sort(column2);
        Arrays.toString(column2);
        System.out.println(column2.length);
        for (int i = 1; i > column2.length - 1; i++) {
            String value = column2[i + 2];
            //String Double = String.format("%.2f", value);
            System.out.println("Exported 2nd CSV values  :" + value + "  Table Column Values:" + secnd2);
            // Assert.assertEquals(Double, list2.get(i).getText());


        }
        String[] column3 = s3.split(":");
        Arrays.sort(column3);
        Arrays.toString(column3);
        for (int i = 1; i <= column3.length - 1; i++) {
            String value = column3[i + 2];
            //String Double = String.format("%.2f", value);
            System.out.println("Exported 3rd CSV values  :" + value + "  Table Column Values:" + thirdRow);
            // Assert.assertEquals(Double, list2.get(i).getText());


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
    public void removingPortlet() {
        safeClick(CLOSE_PORTLET, "Close button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CONFIRM, "Confirm Button", MEDIUMWAIT);
        waitForSecs(2);
        String actualText = safeGetText(PORTLET_NOTIFY, "Empty portlet Notigication", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dashBoardData.noPorteltNotify);
    }

    @Step("Exporting Gauge Portlet")
    public void exportingGaugePortlet(String gaugePortletName) throws IOException {
        waitForSecs(15);
        String gaugeData = safeGetText(GAUGEPORTLETDATA, "Gauge Portlet Data", MEDIUMWAIT);
        System.out.println(gaugeData);
        String gaugeData1 = gaugeData.replace(",", "");
        System.out.println(gaugeData1);
        String actualValue = "#" + gaugeData1;
        waitForSecs(15);
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
        //String downloadPath = "C:\\Users\\rama.chinthareddy\\Downloads";
        String home = System.getProperty("user.home");
        String file_name = gaugePortletName + ".csv";
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
        while ((cell = csvreader.readNext()) != null) {
            int i = 0;
            s = s + cell[i];
            // String emails = cell[i + 1];
            //String message = cell[i + 2];

        }
        System.out.println(s);
        Assert.assertEquals(s, actualValue);
        reader.close();
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }

    @Step("Exporting Counter Portlet")
    public void exportingCounterPortlet(String counterPortletName) throws IOException {
        String counterData = safeGetText(COUNTERPORTLETDATA, "Gauge Portlet Data", MEDIUMWAIT);
        System.out.println(counterData);
        String counterData1 = counterData.replace(",", "");
        System.out.println(counterData1);
        String actualValue = "#" + counterData1;
        safeClick(BTN_EXPORT, "Export Button", MEDIUMWAIT);
        waitForSecs(10);
        String home = System.getProperty("user.home");
        String file_name = counterPortletName + ".csv";
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
        while ((cell = csvreader.readNext()) != null) {
            int i = 0;
            s = s + cell[i];
        }
        System.out.println(s);
        Assert.assertEquals(s, actualValue);
        waitForSecs(2);
        reader.close();
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }


    @Step("Navigate to Drillthrough page using '3 option' tooltip")
    public void navigateToDrillthroughPage(String gaugePortletName) {
        waitForSecs(20);
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(TOOLTIPOPTION_2, "Drillthrough", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip2 = safeGetText(Title_DRILLTHROUGH, "Page title for Drillthrough", MEDIUMWAIT);
        System.out.println(Tooltip2);
        Assert.assertEquals(Tooltip2, dashBoardData.tooltip2 + " " +"User Click"+gaugePortletName);
    }

    @Step("Navigate to RCA page from Drillthrough page")
    public void navigateToRCAFromDrillthroughPage() throws InterruptedException {
        waitForPageToLoad();
        By SESSION_DRILLTHROUGH = By.xpath("//div[contains(@role,'rowgroup')]/a/div//div/div[2]");
        By SESSION_TIME = By.xpath("//div[contains(@role,'rowgroup')]/a/div//div/div[2]/span/span");
        waitUntilClickable(SESSION_TIME, "", MEDIUMWAIT);
        sessionTime = driver.findElement(SESSION_TIME).getText();
        System.out.println("Time is " + driver.findElement(SESSION_TIME).getText());
        safeClick(SESSION_DRILLTHROUGH, "", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip1 = safeGetText(Title_DRILLTHROUGH, "Page title for RCA", MEDIUMWAIT);
        System.out.println(Tooltip1);
        Assert.assertEquals(Tooltip1, dashBoardData.tooltip1);
    }

    @Step("Navigate to RCA page from Drillthrough page")
    public void verifyTimeRangeInRCAPage() throws InterruptedException {
        waitUntilClickable(TIME_SESSION_RCA, "", MEDIUMWAIT);
        Assert.assertEquals(driver.findElement(TIME_SESSION_RCA).getText(), sessionTime);
        String time = driver.findElement(TIME_SESSION_RCA).getText().substring(0, 16);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm");
        DateTime dt = formatter.parseDateTime(time);
        List<WebElement> ranges = driver.findElements(CALENDAR_TIME_RANGE);
        DateTime startRange = formatter.parseDateTime(ranges.get(0).getText().substring(0, 16));
        DateTime endRange = formatter.parseDateTime(ranges.get(1).getText().substring(0, 16));
        System.out.println("Actual Time is " + dt + " Start Time is " + startRange.plusMinutes(5) + " End time is " + endRange.minusMinutes(5));
        if (!(dt.equals(startRange.plusMinutes(5)) && dt.equals(endRange.minusMinutes(5))))
            Assert.fail("Time Range is not displayed properly in RCA page");

    }

    @Step("Navigate to RCA page using '3 option' tooltip")
    public void navigateToRCAPage() {
        waitForPageToLoad();
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_1, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip1 = safeGetText(Title_DRILLTHROUGH, "Page title for RCA", MEDIUMWAIT);
        System.out.println(Tooltip1);
        Assert.assertEquals(Tooltip1, dashBoardData.tooltip1);
    }

    @Step("Maximise portlet in RCA page")
    public void maximisePortletInRCAPage() {
        waitForPageToLoad();
        safeClick(ICON_MAXMIZE_RCA, "Maximize button in Issue Description portlet", MEDIUMWAIT);
        waitUntilClickable(ICON_RESTORE_RCA, "Restore button in Issue Description portlet", MEDIUMWAIT);
        safeClick(ICON_RESTORE_RCA, "Restore button in Issue Description portlet", MEDIUMWAIT);
        try {
            if (driver.findElement(ICON_MAXMIZE_RCA).isDisplayed())
                System.out.println("Portlet is restored properly in RCA page");
        } catch (Exception e) {
            Assert.fail("Portlet is not restored properly in RCA page");
        }
    }

    @Step("Navigate to RCA Drill through page")
    public void navigateToRCADrillThroughPage() {
        waitForPageToLoad();
        mouseHoverJScript(PORTLET_BAR, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_1, "RCA", MEDIUMWAIT);
        waitForPageToLoad();
        String Tooltip1 = safeGetText(Title_DRILLTHROUGH, "Drill through page title for RCA", MEDIUMWAIT);
        System.out.println(Tooltip1);
    }


    @Step("Adding Flow Portlet using BP KPI")
    public void addingFlowPortletUsingBPKPI(String flowPortletName) throws InterruptedException {
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        safeClick(FLOW_HEADER, "Flow header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeClick(KPI_GHOSTTEXT, "KPI ghost text", MEDIUMWAIT);
        //safeJavaScriptClearAndType(FLOW_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(FLOW_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + dashBoardData.portletBPKPI);
        waitForSecs(20);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        waitForSecs(10);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equals(dashBoardData.portletBPKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        waitForSecs(20);
        safeClick(FLOW_PORTLET_NAME, "Portlet Name field in Flow portlet Interface");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + flowPortletName);
        waitForSecs(20);
        safeClick(FLOW_COLUMN_LABEL, "Column Label Field", MEDIUMWAIT);
        String deleteColumnLabelData = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        driver.findElement(FLOW_COLUMN_LABEL_INPUT).sendKeys(deleteColumnLabelData, dashBoardData.flowPortletColumnLabel);
        waitForSecs(20);
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

    @Step("Verifying BP Flow Portlet in Dashboard page")
    public void verifyingFlowPortletUSingBPKPI(String flowPortletName) throws InterruptedException {
        waitForSecs(20);
        By FLOW_PORTLET_TITLE = By.xpath("//span[@aria-label='" + flowPortletName + "']");
        waitUntilClickable(FLOW_PORTLET_TITLE, "Flow Portlet Title", MEDIUMWAIT);
        if (!driver.findElement(FLOW_PORTLET_TITLE).isDisplayed())
            Assert.fail("Flow portlet added is not displayed in Dashboard page");
        By FILTER_FLOW_PORTLET = By.xpath("//span[@aria-label='" + flowPortletName + "']/../following-sibling::div/i");
        if (!driver.findElement(FILTER_FLOW_PORTLET).isDisplayed())
            Assert.fail("Filter icon is not displayed for Flow Portlet");
        mouseHoverJScript(FILTER_FLOW_PORTLET, "Filter icon", "Filter icon in Flow Portlet", MEDIUMWAIT);
        By FILTER_MESSAGE_FLOW_PORTLET = By.cssSelector(".MuiTooltip-tooltip.MuiTooltip-tooltipPlacementTop>div>div>div:nth-child(2)");
        String text = safeGetText(FILTER_MESSAGE_FLOW_PORTLET, "Information text", MEDIUMWAIT);
        System.out.println(text);
        if (!text.contains(appliedFilterBPKPI))
            Assert.fail("Filter Message is not displayed properly in Flow portlet");
        try {
            waitForSecs(5);
            if (driver.findElement(FLOW_PORTLET_GRAPH).isDisplayed()) {
                safeClick(BTN_MAXIMIZE_PORTLET, "Maximise portlet button", MEDIUMWAIT);
                By COLUMN_LABEL = By.cssSelector("text.headerText:nth-child(1)");
                waitUntilClickable(COLUMN_LABEL, "Column label Field", MEDIUMWAIT);
                if (!driver.findElement(COLUMN_LABEL).isDisplayed())
                    Assert.fail("Column Label is not displayed properly in Flow portlet");
            }
        } catch (Exception e) {
            if (!driver.findElement(NO_DATA_AVAILABLE_PORTLET).isDisplayed())
                Assert.fail("No Data Available label is not displayed in flow portlet");
            System.out.println("Data is not available in Flow Portlet");
        }
    }

    public void navigateToRCApageFrmPivotPage() {
        mouseHoverJScript(BY_LABEL_PIVOT, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        safeClick(TOOLTIPOPTION_1, "Pivot", MEDIUMWAIT);
        waitForSecs(10);
        String Tooltip1 = safeGetText(Title_DRILLTHROUGH, "Page title for RCA", MEDIUMWAIT);
        System.out.println(Tooltip1);
        Assert.assertEquals(Tooltip1, dashBoardData.tooltip1);
    }

    public void addingMultipleMeasuresInGHPortlet() {
        safeClick(EDIT_PENCIL_ICON, "Pencil icon", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(MEASURE_ADD_ICON).get(1).click();
        safeClearAndType(MEASURE_TXTBOX, "Count", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Count")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(CHKBOX_SHOW_KPINAME, "KPI name", MEDIUMWAIT);
        safeClick(CHKBOX_SHOW_LEGEND, "Show Legend", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Saving Portlet", MEDIUMWAIT);
        waitForSecs(15);
        String text = driver.findElements(LEGENDS).get(0).getText();
        System.out.println(text);
        String expectedText = "Avg Duration not null";
        Assert.assertEquals(text, expectedText);
        String text2 = driver.findElements(LEGENDS).get(1).getText();
        System.out.println(text2);
        String expectedText1 = "# not null";
        Assert.assertEquals(text2, expectedText1);


    }

    public void addingMultipleMeasuresTabularPortlet() {
        safeClick(EDIT_PENCIL_ICON, "Pencil icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClearAndType(MEASURE_TXTBOX_TABULAR, "Min Color Threshold", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Min Color Threshold")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_SAVE, "Saving Portlet", MEDIUMWAIT);
        waitForSecs(15);
        boolean text = driver.findElement(By.xpath("//div[@aria-label='Avg Duration (s)']")).isDisplayed();
        System.out.println(text);
        Assert.assertTrue(text);
        boolean text2 = driver.findElement(By.xpath("//div[@aria-label='Min Color Threshold (s)']")).isDisplayed();
        System.out.println(text2);
        Assert.assertTrue(text2);

    }

    public void addingMultipleMeasuresInNTabularPortlet() {
        safeClick(EDIT_PENCIL_ICON, "Pencil icon", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElements(MEASURE_ADD_ICON).get(0).click();
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        // safeType(NTABULAR_TEXTBOX_KPI, dashBoardData.portletKPI, "Sending the text", VERYLONGWAIT);
        waitForSecs(2);
        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(NTABULAR_KPI_ONE);
        searchField2.sendKeys(del2 + dashBoardData.portletKPI);
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase(dashBoardData.portletKPI)) {
                kpis.get(i).click();
                break;
            }
        }
        safeClearAndType(NTABULAR_MEASURE_TXTBOX, "Min Color Threshold", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Min Color Threshold")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_SAVE, "Saving Portlet", MEDIUMWAIT);
        waitForSecs(15);
        boolean text = driver.findElement(By.xpath("//span[text()='Sample Label']")).isDisplayed();
        System.out.println(text);
        Assert.assertTrue(text);
        boolean text2 = driver.findElement(By.xpath("//span[text()='Min Color Threshold']")).isDisplayed();
        System.out.println(text2);
        Assert.assertTrue(text2);

    }

    public void addingMultipleMeasuresInGaugePortlet() {
        safeClick(EDIT_PENCIL_ICON, "Pencil icon", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(MEASURE_ADD_ICON).click();
        waitForSecs(15);
        safeClick(SHOWCONSTRAINT_VALUE_CHKBOX, "Show Constraint value checkbox", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Saving Portlet", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(GAUGE_PORTLET_BAR2, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        boolean text = driver.findElement(By.xpath("//p[text()='Avg Duration (User Click)']")).isDisplayed();
        System.out.println(text);
        Assert.assertTrue(text);
        waitForSecs(10);
        mouseHoverJScript(GAUGE_PORTLET_BAR1, "Portlet Bar", "Mouse Over on the portlet bar", MEDIUMWAIT);
        waitForSecs(10);
        boolean text2 = driver.findElement(By.xpath("//p[text()='Avg Color Threshold (User Click)']")).isDisplayed();
        System.out.println(text2);
        Assert.assertTrue(text2);
        refresh();
        waitForSecs(10);
    }

    public void addingMultipleMeasuresInCounterPortlet() {
        safeClick(EDIT_PENCIL_ICON, "Pencil icon", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(MEASURE_ADD_ICON).click();
        safeClick(BTN_SAVE, "Saving Portlet", MEDIUMWAIT);
        waitForSecs(15);
        String text = driver.findElements(LEGENDS).get(0).getText();
        System.out.println(text);
        String expectedText = "Avg Color Threshold not null (User Click):";
        Assert.assertEquals(text, expectedText);
        String text2 = driver.findElements(LEGENDS).get(2).getText();
        System.out.println(text2);
        String expectedText1 = "Avg Duration not null (User Click):";
        Assert.assertEquals(text2, expectedText1);
    }

    public void addingDataOnlyAboveSLA() {
        safeClick(EDIT_PENCIL_ICON, "Pencil icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DATA_ONLY_ABOVE_SLA, "Data only above sla checkbox", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DRILLTHROUGH, "Drillthrough button", MEDIUMWAIT);
        String text = safeGetText(LABEL_DATAABOVE_SLA, "Above SLA value", MEDIUMWAIT);
        System.out.println(text);
        String expectedText = "RED,YELLOW,ORANGE, not none";
        Assert.assertEquals(text, expectedText);
    }

    @Step("Validating hours option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingHours() throws InterruptedException {
        waitForSecs(15);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_TODAY, "Today button", MEDIUMWAIT);
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        waitForSecs(7);
        safeJavaScriptClick(BTN_HOURLY, "Hourly option from Trend Granularity", MEDIUMWAIT);
        waitForSecs(7);
/*        String text = safeGetAttribute(NTABULAR_LABELS_Hourly, "title", "Hourly text", MEDIUMWAIT);
        System.out.println(text);
        expectedText = "Hourly";
        Assert.assertEquals(text, expectedText);*/
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("d. MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
      /*  cal.add(Calendar.DATE, -30);
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
       cal.add(Calendar.DATE, 2);
        String s2 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s3 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s4 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s5 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s6 = f.format(new Date(cal.getTimeInMillis()));

        cal.add(Calendar.DATE, 2);
        String s7 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s8 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s9 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s10 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s11 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s12 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s13 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s14 = f.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 2);
        String s15 = f.format(new Date(cal.getTimeInMillis()));*/
        String[] expected = {s1, "1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm", "11:00 pm"};
        List<WebElement> allOptions = driver.findElements(GHPORTLET_LABELS);
        for (int i = 0; i <= expected.length - 1; i++) {
            String optionValue = allOptions.get(i).getText();
            Assert.assertEquals(optionValue, expected[i]);
            if (optionValue.equals(expected[i])) {
                System.out.println(expected[i]);
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }

    }

    @Step("Validating Daily option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingDaily() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        // safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_DAILY, "Daily option from Trend Granularity");
        waitForSecs(7);
       /* String text = safeGetText(NTABULAR_LABELS_Daily, "Daily text", 5000);
        System.out.println(text);
        expectedText = "DAILY";
        Assert.assertEquals(text, expectedText);*/
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("d. MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        // cal.add(Calendar.DATE, -29);
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        String expected = s1;
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }

    @Step("Validating Monthly option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingMonthly() throws InterruptedException {
        waitForSecs(7);
        // safeClick(BTN_TREND_GRANULARITY, " Trend Granularity");
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(BTN_MONTHLY, "Monthly option from Trend Granularity");
        waitForSecs(7);
  /*      String text = safeGetText(NTABULAR_LABELS_Monthly, "Monthly text", 5000);
        System.out.println(text);
        expectedText = "MONTHLY";
        Assert.assertEquals(text, expectedText);*/
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        // cal.add(Calendar.MONTH);
        // cal.add(Calendar.DATE, -29);
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        String s2 = f1.format(new Date(cal.getTimeInMillis()));
        String date = s1 + " " + "'" + s2;
        System.out.println(date);
        String expected = date;
        waitForSecs(20);
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }

    @Step("Validating Yearly option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingYEARLY() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        //safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_YEARLY, "Yearly option from Trend Granularity");
      /*  waitForSecs(7);
        String text = safeGetText(NTABULAR_LABELS_yearly, "Yearly text", 5000);
        System.out.println(text);
        expectedText = "YEARLY";
        Assert.assertEquals(text, expectedText);*/
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        waitForSecs(20);
        WebElement allOptions = driver.findElement(LABEL_YEAR);
        String actualText = allOptions.getText();
        Assert.assertEquals(s1, actualText);
    }

    @Step("Validating Minutely option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingMinutely() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        //safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_MINUTE, "Minute option from Trend Granularity");
        waitForSecs(7);
    /*    String text = safeGetAttribute(NTABULAR_LABELS_minutely, "title", "Minute text", 5000);
        System.out.println(text);
        expectedText = "Minutely";
        Assert.assertEquals(text, expectedText);*/
        String[] expected = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"};
        List<WebElement> allOptions = driver.findElements(GHPORTLET_LABELS);
        for (int i = 0; i < allOptions.size() - 1; i++) {
            String optionValue = allOptions.get(i).getText();
            Assert.assertEquals(optionValue, expected[i]);
            if (optionValue.equals(expected)) {
                System.out.println(expected);
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }

    }

    @Step("Validating hours option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingHoursForTablularPortlet() throws InterruptedException {
        waitForSecs(20);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_TODAY, "Today button", MEDIUMWAIT);
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        waitForSecs(7);
        safeJavaScriptClick(BTN_HOURLY, "Hourly option from Trend Granularity", MEDIUMWAIT);
        String text = safeGetAttribute(NTABULAR_LABELS_Hourly, "title", "Hourly text", MEDIUMWAIT);
        System.out.println(text);
        expectedText = "Hourly";
        Assert.assertEquals(text, expectedText);
        String[] expected = {"12:00 AM", "1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM"};
        List<WebElement> allOptions = driver.findElements(TABULAR_PORTLET_HOURLY);
        for (int i = 0; i <= 9; i++) {
            String optionValue = allOptions.get(i).getText();
            Assert.assertEquals(optionValue, expected[i]);
            if (optionValue.equals(expected[i])) {
                System.out.println(expected[i]);
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }

    }

    @Step("Validating Daily option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingDailyForTabular() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(BTN_DAILY, "Daily option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetText(NTABULAR_LABELS_Daily, "Daily text", 5000);
        System.out.println(text);
        expectedText = "DAILY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MM/d");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        String expected = s1;
        WebElement allOptions = driver.findElement(TABULAR_PORTLET_DAILY);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }

    @Step("Validating Monthly option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingMonthlyForTabular() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(BTN_MONTHLY, "Monthly option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetText(NTABULAR_LABELS_Monthly, "Monthly text", 5000);
        System.out.println(text);
        expectedText = "MONTHLY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MM");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        String s2 = f1.format(new Date(cal.getTimeInMillis()));
        String date = s1;
        System.out.println(date);
        String expected = date;
        waitForSecs(20);
        WebElement allOptions = driver.findElement(TABULAR_PORTLET_MONTHLY);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }

    @Step("Validating Yearly option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingYEARLYForTabular() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        //safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_YEARLY, "Yearly option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetText(NTABULAR_LABELS_yearly, "Yearly text", 5000);
        System.out.println(text);
        expectedText = "YEARLY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        waitForSecs(20);
        WebElement allOptions = driver.findElement(TABULAR_PORTLET_YEARLY);
        String actualText = allOptions.getText();
        Assert.assertEquals(s1, actualText);
    }

    @Step("Validating Minutely option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingMinutelyForTAbular() throws InterruptedException {
        waitForSecs(7);
        safeJavaScriptClick(BTN_TREND_GRANULARITY, "Trend granularity button", MEDIUMWAIT);
        //safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_MINUTE, "Minute option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetAttribute(NTABULAR_LABELS_minutely, "title", "Minute text", 5000);
        System.out.println(text);
        expectedText = "Minutely";
        Assert.assertEquals(text, expectedText);
        String[] expected = {"12:00 AM", "12:01 AM", "12:02 AM", "12:03 AM", "12:04 AM", "12:05 AM", "12:06 AM", "12:07 AM", "12:08 AM", "12:09 AM", "12:10 AM", "TOTAL"};
        List<WebElement> allOptions = driver.findElements(TABULAR_PORTLET_MINUTELY);
        for (int i = 0; i < 9; i++) {
            String optionValue = allOptions.get(i).getText();
            Assert.assertEquals(optionValue, expected[i]);
            if (optionValue.equals(expected)) {
                System.out.println(expected);
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }

    }


    public void verifyingMaximizeFunctionality() {
        waitForSecs(15);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_MAXIMIZE, "Maximize portlet", MEDIUMWAIT);
        boolean b = isElementDisplayed(BTN_RESTORE);
        Assert.assertTrue(b);
        safeClick(BTN_RESTORE, "Restore portlet", MEDIUMWAIT);
    }

    public void verifyingRestoreFunctionality() {
        waitForSecs(15);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_MAXIMIZE, "Maximize portlet", MEDIUMWAIT);
        safeClick(BTN_RESTORE, "Maximize portlet", MEDIUMWAIT);
        boolean b = isElementDisplayed(BTN_MAXIMIZE);
        Assert.assertTrue(b);

    }

    @Step("Adding Gauge Portlet")
    public void addingGaugePortletForAllThenavgations(String gaugePortletName) throws InterruptedException {
        waitForSecs(10);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitForSecs(10);
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
     /*   waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");*/
        waitUntilClickable(GAUGE_HEADER, "Gauge header in Portlet Interface", MEDIUMWAIT);
        safeClick(GAUGE_HEADER, "Gauge header in Portlet Interface", MEDIUMWAIT);
        safeClick(DROPDOWN_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeClearAndType(GAUGE_TEXTBOX_KPI, "User Click", "Sending the text", VERYLONGWAIT);
        Thread.sleep(3000);
/*        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(GAUGE_TEXTBOX_KPI);
        searchField2.sendKeys(del2 + "User Click");*/
        List<WebElement> kpis = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println(kpis.get(i).getText());
            if (kpis.get(i).getText().equalsIgnoreCase("User Click")) {
                kpis.get(i).click();
                break;
            }
        }
        safeClick(GAUGE_PORTLET_NAME, "Portlet Name field in Gauge portlet Interface");
        safeClearAndType(TEXTBOX_PORTLET,gaugePortletName,"Gauge Portlet",MEDIUMWAIT);
/*        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + gaugePortletName);*/
        safeClick(GAUGE_TEXTBOX_MEASURE, "Measure field", MEDIUMWAIT);
        safeType(GAUGE_TEXTBOX_MEASURE, "Avg Color Threshold", "Enter Measure", MEDIUMWAIT);
        List<WebElement> measures = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < measures.size(); i++) {
            System.out.println(measures.get(i).getText());
            if (measures.get(i).getText().equalsIgnoreCase("Avg Color Threshold")) {
                measures.get(i).click();
                break;
            }
        }
        String deleteDecimalPlaces = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement decimalPlacesField = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        decimalPlacesField.sendKeys(deleteDecimalPlaces + 2);
        waitForSecs(20);
       /* safeJavaScriptClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        // safeClick(TEXTBOX_PORTLET_FILTERS, "Portlet filters field", MEDIUMWAIT);
        waitForSecs(20);
        safeJavaScriptClick(PortletFilters_TypeSearch, "Entering Text into type search", MEDIUMWAIT);
        safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");
        safeJavaScriptClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        safeJavaScriptClick(DROPDOWN_VALUE,"Apply filters text",MEDIUMWAIT);
        safeJavaScriptClick(LABEl_IS,"Is label",MEDIUMWAIT);
        safeJavaScriptClick(SELECT_DRPDOWN,"is not",MEDIUMWAIT);
        // safeClick(IS_NOT_PORTLET_FILTER, "Changing to negation filter", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_APPLY, "Apply button in Portlet Filters", MEDIUMWAIT);
        waitForSecs(5);
        System.out.println("Filter in Portlet Filters is " + driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value"));
        appliedFilter = driver.findElement(TEXTBOX_PORTLET_FILTERS).getAttribute("value");*/
        safeClick(BTN_ADD_PORTLET, "Add portlet button", MEDIUMWAIT);
    }

}


