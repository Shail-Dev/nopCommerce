package com.nopCommerce.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObject.LoginObjects;

public class TestCaseLoginPage_001 extends BaseTest  {
	
	
	@Test
	public void logIn() throws IOException {
		
		//setUp("chrome");
//		logger = Logger.getLogger("nopECommerce");
//		PropertyConfigurator.configure("Log4j.properties");
//		
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
		
		//checking test case status
		if(driver.getTitle().equals(title)) {
			logger.info("Login Page :Login Successful");
			loginObjects.setLnkLogOut();
			Assert.assertTrue(true);
				 
		}else {
			logger.info("Login Page :Login fail");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			
		}
		
		
		
	}

}
