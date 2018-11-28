package com.MavenSelenium.testmodules.amazon;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MavenSelenium.core.BaseSelenium;
import com.MavenSelenium.product.google.GoogleHome;

public class GoogleScenario1 extends BaseSelenium {
	
	public WebDriver driver; 
	String dataFileName = "src/test/java/com/MavenSelenium/testdata/google/GoogleScenario1.xml";

	Map myTestClassMap= new HashMap();
	
	
	@Test(dataProvider="datatest")
	public void runMethod(Map map){
//		GoogleHome GH = new GoogleHome();
//		
//		Map loginDataMap = getTestData(dataFileName, "login");
//		
//		auth.login(loginDataMap, driver);
//		
//		GH.searchStringInGoogle();
//		GH.searchResultInGoogle();
		
	}

	
	@BeforeClass
	public void  mySetup() throws MalformedURLException, SecurityException, IllegalArgumentException, InterruptedException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException{
		driver = getDriver();
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException{
		super.myTearDown(driver);
	}
	
	public void updateClassMap(Map map){
		if(map!=null){
			myTestClassMap.putAll(map);
		}
	}
	
	/**
  	 * Default implementation of a dataprovidor, which provided the dataset
  	 * key value pairs from the test XML as a map 
  	 * @param context the testNG test context of the execution
  	 * @return
	 * @throws Exception 
  	 */
	@DataProvider(name = "datatest1")
	public Object[][] thisDataProvider(ITestContext context, ITestNGMethod ngMethod) throws Exception {
		System.out.println("I am in MyTestScenario1 >>thisDataProvider ");
		BaseSelenium base = new BaseSelenium();
		String className= this.getClass().getName();
		context.setAttribute("className", className);
		context.setAttribute("fileLocation", dataFileName);
		return base.myDataProvider(context, ngMethod);
	}
}
