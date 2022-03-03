package nsdlUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import nsdlKeyword.NSDLUtils;

public class ScrollWindowHandling extends NSDLUtils {
	
	private static JavascriptExecutor je = (JavascriptExecutor)driver;
	private static String newElement = NSDLUtils.element;
	
	public static void scrollBody(String scrollType)
	{
		if(scrollType.equalsIgnoreCase("Down"))
		{
			je.executeScript("window.scrollBy(0,600)");
		}
		else if(scrollType.equalsIgnoreCase("Body"))
		{
			je.executeScript("scroll(0, document.body.scrollHeight)");
		}
		else if(scrollType.equalsIgnoreCase("Key"))
		{
			WebElement locElement = driver.findElement(By.xpath(newElement));
			je.executeScript("arguments[0].scrollIntoView();", locElement);
		}
		else if(scrollType.equalsIgnoreCase("Horizontal"))
		{
			je.executeScript("window.scrollBy(600,0)");
		}
		else if(scrollType.equalsIgnoreCase("Up"))
		{
			je.executeScript("window.scrollBy(0,-600)");
		}
		else
		{
			System.out.println("No Scroll Method Found..");
		}
	}

}
