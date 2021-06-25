package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.DashBoardLocators;
import com.page.locators.OperationalLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OperationalPage extends SafeActions implements OperationalLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData=new DashBoardData();


    //Constructor to define/call methods
    public OperationalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Clicking on Operational button")
    public void clickingOperationButton()
    {

        safeClick(BUTTON_OPERATIONAL,"Operational ICon",MEDIUMWAIT);
        safeClick(BUTTON_OPERATIONAL,"Operational ICon",MEDIUMWAIT);
    }

    @Step("validatingDrillthroughUsingOperational")
    public void validatingDrillthroughUsingOperational() {
        waitForSecs(15);
        boolean b = driver.findElements(TRENDCHARTS).get(1).isDisplayed();
        System.out.println(b);
        String AppName = driver.findElements(APP_NAMES).get(0).getText();
        System.out.println(AppName);
        driver.findElements(ICONS_DRILLTHROUGH).get(1).click();
        String kpi = driver.findElements(KPINAMES).get(0).getText();
        System.out.println(kpi);
        driver.findElements(ICONS_RAWINSTANCES).get(0).click();
        String text = safeGetText(Title_DRILLTHROUGH, "Page title for Drillthrough", MEDIUMWAIT);
        System.out.println(text);
        Assert.assertEquals(text, dashBoardData.drillthrghpage + " " + kpi);
        String appNameIndrilthrgh = safeGetText(APPNAME_IN_DRILLTHROUGH, "Application Name", MEDIUMWAIT);
        System.out.println(appNameIndrilthrgh);
        String expectedText = "Application Name" + " " + "is" + " " + appNameIndrilthrgh;
        String actulaText="Application Name" + " " + "is" + " "+AppName;
        Assert.assertEquals(expectedText,actulaText);
    }

    @Step("Verify count of KPI in Data Graph window and Pivot/Drillthrough page")
    public void validatingCountOfKPI() {
        waitForSecs(15);
        boolean b = driver.findElements(TRENDCHARTS).get(1).isDisplayed();
        System.out.println(b);
        driver.findElements(ICONS_DRILLTHROUGH).get(1).click();
        String kpi = driver.findElements(KPINAMES).get(0).getText();
        System.out.println(kpi);
        safeType(FILTERSKPISTEXTBOX, kpi, "KPI Name", MEDIUMWAIT);
        mouseHoverJScript(KPINAMES, "Searching", "KPI Name", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> li = driver.findElements(KPI_TOOLTIP);
        String str = "";
        for (int i = 0; i < li.size(); i++) {
            str = str + li.get(i).getText() + " ";
        }
        System.out.println(str);
        driver.findElements(ICONS_PIVOTINSTANCES).get(0).click();
        String text = safeGetText(Title_DRILLTHROUGH, "Page title for Drillthrough", MEDIUMWAIT);
        System.out.println(text);
        Assert.assertEquals(text, dashBoardData.pivot_DrillthroughPage + " " + kpi);
        String countInPivotPage=safeGetText(COUNT_IN_PIVOT_DRILLTHRHPAGE,"Count in pivot drillthrough page",MEDIUMWAIT);
        String expectedText="Count"+" "+countInPivotPage+" ";
        Assert.assertEquals(str,expectedText);
    }

    }

