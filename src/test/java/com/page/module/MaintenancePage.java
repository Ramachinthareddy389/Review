package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.MaintenanceLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class MaintenancePage extends SafeActions implements MaintenanceLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Maintenance = "Maintenance" + "-" + random.nextInt(500);
    String Httpaction = "Httpaction" + "-" + random.nextInt(500);
    String Alert = "Alert" + "-" + random.nextInt(500);
    String DistriList = "DistriList" + "-" + random.nextInt(500);
    String Name_Add, Duration_Add, sla_add, Edited_Cred_User_Name, monitoredServer_add, script_Add, Record2, Record1, AddedScenario1, AddedScenario2;


    public MaintenancePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to SSH page from automation module")
    public void clickingOnMaintenance() {
        waitForSecs(20);
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_MAINTENANCE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);

    }

    public void navigateToMaintenancePage() {
        safeClick(LABEL_MAINTENANCE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingMaintenanceConfig() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Maintenance, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeType(TXTBOX_DURATION, "60", "Duration into textbox", MEDIUMWAIT);
        Duration_Add = safeGetAttribute(TXTBOX_DURATION, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Duration_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void applyingFilters() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Maintenance + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        //driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Maintenance);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }

    }

    public void verifyingIconsInEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + Maintenance + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }
    }

    public void verifyingPageIcons() {
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Maintenance + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Maintenance + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_CLEAR,"Clear button",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EXECUTE,"Button execute",MEDIUMWAIT);
        boolean globalText=isElementDisplayed(GLOBALTEXT);
        Assert.assertTrue(globalText,"Global maintennce record ");
        safeClick(STOP_GBLMAINTENCE,"Stop global maintenance record",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void viewDataWithFeildsForViewIcon() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Maintenance  + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClearAndType(ACTIONS_DRPDOWN, "user-login-report", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("user-login-report")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_MAXIMISE,"Maximise button",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        waitForSecs(10);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.ACTION_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.ACTION_VALUES.length - 1; j++) {
            System.out.println("Values are " + dashBoardData.ACTION_VALUES[j]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    public void verifyingAddedMaintenanceConfigs() {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Maintenance;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Duration_Add.equals(driver.findElement(TXTBOX_DURATION).getAttribute("value"))) {
            System.out.println("Business process details are valid");

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addActionsInEditMaintenanceWindow() {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(ACTIONS_ADD_ICON, "Actions add icon", MEDIUMWAIT);
        safeClick(ALERT_LABEL, "Alert label", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(LABEL_NAME_ALERT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME_ALERT, Alert, "Name into textbox", MEDIUMWAIT);
        addingDistriList();
/*        safeClick(LABEL_DISTRIBUTION_LIST, "Server Feild", MEDIUMWAIT);
        safeClick(DISTRIBUTION_LIST_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DISTRIBUTION_LIST, "germain-admin", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(30);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("germain-admin")) {

                dbs1.get(i).click();
                break;
            }
        }*/
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void addingDistriList(){
        safeClick(DISTRIBUTION_LIST_ADDICON,"Distribution List",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TXTBOX_DISTI_NAME, DistriList, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_DISTI_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        waitForSecs(10);
        safeClick(BTN_NEXT_DISTRI, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClearAndType(TXTBOX_EMAIL_ADDRESS, "rama.chinthareddy@zenq.com", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("rama.chinthareddy@zenq.com")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void addingHTTPactionInMaintennceWindow() {
        safeClick(ACTIONS_ADD_ICON, "Actions add icon", MEDIUMWAIT);
        safeClick(HTTP_ACTION_LABEL, "Action Label", MEDIUMWAIT);
        safeClick(LABEL_NAME_ALERT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME_ALERT, Httpaction, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_PATH, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PATH, "Path Name", "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_REQUEST_METHOD, "Server Feild", MEDIUMWAIT);
        safeClick(REQUEST_METHOD_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_REQUEST_METHOD, "FORM", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("FORM")) {

                dbs1.get(i).click();
                break;
            }
        }
        safeClick(LABEL_CONTENT_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(CONTENT_TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CONTENT_TYPE, "application/json", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs2.get(i).getText().equals("application/json")) {

                dbs2.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void addingLocalProgrammes() {
        safeClick(ACTIONS_ADD_ICON, "Actions add icon", MEDIUMWAIT);
        safeClick(LOCALPROGRAM_LABEL, "Actions add icon", MEDIUMWAIT);
        safeClick(LABEL_NAME_ALERT, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_NAME_ALERT, "Local Programmes", "Name Textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_PROGRAM, "Server Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROGRAM, "Program", "Name Textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        waitForSecs(5);
        safeCheck(CHKBOX_RUNSCHEDULE, "Run Schedule checkbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Native User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("Native User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        waitForSecs(10);
        String[] parts = sla.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void verifyingReaccuranceOfCheckBoxInEditMaintenanceWindow() {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b = isElementSelected(CHKBOX_RECURRING);
        System.out.println(b);
        Assert.assertFalse(b);
        safeCheck(CHKBOX_RECURRING, "Recurring checkbox", MEDIUMWAIT);
        boolean b1 = isElementSelected(CHKBOX_RECURRING);
        System.out.println(b1);
        Assert.assertTrue(b1);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void VerifyScheduleinEditMaintenancewindow() {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeCheck(CHKBOX_RECURRING, "Recurring checkbox", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close window", MEDIUMWAIT);
        waitForSecs(20);
        if(isElementDisplayed(BTN_PLAY)) {
            safeClick(BTN_PLAY, "Play button", MEDIUMWAIT);
        }
        safeClick(BTN_PAUSE, "Play button", MEDIUMWAIT);
        safeClick(BTN_PLAY, "Play button", MEDIUMWAIT);
        safeClick(BTN_PAUSE, "Play button", MEDIUMWAIT);
        safeClick(BTN_PLAY, "Play button", MEDIUMWAIT);
        waitForSecs(50);
        refresh();
        waitForSecs(50);
        String s = safeGetAttribute(ICON_REFRESH_ICON, "aria-label", "Status of the maintenance", MEDIUMWAIT);
        System.out.println(s);
        String expectedText = "Is Active";
        Assert.assertEquals(s, expectedText);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_PAUSE, "Play button", MEDIUMWAIT);
    }

    public void verifyingGlobalMaintanennce() {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeCheck(CHKBOX_RECURRING, "Recurring checkbox", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close window", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CLEAR, "Clear button", MEDIUMWAIT);
        safeClick(BTN_PLAY, "Play button", MEDIUMWAIT);
        boolean b = isElementDisplayed(GLOBAL_MAINTENANCE_LABEL);
        System.out.println(b);
        Assert.assertTrue(b);
        String s = safeGetAttribute(GLOBAL_MAINTENANCE_STATUS, "aria-label", "Status of the maintenance", MEDIUMWAIT);
        System.out.println(s);
        String expectedText = "Is Active";
        Assert.assertEquals(s, expectedText);
    }
}
