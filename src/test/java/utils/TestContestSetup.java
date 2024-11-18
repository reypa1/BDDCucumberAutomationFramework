package utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContestSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContestSetup() throws Exception
	{
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
		genericUtils=new GenericUtils(testBase.WebDriverManager());
	}
}
