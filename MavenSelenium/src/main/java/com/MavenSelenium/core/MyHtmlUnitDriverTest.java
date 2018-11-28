package com.MavenSelenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyHtmlUnitDriverTest {
	
	@Test
	public void myMethod() throws InterruptedException{
		
		
		WebDriver driver = new HtmlUnitDriver();
		((HtmlUnitDriver)driver).setJavascriptEnabled(true);
		driver.get("http://google.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Selenium IDE");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Selenium IDE Plugins')]")).click();
		Thread.sleep(10000);
		
		String actProjectString = driver.findElement(By.xpath("//a[@title='Selenium Projects']")).getText();
		String myExpProjectString = "Projects";
		
		boolean result = actProjectString.equals(myExpProjectString);
		
		Assert.assertTrue(result,"Project string not matching");
		
	
		driver.quit();
	}

}
