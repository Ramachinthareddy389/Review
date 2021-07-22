package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.HTTPLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HTTPPage extends SafeActions implements HTTPLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String HttpName = "HttpTest" + random.nextInt(3000);
    String editKPi = "EditedKpis"+random.nextInt(3000);
    String action_Add,sla_add,path_Add,Request_add,content_add;
    private WebDriver driver1;


    public HTTPPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_HTTP, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_HTTP, "Add button", MEDIUMWAIT);
    }
    public void addingHTTPPage() {
        safeClick(LABEL_ACTIONS_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_ACTIONS_NAME, HttpName, "Name into textbox", MEDIUMWAIT);
        action_Add = safeGetAttribute(TXTBOX_ACTIONS_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(action_Add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);

        safeClick(LABEL_PATH, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PATH, "Path Name", "Name into textbox", MEDIUMWAIT);
        path_Add = safeGetAttribute(TXTBOX_PATH, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(path_Add);
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
        Request_add = safeGetText(REQUEST_METHOD_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Request_add);

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
        content_add = safeGetText(CONTENT_TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);

        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Alert - raw - test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Alert - raw - test")) {

                dbs3.get(i).click();
                break;
            }
        }
        sla_add = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla_add);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyinghttpPage(){
        safeType(TEXTBOX_TYPESEARCH, HttpName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = HttpName;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);

       System.out.println(action_Add + driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value") + path_Add + driver.findElement(TXTBOX_EDITED_TARGET_PATH).getAttribute("value") +
            Request_add + driver.findElement(TXTBOX_EDITED_TARGET_METHOD).getText() +content_add + driver.findElement(TXTBOX_EDITED_TARGET_CONTENT_TYPE).getText()+sla_add+driver.findElement(HYPERLINK_SLAs).getText());
       if (action_Add.equals(driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value")) && path_Add.equals(driver.findElement(TXTBOX_EDITED_TARGET_PATH).getAttribute("value")) &&
               Request_add.equals(driver.findElement(TXTBOX_EDITED_TARGET_METHOD).getText()) && content_add.equals(driver.findElement(TXTBOX_EDITED_TARGET_CONTENT_TYPE).getText()) && sla_add.equals(driver.findElement(HYPERLINK_SLAs).getText())) {
            System.out.println("KPIs details are valid");
            String text = driver.findElement(TXTBOX_EDITED_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);


        } else {
            Assert.fail("KPIs details are invalid");
        }
    }
}
