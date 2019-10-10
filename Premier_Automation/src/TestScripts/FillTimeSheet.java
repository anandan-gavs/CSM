package TestScripts;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.csm.ButtonActions;

import Pages.LoginPage;
import Pages.TimeSheet;

public class FillTimeSheet extends ButtonActions{
	
	

	public FillTimeSheet() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* @Parameters({"platform","browserName","remoteurl","url"})
	   @BeforeClass
	    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {
    
	        driver=launchURL(platform, browserName, remoteurl, url);
	    }
	    */

	    @Test
	    public void submitTimeSheet() {
	        try {
	       	
	        	LoginPage LP = new LoginPage();
	        	LP.Login("chrome","http://10.0.100.222:8092");
	        	TimeSheet TS = new TimeSheet();
	        	TS.fillTimeSheet();
	        	LP.Logout();
	        	
	        	//driver=launchURL("chrome","https://csm.gavstech.com");
	        	// Object.buildObjectFromRepository(driver,"Office365");
	           	
	           
	            //close
	          //  driver.close();

	            //Close browser
	           // driver.quit();

	        } catch (Exception e) {
              e.printStackTrace();
	            //ResultUtil.report("FAIL", "Execution failed", "Not able to view Group revenue", "" + e.getMessage(), driver);
	            }
	    }
	   
	    

	}


