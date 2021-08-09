package com.page.module;

import com.page.locators.AlertTemplateLocators;
import com.page.locators.AuthenticationLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class AuthenticationPage extends SafeActions implements AuthenticationLocators {
    private WebDriver driver;
    String expectedText = "Create" + " May2021129" + "";
    static int j;
    String Name_Add, KPIS_add, KeyExp_add, StepName_Add, SLA_Add, EditKey_Exp_add, Edited_KPIS_add, Edited_Name_Add;
    Random random = new Random();
    String dname = "BP";
    String dname1 = dname + random.nextInt(1500);
    String editBP = "BPEDIT";
    String editBP1 = editBP + random.nextInt(1500);
    String Bpstep = "Bp" + random.nextInt(1500);

    //Constructor to define/call methods
    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickingOnAuthentication() {
        safeClick(BTN_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_AUTH_SETTINGS, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(BTN_AUTHENTICTION, "Datasources label from left side pane", MEDIUMWAIT);

    }

    public void addingNewBusinessProcess() {
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        waitForSecs(30);
        safeClick(BTN_JDBC_RADIO, "Name Feild", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        safeClick(LABEL_PROVIDER_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_PROVIDER_NAME, dname1, "Name into textbox", MEDIUMWAIT);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);

    }
}