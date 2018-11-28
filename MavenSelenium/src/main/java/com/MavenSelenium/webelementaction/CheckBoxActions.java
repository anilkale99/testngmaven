package com.MavenSelenium.webelementaction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.MavenSelenium.core.BaseSolvent;




public class CheckBoxActions extends BaseSolvent{
	
	
	
	
	public static void selectCheckBoxByLabelOnRight(String labelOnRight, String trueFalse, WebDriver driver){
		String locator = "//div[@class='checkbox']/input/following-sibling::label[contains(text(),'"+labelOnRight+"')]";
		
		String alreadyChecked =  "//div[@class='checkbox'][@class='ng-valid ng-dirty ng-valid-parse ng-touched']/input/following-sibling::label[contains(text(),'"+labelOnRight+"')]";
		WebElement webE = BaseSearchWebElement.searchElement("xpath", alreadyChecked, driver);
		if(webE==null) { 
			if(trueFalse.equals("true")){
				webE.click();
			}
		}			
		else{
			System.out.println("Checkbox already selected");
		}
	}
	
	
	/**
	 * 
	 * @param searchBy : This method is application for ID only
	 * @param locator
	 * @param driver
	 * @author akale
	 */
	public static void selecCheckBoxByID(String id, boolean trueFalse, WebDriver driver){
		String checkBox = "//div[starts-with(@class,'checkbox')]/input[@id='"+id+"']/following-sibling::label";
		if(isCheckBoxSelectedByID(id, driver)){
			if(trueFalse == false ){
				BaseSearchWebElement.searchElement("xpath", checkBox, driver).click();
			}
		}else{
			if(trueFalse == true ){
				BaseSearchWebElement.searchElement("xpath", checkBox, driver).click();
			}
		}
	}
	
	
	/**
	 * 
	 * @param By : xpath, Css, .....
	 * @param locator : 
	 * @param driver
	 * @author akale
	 */
	public static void selecCheckBox(String By, String locator, WebDriver driver){
		BaseSearchWebElement.searchElement(By, locator, driver).click();
	}
	
	/**
	 * 
	 * @param By : ID
	 * @param locator : 
	 * @param driver
	 * @author akale
	 */
	
	public static boolean isCheckBoxSelectedByID(String id,WebDriver driver)	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String isSelected = js.executeScript("return document.getElementById('"+id+"').checked").toString();; 
		if(isSelected.equals("true"))
				return true;
		else
				return false;

	}
	
	/**
	 * This method confirms whether the checkBox with provided xpath is present
	 * on the screen or not
	 * 
	 * @param searchBy
	 * @param searchValue
	 * @param driver
	 * @author bgatkul1
	 * @return
	 */
	public static boolean isCheckBoxPresent(String searchBy, String searchValue,
			WebDriver driver) {
		if (BaseSearchWebElement.searchElement(searchBy, searchValue, driver) != null)
			return true;
		else
			return false;
	}

	
	
}
