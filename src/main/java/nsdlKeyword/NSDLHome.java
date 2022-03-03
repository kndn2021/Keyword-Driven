package nsdlKeyword;

import org.testng.annotations.Test;

public class NSDLHome {

	NSDLUtils utilsData = new NSDLUtils();

	@Test
	public void updateData() {

		utilsData.fetchExcelData();
		
	}
//	
//	@AfterMethod
//	public void tearUp()
//	{
//		utilsData.quitBrowser();
//	}

}
