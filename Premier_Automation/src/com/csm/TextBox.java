package com.csm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends ButtonActions{
	public TextBox() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//This is check and use sendkeys to enter value in TextBox
	public static void sendKeys(WebDriver driver,String LogicalName,String strValue) throws IOException{
		boolean blResult=false;
		Map<Integer, String> objMap = Object.fetchObjParameters(LogicalName);
		String strLocatorType = objMap.get(1);  
		String  strLocatorValue = objMap.get(2);
		
    	
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						element.sendKeys(strValue);
						//blResult=true;
					}
					catch(Exception e){
						e.printStackTrace();
					//	return false;
					}
				}
			}
			}
	//	return blResult;
	}
	
	//This function is to check and use JavaScript Executor to enter value in TextBox
	public static boolean jsEnterValue(String strLogicalName,WebDriver driver,WebElement element,String strValue){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						JavascriptExecutor javascriptExecutor=((JavascriptExecutor)driver);
						javascriptExecutor.executeScript("arguments[0].value=arguments[1]", element,strValue);
						element.sendKeys(strValue);
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
