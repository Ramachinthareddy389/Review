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

public class DataFieldExclusionsTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DataFeildExclusionsPage dataFeildExclusionsPage;
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
        dataFeildExclusionsPage = new DataFeildExclusionsPage(getDriver());
        dashboardOverviewPage = new DashboardOverviewPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
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
    public void TC_187_AddDataFieldExclusionconfig() throws InterruptedException {
        dataFeildExclusionsPage.clickingOnDataFeildExclusion();
        dataFeildExclusionsPage.addingNewDataFieldExclusion();
        dataFeildExclusionsPage.verifyingFeildExclusionDetails();

    }
/*
    @Test(alwaysRun = true)
    public void TC_188_EditDataFieldExclusionconfig () throws InterruptedException {
        dataFeildExclusionsPage.clickingOnDataFeildExclusion();
        dataFeildExclusionsPage.addingNewDataFieldExclusion();
        dataFeildExclusionsPage.editBusinessConfig();
        dataFeildExclusionsPage.verifyingEditedDataExcusionDetails();

    }*/


    @Test(alwaysRun = true)
    public void TC_193_AddDataFieldExclusionfromDrillthroughpage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortletFromSearchBar();
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigatingToDrillThroughPage(dname1);
        dataFeildExclusionsPage.addingDataExclusionFromDrillThroughPage();
        dataFeildExclusionsPage.addingNewDataFieldExclusion();
        dataFeildExclusionsPage.navigatingToDataExclusionModule();
        dataFeildExclusionsPage.verifyingFeildExclusionDetails();
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortletFromSearchBar();
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigateToRCADrillThroughPage();
        dataFeildExclusionsPage.addingDataFieldExclusionDetailsFromRCApage();
        dataFeildExclusionsPage.addingNewDataFieldExclusion();
        dataFeildExclusionsPage.navigatingToDataExclusionModule();
        dataFeildExclusionsPage.verifyingFeildExclusionDetails();

    }



}
