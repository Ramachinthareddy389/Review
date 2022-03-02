package com.base;


import java.io.File;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.datamanager.ConfigManager;
import com.testng.Assert;
import com.utilities.CloudNotFoundException;

//import com.java.customexceptions.CloudNotFoundException;
//import org.testng.Assert;


/**
 * This class is used to initialize RemoteDriver on cloud. The cloud instance is of Saucelabs or testingbot, depends
 * on the value set in "Cloud.type" under config.properties 
 */
public class RemoteDriver
{
//	private ConfigManager sys;
	WebDriver driver;
	private Logger log = Logger.getLogger("RemoteDriver");
//	DesiredCapabilities capabilities;
	/*public RemoteDriver()
	{
		
	}*/
	
	
	/**
	 * Gets remote driver by setting URL and capabilities - instance of remote driver of testingbot.com or saucelabs.com
	 * @return WebDriver configured on Saucelabs.com or testingbot.com 
	 */
	public WebDriver init(String os_version, String resolution, String browser,
						  String browser_version, String os)
 {
		try {
			ConfigManager sys = new ConfigManager();
			Augmenter aug = new Augmenter();

			String cloud = sys.getProperty("Cloud.Host.URL");
			if (StringUtils.isBlank(cloud))
				throw new CloudNotFoundException("Cloud.Host.URL is blank. Please check sys.properties file ");
			try{
			driver = new RemoteWebDriver(new URL(cloud),new CapabilityHelper().addCapability(os_version, resolution, browser,
					browser_version,  os));
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			}catch(Exception e){
				e.printStackTrace();
			}
			
			driver = aug.augment(driver);
			log.info("************CLOUD/GRID REMOTEDRIVER DETAILS********************");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return driver;
	}	
}
