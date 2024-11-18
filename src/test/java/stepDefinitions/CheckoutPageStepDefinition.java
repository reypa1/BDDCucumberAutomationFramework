package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPageObjects checkOutPage;
	public TestContestSetup testContestSetup;

	public CheckoutPageStepDefinition(TestContestSetup testContestSetup)
	{
		this.testContestSetup=testContestSetup;
		this.checkOutPage=testContestSetup.pageObjectManager.getCheckOutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		//checkOutPage=testContestSetup.pageObjectManager.getCheckOutPage();
		Assert.assertTrue(checkOutPage.VerifyPromoButton());
		System.out.println("Verified PromoButton Successfully");
		Assert.assertTrue(checkOutPage.VerifyPlaceOrder());
		System.out.println("Verified PlaceOrder Button Successfully");
	}

	@Then("User proceeds to Checkout and validate the items in checkout page")
	public void User_proceeds_to_Checkout_and_validate_the_items_in_checkout_page() throws Exception
	{
		checkOutPage.CheckOutItems();
		System.out.println("Verified Checkouts page");
	}

}
