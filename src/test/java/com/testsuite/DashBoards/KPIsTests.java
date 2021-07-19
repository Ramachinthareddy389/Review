package com.testsuite.DashBoards;

import com.base.BaseSetup;
import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.module.DashboardOverviewPage;
import com.page.module.KPIsPage;
import com.page.module.LoginPage;
import com.page.module.PortletsFeature;
import com.selenium.Sync;
import jvm.PasswordDecoder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class KPIsTests extends BaseSetup {
    private DashBoardData dashBoardData;
    private LoginPage loginPage;
    private KPIsPage kpIsPage;

    private String sModeOfExecution;

    @BeforeMethod(alwaysRun = true)
    public void baseClassSetUp() {
        ConfigManager sys;
        sys = new ConfigManager();
        loginPage = new LoginPage(getDriver());
        kpIsPage = new KPIsPage(getDriver());
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
    public void TC199_AddKPIconfigurationwithallSLATypes() throws InterruptedException
    {
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction();
        kpIsPage.verifyingKPIsPage();
    }

    @Test(alwaysRun = true, groups = "Smoke Test")
    public void TC_200_EditKPIconfiguration()
    {
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction();
        kpIsPage.editKPISConfig();
        kpIsPage.verifyingEditedKPISDetails();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public  void TC_201_AddSLAsinEditKPIconfigwindow(){
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction();
        kpIsPage.addingSLASInEditConfigWindow();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction();
        kpIsPage.verifyingAddedSLASInEditConfigWindow();
    }


    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_202_AddThresholdinFactBasedSLAeditwindowinKPIpage(){
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction();
        kpIsPage.addingThresholdValueInEditKPIswindow();
        kpIsPage.verifyingAddedThresholdInEditWindow();
    }

    @Test(alwaysRun = true,groups = "Smoke Test")
    public void TC_203_NavigatetoDrillthroughpagefromKPIeditconfigwindow(){
        kpIsPage.clickingOnCorrelation();
        kpIsPage.addingKPIPage();
        kpIsPage.addingSLASettingsPage();
        kpIsPage.addingSLAAction();
        kpIsPage.navigateToDrillThrghPageFrmKpiEditWindow();
    }
}
