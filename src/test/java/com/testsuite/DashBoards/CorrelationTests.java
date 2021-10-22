package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.BusinessProcessPage;
import com.page.module.CorrelationPage;
import com.page.module.DashboardOverviewPage;
import com.page.module.LoginPage;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CorrelationTests extends BaseSetup {
    private DashboardOverviewPage dashboardOverviewPage;
    private CorrelationPage correlationPage;
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
        correlationPage = new CorrelationPage(getDriver());
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
    public void TC_172_AddCorrelationScenarioconfig() throws InterruptedException {
        correlationPage.clickingOnCorrelation();
        correlationPage.addingNewCorrelation();
        correlationPage.verifyingCorrelationDetails();
    }

/*
    @Test(alwaysRun = true)
    public void TC_173_EditCorrelationScenarioconfig() throws InterruptedException {
        correlationPage.clickingOnCorrelation();
        correlationPage.addingNewCorrelation();
        correlationPage.editCorrelationConfig();
        correlationPage.verifyingEditedCorrelationDetails();
    }
*/

    @Test(alwaysRun = true,retryAnalyzer = com.testng.Retry.class)
    public void TC_175_AddTypesinEditCorrelationScenariowindow() {
        correlationPage.clickingOnCorrelation();
        correlationPage.addingNewCorrelation();
        correlationPage.verifyingTypesInCorrelationScenarioWindow();
    }

    @Test(alwaysRun = true,retryAnalyzer = com.testng.Retry.class)
    public void TC_176_AddFactTypeinEditCorrelationScenariowindow() {
        correlationPage.clickingOnCorrelation();
        correlationPage.addingNewCorrelation();
        correlationPage.validatingEditTypeinEditCorrelationScenariowindow();
    }

    @Test(alwaysRun = true)
    public void TC_177_AddStreamCorrelationScenarioconfig() {
        correlationPage.clickingOnCorrelation();
        correlationPage.AddingCorrrlationStreamPage();
        correlationPage.AddingLeftStreamPage();
        correlationPage.AddingRightStreamPage();
        correlationPage.AddingStreamFunction();
        correlationPage.verifyingAddedStreamCorrelationScenarios();
    }

/*    @Test(alwaysRun = true)
    public void TC_178_EditStreamCorrelationScenarioconfig(){
        correlationPage.clickingOnCorrelation();
        correlationPage.AddingCorrrlationStreamPage();
        correlationPage.AddingLeftStreamPage();
        correlationPage.AddingRightStreamPage();
        correlationPage.AddingStreamFunction();
        correlationPage.EditStreamCorrelationScenarios();
        correlationPage.EditLeftStreamFeildsWithNewValues();
        correlationPage.EditRightStreamFeildsWithNewValues();
        correlationPage.verifyingEditedStreamCorrelationValues();

    }*/


    @Test(alwaysRun = true,retryAnalyzer = com.testng.Retry.class)
    public void TC_174_NavigateToCorrelationDocumentPage() {

        correlationPage.clickingOnCorrelation();
        correlationPage.addingNewCorrelation();
        correlationPage.navigatingToCorrelationDocumentPage();
    }

    @Test(alwaysRun = true)
    public void TC_179_NavigateToStreamCorrelationDocumentPage() {
        correlationPage.clickingOnCorrelation();
        correlationPage.AddingCorrrlationStreamPage();
        correlationPage.AddingLeftStreamPage();
        correlationPage.AddingRightStreamPage();
        correlationPage.AddingStreamFunction();
        correlationPage.navigateToStreamCoorelationDoc();
    }

    @Test(alwaysRun = true)
    public void TC_180_NavigatetoKPIsPageByClickingonKpiUnderKPISColumn(){
        correlationPage.clickingOnCorrelation();
        correlationPage.addingNewCorrelation();
        correlationPage.navigateToKpiPageByClickingOnKPIS();
    }


}
