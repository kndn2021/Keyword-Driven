package nsdlUtilities;

import org.openqa.selenium.WebDriver;

import nsdlKeyword.NSDLUtils;

public class NavigationTest extends NSDLUtils {

	static WebDriver.Navigation navigate;
	
	public static void navigations(String navigateType)
	{
		navigate = driver.navigate();
		
		if(navigateType.equalsIgnoreCase("Refresh"))
		{
			navigate.refresh();
		}
		
		else if(navigateType.equalsIgnoreCase("Forward"))
		{
			navigate.forward();
		}
		
		else if(navigateType.equalsIgnoreCase("Back"))
		{
			navigate.back();
		}
		
		else if(navigateType.equalsIgnoreCase("URL"))
		{
			navigate.to(inputData);
			System.out.println("Navigate to URL : " +inputData);
		}
		
		else
		{
			System.out.println("No Navigation Method Found.");
		}
		
	}
}
