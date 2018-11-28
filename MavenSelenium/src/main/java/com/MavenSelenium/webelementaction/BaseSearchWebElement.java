package com.MavenSelenium.webelementaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.MavenSelenium.core.BaseSolvent;



public class BaseSearchWebElement extends BaseSolvent{
	public static WebElement searchElement(String searchBy,String locator, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, globalWaitForElement);
		WebElement webElement;
		
		try
		{
		if(searchBy.equals("id"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		else if(searchBy.equals("tagname"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
		else if(searchBy.equals("name"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		else if(searchBy.equals("linktext"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		else if(searchBy.equals("partiallinktext"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
		else if(searchBy.equals("classname"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		else if(searchBy.equals("css"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		else if(searchBy.equals("xpath"))
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		else 
			return null;
		
		return webElement;
		
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			Reporter.log(e.toString());
			return null;
		}
	}
}
