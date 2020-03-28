package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Categories {

	@FindBy(how=How.XPATH,using="//*[contains(@class,'category-navigation')]//ul[@class='list']//a[contains(text(),'Books')]") WebElement Books;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Computers')]") WebElement Computers;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Electronics')]") WebElement electronics;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Apparel & Shoes')]") WebElement ApparShoes;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Digital downloads')]") WebElement Digitaldownloads;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Gift Cards')]") WebElement GiftCards;
	
}
