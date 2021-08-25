package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.PresentationModesNdRulesLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class PresentationModesNdRulesNdRulesPages extends SafeActions implements PresentationModesNdRulesLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Presentation = "Presentation" + "-" + random.nextInt(500);
    String Rules = "Rules" + "-" + random.nextInt(500);
    String Edit_Presentation = "EditP_Presentation"+"-" + random.nextInt(500);
    String Name_Add, Duration_Add, Dashboard_add, Timerange_add,Edited_Name_Add,Content_Add;


    public PresentationModesNdRulesNdRulesPages(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to SSH page from automation module")
    public void clickingOnPresentationModes() {
        waitForSecs(20);
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_PRESENTATION_MODES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Presentation, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void addingPresentationModeConfigWithDashboards() {
        safeClick(LABEL_DASHBOARD, "Server Feild", MEDIUMWAIT);
        safeClick(DASHBOARD_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DASHBOARD, "Business Overview", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Business Overview")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Dashboard_add = safeGetText(TXTBOX_DASHBOARD_VALUE, "Server textbox value", MEDIUMWAIT);
        System.out.println(Dashboard_add);
    }

    public void addingTimeRangesAndDurationConfigs() {
        waitForSecs(10);
        safeClick(LABEL_TIMERANGE, "Server Feild", MEDIUMWAIT);
        safeClick(TIMERANGE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TIMERANGE, "Today", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Today")) {

                dbs2.get(i).click();
                break;
            }
        }
        Timerange_add = safeGetText(TXTBOX_TIMERANGE, "Server textbox value", MEDIUMWAIT);
        safeType(TXTBOX_DURATION, "60", "Duration into textbox", MEDIUMWAIT);
        Duration_Add = safeGetAttribute(TXTBOX_DURATION, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Duration_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void verifyingAddedPresenatationModesWithDasshboardsConfig() {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Presentation;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Dashboard_add.equals(driver.findElement(HYPERLINK_DASHBOARDS).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void uncheckDashBoardCheckBox() {
        waitForSecs(10);
        safeUnCheck(CHKBOX_DASHBOARD, "Dashboard checkbox", MEDIUMWAIT);
    }

    public void addingPresentationModeConfigWithViews() {
        safeClick(LABEL_VIEW, "Server Feild", MEDIUMWAIT);
        safeClick(VIEW_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_VIEW, "Insights", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Insights")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Dashboard_add = safeGetText(TXTBOX_VIEW_VALUE, "Server textbox value", MEDIUMWAIT);
        System.out.println(Dashboard_add);
    }

    public void addingDashboardsNDViewsfromEditPresentationModeWindow() {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVE_DASHBOARDS, "Remove Dashboards", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DASHBOARDS_ADD_ICON, "Dashboards add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void verifyingAddedDashboardInEditPresentationWindow() {
        String expectedText = driver.findElement(HYPERLINK_DASHBOARDS).getText();
        Assert.assertEquals(Dashboard_add, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingPresentationModePage(){
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Presentation, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void verifyingPresentationModesInPresentationButton(){
        safeClick(PLAY_BTN_ICON,"Play button",MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(PLAYMODE_DRPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 3; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Presentation")) {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertFalse(false,"Presentation mode is not displaying in play button dropdown");
            }
        }
        waitForSecs(10);
        refresh();
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editDashboardConfigValues()
    {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + Edit_Presentation);
        Edited_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_REMOVE_DASHBOARDS, "Remove Dashboards", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(DASHBOARDS_ADD_ICON, "Dashboards add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void verifyingEditedDashboardViewConfigValues()
    {
        waitForSecs(10);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Dashboard_add.equals(driver.findElement(HYPERLINK_DASHBOARDS).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addRuleConfiguration()
    {
        safeClick(LABEL_SYSTEM,"System",MEDIUMWAIT);
        safeClick(LABEL_ENGINE_SETTINGS, "Engine Settings", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_RULES, "Rules", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Rules, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeType(TEXTAREA_CONTENT,"contentRules","Content Text are",MEDIUMWAIT);
        Content_Add = safeGetText(CONTENT_VAULUE,"Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_FINISH,"Finish",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingAddedRules()
    {
        safeType(TEXTBOX_TYPESEARCH, Rules + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Rules;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Content_Add.equals(driver.findElement(CONTENT_VAULUE).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
}
