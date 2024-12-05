package learning.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserObjects 
{
	public static WebDriver getBrowser(String browserName) throws FileNotFoundException, IOException 
	{
        WebDriver driver;
        
       // Fetch the extension path from the properties file
        String extensionPath = PropertiesManager.getProperty("extensionPath");

        if (browserName.equalsIgnoreCase("chrome")) 
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            
            // Add extension if the path is not null or empty
            if (extensionPath != null && !extensionPath.isEmpty()) {
                File extensionFile = new File(extensionPath);
                if (extensionFile.exists()) {
                    options.addExtensions(extensionFile);
                } else {
                    throw new IllegalArgumentException("Extension file not found: " + extensionPath);
                }
            }
            
            driver = new ChromeDriver(options);
        } 
        else if (browserName.equalsIgnoreCase("edge")) 
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } 
        else if (browserName.equalsIgnoreCase("firefox")) 
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } 
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        return driver;
    }
}
