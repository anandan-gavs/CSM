package com.csm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Object  {
	
	static Properties obj = new Properties();
	 public Object() throws IOException {
	  
	
	 }
	 
	public static WebElement getElement(WebDriver driver,String strLocatorType,String strLocatorValue){
			WebElement element=null;
			try{
				if(strLocatorType.equalsIgnoreCase("ID")){
					element=driver.findElement(By.id(strLocatorValue));
				}
				else if(strLocatorType.equalsIgnoreCase("NAME")){
					element=driver.findElement(By.name(strLocatorValue));
				}
				else if(strLocatorType.equalsIgnoreCase("XPATH")){
					element=driver.findElement(By.xpath(strLocatorValue));
				}
				else if(strLocatorType.equalsIgnoreCase("CSS")){
					element=driver.findElement(By.cssSelector(strLocatorValue));
				}
				else if(strLocatorType.equalsIgnoreCase("CLASS")){
					element=driver.findElement(By.className(strLocatorValue));
				}
				else if(strLocatorType.equalsIgnoreCase("PARTIAL_LINKTEXT")){
						element=driver.findElement(By.partialLinkText(strLocatorValue));
				}
						
				else if(strLocatorType.equalsIgnoreCase("LINKTEXT")){
							element=driver.findElement(By.linkText(strLocatorValue));
				}
			}
			catch(Exception e){}
			
			return element;
	}
	
	
	//This function returns whether Object is Visible or UnVisible- Pass the strLocatorType,strLocatorValue,driver

			public static boolean visibleUnvisible(String strLocatorType, String strLocatorValue,WebDriver driver) throws Exception{		
				boolean blResult=false;
				WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
				if(element!=null){
					if(element.isDisplayed()){
						try{
							 blResult=true;
						}
							catch(Exception e){
								e.printStackTrace();
								return false;
							}
							}
						}
				return blResult;
			}
			
			//This function whether Object is  Enabled or Disabled- Pass the strLocatorType,strLocatorValue,driver

			public static boolean enabledDisabled(String strLocatorType, String strLocatorValue,WebDriver driver) throws Exception{		
				boolean blResult=false;
				WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
				if(element!=null){
					if(element.isEnabled()){
						try{
							 blResult=true;
						}
							catch(Exception e){
								e.printStackTrace();
								return false;
							}
							}
						}
				return blResult;
			}
			
			
			public static void waitForSeconds(int inSecs,WebDriver driver){
				try{
					Thread.sleep(inSecs*1000);
				}
				catch(Exception e){
					e.printStackTrace();
					
				}
			}
			
		    public static void waitInMilliSeconds(int milliseconds) {
		        try {
		            Thread.sleep(milliseconds);
		        } catch (InterruptedException e) {
		            throw new AssertionError("InterruptedException occurred while calling Thread.sleep for " + milliseconds + " milliseconds." + e);
		        }
		    }
		    
		    public static void waitForObject(WebDriver driver,String LogicalName) {
		    	try {
		    	
		    		WebDriverWait wait = new WebDriverWait (driver, 60);
		    		
		        	String PropertyValue= obj.getProperty(LogicalName);
		        	String[] locator = PropertyValue.split(";");
		        	String locatorType = locator[0];
		        	String locatorValue = locator[1];
		        //	WebElement element = getElement(driver,locatorType,locatorValue);
		        	
		    		switch(locatorType.toUpperCase())
					{
					case "ID":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
						break;
						
					case "XPATH":
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
						break;
			
						
					case "CLASSNAME":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
						break;
			
						
					case "CSS":
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
						break;
						
					case "NAME":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
						break;
						
					case "TAGNAME":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
						break;
				
			        default:
						break;
			
					}
		    		
		    	
		    	}
		    	catch(Exception e){
					e.printStackTrace();
					
				}
		    }

		    
		    public static void buildObjectFromRepository(WebDriver driver,String LogicalName) {
		    	try {
		    		 Hashtable<String, String> hp = new Hashtable<String,String>();
		    		 FileInputStream objfile = new FileInputStream("D:\\Premier_Automation\\src\\com\\or\\ObjRepo.properties");
		    			obj.load(objfile);
		        	String PropertyValue= obj.getProperty(LogicalName);
		        	String[] locator = PropertyValue.split(";");
		        	String locatorType = locator[0];
		        	String locatorValue = locator[1];
		        	WebElement element = getElement(driver,locatorType,locatorValue);
		        	
		        	
		    		
		    	}catch(Exception e){
					e.printStackTrace();
					
				}
		    }

		    
		 
	/*public static WebElement getElement(WebDriver driver,String strLocatorType,String strLocatorValue){
		WebElement element=null;
		int inObjectWaitTime = 0;
		 
		try{
		inObjectWaitTime=Integer.parseInt(StringUtils.getKeyValue(CONFIG_FILE_PATH, "WAIT_TIME"));
		 
		WebDriverWait webDriverWait=new WebDriverWait(driver,inObjectWaitTime);
		 
		switch(strLocatorType){
		  case "ID":
		  element=webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(strLocatorValue)));
		  element=driver.findElement(By.id(strLocatorValue));
		  
		  case "NAME":
		  element=webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocatorValue)));
		  element=driver.findElement(By.name(strLocatorValue));
		  
		  case "XPATH":
		  element=webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocatorValue)));
		  element=driver.findElement(By.xpath(strLocatorValue));
		  
		  case "CSS":
		  element=webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocatorValue)));
		  element=driver.findElement(By.cssSelector(strLocatorValue));
		  
		  case "CLASS":
		  element=webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocatorValue)));
		  element=driver.findElement(By.className(strLocatorValue));
		}
		}
		catch(Exception e){
		ResultUtil.report("FAIL", "Unable to find element as waited for:"+inObjectWaitTime, driver);
		}
		 
		return element;
		}*/
		    
		    
		    public static Map<Integer,String> fetchObjParameters(String logicalName) throws IOException
		    {
		    	Map<Integer, String> objMap = new HashMap<Integer,String>();
		    	FileInputStream objfile = new FileInputStream("D:\\Premier_Automation\\src\\com\\or\\ObjRepo.properties");
			    obj.load(objfile);
				String PropertyValue= obj.getProperty(logicalName);
		    	String[] locator = PropertyValue.split(";");
		    	objMap.put(1, locator[0]);
		    	objMap.put(2, locator[1]);
		    	return objMap;
		    }
		    
}
