package com.page.module;

import com.page.locators.ApmStateLocators;
import com.page.locators.UserAccessRequestLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ApmStatePage extends SafeActions implements ApmStateLocators {
    private WebDriver driver;
    String dname = "HttpScenario";
    Random random = new Random();
    String dname1 = dname + random.nextInt(1500);
    String dnameEdit = "Httpedit"+random.nextInt(1500);
    String Server_add,AppName_add,Cred_add,Component_add,Edit_Server_add,Edit_MonitorName_add,Edit_App_add;

    public ApmStatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void configuringHttpScenario() {
        safeClick(APMHEADER, "APM label from left side pane", MEDIUMWAIT);
        safeClick(APMSTATE_HEADER, "APM STATE label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(COMPONENTS_TAB, "Nodes Tab", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(COMPONENT_HTTP_SCENARIO, "Components scenario", MEDIUMWAIT);
    }

    public void configuringServerPage() {
        safeClearAndType(TXTBOX_SERVER, "QA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("QA")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        Server_add = safeGetText(SERVER_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Server_add);
        safeClearAndType(TXTBOX_CREDENTIALS, "QA Cred", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("QA Cred")) {

                dbs3.get(i).click();
                break;
            }
        }
        Cred_add = safeGetText(CREDENTIALS_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Cred_add);
        safeClearAndType(TXTBOX_APPNAME, "_NET", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("_NET")) {

                dbs4.get(i).click();
                break;
            }
        }
        AppName_add = safeGetText(APPNAME_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(AppName_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClearAndType(TXTBOX_COMPONENT_TYPE, "QA HTTP", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("QA HTTP")) {

                dbs5.get(i).click();
                break;
            }
        }
        Component_add = safeGetText(COMPONENTTYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Component_add);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_SKIP, "Skip Button", MEDIUMWAIT);
    }

    public void configuringDeploymentPage() {
        safeClearAndType(TXTBOX_MONIOTOR_NAME, dname1, "Monitoring Name", MEDIUMWAIT);
        waitForSecs(20);
        safeClearAndType(TXTBOX_MONITORING_NAME, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("QA Test")) {

                dbs5.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClearAndType(TXTBOX_ENGINE, "QA Test Engine", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs6 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs6.size());
        for (int i = 0; i < dbs6.size(); i++) {

            if (dbs6.get(i).getText().equals("QA Test Engine")) {

                dbs6.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingHttpScenario(){
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        System.out.println(dname1.equals(driver.findElement(TXTBOX_MONIOTOR_NAME).getAttribute("value")));
        System.out.println(AppName_add.equals(driver.findElement(TXTBOX_EDITED_APPNAME).getText()));
        System.out.println(Server_add.equals(driver.findElement(TXTBOX_EDITED_SERVER).getText()));
        if (dname1.equals(driver.findElement(TXTBOX_MONIOTOR_NAME).getAttribute("value")) && AppName_add.equals(driver.findElement(TXTBOX_EDITED_APPNAME).getText()) &&
                Server_add.equals(driver.findElement(TXTBOX_EDITED_SERVER).getText()))
        {
         Assert.assertTrue(true);
        } else {
            Assert.fail("Ticket details are invalid");
        }
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }

    public void verifyingEditHttpConfigs(){
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeTypeUsingChrod(TXTBOX_MONIOTOR_NAME, dnameEdit, "Monitoring Name", MEDIUMWAIT);
        Edit_MonitorName_add = safeGetText(MONITOR_NAME_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_APPNAME, "QA Software", "Monitoring Name", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("QA Software")) {

                dbs4.get(i).click();
                break;
            }
        }

        Edit_App_add = safeGetText(TXTBOX_EDITED_APPNAME, "Server textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_SERVER, "QA Wordpress", "Monitoring Name", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs5.get(i).getText().equals("QA Wordpress")) {

                dbs5.get(i).click();
                break;
            }
        }

        Edit_Server_add = safeGetText(TXTBOX_EDITED_SERVER, "Server textbox value", MEDIUMWAIT);
         waitForSecs(15);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(30);
        System.out.println(dnameEdit.equals(driver.findElement(TXTBOX_MONIOTOR_NAME).getAttribute("value")));
        System.out.println(Edit_App_add.equals(driver.findElement(TXTBOX_EDITED_APPNAME).getText()));
        System.out.println(Edit_Server_add.equals(driver.findElement(TXTBOX_EDITED_SERVER).getText()));

        if (dnameEdit.equals(driver.findElement(TXTBOX_MONIOTOR_NAME).getAttribute("value")) && Edit_App_add.equals(driver.findElement(TXTBOX_EDITED_APPNAME).getText()) &&
                Edit_Server_add.equals(driver.findElement(TXTBOX_EDITED_SERVER).getText()))
        {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Ticket details are invalid");
        }
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
    }
}
