package learning.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class DriverManager 
{
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver() throws FileNotFoundException, IOException 
	{
		String browser = null;
		try {
			browser = System.getProperty("browser") != null ? System.getProperty("browser"): PropertiesManager.getProperty("browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.set(BrowserObjects.getBrowser(browser));
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static WebDriver getDriver() throws FileNotFoundException, IOException 
	{
		if (driver.get() == null) {
			setDriver();
		}
		return driver.get();
	}

	public static void quitDriver() 
	{
		if (driver.get() != null)
		{
			driver.get().quit();
			driver.remove();
		}
	}	
}
