package com.page.module;

import com.page.locators.DashBoardLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import java.util.Random;


public class DashBoardPage extends SafeActions implements DashBoardLocators {
    private WebDriver driver;
    Random random=new Random();

    //Constructor to define/call methods
    public DashBoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Step("Verifying home page")
    public void verifyDashBoardOverviewPage(String dashboard, String all) {
        boolean bIsdashboardExists = isElementPresent(Dynamic.getNewLocator(DASHBOARd_MODULE, dashboard), MEDIUMWAIT);
        boolean bIsallExists = isElementPresent(Dynamic.getNewLocator(All_FOLDER, all), MEDIUMWAIT);

        //  boolean bIsLabelNewDashboardExists = isElementPresent(Dynamic.getNewLocator(LABEL_NEW_DASHBOARD, LabelNewDashboard), MEDIUMWAIT);
        Assert.assertTrue(bIsdashboardExists || bIsallExists, "Dashboard/All Folder//addDashboardButon/LabelNewDashboard fields is not being displayed on ' Home' page");
    }

    @Step("To click on 'Dashboard' and click on 'All' button")
    public void addingNewDashboard() {
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);

        safeJavaScriptClick(BUTTON_ADD_DASHBOARD, "Add button ondashboards section", MEDIUMWAIT);
        safeClick(LABEL_NEW_DASHBOARD, "All folder on dashboards section ", MEDIUMWAIT);
    }


    @Step("To enter the required fields for creating a new Dashboard and click on Finish button")
    public void enterAddrequirefeildsInDashBoardPage(String dname) throws InterruptedException{
       String dname1= dname+random.nextInt(500);
        safeType(TEXTBOX_DASHBOARD_WINDOW, dname1, "Enter the dashboard name in textbox", MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(LISTBOX_Folder, "foldername", MEDIUMWAIT);
        waitForPageToLoad();
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        waitUntilClickable(By.xpath("//div[contains(@class,'MuiListItem-button')][@id='react-select-2-option-0']"),"text",5000);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
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
            safeType(TEXTBOX_TYPESEARCH,dname1+ "\n","Enter dashboard into type search");
            System.out.println("entered dbtext");
            String actualText= safeGetText(LISTOFDASHBOARDS,"dashboardname",MEDIUMWAIT);
            System.out.println(actualText);
            Assert.assertEquals(actualText,dname1);
    }
    @Step("Logout the application")
        public void signOut(){
            safeClick(USERICON,"Clicking on user icon",MEDIUMWAIT);
            safeClick(LOGOUT,"Click on Logout",MEDIUMWAIT);
        }

    }


