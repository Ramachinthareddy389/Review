package com.page.module;

import com.page.locators.DashBoardLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.openqa.selenium.interactions.Action;


public class DashboardOverviewPage extends SafeActions implements DashBoardLocators {
    private WebDriver driver;
    Random random = new Random();
    String dname = "Filters";
    String dname1 = dname + random.nextInt(500);
    String expectedText = "Create" + " May2021129" + "";
    static int j;


    //Constructor to define/call methods
    public DashboardOverviewPage(WebDriver driver) {
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
    public void enterAddrequirefeildsInDashBoardPage() throws InterruptedException {
       // String dname1 = dname + random.nextInt(500);
        safeType(TEXTBOX_DASHBOARD_WINDOW, dname1, "Enter the dashboard name in textbox", MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(LISTBOX_Folder, "foldername", MEDIUMWAIT);
        Thread.sleep(15000);
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
        Thread.sleep(15000);
        System.out.println("after finish");
        safeClick(BUTTON_CLOSE, "Clicked on close button in Dashboard window", MEDIUMWAIT);
        Thread.sleep(7000);
    }

    @Step("Adding dashbaord")
    public void addingdashboard() throws InterruptedException {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        Thread.sleep(9000);
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname1);
    }

    @Step("Adding Folder")
    public void addingFolder() throws InterruptedException {
        safeType(TEXTBOX_TYPESEARCH, "Dashboards > " + dname1 + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        Thread.sleep(7000);
        String actualText = safeGetText(COLUMN_FOLDER, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Dashboards > " + dname1);

    }


    @Step("Logout the application")
    public void signOut() {
        waitForPageToLoad();
        safeClick(USERICON, "Clicking on user icon", MEDIUMWAIT);
        safeClick(LOGOUT, "Click on Logout", MEDIUMWAIT);
    }

    @Step("Removing dashboard")
    public void removingDashboard() {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(FOLDER_DELETE, "text", 5000);
        safeClick(FOLDER_DELETE, "Click remove button", MEDIUMWAIT);
        safeClick(BUTTON_REMOVE, "Clicking remove button", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        mouseHoverJScript(COLUMN_FOLDER, "text", "mouse", MEDIUMWAIT);
        safeClick(BUTTON_ADDFOLDER, "adding folder", MEDIUMWAIT);
        waitUntilClickable(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]"), "text", 5000);
        safeClick(TEXTBOX_CHOSE_DASHBOARD, "Clicking on select or create dashboard textbox", MEDIUMWAIT);
        driver.findElement(By.xpath("//*[@id='dashboardKey']")).sendKeys(dname1, Keys.ENTER);
        waitUntilClickable(DASHBOARD_LABEL, "waiting for element", MEDIUMWAIT);
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
        for (int i = 0; i < kpi1.size(); i++) {

            if (kpi1.get(i).getText().contains(dname1)) {

                String actualText = kpi1.get(i).getText();
                System.out.println(actualText);
                Assert.assertEquals(actualText, dname1);
                kpi1.get(i).click();
                break;
            } else {
                System.out.println("Created dashboard is not displaying in dropdown list");
                Assert.assertTrue(false);

            }

        }

        safeClick(BUTTON_CANCEL, "Clicking on cancel button", MEDIUMWAIT);

    }

    @Step("Deleting dashboard from the application")
    public void deletingDashboard() throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(FOLDER_DELETE, "text", 5000);
        safeClick(FOLDER_DELETE, "Click remove button", MEDIUMWAIT);
        waitUntilClickable(BUTTON_DELETE, "wait delete button clciked", MEDIUMWAIT);
        safeClick(BUTTON_DELETE, "Clicking remove button", MEDIUMWAIT);
        Thread.sleep(20000);
        waitUntilElementDisappears(BUTTON_DELETE, "disaapers", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        mouseHoverJScript(COLUMN_FOLDER, "text", "mouse", MEDIUMWAIT);
        safeClick(BUTTON_ADDFOLDER, "adding folder", MEDIUMWAIT);
        waitUntilClickable(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]"), "text", 5000);
        safeClick(TEXTBOX_CHOSE_DASHBOARD, "Clicking on select or create dashboard textbox", MEDIUMWAIT);
        driver.findElement(By.xpath("//*[@id='dashboardKey']")).sendKeys(dname1, Keys.ENTER);
        waitUntilClickable(DASHBOARD_LABEL, "waiting for element", MEDIUMWAIT);
        String actualText = safeGetText(DASHBOARD_LABEL, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        String expectedText = "Create" + " " + "\"" + dname1 + "\"";
        Assert.assertEquals(actualText, expectedText);
        safeClick(DASHBOARD_LABEL, "Clicking on select or create dashboard textbox", MEDIUMWAIT);
        safeClick(BUTTON_CANCEL, "Clicking on cancel button", MEDIUMWAIT);
    }

    @Step("Renaming dashboard from the application")
    public void renamingDashboard() throws InterruptedException {
        safeClick(LISTOFDASHBOARDS, "Clicking on Dashboard", MEDIUMWAIT);
        waitUntilClickable(ICON_RENAME, "Waiting for rename icon is displayed");
        safeClick(ICON_RENAME, "Clicking on Rename icon", MEDIUMWAIT);
        waitUntilClickable(TEXTBOX_RENAMEDASHBRD, "Waiting for Dashboard textbox is displayed to enter rename");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_RENAMEDASHBRD);
        searchField.sendKeys(del + dname1 + 123);
        waitUntilClickable(BUTTON_RENAME, "Waiting for rename button is clickable in rename dash board window");
        safeClick(BUTTON_RENAME, "Clicking on Rename button ");
        Thread.sleep(5000);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + 123 + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname1 + 123);
    }


//Dashboard Cloning

    public int getRownumByText(String FolderName) {
        List<WebElement> dbrows = driver.findElements(By.xpath("//div[@class='jss2025']"));
        System.out.println("Total rows %%%%%%%%%%%%%%%% " + dbrows.size());
        for (int i = 0; i <= dbrows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//div[@class='jss2025'][" + i + "]/div[1]/div/div/span/div/div/span"));
            String sFolderName = row.getText();
            if (sFolderName == FolderName) {
                j = i;

            }
        }
        return j;

    }


    public By dashboardLocator(String FolderName) {

        return By.xpath("//div[@class='jss2025'][" + getRownumByText(FolderName) + "]/div[3]/div/div/span/div/div/span");

    }

    @Step("To click on 'Dashboard' > 'All' ")
    public void ClickAll() throws InterruptedException {
        Thread.sleep(7000);
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        Thread.sleep(5000);
    }

    @Step("CloneDashboard")
    public void CloneDashboard(String DBname) throws InterruptedException {
        Thread.sleep(5000);
        safeType(DB_SEARCH, DBname, "Enter dashboard into type search");
        driver.findElement(DB_SEARCH).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        // mouseHoverJScript(OPT_DB_DISPLAY_NAME,"Clone PArent","clone Parent",MEDIUMWAIT);
        //safeJavaScriptClick(OPT_DB_DISPLAY_NAME, "dashboard display name option", MEDIUMWAIT);
        String locator = "//span[text()='" + DBname + "']/parent::div";
        By CLONE_PARENT = By.xpath(locator);
        safeClick(CLONE_PARENT, "CloneParent dashboard", MEDIUMWAIT);
        safeClick(ICON_CLONE, "clone icon", MEDIUMWAIT);
        //Generating random number and converting to string to append with cloned dashboard
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String ran = String.valueOf(rand_int1);
        for (int i = 0; i <= 30; i++) {
            driver.findElement(CLONE_DB_NAME).sendKeys(Keys.BACK_SPACE);
        }
        safeClearAndType(CLONE_DB_NAME, "Child" + ran, "Dashboard Name", MEDIUMWAIT);
        Thread.sleep(10000);
        safeClick(BTN_CLONE, "clone icon", MEDIUMWAIT);
        Thread.sleep(10000);
        String childDB = safeGetText(DB_TITLE, "Dashboard Title", MEDIUMWAIT);
        Assert.assertEquals(childDB, "Child" + ran);
    }

    @Step("Hover Dashboard")
    public void HoverDashboard() throws InterruptedException {
        mouseHoverJScript(CLONE_PARENT, "Clone PArent", "clone Parent", MEDIUMWAIT);
        Thread.sleep(5000);
        safeClick(ICON_CLONE, "Clone icon", MEDIUMWAIT);

    }

    @Step("Clone using Hover over Dashboard")
    public void SearchCloneDashboard(String Folder) throws InterruptedException {
  /*      waitForPageToLoad();
        safeType(DB_SEARCH, dname1, "Enter dashboard into type search");
        driver.findElement(DB_SEARCH).sendKeys(Keys.ENTER);
        Thread.sleep(3000);*/
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "Clone Parent", "clone Parent", MEDIUMWAIT);
        String locator = "//span[text()='" + dname1 + "']/parent::div";
        By CLONE_PARENT = By.xpath(locator);
        List<WebElement> result1 = driver.findElements(CLONE_PARENT);
        int count1 = result1.size();
        mouseHoverJScript(CLONE_PARENT, "Clone Parent", "clone Parent", MEDIUMWAIT);
        safeClick(ICON_CLONE, "clone icon", MEDIUMWAIT);
        String optXpath = "//div[@role='menuitem' and text()='" + Folder + "']";
        By FOLDER = By.xpath(optXpath);
        waitForPageToLoad();
        safeClick(DIALOG_FOLDER, "Folder Field of Clone Dialogue", VERYLONGWAIT);
        Actions act = new Actions(driver);
        act.sendKeys("1 Folder");
        //safeJavaScriptType(DIALOG_FOLDER,"1 Folder", MEDIUMWAIT);
        safeJavaScriptClick(FOLDER, "dashboard display name option", MEDIUMWAIT);
        safeJavaScriptClick(BTN_CLONE, "dashboard display name option", MEDIUMWAIT);
        waitForPageToLoad();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DIALOGBOX));
        Thread.sleep(5000);
        mouseHoverJScript(CLONE_PARENT, "Clone Parent", "clone Parent", VERYLONGWAIT);
        //Thread.sleep(10000);
        List<WebElement> result2 = driver.findElements(CLONE_PARENT);
        int count2 = result2.size();

        System.out.println("************** c1= " + count1);
        System.out.println("************** c2= " + count2);
        boolean checkclone = count2 > count1;
        Assert.assertTrue(checkclone);
    }


    public void cloningPortlet() throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(TEXT_HEADER, "Clicking on portelt NAme");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + dname1 + 123);
        safeClick(BTN_ADD_PORTLET, "Clicking on add portlet", VERYLONGWAIT);
        Thread.sleep(10000);
        waitUntilClickable(All_FOLDER, "Clicking on add metric link");
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        Thread.sleep(5000);
        safeType(TEXTBOX_TYPESEARCH, dname1 + 123, "Enter the dashboard name in textbox", VERYLONGWAIT);
        WebElement type = driver.findElement(TEXTBOX_TYPESEARCH);
        type.sendKeys(Keys.ENTER);
        Thread.sleep(9000);
        mouseHoverJScript(LIST_PORTLETS, "text", "mouse", MEDIUMWAIT);
        safeClick(CLONE_PORTLET, "Clicking on Clone button from dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(LISTBOX_FOLDER_PORTLET, "foldername", MEDIUMWAIT);
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]//following-sibling::div/div/input")).sendKeys("Dashboards");
        waitUntilClickable(DROPDOWN_DASHBOARD_FOLDER, "waitinf for a element");
        safeClick(DROPDOWN_DASHBOARD_FOLDER, "selecting Dashboard", MEDIUMWAIT);
        safeJavaScriptClick(BTN_CLONE, "dashboard display name option", MEDIUMWAIT);
        Thread.sleep(20000);
        String text = safeGetText(DASHBOARD_COUNT, "getting list of dashboards", MEDIUMWAIT);
        System.out.println(text);
        String expectedText = "(2)";
        Assert.assertEquals(text, expectedText);
    }


    public void addingPortlet() throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(LINK_ADD_METRIC, "Clicking on add metric link");
        safeClick(DROPDWON_KPI, "Clicking on KPI", MEDIUMWAIT);
        safeType(TEXTBOX_KPI, "User Click", "Sending the text", VERYLONGWAIT);
        Thread.sleep(7000);
        List<WebElement> kpi12 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpi12.size(); i++) {
            System.out.println(kpi12.get(i).getText());
            if (kpi12.get(i).getText().equals("User Click")) {
                kpi12.get(i).click();
                break;
            }
        }
        safeClick(TEXT_HEADER, "Clicking on portelt NAme");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + dname1);
        //safeClick(DROPDOWN_SHOWAS,"Clicking on showas dropdown",MEDIUMWAIT);
        WebElement rle = driver.findElement(By.xpath("//*[text()='Show As']/../../../div//div[contains(@class,'body1')]"));
        safeClick(DROPDOWN_SHOWAS, "Clikcing on showas", MEDIUMWAIT);
        safeType(TEXTBOX_SHOWAS, "Trend Chart", "Selecting value from show as dropdown", MEDIUMWAIT);
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
        for (int i = 0; i < kpi1.size(); i++) {

            if (kpi1.get(i).getText().contains("Color Distribution - Trend Chart")) {

                kpi1.get(i).click();
                break;
            }
        }

        safeClick(TEXTBOX_SUMMARY, "Clicking on KPI", MEDIUMWAIT);
        safeType(TEXTBOX_SUMMARY, "Avg Color", "Enter Summary", MEDIUMWAIT);
        safeClick(DROPDOWN_CHARTTYPE, "Clicking on chart type", MEDIUMWAIT);
        Actions a = new Actions(driver);
        a.sendKeys("area");
        List<WebElement> kpi3 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi3.size());
        for (int i = 0; i < kpi3.size(); i++) {

            if (kpi3.get(i).getText().contains("Area")) {

                kpi3.get(i).click();
                break;
            }
        }
        safeClick(DROPDWON_TRENDGRATY, "Clicking on Trend granulaity", MEDIUMWAIT);
        safeType(TEXTBOX_TRENDGRATY, "By Minute", "Entering text into trendgranularity", MEDIUMWAIT);
        List<WebElement> kpi4 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi4.size());
        for (int i = 0; i < kpi4.size(); i++) {

            if (kpi4.get(i).getText().contains("By Minute")) {

                kpi4.get(i).click();
                break;
            }
        }
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TEXTBOX_DECIMAL_PLACES);
        searchField1.sendKeys(del + 5);
        //safeClearAndType(TEXTBOX_DECIMAL_PLACES,"5","Entering values in decimal places",MEDIUMWAIT);
        Thread.sleep(10000);
        //safeJavaScriptClick(TEXTBOX_PORTLET_FILTERS,"Clicking on portlet filters",MEDIUMWAIT);
        //safeClick(PortletFilters_TypeSearch,"Entering Text into typesearch",MEDIUMWAIT);
        // safeType(PortletFilters_TypeSearch, "Color", "Enter Text in portlets");

        // safeClick(DROPDOWN_FEILDS,"Selecting feild",MEDIUMWAIT);
        // driver.findElement(PortletFilters_TypeSearch).sendKeys(Keys.ENTER);
        // safeClick(BTN_APPLY,"Clikcing apply button",MEDIUMWAIT);
        //Thread.sleep(9000);
        safeClick(BTN_ADD_PORTLET, "Adding portlet", MEDIUMWAIT);
        Thread.sleep(15000);
        waitUntilClickable(All_FOLDER, "Clicking on add metric link");
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        Thread.sleep(5000);
        safeType(TEXTBOX_TYPESEARCH, dname1, "Enter the dashboard name in textbox", VERYLONGWAIT);
        WebElement type = driver.findElement(TEXTBOX_TYPESEARCH);
        type.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        mouseHoverJScript(LIST_PORTLETS, "text", "mouse", MEDIUMWAIT);
        String text = safeGetText(LIST_PORTLETS, "Getting Text", MEDIUMWAIT);
        //expectedText="ActiveMQ Heap Usage";
        Assert.assertEquals(text, dname1);

    }

    public void SelectingCalender(String DBname) throws InterruptedException {
        Thread.sleep(5000);
        safeType(DB_SEARCH, DBname, "Enter dashboard into type search");
        driver.findElement(DB_SEARCH).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        // mouseHoverJScript(OPT_DB_DISPLAY_NAME,"Clone PArent","clone Parent",MEDIUMWAIT);
        //safeJavaScriptClick(OPT_DB_DISPLAY_NAME, "dashboard display name option", MEDIUMWAIT);
        String locator = "//span[text()='" + DBname + "']/parent::div";
        By CLONE_PARENT = By.xpath(locator);
        safeClick(CLONE_PARENT, "CloneParent dashboard", MEDIUMWAIT);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
    }

    public void ValidatingCurrentHour() throws InterruptedException {

        safeClick(BTN_CURRENTHOUR, "Clicking on Current Hour");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        int i = Integer.parseInt(date1);
        int morn = i + 1;
        int time = i - 12;
        int time1 = i - 11;
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);
        if (i >= 13) {
            System.out.println("Current date and time is " + date5 + " " + 0 + time + ":" + "00" + " " + "PM" + " " + "-" + date5 + " " + 0 + time1 + ":" + "00" + " " + "PM");
            expectedText = date5 + " " + 0 + time + ":" + "00" + " " + "PM" + " " + "-" + date5 + " " + 0 + time1 + ":" + "00" + " " + "PM";
            Assert.assertEquals(str, expectedText);
            System.out.println("Its working");
        } else {
            System.out.println("Current date and time is " + date5 + " " + i + ":" + "00" + " " + "AM" + " " + "-" + date5 + " " + morn + ":" + "00" + " " + "AM");
        }

    }

    public void validatingLastHour() {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LASTHOUR, "Clicking on Last Hour");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        int i = Integer.parseInt(date1);
        System.out.println(i);
        int time = i - 13;
        int time1 = time + 1;
        System.out.println(time);
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);
        if (i >= 13) {
            System.out.println("Current date and time is " + date5 + " " + 0 + time + ":" + "00" + " " + "PM" + " " + "-" + date5 + " " + 0 + time1 + ":" + "00" + " " + "PM");
            expectedText = date5 + " " + 0 + time + ":" + "00" + " " + "PM" + " " + "-" + date5 + " " + 0 + time1 + ":" + "00" + " " + "PM";
            Assert.assertEquals(str, expectedText);
            System.out.println("Its working");
        } else {

        }
        System.out.println("Current date and time is " + date5 + " " + (i - 1) + ":" + "00" + " " + "AM" + " " + "-" + date5 + " " + i + ":" + "00" + " " + "AM");


    }

    public void validatingBusinessHours(String start, String end) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_BUSINESS_HOURS, "Clicking on Business Hour");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);
        System.out.println("Current date and time is " + date5 + " " + start + " " + "-" + date5 + " " + end);
        String expectedText = date5 + " " + start + " " + "-" + date5 + " " + end;
        Assert.assertEquals(str, expectedText);
    }

    public void validatingLast12hours() {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_Last_12_Hours, "Clicking on Business Hour");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        int i = Integer.parseInt(date1);
        int time = i - 11;
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);
        System.out.println("Current date and time is " + date5 + " " + time + ":" + "00" + " " + "AM" + " " + "-" + date5 + " " + time + ":" + "00" + " " + "PM");
        expectedText = date5 + " " + 0 + time + ":" + "00" + " " + "AM" + " " + "-" + date5 + " " + 0 + time + ":" + "00" + " " + "PM";
        Assert.assertEquals(str, expectedText);
    }


    public void validatingThisMonth(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_THIS_MONTH, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        // cal.add(Calendar.DATE, -6);

        // I just want date before 90 days. you can give that you want.
        SimpleDateFormat s = new SimpleDateFormat("MM"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        SimpleDateFormat s3 = new SimpleDateFormat("yyyy"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s4 = s.format(new Date(cal.getTimeInMillis()));
       String date1= s1+"/01"+s4;
        cal.add(Calendar.DATE, 30);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        String date2=s2+"/01"+s4;
        System.out.println("Current date and time is " + date1 + " " + time + " " + "-" + date2 + " " + time);
        String expectedText = date1 + " " + time + " " + "-" + date2 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    public void validatingLastMonth(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LAST_MONTH, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        // cal.add(Calendar.DATE, -6);

        // I just want date before 90 days. you can give that you want.
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.MONTH, -1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s2 + " " + time + " " + "-" + s1 + " " + time);
        String expectedText = s2 + " " + time + " " + "-" + s1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    public void validatingLast30Days(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LAST_30_DAYS, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        // I just want date before 90 days. you can give that you want.
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, -30);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s2 + " " + time + " " + "-" + s1 + " " + time);
        String expectedText = s2 + " " + time + " " + "-" + s1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    public void validatingToday(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_TODAY, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();


        // I just want date before 90 days. you can give that you want.
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s1 + " " + time + " " + "-" + s2 + " " + time);
        String expectedText = s1 + " " + time + " " + "-" + s2 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    public void validatingYesterday(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_YESTERDAY, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();


        // I just want date before 90 days. you can give that you want.
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, -1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s2 + " " + time + " " + "-" + s1 + " " + time);
        String expectedText = s2 + " " + time + " " + "-" + s1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    public void validatingLast7Days(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LAST_7_DAYS, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 1);
        // I just want date before 90 days. you can give that you want.
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy"); // you can specify your format here...
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, -7);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s2 + " " + time + " " + "-" + s1 + " " + time);
        String expectedText = s2 + " " + time + " " + "-" + s1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }


    public void validatingAbsoluteQa_30Mins(String tsstart, String tsend) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_ABSOLUTECURRENTHOUR_QA_30_MINS, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        System.out.println("Current date and time is " + tsstart + " " + "-" + tsend);
        String expectedText = tsstart + " " + "-" + tsend;
        Assert.assertEquals(str, expectedText);


    }

    public void validatingAbsoluteAllUnits(String tsstart, String tsend) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_ABSOLUTE_ALL_UNITS, "Clicking on Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        System.out.println("Current date and time is " + tsstart + " " + "-" + tsend);
        String expectedText = tsstart + " " + "-" + tsend;
        Assert.assertEquals(str, expectedText);


    }

    public void SearchinDashboard() throws InterruptedException {
        String dashboard = "Required Trend Granularity";
        safeType(TEXTBOX_TYPESEARCH, dashboard + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        Thread.sleep(7000);

    }

    public void validaingTrendGranularityUSingMinutely() throws InterruptedException {
        Thread.sleep(7000);
        safeClick(BTN_TREND_GRANULARITY, "Clicking on Trend Granularity");
        Thread.sleep(7000);
        safeClick(BTN_MINUTE, "Selecting auto option from Trend Granularity");
        Thread.sleep(7000);
        String text = safeGetAttribute(NTABULAR_LABELS_minutely, "title", "Getting the text", 5000);
        System.out.println(text);
        expectedText = "Minutely";
        Assert.assertEquals(text, expectedText);
        String[] expected = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"};
        List<WebElement> allOptions = driver.findElements(GHPORTLET_LABELS);
        for (int i = 0; i < expected.length; i++) {
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


    public void validaingTrendGranularityUSingHours() throws InterruptedException {
        Thread.sleep(7000);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        Thread.sleep(7000);
        safeClick(LISTOFDASHBOARDS, "clicking on Dashboard", MEDIUMWAIT);
        Thread.sleep(15000);
        safeClick(BTN_TREND_GRANULARITY, "Clicking on Trend Granularity");
        Thread.sleep(7000);
        safeClick(BTN_HOURLY, "Selecting auto option from Trend Granularity");
        Thread.sleep(7000);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        Thread.sleep(5000);
        safeClick(BTN_TODAY, "Clicking today button", MEDIUMWAIT);
        Thread.sleep(7000);
        String text = safeGetText(NTABULAR_LABELS_Hourly, "Getting the text", 5000);
        System.out.println(text);
        expectedText = "HOURLY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        String s2 = f1.format(new Date(cal.getTimeInMillis()));
        String date = s2 + "." + " " + s1;
        System.out.println(date);
        String[] expected = {date, "1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm", "11:00 pm"};
        List<WebElement> allOptions = driver.findElements(GHPORTLET_LABELS);
        for (int i = 0; i < expected.length; i++) {
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


    public void validaingTrendGranularityUSingDaily() throws InterruptedException {
        Thread.sleep(7000);
        safeClick(BTN_TREND_GRANULARITY, "Clicking on Trend Granularity");
        Thread.sleep(7000);
        safeClick(BTN_DAILY, "Selecting auto option from Trend Granularity");
        Thread.sleep(7000);
        String text = safeGetText(NTABULAR_LABELS_Daily, "Getting the text", 5000);
        System.out.println(text);
        expectedText = "DAILY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        String s2 = f1.format(new Date(cal.getTimeInMillis()));
        String date = s2 + "." + " " + s1;
        System.out.println(date);
        String expected = date;
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }


    public void validaingTrendGranularityUSingMonthly() throws InterruptedException {
        Thread.sleep(7000);
        safeClick(BTN_TREND_GRANULARITY, "Clicking on Trend Granularity");
        Thread.sleep(7000);
        safeClick(BTN_MONTHLY, "Selecting auto option from Trend Granularity");
        Thread.sleep(7000);
        String text = safeGetText(NTABULAR_LABELS_Monthly, "Getting the text", 5000);
        System.out.println(text);
        expectedText = "MONTHLY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        String s2 = f1.format(new Date(cal.getTimeInMillis()));
        String date = s1 + " " + "'" + s2;
        System.out.println(date);
        String expected = date;
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }

    public void validaingTrendGranularityUSingYEARLY() throws InterruptedException {
        Thread.sleep(7000);
        safeClick(BTN_TREND_GRANULARITY, "Clicking on Trend Granularity");
        Thread.sleep(7000);
        safeClick(BTN_YEARLY, "Selecting auto option from Trend Granularity");
        Thread.sleep(7000);
        String text = safeGetText(NTABULAR_LABELS_yearly, "Getting the text", 5000);
        System.out.println(text);
        expectedText = "YEARLY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(s1, actualText);
    }

    @Step("To click on 'Dashboard' and click on 'All' button")
    public void addingNewFolder() {
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        safeJavaScriptClick(BUTTON_ADD_DASHBOARD, "Add button ondashboards section", MEDIUMWAIT);
        safeClick(LABEL_NEW_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
    }


}