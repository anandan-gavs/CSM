package Pages;
import org.openqa.selenium.WebDriver;

import com.csm.*;
import com.csm.Object;

public class LoginPage extends Browser {

	
	public void  Login(String browser, String url) throws Exception{		
		driver = launchURL(browser,url);
	    Object.waitForObject(driver,"Office365");
		TextBox.sendKeys(driver,"login_username_txtbox","sudhakarkumar.mandal@gavstech.com");
		ButtonActions.buttonClick(driver,"login_btn");
	    Object.waitForObject(driver,"dashboard_lnk");
	}
	
	public void Logout()
	{
		ButtonActions.buttonClick(driver,"logout_btn");
		driver.switchTo().alert().accept();
		driver.close();
	}
	}
