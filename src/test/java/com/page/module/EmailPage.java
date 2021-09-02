package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.EmailLocators;
import com.page.locators.UserAccessRequestLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class EmailPage extends SafeActions implements EmailLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();

    public EmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verification() {
        safeType(TXTBOX_EMAIl, "testzenq@yopmail.com", "Entering yop mail", MEDIUMWAIT);
        safeClick(BTN_FORWARD, "Forward button", MEDIUMWAIT);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size);
        selectFrame(0);
        boolean b = isElementDisplayed(LABEL_RECEIVED_EMAIl);
        System.out.println(b);
        Assert.assertTrue(b);
        if(b==true)
        {
            safeClick(LABEL_RECEIVED_EMAIl,"clicked on Label",MEDIUMWAIT);
        }
        driver.switchTo().defaultContent();
        selectFrame(2);
        safeClick(HYPERLINK_ACCEPT_REQUEST,"accept hyper link",MEDIUMWAIT);
        switchToWindow(1);
        String url= getCurrentURL();
        System.out.println(url);
        String expectedURL = "http://qa.germainapm.com/germainapm/workspace/app/#logon";
        Assert.assertEquals(url,expectedURL);
        driver.close();
        switchToWindow(0);
        selectFrame(2);
        safeClick(HYPERLINK_REJECT_REQUEST,"Reject hyper link",MEDIUMWAIT);
        switchToWindow(1);
        String Notify = safeGetText(NOTIGY_REJECTED,"Notification Text",MEDIUMWAIT);
        String expectedNotify ="Request Rejected.";
        Assert.assertEquals(Notify,expectedNotify);
        driver.close();
    }
}
