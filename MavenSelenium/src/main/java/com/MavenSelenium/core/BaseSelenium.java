package com.MavenSelenium.core;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.MavenSelenium.utilities.PropertiesOperation;
import com.MavenSelenium.utilities.XMLProperties;
import com.MavenSelenium.utilities.XMLUtil;






public class BaseSelenium {
	
//	File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe");
//    FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//    FirefoxProfile ffProfile = new FirefoxProfile();
//    public static  WebDriver driver;
    public static Map globalMap =  new HashMap();
    
    
    public WebDriver getDriver() throws MalformedURLException, InterruptedException{
		PropertiesOperation prop = new PropertiesOperation();
		WebDriver driver = LocalDriverFactory.createInstance(prop.getSourcingValueBykey("browser"));
		LocalDriverManager.setWebDriver(driver);
       System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver());
        driver =LocalDriverManager.getDriver();
        driver.get(prop.getSourcingValueBykey("hostURL"));
        Thread.sleep(3000);
        return driver;
	}
	
		//@BeforeClass
		public  void beforeClassSetup(ITestContext context) throws InterruptedException, MalformedURLException, SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException{
			System.out.println("I m in BaseSelenium >> beforeClassSetup");
				
			
//				String className = context.getCurrentXmlTest().getClasses().get(0).toString();
//				className = className.substring(16);
//				className =className.replaceAll("]", "");
				String className = (String) context.getAttribute("className");
				int i;
				Class<?> noparams[] = {};
				 
				//String parameter
				Class[] paramString = new Class[1];	
				paramString[0] = String.class;
				Class<?> cls = Class.forName(className);
				Object obj = cls.newInstance();
				Method method = cls.getDeclaredMethod("getFile");
				Object value = method.invoke(obj);
				String fileLoc= value.toString();
				context.setAttribute("fileLocation", fileLoc);
						
				
				
//				System.out.println("Executing Suite : "+);
				String key      = context.getName();
				Object myClass = context.getClass();
				
			
				context.getAllTestMethods();
				
				//String currMethodName = ngMethod.getMethodName();
				
				
				
				String fileName = context.getSuite().getXmlSuite().getFileName();
				String url = getURL();
				String browser = getBrowser();
				
//				 WebDriver driver = LocalDriverFactory.createInstance("browserName");
//		         LocalDriverManager.setWebDriver(driver);
//				
//				if(browser.equals("firefox")){
//					//driver = new FirefoxDriver(ffBinary, ffProfile);
//					
//					DesiredCapabilities capabillities = DesiredCapabilities.firefox();  
//			        //capabillities.setCapability("version", "17");  
//			        capabillities.setCapability("platform", Platform.WINDOWS); 
//			    	
//					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabillities);
//					driver.manage().window().maximize();
//			        System.out.println("***Execute testGetTitle()");
//			        driver.get(url);
//			        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//				}else if(browser.equals("chrome"))  {
//					//System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\SeleniumFramework\\lib\\chromedriver.exe");
//					System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
//					driver = new ChromeDriver();
//					driver.get(url);
//				}

			
		}
		
		
		/**
	  	 * Default implementation of a dataprovidor, which provided the dataset
	  	 * key value pairs from the test XML as a map 
	  	 * @param context the testNG test context of the execution
	  	 * @return
		 * @throws Exception 
	  	 */
		//@DataProvider(name = "datatest")
		public Object[][] myDataProvider(ITestContext context, ITestNGMethod ngMethod) throws Exception {
			//List datasets = XmlDataMapper.getData(context);
			//List datasets = this.getTestData(context);
			System.out.println(context.getClass().getName());
			//List datasets = this.getMethodData(context);
			String myClassName = context.getClass().getName();
			String currMethodName = ngMethod.getMethodName();
			String fileLoc= (String) context.getAttribute("fileLocation");
			context.setAttribute("currentMethodName", currMethodName);
			Map datasets = this.getMethodData(context);
			Object[][] o = new Object[1][1];
			o[0][0] = datasets;
			
//			if(datasets.size()==0){
//				Object[][] o = new Object[1][1];
//				o[0][0]=new HashMap();
//				return  o;			
//			}
//			Object[][] o =  new Object[datasets.size()][1];
//			for (int i = 0; i < datasets.size(); i++) {
//				o[i][0]=(Map) datasets.get(i);
//			}
			return o;
		}
		
		
		/**
		 * 			
		 * @param attrs
		 * @param attrName
		 * @return
		 */
		public  Map getMethodData(ITestContext context) throws Exception{
			Map testDataMap = new HashMap();
			String s = context.getCurrentXmlTest().getName();
			//String key      = context.getName();
			String key =(String) context.getAttribute("currentMethodName");
			System.out.println("Executing Test case : "+key);
			String fileNameSuite = context.getSuite().getXmlSuite().getFileName();
			String fileName =  (String) context.getAttribute("fileLocation");
			Node suiteRoot = getRootNode(new File(fileName));
			
			
			List     testNodes = XMLUtil.getListOfNodes(suiteRoot, "//suite/test");
			Iterator testIter  = testNodes.iterator();

			while (testIter.hasNext()) {
				Node   testNode = (Node) testIter.next();
				String testName = getAttributeValue(testNode.getAttributes(), "name");
				System.out.println(testName);
				
				if(testName.equals(key)){
					Node datasetNode = XMLUtil.getStrictChildNode(testNode, "dataset");
//					Node    dataNode = XMLUtil.getStrictChildNode(datasetNode, "data");
//					String keyParam = getAttributeValue(dataNode.getAttributes(), "key");
//					System.out.println(keyParam);
//					String value = getAttributeValue(dataNode.getAttributes(), "value");
//					System.out.println(keyParam);
//					testDataMap.put(keyParam, value);
					
					List   dataNode = XMLUtil.getStrictChildNodes(datasetNode, "data");
					
					for (Iterator iterator = dataNode.iterator(); iterator
							.hasNext();) {
						Node object = (Node) iterator.next();
						String keyParam = getAttributeValue(object.getAttributes(), "key");
						String value = null ;
						String refValue=null;
						String refGlobalValue=null;
						NamedNodeMap att = object.getAttributes();
						Node refNode = att.getNamedItem("ref");
						
						if(refNode!=null){
							refValue =getAttributeValue(object.getAttributes(), "ref");
							refGlobalValue =(String) globalMap.get(refValue);
							value = refGlobalValue;
							
						}else {
							value = getAttributeValue(object.getAttributes(), "value");
						}
						
						testDataMap.put(keyParam, value);
						
					}
				
				}
			}
			
			if(globalMap != null){
				if(!globalMap.isEmpty()){
					testDataMap.putAll(globalMap);
				}
			}
			
				
			
			return  testDataMap;
			
		}
		
	
//		public static final String PROJ_DIR() 
//		{
//			 
//			Path path = null;
//			try {
//				path = Paths.get(Constants.class.getResource(".").toURI());
//			} catch (URISyntaxException e) {
//				//Log.error("Malformed URI", e);
//			}
//			return path.getParent().getParent().getParent().toString();
//		} 
		
		
		
		
//		/**
//		 * 			
//		 * @param attrs
//		 * @param attrName
//		 * @return
//		 */
//		public static List getTestData(ITestContext context) throws Exception{
//			
//			String s = context.getCurrentXmlTest().getName();
//			String key      = context.getName();
//			String fileName = context.getSuite().getXmlSuite().getFileName();
//			
//			Node suiteRoot = getRootNode(new File(fileName));
//			
//			List     testNodes = XMLUtil.getListOfNodes(suiteRoot, "//suite/test");
//			Iterator testIter  = testNodes.iterator();
//
//			while (testIter.hasNext()) {
//				Node   testNode = (Node) testIter.next();
//				String testName = getAttributeValue(testNode.getAttributes(), "name");
//				
//
////
////				HashMap includedTest = null;
////				boolean overwrite    = false;
////
////				if ((includedTestMap != null) && (includedTestMap.get(testName) != null)) {
////					includedTest = (HashMap) includedTestMap.get(testName);
////
////					if (includedTestMap.containsKey(testName + "===inheritdatafromParent===")) {
////						overwrite = true;
////					}
////				}
////
//				List    datasetNodes   = XMLUtil.getStrictChildNodes(testNode, "dataset");
//				boolean hasDatasetNode = !datasetNodes.isEmpty()
//				? true
//						: false;
//				HashMap dataSets       = new HashMap();
//
//				List     dataSetList = new ArrayList();
////
////				if (hasDatasetNode &&!overwrite) {
//////
////					;					List    dataSetsOrderedList = new ArrayList();
////					fillDataSet(datasetNodes, includedTest, testName, dataSets, dataSetsOrderedList);
////
////					for(int k=0;k<dataSetsOrderedList.size();k++){
////						dataSetList.add(dataSets.get(dataSetsOrderedList.get(k)));
////					}
////
////				} else if (overwrite) {
////					dataSets = includedTest;
////
////					Iterator itDataset   = dataSets.values().iterator();
////					while (itDataset.hasNext()) {
////						dataSetList.add(itDataset.next());
////					}
////
////				}
//
//			
//			List data = new ArrayList();
//			
//			
//			
//			return data;
//			}
//			return testNodes;
//		}
//			
		/**
		 * 			
		 * @param attrs
		 * @param attrName
		 * @return
		 */
			public static String getAttributeValue(NamedNodeMap attrs, String attrName) {
				String attrValue = null;
				Node   nodeAttr  = attrs.getNamedItem(attrName);

				if (nodeAttr != null) {
					attrValue = nodeAttr.getNodeValue();
				}

				return attrValue;
			}
			
			/**
			 * 			
			 * @param attrs
			 * @param attrName
			 * @return
			 */
		public static Node getRootNode(File xmlFile) throws Exception {
			Node                   node    = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder        builder;
			Document               doc;
			Node tcNode;

			try {
				builder = factory.newDocumentBuilder();
				doc     = builder.parse(xmlFile);
				
				doc.getDocumentElement().normalize();
				System.out.println("Root element  : " + doc.getDocumentElement().getNodeName());
//				tcNode = doc.getParentNode();
//				String s = tcNode.getNodeName();
				
				
				
				XMLProperties props = new XMLProperties(doc.getDocumentElement());

				node = props.getRootPropertyNode();
			} catch (Exception e) {
				Reporter.log("Failed to get root node for " + xmlFile + " due to " + e);
			}

			return node;
		}
		
		
		
		//@AfterClass
		public  void myTearDown(WebDriver driver) throws InterruptedException{
				driver.close();
				driver.quit();
		        System.out.println("Tear Down successfull successfull");
		}
		
		private String getURL(){
			PropertiesOperation props = new PropertiesOperation();
			return props.getSourcingValueBykey("hostURL");
			
		}
		
		private String getBrowser(){
			PropertiesOperation props = new PropertiesOperation();
			return props.getSourcingValueBykey("browser");
			
		}
		
		public void shareToGlobal(String key, String value){
			globalMap.put(key, value);
			System.out.println("key-"+key + "   value-"+value);
		}
		
	

}
