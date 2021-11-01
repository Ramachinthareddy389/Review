package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.DashboardPage;
import com.page.module.LoginPage;
import com.page.module.PortletsFeature;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class PortletsTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;

    private String sModeOfExecution;
    Random random = new Random();
    String tabularPortletName = "Tabular Portlet - " + random.nextInt(1000);
    String nTabularPortletName = "N Tabular Portlet - " + random.nextInt(1000);
    String dname = "GH Portlet";
    String dname1 = dname + random.nextInt(1500);
    String flowPortletName = "Flow Portlet - " + random.nextInt(1000);
    String mapPortletName = "Map Portlet - " + random.nextInt(1000);
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);
    String counterPortletName = "Counter Portlet - " + random.nextInt(1000);

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
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


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC023_AddingGeneralHealthPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortlet(dname1,"User Click");
       // dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.VerifyingGHPortlet(dname1);
        //portletsFeature.removingPortlet();
        // dashboardOverviewPage.deletingDashboard();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_24_AddingTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingTabularPortlet();
        portletsFeature.addingtabularPortlet1(tabularPortletName);
      //  dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingTabularPortlet(tabularPortletName);
        // portletsFeature.removingPortlet();
        // dashboardOverviewPage.deletingDashboard();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_25_AddingNTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
       // dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingNTabularPortlet(nTabularPortletName);
        //  portletsFeature.removingPortlet();
        // dashboardOverviewPage.deletingDashboard();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_26_AddingMapPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingMapPortlet(mapPortletName);
      //  dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingMapPortlet(mapPortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_27_AddingFlowPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingFlowPortlet(flowPortletName);
       // dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.verifyingFlowPortlet(flowPortletName);
        portletsFeature.removingPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_28_AddingGaugePortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
      //  dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingGaugePortlet(gaugePortletName);
        portletsFeature.removingPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_29_AddingCounterPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingCounterPortlet(counterPortletName);
       // dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.verifyingCounterPortlet(counterPortletName);
        portletsFeature.removingPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_45_ClonePortletToAnotherDashboard() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        //portletsFeature.verifyingPortletAddedFromSearchBar();
        portletsFeature.cloningPortletInDashboardPage();
        portletsFeature.verifyingClonedPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_048_ExportGHPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortlet(dname1,"User Click");
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.validatingExportedGHPortlet(dname1 + "_" + "User Click.csv", dashBoardData.porletHeaders.split(","));
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_049_ExportTabularportlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingTabularPortlet();
        portletsFeature.addingtabularPortlet1(tabularPortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingTabularPortlet(tabularPortletName);
        portletsFeature.validatingExportedATabularPortlet(tabularPortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_50_ExportNTabularPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingNTabularPortlet(nTabularPortletName);
        portletsFeature.verifyingExportedNtabularPortlet(nTabularPortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_051_ExportMapPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingMapPortlet(mapPortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingMapPortlet(mapPortletName);
        portletsFeature.validatingExportedGHPortlet(mapPortletName + ".csv", dashBoardData.mapHeaders.split(","));
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_O52_RemovePortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingNTabularPortlet(nTabularPortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_53_ExportingGaugePortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        portletsFeature.verifyingGaugePortlet(gaugePortletName);
        portletsFeature.exportingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_54_ExportingCounterPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingCounterPortlet(counterPortletName);
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.verifyingCounterPortlet(counterPortletName);
        portletsFeature.exportingCounterPortlet(counterPortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }


    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_055_NavigatetoDrillthroughpage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigatingToDrillThroughPage(gaugePortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_056_VerifyHovermessageinFilterIconInTabularPortlet() throws InterruptedException, IOException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingTabularPortlet();
        portletsFeature.verifyingHoverMessageinFilterTabularportlet(tabularPortletName);
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        portletsFeature.verifyhoverFiltermessage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_057_NavigateDrillthroughpageUsing3optionTooltip() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigatingToDrilthroughPagesUsingTooltipOptions();
        portletsFeature.removingPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_058_AddingPortletFromSearchBar() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
       // portletsFeature.verifyingPortletAddedFromSearchBar();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_066_ApplyingTimeRangeinCalendar() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        portletsFeature.navigatingToDrillThroughPage(dname1);
        dashboardOverviewPage.clickingOnCalenderIcon();
        dashboardOverviewPage.ValidatingCurrentHour();
        dashboardOverviewPage.validatingLastHour();
        dashboardOverviewPage.validatingBusinessHours("09:00 AM", "05:00 PM");
        dashboardOverviewPage.validatingLast12hours();
        dashboardOverviewPage.validatingThisMonth("12:00 AM");
        dashboardOverviewPage.validatingLastMonth("12:00 AM");
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        dashboardOverviewPage.validatingToday("12:00 AM");
        dashboardOverviewPage.validatingYesterday("12:00 AM");
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        dashboardOverviewPage.validatingAbsoluteQa_30Mins("01/01/2020 01:01 AM", "02/04/2021 01:30 AM");
        dashboardOverviewPage.validatingAbsoluteAllUnits("01/01/2020 01:00 AM", "02/20/2021 05:30 AM");
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }


    @Test(enabled = true)
    public void TC_061_NavigateToDrillthroughpageUsing3optionTooltip() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigateToDrillthroughPage(gaugePortletName);
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(enabled = true)
    public void TC_080_VerifyingTimeRangeInRCAPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        //portletsFeature.verifyingPortletAddedFromSearchBar();
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigateToDrillthroughPage(gaugePortletName);
        portletsFeature.navigateToRCAFromDrillthroughPage();
        portletsFeature.verifyTimeRangeInRCAPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(enabled = true)
    public void TC_082_MaximisePortletInRCAPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
      //  portletsFeature.verifyingPortletAddedFromSearchBar();
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigateToRCAPage();
        portletsFeature.maximisePortletInRCAPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_27_1_AddingFlowPortletUsingBPKPI() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingFlowPortletUsingBPKPI(flowPortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.verifyingFlowPortletUSingBPKPI(flowPortletName);
        portletsFeature.removingPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_031_AddMultipleMeasuresForGHPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortlet(dname1,"User Click");
        //portletsFeature.VerifyingGHPortlet(dname1);
        portletsFeature.addingMultipleMeasuresInGHPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }
    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_032_AddMultipleMeasuresForTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingTabularPortlet();
        portletsFeature.addingtabularPortlet1(tabularPortletName);
        portletsFeature.addingMultipleMeasuresTabularPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_033_AddMultipleMeasuresForNTabularPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        portletsFeature.addingMultipleMeasuresInNTabularPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_034_AddMultipleMeasuresforGaugePortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        portletsFeature.addingMultipleMeasuresInGaugePortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_035_AddMultipleMeasuresforCounterPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingCounterPortlet(counterPortletName);
        portletsFeature.addingMultipleMeasuresInCounterPortlet();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_037_EnableDataOnlyAboveSLAInGHportletInterface() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingPortlet(dname1,"User Click");
        portletsFeature.addingDataOnlyAboveSLA();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_039_SetTrendGranularityinGHportletInterface() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SearchinDashboard();
        portletsFeature.validaingTrendGranularityUSingHours();
        portletsFeature.validaingTrendGranularityUSingDaily();
        portletsFeature.validaingTrendGranularityUSingMonthly();
        portletsFeature.validaingTrendGranularityUSingYEARLY();
        portletsFeature.validaingTrendGranularityUSingMinutely();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_040_SetTrendGranularityinNTabularPortletInterface() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingNTabularPortlet(nTabularPortletName);
        portletsFeature.validaingTrendGranularityUSingHours();
        portletsFeature.validaingTrendGranularityUSingDaily();
        portletsFeature.validaingTrendGranularityUSingMonthly();
        portletsFeature.validaingTrendGranularityUSingYEARLY();
        portletsFeature.validaingTrendGranularityUSingMinutely();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_046_MaximizeGHPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SearchinDashboard();
        portletsFeature.verifyingMaximizeFunctionality();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_047_RestoreGHPortlet() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.ClickAll();
        dashboardOverviewPage.SearchinDashboard();
        portletsFeature.verifyingRestoreFunctionality();
    }

}


