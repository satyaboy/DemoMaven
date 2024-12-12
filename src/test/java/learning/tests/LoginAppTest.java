package learning.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import learning.Component.BaseTest;
import learning.Component.GenericUtils;
import learning.Page.FriendListPage;
import learning.Page.LoginPage;
import learning.utils.DriverManager;

public class LoginAppTest extends BaseTest
{
	@Test(dataProvider="loginDetails")
   public  void LogInToApplication(String data) throws InterruptedException, FileNotFoundException, IOException
   {  
	   String users[]= data.split(",");
	   LoginPage loginpage = new LoginPage(DriverManager.getDriver());
	   GenericUtils genericutils= new GenericUtils(DriverManager.getDriver());
	                Thread.sleep(2000);
	                genericutils.SwitchToWindow();
	                loginpage.LoginToFacebook();
	                genericutils.SwitchToWindowChild();             
	                FriendListPage friendlist=loginpage.userLogin("testuser305@friender.in", "S@ty@1qq5");
	               //FriendListPage friendlist=loginpage.userLogin(users[0], users[1]);
                    Thread.sleep(2000);
                    friendlist.getClickContact();
                    List<String> friendsToSearch= friendlist.selectParticularNumberOfPeople(5);
                    friendlist.searchForFriends(friendsToSearch);
   }
   
	public void addFriendToCampaign() throws FileNotFoundException, IOException 
	{
		LoginPage loginpage = new LoginPage(DriverManager.getDriver());
		FriendListPage friendlist=loginpage.userLogin("testuser305@friender.in", "S@ty@1qq5");
	}
	
	
	
	@DataProvider(name="loginDetails")
	public String[] readJson() throws IOException, ParseException 
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\src\\main\\java\\learning\\resources\\testData.json");
		
		Object obj=jsonParser.parse(reader);
		
		JSONObject userloginjsonobj =(JSONObject) obj;
		JSONArray userloginsArray = (JSONArray) userloginjsonobj.get("userlogin");
		
		String arr[] = new String[userloginsArray.size()];
		
		for(int i=0;i<userloginsArray.size();i++) 
		{
			JSONObject users = (JSONObject) userloginsArray.get(i);
			String user =(String)users.get("username");
			String pwd =(String)users.get("password");
			
			arr[i]= user+","+pwd;
		}
		
		return arr;
	}
}  
