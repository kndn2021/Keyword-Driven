package nsdlUtilities;

import java.util.ArrayList;
import java.util.Set;

import nsdlKeyword.NSDLUtils;

public class WindowHandling extends NSDLUtils {

	public void windowHandle()
	{
		int inputWindow = Integer.parseInt(inputData);
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> childWindow = driver.getWindowHandles();
		
		ArrayList<String> changeWindow = new ArrayList<String>(childWindow);
		
		driver.switchTo().window(changeWindow.get(inputWindow));
		
	}
	
	
	
}
