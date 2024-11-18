package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public void SwitchWindowToChild()
	{
		Set <String> s1= driver.getWindowHandles();
		Iterator <String> i1=s1.iterator();
		String parentWindow =i1.next();
		String childWindow=i1.next();
		driver.switchTo().window(childWindow);
		System.out.println("Switch to child window completed");
	}
	/*public void mouseHover() {
		//WebElement elem = driver.findElement(elem);
		Actions action = new Actions(driver);
		action.moveToElement(ele);

	}
	*/
}
