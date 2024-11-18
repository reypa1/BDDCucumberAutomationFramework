package stepDefinitions;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContestSetup;

public class Hooks {
	TestContestSetup testContestSetup;
	
	public Hooks(TestContestSetup testContestSetup)
	{
		this.testContestSetup=testContestSetup;
	}
	
	@After
	public void AfterScenario() throws IOException, Exception 
	{
		
		testContestSetup.testBase.WebDriverManager().quit();
		System.out.println("Browser Closed");
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException, Exception 
	{
		WebDriver driver=testContestSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			File srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(srcPath);
			scenario.attach(fileContent, "image/png", "image");
			
		}
	}

	
}
