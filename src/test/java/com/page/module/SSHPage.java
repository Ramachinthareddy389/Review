package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.SSHLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SSHPage extends SafeActions implements SSHLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String SCRIPT = "Script" + "-" + random.nextInt(500);
    String SSH = "SSH" + "-" + random.nextInt(500);
    String WMI = "WMI" + "-" + random.nextInt(500);
    String Cred_add, server_Add, program_Add, sla_add, monitoredServer_add, script_Add, Record2, Record1, AddedScenario1, AddedScenario2;
    String NotifyText = "Unable to delete configuration entry while it is referenced by other objects.";

    public SSHPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to SSH page from automation module")
    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SSH, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_SSH, "Add button", MEDIUMWAIT);
        waitForSecs(10);
    }

    @Step("Creating New SSh page")
    public void addingSSH() {
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SSH, "Name Textbox", MEDIUMWAIT);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);

        safeClick(LABEl_SERVER, "Server Feild", MEDIUMWAIT);
        safeClick(SERVER_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SERVER, "QA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("QA")) {

                dbs3.get(i).click();
                break;
            }
        }
        monitoredServer_add = safeGetText(SERVER_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(monitoredServer_add);


        safeClick(LABEl_CREDENTIALS, "Server Feild", MEDIUMWAIT);
        safeClick(CREDENTIALS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CREDENTIALS, "QA Cred", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("QA Cred")) {

                dbs4.get(i).click();
                break;
            }
        }
        Cred_add = safeGetText(CREDENTIALS_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Cred_add);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_PROGRAM, "Server Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROGRAM, "Program", "Name Textbox", MEDIUMWAIT);
        program_Add = safeGetAttribute(TXTBOX_PROGRAM, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(program_Add);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        waitForSecs(5);
        safeCheck(CHKBOX_RUNSCHEDULE, "Run Schedule checkbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SLA, "Native User Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs7 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs7.size());
        for (int i = 0; i < dbs7.size(); i++) {

            if (dbs7.get(i).getText().equals("Native User Click - raw - User Click SLA")) {

                dbs7.get(i).click();
                break;
            }
        }
        String sla2 = safeGetText(SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla2);

        String[] parts = sla2.split(" - ");
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    @Step("Verifying configured values in SSH page")
    public void verifyingAddedSSH() {
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
        Assert.assertEquals(sla_add, driver.findElement(HYPERLINK_SLAs).getText());
        Assert.assertEquals(program_Add, driver.findElement(TXTBOX_PROGRAM).getAttribute("value"));
        Assert.assertEquals(server_Add, driver.findElement(TXTBOX_SERVERNAME).getAttribute("value"));
        Assert.assertEquals(monitoredServer_add, driver.findElement(EDITED_MONITORED_TXTBOX).getText());
        Assert.assertEquals(Cred_add, driver.findElement(EDITED_CREDENTIALS_TXTBOX).getText());
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    @Step("Adding script from SSH edit window")
    public void AddedScriptInSSHEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(SCRIPT_ADDICON, "Add icon", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_NAME, SCRIPT, "Name Textbox", MEDIUMWAIT);
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
        safeClick(CONTENT_TEXTAREA, "Metric Exp", MEDIUMWAIT);
        WebElement metric = driver.findElement(CONTENT_TEXTAREA);
        metric.sendKeys("test123");
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);

    }

    public void deletingAddedSSh() {
        safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    @Step("Verifying added script in SSH edit window")
    public void verifyingaddedScriptInSSHPage() {
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
        waitForSecs(5);

    }

    @Step("Navigating to WMI page from automation module")
    public void clickingOnWMIInAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_WMI, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_WMI, "Add button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void navigateToWMIpage() {
        safeClick(BTN_WMI, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_WMI, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    @Step("Editing/modifying the values in SSH edit window")
    public void addingEditedSSH() {
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
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del5 + WMI);
        server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);

        safeClick(LABEL_MONITORED_SERVER, "Server Feild", MEDIUMWAIT);
        safeClick(SERVER_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeType(TXTBOX_SERVER, "QA Test", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("QA Test")) {

                dbs3.get(i).click();
                break;
            }
        }
        monitoredServer_add = safeGetText(EDITED_MONITORED_TXTBOX, "Server textbox value", MEDIUMWAIT);
        safeClick(LABEL_EDITED_CREDENTIALS, "Server Feild", MEDIUMWAIT);
        safeClick(CREDENTIALS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CREDENTIALS, "QA Datamart", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("QA Datamart")) {

                dbs4.get(i).click();
                break;
            }
        }
        Cred_add = safeGetText(CREDENTIALS_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Cred_add);
        safeClick(LABEL_PROGRAM, "Server Feild", MEDIUMWAIT);
        String del6 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_PROGRAM);
        searchField1.sendKeys(del6 + "EditedProgram");
        program_Add = safeGetAttribute(TXTBOX_PROGRAM, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(program_Add);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);

    }

    @Step("Verifying the edited values in SSH edit window ")
    public void verifyingAfterSSHEditedConfigValues() {
        safeType(TEXTBOX_TYPESEARCH, WMI + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = WMI;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        Assert.assertEquals(program_Add, driver.findElement(TXTBOX_PROGRAM).getAttribute("value"));
        Assert.assertEquals(server_Add, driver.findElement(TXTBOX_SERVERNAME).getAttribute("value"));
        Assert.assertEquals(monitoredServer_add, driver.findElement(EDITED_MONITORED_TXTBOX).getText());
        Assert.assertEquals(Cred_add, driver.findElement(EDITED_CREDENTIALS_TXTBOX).getText());
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    //Click module

    @Step("Navigating to Click page from automation module")
    public void clickingOnClickModuleInAutomation() {
        waitForSecs(10);
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLICK, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_CLICK, "Add button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingNewRecordingInClickPage() throws InterruptedException, AWTException {
        safeClick(LABEL_RECORD, "Record option", MEDIUMWAIT);
        waitForSecs(15);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitForSecs(10);
        driver.findElements(By.cssSelector("[aria-label='Add to Chrome']")).get(0).click();
        waitForSecs(40);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
    }

    public void switchingToMainWindow() {

        waitForSecs(30);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        waitForSecs(10);
        safeClick(BTN_ADDICON_CLICK, "Add button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_RECORD, "Record option", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void startedRecording() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        waitForSecs(10);
        driver.navigate().to("https://www.google.com/");
        driver.findElements(By.xpath("//center/input[@aria-label='Google Search']")).get(1).click();
        driver.navigate().back();
        System.out.println(tabs.size());
        System.out.println(driver.switchTo().window(tabs.get(3)));
        Record1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        System.out.println(Record1);
        Record2 = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
        System.out.println(Record2);
        safeClick(BTN_STOP, "Stop button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EXPORT, "Export button", MEDIUMWAIT);
        waitForSecs(10);
        System.out.println(driver.switchTo().window(tabs.get(0)));

    }

    public void addingClickConfigurations() {
        safeClick(LABEL_BRWSER_DRIVER_PATH, "Browser driver path", MEDIUMWAIT);
        safeType(TXTBOX_BRSER_DRIVER_PATH, "Click", "Name Textbox", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SSH, "Name Textbox", MEDIUMWAIT);

        safeClick(LABEL_APP_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(LABEL_APP_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_APP_NAME, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Android")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_SKIP, "Skip button", MEDIUMWAIT);
        safeClick(BTN_SKIP, "Skip button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE_CLICK_WINDOW, "close button", MEDIUMWAIT);
    }

    public void verifyingAddedClickActions() {
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
        waitForSecs(5);
        AddedScenario1 = safeGetText(HYPERLINK_BROWSER_RESIZE, "Hyperlink value", MEDIUMWAIT);
        AddedScenario2 = safeGetText(HYPERLINK_CLICK_IN_INPUT, "Hyperlink value", MEDIUMWAIT);
        String expectedText1 = "Browser Resize";
        String expectedText2 = "Click on input submit";
        Assert.assertEquals(expectedText1, AddedScenario1);
        Assert.assertEquals(expectedText2, AddedScenario2);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingAddedClickActionsUsingJsonFile() {
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
        waitForSecs(5);
        AddedScenario1 = safeGetText(HYPERLINK_BROWSER_RESIZE, "Hyperlink value", MEDIUMWAIT);
        AddedScenario2 = safeGetText(HYPERLINK_CLICK_IN_INPUT, "Hyperlink value", MEDIUMWAIT);
        String expectedText1 = "Browser Resize";
        String expectedText2 = "Click";
        Assert.assertEquals(expectedText1, AddedScenario1);
        Assert.assertEquals(expectedText2, AddedScenario2);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void addingJSonFileUsingImport() throws InterruptedException, AWTException {
        safeClick(LABEL_IMPORT_RECORD, "Importing json file", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(ICON_IMPORT, "Import icon", MEDIUMWAIT);
        StringSelection sel = new StringSelection("D:\\DecProject\\germain-test-automation\\ConfigFiles\\germainapm-recorder-output.json");
        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        System.out.println("selection" + sel);
        // This will scroll down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,350)");
        Thread.sleep(5000);

        System.out.println("Browse button clicked");

        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);
        // Press Enter
        // robot.keyPress(KeyEvent.VK_ENTER);
        // Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);
        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        // Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    public void addingCUStomeRole() {
        safeClick(LABEL_CUSTOM_ROLE, "Record option", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(LABEL_URL, "URL Label", MEDIUMWAIT);
        safeType(TXTBOX_URL, "http://google.com", "Url", MEDIUMWAIT);
        safeClick(LABEL_BRWSER_DRIVER_PATH, "Browser driver path", MEDIUMWAIT);
        safeType(TXTBOX_BRSER_DRIVER_PATH, "Click", "Name Textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SSH, "Name Textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SSH, "Name Textbox", MEDIUMWAIT);
        safeClick(LABEL_APP_NAME, "Server Feild", MEDIUMWAIT);
        safeClick(LABEL_APP_NAME_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_APP_NAME, "Android", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Android")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_SKIP, "Skip button", MEDIUMWAIT);
        safeClick(BTN_SKIP, "Skip button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE_CLICK_WINDOW, "close button", MEDIUMWAIT);
    }

    public void verifyingCustomRulesConfigs() {
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
        waitForSecs(5);
        AddedScenario1 = safeGetText(RULES_HYPERLINK, "Hyperlink value", MEDIUMWAIT);
        Assert.assertEquals(SSH, AddedScenario1);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingElementSelectorsInEditSceanrioWindow() {
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
        waitForSecs(5);
        safeClick(SCENARIO_STEP_ADD_ICON, "Scenario step add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_STEPNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_STEPNAME, SSH, "Name Textbox", MEDIUMWAIT);
        safeClick(LABEL_STEPTYPE, "Server Feild", MEDIUMWAIT);
        safeClick(STEPTYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_STEPTYPE, "Click", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Click")) {

                dbs3.get(i).click();
                break;
            }
        }

        safeClick(LABEL_SELECTOR_TYPE, "Server Feild", MEDIUMWAIT);
        safeClick(SELECTOR_TYPE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SELECTOR_TYPE, "By ID", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("By ID")) {

                dbs5.get(i).click();
                break;
            }
        }
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE_CLICK_WINDOW, "close button", MEDIUMWAIT);
        waitForSecs(20);
        AddedScenario1 = safeGetText(HYPERLINK_ADDED_SELECTOR, "Hyperlink value", MEDIUMWAIT);
        Assert.assertEquals(SSH, AddedScenario1);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }

    public void verifyingExportingActionsOnClosingGermainApm() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        waitForSecs(10);
        driver.navigate().to("https://www.google.com/");
        driver.findElements(By.xpath("//center/input[@aria-label='Google Search']")).get(1).click();
        driver.navigate().back();
        System.out.println(tabs.size());
        System.out.println(driver.switchTo().window(tabs.get(3)));
        Record1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        System.out.println(Record1);
        Record2 = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
        System.out.println(Record2);
        safeClick(BTN_STOP, "Stop button", MEDIUMWAIT);
        waitForSecs(10);
        System.out.println(driver.switchTo().window(tabs.get(0)));
        driver.close();
        waitForSecs(10);
        System.out.println(tabs.size());
        System.out.println(driver.switchTo().window(tabs.get(3)));
        safeClick(BTN_EXPORT, "Export button", MEDIUMWAIT);
        String home = System.getProperty("user.home");
        String file_name = "germainapm-recorder-output (1)" + ".json";
        System.out.println(file_name);
        String downloadPath = home + "\\Downloads";
        System.out.println(downloadPath);
        waitForSecs(10);
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        System.out.println(fileName);
        Assert.assertTrue(fileName.equals(file_name));
        File file = new File(downloadPath + "\\" + fileName);
        if (file.delete())
            System.out.println("file deleted");
        else {
            System.out.println("file not deleted");
        }
    }

    @Step("Taking latest file from windows")
    private File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public void clickingOnSSH() {
        safeClick(BTN_SSH, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void verifyingPageIconsInSSH() {
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + SSH + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        waitForSecs(10);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        waitForSecs(10);
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
        String expectedText = SSH + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        waitForSecs(25);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);

    }
    public void  verifyingEditIconFunctionalityInWMI(){
        waitForSecs(10);
        safeClick(BTN_EDIT, "Edit button", MEDIUMWAIT);
        boolean editTitle = isElementDisplayed(EDIT_HEADER_WMI);
        Assert.assertTrue(editTitle);
        List<WebElement> chkboxes = driver.findElements(CHEKBOXES_EDITWINDOW_WMI);
        for (int i = 0; i <= chkboxes.size() - 1; i++) {
            chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES_WMI, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EXECUTE, "Button execute", MEDIUMWAIT);
        String actualText = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Action(s) queued");
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        String Notify = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(Notify);
        if (Notify.equals(NotifyText)) {
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

    public void  verifyingEditIconFunctionalityInSSH(){
        waitForSecs(10);
        safeClick(BTN_EDIT, "Edit button", MEDIUMWAIT);
        boolean editTitle = isElementDisplayed(EDIT_HEADER);
        Assert.assertTrue(editTitle);
        List<WebElement> chkboxes = driver.findElements(CHEKBOXES_EDITWINDOW);
        for (int i = 0; i <= chkboxes.size() - 1; i++) {
            chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EXECUTE, "Button execute", MEDIUMWAIT);
        String actualText = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Action(s) queued");
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        String Notify = safeGetText(FOOTERTEXT, "Notification", MEDIUMWAIT);
        System.out.println(Notify);
        if (Notify.equals(NotifyText)) {
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
    public void applyFiletrsInClickPage(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + SSH + "')]");
        waitForSecs(10);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, SSH);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void applyingFiltersInSSHPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + SSH + "')]");
        waitForSecs(10);
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, SSH);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void verifyingIconsInSSHEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + SSH + " - Cloned']");
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


    public void validateTheFeildsViewIconInSSHWindow() {
        safeType(TEXTBOX_TYPESEARCH, SSH + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        waitForSecs(10);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        waitForSecs(5);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.SSH_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.SSH_VALUES.length - 1; j++) {
            System.out.println("Values are " + dashBoardData.SSH_VALUES[j]);
        }
        safeClick(CLOSE_ICON, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void addingScriptInLocalProgramsEditWindow() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Dropdown field", MEDIUMWAIT);
        waitForSecs(10);
        By SeachedText = By.xpath("//div[contains(text(),'" + SSH + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SCRIPT_ADDICON, "Add icon", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_NAME, SCRIPT, "Name Textbox", MEDIUMWAIT);
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
        safeClick(CONTENT_TEXTAREA, "Metric Exp", MEDIUMWAIT);
        WebElement metric = driver.findElement(CONTENT_TEXTAREA);
        metric.sendKeys("test123");
        waitForSecs(20);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
    }

    public void navigateToScriptPageFrmSSHPage() {
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "edit wondow", MEDIUMWAIT);
        safeClick(SCRIPT_LINK, "Script Hyper Link", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Scripts");
        waitForSecs(10);
        String addedScript = safeGetText(EDIT_TXTBOX_SCRIPT, "Script", MEDIUMWAIT);
        System.out.println(addedScript);
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);

    }

    public void navigateToSLAPageFrmSSHPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(15);
        safeClick(DROPDOWN_FEILDS, "Dropdown field", MEDIUMWAIT);
        waitForSecs(15);
        By SeachedText = By.xpath("//div[contains(text(),'" + SSH + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        safeClick(SLA_LINK, "Sla Hyper link", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Service Level Agreements");
        waitForSecs(10);
        String SLAname = safeGetAttribute(SLA_TXTBOX, "value", "Script", MEDIUMWAIT);
        System.out.println(SLAname);
        Assert.assertEquals(SLAname, "Agent Desktop Click");
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);
        waitForSecs(5);

    }

    public void deletingAddedSSHConfig() {
        safeClick(BTN_SSH, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(15);
        safeClick(DROPDOWN_FEILDS, "Dropdown field", MEDIUMWAIT);
        waitForSecs(15);
        By SeachedText = By.xpath("//div[contains(text(),'" + SSH + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
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
