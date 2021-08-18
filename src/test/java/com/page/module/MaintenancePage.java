package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.MaintenanceLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Random;

public class MaintenancePage extends SafeActions implements MaintenanceLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Maintenance = "Maintenance" + "-" + random.nextInt(500);
    String Cred = "Cred" + "-" + random.nextInt(500);
    String credEdited = "credEdited" + "-" + random.nextInt(500);
    String Name_Add, Duration_Add, Edited_Cred_Name, Edited_Cred_User_Name, monitoredServer_add, script_Add, Record2, Record1, AddedScenario1, AddedScenario2;


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

    public  void verifyingAddedMaintenanceConfigs()
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
    }
}
