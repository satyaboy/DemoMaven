package learning.Page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendListPage
{
   public WebDriver driver;
    
	public FriendListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".nav-bar li:nth-child(2)")
	WebElement clickContacts;
	
	@FindBy(xpath="//tbody[@class='MuiTableBody-root mui-table-body css-4lotsn']")
	WebElement table;
	
	@FindBy(xpath="(//tr[@class='MuiTableRow-root css-tmdiqw'])")
	List<WebElement> rows;
	
//	@FindBy(xpath="//input[@type='checkbox']")
//	WebElement checkbox;
	
	@FindBy(css="input[placeholder='Search']")
	WebElement searchfield;
	
	@FindBy(css="input[aria-label='Toggle select row']")
	WebElement selectfriend;
	
	@FindBy(css=".accessibility-btn.btn.h-100")
	WebElement actionbtn;
	
	@FindBy(css="div[class='fr-dropdown fr-dropdownAction active'] ul li")
	private List<WebElement> actionlist;
	
	@FindBy(xpath="//div[@class='selector_box']")
	WebElement selectbox;
	
	@FindBy(xpath="//ul[@class='selector_box_options']//li")
	private List<WebElement> campaigns;
	
	@FindBy(css="div[class='modal-background add-campaign-modal'] button[class='btn-primary unfriend']")
	WebElement addAll;
	
	private By selCheckbox = By.xpath(".//span/input[@aria-label='Toggle select row']");
	private By getFbName =   By.xpath(".//span[@class='fb-name']");
	
	public void getClickContact()
	{
		clickContacts.click();
	}
	
	public List<WebElement> getActionList(){
        return actionlist;
    }
	
	public List<WebElement> getCampaigns(){
        return campaigns;
    }
	
	public List<String> selectParticularNumberOfPeople(int n) 
	{
		 List<String> selectedFriendNames = new ArrayList<>();
		 
		    int count;
		    if (n > rows.size()) {
		        count = rows.size();
		    } else {
		        count = n;
		    }
	        System.out.println(count);
	        
	        for (int i = 0; i < count; i++) {
	            WebElement row = rows.get(i);
	            WebElement checkbox = row.findElement(selCheckbox);
	            checkbox.click();

	            if (checkbox.isSelected()) {
	                WebElement friendNameCell = row.findElement(getFbName);
	                String friendName = friendNameCell.getText();
	                System.out.println(friendName);
	                selectedFriendNames.add(friendName);

	                try {
	                    Thread.sleep(5000); // Pause for 5 seconds (discouraged in production)
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        System.out.println(selectedFriendNames);
	        return selectedFriendNames;
	}
	
	public void searchForFriends(List<String> friendNames) throws InterruptedException 
	{
		for(String friendName : friendNames) 
		{	
			searchfield.clear();  // Clear any previous search
			searchfield.sendKeys(friendName);
			Thread.sleep(3000);
			selectfriend.click();

			actionbtn.click();
			Thread.sleep(3000);
			List<WebElement> alloptions = getActionList(); 
			for(int i=0;i<alloptions.size()-1;i++) 
			{
				if(alloptions.get(i).getText().equalsIgnoreCase("Campaign")) 
				{
					alloptions.get(i).click();
					break;
				}
			}
			
			Thread.sleep(3000);
			selectbox.click();
			List<WebElement> campaigns = getCampaigns();
			for(int i=0;i<campaigns.size()-1;i++) 
			{
				if(campaigns.get(i).getText().equalsIgnoreCase("Demo campaign")) 
				{
					campaigns.get(i).click();
					break;
				}
			}
			addAll.click();
			
		}
		
		
	}
	
}
