::cd C:\Sharepoint Project\src\resources
::set PATH=C:\Program Files (x86)\Java\jdk1.7.0_79\bin;%PATH%
@echo %CD%
cd src/main/java/resources
java -jar selenium-server-standalone-2.53.1.jar -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.ie.driver="IEDriverServer.exe" -Dwebdriver.safari.driver="SafariDriver.safariextz" 