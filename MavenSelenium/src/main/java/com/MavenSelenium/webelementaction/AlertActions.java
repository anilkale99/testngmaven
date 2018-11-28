package com.MavenSelenium.webelementaction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertActions{


	/**
	 * This method can be used to accept the alert box - Press OK button in OK/Cancel type alert boxes.
	 * 
	 * @author cbhanushali
	 */
	public static void acceptAlertBox(WebDriver driver) {
		 Alert alert = driver.switchTo().alert();
         alert.accept();
	}
	
	/**
	 * This method can be used to reject the alert box - Press Cancel button in OK/Cancel type alert boxes.
	 * 
	 * @author cbhanushali
	 */
	public static void dismissAlertBox(WebDriver driver) {
		 Alert alert = driver.switchTo().alert();
         alert.dismiss();
	}
	
}