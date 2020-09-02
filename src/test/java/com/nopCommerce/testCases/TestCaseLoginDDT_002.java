package com.nopCommerce.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObject.LoginObjects;
import com.nopCommerce.utilities.*;

public class TestCaseLoginDDT_002 extends BaseTest {

	@Test(dataProvider="LoginData")
	public void logIn(String user,String password) throws IOException {
		
//		logger = Logger.getLogger("nopECommerce");
//		PropertyConfigurator.configure("Log4j.properties");
		
		String title = "Dashboard / nopCommerce administration";
		
		
//		System.setProperty("webdriver.chrome.driver", "C://HCL//Java//Drivers//chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.get("https://admin-demo.nopcommerce.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LoginObjects loginObjects = new LoginObjects(driver);
		loginObjects.setTxtEmail(username);
		loginObjects.setTxtpwd(password);
		loginObjects.setBtnLogin();
		if(driver.getTitle().equals(title)) {
			logger.info("Login Page :Login Successful");
			loginObjects.setLnkLogOut();
			Assert.assertTrue(true);
				 
		}else {
			captureScreen(driver, "loginTest");
			logger.info("Login Page :Login fail");
			
			Assert.assertTrue(false);
			 
		}
		
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopCommerce/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",0);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
	
}
