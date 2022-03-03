package nsdlUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import nsdlKeyword.NSDLUtils;

public class MouseKeyboardEvents extends NSDLUtils {

	static Actions action = new Actions(driver);
	
	static WebElement source = driver.findElement(By.id(locator));
	static WebElement target = driver.findElement(By.id(element));
	
	public static void dragAndDropEvent()
	{
		action.dragAndDrop(source, target).build().perform();
	}
	
	public static void doubleClick()
	{
		action.doubleClick(source).build().perform();
	}
	
	public static void rightClick()
	{
		action.contextClick(source).build().perform();
	}
	
	public static void moveElement()
	{
		action.moveToElement(source).build().perform();
	}
	
}
