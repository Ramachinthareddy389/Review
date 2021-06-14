package com.page.locators;

import org.openqa.selenium.By;

public interface PivotLocators {

    //Table Portlet in Pivot page
    By PORTELT_NAME_FIELD = By.xpath("//label[contains(@for,'name-table')]");
    By PORTLET_NAME_FIELD_INPUT = By.xpath("//input[contains(@id,'name-table')]");
    By PIVOT_FIELD = By.xpath("//label[contains(@for,'pivot-table')]");
    By PIVOT_FIELD_INPUT = By.xpath("//input[contains(@id,'pivot-table')]");
    By ADD_PORTLET_PIVOT = By.xpath("//button/span[contains(text(),'Add')]");
    By MEASURE_FIELD = By.xpath("//label[contains(@for,'measures-table')]");
    By MEASURE_FIELD_INPUT = By.xpath("//input[contains(@id,'measures-table')]");
    By MEASURE_DATA_PORTLET = By.xpath("//label[contains(@for,'measures-table')]/../div/div");

    //Chart Portlet in Pivot page
    By CHART_TAB_PIVOT_PAGE = By.xpath("//button/span[contains(text(),'Chart')]");
    By CHART_PORTELT_NAME_FIELD = By.xpath("//label[contains(@for,'name-chart')]");
    By CHART_PORTLET_NAME_FIELD_INPUT = By.xpath("//input[contains(@id,'name-chart')]");
    By CHART_PIVOT_FIELD = By.xpath("//label[contains(@for,'pivot-chart')]");
    By CHART_PIVOT_FIELD_INPUT = By.xpath("//input[contains(@id,'pivot-chart')]");
    By CHART_MEASURE_FIELD = By.xpath("//label[contains(@for,'measures-chart')]/../div");
    By CHART_MEASURE_INPUT = By.xpath("//input[contains(@id,'measures-chart')]");
    By CHART_TYPE_FIELD = By.xpath("//label[contains(@for,'type')]/../div");
    By CHART_TYPE_INPUT = By.xpath("//input[contains(@id,'type')]");
    By SHOW_CHART_LEGEND_CHECKBOX = By.xpath("//span[contains(text(),'Show Chart Legend')]");
    By UPDATE_PORTLET_PIVOT = By.xpath("//button/span[contains(text(),'Update')]");
}
