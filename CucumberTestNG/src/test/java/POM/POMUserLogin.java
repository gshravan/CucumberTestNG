package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class POMUserLogin {
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Log in')]") WebElement loginlink;
	@FindBy(how=How.XPATH,using="//*[@name='Email']") WebElement email;
	@FindBy(how=How.XPATH,using="//*[@name='Password']") WebElement pwd;
	@FindBy(how=How.XPATH,using="//*[@value='Log in']") WebElement loginbtn ;
	
	public void userLogin(String mail,String pass)
	{
		System.out.println("user login method");
		loginlink.click();
		email.sendKeys(mail);
		pwd.sendKeys(pass);
		loginbtn.click();
	}
	
	

}
