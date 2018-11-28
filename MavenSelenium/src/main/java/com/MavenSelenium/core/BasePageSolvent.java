package com.MavenSelenium.core;

import org.openqa.selenium.WebDriver;

import com.MavenSelenium.webelementaction.ButtonActions;



/**
 * 
 * @author akale
 * 
 */
public class BasePageSolvent extends BaseSolvent {
	/**
	 * To Click the Save button . This method is common for Save button on
	 * Create 1) Section 2) Question 3) Item Field 4) Bid Form
	 * 
	 * @param driver
	 * @author bgatkul1
	 */
	public void clickSaveButton(WebDriver driver) throws InterruptedException {
		String buttonLocator = ".//*[@class='card-footer']/div[//@class='btn-toolbar pull-right']/div/button[contains(text(),'Save')]";
		ButtonActions.click("xpath", buttonLocator, driver);
		Thread.sleep(5000);

	}

	/**
	 * To Click the Cancel button. This method is common for Save button on
	 * Create 1) Section 2) Question 3) Item Field 4) Bid Form
	 * 
	 * @param driver
	 * @author bgatkul1
	 */
	public void clickCancelButton(WebDriver driver) throws InterruptedException {
		String buttonLocator = ".//*[@class='card-footer']/div[//@class='btn-toolbar pull-right']/div/button[contains(text(),'Cancel')]";
		ButtonActions.click("xpath", buttonLocator, driver);
		Thread.sleep(5000);

	}

}
