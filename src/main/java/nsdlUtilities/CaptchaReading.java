package nsdlUtilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import nsdlKeyword.NSDLUtils;

public class CaptchaReading extends NSDLUtils {

	static Tesseract readCharacter;
	static String[] myarray;
	static String mydata;
	static String captchaString;

	public static void ocrCaptcha() throws IOException, TesseractException, InterruptedException
	{
		readCharacter = new Tesseract();
		readCharacter.setDatapath("C:\\Users\\Bhushan\\eclipse-workspace\\KeywordDriven\\testdata\\");
		
		TakesScreenshot ss = (TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		Files.move(file, new File("C:\\Users\\Bhushan\\eclipse-workspace\\KeywordDriven\\Screenshots\\SS.png"));
		Thread.sleep(3000);
		
		try {
		String captchaString = readCharacter.doOCR(new File("C:\\Users\\Bhushan\\eclipse-workspace\\KeywordDriven\\Screenshots\\SS.png"));
//		String captchaString = readCharacter.doOCR(file);
		System.out.println("Read captcha string is : " +captchaString);
		
		myarray = captchaString.split("Captcha Code *");
		System.out.println(myarray[1]);
		
		mydata = myarray[1].replaceAll("[a-zA-Z0-9]", "");
		System.out.println(mydata);
	}		
		catch(TesseractException e)
	{
		System.out.println("OCR exception occurred");
		e.printStackTrace();
	}
//		return captchaString;
		
	}
}
