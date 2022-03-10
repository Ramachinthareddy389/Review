package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.AlertTemplatePage;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.WizardsPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class WizardsTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private WizardsPage wizardsPage;
private  AlertTemplatePage alertTemplatePage;
    private String sModeOfExecution;
    Random random = new Random();
    String dname = "wizards";
    String dname1 = dname + random.nextInt(1500);
    String DistriList = "DistriList" + "-" + random.nextInt(500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        wizardsPage = new WizardsPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        alertTemplatePage=new AlertTemplatePage(getDriver());
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
    public void TC_Wizards_001_AddconfigfromWizardspage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        wizardsPage.addingConfigFromWizardPage();
        alertTemplatePage.addingDistributionList(DistriList, "rama.chinthareddy@zenq.com");
        wizardsPage.verifyingInAlertPage();


    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Wizards_002_ManageButtonsfromWizardPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        wizardsPage.verifyingManageButtonInWizards();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Wizards_004_VerifyingTestSearchCapability() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        wizardsPage.verifyingTestSearchCapability();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_Wizards_005_VerifyingTestShowCapability() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        wizardsPage.verifyingTestShowCapability();
        wizardsPage.verifyingTestShowCapabilityUsingMonitoring();
        wizardsPage.verifyingTestShowCapabilityUsingAnalytics();
        wizardsPage.verifyingTestShowCapabilityUsingAutomation();


    }


}
