/* ************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the 9 abstract methods
 and define certain useful Log statements which would be displayed/logged as the application under test
 is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, type etc).

 This would allow us not to log any additional messages which we've used in other utility classes so far.

 */

package com.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;



public class WebListener implements WebDriverEventListener
{
	private Logger log = Logger.getLogger("Weblistener");


	//Constructor
	public WebListener(){}

	public void beforeNavigateTo(String url, WebDriver driver)
	{
		log.info("Before navigating to url printing the browser associated capabilities");
	}

	public void afterNavigateTo(String url, WebDriver driver)
	{
		log.info("WebDriver has navigated to:'"+url+"'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver)
	{
		log.info("Value of the:"+ElementValue(element)+" before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver)
	{
		log.info("Value of element after change: "+ElementValue(element));
	}

	public void beforeClickOn(WebElement element, WebDriver driver)
	{
		log.info("Trying to click on: "+ElementValue(element));

	}

	public void afterClickOn(WebElement element, WebDriver driver)
	{
		//log.info("Clicked on: "+ElementValue(element));
	}

	public void beforeNavigateBack(WebDriver driver)
	{
		log.info("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver)
	{
		log.info("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver)
	{
		log.info("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver)
	{
		log.info("Navigated forward to next page");
	}


	public void onException(Throwable error, WebDriver driver)
	{
		if (error.getClass().equals(NoSuchElementException.class))
			System.out.print("...");
		else
			log.error("WebDriver error:", error);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {

	}

	/*
     * non overridden methods of WebListener class
     */
	public void beforeScript(String script, WebDriver driver){}

	public void afterScript(String script, WebDriver driver){}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver){}

	public void afterFindBy(By by, WebElement element, WebDriver driver){}


	private static String ElementValue(WebElement element)
	{
		String sValue = element.toString();
		int iStartindex = sValue.indexOf(">");
		int iEndindex = sValue.lastIndexOf("]");
		String sElementValue = sValue.substring(iStartindex+1,iEndindex);
		return sElementValue;
	}

	public void afterNavigateRefresh(WebDriver driver) {
		log.info("After refreshing the page ");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		log.info("After refreshing the page ");
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}


}

