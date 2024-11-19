package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.AutomationPageObjects;
import PageObjects.CheckoutPageObjects;
import PageObjects.LandingPageObjects;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContestSetup;

public class AutomationStepDefinition {
	public WebDriver driver;
	AutomationPageObjects autoPage;
	TestContestSetup testContestSetup;

	public AutomationStepDefinition(TestContestSetup testContestSetup)
	{
		this.testContestSetup=testContestSetup;
		this.autoPage=testContestSetup.pageObjectManager.getAutomationPageObjects();
		
	}

	@Given("User landed on Automation Practise page")
	public void user_landed_on_automation_practise_page() 
	{
		System.out.println("Landed on Practise Page");
	}
	
	@When("^user selected (.+) Radio button$")
	public void user_selected_Radio_button(String name) throws Exception
	{
		autoPage.RadioButton(name);
		Thread.sleep(2000);
		
	}
	
	@When("^select (.+) from dropdown$")
	public void select_from_dropdown(String option) throws Exception 
	{
		autoPage.SelectDropdown(option);
		Thread.sleep(2000);
		
	}
    @When("^pick (.+) from Autosuggestion list$")
    public void pick_from_Autosuggestion_list(String value) throws Exception
    {
    	autoPage.AutoSuggestion(value);
    	Thread.sleep(2000);
    }
    
    @And("^check the box (.+) from list$")
    public void check_the_box_from_list(String checkboxname) throws Exception {
        autoPage.SelectCheckBox(checkboxname);
        System.out.println("Check Box selected");
        Thread.sleep(2000);
    }
    
    @And("^Enter the (.+) click on Alert button$")
    public void Enter_the_click_on_Alert_button(String Text) throws Exception
    {
    	autoPage.AlertPopUp(Text);
    	Thread.sleep(2000);
    }
    
    @And("click the window button")
    public void click_the_window_button() throws Exception
    {
    	autoPage.WindowHandles();
    	Thread.sleep(2000);
    }
  
    @And("click on show and hide buttons")
    public void click_on_show_and_hide_buttons() throws Exception
    {
    	autoPage.scrollView();
    	Thread.sleep(2000);
    	
    }

}
