package learning.tests;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class EndToEndChecking
{
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
             WebDriver driver = new ChromeDriver();	
             driver.get("https://beta.friender.io/login");
             driver.manage().window().maximize();
     	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
             driver.findElement(By.cssSelector("input[placeholder='Enter Email']")).sendKeys("testuser305@friender.in");
             driver.findElement(By.cssSelector("input[placeholder='Enter Password']")).sendKeys("S@ty@1qq5");
             driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();
             
             driver.findElement(By.cssSelector(".nav-bar li:nth-child(2)")).click();
             
             driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("Digi Kahani");
             Thread.sleep(2000);
             driver.findElement(By.cssSelector("input[aria-label='Toggle select row']")).click();
	}

}
