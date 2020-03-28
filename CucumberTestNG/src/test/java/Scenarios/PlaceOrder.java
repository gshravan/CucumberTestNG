package Scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basic.BrowserFactory;
import POM.POMUserLogin;

public class PlaceOrder {
	
	WebDriver driver;
	
	@Test
	public void userlogin()
	{
	
	driver=BrowserFactory.startBrowser("chrome", "http://demowebshop.tricentis.com/");
	//Thread.sleep(15000);
	 POMUserLogin login=PageFactory.initElements(driver,POMUserLogin.class );
	 login.userLogin("JohnMake@test.com", "test1234");
	 System.out.println("User logged successfully");
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test (dependsOnMethods= {"userlogin"})
	public void searchForProduct()
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Health");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		System.out.println("Product searched successfully");
	}
	
	@Test (dependsOnMethods= {"searchForProduct"})
	public void addToCart() throws Exception
	{
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Health']/parent::h2/following-sibling::div[@class='add-info']//input[@value='Add to cart']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		//Enter Quantity
		driver.findElement(By.xpath("//table[@class='cart']//input[@class='qty-input']")).clear();
		driver.findElement(By.xpath("//table[@class='cart']//input[@class='qty-input']")).sendKeys("2");
		
		
		driver.findElement(By.xpath("//input[@name='termsofservice']")).click();
		
		driver.findElement(By.xpath("//*[@name='checkout']")).click();
		
		System.out.println("Product checkedout successfully");
		
	}
 

	@Test (dependsOnMethods= {"addToCart"})
	public void billingAdrress()
	{
		/*//Select Country
		WebElement country_ele=driver.findElement(By.xpath("//*[contains(@id,'CountryId')]"));
		Select country=new Select(country_ele);
		country.selectByValue("United States");
		
		//Select Country
		WebElement state_ele=driver.findElement(By.xpath("//*[contains(@id,'StateProvinceId')]"));
		Select state=new Select(state_ele);
		state.selectByValue("Alabama");
		*/
		
		driver.findElement(By.xpath("//div[contains(@id,'billing-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered billing address");
	}
	
	
	@Test (dependsOnMethods= {"billingAdrress"})
	public void shippingAddress()
		{
		
		driver.findElement(By.xpath("//*[(@name='PickUpInStore') and (@type='checkbox')]")).click();
				
		driver.findElement(By.xpath("//div[contains(@id,'shipping-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered shipping address");
	}
	
	@Test (dependsOnMethods= {"shippingAddress"})
	public void paymentMethod()
	{
		driver.findElement(By.xpath("//*[(@type='radio') and (@value='Payments.CashOnDelivery')]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'payment-method-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered payment method");
	}
	
	@Test (dependsOnMethods= {"paymentMethod"})
	public void paymentInformation()
	{
		
		driver.findElement(By.xpath("//div[contains(@id,'payment-info-buttons')]/input[@value='Continue']")).click();
		System.out.println("Successfully entered payment information");
	}
	
	@Test (dependsOnMethods= {"paymentInformation"})
	public void confirmOrder()
	{
		
		driver.findElement(By.xpath("//div[contains(@id,'confirm-order-buttons')]/input[@value='Confirm']")).click();
		System.out.println("Order confirmed successfully");
	}
	
	@Test (dependsOnMethods= {"confirmOrder"})
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
	
	
	@Test (dependsOnMethods= {"successMessage"})
	public void logout()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		driver.quit();
	}
	
}
