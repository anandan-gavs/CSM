package com.csm;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Screenshots extends Browser{

	public static void takeScreenshot(String filename) throws IOException
	{
		try
		{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("D:\\Premier_Automation\\result\\"+filename+".png"));
		
		}
		catch(Exception e) { e.printStackTrace();}
	}
}
