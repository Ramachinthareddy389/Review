package com.page.module;

import com.datamanager.ConfigManager;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

import com.page.locators.LogInPageLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

import java.util.ArrayList;


public class LoginPage extends SafeActions implements LogInPageLocators {
    private WebDriver driver;
    ConfigManager app = new ConfigManager("App");
    String isPasswordEncrypted = app.getProperty("App.IsPasswordEncrypted");

    //Constructor to define/call methods
    public LoginPage(WebDriver driver) {

        super(driver);
        this.driver = driver;

    }

    /**
     * Purpose- To verify whether Germanian apm login page is being displayed or not
     */
    @Step("Verifying login page")
    public void verifyLoginPage() {
        waitForSecs(10);

        try{
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            waitForSecs(10);
            driver.switchTo().window(tabs2.get(1));
            driver.close();
            driver.switchTo().window(tabs2.get(0));
        }catch(Exception e){

            e.printStackTrace();
        }
        boolean bIsEmailAddressExists = isElementPresent(EMAILADDRESS_FIELD, MEDIUMWAIT);
        boolean bIsPasswordFieldExists = isElementPresent(PASSWORD_FIELD, MEDIUMWAIT);
        Assert.assertTrue(bIsEmailAddressExists || bIsPasswordFieldExists, "Email field/Password field textbox is not being displayed on 'Login' page");
    }

    /**
     * Purpose- To enter login credentilas i.e.,emailAddress and password
     *
     * @param sEmailAddresss- we pass username of Opencart application
     * @param sPassword-      we pass passowrd of Opencart application
     */
    @Step("Entering login credentials")
    public void enterLoginCredentials(String sEmailAddresss, String sPassword) {
        safeType(EMAILADDRESS_FIELD, sEmailAddresss, "'Email' field in 'Login' page", MEDIUMWAIT);
        if (isPasswordEncrypted.equalsIgnoreCase("false"))
            safeTypePassword(PASSWORD_FIELD, sPassword, "'Password' field in 'Login' page", MEDIUMWAIT);
        else
            safeType(PASSWORD_FIELD, sPassword, "'Password' field in 'Login' page", MEDIUMWAIT);
        waitForPageToLoad(VERYSHORTWAIT);

    }

    /**
     * Purpose- To click on Sign In button
     */
    @Step("Clicking on LogIn button")
    public void clickLogInButton() {
        safeClick(LOGIN_BTN, "'Login' button in 'Login' page ", VERYLONGWAIT);
        isElementVisible(INSIGHT_LABEL, MEDIUMWAIT);

    }

    @Step("Clicking on Logout button")
    public void clickLogoutButton() {
        waitForSecs(15);
        safeClick(USERICON, "'User Profile' icon", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LOGOUT, "Logout button in User Profile", MEDIUMWAIT);
        waitForPageToLoad();
        verifyLoginPage();
    }

}
