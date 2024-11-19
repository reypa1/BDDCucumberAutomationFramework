package PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;

public class AutomationPageObjects {
	public WebDriver driver;
	public Select s;
	String country="Ind";
	
	

	public AutomationPageObjects(WebDriver driver) {
		this.driver = driver;
		s=new Select(driver.findElement(Dropdown));
		
	}

	//By Radio = By.xpath("//input[@value='radio2']");
	By RadioBtn=By.xpath("//input[@name='radioButton']");
	By Dropdown=By.xpath("//select[@id='dropdown-class-example']");
	By autosug=By.xpath("//input[@id='autocomplete']");
	By CountrySel=By.xpath("//li[@class='ui-menu-item']");
	By CheckBox=By.xpath("//input[@type='checkbox']");
	By EnterText=By.xpath("//input[@name='enter-name']");
	By AlertButton=By.xpath("//input[@id='alertbtn']");
	By windowbutton=By.xpath("//button[@id='openwindow']");
	By Hidebutton=By.xpath("//input[@id='hide-textbox']");
	By InputBox=By.xpath("//input[@id='displayed-text']");
	By ShowButton=By.xpath("//input[@name='show-hide']");
	By Header=By.xpath("//legend[text()='Web Table Fixed header']");

	//Radio Button
	public void RadioButton(String name) {

		try{
			//driver.findElement(Radio).click();
			List <WebElement> rbutton = driver.findElements(RadioBtn);
			for(WebElement radiobutton:rbutton)
			{
				if(radiobutton.getAttribute("value").equalsIgnoreCase(name))
				{
					radiobutton.click();
				}
				
			}
			System.out.println("Successfully selected radio button");
		}
		catch(Exception e)
		{
			System.out.println("Unable to find the radio buton based on label");
		}

	}

//dropdown
	public void SelectDropdown(String option)
	{
		try {
	    s.selectByVisibleText(option);
		System.out.println("selected dropdown succesfull");
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to find the dropdown based on label");
		}
	}
   //Autosuggestion list 
	public void AutoSuggestion(String value) throws Exception
	{
		/*before doing auto suggestion pass the value into textbox suggetstion display in inspect section rightside click 
		on EventListeners-->blur-->removeit all-->now u can see all hidden elements to find xpath of expected*/
		
		driver.findElement(autosug).sendKeys(country);
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(10) );
		List<WebElement>suggestions=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CountrySel));
		for(WebElement autosug:suggestions)
		{
			if(autosug.getText().equals(value))
			{   
				System.out.println("Before Auto Suggestion success");
				 autosug.click();  
			}
			
		}
		System.out.println("After Auto Suggestion clicked success");
	}
	//checkbox	
	public void SelectCheckBox(String checkboxname)	
	{
		List<WebElement> checks =driver.findElements(CheckBox);
		for(WebElement checkbox:checks)
		{
			if(checkbox.getAttribute("value").equalsIgnoreCase(checkboxname))
			{
			  checkbox.click();
		     }
	}
		System.out.println("Checkbox clicked successfully");
		
		
	}
	
//Alerts
	public void AlertHandleAccept()
	{
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
	}
    
	public void AlertPopUp(String Text) throws Exception
	{
		driver.findElement(EnterText).sendKeys(Text);
		System.out.println("Entered text success");
		driver.findElement(AlertButton).click();
		System.out.println("Alert Button clicked success");
		Thread.sleep(1000);
		AlertHandleAccept();
		System.out.println("Alert handled success");
		
	}
	
	public void WindowHandles() throws Exception
	{
		driver.findElement(windowbutton).click();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		String Parent=i1.next();
		String child=i1.next();
		driver.switchTo().window(child);
		String childtitle=driver.getTitle();
		System.out.println(childtitle);
		driver.switchTo().window(Parent);
		String Parenttitle=driver.getTitle();
		System.out.println("landed in" +Parenttitle);
		Thread.sleep(2000);
	}
	public void scrollView()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Header);
		
		System.out.println("Scroll successfull");
	}
	
	public void ShowAndHide() throws Exception
	{
		driver.findElement(Hidebutton).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.display = 'none';", InputBox);
		Thread.sleep(1000);
		System.out.println("Show button hided");
		driver.findElement(ShowButton).click();
		js.executeScript("arguments[0].style.display='block';",InputBox);
		Thread.sleep(1000);
		driver.findElement(InputBox).sendKeys("veena");
	}

}


/*JavascriptExecutor js=(JavascriptExecutor)driver;
String script="return document.getElementById(\"autocomplete\").value;";
String text=(String) js.executeScript(script);
System.out.println(text);*/
