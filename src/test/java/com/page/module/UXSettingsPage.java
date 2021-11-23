package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.UXSettingsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class UXSettingsPage extends SafeActions implements UXSettingsLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String AppProfieName ="Angular";



    public UXSettingsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void ClickingOnUXSettings(){
        safeClick(BTN_ANALYTICS, "Analytics label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_UXSETTINGS, "UXsettings label from Datasources sub mneu", MEDIUMWAIT);
    }

    public void verifyingTheNavigationOfWebExAgentWindow(){
        safeType(TEXTBOX_TYPESEARCH, AppProfieName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(30);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(WEBXAGENT_HYPERLINK, "WebEx agent Hyperlink ", MEDIUMWAIT);
        boolean title =isElementDisplayed(WEBXAGENT_TITLE);
        Assert.assertTrue(title);
        waitForSecs(15);
        String actualText = safeGetText(TXTBOX_APP_PROFILE,"App Profile text",MEDIUMWAIT);
        Assert.assertEquals(actualText,AppProfieName);
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW,"WebExAgent window",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW,"Application profile edit window",MEDIUMWAIT);
    }
    public void verifyingPageIconsInUXSettingsPage() {
        safeType(TEXTBOX_TYPESEARCH, AppProfieName + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(30);
        By SELECTROW_CHKBOX1 = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span/mark[text()='" + AppProfieName + "']/../../../../parent::div/descendant::input[1]");
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        By ELEMENT_STATUS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span//span/mark[text()='" + AppProfieName + "']/../../..//parent::div/div[1]/span/span/input");
        boolean b1 = isElementSelected(ELEMENT_STATUS);
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
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE, "clone button", MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label", "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = AppProfieName+ " - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(25);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_ENABLE, "Enable config button", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
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
        safeJavaScriptClick(SELECTROW_CHKBOX1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_EDIT,"Edit button",MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> chkboxes1 =driver.findElements(CHEKBOXES_EDITWINDOW);
        for(int i=0;i<=chkboxes1.size()-1;i++) {
            chkboxes1.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM,"Confirm button",MEDIUMWAIT);
        waitForSecs(10);


    }
    public void applyingFiltersInUxSettingsWindow() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + AppProfieName + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, AppProfieName);
    }

    public void VerifyIconsInUxSetingsEditConfigWindow(){
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + AppProfieName + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
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
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + AppProfieName + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
    }
    public void viewDataWithFeildsForViewIcon() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + AppProfieName+ "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(WEBXAGENT_HYPERLINK, "WebEx agent Hyperlink ", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 0; i <= 1; i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.UXSETTING_VALUES[i]));
            System.out.println(wizardName);
        }


        for (int j = 0; j < dashBoardData.UXSETTING_VALUES.length - 1; j++) {
            System.out.println("Values are " + dashBoardData.UXSETTING_VALUES[j]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(CLOSE_EDITWINDOW,"WebExAgent window",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(CLOSE_EDITWINDOW,"Application profile edit window",MEDIUMWAIT);
    }
}
