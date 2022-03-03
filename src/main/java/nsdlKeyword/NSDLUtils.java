package nsdlKeyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.sourceforge.tess4j.TesseractException;
import nsdlUtilities.AlertWindowHandling;
import nsdlUtilities.CaptchaReading;
import nsdlUtilities.DriverInitiation;
import nsdlUtilities.MouseKeyboardEvents;
import nsdlUtilities.NavigationTest;
import nsdlUtilities.ScrollWindowHandling;
import nsdlUtilities.ThreadTime;

public class NSDLUtils {

	public static WebDriver driver;
	static FileInputStream fileInput;
	static Workbook book;
	static Sheet sheet;
	static FileOutputStream fileOutput;

	public static String action;
	public static String locator;
	public static String element;
	public static String inputData;
	public static String captcha;
	public static String result;

	public static void fetchExcelData() {

		String excelPath = "C:\\Users\\Bhushan\\Desktop\\KundanKey.xlsx";
		try {
			fileInput = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("File is not available on path.");
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fileInput);
		} catch (EncryptedDocumentException e) {
			System.out.println("Workbook not created due to encrypted document.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Workbook input output error.");
			e.printStackTrace();
		}

		sheet = book.getSheet("Sheet1");
		
		try {
			fileOutput = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e1) {
			System.out.println("Excel file not able to write.");
			e1.printStackTrace();
		}

		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			int j = 0;
			action = sheet.getRow(i + 1).getCell(j).toString().trim();
			locator = sheet.getRow(i + 1).getCell(j + 1).toString().trim();
			element = sheet.getRow(i + 1).getCell(j + 2).toString().trim();
			inputData = sheet.getRow(i + 1).getCell(j + 3).toString().trim();
//			result = sheet.getRow(i + 1).getCell(j + 4).toString().trim();

			switch (action) {
			case "OpenBrowser":
				DriverInitiation.driverInitiations(locator);
				break;

			case "EnterData":
				locatorHandling();
				break;

			case "Click":
				locatorHandling();
				break;

			case "Scroll":
				ScrollWindowHandling.scrollBody(locator);
				break;

			case "Alert":
				AlertWindowHandling.alertHandling(locator);
				break;

			case "Thread":
				ThreadTime.threadTime();
				break;
				
			case "Navigation":
				NavigationTest.navigations(locator);
				break;
				
			case "DragAndDrop":
				MouseKeyboardEvents.dragAndDropEvent();
				break;

			case "Captcha":
				try {
					CaptchaReading.ocrCaptcha();
					// locatorHandling();
				} catch (IOException | InterruptedException | TesseractException e) {
					System.out.println("Captcha reading error");
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("No action found in sheet");
				break;
			}
		}
	}
	
	public static void locatorHandling() 
	{
		switch (locator) {
		case "id":
			if (action.equalsIgnoreCase("EnterData")) {
				driver.findElement(By.id(element)).sendKeys(inputData);
			} else if (action.equalsIgnoreCase("Click")) {
				driver.findElement(By.id(element)).click();

			} else if (action.equalsIgnoreCase("Captcha")) {
				driver.findElement(By.id(element)).sendKeys(captcha);

			} else {
				System.out.println("id is not found in code as per sheet");
			}
			break;

		case "name":
			if (action.equalsIgnoreCase("EnterData")) {
				driver.findElement(By.name(element)).sendKeys(inputData);

			} else if (action.equalsIgnoreCase("Click")) {
				driver.findElement(By.name(element)).click();

			} else if (action.equalsIgnoreCase("Captcha")) {
				driver.findElement(By.name(element)).sendKeys(captcha);

			} else {
				System.out.println("name is not found in code as per sheet");
			}
			break;

		case "xpath":
			if (action.equalsIgnoreCase("EnterData")) {
				driver.findElement(By.xpath(element)).sendKeys(inputData);

			} else if (action.equalsIgnoreCase("Click")) {
				driver.findElement(By.xpath(element)).click();

			} else if (action.equalsIgnoreCase("Captcha")) {
				driver.findElement(By.xpath(element)).sendKeys(captcha);

			} else {
				System.out.println("xpath is not found in code as per sheet");
			}
			break;

		default:
			System.out.println("No id type found of sheet");
			break;
		}
	}
	
//
//	public void quitBrowser() {
//		driver.quit();
//	}

}
