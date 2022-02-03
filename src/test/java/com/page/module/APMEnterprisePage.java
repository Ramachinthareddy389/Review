package com.page.module;

import com.opencsv.CSVReader;
import com.page.locators.APMEnterpriseLocators;
import com.page.locators.ApmStateLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class APMEnterprisePage extends SafeActions implements APMEnterpriseLocators {
    private WebDriver driver;
    String dname = "HttpScenario";
    Random random = new Random();
    String dname1 = dname + random.nextInt(1500);
    String dnameEdit = "Httpedit" + random.nextInt(1500);
    String Server_add, AppName_add, Cred_add, Component_add, Edit_Server_add, Edit_MonitorName_add, Edit_App_add;
    String downloadPath;
    public APMEnterprisePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void navigateToAPMPage(){
        waitForSecs(10);
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
    }
    public  void verifyingNavigateToEnterpriseTab(){
        try {
            if (!isElementDisplayed(INSTANCE_COLUMN)) {
             safeClick(ENTERPRISE_TAB,"Enterprise tab");
                Assert.assertTrue(isElementDisplayed(ENTERPRISE_TAB));
            }
            Assert.assertTrue(isElementDisplayed(ENTERPRISE_TAB));
        }catch (Exception e){

        }

    }


    public  void navigateToDrirllThroughPageFrmFactsProcessedPortlet(){
           waitForSecs(10);
            safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
            safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
            waitForSecs(10);
            safeType(TYPE_SEARCH, "Hostname", "Enter Text in portlets");
            waitForSecs(10);
            safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
            By SeachedText = By.xpath("//div[contains(text(),'"+"9f6619421afb"+"')]");
            mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
            driver.findElement(SeachedText).click();
            mouseHoverJScript(HOSTNAME_VALUE, "Databse Name", "Mouse hover", MEDIUMWAIT);
            safeClick(HOSTNAME_VALUE,"Host name value",MEDIUMWAIT);
            waitForSecs(10);
            safeJavaScriptClick(DRILLTHRUGH_FACT_PROCESSED,"Drill through icon",MEDIUMWAIT);
            waitForSecs(5);
            Assert.assertTrue(isElementDisplayed(TITLE_DRILLTHRUGH_FACT_PROCESSED));
    }



}
