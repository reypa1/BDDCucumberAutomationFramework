package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",monochrome=true,
plugin= {"html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		})

public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests
{
@Override
@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();  //it will call parent class which is having to excute all screnarios in parallel
	}
	
}
