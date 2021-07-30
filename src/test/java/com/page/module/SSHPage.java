package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.SSHLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SSHPage extends SafeActions implements SSHLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String SCRIPT = "Script" + "-" + random.nextInt(500);
    String SSH = "SSH" + "-" + random.nextInt(500);
    String Cred_add, server_Add, program_Add, sla_add, monitoredServer_add,script_Add;


    public SSHPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SSH, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_SSH, "Add button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingSSH() {
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SSH, "Name Textbox", MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);

        safeClick(LABEl_SERVER, "Server Feild", MEDIUMWAIT);
        safeClick(SERVER_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SERVER, "germain-test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("germain-test")) {

                dbs3.get(i).click();
                break;
            }
        }
       monitoredServer_add = safeGetText(SERVER_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(monitoredServer_add);


        safeClick(LABEl_CREDENTIALS, "Server Feild", MEDIUMWAIT);
        safeClick(CREDENTIALS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CREDENTIALS, "Salesforce User", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("Salesforce User")) {

                dbs4.get(i).click();
                break;
            }
        }
        Cred_add = safeGetText(CREDENTIALS_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Cred_add);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        safeClick(LABEL_PROGRAM, "Server Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROGRAM,"Program","Name Textbox",MEDIUMWAIT);
        program_Add = safeGetAttribute(TXTBOX_PROGRAM, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(program_Add);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        waitForSecs(5);
        safeCheck(CHKBOX_RUNSCHEDULE,"Run Schedule checkbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Alert - raw - test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs7 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs7.size());
        for (int i = 0; i < dbs7.size(); i++) {

            if (dbs7.get(i).getText().equals("Alert - raw - test")) {

                dbs7.get(i).click();
                break;
            }
        }
        String sla2 = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla2);

        String[] parts = sla2.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }
public void verifyingAddedSSH(){
    safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
    System.out.println("entered dbtext");
    waitForSecs(9);
    mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
    safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
    waitForSecs(9);
    String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
    System.out.println(pageTitle);
    String expectedText = SSH;
    Assert.assertEquals(pageTitle, expectedText);
    waitForSecs(10);
    Assert.assertEquals(sla_add,driver.findElement(HYPERLINK_SLAs).getText());
    Assert.assertEquals(program_Add,driver.findElement(TXTBOX_PROGRAM).getAttribute("value"));
    Assert.assertEquals(server_Add,driver.findElement(TXTBOX_SERVERNAME).getAttribute("value"));
    Assert.assertEquals(monitoredServer_add,driver.findElement(EDITED_MONITORED_TXTBOX).getText());
    Assert.assertEquals(Cred_add,driver.findElement(EDITED_CREDENTIALS_TXTBOX).getText());
    safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
    waitForSecs(5);
    safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    waitForSecs(10);
    safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    waitForSecs(10);
}
    public void verifyingAddedScriptInSSH(){
        safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(SCRIPT_ADDICON,"Add icon",MEDIUMWAIT);
        safeClick(LABEL_NAME,"Name Label",MEDIUMWAIT);
        safeType(TXTBOX_NAME,SCRIPT,"Name Textbox",MEDIUMWAIT);
        script_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(script_Add);
        safeClick(LABEL_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "python", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("python")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        safeClick(CONTENT_TEXTAREA,"Metric Exp",MEDIUMWAIT);
        WebElement metric=driver.findElement(CONTENT_TEXTAREA);
        metric.sendKeys("test123");
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);

        safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String addedScript = safeGetText(EDITED_SCRIPT,"Script",MEDIUMWAIT);
        System.out.println(addedScript);
        Assert.assertEquals(script_Add,addedScript);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);

    }

    public void verifyingInScriptPage(){
        safeClick(BTN_SCRIPT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = SCRIPT;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);

    }
}
