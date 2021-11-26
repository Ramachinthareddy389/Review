package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.LocalProgramLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class LocalProgramPage extends SafeActions implements LocalProgramLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String LCLPRGM = "LCLPRGM" + " - " + random.nextInt(500);
    String SCRIPT = "SCRIPT" + "-" +random.nextInt(500);
    String script_add,server_Add,program_Add,sla_add,script_Add;


    public LocalProgramPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_LOCAL_PRGMS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_LOCAL_PRGMS, "Add button", MEDIUMWAIT);
    }

    public void addingLocalPrograms(){
        safeClick(LABEL_SERVERNAME,"Name Label",MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME,LCLPRGM,"Name Textbox",MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(server_Add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
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
        safeClearAndType(TXTBOX_SLA, "Native User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
       waitForSecs(10);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Native User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);

    }

    public void verifyingLocalprogrames(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Dropdown field", MEDIUMWAIT);
        waitForSecs(10);
        By SeachedText = By.xpath("//div[contains(text(),'" + LCLPRGM + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = LCLPRGM;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        Assert.assertEquals(sla_add,driver.findElement(HYPERLINK_SLAs).getText());
        Assert.assertEquals(program_Add,driver.findElement(TXTBOX_PROGRAM).getAttribute("value"));
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingLocalProgramWithoutSla(){
        safeClick(LABEL_SERVERNAME,"Name Label",MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME,LCLPRGM,"Name Textbox",MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(server_Add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_PROGRAM, "Server Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROGRAM,"Program","Name Textbox",MEDIUMWAIT);
        program_Add = safeGetAttribute(TXTBOX_PROGRAM, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(program_Add);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        waitForSecs(5);
        safeCheck(CHKBOX_RUNSCHEDULE,"Run Schedule checkbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next Button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);

    }
    public void addingScriptInLocalProgramsEditWindow(){
        safeType(TEXTBOX_TYPESEARCH, LCLPRGM + "\n", "Alert Name into type search");
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
       waitForSecs(10);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("python")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        String sla = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        safeClick(CONTENT_TEXTAREA,"Metric Exp",MEDIUMWAIT);
        WebElement metric=driver.findElement(CONTENT_TEXTAREA);
        metric.sendKeys("test123");
       waitForSecs(10);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
    }

    public void verifyingAddedScriptInLocalProgramsEditwindow(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + LCLPRGM + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
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

    public void verifyingAddedSLAsInLocalProgramsWindow(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + LCLPRGM + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(TARGET_BY_SLA_ADD_ICON,"Add icon",MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(ACTION_SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(ACTION_SLA_TXTBOX, "User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(ACTION_SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeType(TEXTBOX_TYPESEARCH, LCLPRGM + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        Assert.assertEquals(sla_add, driver.findElement(HYPERLINK_SLAs).getText());
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }

    public void navigateToScriptPageFrmLocalProgrammes(){
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW,"edit wondow",MEDIUMWAIT);
        safeClick(SCRIPT_LINK, "Script Hyper Link", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Scripts");
        String addedScript = safeGetText(EDITED_SCRIPT,"Script",MEDIUMWAIT);
        System.out.println(addedScript);
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);

    }

    public void deletingCreatedLocalProgram(){
        safeClick(BTN_LOCAL_PRGMS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + LCLPRGM + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }
}
