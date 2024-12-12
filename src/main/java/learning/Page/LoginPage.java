package learning.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
   public WebDriver driver;
    
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Enter Email']")
	WebElement emailId;
	
	@FindBy(css="input[placeholder='Enter Password']")
	WebElement Pwd;
	
	@FindBy(css=".btn.btn-primary.w-100")
	WebElement loginBtn;
	
	@FindBy(id="email")
	WebElement FbEmail;
	
	@FindBy(id="pass")
	WebElement FbPass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginBtn;
	
	public void LoginToFacebook() throws InterruptedException 
	{
		driver.get("https://www.facebook.com/");
		FbEmail.sendKeys("p7thers@gmail.com");
		FbPass.sendKeys("S@ty@jit1qq5");
		LoginBtn.click();
		Thread.sleep(3000);
	}
	
	public FriendListPage userLogin(String username, String password) 
	{
		emailId.sendKeys(username);
		Pwd.sendKeys(password);
		loginBtn.click();
		
		FriendListPage friendlist = new FriendListPage(driver);
		return friendlist;
	}
	
	
}
