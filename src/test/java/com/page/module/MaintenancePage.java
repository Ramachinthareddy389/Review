package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.MaintenanceLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
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

    public  void addingMaintenanceConfig(){
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Maintenance, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeType(TXTBOX_DURATION, "10", "Duration into textbox", MEDIUMWAIT);
        Duration_Add = safeGetAttribute(TXTBOX_DURATION, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Duration_Add);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingAddedMaintenanceConfigs()
    {
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
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value"))&& Duration_Add.equals(driver.findElement(TXTBOX_DURATION).getAttribute("value"))){
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

    public void addActionsInEditMaintenanceWindow()
    {
        safeType(TEXTBOX_TYPESEARCH, Maintenance + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(ACTIONS_ADD_ICON,"Actions add icon",MEDIUMWAIT);
        safeClick(ALERT_LABEL,"Alert label",MEDIUMWAIT);
        waitForSecs(30);
        safeClick(LABEL_NAME_ALERT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME_ALERT, Alert, "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_DISTRIBUTION_LIST, "Server Feild", MEDIUMWAIT);
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
        }
        waitForSecs(10);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void addingHTTPactionInMaintennceWindow()
    {
        safeClick(ACTIONS_ADD_ICON,"Actions add icon",MEDIUMWAIT);
        safeClick(HTTP_ACTION_LABEL,"Action Label",MEDIUMWAIT);
        safeClick(LABEL_NAME_ALERT, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME_ALERT, Httpaction, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
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

    public  void addingLocalProgrammes(){
        safeClick(ACTIONS_ADD_ICON,"Actions add icon",MEDIUMWAIT);
        safeClick(LOCALPROGRAM_LABEL,"Actions add icon",MEDIUMWAIT);
        safeClick(LABEL_NAME_ALERT,"Name Label",MEDIUMWAIT);
        safeType(TXTBOX_NAME_ALERT,"Local Programmes","Name Textbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_PROGRAM, "Server Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROGRAM,"Program","Name Textbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        waitForSecs(5);
        safeCheck(CHKBOX_RUNSCHEDULE,"Run Schedule checkbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }
}
