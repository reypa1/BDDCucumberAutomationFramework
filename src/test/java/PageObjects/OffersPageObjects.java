package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageObjects {
public WebDriver driver;
	
	public OffersPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
 
	By search = By.xpath("//input[@type='search']");
	
	 By productName = By.xpath("//td[text()='Tomato']");
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getText()
	{
		driver.findElement(search).getText();
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
}
