package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.DBInstancesLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class DBInstancesPage extends SafeActions implements DBInstancesLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Name_Add, DatabaseName_Add, InstanceName_Add, Port_Add, Server_Add, Vendor_add;
    String DbTitle = dashBoardData.ticketTitle
            + " - " + random.nextInt(500);

    public DBInstancesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnDbInstances() {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DBINSTANCES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void addingNewDbinstances() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, "Dbinstancename", "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEL_SERVER, "Server Feild", MEDIUMWAIT);
        safeClick(SERVER_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_SERVER, "Oracle Database Server", "Server name into textbox", MEDIUMWAIT);

        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);

        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Oracle Database Server")) {

                dbs1.get(i).click();
                break;
            }
        }
        Server_Add = safeGetText(SERVER_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        safeClick(LABEL_VENDOR_NAME, "Vendor Feild", MEDIUMWAIT);
        safeClick(VENDOR_NAME_GHOSTTEXT, "Vendor Name ghost text", MEDIUMWAIT);
        safeClearAndType(TXTBOX_VENDOR_NAME, "ORACLE", "Vendor name into textbox", MEDIUMWAIT);
        List<WebElement> db = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + db.size());
        for (int i = 0; i < db.size(); i++) {

            if (db.get(i).getText().equals("ORACLE")) {

                db.get(i).click();
                break;
            }
        }
        String vendor = safeGetText(VENDOR_NAME_GHOSTTEXT, "Name textbox value", MEDIUMWAIT);
        String vendor1 = vendor.toLowerCase() + " " + "DB";
        Vendor_add = vendor1.replaceFirst("o", "O");
        System.out.println(vendor);
        System.out.println("Before adding db :" + Vendor_add);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_PORTNUMBER, "Port number feild", MEDIUMWAIT);
        safeType(TXTBOX_PORTNUMBER, "5040", "Portnumber", MEDIUMWAIT);
        Port_Add = safeGetAttribute(TXTBOX_PORTNUMBER, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEL_DATABASENAME, "Dabase name Feild", MEDIUMWAIT);
        safeType(TXTBOX_DATABASENAME, "Oracle", "Database");
        DatabaseName_Add = safeGetAttribute(TXTBOX_DATABASENAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(LABEL_INSTANCENAME, "Instance Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_INSTANCENAME, "Instance", "Instance Name", MEDIUMWAIT);
        InstanceName_Add = safeGetAttribute(TXTBOX_INSTANCENAME, "value", "Name textbox value", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);


    }

    public void verifyingDbInstanceNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = "Dbinstancename";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && DatabaseName_Add.equals(driver.findElement(TXTBOX_DATABASENAME).getAttribute("value")) &&
                InstanceName_Add.equals(driver.findElement(TXTBOX_INSTANCENAME).getAttribute("value")) && Port_Add.equals(driver.findElement(TXTBOX_PORTNUMBER).getAttribute("value")) &&
                Vendor_add.equals(driver.findElement(VENDOR_NAME_GHOSTTEXT).getText()) && Server_Add.equals(driver.findElement(SERVER_GHOSTEXT).getText())) {
            System.out.println("Ticket details are valid");
            String text = driver.findElement(TXTBOX_NAME).getAttribute("value");
            System.out.println(text);
            waitForSecs(7);
            System.out.println("Name: " + driver.findElement(TXTBOX_NAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_DATABASENAME).getAttribute("value") +
                    " Instance Name: " + driver.findElement(TXTBOX_INSTANCENAME).getAttribute("value") + " Port: " + driver.findElement(TXTBOX_PORTNUMBER).getAttribute("value") +
                    " Vendor: " + driver.findElement(VENDOR_NAME_GHOSTTEXT).getText() + "Server Name :" + driver.findElement(SERVER_GHOSTEXT).getText());
        } else {
            Assert.fail("Ticket details are invalid");
        }
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void ediingConfiguration() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(TXTBOX_NAME, "Name textbox", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + "test" + 123);
        waitForSecs(5);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, "test123" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String EditedText = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(EditedText);
        Assert.assertEquals(EditedText, "test123");
    }

    public void verifyingPageIconsInDbinstancespage() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(30);
        By SELECTROW_CHKBOX1 = By.xpath("//div[@aria-label='Select Row']/following-sibling::div[2]/span/span[text()='Dbinstancename']/../../parent::div/descendant::input[1]");
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        By ELEMENT_STATUS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span/mark[text()='Dbinstancename']/../../..//parent::div/div[1]/descendant::input");
       // isElementSelected(ELEMENT_STATUS);
        boolean b1 =  driver.findElement(ELEMENT_STATUS).isSelected();
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(ELEMENT_STATUS);
        System.out.println(row);
        Assert.assertFalse(row);
        waitForSecs(9);
        By SELECTROW_CHKBOX2 = By.xpath("//div[@aria-label='Select Row']/following-sibling::div[2]/span/span/mark[text()='Dbinstancename']/../../../parent::div/descendant::input[1]");
        safeJavaScriptClick(SELECTROW_CHKBOX2, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = "Dbinstancename"+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    public void applyingFilters() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(20);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'Dbinstancename')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        //  mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, "Dbinstancename");
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);


    }
    public void navigateToHardwarePageFrmDbinstnacePage() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(10);
        By locator = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span[text()='Dbinstancename']/../../following-sibling::div[2]/span/button");
        // mouseHoverJScript(locator, "Database Name", "Mouse hover", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(locator, "KPi Hyper Link", MEDIUMWAIT);
        waitForSecs(15);
        String actualText = safeGetText(Title_DRILLTHROUGH, "title", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, "Hardware");
        waitForSecs(10);
        String pageTitle = safeGetText(TITLE_IN_ALERTTEMPLATE, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String alertName = safeGetAttribute(KPINAME_TXTBOX, "value", "Added Alert template", MEDIUMWAIT);
        System.out.println(alertName);
        Assert.assertEquals(pageTitle, alertName);
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW, "Close Edit window", MEDIUMWAIT);
        safeClick(BTN_DBINSTANCES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

  public void viewDataWithFeildsForViewIcon() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        boolean b=isElementDisplayed(SERVER_TEXT);
        Assert.assertTrue(b);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.SERVER_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.SERVER_VALUES.length; j++) {
            System.out.println("Values are " + dashBoardData.SERVER_VALUES[j]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void verifyingIconsInEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, "Dbinstancename" + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + "Dbinstancename" + " - Cloned']");
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
}
