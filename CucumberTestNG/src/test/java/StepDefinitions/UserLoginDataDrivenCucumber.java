package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Basic.BrowserFactory;
import POM.POMUserLogin;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class UserLoginDataDrivenCucumber extends AbstractDriverClass{
	WebDriver driver=getDriver();
	
  @Given("^Launch the application$")
  public void launch_the_application() throws Throwable {
	  driver.navigate().to("http://demowebshop.tricentis.com/");
	   
  }

  /*
  @When("^Enter username and password$")
  public void enter_username_and_password() throws Throwable {
	  
	  POMUserLogin login=PageFactory.initElements(driver,POMUserLogin.class );
		 login.userLogin("JohnMake@test.com", "test1234");
  }
  */
  
  //****regular expressions
  //1. \"(.*)\" ----- "<username>" in feature file
  //2. \"([^\"]*)\" ---"value" in feature file
  
  
  //*****datadriven****
  @When("^Enter \"(.*)\" and \"(.*)\"$")
  public void enter_username_and_password(String username,String password) throws Throwable {
	  
	  POMUserLogin login=PageFactory.initElements(driver,POMUserLogin.class );
		 login.userLogin(username, password);
  }

  @Then("^User should be able to login successfully$")
  public void success_message() throws Throwable {
	  System.out.println("User logged successfully");
  }

}
