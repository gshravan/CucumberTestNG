package Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Basic.BrowserFactory;
import POM.POMUserLogin;


public class UserLoginTestNG {
	
	@Test
	public void userlogin() throws Exception
	{

	WebDriver driver=BrowserFactory.startBrowser("chrome", "http://demowebshop.tricentis.com/");
	Thread.sleep(15000);
	 POMUserLogin login=PageFactory.initElements(driver,POMUserLogin.class );
	 login.userLogin("JohnMake@test.com", "test1234");
	 System.out.println("User logged successfully");
	 
	}
	 
	
	
}
