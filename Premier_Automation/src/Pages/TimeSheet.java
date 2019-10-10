package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.csm.*;
import com.csm.Object;

public class TimeSheet extends Browser {

	public void fillTimeSheet() throws IOException {
	
  //  ButtonActions.buttonClickJS(driver,"timesheets");
    try
    {
    	
       	/*WebElement dashboard= driver.findElement(By.xpath("//ul/li[@class='active ng-star-inserted']"));
    	
    	
	
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class','ng-star-inserted');",dashboard);
    
		WebElement timesheet= driver.findElement(By.xpath("//ul/li[6]"));
		js.executeScript("arguments[0].setAttribute('class','ng-star-inserted active');",timesheet);
		js.executeScript("arguments[0].click();",timesheet);*/
	/*DropDown.selectByValue(driver, strLocatorValue, value);
	DropDown.selectByValue(driver, strLocatorValue, value);
	DropDown.selectByValue(driver, strLocatorValue, value);*/
    ButtonActions.buttonClickJS(driver,"timesheets"); 	
    Object.waitForObject(driver,"save_btn");
    ButtonActions.buttonClickJS(driver,"timesheet_row1_cell1");
	TextBox.sendKeys(driver,"timesheet_row1_cell1_txtbox", "10");
	ButtonActions.buttonClickJS(driver,"timesheet_row1_cell2");
	TextBox.sendKeys(driver,"timesheet_row1_cell2_txtbox", "10");	
	ButtonActions.buttonClickJS(driver,"timesheet_row1_cell3");
	TextBox.sendKeys(driver,"timesheet_row1_cell3_txtbox", "10");
	ButtonActions.buttonClickJS(driver,"timesheet_row1_cell4");
	TextBox.sendKeys(driver,"timesheet_row1_cell4_txtbox", "10");	
	ButtonActions.buttonClickJS(driver,"timesheet_row1_cell5");
	TextBox.sendKeys(driver,"timesheet_row1_cell5_txtbox", "10");
	ButtonActions.buttonClickJS(driver,"timesheet_row1_cell6");
	TextBox.sendKeys(driver,"timesheet_row1_cell6_txtbox", "10");	
	ButtonActions.buttonClickJS(driver,"timesheet_row1_cell7");
	TextBox.sendKeys(driver,"timesheet_row1_cell7_txtbox", "10");
	ButtonActions.buttonClick(driver,"save_btn");
    String validationMessage = driver.switchTo().alert().getText();
    Assert.assertEquals(validationMessage, "Updated Successfully");
    driver.switchTo().alert().accept();
    ButtonActions.buttonClick(driver,"submit_for_review_btn");
    driver.switchTo().alert().accept();
    validationMessage = driver.switchTo().alert().getText();
    Assert.assertEquals(validationMessage, "Successfully submitted for review");
    driver.switchTo().alert().accept();
    Screenshots.takeScreenshot("Timesheet Submitted Successful");
  
    }
    catch (Exception e) {
        e.printStackTrace();
          //ResultUtil.report("FAIL", "Execution failed", "Not able to view Group revenue", "" + e.getMessage(), driver);
                }
    
	}
	 
}
