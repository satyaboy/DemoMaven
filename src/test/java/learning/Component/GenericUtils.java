package learning.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import learning.utils.DriverManager;

public class GenericUtils
{
	WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public void SwitchToWindow() throws InterruptedException, FileNotFoundException, IOException   
	{
		Set<String> s1 = DriverManager.getDriver().getWindowHandles();
		Iterator<String>i1 = s1.iterator();
		String parentwindow  = i1.next();
		String childwindow   = i1.next();	
		driver.switchTo().window(childwindow);
	}
	
	public void SwitchToWindowChild() throws InterruptedException, FileNotFoundException, IOException 
	{	
		Set<String> s1 = DriverManager.getDriver().getWindowHandles();
		Iterator<String>i1 = s1.iterator();
		String parentwindow  = i1.next();
		String childwindow   = i1.next();	
		driver.switchTo().window(parentwindow);
	}

}
