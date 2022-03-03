package nsdlUtilities;


import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;

public class OCR {

	public static void main(String[] args) {

		Tesseract object = new Tesseract();
		
		object.setDatapath("C:\\Users\\Bhushan\\eclipse-workspace\\KeywordDriven\\testdata\\");
		File input = new File("C:\\Users\\Bhushan\\eclipse-workspace\\KeywordDriven\\Screenshots\\kundanPin.png");
		
		try {
			String captcha = object.doOCR(input);
			System.out.println("Captcha text is : " +captcha);
		} catch (TesseractException e) {
			System.out.println("File OCR error");
			e.printStackTrace();
		}
		
	}

}
