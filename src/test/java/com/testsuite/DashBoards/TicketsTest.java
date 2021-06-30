package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.page.module.TicketsPage;
import com.selenium.Sync;
import com.utilities.MailinatorAPI;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TicketsTest extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private TicketsPage ticketsPage;
    private DashboardOverviewPage dashboardOverviewPage;


    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        ticketsPage = new TicketsPage(getDriver());
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

    @Test( groups ="Smoke Test" )
    public void TC_122_Upload_Attachment_To_Ticket() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.verifyAddedTicketInTicketsPage();
        ticketsPage.uploadAttachementToTicket();
        ticketsPage.verifyingUploadedAttachementsInTicket();
    }

    @Test( groups ="Smoke Test" )
    public void TC_123_Verify_Status_Assigned_To_In_Tickets_Page() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.setPaginationInTicketsPage();
        ticketsPage.verifyStatusAndAssignedToInTicketsPage();
    }

    @Test( groups ="Smoke Test" )
    public void TC_121_Add_Ticket_With_Assignee_And_Multiple_Participants() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.addTicketWithAssigneeAndMultipleParticipants();
        ticketsPage.verifyAddedTicketInTicketsPage();

    }
    @Test( groups ="Smoke Test" )
    public void TC_131_Verify_Status_Assigned_To_Filters_In_Tickets_Page() throws InterruptedException {
        ticketsPage.navigateToTicketsPage();
        ticketsPage.setPaginationInTicketsPage();
        ticketsPage.verifyStatusAndAssignedToFiltersInTicketsPage();
    }
}
