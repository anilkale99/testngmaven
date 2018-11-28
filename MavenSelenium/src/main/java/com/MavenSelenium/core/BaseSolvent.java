package com.MavenSelenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MavenSelenium.utilities.PropertiesOperation;
import com.MavenSelenium.webelementaction.BaseSearchWebElement;


/**
 * 
 * @author akale
 *
 */
public class BaseSolvent {
	
	public static int globalWaitForElement;
	
	public BaseSolvent(){
		PropertiesOperation props = new PropertiesOperation();
		String wait1 =props.getSourcingValueBykey("globalWaitForElement");
		globalWaitForElement = Integer.parseInt(wait1);
		
	}
	
	
	/**
	 * Wait for page to load
	 * @param driver
	 */
	public void waitForPagetoLoad(WebDriver driver) {
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			String readyState = js.executeScript("return document.readyState").toString();; 
			while(!readyState.equalsIgnoreCase("complete"))
			{
				System.out.println("ReadyState = "+readyState);
				Thread.sleep(1000);
				readyState = js.executeScript("return document.readyState").toString();
			}
		} catch (InterruptedException e) {
			System.out.println("Logs "+e.toString());
		}
	} 
	
	/**
	 * 
	 * @param by
	 * @param driver
	 */
	public void waitForElementToPresent(By by, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, globalWaitForElement);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param searchBy
	 * @param locator
	 * @param fileLocation location of the file e.g. "C:\\test1.txt"
	 * @param driver
	 * @author akale
	 * @throws InterruptedException 
	 */
	public void addAttachment(String searchBy, String locator, String fileLocation, WebDriver driver) throws InterruptedException{
		WebElement upload = BaseSearchWebElement.searchElement(searchBy, locator, driver);
		upload.sendKeys(fileLocation);
		Thread.sleep(2000);
		
	}

}
