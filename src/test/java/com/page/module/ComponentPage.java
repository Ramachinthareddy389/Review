package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.ComponentTypesLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class ComponentPage extends SafeActions implements ComponentTypesLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Component = "Component" + "-" + random.nextInt(500);
    String Cred = "Cred" + "-" + random.nextInt(500);
    String WMI = "WMI" + "-" + random.nextInt(500);
    String Name_Add, KPIS_add, program_Add, sla_add, monitoredServer_add, script_Add, Record2, Record1, AddedScenario1, AddedScenario2;


    public ComponentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to SSH page from automation module")
    public void clickingOnAutomation() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ENGINE_SETTINGS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_COMPONENT_TYPES, "Add button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void adding1stComponent()
    {
        safeClick(BTN_ADDICON,"Add Icon",MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(2).click();
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        waitForSecs(50);
        driver.findElement(TXTBOX_USERNAME_QUERY).sendKeys("test");
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingAddedComponent()
    {
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, Component + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Component;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void adding2ndComponent()
    {
        safeClick(BTN_ADDICON,"Add Icon",MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(3).click();
        safeClick(LABEL_COMPONENT_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_COMPONENT_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_COMPONENT_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_QUERY_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_QUERY_NAME, Component, "Name into textbox", MEDIUMWAIT);
        waitForSecs(30);
        driver.findElement(TXTBOX_USERNAME_QUERY).sendKeys("test");
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "Alert", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Alert")) {

                dbs1.get(i).click();
                break;
            }
        }
        KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KPIS_add);
        safeCheck(CUSTOMRULE_CHKBOX,"Custom rule",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    //Credentials

    public void clickingOnAddCredentials()
    {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_CREDENTIALS,"Credentials",MEDIUMWAIT);
        safeClick(BTN_ADDICON,"Add Icon",MEDIUMWAIT);
    }

//Credentails config

    public void addingNewCredentials()
    {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Cred, "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_USERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_USERNAME, Cred, "Name into textbox", MEDIUMWAIT);

        safeClick(LABEL_PASSWORD, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PASSWORD, Cred, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"close button",MEDIUMWAIT);
    }

    public void verifyingAddedCredentials(){
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, Cred + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Cred;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

}
