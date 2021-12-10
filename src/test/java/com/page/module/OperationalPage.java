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
import java.util.NoSuchElementException;

public class OperationalPage extends SafeActions implements OperationalLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();


    //Constructor to define/call methods
    public OperationalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Clicking on Operational button")
    public void clickingOperationButton() {
        safeClick(BUTTON_OPERATIONAL, "Operational ICon", MEDIUMWAIT);
        waitForSecs(2);
    }

    @Step("validatingDrillthroughUsingOperational")
    public void validatingPivotPageUsingOperational() {
        waitForSecs(15);
        boolean b = driver.findElements(TRENDCHARTS).get(1).isDisplayed();
        System.out.println(b);
        String AppName = driver.findElements(APP_NAMES).get(0).getText();
        System.out.println(AppName);
        waitForSecs(10);
        driver.findElements(ICONS_DRILLTHROUGH).get(1).click();
        String kpi = driver.findElements(KPINAMES).get(0).getText();
        System.out.println(kpi);
        driver.findElements(ICONS_PIVOTINSTANCES).get(0).click();
        String text = safeGetText(Title_DRILLTHROUGH, "Page title for Drillthrough", MEDIUMWAIT);
        System.out.println(text);
        Assert.assertEquals(text, dashBoardData.pivot_DrillthroughPage + " " + kpi);
        String appNameInPivot = safeGetText(APPNAME_IN_PIVOT, "Application Name", MEDIUMWAIT);
        System.out.println(appNameInPivot);
        String expectedText1 = "Application Name" + " " + "is" + " " + appNameInPivot;
        String actulaText1 = "Application Name" + " " + "is" + " " + kpi;
        Assert.assertEquals(expectedText1, actulaText1);


    }

    public void validatingDrillthroughPageUsingOprtaional(){
       waitForSecs(10);
        boolean b1 = driver.findElements(TRENDCHARTS).get(1).isDisplayed();
        System.out.println(b1);
        String AppName1 = driver.findElements(APP_NAMES).get(0).getText();
        System.out.println(AppName1);
        waitForSecs(10);
        driver.findElements(ICONS_DRILLTHROUGH).get(1).click();
        String kpi1 = driver.findElements(KPINAMES).get(0).getText();
        System.out.println(kpi1);
        driver.findElements(ICONS_RAWINSTANCES).get(0).click();
        safeClick(BTN_CLEAR,"Clear button",MEDIUMWAIT);
        String text1 = safeGetText(Title_DRILLTHROUGH, "Page title for Drillthrough", MEDIUMWAIT);
        System.out.println(text1);
        waitForSecs(10);
        Assert.assertEquals(text1, dashBoardData.drillthrghpage + " " + kpi1);
        String appNameIndrilthrgh = safeGetText(APPNAME_IN_DRILLTHROUGH, "Application Name", MEDIUMWAIT);
        System.out.println(appNameIndrilthrgh);
        String expectedText = "Application Name" + " " + "is" + " " + appNameIndrilthrgh;
        String actulaText = "Application Name" + " " + "is" + " " + kpi1+"s";
        Assert.assertEquals(expectedText, actulaText);
        waitForSecs(15);

    }



    @Step("Verify count of KPI in Data Graph window and Pivot/Drillthrough page")
    public void validatingCountOfKPI() {
        waitForSecs(15);
        boolean b = driver.findElements(TRENDCHARTS).get(2).isDisplayed();
        System.out.println(b);
        driver.findElements(ICONS_DRILLTHROUGH).get(2).click();
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
        String countInPivotPage = safeGetText(COUNT_IN_PIVOT_DRILLTHRHPAGE, "Count in pivot drillthrough page", MEDIUMWAIT);
        String expectedText = "Count" + " " + countInPivotPage + " ";
        Assert.assertEquals(str, expectedText);
    }

    public void navigateToAppComponentsTab() {
        waitForSecs(10);
        safeClick(TAB_APP_COMPONENTS, "App Components tab", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void validatingDataAvailabilityInAppComponentsTab() {
        waitForSecs(20);
        try {
            By err = By.xpath("//i[contains(@class,'fas fa-exclamation-triangle')]");
            Assert.assertEquals(0, driver.findElements(err).size());
            if (!driver.findElement(TRENDCHARTS).isDisplayed())
                Assert.fail("Data is not displayed properly in Operational page");
            Assert.assertEquals(0, driver.findElements(NO_DATA_AVAILABLE).size());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }


    public void navigateToDatabaseTab() {
        waitForSecs(10);
        safeClick(TAB_DATABASES, "App Components tab", MEDIUMWAIT);
        waitForSecs(10);
    }
}