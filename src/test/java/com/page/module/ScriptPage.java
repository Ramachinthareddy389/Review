package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.LocalProgramLocators;
import com.page.locators.ScriptLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ScriptPage extends SafeActions implements ScriptLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String EDITSCRIPT = "EDITSCRIPT" + " - " + random.nextInt(500);
    String SCRIPT = "Script" + "-" + random.nextInt(500);
    String script_add, server_Add, type_add, sla_add, script_Add, content_add;
    String NotifyText = "Some entries could not be deleted. Please try deleting them individually.";

    public ScriptPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SCRIPT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_SCRIPT, "Add button", MEDIUMWAIT);
    }

    public void addingScripts() {
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SCRIPT, "Name Textbox", MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEl_TYPE, "Type Label", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Type", MEDIUMWAIT);
       waitForSecs(10);
        safeClearAndType(TXTBOX_TYPE, "bat", "Entering type", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("bat")) {

                dbs3.get(i).click();
                break;
            }
        }
        type_add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(type_add);
        waitForSecs(20);
        safeClick(LABEL_CONTENT, "Server Feild", MEDIUMWAIT);
        safeClearAndType(CONTENT_TEXTAREA, "test", "Server name into textbox", MEDIUMWAIT);
        content_add = safeGetText(CONTENT_TEXTAREA, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "NExt button", MEDIUMWAIT);
        safeCheck(CHKBOX_RUNSCHEDULE, "Run Schedule checkbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Native Mouse Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equalsIgnoreCase("Native Mouse Click - raw - User Click SLA")) {

                dbs4.get(i).click();
                break;
            }
        }
        String sla = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        System.out.println(sla);
        // String[] parts = sla.split(" - ");
        //sla_add = parts[2]; // 004
        //System.out.println(sla_add);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void searchingForScript() {
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = SCRIPT;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);

    }

    public void verifyingAddedScript() {

        if (server_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && type_add.equals(driver.findElement(TYPE_GHOSTTEXT).getText())) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editScriptConfigurationWindow() {
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        // safeType(TXTBOX_SERVERNAME, EDITSCRIPT, "Name Textbox", MEDIUMWAIT);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del5 + EDITSCRIPT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEl_TYPE, "Type Label", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Type", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "PYTHON", "Entering type", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("PYTHON")) {

                dbs3.get(i).click();
                break;
            }
        }
        type_add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(type_add);
        safeClick(LABEL_CONTENT, "Server Feild", MEDIUMWAIT);
        String del6 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(CONTENT_TEXTAREA);
        searchField2.sendKeys(del5 + "test123");
        content_add = safeGetText(CONTENT_TEXTAREA, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addinSLA() {
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SCRIPT, "Name Textbox", MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEl_TYPE, "Type Label", MEDIUMWAIT);
        safeClick(TYPE_GHOSTTEXT, "Type", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TYPE, "bat", "Entering type", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("bat")) {

                dbs3.get(i).click();
                break;
            }
        }
        type_add = safeGetText(TYPE_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(type_add);
        waitForSecs(7);
        safeClick(LABEL_CONTENT, "Server Feild", MEDIUMWAIT);
        safeClearAndType(CONTENT_TEXTAREA, "test", "Server name into textbox", MEDIUMWAIT);
        content_add = safeGetText(CONTENT_TEXTAREA, "Server textbox value", MEDIUMWAIT);
        System.out.println(content_add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_NEXT, "NExt button", MEDIUMWAIT);
        safeCheck(CHKBOX_RUNSCHEDULE, "Run Schedule checkbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = SCRIPT;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeClick(USED_BY_ACTIONS_HYPERLINK, "Used by actions hyper link", MEDIUMWAIT);
    }

    public void verifyingAddedSLAsScriptWindow() {
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_SHOW_ADVANCED, "Advanced button", MEDIUMWAIT);
        safeClick(TARGET_BY_SLA_ADD_ICON, "Add icon", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(ACTION_SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(ACTION_SLA_TXTBOX, "Native User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size() - 1; i++) {

            if (dbs3.get(i).getText().equalsIgnoreCase("Native User Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        String sla = safeGetText(ACTION_SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        waitForSecs(10);
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
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
        waitForSecs(10);
    }

    public void navigatingToActionPageFrmScriptWindow() {
        waitForSecs(10);
        safeClick(USED_BY_ACTIONS_HYPERLINK, "Used by actions hyper link", MEDIUMWAIT);
        String Title = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(Title);
        String expectedText = SCRIPT + "-action";
        Assert.assertEquals(Title, expectedText);
        waitForSecs(10);
        By pageTitle = By.xpath("//h5[text()='Actions']");
        boolean page = isElementDisplayed(pageTitle);
        Assert.assertTrue(page);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        }catch (Exception e){
            System.out.println("Confirm delete buttom is not displaying");
        }

        safeClick(BTN_SCRIPT, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void verifyingPageIconsinScriptPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + SCRIPT + "')]");
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
        String expectedText = SCRIPT + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        String Notify = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(Notify);
        if(Notify.equals(NotifyText)) {
            mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
            safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
            waitForSecs(9);
            safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
            waitForSecs(5);
            safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
            waitForSecs(10);
            safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
            waitForSecs(10);

    }

}

    public void applyingFiltersInScriptPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + SCRIPT + "')]");
        waitForSecs(10);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, SCRIPT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }


    public void verifyingIconsInScriptEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, SCRIPT + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + SCRIPT + " - Cloned']");
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
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }
}