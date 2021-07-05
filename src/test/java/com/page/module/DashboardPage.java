package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.DashBoardLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.openqa.selenium.*;
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
    String Assignee_Add, Severity_Add, Priority_Add, Status_Add, Participants_Add,filterValue_Drillthrough,portletName_Pivot;
    String sampleDashboard_AllowedUsers = dashBoardData1.sampleDashboard_AllowedUsers;
    String sampleDB_RequiredRoles = dashBoardData1.sampleDB_RequiredRole;
    String sample_Role_Name = dashBoardData1.sample_Role_Name + " - " +random.nextInt(1000);
    String sampleDB_OwnerRoles = dashBoardData1.sampleDB_OwnerRole;
    String sample_RoleName_Owner = dashBoardData1.sample_Role_Name_Owner + " - " +random.nextInt(1000);
    String dname12= "Sample DB - ";
    String dname2 = dname12 + random.nextInt(500);

    //Constructor to define/call methods
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("To enter the required fields for creating a new Dashboard and click on Finish button")
    public void enterAddrequirefeildsInDashBoardPage() throws InterruptedException {
        safeType(TEXTBOX_DASHBOARD_WINDOW, dname2, "Dashboard name in text box", MEDIUMWAIT);
        waitForSecs(7);
        safeClick(LISTBOX_Folder, "Folder", MEDIUMWAIT);
        waitForSecs(9);
        List<WebElement> dbs = driver.findElements(DROPDOWN_DASHBOARD_FOLDER);
        System.out.println("Total no 0f dashboards:::====> " + dbs.size());
        waitUntilClickable(By.xpath("//div[contains(@class,'MuiListItem-button')][@id='react-select-2-option-0']"), "text", 5000);
        for (int i = 0; i < dbs.size(); i++) {

            if (dbs.get(i).getText().contains(dashBoardData1.dashboardname)) {

                dbs.get(i).click();
                break;
            }
        }

        waitForPageToLoad();
        System.out.println("Before finish");
        safeClick(BUTTON_FINISH, " Finish button in Dashboard window", MEDIUMWAIT);
        System.out.println("after finish");
        safeClick(BUTTON_CLOSE, "Close button in Dashboard window", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname2 + "\n", "Dashboard into type search");
        System.out.println("entered dbtext");
        String actualText = safeGetText(LISTOFDASHBOARDS, "Dashboard name", MEDIUMWAIT);
        System.out.println(actualText);
        Assert.assertEquals(actualText, dname2);

    }

    @Step("Pin Dashboard")
    public void PinDashboard() throws InterruptedException{
        waitForPageToLoad();
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(PIN_DASHBOARD, "text", 5000);
        safeClick(PIN_DASHBOARD, "Pin Dashboard", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(ICON_PIN,"pin button",MEDIUMWAIT);
        waitForSecs(5);
        By pinnedDashboard=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]/../../following-sibling::div/div/a/span/span[contains(text(),'"+dname2+"')]");
        WebElement pinnedDashboardElement = driver.findElement(pinnedDashboard);
        Boolean pinnedDashboard_Visibility = pinnedDashboardElement.isDisplayed();
        System.out.println("Dashboard is visible: "+pinnedDashboard_Visibility);
        Assert.assertTrue(pinnedDashboard_Visibility,"Pinned Dashboard is displayed");
        safeClick(pinnedDashboard,"Pinned Dashboard in side menu",MEDIUMWAIT);
    }

    @Step("Unpin Dashboard")
    public void Unpin_Pin_Dashboard_FromDashboardPage() throws InterruptedException{
        Boolean flag=false;
        waitForPageToLoad();
        safeClick(UNPIN_DASHBOARD, "Unpin Dashboard", MEDIUMWAIT);
        waitForSecs(5);
        By pinnedDashboard=By.xpath("//div[@class='menu-icon-hover']/following-sibling::span/span[contains(text(),'Dashboards')]/../../following-sibling::div/div/a/span/span[contains(text(),'"+dname2+"')]");
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
        waitForSecs(5);
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
        waitForSecs(5);
        safeClick(TICKET_ASSIGNEE,"Assignee field",MEDIUMWAIT);
        safeType(TEXTBOX_ASSIGNEE,"vchavhan","ENtering text in to asignee");
        List<WebElement> assignees = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
        System.out.println("Total no 0f assignees:::====> " + assignees.size());
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
        waitForSecs(5);
        safeClick(PARTICIPANTS_GHOSTTEXT,"Select..ghost text",MEDIUMWAIT);
        safeClearAndType(PARTICIPANTS_TEXTBOX,dashBoardData1.ticketParticipant,"Text into partcipants",MEDIUMWAIT);
        List<WebElement> participants = driver.findElements(TICKET_ASSIGNEE_DROPDOWN);
        System.out.println("Total no 0f participants:::====> " + participants.size());
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i).getText());
            waitForSecs(7);
            if (participants.get(i).getText().contains(dashBoardData1.ticketParticipant)) {
                WebElement e=  participants.get(i);
                e.click();
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
        waitForSecs(15);
        waitUntilClickable(STATUS_TICKETS_PAGE,"Status in Tickets page",MEDIUMWAIT);
        safeClick(STATUS_TICKETS_PAGE,"Status in Tickets page",MEDIUMWAIT);
        waitUntilClickable(TICKET_ASSIGNED_TO,"Assigned user in Tickets page",MEDIUMWAIT);
        safeClick(TICKET_ASSIGNED_TO,"Assigned user in Tickets page",MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH,ticketTitle+ "\n","Searching Ticket Title",MEDIUMWAIT);
        waitForSecs(9);
        By TitleCheck= By.xpath("(//span[contains(text(),'"+ticketTitle+"')])[2]");
        waitUntilClickable(TitleCheck,"Ticket Title",MEDIUMWAIT);
        if(driver.findElement(TitleCheck).isDisplayed()){
            safeClick(TitleCheck, "Ticket Title in Tickets page",MEDIUMWAIT);
            waitForSecs(9);
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


    @Step("Adding and Verifying Sample Portlet")
    public void addingAndVerifyingSamplePortlet(){
        waitForPageToLoad();
        waitUntilClickable(BTN_ADD_METRIC, "Clicking add metric icon");
        safeClick(BTN_ADD_METRIC, "Clicking on Add metric icon");
        waitUntilClickable(SEARCH_BAR_ADD_METRIC,"Search bar in Add Metric Window",MEDIUMWAIT);
        safeClick(SEARCH_BAR_ADD_METRIC,"Search bar in Add Metric Window",MEDIUMWAIT);
        driver.findElement(SEARCH_BAR_ADD_METRIC).sendKeys(dashBoardData1.portletQuery, Keys.ENTER,Keys.ENTER);
        waitForPageToLoad();
        By PORTLET_TITLE= By.xpath("//span[@aria-label='"+dashBoardData1.portletQuery+"']");
        waitUntilClickable(PORTLET_TITLE,"Counter Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(PORTLET_TITLE).isDisplayed())
            Assert.fail("Counter portlet added is not displayed in Dashboard page");
    }

    @Step("Set 'Allowed Users' in 'Dashboard Visibility'")
    public void setAllowedUsersInDashboardVisibility() throws InterruptedException{
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS,"Dashboard in Dashboards Overview page", MEDIUMWAIT);
        addingAndVerifyingSamplePortlet();
        waitUntilClickable(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        safeClick(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        waitUntilClickable(ALLOWED_USERS_FIELD,"Allowed Users Field",MEDIUMWAIT);
        safeClick(ALLOWED_USERS_FIELD,"Allowed Users Field",MEDIUMWAIT);
        By ALLOWED_USER_OPTION = By.xpath("//div[contains(text(),'"+dashBoardData1.userName+"')]");
        waitForPageToLoad();
        Actions act2=new Actions(driver);
        act2.sendKeys(dashBoardData1.userName);
        waitUntilClickable(ALLOWED_USER_OPTION,"Wait till users load" ,5000);
        List<WebElement> users = driver.findElements(ALLOWED_USER_OPTION);
        System.out.println("Total no 0f users:::====> " + users.size());
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getText());
            if (users.get(i).getText().contains(dashBoardData1.userName)) {
                users.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_SAVE_DASHBOARD_VISIBILITY,"Save button in Dashboard Visibility",MEDIUMWAIT);
        waitForSecs(10);
    }

    @Step("Accessing Dashboard by Allowed user")
    public void accessDashboardByAllowedUser() throws InterruptedException{
        boolean flag = false;
        try{
            safeClick(CLOSE_ERROR_POPUP,"Close button in error popup",MEDIUMWAIT);
        }
        catch (NoSuchElementException|AssertionError e){
            e.getMessage();
        }
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", LONGWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dname2 + "\n", "Enter dashboard into type search");
        By SAMPLE_DASHBOARD = By.xpath("//div[@title='"+dname2+"']");
        waitUntilClickable(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        safeClick(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        By HEADER_DASHBOARD = By.xpath("//h5[contains(text(),'"+dname2+"')]");
        waitUntilClickable(HEADER_DASHBOARD,"",MEDIUMWAIT);
        if(!driver.findElement(HEADER_DASHBOARD).isDisplayed())
            Assert.fail("Dashboard page is not displayed for user after giving access");
        By PORTLET_TITLE= By.xpath("//span[@aria-label='"+dashBoardData1.portletQuery+"']");
        waitUntilClickable(PORTLET_TITLE,"Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(PORTLET_TITLE).isDisplayed())
            Assert.fail("Portlet added is not displayed in Dashboard page");
        try{
            if((driver.findElement(ADD_METRIC_ICON).isDisplayed()|driver.findElement(BTN_RENAME_DASHBOARD).isDisplayed()|
                    driver.findElement(BTN_CLONE_DASHBOARD).isDisplayed()|driver.findElement(BTN_PORTLETS_PER_ROW).isDisplayed()|
                    driver.findElement(DASHBAORD_VISIBILITY_ICON).isDisplayed()))
                Assert.fail("Dashboard Permissions are given to 'Allowed User'");
            if((driver.findElement(BTN_CLONE_PORTLET).isDisplayed()|driver.findElement(BTN_EDIT_PORTLET).isDisplayed()|
                    driver.findElement(BTN_CLOSE_PORTLET).isDisplayed()))
                Assert.fail("Permissions for portlet are given to 'Allowed User'");
            flag = true;
        }catch(Exception e){
            System.out.println("Expected Permissions are given to 'Allowed User'");
        }
        if(flag)
            Assert.fail("Non-applicable Permissions are given to 'Allowed User'");
    }

    @Step("Remove 'Allowed Users' in 'Dashboard Visibility'")
    public void removeAllowedUsersInDashboardVisibility() throws InterruptedException{
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dname2 + "\n", "Enter dashboard into type search");
        By SAMPLE_DASHBOARD = By.xpath("//div[@title='"+dname2+"']");
        waitUntilClickable(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        safeClick(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        waitUntilClickable(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        safeClick(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        waitUntilClickable(ALLOWED_USERS_FIELD,"Allowed Users Field",MEDIUMWAIT);
        By DELETE_ALLOWED_USER = By.xpath("//span[contains(text(),'"+dashBoardData1.userName+"')]/following-sibling::i");
        waitUntilClickable(DELETE_ALLOWED_USER,"Delete icon for Allowed User",MEDIUMWAIT);
        safeClick(DELETE_ALLOWED_USER,"Delete icon for Allowed User",MEDIUMWAIT);
        safeClick(BTN_SAVE_DASHBOARD_VISIBILITY,"Save button in Dashboard Visibility",MEDIUMWAIT);
    }

    @Step("Accessing Dashboard by sample user after removing access")
    public void accessDashboardByUserAfterRemovingAccess() throws InterruptedException{
        //waitUntilClickable(ERROR_MESSAGE,"Error popup for accessing dashboard",MEDIUMWAIT);
        waitForSecs(10);
        if(!driver.findElement(ERROR_MESSAGE).isDisplayed())
            Assert.fail("Error message is not displayed for user without access");
    }

    @Step("Navigate to Dashboards page")
    public void navigateToDashboardsPage(){
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", LONGWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
    }

    @Step("Set 'Required Roles' in 'Dashboard Visibility'")
    public void setRequiredRolesInDashboardVisibility() throws InterruptedException{
        boolean flag = false;
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS,"Dashboard in Dashboards Overview page", MEDIUMWAIT);
        addingAndVerifyingSamplePortlet();
        waitUntilClickable(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        safeClick(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        waitUntilClickable(BTN_REQUIRED_ROLES,"Add icon in 'Required Roles' Field",MEDIUMWAIT);
        safeClick(BTN_REQUIRED_ROLES,"Add icon in 'Required Roles' Field",MEDIUMWAIT);
        waitForSecs(7);
        waitUntilClickable(NAME_ADD_ROLE_WINDOW,"Name field in Add Role window",MEDIUMWAIT);
        safeType(NAME_ADD_ROLE_WINDOW,sample_Role_Name,"Name field in Add Role window",MEDIUMWAIT);
        safeClick(VIEW_DATA_PRIVILEGE,"View Data Privilege in Add Role window",MEDIUMWAIT);
        safeClick(BTN_FINISH_ROLE_WINDOW,"Finish button in Add Role window",MEDIUMWAIT);
        waitForSecs(7);
        if(!driver.findElement(SUCCESS_CREATED_MESSAGE).isDisplayed())
            Assert.fail("User is not able to add new Role in 'Required Roles' field");
        waitUntilClickable(BTN_CLOSE_ROLE,"Close button in Role window",MEDIUMWAIT);
        safeClick(BTN_CLOSE_ROLE,"Close button in Role window",MEDIUMWAIT);
        By DELETE_REQUIRED_ROLE = By.xpath("//span[contains(text(),'"+sample_Role_Name+"')]/following-sibling::i");
        waitUntilClickable(DELETE_REQUIRED_ROLE,"Delete icon for Required Role",MEDIUMWAIT);
        safeClick(DELETE_REQUIRED_ROLE,"Delete icon for Required Role",MEDIUMWAIT);
        safeClick(REQUIRED_ROLES_FIELD,"Requires Roles field",MEDIUMWAIT);
        List<WebElement> roles = driver.findElements(DROPDOWN_REQUIRED_ROLES);
        System.out.println("Total no of roles:::====> " + roles.size());
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(roles.get(i).getText());
            if (roles.get(i).getText().contains(dashBoardData1.sample_Required_Role)) {
                roles.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        safeClick(BTN_SAVE_DASHBOARD_VISIBILITY,"Save button in Dashboard Visibility",MEDIUMWAIT);
        waitForSecs(10);
    }

    @Step("Accessing Dashboard by sample user with 'Required Roles'")
    public void accessDashboardByRequiredRoleUser() throws InterruptedException{
        boolean flag = false;
        try{
            safeClick(CLOSE_ERROR_POPUP,"Close button in error popup",MEDIUMWAIT);
        }
        catch (NoSuchElementException|AssertionError e){
            e.getMessage();
        }
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", LONGWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dname2 + "\n", "Enter dashboard into type search");
        By SAMPLE_DASHBOARD = By.xpath("//div[@title='"+dname2+"']");
        waitUntilClickable(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        safeClick(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        By HEADER_DASHBOARD = By.xpath("//h5[contains(text(),'"+dname2+"')]");
        waitUntilClickable(HEADER_DASHBOARD,"",MEDIUMWAIT);
        if(!driver.findElement(HEADER_DASHBOARD).isDisplayed())
            Assert.fail("Dashboard page is not displayed for user after giving access");
        By PORTLET_TITLE= By.xpath("//span[@aria-label='"+dashBoardData1.portletQuery+"']");
        waitUntilClickable(PORTLET_TITLE,"Portlet Title",MEDIUMWAIT);
        if(!driver.findElement(PORTLET_TITLE).isDisplayed())
            Assert.fail("Portlet added is not displayed in Dashboard page");
        try{
            if((driver.findElement(ADD_METRIC_ICON).isDisplayed()|driver.findElement(BTN_RENAME_DASHBOARD).isDisplayed()|
                    driver.findElement(BTN_CLONE_DASHBOARD).isDisplayed()|driver.findElement(BTN_PORTLETS_PER_ROW).isDisplayed()|
                    driver.findElement(DASHBAORD_VISIBILITY_ICON).isDisplayed()))
                Assert.fail("Dashboard Permissions are given to 'Required Role' User");
            if((driver.findElement(BTN_CLONE_PORTLET).isDisplayed()|driver.findElement(BTN_EDIT_PORTLET).isDisplayed()|
                    driver.findElement(BTN_CLOSE_PORTLET).isDisplayed()))
                Assert.fail("Permissions for portlet are given to 'Required Role' user");
            flag = true;
        }catch(Exception e){
            System.out.println("Expected Permissions are given to 'Required Role' user");
        }
        if(flag)
            Assert.fail("Non-applicable Permissions are given to 'Required Role' User");
    }

    @Step("Remove 'Required Roles' in 'Dashboard Visibility'")
    public void removeRequiredRoleInDashboardVisibility() throws InterruptedException{
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dname2 + "\n", "Enter dashboard into type search");
        By SAMPLE_DASHBOARD = By.xpath("//div[@title='"+dname2+"']");
        waitUntilClickable(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        safeClick(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        waitUntilClickable(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        safeClick(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        waitUntilClickable(REQUIRED_ROLES_FIELD,"Required Roles Field",MEDIUMWAIT);
        By DELETE_REQUIRED_ROLES = By.xpath("//span[contains(text(),'"+dashBoardData1.sample_Required_Role+"')]/following-sibling::i");
        waitUntilClickable(DELETE_REQUIRED_ROLES,"Delete icon for Required Role",MEDIUMWAIT);
        safeClick(DELETE_REQUIRED_ROLES,"Delete icon for Required Role",MEDIUMWAIT);
        safeClick(BTN_SAVE_DASHBOARD_VISIBILITY,"Save button in Dashboard Visibility",MEDIUMWAIT);
    }

    @Step("Accessing Dashboard by sample user after removing required role")
    public void accessDashboardByUserAfterRemovingRequiredRole() throws InterruptedException{
        waitUntilClickable(ERROR_MESSAGE,"Error popup for accessing dashboard",MEDIUMWAIT);
        if(!driver.findElement(ERROR_MESSAGE).isDisplayed())
            Assert.fail("Error message is not displayed for user without access");
    }

    @Step("Set 'Owner Roles' in 'Dashboard Visibility'")
    public void setOwnerRolesInDashboardVisibility() throws InterruptedException{
        waitForPageToLoad();
        safeClick(LISTOFDASHBOARDS,"Dashboard in Dashboards Overview page", MEDIUMWAIT);
        addingAndVerifyingSamplePortlet();
        waitUntilClickable(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        safeClick(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        waitUntilClickable(BTN_OWNER_ROLES,"Add icon in 'Owner Roles' Field",MEDIUMWAIT);
        safeClick(BTN_OWNER_ROLES,"Add icon in 'Owner Roles' Field",MEDIUMWAIT);
        waitForPageToLoad();
        waitUntilClickable(NAME_ADD_ROLE_WINDOW,"Name field in Add Role window",MEDIUMWAIT);
        safeType(NAME_ADD_ROLE_WINDOW,sample_RoleName_Owner,"Name field in Add Role window",MEDIUMWAIT);
        safeClick(VIEW_DATA_PRIVILEGE,"View Data Privilege in Add Role window",MEDIUMWAIT);
        safeClick(BTN_FINISH_ROLE_WINDOW,"Finish button in Add Role window",MEDIUMWAIT);
        waitUntilClickable(SUCCESS_CREATED_MESSAGE,"Success message after adding Role",MEDIUMWAIT);
        if(!driver.findElement(SUCCESS_CREATED_MESSAGE).isDisplayed())
            Assert.fail("User is not able to add new Role in 'Owner Roles' field");
        waitUntilClickable(BTN_CLOSE_ROLE,"Close button in Role window",MEDIUMWAIT);
        safeClick(BTN_CLOSE_ROLE,"Close button in Role window",MEDIUMWAIT);
        By DELETE_OWNER_ROLE = By.xpath("//span[contains(text(),'"+sample_RoleName_Owner+"')]/following-sibling::i");
        waitUntilClickable(DELETE_OWNER_ROLE,"Delete icon for Owner Role",MEDIUMWAIT);
        safeClick(DELETE_OWNER_ROLE,"Delete icon for Owner Role",MEDIUMWAIT);
        safeClick(OWNER_ROLES_FIELD,"Requires Roles field",MEDIUMWAIT);
        List<WebElement> roles = driver.findElements(DROPDOWN_OWNER_ROLES);
        System.out.println("Total no of roles:::====> " + roles.size());
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(roles.get(i).getText());
            if (roles.get(i).getText().contains(dashBoardData1.sample_Owner_Role)) {
                roles.get(i).click();
                break;
            }
        }
        safeClick(BTN_SAVE_DASHBOARD_VISIBILITY,"Save button in Dashboard Visibility",MEDIUMWAIT);
    }

    @Step("Accessing Dashboard by sample user with 'Owner Roles'")
    public void accessDashboardByOwnerRoleUser() throws InterruptedException{
        try{
            safeClick(CLOSE_ERROR_POPUP,"Close button in error popup",MEDIUMWAIT);
        }
        catch (NoSuchElementException |AssertionError e){
            e.getMessage();
        }
        safeClick(DASHBOARd_MODULE, "DashBoard Module on Home page", LONGWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        safeType(TEXTBOX_TYPESEARCH, dname2 + "\n", "Enter dashboard into type search");
        By SAMPLE_DASHBOARD = By.xpath("//div[@title='"+dname2+"']");
        waitUntilClickable(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        safeClick(SAMPLE_DASHBOARD,"Sample Dashboard for user",MEDIUMWAIT);
        By HEADER_DASHBOARD = By.xpath("//h5[contains(text(),'"+dname2+"')]");
        waitUntilClickable(HEADER_DASHBOARD,"",MEDIUMWAIT);
        if(!driver.findElement(HEADER_DASHBOARD).isDisplayed())
            Assert.fail("Dashboard page is not displayed for user after giving access");
        if(!(driver.findElement(ADD_METRIC_ICON).isDisplayed()&&driver.findElement(BTN_RENAME_DASHBOARD).isDisplayed()&&
                driver.findElement(BTN_CLONE_DASHBOARD).isDisplayed()&&driver.findElement(BTN_PORTLETS_PER_ROW).isDisplayed()&&
                driver.findElement(DASHBAORD_VISIBILITY_ICON).isDisplayed()))
            Assert.fail("Dashboard Permissions are not given properly to 'Owner Role' User");
        if(!(driver.findElement(BTN_CLONE_PORTLET).isDisplayed()&&driver.findElement(BTN_EDIT_PORTLET).isDisplayed()&&
                driver.findElement(BTN_CLOSE_PORTLET).isDisplayed()))
            Assert.fail("Permissions for portlet are not given properly to owner user");
    }
    @Step("Remove 'Owner Roles' in 'Dashboard Visibility'")
    public void removeOwnerRoleInDashboardVisibility() throws InterruptedException{
        waitForPageToLoad();
        waitUntilClickable(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        safeClick(DASHBAORD_VISIBILITY_ICON,"Dashboard Visibility icon",MEDIUMWAIT);
        waitUntilClickable(OWNER_ROLES_FIELD,"Owner Roles Field",MEDIUMWAIT);
        By DELETE_OWNER_ROLES = By.xpath("//span[contains(text(),'"+dashBoardData1.sample_Owner_Role+"')]/following-sibling::i");
        waitUntilClickable(DELETE_OWNER_ROLES,"Delete icon for Required Role",MEDIUMWAIT);
        safeClick(DELETE_OWNER_ROLES,"Delete icon for Required Role",MEDIUMWAIT);
        safeClick(BTN_SAVE_DASHBOARD_VISIBILITY,"Save button in Dashboard Visibility",MEDIUMWAIT);
    }

    @Step("Accessing Dashboard by sample user after removing owner role")
    public void accessDashboardByUserAfterRemovingOwnerRole() throws InterruptedException{
        refresh();
        waitUntilClickable(ERROR_MESSAGE,"Error popup for accessing dashboard",MEDIUMWAIT);
        if(!driver.findElement(ERROR_MESSAGE).isDisplayed())
            Assert.fail("Error message is not displayed for user without access");
    }

    @Step("Navigating to Drillthrough page from pivot page")
    public void navigateToDrillthroughPageFromPivotPage() {
        waitForPageToLoad();
        System.out.println("Pivot Portlet Name is "+driver.findElement(FIRST_PORTLET_PIVOT).getText());
        portletName_Pivot = driver.findElement(FIRST_PORTLET_PIVOT).getText();
        By DRILLTHROUGH_TABLE_PORTLET = By.xpath("//span[contains(@aria-label,'" + portletName_Pivot + "')]/../../../descendant::div[contains(@aria-label,'Drillthrough')]");
        waitUntilClickable(DRILLTHROUGH_TABLE_PORTLET, "Drillthrough icon in Table portlet", MEDIUMWAIT);
        safeClick(DRILLTHROUGH_TABLE_PORTLET, "Drillthrough icon in Table portlet", MEDIUMWAIT);
        waitUntilClickable(Title_DRILLTHROUGH,"Drillthrough Title",MEDIUMWAIT);
        if(!driver.findElement(Title_DRILLTHROUGH).getText().contains(portletName_Pivot))
            System.out.println("Drillthrough page is not displayed properly");
    }


    @Step("Verify Standard Breadcrumb navigation")
    public void verifyStandardBreadcrumbNavigation() throws InterruptedException{
        waitUntilClickable(DASHBOARD_BREADCRUMB,"Dashboard Breadcrumb",MEDIUMWAIT);
        System.out.println("Breadcrumb is "+driver.findElement(DASHBOARD_BREADCRUMB).getText()+" dNAME IS "+dname2);
        if (!driver.findElements(DASHBOARD_BREADCRUMB).get(0).getText().equalsIgnoreCase(dname2))
            Assert.fail("Breadcrumb for Dashboard is not displayed properly");
        System.out.println("Breadcrumb for Pivot is "+driver.findElement(PIVOT_BREADCRUMB).getText()+"portlet name is "+dashBoardData1.portletQuery);
        if(!driver.findElement(PIVOT_BREADCRUMB).getText().equalsIgnoreCase(dashBoardData1.portletQuery))
            Assert.fail("Breadcrumb for Pivot is not displayed properly");
        System.out.println("Breadcrumb for Drillthrough is "+driver.findElement(DRILLTHROUGH_BREADCRUMB).getText()+"portlet name is "+portletName_Pivot);
        if(!driver.findElement(DRILLTHROUGH_BREADCRUMB).getText().equalsIgnoreCase(portletName_Pivot))
            Assert.fail("Breadcrumb for Drillthrough is not displayed properly");
    }

    @Step("Verify Standard Breadcrumb Backward navigation")
    public void verifyStandardBreadcrumbBackwardNavigation() throws InterruptedException{
        waitUntilClickable(DRILLTHROUGH_BREADCRUMB,"Drillthrough Breadcrumb",MEDIUMWAIT);
        safeClick(DRILLTHROUGH_BREADCRUMB,"Drillthrough Breadcrumb",MEDIUMWAIT);
        if(!driver.findElement(DRILLTHROUGH_BREADCRUMB).getText().equalsIgnoreCase(portletName_Pivot))
            Assert.fail("Breadcrumb for Drillthrough is not displayed properly");
        if(!driver.findElement(Title_DRILLTHROUGH).getText().contains(portletName_Pivot))
            Assert.fail("Title for Drillthrough page is not displayed properly");
        waitUntilClickable(PIVOT_BREADCRUMB,"Pivot Page Breadcrumb",MEDIUMWAIT);
        safeClick(PIVOT_BREADCRUMB,"Pivot Page Breadcrumb",MEDIUMWAIT);
        if(!driver.findElement(PIVOT_BREADCRUMB).getText().equalsIgnoreCase(dashBoardData1.portletQuery))
            Assert.fail("Breadcrumb for Pivot is not displayed properly");
        if(!driver.findElement(Title_DRILLTHROUGH).getText().contains(dashBoardData1.portletQuery))
            Assert.fail("Title for Pivot page is not displayed properly");
        waitUntilClickable(DASHBOARD_BREADCRUMB,"Dashboard Breadcrumb",MEDIUMWAIT);
        safeClick(DASHBOARD_BREADCRUMB,"Dashboard Breadcrumb",MEDIUMWAIT);
        if(!driver.findElement(DASHBOARD_TITLE).getText().equalsIgnoreCase(dname2))
            Assert.fail("Title for Dashboard page is not displayed properly");
    }

    @Step("Applying and Verifying breadcrumb with constraints in Drillthrough page")
    public void applyAndVerifyConstraintsInDrillthroughPage() {
        waitForPageToLoad();
        safeClick(TEXTBOX_TYPESEARCH,"Search box in Drillthrough page",MEDIUMWAIT);
        String constraint = Keys.chord(dashBoardData1.constraint_DrillthroughPage)+Keys.ENTER;
        driver.findElement(TEXTBOX_TYPESEARCH).sendKeys(constraint);
        waitUntilClickable(FILTER_VALUE_DRILLTHROUGH,"Filter value in Drillthrough page",MEDIUMWAIT);
        filterValue_Drillthrough=driver.findElement(FILTER_VALUE_DRILLTHROUGH).getText();
        if(!driver.findElement(FILTER_VALUE_DRILLTHROUGH).getText().equalsIgnoreCase(driver.findElement(BREADCRUMB_DRILLTHROUGH).getText()))
            Assert.fail("Breadcrumb is not updated as per the applied constraint");
    }

    @Step("Verify Standard Breadcrumb navigation with constraints in Drillthrough page")
    public void verifyBreadcrumbNavigationWithConstraintsInDrillthroughPage() throws InterruptedException{
        waitUntilClickable(DASHBOARD_BREADCRUMB,"Dashboard Breadcrumb",MEDIUMWAIT);
        System.out.println("Breadcrumb is "+driver.findElement(DASHBOARD_BREADCRUMB).getText()+" dNAME IS "+dname2);
        if (!driver.findElement(DASHBOARD_BREADCRUMB).getText().equalsIgnoreCase(dname2))
            Assert.fail("Breadcrumb for Dashboard is not displayed properly");
        System.out.println("Breadcrumb for Drillthrough is "+driver.findElement(BREADCRUMB_DRILLTHROUGH).getText()+" Filter value is "+filterValue_Drillthrough);
        if(!driver.findElement(BREADCRUMB_DRILLTHROUGH).getText().equalsIgnoreCase(filterValue_Drillthrough))
            Assert.fail("Breadcrumb with constraints for Drillthrough is not displayed properly");
    }

    @Step("Verify Standard Breadcrumb navigation with constraints in Drillthrough page")
    public void verifyBreadcrumbBackwardNavigationWithConstraintsInDrillthroughPage() throws InterruptedException{
        waitUntilClickable(BREADCRUMB_DRILLTHROUGH,"Drillthrough Breadcrumb",MEDIUMWAIT);
        safeClick(BREADCRUMB_DRILLTHROUGH,"Drillthrough Breadcrumb",MEDIUMWAIT);
        if(!driver.findElement(BREADCRUMB_DRILLTHROUGH).getText().equalsIgnoreCase(filterValue_Drillthrough))
            Assert.fail("Breadcrumb with constraints for Drillthrough is not displayed properly on backward navigation");
        if(!driver.findElement(Title_DRILLTHROUGH).getText().contains(dashBoardData1.portletQuery))
            Assert.fail("Title for Drillthrough page is not displayed properly");
        waitUntilClickable(DASHBOARD_BREADCRUMB,"Dashboard Breadcrumb",MEDIUMWAIT);
        safeClick(DASHBOARD_BREADCRUMB,"Dashboard Breadcrumb",MEDIUMWAIT);
        if(!driver.findElement(DASHBOARD_TITLE).getText().equalsIgnoreCase(dname2))
            Assert.fail("Title for Dashboard page is not displayed properly");
    }

    @Step("Deleting dashboard from the application ")
    public void deletingDashboard() throws InterruptedException {
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, dname2+ "\n", "dashboard name into type search");
        System.out.println("entered db text");
        mouseHoverJScript(LISTOFDASHBOARDS, "text", "mouse", MEDIUMWAIT);
        waitUntilClickable(FOLDER_DELETE, "text", 5000);
        safeClick(FOLDER_DELETE, "Remove button from folder", MEDIUMWAIT);
        waitUntilClickable(BUTTON_DELETE, "wait delete button clicked", MEDIUMWAIT);
        safeClick(BUTTON_DELETE, "Delete button", MEDIUMWAIT);
        waitForSecs(20);
        waitUntilElementDisappears(BUTTON_DELETE, "disappears", MEDIUMWAIT);
        safeClick(All_FOLDER, "All folder on dashboards section ", MEDIUMWAIT);
        waitForPageToLoad();
        mouseHoverJScript(COLUMN_FOLDER, "text", "mouse", MEDIUMWAIT);
        safeClick(BUTTON_ADDFOLDER, "Add folder", MEDIUMWAIT);
        waitUntilClickable(By.xpath("//*[text()='Dashboard']/../../../div//div[contains(@class,'body1')]"), "text", 5000);
        safeClick(TEXTBOX_CHOSE_DASHBOARD, "Select or create dashboard text box", MEDIUMWAIT);
        driver.findElement(By.xpath("//*[@id='dashboardKey']")).sendKeys(dname2, Keys.ENTER);
        waitUntilClickable(DASHBOARD_LABEL, "waiting for element", MEDIUMWAIT);
        String actualText = safeGetText(DASHBOARD_LABEL, "dashboard name", MEDIUMWAIT);
        System.out.println(actualText);
        String expectedText = "Create" + " " + "\"" + dname2 + "\"";
        Assert.assertEquals(actualText, expectedText);
        safeClick(DASHBOARD_LABEL, "Select or create dashboard text box", MEDIUMWAIT);
        safeClick(BUTTON_CANCEL, "Cancel button", MEDIUMWAIT);
    }

}
