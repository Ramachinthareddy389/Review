package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.ApmStatePage;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.PortletsFeature;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class ApmStateTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private String sModeOfExecution;
    private ApmStatePage apmStatePage;
    Random random = new Random();

    String dname = "HttpScenario";
    String dname1 = dname + random.nextInt(1500);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        apmStatePage = new ApmStatePage(getDriver());
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
    public void TC_Apm_001_AddNewHTTPScenarioComponentDeployementComponent() throws InterruptedException
    {
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.verifyingHttpScenario();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_Apm_002_EditExistingHTTPScenarioComponentDeployementComponent(){
        apmStatePage.configuringHttpScenario();
        apmStatePage.configuringServerPage();
        apmStatePage.configuringDeploymentPage();
        apmStatePage.verifyingEditHttpConfigs();
    }
}
