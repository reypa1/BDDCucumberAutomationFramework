package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException, Exception 
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties ");
		Properties prop = new Properties();
		prop.load(fis);
		String URL= prop.getProperty("PractiseUrl");
		String Browser=prop.getProperty("browser"); //it will get properties from properties file
		String Browser_Mvn=System.getProperty("browser");// it will be usefull for maven to run commands 
		
		String mavenBrowser=Browser_Mvn!=null?Browser_Mvn:Browser;
		
		if(driver == null) {
			if(Browser.equalsIgnoreCase("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.acceptInsecureCerts();
			capabilities.setAcceptInsecureCerts(false);
			driver=new ChromeDriver();
			}
			if(Browser.equalsIgnoreCase("firefox"))
			{
				//firefoxcode
			}
			
			driver.get(URL);
			System.out.println("Provided URL loaded successfully"); 
			driver.manage().window().maximize();
			System.out.println("Browser Maximized successfully");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		return driver;		
	}
}
