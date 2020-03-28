package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Temp {
	
	@Test
	public void temp()
	{
		System.setProperty("webdriver.chrome.dribver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("http://demowebshop.tricentis.com/");
		//driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.get("http://google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@name='q']")).submit();
		
		
	}
	}
	


