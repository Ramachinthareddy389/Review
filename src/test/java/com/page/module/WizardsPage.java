package com.page.module;

import com.datamanager.ConfigManager;
import com.page.data.DashBoardData;
import com.page.locators.WizardsLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.WebDriver;


public class WizardsPage extends SafeActions implements WizardsLocators {

    private WebDriver driver;
    private DashBoardData dashBoardData=new DashBoardData();


    //Constructor to define/call methods
    public WizardsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
