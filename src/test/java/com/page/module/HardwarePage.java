package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.HardwareLocators;
import com.selenium.SafeActions;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class HardwarePage extends SafeActions implements HardwareLocators
{
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random= new Random();
    String Name_Add,DatabaseName_Add,InstanceName_Add,Port_Add,Server_Add,Vendor_add;
    String DbTitle = dashBoardData.ticketTitle
            +" - "+random.nextInt(500);
    public HardwarePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
