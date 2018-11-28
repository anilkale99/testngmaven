package com.MavenSelenium.webelementaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.MavenSelenium.core.BaseSolvent;

/**
 * 
 * @author akale
 *
 */
public class RadioButtonActions extends BaseSolvent{

	
	/**
	 * 
	 * @param searchBy : This method is application for ID only
	 * @param locator
	 * @param driver
	 * @author akale
	 */
	public static void selectRadioButtonYesNoByID(String searchBy,String id, WebDriver driver){
		String isRadioBtnSelected = "//span[@id='"+id+"'][@aria-checked='true']";
		WebElement webE = BaseSearchWebElement.searchElement(searchBy, isRadioBtnSelected, driver);
		if(webE==null) 
			webE.click();
		else
			System.out.println("Checkbox already selected");
	}
	
	/**
	 * 
	 * @param labelOnLeft : Label present on Left or Top of the radio button.
	 * @param status true: to select 'Yes', false: to select 'No'
	 * @param driver
	 * @author akale
	 */
	public static void selectRadioButtonYesNoByLabelOnTop(String labelOnLeft, boolean status, WebDriver driver){
		String isRadioBtnSelectedLoc1 = "//div/label[contains(text(),'"+labelOnLeft+"')]/..//span[@aria-checked='true']";
		String isRadioBtnSelectedLoc2 = "//div/label[contains(text(),'"+labelOnLeft+"')]/../../div/span[@aria-checked='true']";
		String radioBtnLoc = "//div/label[contains(text(),'"+labelOnLeft+"')]/..//span";
		WebElement webE = BaseSearchWebElement.searchElement("xpath", isRadioBtnSelectedLoc1, driver);
		if(webE==null){
			webE = BaseSearchWebElement.searchElement("xpath", isRadioBtnSelectedLoc2, driver);
			radioBtnLoc = "//div/label[contains(text(),'"+labelOnLeft+"')]/../../div/span";
		}
		if(webE==null || status==false) 
			BaseSearchWebElement.searchElement("xpath", radioBtnLoc, driver).click();
		
		else
			System.out.println("Checkbox already selected");
	}
	
	
	/**
	 * 
	 * @param searchBy : This method is application for ID only
	 * @param locator
	 * @param driver
	 * @author akale
	 */
	public static void selectRadioButtonByID(String id, WebDriver driver){
		String radioBtn = "//div//input[@id='"+id+"']/following-sibling::label";
		BaseSearchWebElement.searchElement("xpath", radioBtn, driver).click();
	}
	
	/**
	 * 
	 * @param searchBy : This will directly click on the radio button with provided locator
	 * @param locator
	 * @param driver
	 * @author akale
	 */
	public static void selectRadioButton(String searchBy,String locator, WebDriver driver){
		WebElement webE = BaseSearchWebElement.searchElement(searchBy, locator, driver);
		if(webE!=null) 
			webE.click();
		else
			System.out.println("Checkbox not Present");
	}

    public static boolean isRadioButtonPresent(String searchBy,String searchValue, WebDriver driver)	{
		
		if( BaseSearchWebElement.searchElement(searchBy, searchValue, driver) != null )
				return true;
		else
			return false;

	}
    
    
    
    public static void selectRadioButtonYesNo(String searchBy,String locator,String status, WebDriver driver)
    {
    	WebElement webE = BaseSearchWebElement.searchElement(searchBy, locator, driver);
    	String currentStatus = webE.getAttribute("aria-checked");
    	if(! currentStatus.equals(status))
    		webE.click();
    		
    }
}
