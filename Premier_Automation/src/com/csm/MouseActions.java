package com.csm;



import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;




public class MouseActions extends ButtonActions{

	public MouseActions() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//This is to check and perform MouseClick
	public static void mouseClick(WebDriver driver,String LogicalName) throws Exception{
		boolean blResult=false;
		FileInputStream objfile = new FileInputStream("D:\\Premier_Automation\\src\\com\\or\\ObjRepo.properties");
		obj.load(objfile);
		String PropertyValue= obj.getProperty(LogicalName);
    	String[] locator = PropertyValue.split(";");
    	String strLocatorType = locator[0];
    	String  strLocatorValue = locator[1];
    	
    	
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		 if(element!=null){
			if(element.isDisplayed()){
				try{
						 Actions action = new Actions(driver);
					     action.moveToElement(element).perform();
					     action.click(element).build().perform();
					   //  blResult=true;
					}
                
		  catch(Exception e){
					e.printStackTrace();
				//	return false;
				}
			}
		 }
	//	return blResult;
	}
	
	//This is to check and perform DoubleClick
	public static boolean mouseDoubleClick(String strLocatorType,String strLocatorValue,WebDriver driver) throws Exception{
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		 if(element!=null){
			if(element.isDisplayed()){
				try{
						 Actions action = new Actions(driver);
					     action.moveToElement(element).perform();
					     action.doubleClick(element).build().perform();
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
	
	//This is to check and perform mouseRightClick
	public static boolean mouseRightClick(String strLocatorType,String strLocatorValue,WebDriver driver) throws Exception{
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		 if(element!=null){
			if(element.isDisplayed()){
				try{
						 Actions action = new Actions(driver);
					     action.moveToElement(element).perform();
					     action.contextClick(element).build().perform();
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
	
	//This is to check and perform MouseDragandDrop from source to target element
	public static boolean mouseDragAndDrop(String strLocatorType,String strLocatorValue,String strLogicalName1,String strLocatorType1, String strLocatorValue1,WebDriver driver) throws Exception{
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		WebElement element1 = Object.getElement(driver, strLocatorType1, strLocatorValue1);
		 if(element!=null){
			if(element.isDisplayed()){
				try{
						 Actions action = new Actions(driver);
					     action.dragAndDrop(element, element1).build().perform();
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
	
	//This is to check and perform MouseHoverandclick on element
	public static boolean mouseHoverAndClick(String strLocatorType,String strLocatorValue,WebDriver driver) throws Exception{
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		 if(element!=null){
			if(element.isDisplayed()){
				try{
						 Actions action = new Actions(driver);
					     action.moveToElement(element).build().perform();
					     action.click(element).perform();
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
	
	//This is to check and perform MouseClick and Hold on Element and mouse over on another element and click on it
	public static boolean mouseClickAndHold(String strLocatorType,String strLocatorValue,String strLocatorType1,String strLocatorValue1,WebDriver driver) throws Exception{
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		WebElement element1 = Object.getElement(driver, strLocatorType1, strLocatorValue1);
		 if(element!=null){
			if(element.isDisplayed()){
				try{
						 Actions action = new Actions(driver);
					     action.clickAndHold(element).build().perform();
					     action.moveToElement(element1).build().perform();
					     action.click().build().perform();
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

	//This is to check and perform scroll using JS
		public static boolean scrollJS(String strLocatorType,String strLocatorValue,WebDriver driver) throws Exception{
			boolean blResult=false;
			WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
			 if(element!=null){
				if(element.isDisplayed()){
					try{
						    JavascriptExecutor js = (JavascriptExecutor)driver;
						    js.executeScript("arguments[0].scrollIntoView(true);", element);
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

}
