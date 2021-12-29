package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.ComponentTypesLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class ComponentPage extends SafeActions implements ComponentTypesLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String AutoConfig = "AutoConfig" + "-" + random.nextInt(500);
    String EditConfig = "editConfig" + "-" + random.nextInt(500);
    String Component = "Component" + "-" + random.nextInt(500);
    String Cred = "Cred" + "-" + random.nextInt(500);
    String credEdited = "credEdited" + "-" + random.nextInt(500);
    String Name_Add, Criteria_Add, KPIS_add, Edited_Cred_Name, Edited_Cred_User_Name, monitoredServer_add, script_Add, Record2, Record1, AddedScenario1, AddedScenario2;


    public ComponentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to SSH page from automation module")
    public void clickingOnAutomation() {
        waitForSecs(20);
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ENGINE_SETTINGS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_COMPONENT_TYPES, "Add button", MEDIUMWAIT);

    }
    public void navigatingToComponentPage(){
        safeClick(BTN_COMPONENT_TYPES, "Add button", MEDIUMWAIT);
    }
    public void adding1stComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
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
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedComponent() {
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


    public void adding2ndComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
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
        safeCheck(CUSTOMRULE_CHKBOX, "Custom rule", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }
    public void verifyingPageIcons() {
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Component + "')]");
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
        String expectedText = Component + " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(25);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        safeClick(BTN_DELETE, "Delete Slas", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void applyingFilters() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Component + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        //driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Component);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }

    }
    public void verifyingIconsInEditWindow() {
        safeType(TEXTBOX_TYPESEARCH, Component + "\n", "Alert Name into type search");
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + Component + " - Cloned']");
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
        try {
            if (isElementDisplayed(CONFIRM_DELETE)) {
                safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
                waitForSecs(15);
            }
        } catch (Exception e) {
            System.out.println("Confirm delete buttom is not displaying");
        }
    }


    //Credentials

    public void clickingOnAddCredentials() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_CREDENTIALS, "Credentials", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
    }

//Credentails config

    public void addingNewCredentials() {
        // safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SOFT_NAME, Cred, "Name into textbox", MEDIUMWAIT);
        safeClick(LABEL_USERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_USERNAME, Cred, "Name into textbox", MEDIUMWAIT);

        safeClick(LABEL_PASSWORD, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PASSWORD, Cred, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "close button", MEDIUMWAIT);
    }

    public void verifyingAddedCredentials() {
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

    public void editCredentialsConfigs() {
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, Cred + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + credEdited);
        Edited_Cred_Name = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_USERNAME);
        searchField1.sendKeys(del1 + credEdited);
        Edited_Cred_User_Name = safeGetAttribute(TXTBOX_USERNAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        safeClick(BTN_CLEAR, "Save button", MEDIUMWAIT);
    }

    public void changePasswordInEditCredWindow() {
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, Cred + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CHNAGE_PASSWORD, "Change password button", MEDIUMWAIT);
        safeType(TXTBOX_PASSWORD, "test", "Password textbox", MEDIUMWAIT);
        safeType(TXTBOX_CONFIRM_PASSWRD, "test", "Confirm password textbox", MEDIUMWAIT);
        safeClick(BTN_UPDATE_PASSWRD, "update password button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
       // acceptAlert();
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

    public void verifyingEditedAddedCredentials() {
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, credEdited + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = credEdited;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void adding3rdComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(4).click();
        //safeClick(LABEL_COMPONENT_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(20);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        safeType(TXTBOX_FILE_PATTERN, "File Pattern", "File Pattern", MEDIUMWAIT);
        safeType(TXTBOX_TARGET_QUEUE, "Target Queue", "File Pattern", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "close button", MEDIUMWAIT);
    }

    public void adding4thComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(5).click();
        //safeClick(LABEL_COMPONENT_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        safeType(TXTBOX_EXECUTABLE, Component, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "close button", MEDIUMWAIT);

    }

    public void adding5thComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(6).click();
        //safeClick(LABEL_COMPONENT_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);

        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "close button", MEDIUMWAIT);

    }

    public void adding8thComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(9).click();
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeType(TXTBOX_ROOT, "Root", "Root textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        safeType(TXTBOX_PATH, "Path", "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "close button", MEDIUMWAIT);
    }

    public void adding9thComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(10).click();
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        safeType(TXTBOX_OID, "OID", "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "close button", MEDIUMWAIT);
    }

    public void adding10thComponent() {
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        driver.findElements(LIST_COMPONENT_TYPES).get(11).click();
        safeType(TXTBOX_NAME, Component, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(LABEL_DRIVER, "Server Feild", MEDIUMWAIT);
        safeClick(DRIVER_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DRIVER, "Chrome", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Chrome")) {

                dbs1.get(i).click();
                break;
            }
        }
        safeType(TXTBOX_DRIVER_PATH, Component, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingEditedAllComponentTypes() {
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, Component + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + credEdited);
        Edited_Cred_Name = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CLEAR, "Save button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, credEdited + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = credEdited;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    //Display Settings
    public void clickingOnDisplaySettings() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_DISPLAY_SETTINGS, "Display settings label", MEDIUMWAIT);
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, "ActionConfig" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + credEdited);
        Edited_Cred_Name = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_NAME);
        searchField1.sendKeys(del1 + credEdited);
        Edited_Cred_Name = safeGetAttribute(TXTBOX_IDENTIFIER, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetText(EDITWINDOW_TITLE, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = credEdited;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        String del2 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField2 = driver.findElement(TXTBOX_NAME);
        searchField2.sendKeys(del2 + "ActionConfig");
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Close Edit Window", MEDIUMWAIT);
    }

    //Distribution list

    public void clickingOnAddDistributionList(String name, String email) {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DISTRIBUTION_LISTS, "Credentials", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeType(TXTBOX_NAME, name, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_EMAIL_ADDRESS, "Server Feild", MEDIUMWAIT);
        safeClick(EMAIL_ADDRESS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_EMAIL_ADDRESS, email, "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals(email)) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedDistributionList(String name, String email) {
        safeType(TEXTBOX_TYPESEARCH, name + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = name;
        Assert.assertEquals(pageTitle, expectedText);
        String distributionName = safeGetAttribute(TXTBOX_NAME, "value", "Distribution List Name", MEDIUMWAIT);
        Assert.assertEquals(distributionName, expectedText);
        String actualText = safeGetText(MEMBERS_HYPERLINK, "Member hyperlink", MEDIUMWAIT);
        expectedText = email;
        Assert.assertEquals(actualText, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addMembersInEditDistributionListwindow(String name) {
        safeType(TEXTBOX_TYPESEARCH, name + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        safeClick(BTN_REMOVE_MEMBER, "Delete button", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save Button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(MEMBER_ADDICON, "Member add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        safeClick(LABEL_EMAIL_ADDRESS, "Server Feild", MEDIUMWAIT);
        safeClick(EMAIL_ADDRESS_GHOSTTEXT_EDIT_WINDOW, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_EMAIL_ADDRESSS_EDIT_WINDOW, "rama.chinthareddy@zenq.com", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("rama.chinthareddy@zenq.com")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingEditDistributionListConfig(String name) {
        safeType(TEXTBOX_TYPESEARCH, name + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + "DistributionList");
        waitForSecs(15);
        safeClick(BTN_SAVE, "Save configuaration", MEDIUMWAIT);
        waitForSecs(15);
        String actualText = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        String expectedText = "DistributionList";
        Assert.assertEquals(actualText, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void addingEmailFromDistriist(String name, String email) {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DISTRIBUTION_LISTS, "Credentials", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeType(TXTBOX_NAME, name, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_EMAIL_ADDRESS, "Server Feild", MEDIUMWAIT);
        safeClick(EMAIL_ADDRESS_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_EMAIL_ADDRESS, email, "Server name into textbox", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(DASHBOARD_LABEL, "Select or create dashboard text box", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void deleteDistributionList(String name) {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_DISTRIBUTION_LISTS, "Credentials", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, name + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        //safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        safeClick(BTN_DISTRIBUTION_LISTS, "Credentials", MEDIUMWAIT);

    }

    public void navigatingToCredWindow() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_CREDENTIALS, "Credentials", MEDIUMWAIT);
        waitForSecs(20);
        safeType(TEXTBOX_TYPESEARCH, Cred + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void addingAutoConfig() {
        waitForSecs(20);
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ENGINE_SETTINGS, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(LABEL_AUTO_CONFIG, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add Icon", MEDIUMWAIT);
        safeType(TXTBOX_NAME, AutoConfig, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeType(TXTAREA_CRITERIA, AutoConfig, "Name into textbox", MEDIUMWAIT);
        Criteria_Add = safeGetAttribute(TXTAREA_CRITERIA, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Criteria_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedAutoConfig() {
        safeType(TEXTBOX_TYPESEARCH, AutoConfig + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        String actualText = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        String expectedText = AutoConfig;
        Assert.assertEquals(actualText, expectedText);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void editAutoConfig() {
        safeType(TEXTBOX_TYPESEARCH, AutoConfig + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeTypeUsingChrod(TXTAREA_CRITERIA, EditConfig, "Name into textbox", MEDIUMWAIT);
        Criteria_Add = safeGetAttribute(TXTAREA_CRITERIA, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Criteria_Add);
        safeClick(BTN_VALIDATE, "Validate button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE, "Save configuaration", MEDIUMWAIT);
        waitForSecs(10);
        String actualText = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        String expectedText = EditConfig;
        Assert.assertEquals(actualText, expectedText);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void repplyToServers() {
        safeType(TEXTBOX_TYPESEARCH, AutoConfig + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REAPPLY_TO_SERVERS, "Reapply to servers", MEDIUMWAIT);
        String notify = safeGetText(NOTIFY_FOOTER, "Footer", MEDIUMWAIT);
        String expectedText = "Reapplied config to all matching servers.";
        Assert.assertEquals(notify, expectedText);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }

    public void addingProfileBinding() {
        safeType(TEXTBOX_TYPESEARCH, AutoConfig + "\n", "Distribution Name into type search");
        System.out.println("entered dbtext");
        safeClickingOnSearchingConfig(LISTOFDBS,AutoConfig);
 /*       waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Database Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);*/
        safeClick(PROFILE_BINDINGS_ADDICON, "Add icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(EMAIL_ADDRESS_GHOSTTEXT_EDIT_WINDOW, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_EMAIL_ADDRESSS_EDIT_WINDOW, "Apache HTTP Server", "Name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Apache HTTP Server")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(15);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingAddedProfileBinding() {
        String text = safeGetText(ADDED_PROFILE_BINDING, "Added profile binding", MEDIUMWAIT);
        String expectedText = "Apache HTTP Server";
        Assert.assertEquals(text, expectedText);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }


}
