package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.SoftwareLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SoftwarePage extends SafeActions implements SoftwareLocators {

    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    String Server_Add, desc, techStack, category_Add, acess_Means, search_Tags,Server_Add1, desc1, techStack1, category_Add1, acess_Means1, search_Tags1;
    Random random = new Random();
    String NodeJS = "NodeJs" + " - " + random.nextInt(500);
    String WebUXAgent = "WebUXAgent" + " - " + random.nextInt(500);

    //Constructor to define/call methods
    public SoftwarePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnSoftware() {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SOFTWARE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
    }

    public void addingNewSoftware(String DbTitle) {
        waitForSecs(10);
        //safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, DbTitle, "Name into textbox", MEDIUMWAIT);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_DESC, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_DESC, DbTitle, "Name into textbox", MEDIUMWAIT);
        desc = safeGetAttribute(TXTBOX_DESC, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(desc);
        safeClick(LABEL_TECHSTACK, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_TECKSTACK, "Techstack", "Name into textbox", MEDIUMWAIT);
        techStack = safeGetAttribute(TXTBOX_TECKSTACK, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(techStack);
        safeClick(LABEL_CATEGORY, "Server Feild", MEDIUMWAIT);
        safeClick(CATEGORY_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CATEGORY, "Database", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Database")) {

                dbs1.get(i).click();
                break;
            }
        }
        category_Add = safeGetText(CATEGORY_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        safeClick(BTN_ADD_ACCESMEANS, "Access Means add button", MEDIUMWAIT);
        safeType(TXTBOX_ACCESMEANS, "Access Means", "Name into textbox", MEDIUMWAIT);
        acess_Means = safeGetAttribute(TXTBOX_ACCESMEANS, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(acess_Means);
        safeClick(BTN_ADD_SEARCHTAGS, "Access Means add button", MEDIUMWAIT);
        safeType(TXTBOX_SEARCHTAGS, "Search tags", "Name into textbox", MEDIUMWAIT);
        search_Tags = safeGetAttribute(TXTBOX_SEARCHTAGS, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(search_Tags);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
    }

    public void verifyingSoftwareNameDetails(String DbTitle) {
        serchingForCreatedConfig(DbTitle);
        waitForSecs(10);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        waitForSecs(10);
        System.out.println(pageTitle);
        String expectedText = DbTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        try {
            if (Server_Add.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && desc.equals(driver.findElement(TXTBOX_DESC).getAttribute("value")) &&
                    techStack.equals(driver.findElement(TXTBOX_TECKSTACK).getAttribute("value")) && category_Add.equals(driver.findElement(CATEGORY_GHOSTEXT).getText()) &&
                    acess_Means.equals(driver.findElement(EDITED_ACESSMEANS).getAttribute("value")) && search_Tags.equals(driver.findElement(EDITED_SEARCHTAGS).getAttribute("value"))) {
                System.out.println("Ticket details are valid");
                String text = driver.findElement(TXTBOX_SERVERNAME).getAttribute("value");
                System.out.println(text);
                waitForSecs(7);
                System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_DESC).getAttribute("value") +
                        " Instance Name: " + driver.findElement(TXTBOX_TECKSTACK).getAttribute("value") + driver.findElement(CATEGORY_GHOSTEXT).getText()
                        + driver.findElement(EDITED_ACESSMEANS).getAttribute("value") + driver.findElement(EDITED_SEARCHTAGS).getAttribute("value"));
            } else {
                Assert.fail("Ticket details are invalid");
            }
        }
        catch (Exception e){

        }
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void editConfiugurationSoftwareDetails(String DbTitle,String EditTitle) {
        serchingForCreatedConfig(DbTitle);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del + EditTitle);
        waitForSecs(5);
        Server_Add1 = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add1);
       // safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_DESC, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_DESC);
        searchField1.sendKeys(del1 + EditTitle);
        waitForSecs(5);
        desc1 = safeGetAttribute(TXTBOX_DESC, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(desc1);
/*        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);*/
        safeClick(LABEL_TECHSTACK, "Name Feild", MEDIUMWAIT);
        String del7 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField7 = driver.findElement(TXTBOX_TECKSTACK);
        searchField7.sendKeys(del7 + "EditedTechstack");
        techStack1 = safeGetAttribute(TXTBOX_TECKSTACK, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(techStack1);
 /*       safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);*/
        waitForSecs(5);
        safeClick(LABEL_CATEGORY, "Server Feild", MEDIUMWAIT);
        safeClick(CATEGORY_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeJavaScriptClearAndType(TXTBOX_CATEGORY, "Web Server", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Web Server")) {

                dbs1.get(i).click();
                break;
            }
        }
        category_Add1 = safeGetText(CATEGORY_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
     /*   safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);*/
        String del3 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField3 = driver.findElement(EDITED_ACESSMEANS);
        searchField3.sendKeys(del + "EditedAcessMeans");
        waitForSecs(5);
        acess_Means1 = safeGetAttribute(EDITED_ACESSMEANS, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(acess_Means1);
   /*     safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);*/
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField5 = driver.findElement(EDITED_SEARCHTAGS);
        searchField5.sendKeys(del + "EditedSearchTags");
        waitForSecs(5);
        search_Tags1 = safeGetAttribute(EDITED_SEARCHTAGS, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(search_Tags1);
        waitForSecs(10);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        serchingForCreatedConfig(EditTitle);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String EditedText = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(EditedText);
        Assert.assertEquals(EditedText, EditTitle);
    }


    public void verifyingEditSoftwareNameDetails(String EditTitle) {
        serchingForCreatedConfig(EditTitle);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
            System.out.println(pageTitle);
            String expectedText = EditTitle;
            Assert.assertEquals(pageTitle, expectedText);
            waitForSecs(5);
        System.out.println(Server_Add1+"" +(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")));
        System.out.println(desc1+ "" +(driver.findElement(TXTBOX_DESC).getAttribute("value")));
        System.out.println(techStack1+" "+(driver.findElement(TXTBOX_TECKSTACK).getAttribute("value")));
        System.out.println(category_Add1+" " +(driver.findElement(CATEGORY_GHOSTEXT).getText()));
        System.out.println(acess_Means1+" "+(driver.findElement(EDITED_ACESSMEANS).getAttribute("value")));
        System.out.println(search_Tags1+ " "+(driver.findElement(EDITED_SEARCHTAGS).getAttribute("value")));

            if (Server_Add1.equals(driver.findElement(TXTBOX_SERVERNAME).getAttribute("value")) && desc1.equals(driver.findElement(TXTBOX_DESC).getAttribute("value")) &&
                    techStack1.equals(driver.findElement(TXTBOX_TECKSTACK).getAttribute("value")) && category_Add1.equals(driver.findElement(CATEGORY_GHOSTEXT).getText()) &&
                    acess_Means1.equals(driver.findElement(EDITED_ACESSMEANS).getAttribute("value")) && search_Tags1.equals(driver.findElement(EDITED_SEARCHTAGS).getAttribute("value"))) {
                System.out.println("Ticket details are valid");
                String text = driver.findElement(TXTBOX_SERVERNAME).getAttribute("value");
                System.out.println(text);
                waitForSecs(7);
                System.out.println("Name: " + driver.findElement(TXTBOX_SERVERNAME).getAttribute("value") + " Database Name: " + driver.findElement(TXTBOX_DESC).getAttribute("value") +
                        " Instance Name: " + driver.findElement(TXTBOX_TECKSTACK).getAttribute("value") + driver.findElement(CATEGORY_GHOSTEXT).getText()
                        + driver.findElement(EDITED_ACESSMEANS).getAttribute("value") + driver.findElement(EDITED_SEARCHTAGS).getAttribute("value"));
            } else {
                Assert.fail("Ticket details are invalid");
            }

        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }

    public void navigatingToSoftwarePage(String DbTitle)
    {
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SOFTWARE, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        serchingForCreatedConfig(DbTitle);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(25);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = DbTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void verifyingPageIconsInSoftwarepage(String DbTitle) {
        serchingForCreatedConfig(DbTitle);
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
        String expectedText = DbTitle+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_EDIT,"Edit button",MEDIUMWAIT);
        boolean editTitle=  isElementDisplayed(EDIT_HEADER);
        Assert.assertTrue(editTitle);
        List<WebElement> chkboxes =driver.findElements(CHEKBOXES_EDITWINDOW);
        for(int i=0;i<=chkboxes.size()-1;i++) {
            chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM,"Confirm button",MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
    }


    public void applyingFiltersInSoftwarePage(String DbTitle) {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, DbTitle);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void navigateToReferenceWindowFromSoftwareEditWindow(){
        safeClick(BTN_DATASOURCES, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SOFTWARE, "Software label from Datasources sub mneu", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "Name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        waitForSecs(10);
        By SeachedText = By.xpath("//div[contains(text(),'" + dashBoardData.SoftwareConfigRcrd +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String refName =safeGetText(REFERENCED_TEXT,"Referneced item name",MEDIUMWAIT);
        System.out.println(refName);
        String splititem[]= refName.split(">");
        String cpName=splititem[2];
        System.out.println(cpName);
        waitForSecs(10);
        safeClick(REFERENCED_ITEM_LINK,"referenced item",MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label","Db page title", MEDIUMWAIT);
        pageTitle = " "+pageTitle;
        System.out.println(pageTitle);
        Assert.assertEquals(cpName,pageTitle);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW, "Closing window");
        waitForSecs(10);
    }

    public void VerifyIconsInSoftwareEditConfigWindow(String DbTitle){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle +"')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + DbTitle + " - Cloned']");
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

public void serchingForCreatedConfig(String DbTitle){
    waitForSecs(10);
    safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
    safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
    waitForSecs(10);
    safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
    waitForSecs(10);
    safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
    By SeachedText = By.xpath("//div[contains(text(),'" + DbTitle +"')]");
    mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
    driver.findElement(SeachedText).click();
    waitForSecs(10);
}
}