package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;

public class LandingPageObjects {
	public WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.xpath("//a[text()='Top Deals']");
	By increment = By.cssSelector("a.increment");
	By AddCart = By.xpath("//button[text()='ADD TO CART']//ancestor::div[@class='product']");
	By modalPopUpActive = By.xpath("//div[@class='modal-wrapper active']");
	By modalPopUp = By.xpath("//div[@class='modal-wrapper']/div//button[text()='×']");

	public void searchItem(String name) {
		System.out.println("Enter : " + name);
		driver.findElement(search).sendKeys(name);
		System.out.println("Input text -- " + name + " -- provided to seach field");
	}

	public void getText() {
		String eleText = driver.findElement(search).getText();
		System.out.println("Retrieved : " + eleText);
	}

	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(increment).click();
			i--;
		}
	}

	

	public void overlay() {
		// Handle any potential overlay
		try {
			WebElement overlay = driver.findElement(modalPopUpActive);
			if (overlay.isDisplayed()) {
				System.out.println(modalPopUpActive + " --- is displayed on page");
				// Close the overlay if it's blocking the button
				overlay.click();
				System.out.println("Overlay clicked successfully");
				Explicitwait();

			}
		} catch (NoSuchElementException e) {
			System.out.println(" No overlay present on page ");
		}
	}

	public void Explicitwait() {
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(AddCart));
		System.out.println("Presence of Add to cart is located");
		wait.until(ExpectedConditions.elementToBeClickable(AddCart));
	}

	public void addToCart() throws Exception {

		Thread.sleep(2000);
		WebElement AddCartButton = driver.findElement(AddCart);
		System.out.println(" Wait before clicking on Add to Cart Button ");
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", AddCartButton);
		 */
		AddCartButton.click();
		 
		Explicitwait();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void clickTopDeals() {
		System.out.println("Before Clicking on top deals");
		driver.findElement(topDeals).click();
		System.out.println("Clicked on top deals");
	}

	public String gettitle() {
		return driver.getTitle();
	}

}
