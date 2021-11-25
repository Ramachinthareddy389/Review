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

public class SQLTests extends BaseSetup {
    private EmailPage emailPage;
    private PortletsFeature portletsFeature;
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private SQLPage sqlPage;
    private  DashboardOverviewPage dashboardOverviewPage;
    private  ComponentPage componentPage;
    private String sModeOfExecution;
    Random random = new Random();
    String dname = "Pivots";
    String dname1 = dname + random.nextInt(1500);

    String SQL = "Sqltest"+ random.nextInt(1500);;
    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        emailPage = new EmailPage(getDriver());
        dashboardOverviewPage =new DashboardOverviewPage(getDriver());
        sqlPage = new SQLPage(getDriver());
        componentPage= new ComponentPage(getDriver());
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
    public void TC_276_AddSQLConfigwithDatamartQuery() throws InterruptedException
    {
          sqlPage.clickingOnAutomation();
          sqlPage.addingNewSqlRecord(SQL,"DistributionList","SELECT NAME, TIMESTAMP, USER_NAME, PATH FROM UX_SESSION WHERE TIMESTAMP > ? AND TIMESTAMP < ?","User login report 1","Today");
          sqlPage.verifyingaddedSQLConfigs(SQL);
          sqlPage.deletingSQLConfig();
          getDriver().get(dashBoardData.yopmail);
          emailPage.navigatingToYopMail("zenqtest75@yopmail.com","Germain Report - User Login Report - Germain Software - QA");
          emailPage.verifyingDataforSqlTests(SQL);
          //sqlPage.verifyingDataInEmail("Daily User Login Report");


    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_278_AddSQLConfigwithMultiplequeries(){
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"SQLList","select name, value from GENERIC_METRIC order by id desc limit 10","Multi-Query Report eBay","None");
        sqlPage.verifyingaddedSQLConfigs(SQL);
        sqlPage.addingQueryFromSQLEditWindow("select name from GENERIC_EVENT order by id desc limit 10");
        sqlPage.deletingSQLConfig();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zenqtest75@yopmail.com","Doesn't Matter");
        sqlPage.verifyingDataInEmail("Multi-Query-Report");
    }

/*
   @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_281_VerifyNotificationonSuccessNdFailureinEditSQLwindow(){
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"germain-admin","select name, value from GENERIC_METRIC order by id desc limit 10","User login report 1","None");
        sqlPage.verifyingOnSuccessNdFailure(SQL);
        sqlPage.deletingSQLConfig();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zenqtest75@yopmail.com", "Germain Alert - Internal issue - Notification for 'AlertsTest'");

    }
*/

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_282_VerifyLoggingEnabledinEditSQLwindow() throws InterruptedException {
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"germain-admin","select name, value from GENERIC_METRIC order by id desc limit 10","User login report 1","None");
        dashboardOverviewPage.verifyDashBoardOverviewPage(dashBoardData.dashboard, dashBoardData.allpages);
        dashboardOverviewPage.addingNewDashboard();
        dashboardOverviewPage.enterAddrequirefeildsInDashBoardPage();
        dashboardOverviewPage.searchingDashboard();
        sqlPage.addingGermainAPmActionLog("Germain APM Action Log");
        sqlPage.verifyingInDrillThroughPage(SQL);

    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_284_VerifyAttachResultinEditSQLwindow(){
        componentPage.addingEmailFromDistriist("DistributionList","testauto056@gmail.com");
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"DistributionList","SELECT NAME, TIMESTAMP, USER_NAME, PATH FROM UX_SESSION WHERE TIMESTAMP > ? AND TIMESTAMP < ?","User login report 1","Today");
        sqlPage.verifyingaddedSQLConfigs(SQL);
        //sqlPage.deletingSQLConfig();
        componentPage.deleteDistributionList("DistributionList");
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zenqtest75@yopmail.com","Germain Report - User Login Report - Germain Software - QA");
        emailPage.verifyingDataforSqlTests(SQL);
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_283_VerifyRunonScheduleinEditSQLwindow(){
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"DistributionList","SELECT NAME, TIMESTAMP, USER_NAME, PATH FROM UX_SESSION WHERE TIMESTAMP > ? AND TIMESTAMP < ?","User login report 1","Today");
        sqlPage.verifyingaddedSQLConfigs(SQL);
        sqlPage.deletingSQLConfig();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zenqtest75@yopmail.com","Germain Report - User Login Report - Germain Software - QA");
        emailPage.verifyingDataonRunschedule("zenqtest75@yopmail.com","Germain Report - User Login Report - Germain Software - QA");
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_277_AddSQLconfigwithNonDatamartQuery() {
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"DistributionList","select count(*) from SIEBEL.S_USER where CREATED >= ? and CREATED < ?","User login report 1","Today");
        sqlPage.verifyingNonDataMartQueryConfigs(SQL);
        sqlPage.deletingSQLConfig();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_286_VerifyExecutionCountIntervalinEditSQLwindow()
    {
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord(SQL,"DistributionList","SELECT NAME, TIMESTAMP, USER_NAME, PATH FROM UX_SESSION WHERE TIMESTAMP > ? AND TIMESTAMP < ?","User login report 1","Today");
        sqlPage.verifyingaddedSQLConfigs(SQL);
        sqlPage.verifyingExecutionCountInSQl();
        sqlPage.deletingSQLConfig();
        getDriver().get(dashBoardData.yopmail);
        emailPage.navigatingToYopMail("zenqtest75@yopmail.com","Germain Report - User Login Report - Germain Software - QA");
        emailPage.verifyingDataforSqlTests(SQL);

    }

}
