package learning.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import learning.utils.DriverManager;
import learning.utils.PropertiesManager;


public class BaseTest
{  
	@BeforeMethod(alwaysRun = true)
	public void launchApp() throws FileNotFoundException, IOException 
	{
	    String baseUrl = null;

	    try {
	        // Fetch the 'url' system property passed via Maven or default to the properties file
	        String environment = System.getProperty("url") != null ? System.getProperty("url") : "default";
	        baseUrl = PropertiesManager.getProperty(environment);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    DriverManager.getDriver().get(baseUrl);
	}
    

	@AfterMethod(alwaysRun=true)
	public void closeApp() throws InterruptedException 
	{
		Thread.sleep(3000);
		DriverManager.quitDriver();
	}
		
}
