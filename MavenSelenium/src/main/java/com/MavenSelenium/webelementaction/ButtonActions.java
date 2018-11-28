package com.MavenSelenium.webelementaction;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ButtonActions {

	public static void click(String searchBy,String searchValue, WebDriver driver)
	{
		try
		{
			BaseSearchWebElement.searchElement(searchBy, searchValue, driver).click();
		}
		catch(Exception e)
		{
			System.out.println(e.toString() + "Failed whilte executing ");
		}
	}
	
	public static boolean isButtonPresent(String searchBy, String searchValue,
			WebDriver driver) {
		if (BaseSearchWebElement.searchElement(searchBy, searchValue, driver) != null)
			return true;
		else
			return false;
	}

}
