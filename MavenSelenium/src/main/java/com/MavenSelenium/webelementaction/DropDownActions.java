package com.MavenSelenium.webelementaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.MavenSelenium.core.BaseSolvent;

public class DropDownActions extends BaseSolvent{

	
	public static void selectByVisibleText(String searchBy,String searchValue,String setText, WebDriver driver)
	{
		try{
			Select dropDown = new Select(BaseSearchWebElement.searchElement(searchBy, searchValue, driver));
			dropDown.selectByVisibleText(setText);
		}
		catch(Exception e){
			System.out.println(e.toString() + "Failed whilte executing ");
		}
	}
	
	
	/**
	 * This method will enter the option value in text field and click on the desired search result option.
	 * @param labelOnTop : Label present on the top of the dropdown
	 * @param optionValue : Value to be selected
	 * @param driver
	 * @author akale
	 * @throws InterruptedException 
	 */
	public static void selectDropDownValueByLabelOnTop(String labelOnTop, String optionValue, WebDriver driver) throws InterruptedException{
		String BaseLocator = "//div/label[contains(text(),'"+labelOnTop+"')]/../div";
		String inputLocator = BaseLocator+"//input";
		String optionLocator = BaseLocator+"/div//ul/li/a[contains(text(),'"+optionValue+"')]";
		BaseSearchWebElement.searchElement("xpath",inputLocator , driver).clear();
		BaseSearchWebElement.searchElement("xpath",inputLocator , driver).sendKeys(optionValue);
		WebElement ele = BaseSearchWebElement.searchElement("xpath",optionLocator , driver);
		Thread.sleep(3000);
		ele.click();
		
	}
	
	/**
	 * 
	 * @param searchBy
	 * @param searchValue
	 * @param driver
	 * @return
	 */
	public static boolean isDropDownPresent(String searchBy,String searchValue, WebDriver driver)	{
		
		if( BaseSearchWebElement.searchElement(searchBy, searchValue, driver) != null )
				return true;
		else
			return false;

	}
	
}
