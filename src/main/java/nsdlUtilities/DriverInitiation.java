package nsdlUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import nsdlKeyword.NSDLUtils;

public class DriverInitiation extends NSDLUtils{

	
	public static void driverInitiations(String browserType)
	{
		if(browserType.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
			
			System.out.println("\n ***** Chrome Browser will be Lauched *****"); 
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(inputData);
		}
		else if(browserType.equalsIgnoreCase("IE"))
		{
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");
			System.setProperty("webdriver.ie.driver", "C:\\Automation\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			
			System.out.println("\\n ***** IE Browser will be Lauched *****");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(inputData);
		}
		else
		{
			System.out.println("\\n ***** No Browser Type is Found *****");
		}
	}
	
}
