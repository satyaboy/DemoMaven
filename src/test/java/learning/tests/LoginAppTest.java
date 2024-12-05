package learning.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import learning.Component.BaseTest;
import learning.Component.GenericUtils;
import learning.Page.LoginPage;
import learning.utils.DriverManager;

public class LoginAppTest extends BaseTest
{
	@Test
   public  void LogInToApplication() throws InterruptedException, FileNotFoundException, IOException
   {  
	   LoginPage loginpage = new LoginPage(DriverManager.getDriver());
	   GenericUtils genericutils= new GenericUtils(DriverManager.getDriver());
	                genericutils.SwitchToWindow();
	                loginpage.LoginToFacebook();
	                genericutils.SwitchToWindowChild();             
                    loginpage.userLogin("testuser305@friender.in", "S@ty@1qq5");
                    Thread.sleep(1000);
   }
}  
