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

    Random random = new Random();
    String Server_Add, desc, techStack, category_Add, acess_Means, search_Tags;
    String DbTitle = "Module_soft" + " - " + random.nextInt(500);
    String EditTitle = "Module_Sft_Edit" + " - " + random.nextInt(500);
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
    }

    public void addingNewSoftware() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
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

    public void verifyingSoftwareNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = DbTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
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
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void editConfiugurationSoftwareDetails() {
        safeType(TEXTBOX_TYPESEARCH, DbTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(LABEL_SERVERNAME, "Name Feild", MEDIUMWAIT);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_SERVERNAME);
        searchField.sendKeys(del + EditTitle);
        waitForSecs(5);
        Server_Add = safeGetAttribute(TXTBOX_SERVERNAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Server_Add);
        safeClick(LABEL_DESC, "Name Feild", MEDIUMWAIT);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1 = driver.findElement(TXTBOX_DESC);
        searchField1.sendKeys(del1 + EditTitle);
        waitForSecs(5);
        desc = safeGetAttribute(TXTBOX_DESC, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(desc);
        safeClick(LABEL_TECHSTACK, "Name Feild", MEDIUMWAIT);
        String del7 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField7 = driver.findElement(TXTBOX_TECKSTACK);
        searchField7.sendKeys(del7 + "EditedTechstack");
        techStack = safeGetAttribute(TXTBOX_TECKSTACK, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(techStack);
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
        category_Add = safeGetText(CATEGORY_GHOSTEXT, "Server textbox value", MEDIUMWAIT);
        String del3 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField3 = driver.findElement(EDITED_ACESSMEANS);
        searchField3.sendKeys(del + "EditedAcessMeans");
        waitForSecs(5);
        acess_Means = safeGetAttribute(EDITED_ACESSMEANS, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(acess_Means);
        String del5 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField5 = driver.findElement(EDITED_SEARCHTAGS);
        searchField5.sendKeys(del + "EditedSearchTags");
        waitForSecs(5);
        search_Tags = safeGetAttribute(EDITED_SEARCHTAGS, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(search_Tags);
        waitForSecs(10);
        safeJavaScriptClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_CLEAR, "clear button", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, EditTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String EditedText = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(EditedText);
        Assert.assertEquals(EditedText, EditTitle);
    }


    public void verifyingEditSoftwareNameDetails() {
        safeType(TEXTBOX_TYPESEARCH, EditTitle + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = EditTitle;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
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
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }
}