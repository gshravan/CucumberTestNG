package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractDriverClass {
	
	protected static WebDriver driver;
	
	protected WebDriver getDriver()
	{
		if (driver == null)
		{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		}
		
		return driver;
	}
	

}
