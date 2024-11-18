package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPageObjects;
import PageObjects.OffersPageObjects;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContestSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContestSetup testContestSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContestSetup testContestSetup)
	{
		this.testContestSetup=testContestSetup;
	}  

	@Then("^user searched for (.+)shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		System.out.println("*** Before calling swithcToOffersPage ***");
		switchToOffersPage();
		OffersPageObjects offersPage=testContestSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		String offerPageProductName=offersPage.getProductName();
		System.out.println(offerPageProductName);
	}
	public void switchToOffersPage()
	{
		//Write the method in independent like if already user is on offeres page by using other then skip the code
	
		LandingPageObjects landingPage=testContestSetup.pageObjectManager.getLandingPage();
		landingPage.clickTopDeals();
		testContestSetup.genericUtils.SwitchWindowToChild();
	}


	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page()
	{
		Assert.assertEquals(offerPageProductName,testContestSetup.landingPageProductName);
		System.out.println("Product Validation success");
	}


}
