package TestScripts;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import CSMUtlities.*;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class CSMTest {
	
	static WebDriver driver;
	ExtentHtmlReporter reporter;
	 ExtentReports extent;
	 ExtentTest report;
	 Utilities Utility;
	 File HtmlFile;
	 ConfigurationUtilities configUtilty;
	 TabClick click;
	 
	@BeforeClass
	public void Calldriver() throws IOException
	{
		configUtilty = new ConfigurationUtilities();
		System.setProperty("webdriver.chrome.driver",configUtilty.Readproperty("ChromeDriver"));
		driver = new ChromeDriver();	
		 reporter=new ExtentHtmlReporter(configUtilty.Readproperty("ReportFile"));
		 extent = new ExtentReports();
		 Utility = new Utilities();
		 HtmlFile = new File(configUtilty.Readproperty("ReportFile"));
		   click = new TabClick(); 
         // attach the reporter which we created in Step 1
	    extent.attachReporter(reporter);
	    
         // call createTest method and pass the name of TestCase- Based on your requirement
	    report=extent.createTest("CSM Test");
	}
	
  @Test // CSM Page Load
  public void TestCase1() throws Exception {
	  
	  driver.get(configUtilty.Readproperty("CSMURL"));
	  driver.manage().window().maximize();
	  driver.findElement(ById.id("Office365")).click();
	  report.log(Status.PASS, "CSM Login Page Displayed");
	  extent.flush();
  }
  
  @Test // Login Test
  public void TestCase2() throws IOException {
	  try
	  {
		  String signinxpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]";
	  driver.findElement(ByName.name("loginfmt")).sendKeys(configUtilty.Readproperty("Userid"));
	  Thread.sleep(1000);
	  driver.findElement(By.id("idSIButton9")).click();
	  driver.findElement(ByName.name("passwd")).sendKeys(configUtilty.Readproperty("Password"));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(signinxpath)).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@value='Yes']")).click();
	  report.log(Status.PASS, "Home Page Displayed");
	  Utility.GetScreenshot(driver,"HomePage");
	//  report.pass("Home Page Pass",MediaEntityBuilder.createScreenCaptureFromPath().build());
	 
	  extent.flush();
	  }
	  catch(Exception e)
	  {
		  report.log(Status.FAIL, "Home Page Loading Failed");
		  report.fail("Home Page Fail",MediaEntityBuilder.createScreenCaptureFromPath(Utility.GetScreenshot(driver,"HomePageFail")).build());
		  extent.flush();
		  e.printStackTrace();
	  }
  }
  
  @Test // navigating to the account and project
  public void TestCase3() throws IOException {
	  try
	  {
		  Thread.sleep(7000);
		  driver.findElement(By.id("202100030")).click();
		  Thread.sleep(7000);
			  
		  driver.findElement(By.xpath("//li[contains(text(),'ACCF - Database Developer Associate')]")).click();
//		    WebDriverWait wait = new WebDriverWait(driver, 60);
//		    WebElement projName =driver.findElement(By.xpath(""));
//		    projName.click();
//// driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-dashboard[1]/div[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/a[1]/li[1]/i[1]")).click();
	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//span[contains(text(),'Risks')]")).click();
	  click.ClickTab(driver, "'Risks'");
	  report.log(Status.PASS, "Risk Tab is Loaded");
	  report.pass("Risk Tab Success",MediaEntityBuilder.createScreenCaptureFromPath(Utility.GetScreenshot(driver,"RiskTabPass")).build());
	  extent.flush();
	  }
	  
	  catch(Exception e)
	  {
		 
		  report.log(Status.FAIL, "Risk Tab is not Loaded");
		  report.fail("Risk Tab Failes",MediaEntityBuilder.createScreenCaptureFromPath(Utility.GetScreenshot(driver,"RiskTabFail")).build());
		  extent.flush();
		  e.printStackTrace();
	  }
  }
  
  
  @Test // Retrieving Risk Table Data and Editing the data
  public void TestCase4() throws IOException {
	  try
	  {
		  List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover mat-table']//tr"));
		  int rowsize = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover mat-table']//tr")).size();
		  System.out.println("Rows:"+rowsize);
		  int colsize = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover mat-table']//tr[1]//td")).size();
		  System.out.println("Columns:"+colsize);
		  System.out.println(rows.size());
		  Iterator itr = rows.iterator();
		  
		  for( int i = 1;i <=colsize;i++)
		  {			  
			  WebElement element = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover mat-table']//tr[1]//td["+i+"]"));
			  System.out.println(element.getText());
		  }
		  driver.findElement(By.xpath("//table[@class='table table-bordered table-hover mat-table']//tr[1]//td["+(colsize-2)+"]")).click();
		  Thread.sleep(2000);
		  RiskEdit("Probability","Unlikely");
		  Thread.sleep(2000);
		  driver.findElement(By.className("btn-success")).click();
		  
		  report.log(Status.PASS, "Risk is Edited");
		  report.pass("Risk Tab Edit Success",MediaEntityBuilder.createScreenCaptureFromPath(Utility.GetScreenshot(driver,"RsikTabEditSuccess")).build());
		  extent.flush();
	  }
	  catch(Exception e)
	  {
		  report.log(Status.FAIL, "Risk Edit Button is not Found");
		  report.fail("Risk Tab Edit Failes",MediaEntityBuilder.createScreenCaptureFromPath(Utility.GetScreenshot(driver,"RsikTabEditFailed")).build());
		  extent.flush();
		  e.printStackTrace();
	  }
	  }
  

  public void RiskEdit(String FieldName, String Value) throws IOException {
	  try
	  {
		 
		  WebElement RiskDesc = driver.findElement(By.name("txtDescription"));
		  
		  WebElement BusImpact = driver.findElement(By.name("txtImpact"));
		  System.out.println("Select Probability dd");
		  
		  Select DD=new Select(driver.findElement(By.className("ng-dirty")));
		  System.out.println("element selected");	
		  DD.selectByIndex(3);
		  System.out.println("Value selected in Prob dd");
		  //WebElement Impact = driver.findElement(By.id("mat-select-439"));
		  //Select Impactdropdown = new Select(Impact);
		  
		  WebElement RiskOwner =driver.findElement(By.name("txtOwner"));
		  WebElement RiskArea = driver.findElement(By.name("txtArea"));
		  WebElement IDentified = driver.findElement(By.name("txtIdentifiedBy"));
		  WebElement IDate = driver.findElement(By.name("dtIdentifiedDate"));
		  WebElement RiskTreatment=driver.findElement(By.name("txtActionTaken"));;
		  WebElement TDate =driver.findElement(By.name("dtTargetDate"));
		  WebElement Status=driver.findElement(By.name("ddStatus"));
		  Select Statusdropdown = new Select(Status);
		  WebElement Button=driver.findElement(By.className("btn-success"));
		  
		  switch(FieldName)
		  {
		  case "RiskDesc":
			  RiskDesc.sendKeys(Value);
			  break;
		  case "BusinessImpact":
			  BusImpact.sendKeys(Value);
			  break;
		  case "Probability":
			  Thread.sleep(1000);
			  DD.selectByVisibleText(Value);
			  break;
		  /*case "Impact":
			  Impactdropdown.selectByValue(Value);
			  break;*/
		  case "RiskOwner":
			  RiskOwner.sendKeys(Value);
			  break;
		  case "RiskArea":
			  RiskArea.sendKeys(Value);
			  break;
		  case "IdentifiedBy":
			  IDentified.sendKeys(Value);
			  break;
		  case "Identified Date":
			  IDate.sendKeys(Value);
			  break;
		  case "Risk Treatment":
			  RiskTreatment.sendKeys(Value);
			  break;
		  case "TargetDate":
			  TDate.sendKeys("Value");
			  break;
		  case "Status":
			  Statusdropdown.selectByValue(Value);
			  break;
			  
			  default:
				  driver.findElement(By.className("btn-success")).click();
				
			  		  }
		    }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  System.out.println(FieldName+ " is Invalid");
	  }
  }

  
  @AfterTest // End of the Test and HTML Report Generation
  public void openReport() throws IOException
  {
//	  driver.close();
	  driver.quit();
	  Desktop.getDesktop().browse(HtmlFile.toURI());
  }
  }
  

