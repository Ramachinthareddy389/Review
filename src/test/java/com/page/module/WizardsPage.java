package com.page.module;

import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.locators.WizardsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


public class WizardsPage extends SafeActions implements WizardsLocators {

    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();


    //Constructor to define/call methods
    public WizardsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Add config from Wizards page")
    public void addingConfigFromWizardPage() {
        safeClick(BTN_Wizards, "Wizard label from side pane", MEDIUMWAIT);
        safeClick(ALERT_ADD_BUTTON, "Alert button", MEDIUMWAIT);
        safeType(ALERTNAME_TXTBOX, "TestAlerts", "Alert Textbox", MEDIUMWAIT);
        safeClick(DISTRIBUTION_HEADER, "Distribution header", MEDIUMWAIT);
        safeClick(DISTRIBUTION_GhOSTTEXT, "Select or add ghost text", MEDIUMWAIT);
        safeClearAndType(DISTRIBUTION_TXTBOX, "QA test", "QA test", MEDIUMWAIT);
        List<WebElement> dbs = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + dbs.size());
        for (int i = 0; i < dbs.size(); i++) {

            if (dbs.get(i).getText().contains("QA test")) {

                dbs.get(i).click();
                break;
            }

        }
        safeClick(BTN_NEXT, "Next Button", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(SLA_HEADER, "SLA label", MEDIUMWAIT);
        safeClick(DISTRIBUTION_GhOSTTEXT, "Selec or add ghost text", MEDIUMWAIT);
        safeClearAndType(SLA_TXTBOX, "0 KPI Threshold - raw - fact sample 1", "text", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().contains("0 KPI Threshold - raw - fact sample 1")) {

                dbs1.get(i).click();
                break;
            }
        }
        safeClick(BTN_FINISH, "Finish Button", MEDIUMWAIT);
        String Notify = safeGetText(NOTIFY_TEXT, "Success Notification", MEDIUMWAIT);

        String expecteText = "TestAlerts" + " successfully configured.";
        String expecteText1 = "TestAlerts" + " already exists";
        if (Notify.equals("TestAlerts" + " successfully configured.")) {
            Assert.assertEquals(Notify, expecteText);
        } else {
            Assert.assertEquals(Notify, expecteText1);
        }
        safeClick(BUTTON_CLOSE, "Close button", MEDIUMWAIT);


    }

    @Step("Verifying created alert in alert page")
    public void verifyingInAlertPage() {
        safeClick(BTN_AUTOMATION, "Automation label from left side pane", MEDIUMWAIT);
        safeClick(ALERT_HEADER_SIDE_MENU, "Alerts label from automation menu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, "TestAlerts" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        By ALERTNAME = By.xpath("//mark[text()='TestAlerts']");
        boolean alertName = driver.findElement(ALERTNAME).isDisplayed();
        System.out.println(alertName);
        Assert.assertTrue(alertName);
        waitForSecs(5);
        driver.findElement(ALERTNAME).click();
        waitForSecs(2);
        //safeJavaScriptClick(CHKBOX_ALERT,"Alert Checkbox",MEDIUMWAIT);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(2);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
    }

    @Step("Verify Manage button in Wizards")
    public void verifyingManageButtonInWizards() {
        safeClick(BTN_Wizards, "Wizard label from side pane", MEDIUMWAIT);
        safeClick(BTN_MANAGE_ALERT, "Alert button", MEDIUMWAIT);
        waitForSecs(5);
        String backcolor = driver.findElement(By.xpath("//a[@href='#Actions(syntheticCollections.alerts)']")).getCssValue("background-color");
        System.out.println(backcolor);
        String backcolor1 = "rgba(0, 0, 0, 0)";
        boolean b = backcolor.equals(backcolor1);
        System.out.println(b);
        Assert.assertFalse(b);
        String title = safeGetText(PAGE_TITLE_ALERT, "Alert page title", MEDIUMWAIT);
        String expectedText = "Alerts";
        Assert.assertEquals(title, expectedText);

    }

    @Step("Verify Test Search Capability")
    public void verifyingTestSearchCapability() {
        safeClick(BTN_Wizards, "Wizard label from side pane", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, "Alert Template" + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        By ALERTNAME = By.xpath("//span[@aria-label='Alert Template']");
        boolean alertName = driver.findElement(ALERTNAME).isDisplayed();
        System.out.println(alertName);
        Assert.assertTrue(alertName);

    }

    @Step("Verify Test Search Capability")
    public void verifyingTestShowCapability() {
        safeClick(BTN_Wizards, "Wizard label from side pane", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LISTOFWIZARDS);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.all[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.all.length; j++) {
            System.out.println("Values are " + dashBoardData.all[j]);
        }
    }

    @Step("Verify Test Show Capability Using Monitoring ")
    public void verifyingTestShowCapabilityUsingMonitoring() {
        safeClick(BUTTON_MONITORING, "Monitoring tab", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LISTOFWIZARDS);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.monitoring[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.monitoring.length; j++) {
            System.out.println("Values are " + dashBoardData.monitoring[j]);
        }
    }

    @Step("Verify Test Show Capability using Analytics")
    public void verifyingTestShowCapabilityUsingAnalytics() {
        safeClick(BUTTON_ANALYTICS, "Monitoring tab", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LISTOFWIZARDS);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.analytics[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.analytics.length; j++) {
            System.out.println("Values are " + dashBoardData.analytics[j]);
        }
    }

    @Step("Verify Test Show Capability using Automation")
    public void verifyingTestShowCapabilityUsingAutomation() {
        safeClick(BUTTON_AUTOMATION, "Monitoring tab", MEDIUMWAIT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LISTOFWIZARDS);
        for (int i = 0; i <= wizards.size() - 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.automation[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.automation.length; j++) {
            System.out.println("Values are " + dashBoardData.automation[j]);
        }
    }
}
