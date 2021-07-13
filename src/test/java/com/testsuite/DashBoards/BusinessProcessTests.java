package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class BusinessProcessTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private BusinessProcessPage businessProcessPage;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;
    Random random = new Random();
    String dname = "testng";
    String dname1 = dname + random.nextInt(1500);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        businessProcessPage = new BusinessProcessPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        dashBoardData = new DashBoardData();
        getDriver().manage().deleteAllCookies();
        getDriver().get(dashBoardData.openCartURL);
        (new Sync(getDriver())).waitForPageToLoad();
        sModeOfExecution = sys.getProperty("ModeOfExecution");
        loginPage.verifyLoginPage();
        loginPage.enterLoginCredentials(dashBoardData.emailAddress, PasswordDecoder.passwordDecrypt(dashBoardData.password));
        loginPage.clickLogInButton();
    }

    @Test(alwaysRun = true)
    public void TC_160_AddBusinessProcessConfiguration() throws InterruptedException {
        businessProcessPage.clickingOnBP();
        businessProcessPage.addingNewBusinessProcess();
        businessProcessPage.verifyingBusinessProcessDetails();
    }

    @Test(alwaysRun = true)
    public void TC_161_EditBusinessProcessConfiguration() throws InterruptedException {
        businessProcessPage.clickingOnBP();
        businessProcessPage.addingNewBusinessProcess();
        businessProcessPage.editBusinessConfig();
        businessProcessPage.verifyingEditedBusinessProcessNameDetails();
    }


    @Test(alwaysRun = true)
    public void TC_162_AddBPStepineditconfigwindow() throws InterruptedException {
        businessProcessPage.clickingOnBP();
        businessProcessPage.addingNewBusinessProcess();
        businessProcessPage.addingBPStepInEditConfigWindow();
        businessProcessPage.verifyingAddedBPStepsInEditConfigWindow();


    }

    @Test(alwaysRun = true)
    public void TC_163_AddBPStepMetricinEditBPStepwindow() throws InterruptedException
    {
        businessProcessPage.clickingOnBP();
        businessProcessPage.addingNewBusinessProcess();
        businessProcessPage.addingBPStepInEditConfigWindow();
        businessProcessPage.validatingBPStepMetrics();

    }


}

