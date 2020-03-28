 package Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver startBrowser(String BrowserName,String Url)
	{
		if(BrowserName.equalsIgnoreCase("firefox"))
			
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("chrome"))
			
		{
			System.setProperty("webdriver.chrome.dribver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("ie"))
			
		{
			System.setProperty("webdriver.ie.dribver", "IEDriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(Url);
		return driver;
	}
}
