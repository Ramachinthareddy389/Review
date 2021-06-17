package com.page.module;

import com.page.locators.DashBoardLocators;
import com.page.locators.OperationalLocators;
import com.selenium.SafeActions;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OperationalPage extends SafeActions implements OperationalLocators {
    private WebDriver driver;



    //Constructor to define/call methods
    public OperationalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Clicking on Operational button")
    public void clickingOperationButton()
    {
     safeClick(BUTTON_OPERATIONAL,"Operational ICon",MEDIUMWAIT);
    }

    @Step("validatingDrillthroughUsingOperational")
    public void validatingDrillthroughUsingOperational()
    {
        waitForSecs(8);
        boolean b=driver.findElements(TRENDCHARTS).get(1).isDisplayed();
        System.out.println(b);
        driver.findElements(ICONS_DRILLTHROUGH).get(1).click();
        driver.findElements(ICONS_DRILLTHROUGH).get(1).click();

        driver.findElements(ICONS_RAWINSTANCES).get(1).click();

        }
    }

