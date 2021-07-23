package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.HTTPPage;
import com.page.module.HardwarePage;
import com.page.module.KPIsPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class HTTPTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private HTTPPage httpPage;
    private HardwarePage hardwarePage;
    private String sModeOfExecution;
    Random random = new Random();
    String NodeJS = "NodeJs" + " - " + random.nextInt(500);
    String Engine="Engine"  + " - " + random.nextInt(500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        httpPage  = new HTTPPage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_237_AddHTTPActionconfiguration() throws InterruptedException
    {
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.verifyinghttpPage();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_238_AddSLAsinEditHTTPActionwindow()
    {
        httpPage.clickingOnAutomation();
        httpPage.addingHTTPPage();
        httpPage.verifyingAddedSLAInHTTP();
        httpPage.addingSLA();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_243_AddHTTPScenarioconfiguration(){
        httpPage.configuringNodeInAPMModule();
        httpPage.configuringEnginesInAPMModule();
        httpPage.addingHttpScenario();
    }
}
