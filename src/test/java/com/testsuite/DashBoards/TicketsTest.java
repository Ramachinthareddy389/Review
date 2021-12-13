package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.*;
import com.selenium.Sync;
import com.utilities.MailinatorAPI;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class TicketsTest extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private TicketsPage ticketsPage;
    private DashboardOverviewPage dashboardOverviewPage;
    private PortletsFeature portletsFeature;
    private PivotPage pivotPage;
    private  DashboardPage dashboardPage;
    private String sModeOfExecution;
    Random random = new Random();
    String gaugePortletName = "Gauge Portlet - " + random.nextInt(1000);
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        ticketsPage = new TicketsPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        pivotPage = new PivotPage(getDriver());
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

    @Test(groups = "Smoke Test")
    public void TC_Tickets_002_Upload_Attachment_To_Ticket() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.verifyAddedTicketInTicketsPage();
        ticketsPage.uploadAttachementToTicket();
        ticketsPage.verifyingUploadedAttachementsInTicket();
    }

    @Test(groups = "Smoke Test")
    public void TC_Tickets_003_Verify_Status_Assigned_To_In_Tickets_Page() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.setPaginationInTicketsPage();
        ticketsPage.verifyStatusAndAssignedToInTicketsPage();
    }

    @Test(groups = "Smoke Test")
    public void TC_Tickets_001_Add_Ticket_With_Assignee_And_Multiple_Participants() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.verifyAddedTicketInTicketsPage();

    }

    @Test(groups = "Smoke Test")
    public void TC_Tickets_011_Verify_Status_Assigned_To_Filters_In_Tickets_Page() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.setPaginationInTicketsPage();
        ticketsPage.verifyStatusAndAssignedToFiltersInTicketsPage();
    }

    @Test(groups = "Smoke Test")
    public void TC_Tickets_010_Change_Ticket_Settings_In_Tickets_Page() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.verifyAddedTicketInTicketsPage();
        ticketsPage.changeTicketSettingsInTicketsPage();
        ticketsPage.navigateToTicketsPage();
        ticketsPage.verifyChangedTicketSettingsInTicketsPage();
    }

    @Test(groups = "Smoke Test")
    public  void TC_Tickets_006_AddTicketFromDrillthroughpage() throws InterruptedException
    {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
     //   dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigateToDrillthroughPage(gaugePortletName);
        ticketsPage.creatingTicketFrmDrillThrghPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.clickingOnTicketspage();
        ticketsPage.verifyAddedTicketInTicketsPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(groups = "Smoke Test")
    public void TC_Tickets_007_AddTicketFromRCApage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast7Days("12:00 AM");
        portletsFeature.navigateToDrillthroughPage(gaugePortletName);
        portletsFeature.navigateToRCAFromDrillthroughPage();
        ticketsPage.creatingTicketFrmDrillThrghPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.clickingOnTicketspage();
        ticketsPage.verifyAddedTicketInTicketsPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardOverviewPage.searchingDashboard();
        dashboardOverviewPage.deletingDashboard();

    }

    @Test(groups = "Smoke Test")
    public void TC_Tickets_005_AddTicketFromPivotPage() throws InterruptedException {
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardPage.enterAddrequirefeildsInDashBoardPage();
        //dashboardPage.clickOnDashboard();
        portletsFeature.addingGaugePortlet(gaugePortletName);
        dashboardOverviewPage.validatingLast30Days("12:00 AM");
        pivotPage.navigateToPivotPage(gaugePortletName);
        dashboardPage.createTicketOnDashboard();
        dashboardPage.verifyTicketInTicketsPage();
        dashboardOverviewPage.clickingDashBoardModule();
        dashboardPage.searchingDashboard();
        dashboardPage.deleteDashboard();
    }
}
