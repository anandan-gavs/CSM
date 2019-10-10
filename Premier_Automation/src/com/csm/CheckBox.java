package com.csm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//Checks or Unchecks a checkbox - Pass the strLocatorType,strLocatorValue,driver,action as true or false (to check or uncheck)
public class CheckBox {	
	public static boolean checkUncheck(String strLocatorType, String strLocatorValue,WebDriver driver,boolean action) throws Exception{		
		boolean blResult=false;
		WebElement element = Object.getElement(driver, strLocatorType, strLocatorValue);
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						if(action == true)
						{						
						 if(!element.isSelected()){
							 element.click(); //Check the checkbox
						 }						 
						 blResult=true;
						}
						else
						{
							 if(element.isSelected()){
								 element.click(); //UnCheck the checkbox
							 }						 
							 blResult=true;
							}
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
			