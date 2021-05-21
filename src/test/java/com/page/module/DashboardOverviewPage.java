package com.page.module;

import com.page.locators.DashBoardLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    String dname = "May2021";
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
        System.out.println("after finish");
        safeClick(BUTTON_CLOSE, "Clicked on close button in Dashboard window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname1);

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



    public void addingPortlet() throws InterruptedException {
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
        waitForPageToLoad();
        mouseHoverJScript(LIST_PORTLETS, "text", "mouse", MEDIUMWAIT);
        safeClick(CLONE_PORTLET, "Clicking on Clone button from dashboard", MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(LISTBOX_FOLDER_PORTLET, "foldername", MEDIUMWAIT);
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]//following-sibling::div/div/input")).sendKeys("Dashboards");
        waitUntilClickable(DROPDOWN_DASHBOARD_FOLDER, "waitinf for a element");
        safeClick(DROPDOWN_DASHBOARD_FOLDER, "selecting Dashboard", MEDIUMWAIT);
        safeJavaScriptClick(BTN_CLONE, "dashboard display name option", MEDIUMWAIT);
        Thread.sleep(15000);
        String text = safeGetText(DASHBOARD_COUNT, "getting list of dashboards", MEDIUMWAIT);
        System.out.println(text);
        String expectedText = "(2)";
        Assert.assertEquals(text, expectedText);
    }


}