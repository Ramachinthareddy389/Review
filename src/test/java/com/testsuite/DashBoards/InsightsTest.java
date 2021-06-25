package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InsightsTest extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private InsightsPage insightsPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        insightsPage = new InsightsPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }

    @Test( groups ="Smoke Test" )
    public void TC_098_Navigate_To_Drillthrough_From_Insights_Page() throws InterruptedException {
        insightsPage.navigateToInsightsPage();
        insightsPage.navigateToDrillthroughFromInsightsPage();
        insightsPage.verifyDrillthroughPageNavigatedFromInsightsPage();
    }

    @Test( groups ="Smoke Test" )
    public void TC_100_Navigation_Using_3Option_Tooltip_From_Insights_Page() throws InterruptedException {
        insightsPage.navigateToInsightsPage();
        insightsPage.navigationUsingTooltipOptions();
    }

}
