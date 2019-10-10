package com.csm;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;




public class Browser  {
    public static WebDriver driver;
    public String BrowserName;
    //public String platform;

    public WebDriver launchURL(String browserName, String strURL) {
      // DesiredCapabilities capability = null;
        try {
           // String workingFolder=System.getProperty("user.dir");
              if (browserName.equalsIgnoreCase("CHROME")) {
                BrowserName = BrowserType.Chrome.getType();
                try {
                   /*  capability = DesiredCapabilities.chrome();
                     capability.setPlatform(Platform.WINDOWS);
                     HashMap<String, java.lang.Object> chromePrefs = new HashMap<String, java.lang.Object>();
                     chromePrefs.put("profile.default_content_settings.popups", 0);
                     chromePrefs.put("download.default_directory", workingFolder+"\\Downloads");
                     ChromeOptions options = new ChromeOptions();
                     HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
                     options.setExperimentalOption("prefs", chromePrefs);
                     options.addArguments("--start-maximized");
                     capability.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
                     capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                     capability.setCapability(ChromeOptions.CAPABILITY, options);
                     capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                     capability.setCapability("chrome.switches", Arrays.asList("--incognito"));
                     */
                 } catch (WebDriverException exception) {
                     System.out.print("ERROR : Chrome is not installed on host machine." + exception.getMessage());
                     System.exit(1);
                 }
            } 
              System.setProperty("webdriver.chrome.driver", "D:\\Premier_Automation\\src\\com.resources\\chromedriver.exe");
            driver = new ChromeDriver();
          //  driver = new Augmenter().augment(driver);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(strURL);
            System.out.println("PASS" + "Opened <<" + strURL + ">> URL on " + browserName + " browser Machine:" +  driver);

        } catch (Exception e) {
            e.printStackTrace();
     }
        return driver;
    }



    public enum BrowserType {
        FireFox("*firefox"),
        Chrome("*chrome"),
        InternetExplore("*iexplore"),
        Safari("*safari"),
        Opera("*opera"),
        Android("*android"),;

        private String type;

        BrowserType(String type) {
            this.type = type;
        }


        public String getType() {
            return this.type;
        }

    }

}
