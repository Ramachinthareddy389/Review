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
    String NotifyText = "Unable to delete configuration entry while it is referenced by other objects.";


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
        safeClearAndType(TXTBOX_SLA, "Native Mouse Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
       waitForSecs(10);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Native Mouse Click - raw - User Click SLA")) {

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
        waitForSecs(20);
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(20);
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
        String addedScript = safeGetText(ADDED_SCRIPT,"Script",MEDIUMWAIT);
        System.out.println(addedScript);
        Assert.assertEquals(script_Add,addedScript);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
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
        safeClick(BTN_SHOW_ADVANCED,"Advanced button",MEDIUMWAIT);
        waitForSecs(9);
        safeClick(TARGET_BY_SLA_ADD_ICON,"Add icon",MEDIUMWAIT);
        safeClick(LABEL_SLA, "Server Feild", MEDIUMWAIT);
        safeClick(ACTION_SLA_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(ACTION_SLA_TXTBOX, "Native Mouse Click - raw - User Click SLA", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs3.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Native Mouse Click - raw - User Click SLA")) {

                dbs3.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        String sla = safeGetText(ACTION_SLA_GHOSTTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(sla);
        String[] parts = sla.split(" - ");
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(10);
        sla_add = parts[2]; // 004
        System.out.println(sla_add);
    }

    public void navigateToScriptPageFrmLocalProgrammes(){
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW,"edit wondow",MEDIUMWAIT);
        safeClick(SCRIPT_LINK, "Script Hyper Link", MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Scripts");
        waitForSecs(10);
        String addedScript = safeGetText(EDIT_TXTBOX_SCRIPT,"Script",MEDIUMWAIT);
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
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        String Notify= safeGetText(FOOTERTEXT,"Notification",MEDIUMWAIT);
        System.out.println(Notify);
        Assert.assertEquals(Notify,NotifyText);
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

    public void navigateToSLAPageFrmLocalPrgms(){
        safeClick(CLOSE_EDITWINDOW,"Close Edit window",MEDIUMWAIT);
        safeClick(SLA_LINK,"Sla Hyper link",MEDIUMWAIT);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Service Level Agreements");
        waitForSecs(10);
        String SLAname = safeGetAttribute(SLA_TXTBOX,"value","Script",MEDIUMWAIT);
        System.out.println(SLAname);
        Assert.assertEquals(SLAname, "User Click SLA");
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW,"Close Edit window",MEDIUMWAIT);
        waitForSecs(5);

    }
    public void verifyingPageIconsInLocalPrgms() {
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
        String expectedText = LCLPRGM + " - Cloned";
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
        safeClick(BTN_EXECUTE,"Button execute",MEDIUMWAIT);
        String actualText= safeGetText(FOOTERTEXT,"Notification",MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText,"Action(s) queued");
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
    public void applyingFiltersInLocalprgmPage() {
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
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, LCLPRGM);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void VerifyIconsInLocalPrgrmsEditConfigwindow()
    {
        safeType(TEXTBOX_TYPESEARCH, LCLPRGM + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + LCLPRGM + " - Cloned']");
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
    }

    public void validateTheFeildsViewIconInLocalPrgrmsWindow(){
        waitForSecs(10);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        waitForSecs(5);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.SCRIPT_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.SCRIPT_VALUES.length - 1; j++) {
            System.out.println("Values are " + dashBoardData.SCRIPT_VALUES[j]);
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

}
