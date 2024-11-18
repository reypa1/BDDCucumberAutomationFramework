package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageObjects {
	public WebDriver driver;

	public CheckoutPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By cartBag = By.xpath("//a[@class='cart-icon']");
	//By AddCart=By.xpath("//button[text()='ADD TO CART']//ancestor::div[@class='product']");
	By AddCart=By.xpath("//div[@class='product-action']");
	By checkOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoButton=By.xpath("//button[contains(text(),'Apply')]");
	By placeOrder = By.xpath("//button[text()='Place Order']");


	public void CheckOutItems() throws Exception
	{
		WebElement AddCartBag = driver.findElement(cartBag);
		System.out.println(" Before Clicking on --- " + AddCartBag);
		AddCartBag.click();
		System.out.println(" After Clicking on --- " + AddCartBag);
		Thread.sleep(1000);
		
		WebElement ProceedToCheckOut=driver.findElement(checkOutButton);
		if(ProceedToCheckOut.isDisplayed())
		{
			System.out.println("Proceed to Checkout button Is Clickable");
			ProceedToCheckOut.click();
			Thread.sleep(2000);
			System.out.println(" Clicked on Proceed to Check out Button ");
		}
		else {
			System.out.println("Proceed to Checkout button Is not Clickable");
		}
		
		
	}
	
	

	/*
	 * public void JavaScriptExe() {
	 * 
	 * JavascriptExecutor ModalActive= (JavascriptExecutor) driver;
	 * ModalActive.executeScript(
	 * "var el=arguments[0]; setTimeout(function() { el.click(); }, 100);",
	 * modalPopUpActive); }
	 */


	public boolean VerifyPromoButton() {

		return driver.findElement(promoButton).isDisplayed();

	}

	public boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}


}