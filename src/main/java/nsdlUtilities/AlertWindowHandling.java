package nsdlUtilities;

import org.openqa.selenium.Alert;

import nsdlKeyword.NSDLUtils;

public class AlertWindowHandling extends NSDLUtils {

	public static void alertHandling(String locatorType) {

		Alert alert = driver.switchTo().alert();

		if (locatorType.equalsIgnoreCase("Accept")) {
			alert.accept();
			System.out.println("Alert is Accepted");
			
		} else if (locatorType.equalsIgnoreCase("Dismiss")) {
			alert.dismiss();
			System.out.println("Alert is Dismissed");
			
		} else if(locatorType.equalsIgnoreCase("getText"))
		{
			System.out.println("Text Message of Alert is : "+alert.getText());
		} else 
		{
			alert.sendKeys(locatorType);
			System.out.println("Input taken by alert window");
		}

	}

}
