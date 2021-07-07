package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.DashBoardLocators;
import com.page.locators.TicketLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicketsPage extends SafeActions implements TicketLocators, DashBoardLocators {
    private WebDriver driver;
    Random random = new Random();
    private DashBoardData dashBoardData = new DashBoardData();
    String sampleTicket = "Ticket From Dashboard page - 48";
    String ticketTitle = dashBoardData.ticketTitle
            + " --- " + random.nextInt(1000);
    String Assignee_Add, Severity_Add, Priority_Add, Status_Add;
    String[] Participants_Add = new String[20];
    String[] Participants_After_Add = new String[20];
    String[] attached_Files = new String[10];
    String attachments[] = new String[10];

    public TicketsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigate to Tickets page")
    public void navigateToTicketsPage() {
        waitForPageToLoad();
        waitUntilClickable(TICKETS_SIDE_MENU, "Tickets Page in side menu", LONGWAIT);
        safeClick(TICKETS_SIDE_MENU, "Tickets Page in side menu", LONGWAIT);
        waitUntilClickable(TICKETS_PAGE_TITLE, "Tickets page Title", MEDIUMWAIT);
        if (!driver.findElement(TICKETS_PAGE_TITLE).isDisplayed())
            Assert.fail("Tickets page is not displayed properly");
    }

    @Step("Navigate to Tickets page")
    public void navigateToSampleTicket() {
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, sampleTicket + "\n", "Searching Ticket Title", MEDIUMWAIT);
        waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", MEDIUMWAIT);
        By myTicket = By.xpath("//div[@role='rowgroup']/a");
        waitUntilClickable(myTicket, "Ticket Rows in Tickets page", MEDIUMWAIT);
        safeClick(myTicket, "", MEDIUMWAIT);
    }

    @Step("Adding Ticket with assignee and Multiple Participants in Tickets page")
    public void addTicketWithAssigneeAndMultipleParticipants() {
        //waitUntilClickable(TICKET_ROWS,"Ticket Rows in Tickets page",MEDIUMWAIT);
        waitUntilClickable(ADD_TICKET_ICON, "Add Ticket Icon", LONGWAIT);
        safeClick(ADD_TICKET_ICON, "Add Ticket Icon", LONGWAIT);
        waitUntilClickable(TICKET_TITLE, "", MEDIUMWAIT);
        safeType(TICKET_TITLE, ticketTitle, "Ticket Title in Dashboard page", MEDIUMWAIT);
        safeClick(TICKET_SEVERITY, "Severity field", MEDIUMWAIT);
        waitUntilClickable(SEVERITY_OPTION, "", MEDIUMWAIT);
        safeClick(SEVERITY_OPTION, "Severity Option selection", MEDIUMWAIT);
        waitUntilClickable(TICKET_PRIORITY, "", MEDIUMWAIT);
        safeClick(TICKET_PRIORITY, "Priority field", MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNEE_DROPDOWN, "", MEDIUMWAIT);
        waitForSecs(3);
        safeClick(PRIORITY_OPTION, "Priority Option selection", MEDIUMWAIT);
        waitUntilClickable(TICKET_STATUS, "", MEDIUMWAIT);
        safeClick(TICKET_STATUS, "Status field", MEDIUMWAIT);
        waitUntilClickable(STATUS_OPTION, "", MEDIUMWAIT);
        safeClick(STATUS_OPTION, "Status Option selection", MEDIUMWAIT);
        safeClick(TICKET_ASSIGNEE, "Assignee field", MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNEE_DROPDOWN, "", MEDIUMWAIT);
        safeType(TEXTBOX_ASSIGNEE, "vchavhan", "Entering text in to assignee");
        List<WebElement> assignees = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
        System.out.println("Total no 0f assignees:::====> " + assignees.size());
        for (int i = 0; i < assignees.size(); i++) {
            System.out.println(assignees.get(i).getText());
            if (assignees.get(i).getText().contains(dashBoardData.ticketAssignee)) {
                assignees.get(i).click();
                break;
            }
        }
        waitForPageToLoad();
        safeClick(TICKET_PARTCIPANTS, "Participants", MEDIUMWAIT);
        System.out.println("Participant existing one is " + driver.findElement(TICKET_PARTCIPANTS).getText());
        safeClick(PARTICIPANTS_GHOSTTEXT, "Select..ghost text", MEDIUMWAIT);
        int participantcount = dashBoardData.ticketParticipantsList.length;
        for (int j = 0; j < participantcount; j++) {
            safeClearAndType(PARTICIPANTS_TEXTBOX, dashBoardData.ticketParticipantsList[j], "Text into partcipants", MEDIUMWAIT);
            waitUntilClickable(TICKET_ASSIGNEE_DROPDOWN, "", MEDIUMWAIT);
            List<WebElement> participants = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
            System.out.println("Total no 0f participants:::====> " + participants.size());
            for (int i = 0; i < participants.size(); i++) {
                System.out.println(participants.get(i).getText());
                if (participants.get(i).getText().contains(dashBoardData.ticketParticipantsList[j])) {
                    WebElement e = participants.get(i);
                    e.click();
                    break;
                }
            }
        }
        Assignee_Add = driver.findElement(TICKET_ASSIGNEE).getText();
        Severity_Add = driver.findElement(TICKET_SEVERITY).getText();
        Priority_Add = driver.findElement(TICKET_PRIORITY).getText();
        Status_Add = driver.findElement(TICKET_STATUS).getText();
        for (int i = 0; i < driver.findElements(TICKET_PARTCIPANTS_LIST).size(); i++) {
            String a = driver.findElements(TICKET_PARTCIPANTS_LIST).get(i).getText();
            Participants_Add[i] = a;
        }
        System.out.println("Assignee: " + Assignee_Add + " Severity: " + Severity_Add + " Priority: " + Priority_Add + " Status: " + Status_Add + " Participants: " + Participants_Add);
        safeClick(BUTTON_SUBMIT_TICKET, "Submit ticket button", MEDIUMWAIT);
    }

    @Step("Verifying added ticket in Tickets page")
    public void verifyAddedTicketInTicketsPage() throws InterruptedException {
        waitForPageToLoad();
        waitForSecs(10);
        //waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", MEDIUMWAIT);
        waitUntilClickable(STATUS_TICKETS_PAGE, "Status in Tickets page", MEDIUMWAIT);
        safeClick(STATUS_TICKETS_PAGE, "Status in Tickets page", MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNED_TO, "Assigned user in Tickets page", MEDIUMWAIT);
        safeClick(TICKET_ASSIGNED_TO, "Assigned user in Tickets page", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, ticketTitle + "\n", "Searching Ticket Title", MEDIUMWAIT);
        waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", MEDIUMWAIT);
        By TitleCheck = By.xpath("(//span[contains(text(),'" + ticketTitle + "')])[2]");
        waitUntilClickable(TitleCheck, "Ticket Title", MEDIUMWAIT);
        if (driver.findElement(TitleCheck).isDisplayed()) {
            safeClick(TitleCheck, "Ticket Title in Tickets page", MEDIUMWAIT);
            waitForSecs(15);
            if (Assignee_Add.equals(driver.findElement(TICKET_ASSIGNEE).getText()) || Severity_Add.equals(driver.findElement(TICKET_SEVERITY).getText()) ||
                    Priority_Add.equals(driver.findElement(TICKET_PRIORITY).getText()) || Status_Add.equals(driver.findElement(TICKET_STATUS).getText())) {
                System.out.println("Ticket details are valid");
                System.out.println("Assignee: " + driver.findElement(TICKET_ASSIGNEE).getText() + " Severity: " + driver.findElement(TICKET_SEVERITY).getText() +
                        " Priority: " + driver.findElement(TICKET_PRIORITY).getText() + " Status: " + driver.findElement(TICKET_STATUS).getText() +
                        " Participants: " + driver.findElement(TICKET_PARTCIPANTS).getText());
                for (int i = 0; i < driver.findElements(TICKET_PARTCIPANTS_LIST).size(); i++) {
                    String a = driver.findElements(TICKET_PARTCIPANTS_LIST).get(i).getText();
                    Participants_After_Add[i] = a;
                }
                System.out.println("Participants before add " + Participants_Add);
                System.out.println("Participants after add " + Participants_After_Add);
                for (int i = 0; i < driver.findElements(TICKET_PARTCIPANTS_LIST).size(); i++) {
                    if (!Participants_Add[i].equals(Participants_After_Add[i]))
                        Assert.fail("Participants are not displayed properly in Ticket");
                }
            } else {
                Assert.fail("Ticket added on Dashboard is not displayed in Tickets page");
            }
        }
    }

    @Step("Upload attachments to Ticket")
    public void uploadAttachementToTicket() {
        waitUntilClickable(UPLOAD_LABEL, "Upload icon in Ticket window", MEDIUMWAIT);
        File folder = new File(dashBoardData.filePath_Tickets);
        File[] files = folder.listFiles();
        String filesList = "";
        for (int i = 0; i < files.length; i++) {
            filesList += (i != 0 ? "\n" : "") + files[i].getAbsolutePath();
        }
        attachments = filesList.split("\n");
        driver.findElement(UPLOAD_ICON).sendKeys(filesList);
        waitUntilClickable(COMMENT_BOX, "Comment box in Ticket", MEDIUMWAIT);
        safeClick(COMMENT_BOX, "Comment box in Ticket", MEDIUMWAIT);
        waitUntilClickable(COMMENT_TEXTAREA, "Comment textarea in Ticket", MEDIUMWAIT);
        safeType(COMMENT_TEXTAREA, "Attachments", "Comment textarea in Ticket", MEDIUMWAIT);
        waitUntilClickable(SUBMIT_COMMENT, "Submit comment with attachments", MEDIUMWAIT);
        safeClick(SUBMIT_COMMENT, "Submit comment with attachments", MEDIUMWAIT);
    }

    @Step("Verifying Uploaded attachments in Ticket")
    public void verifyingUploadedAttachementsInTicket() {
        waitForPageToLoad();
        waitUntilClickable(FILES_TICKET, "Attached Files in Ticket", MEDIUMWAIT);
        List<WebElement> files_Attachments = driver.findElements(FILES_TICKET);
        for (int i = 0; i < files_Attachments.size(); i++) {
            attached_Files[i] = files_Attachments.get(i).getText();
        }
        for (int i = 0; i < files_Attachments.size(); i++) {
            if (!attachments[i].contains(attached_Files[i])) {
                Assert.fail("Attachment " + attached_Files[i] + " is not displayed properly" + attachments[i]);
            }
        }
    }

    @Step("Set Pagination Count in Tickets page")
    public void setPaginationInTicketsPage() {
        waitForPageToLoad();
        // waitUntilClickable(TICKET_ROWS,"Ticket Rows in Tickets page",MEDIUMWAIT);
        waitUntilClickable(PAGINATION_TICKETS, "Pagination in Tickets Page", LONGWAIT);
        safeClick(PAGINATION_TICKETS, "Pagination in Tickets Page", MEDIUMWAIT);
        waitUntilClickable(PAGINATION_OPTION, "First Option in Pagination", MEDIUMWAIT);
        safeClick(PAGINATION_OPTION, "First Option in Pagination", MEDIUMWAIT);
        if (!driver.findElement(PAGINATION_TICKETS).getText().equalsIgnoreCase("10"))
            Assert.fail("Pagination is not set properly");
    }

    @Step("Getting Page Count from pagination in Tickets page")
    public int getPageCountFromPagination() {
        waitForPageToLoad();
        String pageCount = driver.findElement(PAGINATION_COUNT).getText();
        String pageCount_String = pageCount.substring(pageCount.lastIndexOf("of") + 3);
        int paginationCount = Integer.parseInt(pageCount_String);
        System.out.println("Page Count is " + paginationCount);
        return paginationCount;
    }

    @Step("Getting Page Count from pagination in Tickets page")
    public boolean verifyTicketsForStatusAndAssignedTo(By LIST, String compareItem, String msg, boolean checkList) {
        waitForPageToLoad();
        int rowCount = 0;
        int count_Pagination = getPageCountFromPagination();
        waitUntilClickable(LIST, "List", LONGWAIT);
        while (true) {
            List<WebElement> statusList = driver.findElements(LIST);
            System.out.println("List size is " + statusList.size());
            if (checkList) {
                for (int i = 0; i < statusList.size(); i++) {
                    if (!statusList.get(i).getText().equalsIgnoreCase(compareItem)) {
                        Assert.fail("Invalid " + msg + statusList.get(i).getText());
                    }
                }
            }
            rowCount += statusList.size();
            if (!driver.findElement(PAGINATION_NEXT_PAGE).isEnabled()) {
                break;
            }
            safeClick(PAGINATION_NEXT_PAGE, "Next page in Pagination", MEDIUMWAIT);
        }
        System.out.println("Row Count is " + rowCount);
        if (rowCount != count_Pagination)
            Assert.fail("Row Count is not matching with pagination count for " + msg);
        return true;
    }

    @Step("Verify Status and Assigned To in Tickets page")
    public void verifyStatusAndAssignedToInTicketsPage() {
        waitForPageToLoad();
        // waitUntilClickable(TICKET_ROWS,"Ticket Rows in Tickets page",LONGWAIT);
        safeClick(STATUS_ANY, "Any status in Tickets page", MEDIUMWAIT);
        waitUntilClickable(ASSIGNED_TO_ME, "Assigned to Me in Tickets page", LONGWAIT);
        safeClick(ASSIGNED_TO_ME, "Assigned to Me in Tickets page", MEDIUMWAIT);
        if (!verifyTicketsForStatusAndAssignedTo(ASSIGNEE_LIST, dashBoardData.emailAddress, "Assignee", true))
            Assert.fail("Tickets are not displayed properly for Assigned to 'Me'");
        waitUntilClickable(ASSIGNED_TO_ANYONE, "Assigned to Anyone in Tickets page", LONGWAIT);
        safeClick(ASSIGNED_TO_ANYONE, "Assigned to Anyone in Tickets page", MEDIUMWAIT);
        if (!verifyTicketsForStatusAndAssignedTo(ASSIGNEE_LIST, "All", "Assignee", false))
            Assert.fail("Tickets are not displayed properly for Assigned to 'Anyone'");
        waitUntilClickable(STATUS_OPEN, "Status 'Open' in Tickets page", LONGWAIT);
        safeClick(STATUS_OPEN, "Status 'Open' in Tickets page", MEDIUMWAIT);
        if (!verifyTicketsForStatusAndAssignedTo(STATUS_LIST, "Open", "Status 'Open'", true))
            Assert.fail("Tickets are not displayed properly for Status 'Open'");
        waitUntilClickable(STATUS_CLOSED, "Status 'Closed' in Tickets page", LONGWAIT);
        safeClick(STATUS_CLOSED, "Status 'Closed' in Tickets page", MEDIUMWAIT);
        if (!verifyTicketsForStatusAndAssignedTo(STATUS_LIST, "Closed", "Status 'Closed'", true))
            Assert.fail("Tickets are not displayed properly for Status 'Closed'");
    }

    @Step("Verify Status and Assigned To filters in Tickets page")
    public void verifyStatusAndAssignedToFiltersInTicketsPage() {
        waitForPageToLoad();
        //  waitUntilClickable(TICKET_ROWS,"Ticket Rows in Tickets page",LONGWAIT);
        safeClick(STATUS_ANY, "Any status in Tickets page", MEDIUMWAIT);
        waitUntilClickable(ASSIGNED_TO_ANYONE, "Assigned to Anyone in Tickets page", LONGWAIT);
        safeClick(ASSIGNED_TO_ANYONE, "Assigned to Anyone in Tickets page", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, "status : CLOSED" + "\n", "Filter data in search box", MEDIUMWAIT);
        waitForSecs(7);
        if (!verifyTicketsForStatusAndAssignedTo(STATUS_LIST, "Closed", "Status 'Closed'", true))
            Assert.fail("Tickets are not displayed properly for filter Status 'Closed'");
        safeClick(CLEAR_FILTER, "Clear applied filters", MEDIUMWAIT);
        waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", LONGWAIT);
        safeType(TEXTBOX_TYPESEARCH, "status : OPEN" + "\n", "Filter data in search box", MEDIUMWAIT);
        waitForSecs(7);
        if (!verifyTicketsForStatusAndAssignedTo(STATUS_LIST, "Open", "Status 'Open'", true))
            Assert.fail("Tickets are not displayed properly for Filter Status 'Open'");
        safeClick(CLEAR_FILTER, "Clear applied filters", MEDIUMWAIT);
        waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", LONGWAIT);
        safeType(TEXTBOX_TYPESEARCH, "assignee : " + dashBoardData.emailAddress + "\n", "Filter data in search box", MEDIUMWAIT);
        waitForSecs(7);
        if (!verifyTicketsForStatusAndAssignedTo(ASSIGNEE_LIST, dashBoardData.emailAddress, "Assignee", true))
            Assert.fail("Tickets are not displayed properly for filter Assigned to 'Me'");
    }

    @Step("Changing Ticket Settings in Ticket page")
    public void changeTicketSettingsInTicketsPage() {
        waitForPageToLoad();
        waitUntilClickable(TICKET_TITLE, "", MEDIUMWAIT);
        String title = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        driver.findElement(TICKET_TITLE).sendKeys(title, ticketTitle + " - Updated");
        safeClick(TICKET_SEVERITY, "Severity field", MEDIUMWAIT);
        waitUntilClickable(SEVERITY_OPTION_UPDATED, "", MEDIUMWAIT);
        safeClick(SEVERITY_OPTION_UPDATED, "Severity Option selection", MEDIUMWAIT);
        waitUntilClickable(TICKET_PRIORITY, "", MEDIUMWAIT);
        safeClick(TICKET_PRIORITY, "Priority field", MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNEE_DROPDOWN, "", MEDIUMWAIT);
        waitForSecs(2);
        safeClick(PRIORITY_OPTION_UPDATED, "Priority Option selection", MEDIUMWAIT);
        waitUntilClickable(TICKET_STATUS, "", MEDIUMWAIT);
        safeClick(TICKET_STATUS, "Status field", MEDIUMWAIT);
        waitUntilClickable(STATUS_OPTION_UPDATED, "", MEDIUMWAIT);
        safeClick(STATUS_OPTION_UPDATED, "Status Option selection", MEDIUMWAIT);
        safeClick(TICKET_ASSIGNEE, "Assignee field", MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNEE_DROPDOWN, "", MEDIUMWAIT);
        safeType(TEXTBOX_ASSIGNEE, dashBoardData.updatedTicketAssignee, "Entering text in to assignee");
        List<WebElement> assignees = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
        System.out.println("Total no 0f assignees:::====> " + assignees.size());
        for (int i = 0; i < assignees.size(); i++) {
            System.out.println(assignees.get(i).getText());
            if (assignees.get(i).getText().equalsIgnoreCase(dashBoardData.updatedTicketAssignee)) {
                assignees.get(i).click();
                break;
            }
        }
        waitForPageToLoad();
        safeClick(TICKET_PARTCIPANTS, "Participants", MEDIUMWAIT);
        System.out.println("Participant existing one is " + driver.findElement(TICKET_PARTCIPANTS).getText());
        safeClick(REMOVE_EXISTING_PARTICIPANTS, "Remove button in Participants field", MEDIUMWAIT);
        safeClick(PARTICIPANTS_GHOSTTEXT, "Select..ghost text", MEDIUMWAIT);
        int participantcount = dashBoardData.updatedTicketParticipantsList.length;
        for (int j = 0; j < participantcount; j++) {
            safeClearAndType(PARTICIPANTS_TEXTBOX, dashBoardData.updatedTicketParticipantsList[j], "Text into partcipants", MEDIUMWAIT);
            waitUntilClickable(TICKET_ASSIGNEE_DROPDOWN, "", MEDIUMWAIT);
            List<WebElement> participants = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
            System.out.println("Total no 0f participants:::====> " + participants.size());
            for (int i = 0; i < participants.size(); i++) {
                System.out.println(participants.get(i).getText());
                if (participants.get(i).getText().equalsIgnoreCase(dashBoardData.updatedTicketParticipantsList[j])) {
                    WebElement e = participants.get(i);
                    e.click();
                    break;
                }
            }
        }
        Assignee_Add = driver.findElement(TICKET_ASSIGNEE).getText();
        Severity_Add = driver.findElement(TICKET_SEVERITY).getText();
        Priority_Add = driver.findElement(TICKET_PRIORITY).getText();
        Status_Add = driver.findElement(TICKET_STATUS).getText();
        for (int i = 0; i < driver.findElements(TICKET_PARTCIPANTS_LIST).size(); i++) {
            String a = driver.findElements(TICKET_PARTCIPANTS_LIST).get(i).getText();
            Participants_Add[i] = a;
        }
        System.out.println("Assignee: " + Assignee_Add + " Severity: " + Severity_Add + " Priority: " + Priority_Add + " Status: " + Status_Add + " Participants: " + Participants_Add);
        safeClick(CLOSE_BUTTON, "Close ticket button", MEDIUMWAIT);
        waitUntilClickable(TICKET_UPDATED_MESSAGE, "Ticket Updated Message", MEDIUMWAIT);
        if (!driver.findElement(TICKET_UPDATED_MESSAGE).isDisplayed())
            Assert.fail("Ticket Updated message is not displayed");
    }

    @Step("Changing Ticket Settings in Ticket page")
    public void verifyChangedTicketSettingsInTicketsPage() {
        waitForPageToLoad();
        waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", MEDIUMWAIT);
        waitUntilClickable(STATUS_TICKETS_PAGE, "Status in Tickets page", MEDIUMWAIT);
        safeClick(STATUS_TICKETS_PAGE, "Status in Tickets page", MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNED_TO, "Assigned user in Tickets page", MEDIUMWAIT);
        safeClick(TICKET_ASSIGNED_TO, "Assigned user in Tickets page", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, ticketTitle + " - Updated" + "\n", "Searching Ticket Title", MEDIUMWAIT);
        waitUntilClickable(TICKET_ROWS, "Ticket Rows in Tickets page", MEDIUMWAIT);
        By TitleCheck = By.xpath("(//span[contains(text(),'" + ticketTitle + " - Updated" + "')])[2]");
        waitUntilClickable(TitleCheck, "Ticket Title", MEDIUMWAIT);
        if (driver.findElement(TitleCheck).isDisplayed()) {
            safeClick(TitleCheck, "Ticket Title in Tickets page", MEDIUMWAIT);
            waitForSecs(10);
            if (Assignee_Add.equals(driver.findElement(TICKET_ASSIGNEE).getText()) || Severity_Add.equals(driver.findElement(TICKET_SEVERITY).getText()) ||
                    Priority_Add.equals(driver.findElement(TICKET_PRIORITY).getText()) || Status_Add.equals(driver.findElement(TICKET_STATUS).getText())) {
                System.out.println("Ticket details are valid");
                System.out.println("Assignee: " + driver.findElement(TICKET_ASSIGNEE).getText() + " Severity: " + driver.findElement(TICKET_SEVERITY).getText() +
                        " Priority: " + driver.findElement(TICKET_PRIORITY).getText() + " Status: " + driver.findElement(TICKET_STATUS).getText() +
                        " Participants: " + driver.findElement(TICKET_PARTCIPANTS).getText());
                for (int i = 0; i < driver.findElements(TICKET_PARTCIPANTS_LIST).size(); i++) {
                    String a = driver.findElements(TICKET_PARTCIPANTS_LIST).get(i).getText();
                    Participants_After_Add[i] = a;
                }
                for (int i = 0; i < driver.findElements(TICKET_PARTCIPANTS_LIST).size(); i++) {
                    if (!Participants_Add[i].equals(Participants_After_Add[i])) {
                        System.out.println("Participant add: " + Participants_Add[i] + " Partcipant after add is " + Participants_After_Add[i]);
                        Assert.fail("Participants are not displayed properly in Ticket");
                    }
                }
            } else {
                Assert.fail("Ticket added on Dashboard is not displayed in Tickets page");
            }
        }
    }

}
