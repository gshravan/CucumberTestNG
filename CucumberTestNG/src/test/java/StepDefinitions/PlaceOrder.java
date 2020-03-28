package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import POM.POMUserLogin;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlaceOrder extends AbstractDriverClass {
	
	WebDriver driver=getDriver();
	
	@When("^Search for product \"([^\"]*)\"$")
	public void searchForProduct(String product)
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(product);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		System.out.println("Product searched successfully");
	}
	
	@Then("^Add to cart and enter qty is \"([^\"]*)\"$")
	public void addToCart(String qty) throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'Health')]/parent::h2/following-sibling::div[@class='add-info']//input[@value='Add to cart']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();		
		//Enter Quantity
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@class='cart']//input[@class='qty-input']")).clear();
		driver.findElement(By.xpath("//table[@class='cart']//input[@class='qty-input']")).sendKeys(qty);
		
		
		driver.findElement(By.xpath("//input[@name='termsofservice']")).click();
		
		driver.findElement(By.xpath("//*[@name='checkout']")).click();
		
		System.out.println("Product checkedout successfully");
		
	}
 

	@When("^Confirm billing address$")
	public void billingAdrress()
	{
		driver.findElement(By.xpath("//div[contains(@id,'billing-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered billing address");
	}
	
	
	@When("^Confirm shipping address$")
	public void shippingAddress()
	{		
		driver.findElement(By.xpath("//*[(@name='PickUpInStore') and (@type='checkbox')]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'shipping-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered shipping address");
	}
	
	@When("^Select payment method$")
	public void paymentMethod()
	{
		driver.findElement(By.xpath("//*[(@type='radio') and (@value='Payments.CashOnDelivery')]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'payment-method-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered payment method");
	}
	
	@When("^Confirm payment information$")
	public void paymentInformation()
	{		
		driver.findElement(By.xpath("//div[contains(@id,'payment-info-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered payment information");
	}
	
	@When("^Confirm order$")
	public void confirmOrder()
	{
		
		driver.findElement(By.xpath("//div[contains(@id,'confirm-order-buttons')]/input[@value='Confirm']")).click();
		System.out.println("Order confirmed successfully");
	}
	
	@Then("^Order Confirmation$")
	public void successMessage()
	{
		
		String message=driver.findElement(By.xpath("//*[@class='section order-completed']/div/strong")).getText();
		if (message.equalsIgnoreCase("Your order has been successfully processed!"))
		{
			System.out.println("Order Placed Successfully!");
			
			//Capture Oder number
			String ordermessage=driver.findElement(By.xpath("//*[@class='section order-completed']//li")).getText();
			System.out.println(ordermessage);
			driver.findElement(By.xpath("//*[@value='Continue']")).click();
			
		}
		else
		{
			System.out.println("Error in order placement");
		}
	
	}
	
	
	@When("^Click on logout$")
	public void logout()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		driver.quit();
	}
	
}
