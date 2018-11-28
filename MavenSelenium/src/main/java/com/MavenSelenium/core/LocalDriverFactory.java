package com.MavenSelenium.core;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.MavenSelenium.utilities.PropertiesOperation;
import com.sun.jna.Platform;

/**
 * 
 * @author akale
 *
 */
public class LocalDriverFactory {
	
	public static WebDriver createInstance(String browserName) throws MalformedURLException {
        WebDriver driver = null;
        PropertiesOperation props= new PropertiesOperation();
        String firefoxEXEpath =props.getSourcingValueBykey("firefoxEXEpath");
        
        if (browserName.toLowerCase().contains("firefox")) {
        	File pathToBinary = new File(firefoxEXEpath);
//        	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//        	FirefoxProfile ffProfile = new FirefoxProfile();	
//        	driver = new FirefoxDriver(ffBinary, ffProfile);
        	
//        	DesiredCapabilities capabillities = DesiredCapabilities.firefox();
//        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabillities);
//            return driver;
        }
//        if (browserName.toLowerCase().contains("internet")) {
//            driver = new InternetExplorerDriver();
//            return driver;
//        }
        if (browserName.toLowerCase().contains("chrome")) {
//        		DesiredCapabilities capabillities = DesiredCapabilities.chrome();
//	        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabillities);
//	            return driver;
	            
        		DesiredCapabilities capabillities = DesiredCapabilities.chrome();  
	            capabillities.setCapability("version", "46");  
	            capabillities.setCapability("platform", Platform.WINDOWS); 
	            System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
	            driver = new ChromeDriver();
        }
        
//       DesiredCapabilities capabillities = DesiredCapabilities.chrome();  
//        capabillities.setCapability("version", 17);  
//        capabillities.setCapability("platform", Platform.WINDOWS); 
//    	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabillities);
       
//        DesiredCapabilities capabillities = DesiredCapabilities.chrome();  
//       capabillities.setCapability("version", "46");  
//        capabillities.setCapability("platform", Platform.WINDOWS); 
//        System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
//		driver = new RemoteWebDriver(new URL("http://9.109.110.195:4444/wd/hub"), capabillities);
        
		//driver = new ChromeDriver();
        return driver;
        
    }

}
