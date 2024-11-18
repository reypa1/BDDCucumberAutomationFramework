package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.CheckoutPageObjects;
import PageObjects.LandingPageObjects;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContestSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	 LandingPageObjects landingPage;
	 CheckoutPageObjects checkOutPage;
	 
	 By modalPopUp = By.xpath("//div[@class='modal-wrapper']/div//button[text()='×']");
	 
	public TestContestSetup testContestSetup;

	public LandingPageStepDefinition(TestContestSetup testContestSetup)
	{
		this.testContestSetup=testContestSetup;
		this.landingPage=testContestSetup.pageObjectManager.getLandingPage();
		this.checkOutPage=testContestSetup.pageObjectManager.getCheckOutPage();
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws Throwable {

		//testContestSetup.testBase.WebDriverManager();
		//Assert.assertTrue(landingPage.gettitle().contentEquals("GreenKart"));
		System.out.println("Landing page loaded successfully");
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws Exception {
		
		landingPage.searchItem(shortName);
		Thread.sleep(3000);
		String landingPageProductName =  landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName + " got retrieved from Home page");
	}

    @And("^Added (.+) items of the selected product to the cart$")
    public void Added_items_of_the_selected_product_to_the_cart(String quantity) throws Exception
    {
    	landingPage.incrementQuantity(Integer.parseInt(quantity));
    	System.out.println("Product incremented");
    	landingPage.addToCart(); 
    	landingPage.overlay();
    	System.out.println("Product added to cart");
    }
    


}
