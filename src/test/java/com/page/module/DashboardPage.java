package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.DashBoardLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class DashboardPage extends SafeActions implements DashBoardLocators {
    private WebDriver driver;
    Random random = new Random();
    String dname = "Portlet";
    String dname1 = dname + random.nextInt(500);
    String expectedText = "Create" + " May2021129" + "";
    DashBoardData dashBoardData1=new DashBoardData();
    String ticketTitle = dashBoardData1.ticketTitle
            +" - "+random.nextInt(500);
    static int j;
    String Assignee_Add, Severity_Add, Priority_Add, Status_Add, Participants_Add;


    //Constructor to define/call methods
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("To enter the required fields for creating a new Dashboard and click on Finish button")
    public void enterAddrequirefeildsInDashBoardPage() throws InterruptedException {
        safeType(TEXTBOX_DASHBOARD_WINDOW, dname1, "Enter the dashboard name in textbox", MEDIUMWAIT);
        Thread.sleep(7000);
        safeClick(LISTBOX_Folder, "foldername", MEDIUMWAIT);
        Thread.sleep(9000);
        List<WebElement> kpi1 = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + kpi1.size());
        waitUntilClickable(By.xpath("//div[contains(@class,'MuiListItem-button')][@id='react-select-2-option-0']"), "text", 5000);
        for (int i = 0; i < kpi1.size(); i++) {

            if (kpi1.get(i).getText().contains("Dashboards")) {

                kpi1.get(i).click();
                break;
            }
        }

        waitForPageToLoad();
        System.out.println("Before finish");
        safeClick(BUTTON_FINISH, "Clicked on Finish button in Dashboard window", MEDIUMWAIT);
        System.out.println("after finish");
        safeClick(BUTTON_CLOSE, "Clicked on close button in Dashboard window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname1 + "\n", "Enter dashboard into type search");
        System.out.println("entered dbtext");
        String actualText = safeGetText(LISTOFDASHBOARDS, "dashboardname", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname1);

    }

    @Step("Pin Dashboard")
    public void PinDashboard() throws InterruptedException{
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(PIN_DASHBOARD, "text", 5000);
        safeClick(PIN_DASHBOARD, "Pin Dashboard", MEDIUMWAIT);
        Thread.sleep(5000);
        safeClick(ICON_PIN,"Clicking on pin button",MEDIUMWAIT);
        Thread.sleep(5000);
        By pinnedDashboard=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]/../../following-sibling::div/div/a/span/span[contains(text(),'"+dname1+"')]");
        WebElement pinnedDashboardElement = driver.findElement(pinnedDashboard);
        Boolean pinnedDashboard_Visibility = pinnedDashboardElement.isDisplayed();
        System.out.println("Dashboard is visible: "+pinnedDashboard_Visibility);
        Assert.assertTrue(pinnedDashboard_Visibility,"Pinned Dashboard is displayed");
        safeClick(pinnedDashboard,"Clicking on pinned Dashboard in side menu",MEDIUMWAIT);
    }
    @Step("Unpin Dashboard")
    public void Unpin_Pin_Dashboard_FromDashboardPage() throws InterruptedException{
        Boolean flag=false;
        waitForPageToLoad();
        safeClick(UNPIN_DASHBOARD, "Unpin Dashboard", MEDIUMWAIT);
        Thread.sleep(5000);
        By pinnedDashboard=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]/../../following-sibling::div/div/a/span/span[contains(text(),'"+dname1+"')]");
        try {
            driver.findElement(pinnedDashboard).isDisplayed();
            flag = true;
        }
        catch (Exception e){
            e.getMessage();
        }
        if(flag)
            Assert.fail("Pinned Dashboard is still displayed");
        System.out.println("Unpinned Dashboard Verification is completed in Dashboard page");
        safeClick(PIN_DASHBOARDPAGE, "Pin Dashboard from Dashboard page", MEDIUMWAIT);
        Thread.sleep(5000);
        WebElement pinnedDashboardElement = driver.findElement(pinnedDashboard);
        Boolean pinnedDashboard_Visibility = pinnedDashboardElement.isDisplayed();
        System.out.println("Dashboard is visible: "+pinnedDashboard_Visibility);
        Assert.assertTrue(pinnedDashboard_Visibility,"Pinned Dashboard is displayed");
    }

    @Step("Creating Ticket on Dashboard page")
    public void createTicketOnDashboard() throws InterruptedException{
        waitForPageToLoad();
        safeClick(TICKET_ICON, "text", MEDIUMWAIT);
        safeType(TICKET_TITLE, ticketTitle,"Ticket Title in Dashboard page",MEDIUMWAIT);
        safeClick(TICKET_SEVERITY,"Severity field",MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(SEVERITY_OPTION,"Severity Option selection",MEDIUMWAIT);
        safeClick(TICKET_PRIORITY,"Priority field",MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(PRIORITY_OPTION,"Priority Option selection",MEDIUMWAIT);
        safeClick(TICKET_STATUS,"Status field",MEDIUMWAIT);
        waitForPageToLoad();
        safeClick(STATUS_OPTION,"Status Option selection",MEDIUMWAIT);
        Thread.sleep(5000);
        safeClick(TICKET_ASSIGNEE,"Assignee field",MEDIUMWAIT);
        //By TICKET_ASSIGNEE_SELECTION = By.xpath("//div[contains(text(),'"+ dashBoardData1.ticketAssignee+"')]");
       // waitForPageToLoad();
        //WebElement searchField1 = driver.findElement(TEXTBOX_ASSIGNEE);
       // searchField1.sendKeys("vchavhan");
        //Actions act=new Actions(driver);
      //  act.sendKeys(dashBoardData1.ticketAssignee);
        safeType(TEXTBOX_ASSIGNEE,"vchavhan","ENtering text in to asignee");
        List<WebElement> assignees = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
        System.out.println("Total no 0f assignees:::====> " + assignees.size());
       // waitUntilClickable(TICKET_ASSIGNEE_SELECTION,"Wait till assignees load" ,5000);
        for (int i = 0; i < assignees.size(); i++) {
            System.out.println(assignees.get(i).getText());
            if (assignees.get(i).getText().contains(dashBoardData1.ticketAssignee)) {
                assignees.get(i).click();
                break;
            }
        }
        waitForPageToLoad();
        safeClick(TICKET_PARTCIPANTS,"Participants",MEDIUMWAIT);
        System.out.println("Participant existing one is "+driver.findElement(TICKET_PARTCIPANTS).getText());
        By TICKET_PARTICIPANT_SELECTION = By.xpath("//div[contains(text(),'"+dashBoardData1.ticketParticipant+"')]");
        waitForPageToLoad();
        Actions act1=new Actions(driver);
        act1.sendKeys(dashBoardData1.ticketParticipant);
        List<WebElement> participants = driver.findElements(TICKET_PARTICIPANT_SELECTION);
        System.out.println("Total no 0f participants:::====> " + participants.size());
        waitUntilClickable(TICKET_PARTICIPANT_SELECTION,"Wait till participants load" ,5000);
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i).getText());
            if (participants.get(i).getText().contains(dashBoardData1.ticketParticipant)) {
                participants.get(i).click();
                break;
            }
        }
        Assignee_Add=driver.findElement(TICKET_ASSIGNEE).getText();
        Severity_Add=driver.findElement(TICKET_SEVERITY).getText();
        Priority_Add=driver.findElement(TICKET_PRIORITY).getText();
        Status_Add=driver.findElement(TICKET_STATUS).getText();
        Participants_Add=driver.findElement(TICKET_PARTCIPANTS).getText();
        System.out.println("Assignee: "+Assignee_Add+" Severity: "+Severity_Add+" Priority: "+Priority_Add+" Status: "+Status_Add+" Participants: "+Participants_Add);
        safeClick(BUTTON_SUBMIT_TICKET,"Submit ticket button",MEDIUMWAIT);
        Thread.sleep(5000);
    }
    @Step("Verifying Ticket in Tickets page")
    public void verifyTicketInTicketsPage() throws InterruptedException{
        waitUntilClickable(TICKETS_PAGE_URL,"Ticket Page in side menu",MEDIUMWAIT);
        safeClick(TICKETS_PAGE_URL,"Tickets page",MEDIUMWAIT);
        waitForPageToLoad();
        Thread.sleep(15000);
        waitUntilClickable(STATUS_TICKETS_PAGE,"Status in Tickets page",MEDIUMWAIT);
        safeClick(STATUS_TICKETS_PAGE,"Status in Tickets page",MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNED_TO,"Assigned user in Tickets page",MEDIUMWAIT);
        safeClick(TICKET_ASSIGNED_TO,"Assigned user in Tickets page",MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH,ticketTitle+ "\n","Searching Ticket Title",MEDIUMWAIT);
        Thread.sleep(9000);
        By TitleCheck= By.xpath("(//span[contains(text(),'"+ticketTitle+"')])[2]");
        waitUntilClickable(TitleCheck,"Ticket Title",MEDIUMWAIT);
        if(driver.findElement(TitleCheck).isDisplayed()){
            safeClick(TitleCheck, "Ticket Title in Tickets page",MEDIUMWAIT);
            Thread.sleep(9000);
            if(Assignee_Add.equals(driver.findElement(TICKET_ASSIGNEE).getText()) || Severity_Add.equals(driver.findElement(TICKET_SEVERITY).getText()) ||
                    Priority_Add.equals(driver.findElement(TICKET_PRIORITY).getText())||Status_Add.equals(driver.findElement(TICKET_STATUS).getText()) ||
                    Participants_Add.equals(driver.findElement(TICKET_PARTCIPANTS).getText())){
                System.out.println("Ticket details are valid");
                System.out.println("Assignee: "+driver.findElement(TICKET_ASSIGNEE).getText()+" Severity: "+driver.findElement(TICKET_SEVERITY).getText()+
                        " Priority: "+driver.findElement(TICKET_PRIORITY).getText()+" Status: "+driver.findElement(TICKET_STATUS).getText()+
                        " Participants: "+driver.findElement(TICKET_PARTCIPANTS).getText());
            }
            else
                Assert.fail("Ticket details are invalid");
        }else {
            Assert.fail("Ticket added on Dashboard is not displayed in Tickets page");
        }
    }

    @Step("Clicking on Dashboard in Dashboards Overview page")
    public void clickOnDashboard(){
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS, "text", MEDIUMWAIT);
    }
}