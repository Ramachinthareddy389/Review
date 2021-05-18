package com.page.module;

import com.page.locators.DashBoardLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class DashboardPage extends SafeActions implements DashBoardLocators {
    private WebDriver driver;
    Random random = new Random();
    String dname = "May2021";
    String dname1 = dname + random.nextInt(500);
    String expectedText = "Create" + " May2021129" + "";
    static int j;


    //Constructor to define/call methods
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("To enter the required fields for creating a new Dashboard and click on Finish button")
    public void enterAddrequirefeildsInDashBoardPage() throws InterruptedException {
        safeType(TEXTBOX_DASHBOARD_WINDOW, dname1, "Enter the dashboard name in textbox", MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(LISTBOX_Folder, "foldername", MEDIUMWAIT);
        Thread.sleep(5000);
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
        waitUntilClickable(By.xpath("//div[contains(@class,'MuiListItem-button')][@id='react-select-2-option-0']"), "text", 5000);
        for (int i = 0; i < kpi1.size(); i++) {

            if (kpi1.get(i).getText().contains("Dashboards")) {

                kpi1.get(i).click();
                break;
            }
        }

        waitForPageToLoad();
        System.out.println("Before finish");
        safeClick(BUTTON_FINISH, "Clicked on Finish button in Dashboard window", MEDIUMWAIT);
        System.out.println("after finish");
        safeClick(BUTTON_CLOSE, "Clicked on close button in Dashboard window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname1);

    }

    @Step("Pin Dashboard")
    public void PinDashboard() throws InterruptedException{
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(PIN_DASHBOARD, "text", 5000);
        safeClick(PIN_DASHBOARD, "Pin Dashboard", MEDIUMWAIT);
        Thread.sleep(5000);
        By pinnedDashboard=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]/../../following-sibling::div/div/a/span/span[contains(text(),'"+dname1+"')]");
        WebElement pinnedDashboardElement = driver.findElement(pinnedDashboard);
        Boolean pinnedDashboard_Visibility = pinnedDashboardElement.isDisplayed();
        System.out.println("Dashboard is visible: "+pinnedDashboard_Visibility);
        Assert.assertTrue(pinnedDashboard_Visibility,"Pinned Dashboard is displayed");
        safeClick(pinnedDashboard,"Clicking on pinned Dashboard in side menu",MEDIUMWAIT);
    }
    @Step("Unpin Dashboard")
    public void Unpin_Pin_Dashboard_FromDashboardPage() throws InterruptedException{
        Boolean flag=false;
        waitForPageToLoad();
        safeClick(UNPIN_DASHBOARD, "Unpin Dashboard", MEDIUMWAIT);
        Thread.sleep(5000);
        By pinnedDashboard=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]/../../following-sibling::div/div/a/span/span[contains(text(),'"+dname1+"')]");
        try {
            driver.findElement(pinnedDashboard).isDisplayed();
            flag = true;
        }
        catch (Exception e){
            e.getMessage();
        }
        if(flag)
            Assert.fail("Pinned Dashboard is still displayed");
        System.out.println("Unpinned Dashboard Verification is completed in Dashboard page");
        safeClick(PIN_DASHBOARDPAGE, "Pin Dashboard from Dashboard page", MEDIUMWAIT);
        Thread.sleep(5000);
        WebElement pinnedDashboardElement = driver.findElement(pinnedDashboard);
        Boolean pinnedDashboard_Visibility = pinnedDashboardElement.isDisplayed();
        System.out.println("Dashboard is visible: "+pinnedDashboard_Visibility);
        Assert.assertTrue(pinnedDashboard_Visibility,"Pinned Dashboard is displayed");
    }
}