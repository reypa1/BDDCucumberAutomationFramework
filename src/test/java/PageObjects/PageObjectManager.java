package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPageObjects landingPage;
	public OffersPageObjects offersPage;
	public CheckoutPageObjects checkOutPage;
	//***************************
	public AutomationPageObjects autoPage;
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPageObjects getLandingPage()
	{
		landingPage=new LandingPageObjects(driver);
		return landingPage;
	}
	
	public OffersPageObjects getOffersPage()
	{
		offersPage=new OffersPageObjects(driver);
		return offersPage;
	}
	public CheckoutPageObjects getCheckOutPage()
	{
		checkOutPage=new CheckoutPageObjects(driver);
		return checkOutPage;
	}
	//From here it is an another proj
	public AutomationPageObjects getAutomationPageObjects ()
	{
		 autoPage=new AutomationPageObjects(driver);
		return autoPage;
	}
}
