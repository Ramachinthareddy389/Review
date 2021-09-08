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
    private String sModeOfExecution;
    Random random = new Random();
    String dname = "Pivots";
    String dname1 = dname + random.nextInt(1500);


    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        portletsFeature = new PortletsFeature(getDriver());
        emailPage = new EmailPage(getDriver());
        sqlPage = new SQLPage(getDriver());
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
          sqlPage.addingNewSqlRecord("SELECT NAME, TIMESTAMP, USER_NAME, PATH FROM UX_SESSION WHERE TIMESTAMP > ? AND TIMESTAMP < ?","User login report 1","Today");
          sqlPage.verifyingaddedSQLConfigs();
          sqlPage.deletingSQLConfig();
          getDriver().get(dashBoardData.yopemail);
          emailPage.navigatingToEmail("apmsqlzenq@yopmail.com","Germain Report - User Login Report - Germain Software - QA");
          sqlPage.verifyingDataInEmail("Daily User Login Repor");


    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_278_AddSQLConfigwithMultiplequeries(){
        sqlPage.clickingOnAutomation();
        sqlPage.addingNewSqlRecord("select name, value from GENERIC_METRIC order by id desc limit 10","Multi-Query Report eBay","None");
        sqlPage.verifyingaddedSQLConfigs();
        sqlPage.addingQueryFromSQLEditWindow("select name from GENERIC_EVENT order by id desc limit 10");
        sqlPage.deletingSQLConfig();
        getDriver().get(dashBoardData.yopemail);
        emailPage.navigatingToEmail("apmsqlzenq@yopmail.com","Doesn't Matter");
        sqlPage.verifyingDataInEmail("Multi-Query-Report");
    }

}
