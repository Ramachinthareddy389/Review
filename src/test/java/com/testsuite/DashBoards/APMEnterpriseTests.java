package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class APMEnterpriseTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private String sModeOfExecution;
    private APMEnterprisePage apmEnterprisePage;
    private HardwarePage hardwarePage;
    private SoftwarePage softwarePage;
    private ComponentPage componentPage;
    Random random = new Random();

    String dname = "HttpScenario";
    String dname1 = dname + random.nextInt(1500);
    String HostName = "HostTest" + "-" + random.nextInt(500);
    String HostName1 = "Hostname" + "-" + random.nextInt(500);
    String DbTitle = "Module_soft" + " - " + random.nextInt(500);
    String Cred = "Cred" + "-" + random.nextInt(500);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        softwarePage = new SoftwarePage(getDriver());
        hardwarePage = new HardwarePage(getDriver());
        apmEnterprisePage = new APMEnterprisePage(getDriver());
        componentPage = new ComponentPage(getDriver());
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
    public void TC_APMEnter_001_clickingOnEnterpriseSection() throws InterruptedException
    {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.verifyingNavigateToEnterpriseTab();

    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_APMEnter_003_NavigateToDrillthroughPageFromFactsProcessedPortlet() throws InterruptedException
    {
        apmEnterprisePage.navigateToAPMPage();
        apmEnterprisePage.navigateToDrirllThroughPageFrmFactsProcessedPortlet();

    }

}
