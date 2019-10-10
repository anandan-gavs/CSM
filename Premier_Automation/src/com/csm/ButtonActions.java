package com.csm;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonActions extends Browser {
	
	static Properties obj = new Properties();
		
	
	//static Properties obj = new Properties();
	 public ButtonActions() throws IOException {
	  
		
			
	 }
	 
	// Clicks on the button based on the strLocatorType and strLocatorValue passed
	public static void buttonClick(WebDriver driver,String LogicalName) 
	{
		
		try
		{
		boolean blResult=false;
		
		Map<Integer, String> objMap = Object.fetchObjParameters(LogicalName);
		
//		 FileInputStream objfile = new FileInputStream("D:\\Premier_Automation\\src\\com\\or\\ObjRepo.properties");
//	     obj.load(objfile);
//		String PropertyValue= obj.getProperty(LogicalName);
//    	String[] locator = PropertyValue.split(";");
		String strLocatorType = objMap.get(1);  
		String  strLocatorValue = objMap.get(2);
		
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		if(element!=null)
		{
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					try
					{
						element.click();
						//blResult=true;
						//ResultUtil.report("PASS", "Clicked button <<" + strLogicalName + ">>","", "", driver);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
						//ResultUtil.report("FAIL", "Unable to click <<" + strLogicalName + ">> button Exception occurred:" + e.getMessage(),"", "", driver);
					}
					
				}
		}
			//return blResult;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//return false;
		}
	}
	
	// Returns whether the button isEnabled or Disabled based on the strLocatorType and strLocatorValue passed
	public static boolean isEnabled(WebElement element, String strLogicalName,WebDriver driver) throws Exception{
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						blResult=true;
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			}
		return blResult;
	 }
	//This is to check whether button is visible and then click on the button 
    public static boolean visibleClick(String strLogicalName,String strLocatorType,String strLocatorValue,WebDriver driver) {
        boolean blResult=false;
        WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
        if(element!=null){
            if(element.isDisplayed()){
                if(element.isEnabled()){
                    try{
                        element.click();
                        blResult=true;
                        
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                }
        }
                
        return blResult;
    }

		
	// Clicks on the button based on the strLocatorType and strLocatorValue passed using Javascript executor
		public static boolean buttonClickJS(WebDriver driver,String strLogicalName) 
		{
			
			try
			{
			boolean blResult=false;
			Map<Integer, String> objMap = Object.fetchObjParameters(strLogicalName);
			String strLocatorType = objMap.get(1);  
			String  strLocatorValue = objMap.get(2);
			WebElement element =  Object.getElement(driver, strLocatorType, strLocatorValue);
			if(element!=null)
			{
				if(element.isDisplayed())
				{
					if(element.isEnabled())
					{
						try
						{
							 JavascriptExecutor js = (JavascriptExecutor)driver;
							 js.executeScript("arguments[0].click();", element);
							blResult=true;
							//ResultUtil.report("PASS", "Clicked button <<" + strLogicalName + ">>","", "", driver);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
							//ResultUtil.report("FAIL", "Unable to click <<" + strLogicalName + ">> button Exception occurred:" + e.getMessage(),"", "", driver);
						}
						
					}
			}
				return blResult;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}

		
		
	/* Build the element based on the strLocatorType and strLocatorValue passed
	public static WebElement BuildElement (String strLocatorType, String strLocatorValue)
	{
		try
		{
			WebElement element1 = null;
			WebDriver driver = new ChromeDriver();
			switch(strLocatorType.toUpperCase())
			{
			case "ID":
				element1=driver.findElement(By.id(strLocatorValue));
				break;
				
			case "XPATH":
				element1=driver.findElement(By.xpath(strLocatorValue));
				break;
	
				
			case "CLASSNAME":
				element1=driver.findElement(By.className(strLocatorValue));
				break;
	
				
			case "CSS":
				
				element1=driver.findElement(By.cssSelector(strLocatorValue));
				break;
				
			case "NAME":
				element1=driver.findElement(By.name(strLocatorValue));
				break;
				
			case "TAGNAME":
				element1=driver.findElement(By.tagName(strLocatorValue));
				break;
		
	        default:
				break;
	
			}
			return element1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	
}*/
    
   
   
    
}

