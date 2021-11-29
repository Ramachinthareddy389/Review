package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Random;

public class HTTPTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private HTTPPage httpPage;
    private HardwarePage hardwarePage;
    private AlertTemplatePage alertTemplatePage;
    private SLAsPage slAsPage;
    private String sModeOfExecution;
    Random random = new Random();
    String alertTemp = "ALERTTEMPLATE";
    String Engine="Engine"  + " - " + random.nextInt(500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        httpPage  = new HTTPPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        alertTemplatePage=new AlertTemplatePage(getDriver());
        slAsPage = new SLAsPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true, groups = "Smoke Suite")
    public void TC_237_AddHTTPActionconfiguration() throws InterruptedException
    {
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.verifyinghttpPage();
    }


    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_238_AddSLAsinEditHTTPActionwindow()
    {
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.verifyingAddedSLAInHTTP();
        httpPage.addingSLA();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_243_AddHTTPScenarioconfiguration()
    {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        httpPage.configuringNodeInAPMModule();
        httpPage.configuringEnginesInAPMModule();
        httpPage.addingHttpScenario();


    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_244_AddHTTPScenariofromharfileconfiguration() throws InterruptedException, AWTException
    {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        httpPage.configuringNodeInAPMModule();
        httpPage.configuringEnginesInAPMModule();
        httpPage.addingHTTPScenarioUsingharFile();
        httpPage.verifyingHttpScenario();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_245_AddScenarioTargetsinEditHTTPScenariowindow() throws InterruptedException, AWTException {
        hardwarePage.clickingOnHardware();
        hardwarePage.addingNewHardware();
        httpPage.configuringNodeInAPMModule();
        httpPage.configuringEnginesInAPMModule();
        httpPage.addingHttpScenarioUsinharFile();
        httpPage.addingHTTPScenarioUsingharFile();
        httpPage.verifyingHttpScenario();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_247_VerifyPageIconsInHttpPage(){
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.verifyingPageIcons();
    }
    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_248_ApplyFiltersInHttpPage(){
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.applyingFiltersInHttpPage();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_250_VerifyIconsInHttpActionsEditConfigwindow()
    {
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.VerifyIconsInHttpActionsEditConfigwindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Suite")
    public void TC_252_ViewDataForFieldswithViewIconInEditConfigwindow(){
        alertTemplatePage.clickingOnAlertTemplate();
        alertTemplatePage.addIngAlertTemplate(alertTemp);
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.viewDataWithFeildsForViewIcon(alertTemp);
        slAsPage.deleteinAlertTemplate(alertTemp);
    }


}
