package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.SQLLocators;
import com.page.locators.SoftwareLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SQLPage extends SafeActions implements SQLLocators {

    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();

    Random random = new Random();
    String Server_Add, desc, techStack, category_Add, acess_Means, search_Tags;
    String SQL = "Sql" + " - " + random.nextInt(500);
    String Querys = "Querys" + " - " + random.nextInt(500);
    String QryEdit = "QryEdit" + " - " + random.nextInt(500);
    String WebUXAgent = "WebUXAgent" + " - " + random.nextInt(500);

    //Constructor to define/call methods
    public SQLPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAutomation() {
        safeClick(BTN_AUTOMATION, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_SQL, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON_SQL, "Add button", MEDIUMWAIT);
    }

    public void addingNewSqlRecord(String Query,String alertTemplate,String TimeRange){
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, SQL, "Name Textbox", MEDIUMWAIT);
        safeClick(DISTRIBUTION_LIST_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DISTRIBUTION_LIST, "SQLList", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("SQLList")) {

                dbs1.get(i).click();
                break;
            }
        }
        safeClick(REPORT_TEMPLATE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_REPORT_TEMPLATE, alertTemplate, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs2.get(i).getText().equals(alertTemplate)) {

                dbs2.get(i).click();
                break;
            }
        }
        safeCheck(CHKBOX_ATTACH_RESULT,"Attach result checkbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(DATABASE_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DATABASE, "Database Wizard", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs3 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs3.size(); i++) {

            if (dbs3.get(i).getText().equals("Database Wizard")) {

                dbs3.get(i).click();
                break;
            }
        }
        safeClick(CREDENTIALS_GHOSTTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_CREDENTIALS, "cred wizard", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs4 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs4.size());
        for (int i = 0; i < dbs4.size(); i++) {

            if (dbs4.get(i).getText().equals("cred wizard")) {

                dbs4.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_SERVERNAME, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SERVERNAME, Querys, "Name Textbox", MEDIUMWAIT);
        safeType(SQL_TEXTAREA,Query,"Query",MEDIUMWAIT);
        safeClick(SQLQUERY_TIMERANGE_GHOSTTEXT,"TimRange ghost text",MEDIUMWAIT);
        safeClearAndType(TXTBOX_SQL_QUERY_TIMERANGE, TimeRange, "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5= driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals(TimeRange)) {

                dbs5.get(i).click();
                break;
            }
        }
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeCheck(CHKBOX_RUNSCHEDULE,"Run Schedule checkbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish Button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingaddedSQLConfigs() {
        safeType(TEXTBOX_TYPESEARCH, SQL + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = SQL;
        Assert.assertEquals(pageTitle, expectedText);
        safeCheck(CHKBOX_DATAMART_QUERY, "Data mart query check box", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(By.xpath("//button[@aria-label='" + Querys + "']")).click();
        safeClick(BTN_VALIDATE, "Validate button", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close sql edit window", MEDIUMWAIT);

    }
    public  void deletingSQLConfig(){
        safeJavaScriptClick(DELETE_ALERT, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(20);
    }

    public void verifyingDataInEmail(String Report){
        String DailyReport = safeGetText(LABEL_DAILY_REPORT,"Daily report label",MEDIUMWAIT);
        Assert.assertEquals(DailyReport,Report);
        waitForSecs(20);
        driver.switchTo().defaultContent();
        driver.findElements(LABEL_MENU_BUTTON).get(1).click();
        safeClick(LABEL_EMPTY_TEXTBOX, "Empty textbox", MEDIUMWAIT);
        acceptAlert();
    }

    public void addingQueryFromSQLEditWindow(String Query){
        safeClick(SQL_QUERIES_ADD_ICON,"Queries add icon",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeClick(LABEL_SQL_QUERY, "Name Label", MEDIUMWAIT);
        safeType(TXTBOX_SQL_QUERY, QryEdit, "Name Textbox", MEDIUMWAIT);
        safeType(SQL_TEXTAREA,Query,"Query",MEDIUMWAIT);
        /*safeClick(SQLQUERY_TIMERANGE_GHOSTTEXT,"TimRange ghost text",MEDIUMWAIT);
        safeClearAndType(TXTBOX_SQL_QUERY_TIMERANGE, "None", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs5= driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs5.size());
        for (int i = 0; i < dbs5.size(); i++) {

            if (dbs5.get(i).getText().equals("None")) {

                dbs5.get(i).click();
                break;
            }
        }*/
        safeClick(BTN_FINISH,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
        waitForSecs(10);
        driver.findElement(By.xpath("//button[@aria-label='" + QryEdit + "']")).click();
        safeClick(BTN_VALIDATE, "Validate button", MEDIUMWAIT);
        safeClick(CLOSE_EDITWINDOW, "Close sql edit window", MEDIUMWAIT);
    }
}
