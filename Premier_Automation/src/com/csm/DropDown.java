package com.csm;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	//This function Selects a value from the Dropdown based on the value passed.
	public static boolean selectByValue(WebDriver driver,String strLocatorValue, String value) throws Exception{		
		boolean blResult=false;
		;
		WebElement element = Object.getElement(driver,strLocatorValue,value);
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						sel.selectByValue(value);
						 blResult=true;
						}
            		catch(Exception e){
						e.printStackTrace();
						return false;
					}
					}
				}
		
			}
		
		return blResult;
	}
	
	
	//This function Selects a value from the Dropdown based on the index passed.
	/*public static boolean selectByIndex(WebDriver driver, String strLocatorValue, int index) throws Exception{		
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorValue, strLocator);
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						sel.selectByIndex(index);
						 blResult=true;
						}
            		catch(Exception e){
						e.printStackTrace();
						return false;
					}
					}
				}
		
			}
		
		return blResult;
}
	
	*/


//This function Selects a value from the Dropdown based on the Visibletext passed.
public static boolean selectByVisibleText(String strLocatorType, String strLocatorValue,WebDriver driver,String text) throws Exception{		
	boolean blResult=false;
	WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
	if(element!=null){
		if(element.isDisplayed()){
			if(element.isEnabled()){
				try{
					Select sel = new Select(element);
					sel.selectByVisibleText(text);
					blResult=true;
					}
        		catch(Exception e){
					e.printStackTrace();
					return false;
				}
				}
			}
	
		}
	
	return blResult;
	}



//This function Selects a value from the Dropdown by JS and Mouseover
public static boolean selectByJS(String strLocatorType, String strLocatorValue, String strLocatorType1, String strLocatorValue1,WebDriver driver) throws Exception{		
	boolean blResult=false;
	WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
	WebElement element1 = Object.getElement(driver, strLocatorType1, strLocatorValue1);
	if(element!=null){
		if(element.isDisplayed()){
			if(element.isEnabled()){
				try{
					 JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", element);
					 Object.waitForSeconds(2,driver);
					 Actions action = new Actions(driver);
				     action.moveToElement(element1).perform();
				     action.click(element1).perform();
					 blResult=true;
					}
      		catch(Exception e){
					e.printStackTrace();
					return false;
				}
				}
			}
	
		}
	
	return blResult;
	}
}

