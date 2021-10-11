package com.page.module;

import com.page.locators.DashBoardLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class DashboardOverviewPage extends SafeActions implements DashBoardLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    static int j;

    Random random = new Random();
    String dname = "Dboverview";
    String dname1 = dname + random.nextInt(1500);

    //Constructor to define/call methods
    public DashboardOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Step("Verifying home page")
    public void verifyDashBoardOverviewPage(String dashboard, String all) {
        boolean bIsdashboardExists = isElementPresent(Dynamic.getNewLocator(DASHBOARD_MODULE, dashboard), MEDIUMWAIT);
        boolean bIsallExists = isElementPresent(Dynamic.getNewLocator(All_FOLDER, all), MEDIUMWAIT);
        Assert.assertTrue(bIsdashboardExists || bIsallExists, "Dashboard/All Folder//addDashboardButon/LabelNewDashboard fields is not being displayed on ' Home' page");
    }

    @Step("To click on 'Dashboard' and click on 'All' button")
    public void addingNewDashboard() {
        safeClick(DASHBOARD_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        safeJavaScriptClick(BUTTON_ADD_DASHBOARD, "Add button on dashboards section", MEDIUMWAIT);
        safeClick(LABEL_NEW_DASHBOARD, "All folder on dashboards section ", MEDIUMWAIT);
    }


    @Step("To enter the required fields for creating a new Dashboard and click on Finish button")
    public void enterAddrequirefeildsInDashBoardPage() throws InterruptedException {
        safeType(TEXTBOX_DASHBOARD_WINDOW, dname1, "Dashboard name in textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LISTBOX_Folder, "Folder", MEDIUMWAIT);
        safeClick(FOLDER_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TEXTBOX_Folder, "Dashboards", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + dbs.size());
        for (int i = 0; i < dbs.size(); i++) {

            if (dbs.get(i).getText().contains("Dashboards")) {

                dbs.get(i).click();
                break;
            }
        }

        waitForSecs(10);
        System.out.println("Before finish");
        safeClick(BUTTON_FINISH, "Finish button in Dashboard window", MEDIUMWAIT);
        waitForSecs(10);
        System.out.println("after finish");
        safeClick(BUTTON_CLOSE, "Close button in Dashboard window", MEDIUMWAIT);
        waitForSecs(20);
    }

    @Step("Adding dashbaord in Dashboard overview page")
    public void searchingDashboard() throws InterruptedException {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Dashboard Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(10);
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboard name", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname1);
    }

    @Step("Adding Folder in Dashboard overview Page")
    public void addingFolder() throws InterruptedException {
        safeType(TEXTBOX_TYPESEARCH, "Dashboards > " + dname1 + "\n", "Dashboard into type search");
        System.out.println("entered db text");
        waitForSecs(5);
        String actualText = safeGetText(COLUMN_FOLDER, "dashboard name", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Dashboards > " + dname1);

    }

    @Step("Removing dashboard from Dashboard overview page")
    public void removingDashboard() {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(FOLDER_DELETE, "text", 5000);
        safeClick(FOLDER_DELETE, "Remove button from folder", MEDIUMWAIT);
        safeClick(BUTTON_REMOVE, "Remove button", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        mouseHoverJScript(COLUMN_FOLDER, "text", "mouse", MEDIUMWAIT);
        safeClick(BUTTON_ADDFOLDER, "Add folder", MEDIUMWAIT);
        waitUntilClickable(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]"), "text", 5000);
        safeClick(TEXTBOX_CHOSE_DASHBOARD, "Select or create dashboard text box", MEDIUMWAIT);
        driver.findElement(By.xpath("//*[@id='dashboardKey']")).sendKeys(dname1, Keys.ENTER);
        waitUntilClickable(DASHBOARD_LABEL, "waiting for element", MEDIUMWAIT);
        List<WebElement> dbs = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + dbs.size());
        for (int i = 0; i < dbs.size(); i++) {

            if (dbs.get(i).getText().contains(dname1)) {

                String actualText = dbs.get(i).getText();
                System.out.println(actualText);
                Assert.assertEquals(actualText, dname1);
                dbs.get(i).click();
                break;
            } else {
                System.out.println("Created dashboard is not displaying in dropdown list");
                Assert.assertTrue(false);

            }

        }

        safeClick(BUTTON_CANCEL, "Cancel button", MEDIUMWAIT);

    }

    @Step("Deleting dashboard from the application ")
    public void deletingDashboard() throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(FOLDER_DELETE, "text", 5000);
        safeClick(FOLDER_DELETE, "Remove button from folder", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BUTTON_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(40);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        mouseHoverJScript(COLUMN_FOLDER, "text", "mouse", MEDIUMWAIT);
        safeClick(BUTTON_ADDFOLDER, "Add folder", MEDIUMWAIT);
        waitUntilClickable(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]"), "text", 5000);
        safeClick(TEXTBOX_CHOSE_DASHBOARD, "Select or create dashboard text box", MEDIUMWAIT);
        driver.findElement(By.xpath("//*[@id='dashboardKey']")).sendKeys(dname1, Keys.ENTER);
        String actualText = safeGetText(DASHBOARD_LABEL, "dashboard name", MEDIUMWAIT);
        System.out.println(actualText);
        String expectedText = "Create" + " " + "\"" + dname1 + "\"";
        Assert.assertEquals(actualText, expectedText);
        safeClick(DASHBOARD_LABEL, "Select or create dashboard text box", MEDIUMWAIT);
        safeClick(BUTTON_CANCEL, "Cancel button", MEDIUMWAIT);
    }

    @Step("Renaming dashboard from the  Dashboard overview page")
    public void renamingDashboard() throws InterruptedException {
        safeClick(LISTOFDASHBOARDS, "Dashboard", MEDIUMWAIT);
        waitUntilClickable(ICON_RENAME, "Waiting for rename icon is displayed");
        safeClick(ICON_RENAME, "Rename icon", MEDIUMWAIT);
        waitUntilClickable(TEXTBOX_RENAMEDASHBRD, "Waiting for Dashboard textbox is displayed to enter rename");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_RENAMEDASHBRD);
        searchField.sendKeys(del + dname1 + 123);
        waitUntilClickable(BUTTON_RENAME, "Waiting for rename button is clickable in rename dash board window");
        safeClick(BUTTON_RENAME, "Rename button ");
        waitForSecs(5);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + 123 + "\n", "dashboard name into type search");
        System.out.println("entered db text");
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboard name", MEDIUMWAIT);
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
        waitForSecs(7);
        safeClick(DASHBOARD_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForSecs(5);
    }

    @Step("CloneDashboard from Dashboard overview page")
    public void CloneDashboard(String DBname) throws InterruptedException {
        waitForSecs(5);
        safeType(DB_SEARCH, DBname, "Enter dashboard into type search");
        driver.findElement(DB_SEARCH).sendKeys(Keys.ENTER);
        waitForSecs(3);
        String locator = "//span[text()='" + DBname + "']/parent::div";
        By CLONE_PARENT = By.xpath(locator);
        safeClick(CLONE_PARENT, "CloneParent dashboard", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ICON_CLONE, "clone icon", MEDIUMWAIT);
        waitForSecs(5);
        //Generating random number and converting to string to append with cloned dashboard
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String ran = String.valueOf(rand_int1);
        for (int i = 0; i <= 30; i++) {
            driver.findElement(CLONE_DB_NAME).sendKeys(Keys.BACK_SPACE);
        }
        safeClearAndType(CLONE_DB_NAME, "Child" + ran, "Dashboard Name", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CLONE, "clone icon", MEDIUMWAIT);
        waitForSecs(5);
        String childDB = safeGetText(DB_TITLE, "Dashboard Title", MEDIUMWAIT);
        Assert.assertEquals(childDB, "Child" + ran);
    }

    @Step("Mouse Hover on Dashboard")
    public void HoverDashboard() throws InterruptedException {
        mouseHoverJScript(CLONE_PARENT, "Clone Parent", "clone Parent", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ICON_CLONE, "Clone icon", MEDIUMWAIT);

    }

    @Step("Clone using Hover over Dashboard")
    public void SearchCloneDashboard() throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "Clone Parent", "clone Parent", MEDIUMWAIT);
        String locator = "//span[text()='" + dname1 + "']/parent::div";
        By CLONE_PARENT = By.xpath(locator);
        List<WebElement> result1 = driver.findElements(CLONE_PARENT);
        int count1 = result1.size();
        mouseHoverJScript(CLONE_PARENT, "Clone Parent", "clone Parent", MEDIUMWAIT);
        safeClick(ICON_CLONE, "clone icon", MEDIUMWAIT);
        String optXpath = "//div[@role='menuitem' and text()='Application']";
        By FOLDER = By.xpath(optXpath);
        waitForSecs(5);
        safeClick(DIALOG_FOLDER, "Folder Field of Clone Dialogue", VERYLONGWAIT);
        waitForSecs(5);
        safeType(DIALOG_DASHBOARD, "Application", "Folder textbox", MEDIUMWAIT);
   /*     Actions act = new Actions(driver);
        act.sendKeys("1 Folder");*/
        waitForSecs(5);
        safeClick(FOLDER, "dashboard display name option", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_CLONE, "Clone button", MEDIUMWAIT);
        waitForSecs(10);
        mouseHoverJScript(CLONE_PARENT, "Clone Parent", "clone Parent", VERYLONGWAIT);
        List<WebElement> result2 = driver.findElements(CLONE_PARENT);
        int count2 = result2.size();
        System.out.println("************** c1= " + count1);
        System.out.println("************** c2= " + count2);
        boolean checkclone = count2 > count1;
        Assert.assertTrue(checkclone);
    }

    @Step("Verifying cloning portlet in Dashboard over view page")
    public void cloningPortlet() throws InterruptedException {
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitUntilClickable(BTN_ADD_METRIC, "Waiting for Add metric icon");
        safeClick(BTN_ADD_METRIC, "Add metric icon");
        waitUntilClickable(LINK_ADD_METRIC, "Waiting for Add metric link");
        safeClick(LINK_ADD_METRIC, "Add metric link");
        safeClick(TEXT_HEADER, "Portlet Name");
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TEXTBOX_PORTLET);
        searchField.sendKeys(del + dname1 + 123);
        safeClick(BTN_ADD_PORTLET, "Add portlet", VERYLONGWAIT);
        waitForSecs(5);
        waitUntilClickable(All_FOLDER, "Add metric link");
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForSecs(5);
        safeType(TEXTBOX_TYPESEARCH, dname1 + 123, "Dashboard Name in textbox", VERYLONGWAIT);
        WebElement type = driver.findElement(TEXTBOX_TYPESEARCH);
        type.sendKeys(Keys.ENTER);
        waitForSecs(5);
        mouseHoverJScript(LIST_PORTLETS, "text", "mouse", MEDIUMWAIT);
        safeClick(CLONE_PORTLET, "Clone button from dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(LISTBOX_FOLDER_PORTLET, "Folder name", MEDIUMWAIT);
        waitForSecs(7);
        driver.findElement(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]//following-sibling::div/div/input")).sendKeys("QA Dashboard Test");
        waitUntilClickable(DROPDOWN_DASHBOARD_FOLDER, "Waiting for an element");
        safeClick(DROPDOWN_DASHBOARD_FOLDER, "QA Dashboard Test", MEDIUMWAIT);
        safeJavaScriptClick(BTN_CLONE, "Clone button", MEDIUMWAIT);
        waitForSecs(10);
        String text = safeGetText(DASHBOARD_COUNT, "list of dashboards", MEDIUMWAIT);
        System.out.println(text);
        String expectedText = "(2)";
        Assert.assertEquals(text, expectedText);
    }


    @Step("Clicking on the calender in date picker in dashboard overview page")
    public void SelectingCalender(String DBname) throws InterruptedException {
        waitForSecs(5);
        safeType(DB_SEARCH, DBname, "Dashboard Name into type search");
        driver.findElement(DB_SEARCH).sendKeys(Keys.ENTER);
        waitForSecs(3);
        String locator = "//span[text()='" + DBname + "']/parent::div";
        By CLONE_PARENT = By.xpath(locator);
        safeClick(CLONE_PARENT, "CloneParent dashboard", MEDIUMWAIT);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
    }

    @Step("Clicking on Calender icon")
    public void clickingOnCalenderIcon() {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
    }

    @Step("Validating current hour of predefined time range from calendar ")
    public void ValidatingCurrentHour() throws InterruptedException {
        safeClick(BTN_CURRENTHOUR, "Current Hour");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatArrivals = new SimpleDateFormat("hh:00 aa", Locale.US);
        String time = simpleDateFormatArrivals.format(new Date(cal1.getTimeInMillis()));
        System.out.println(time);
        cal1.add(Calendar.HOUR, 1);
        String time1 = simpleDateFormatArrivals.format(new Date(cal1.getTimeInMillis()));
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);
        System.out.println("Current date and time is " + date5 + " " + time + " " + "-" + date5 + " " + time1);
        expectedText = date5 + " " + time + " " + "-" + date5 + " " + time1;
        Assert.assertEquals(str, expectedText);


    }

    @Step("Validating Last hour of predefined time range from calendar ")
    public void validatingLastHour() {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LASTHOUR, "Last Hour");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatArrivals = new SimpleDateFormat("hh:00 aa", Locale.US);
        String time = simpleDateFormatArrivals.format(new Date(cal1.getTimeInMillis()));
        System.out.println(time);
        cal1.add(Calendar.HOUR, -1);
        String time1 = simpleDateFormatArrivals.format(new Date(cal1.getTimeInMillis()));
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);

        System.out.println("Current date and time is " + date5 + " " + time1 + " " + "-" + date5 + " " + time);
        expectedText = date5 + " " + time1 + " " + "-" + date5 + " " + time;
        Assert.assertEquals(str, expectedText);
        System.out.println("Its working");


    }

    @Step("Validating Business hours of predefined time range from calendar ")
    public void validatingBusinessHours(String start, String end) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_BUSINESS_HOURS, "Business Hours");
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

    @Step("Validating Last12 hours option of predefined time range from calendar ")
    public void validatingLast12hours() {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_Last_12_Hours, "Last12hours");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }

        System.out.println(str);
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatArrivals = new SimpleDateFormat("hh:00 aa", Locale.US);
        String time = simpleDateFormatArrivals.format(new Date(cal1.getTimeInMillis()));
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatArrivals1 = new SimpleDateFormat("hh:00");
        String time1 = simpleDateFormatArrivals1.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.HOUR, 1);
        String time3 = simpleDateFormatArrivals1.format(new Date(cal.getTimeInMillis()));
        Calendar cal5 = Calendar.getInstance();
        DateFormat date123 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String date5 = date123.format(date2);
        System.out.println(date5);
        cal5.add(Calendar.DATE, -1);
        String date12 = date123.format(new Date(cal5.getTimeInMillis()));
        System.out.println(date12);
        if (time.contains("PM")) {
            System.out.println("Current date and time is " + date5 + " " + time3 + " " + "AM" + " " + "-" + date5 + " " + time3 + " " + "PM");
            expectedText = date5 + " " + time3 + " " + "AM" + " " + "-" + date5 + " " + time3 + " " + "PM";
            Assert.assertEquals(str, expectedText);
            System.out.println("Its working");
        } else {
            System.out.println("Current date and time is " + date12 + " " + time3 + " " + "PM" + " " + "-" + date5 + " " + time3 + " " + "AM");
            expectedText = date12 + " " + time3 + " " + "PM" + " " + "-" + date5 + " " + time3 + " " + "AM";
            Assert.assertEquals(str, expectedText);
            System.out.println("Its working");
        }
    }

    @Step("Validating This month of predefined time range from calendar ")
    public void validatingThisMonth(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_THIS_MONTH, "Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("MM");
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy");
        System.out.println(s2.format(new Date(cal.getTimeInMillis())));
        String s3 = s2.format(new Date(cal.getTimeInMillis()));
        System.out.println(s3);
        cal.add(Calendar.MONTH, 1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s4 = s.format(new Date(cal.getTimeInMillis()));
        String date1 = s1 + "/01" + "/" + s3;
        String date2 = s4 + "/01" + "/" + s3;
        System.out.println("Current date and time is " + date1 + " " + time + " " + "-" + date2 + " " + time);
        String expectedText = date1 + " " + time + " " + "-" + date2 + " " + time;
        Assert.assertEquals(str, expectedText);

    }

    @Step("Validating Last Month of predefined time range from calendar ")
    public void validatingLastMonth(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LAST_MONTH, "Last Month");
        waitForSecs(5);
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("MM");
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println(s1);
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy");
        System.out.println(s2.format(new Date(cal.getTimeInMillis())));
        String s3 = s2.format(new Date(cal.getTimeInMillis()));
        System.out.println(s3);
        cal.add(Calendar.MONTH, -1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s4 = s.format(new Date(cal.getTimeInMillis()));
        String date1 = s1 + "/01" + "/" + s3;
        String date2 = s4 + "/01" + "/" + s3;
        System.out.println("Current date and time is " + date2 + " " + time + " " + "-" + date1 + " " + time);
        String expectedText = date2 + " " + time + " " + "-" + date1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    @Step("Validating Last 30 Days of predefined time range from calendar ")
    public void validatingLast30Days(String time) {
        waitForSecs(10);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LAST_30_DAYS, "Last 30 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
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

    @Step("Validating Today option of predefined time range from calendar ")
    public void validatingToday(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_TODAY, "Today");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, 1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s1 + " " + time + " " + "-" + s2 + " " + time);
        String expectedText = s1 + " " + time + " " + "-" + s2 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    @Step("Validating Yesterday option of predefined time range from calendar ")
    public void validatingYesterday(String time) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_YESTERDAY, "Yesterday");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, -1);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s2 + " " + time + " " + "-" + s1 + " " + time);
        String expectedText = s2 + " " + time + " " + "-" + s1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    @Step("Validating Last7Days option of predefined time range from calendar ")
    public void validatingLast7Days(String time) {
        waitForSecs(5);
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_LAST_7_DAYS, "Last 7 Days");
        List<WebElement> list = driver.findElements(TIMESTAMPTEXTBOX);
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str = str + list.get(i).getText();
        }
        System.out.println(str);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s1 = s.format(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DATE, -7);
        System.out.println(s.format(new Date(cal.getTimeInMillis())));
        String s2 = s.format(new Date(cal.getTimeInMillis()));
        System.out.println("Current date and time is " + s2 + " " + time + " " + "-" + s1 + " " + time);
        String expectedText = s2 + " " + time + " " + "-" + s1 + " " + time;
        Assert.assertEquals(str, expectedText);


    }

    @Step("Validating AbsoluteQa30mins option of predefined time range from calendar")
    public void validatingAbsoluteQa_30Mins(String tsstart, String tsend) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_ABSOLUTECURRENTHOUR_QA_30_MINS, "AbsoluteQa30mins");
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

    @Step("Validating AbsoluteAllUnits option of predefined time range from calendar")
    public void validatingAbsoluteAllUnits(String tsstart, String tsend) {
        safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        safeClick(BTN_ABSOLUTE_ALL_UNITS, "AbsoluteAllUnits");
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

    @Step("Searching dashboard in dashboard overview page")
    public void SearchinDashboard() throws InterruptedException {
        String dashboard = "Required Trend Granularity";
        safeType(TEXTBOX_TYPESEARCH, dashboard + "\n", "Dashboard name into type search");
        System.out.println("entered dbtext");
        waitForSecs(7);

    }

    @Step("Validating Minutely option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingMinutely() throws InterruptedException {
        waitForSecs(7);
        safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_MINUTE, "Minute option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetAttribute(NTABULAR_LABELS_minutely, "title", "Minute text", 5000);
        System.out.println(text);
        expectedText = "Minutely";
        Assert.assertEquals(text, expectedText);
        String expected = "00:00";
        List<WebElement> allOptions = driver.findElements(GHPORTLET_LABELS);
        for (int i = 0; i < allOptions.size() - 1; i++) {
            String optionValue = allOptions.get(i).getText();
            Assert.assertEquals(optionValue, expected);
            if (optionValue.equals(expected)) {
                System.out.println(expected);
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }

    }

    @Step("Validating hours option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingHours() throws InterruptedException {
        waitForSecs(15);
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(LISTOFDASHBOARDS, "Dashboard Name", MEDIUMWAIT);
        waitForSecs(10);

       // safeClick(CALENDAR_ICON, "Calendar Icon", MEDIUMWAIT);
        waitForSecs(5);
        //safeClick(BTN_LAST_30_DAYS, "Last 30 Days button", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_HOURLY, "Hourly option from Trend Granularity");
        waitForSecs(7);
/*        String text = safeGetAttribute(NTABULAR_LABELS_Hourly, "title", "Hourly text", 5000);
        System.out.println(text);
        expectedText = "Hourly";
        Assert.assertEquals(text, expectedText);*/
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("d. MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        cal.add(Calendar.DATE, -29);
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
        String s15 = f.format(new Date(cal.getTimeInMillis()));
        String[] expected = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15};
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
        safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_DAILY, "Daily option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetText(NTABULAR_LABELS_Daily, "Daily text", 5000);
        System.out.println(text);
        expectedText = "DAILY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("d. MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("d");
        cal.add(Calendar.DATE, -29);
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
        safeClick(BTN_TREND_GRANULARITY, " Trend Granularity");
        waitForSecs(7);
        safeClick(BTN_MONTHLY, "Monthly option from Trend Granularity");
        waitForSecs(7);
        String text = safeGetText(NTABULAR_LABELS_Monthly, "Monthly text", 5000);
        System.out.println(text);
        expectedText = "MONTHLY";
        Assert.assertEquals(text, expectedText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MMM");
        SimpleDateFormat f1 = new SimpleDateFormat("yy");
        // cal.add(Calendar.MONTH);
        cal.add(Calendar.DATE, -29);
        String s1 = f.format(new Date(cal.getTimeInMillis()));
        String s2 = f1.format(new Date(cal.getTimeInMillis()));
        String date = s1 + " " + "'" + s2;
        System.out.println(date);
        String expected = date;
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(expected, actualText);


    }

    @Step("Validating Yearly option in trendGranularity in dashboard overview page")
    public void validaingTrendGranularityUSingYEARLY() throws InterruptedException {
        waitForSecs(7);
        safeClick(BTN_TREND_GRANULARITY, "Trend Granularity");
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
        WebElement allOptions = driver.findElement(GHPORTLET_LABELS);
        String actualText = allOptions.getText();
        Assert.assertEquals(s1, actualText);
    }

    @Step("To click on 'Dashboard' and click on 'All' button")
    public void addingNewFolder() {
        safeClick(DASHBOARD_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        safeJavaScriptClick(BUTTON_ADD_DASHBOARD, "Add button ondashboards section", MEDIUMWAIT);
        safeClick(LABEL_NEW_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
    }

    @Step("Clicking on Dashboards section")
    public void clickingOnDashboardSection() {
        safeClick(DASHBOARD_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
    }

    @Step("Logout the application")
    public void signOut() {
        waitForPageToLoad();
        safeClick(USERICON, "User Icon", MEDIUMWAIT);
        safeClick(LOGOUT, "Logout", MEDIUMWAIT);
    }

    public void clickingDashBoardModule() {
        if (!driver.findElement(All_FOLDER).isDisplayed()) {
            safeClick(DASHBOARD_MODULE, "DashBoard Module on Home page", MEDIUMWAIT);
            safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        } else {
            safeClick(All_FOLDER, "DashBoard Module on Home page", MEDIUMWAIT);
        }

    }

    public void verifySharingDashboardWithExistingUser() {
        safeClick(LISTOFDASHBOARDS, "dashboard name", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ICON_SHARE_DASHBORD, "Share icon", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_SHARE_DASHBOARD_EMAIL, "access1234@yopmail.com", "Entering email", MEDIUMWAIT);
        waitForSecs(15);
        List<WebElement> kpi12 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        for (int i = 0; i < kpi12.size(); i++) {
            System.out.println(kpi12.get(i).getText());
            if (kpi12.get(i).getText().equals("access1234@yopmail.com")) {
                kpi12.get(i).click();
                break;
            }
        }
        safeClick(BTN_SHARE, "Share button", MEDIUMWAIT);
        String sharedDashbrd = safeGetText(NOTIFY_FOOTER_SHAREDASHBRD, "Shared dashboard notify", MEDIUMWAIT);
        String expectedText = "Dashboard Shared";
        Assert.assertEquals(sharedDashbrd, expectedText);
    }

    public void verifySharingDashboardWithNewUser() {
        safeClick(LISTOFDASHBOARDS, "dashboard name", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ICON_SHARE_DASHBORD, "Share icon", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_SHARE_DASHBOARD_EMAIL, "testzenq@yopmail.com", "Entering email", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(NEW_EMAIL_TEXT, "dashboard name", MEDIUMWAIT);
        safeClick(BTN_SHARE, "Share button", MEDIUMWAIT);
        String sharedDashbrd = safeGetText(NOTIFY_FOOTER_SHAREDASHBRD, "Shared dashboard notify", MEDIUMWAIT);
        String expectedText = "Dashboard Shared";
        Assert.assertEquals(sharedDashbrd, expectedText);
    }

    public void checkPortletsPerRow() {
        safeType(TEXTBOX_TYPESEARCH, "QA - cloned" + "\n", "Dashboard Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        safeClickingOnSearchingConfig(LISTOFDASHBOARDS, "QA - cloned");
        waitForSecs(10);
        safeClick(PORTLETS_PER_REVIEW_ICON, "Per review icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_TWO_COLUMNS, "2 Columns", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> prodsCount = driver.findElements(NUMBER_OF_PORTLETS);
        System.out.println("Total number of products are " + prodsCount.size());
        System.out.println(prodsCount.get(0).getLocation());
        System.out.println(prodsCount.get(1).getLocation());
        System.out.println(prodsCount.get(2).getLocation());
        System.out.println(prodsCount.get(3).getLocation());
        System.out.println(prodsCount.get(4).getLocation());
        System.out.println(prodsCount.get(5).getLocation());
        System.out.println(prodsCount.get(6).getLocation());
        System.out.println(prodsCount.get(7).getLocation());
        System.out.println(prodsCount.get(8).getLocation());
        System.out.println(prodsCount.get(9).getLocation());
        System.out.println(prodsCount.get(10).getLocation());
        waitForSecs(10);
        int x = prodsCount.get(0).getLocation().getY();
        System.out.println(x);
        Assert.assertEquals(prodsCount.get(0).getLocation().getY(), 113);
        int y = prodsCount.get(1).getLocation().getY();
        System.out.println(y);
        Assert.assertEquals(prodsCount.get(1).getLocation().getY(), 113);
        int z = prodsCount.get(2).getLocation().getY();
        System.out.println(z);
        Assert.assertNotEquals(prodsCount.get(2).getLocation().getY(), 113);


    }




}