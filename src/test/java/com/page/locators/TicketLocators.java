package com.page.locators;

import org.openqa.selenium.By;

public interface TicketLocators {

    By TICKETS_SIDE_MENU = By.xpath("//span[contains(@title,'Tickets')]");
    By TICKETS_PAGE_TITLE = By.xpath("//h5[text()='Tickets']");

    //Adding Ticket With assignee and Multiple participants
    By ADD_TICKET_ICON = By.xpath("//i[contains(@aria-label,'New Ticket')]");
    By TICKET_PARTCIPANTS_LIST = By.xpath("//label[@for='participants']/../div/div/div/div[@role='button']/span");

    //Upload attachments
    By UPLOAD_LABEL = By.xpath("//label[contains(@for,'attachButton')]");
    By UPLOAD_ICON = By.xpath("//input[@id='attachButton']");
    By COMMENT_BOX = By.xpath("//label[contains(text(),'Enter a comment')]/../div");
    By COMMENT_TEXTAREA = By.xpath("//label[contains(text(),'Enter a comment')]/following-sibling::div/textarea");
    By SUBMIT_COMMENT = By.xpath("//button/span[contains(text(),'Submit')]");
    By FILES_TICKET = By.xpath("//p[text()='Attachments']/following-sibling::div/a");

    //Verify Status and Assigned To
    By STATUS_ANY = By.xpath("//button[@value='ANY']");
    By ASSIGNED_TO_ME = By.xpath("//button[@value='ME']");
    By ASSIGNED_TO_ANYONE = By.xpath("//button[@value='ANY']/span[text()='Anyone']");
    By TICKET_ROWS = By.xpath("//div[@role='rowgroup']");
    By ASSIGNEE_LIST = By.xpath("//div[@role='rowgroup']/a/div/div/div[4]/span/span");
    By PAGINATION_TICKETS = By.xpath("//div[@aria-haspopup='listbox']");
    By PAGINATION_OPTION = By.xpath("//ul[@role='listbox']/li[text()='10']");
    By PAGINATION_NEXT_PAGE = By.xpath("//button[@title='Next page']");
    By PAGINATION_PREVIOUS_PAGE = By.xpath("//button[@title='Previous page']");
    By PAGINATION_COUNT = By.xpath("//p[contains(@class,'caption')][2]");
    By STATUS_OPEN = By.xpath("//button[@value='OPEN']");
    By STATUS_CLOSED = By.xpath("//button[@value='CLOSED']");
    By STATUS_LIST = By.xpath("//div[@role='rowgroup']/a/div/div/div[8]/span/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");
    //Verify Status and Assigned To Filters
    By CLEAR_FILTER = By.xpath("//button/span[contains(text(),'Clear')]");

    //Change Ticket Settings
    By SEVERITY_OPTION_UPDATED = By.xpath("//span[contains(text(),'Severity')]/../../../following-sibling::div/div/div/div/div[contains(text(),'Critical')]");
    By PRIORITY_OPTION_UPDATED = By.xpath("//span[contains(text(),'Priority')]/../../../following-sibling::div/div/div/div/div[contains(text(),'Low')]");
    By STATUS_OPTION_UPDATED = By.xpath("//div[contains(text(),'Open')]");
    By REMOVE_EXISTING_PARTICIPANTS = By.xpath("//label[@for='participants']/../descendant::*[local-name()='svg'][1]");
    By CLOSE_BUTTON = By.xpath("//h6/../following-sibling::button");
    By TICKET_UPDATED_MESSAGE = By.xpath("//span[contains(@id,'snackbar') and contains(text(),'Ticket updated')]");

}
