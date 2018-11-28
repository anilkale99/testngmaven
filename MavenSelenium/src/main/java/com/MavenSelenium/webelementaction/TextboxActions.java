package com.MavenSelenium.webelementaction;

import org.openqa.selenium.WebDriver;

public class TextboxActions{

	public static void setValue(String searchBy,String searchValue,String setText, WebDriver driver)
	{
		try
		{
			BaseSearchWebElement.searchElement(searchBy, searchValue , driver).sendKeys(setText);
		}
		catch(Exception e)
		{
			System.out.println(e.toString() + "Failed whilte executing ");
		}
	}
	
	/**
	 * This method is useful for clear the text Box Value, It is recommended
	 * that user should call clearValue method before setting up a value in a
	 * Text Box
	 * 
	 * @param searchBy
	 * @param searchValue
	 * @param driver
	 * @author bgatkul1
	 */
	public static void clearValue(String searchBy, String searchValue,
			WebDriver driver) {
		try {
			BaseSearchWebElement.searchElement(searchBy, searchValue, driver)
					.clear();
		} catch (Exception e) {
			System.out.println(e.toString() + "Failed whilte executing ");
		}
	}
	
	public static boolean isTextBoxPresent(String searchBy,String searchValue, WebDriver driver)	{
	
			if( BaseSearchWebElement.searchElement(searchBy, searchValue, driver) != null )
					return true;
			else
				return false;

	}
	
}