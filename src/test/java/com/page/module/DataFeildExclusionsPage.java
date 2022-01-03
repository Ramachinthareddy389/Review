package com.page.module;

import com.page.locators.CorrelationLocators;
import com.page.locators.DataFeildExclusionLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class DataFeildExclusionsPage extends SafeActions implements DataFeildExclusionLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    static int j;
    String Name_Add, KPIS_add, FeildName_add, Edited_Name_Add, Edited_Field_Name_add, Edit_FactType;
    Random random = new Random();
    String dname = "DataField";
    String dname1 = dname + random.nextInt(1500);
    String editDE1 = "DExclusionEdit" + random.nextInt(1500);


    //Constructor to define/call methods
    public DataFeildExclusionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnDataFeildExclusion() {
        waitForSecs(30);
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DATAFIELD_EXCLUSION, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
    }

    public void addingNewDataFieldExclusion() {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + dname1);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(LABEL_KPIS, "Server Feild", MEDIUMWAIT);
        safeClick(KPIS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_KPIS, "Alert", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Alert")) {

                dbs2.get(i).click();
                break;
            }
        }
        KPIS_add = safeGetText(KPIS_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(KPIS_add);
        safeClick(LABEL_FIELDNAME, "Server Feild", MEDIUMWAIT);
        safeClick(FEILDNAME_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FEILDNAME, "user.name", "Server name into textbox", MEDIUMWAIT);
       waitForSecs(20);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("user.name")) {

                dbs5.get(i).click();
                break;
            }
        }

        FeildName_add = safeGetText(FEILDNAME_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(FeildName_add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }

    public void verifyingFeildExclusionDetails() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(LABEL_FACTTYPE, "Server Feild", MEDIUMWAIT);
        String FactType = safeGetText(TXTBOX_FACTTYPE, "Server textbox value", MEDIUMWAIT);
        System.out.println(FactType);
        String expectedFactType = "SLA";
        waitForSecs(20);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) &&
                FeildName_add.equals(driver.findElement(FEILDNAME_GHOSTEXT).getText()) && expectedFactType.equals(driver.findElement(TXTBOX_FACTTYPE).getText())) {
            System.out.println("Data Field Exclusion details are valid");
            String text = driver.findElement(TXTBOX_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_NAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(FEILDNAME_GHOSTEXT).getText());
        } else {
            Assert.fail("Data Field Exclusion details are invalid");
        }

        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }


    public void editBusinessConfig() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + editDE1);
        Edited_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_FIELDNAME, "Server Feild", MEDIUMWAIT);
        safeClick(FEILDNAME_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_FEILDNAME, "system.name", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("system.name")) {

                dbs2.get(i).click();
                break;
            }
        }
        Edited_Field_Name_add = safeGetText(FEILDNAME_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Edited_Field_Name_add);

        safeClick(LABEL_FACTTYPE, "Server Feild", MEDIUMWAIT);
        safeClick(TXTBOX_FACTTYPE, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_FACTTYPE, "System:Disk Usage", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("System:Disk Usage")) {

                dbs5.get(i).click();
                break;
            }
        }
        Edit_FactType = safeGetText(TXTBOX_FACTTYPE, "Server textbox value", MEDIUMWAIT);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
    }

    public void verifyingEditedDataExcusionDetails() {
        safeType(TEXTBOX_TYPESEARCH, editDE1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = editDE1;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) &&
                Edited_Field_Name_add.equals(driver.findElement(FEILDNAME_GHOSTEXT).getText()) && Edit_FactType.equals(driver.findElement(TXTBOX_FACTTYPE).getText())) {
            System.out.println("Data Field Exclusion details are valid");
            String text = driver.findElement(TXTBOX_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_NAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(FEILDNAME_GHOSTEXT).getText());
        } else {
            Assert.fail("Data Field Exclusion details are invalid");
        }

        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Edit window", MEDIUMWAIT);
    }
    public void clickingOnMenuIcon(){
        safeClick(MENU_ICON,"Menu Icon",MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingDataExclusionFromDrillThroughPage() {
        waitForSecs(10);
        mouseHoverJScript(ICON_INFROMATIONINDRILLTHRGH, "Information icon in System header", "Drillthrogh Page", MEDIUMWAIT);
        waitForSecs(2);
        mouseHoverJScript(LABEL_TARGET, "System name label", "Popup", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(ICON_EYE, "Data field exclusion eye icon", MEDIUMWAIT);
    }

    public void navigatingToDataExclusionModule(){
        safeClick(MENU_ICON,"Menu icon",MEDIUMWAIT);
        safeClick(BTN_ANALYTICS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DATAFIELD_EXCLUSION, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingDataFieldExclusionDetailsFromRCApage(){
        waitForSecs(20);
        mouseHoverJScript(ICON_INFORMATION_RCA_PAGE, "Information icon in System header", "Drillthrogh Page", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_TARGET,"SYstem Name Label",MEDIUMWAIT);
        waitForSecs(5);
        mouseHoverJScript(LABEL_TARGET, "System name label", "Popup", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(ICON_EYE, "Data field exclusion eye icon", MEDIUMWAIT);
    }
    public void applyingFilters(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'"+dname1+"')]");
        mouseHoverJScript(SeachedText,"SeachedText","text",MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        //driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName =safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName,dname1);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void verifyingIconsInEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + dname1 + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(10);
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


    public void verifyingPageIconsInDataExclusionPage() {
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        //mouseHoverJScript(SELECTROW_CHKBOX, "Databse Name", "Mouse hover", MEDIUMWAIT);
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
        safeClick(BTN_CLONE,"clone button",MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label","Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = dname1+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
}
