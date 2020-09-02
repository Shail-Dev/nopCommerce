package com.nopCommerce.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.nopCommerce.pageObject.AddCustomerObjects;
import com.nopCommerce.pageObject.LoginObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseAddNewCustomer_003 extends BaseTest {
	
	
	
@Test
	public void addNewCustomer() throws IOException, InterruptedException
	
	{
		
//		logger = Logger.getLogger("nopECommerce");
//		PropertyConfigurator.configure("Log4j.properties");
//		
//		System.setProperty("webdriver.chrome.driver", "C://HCL//Java//Drivers//chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.get("https://admin-demo.nopcommerce.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LoginObjects loginObjects = new LoginObjects(driver);
		
		loginObjects.setTxtEmail(username);
		loginObjects.setTxtpwd(password);
		loginObjects.setBtnLogin();
		
		logger.info("providing customer details....");
		
		AddCustomerObjects addCus = new AddCustomerObjects(driver);
		
		addCus.setLnkMainCustomer();
		
		
		addCus.setLnkCustomer();
		
		addCus.setLnkAddNew();
		
		logger.info("Add New Customer button click");
		
		Thread.sleep(3000);
		
		String email = randomestring() + "@gmail.com";
		addCus.setTxtAddCustomerEmail(email);
		
		logger.info("Email id added");
				
		addCus.setTxtAddCustomerPassword("test123");
		
		logger.info("Password entered");
		
		addCus.setTxtAddCustomerFirstName("Tara");
		addCus.setTxtAddCustomerLastName("Kumari");
		
		logger.info("Name added");
		
		addCus.setRdoAddCustomerFemaleGender();
		
		addCus.setdateDOB("12/12/1980");
		
		logger.info("Gender and DOB added");
		
		addCus.setTxtAddCustomerCompanyName("busyQA");
		
		addCus.setChkAddCustomerTax();
		
		//Thread.sleep(50000);
		
		logger.info("Company Name and Tax details added");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)","");
		
		Thread.sleep(30000);

		//addCus.setLstitemGuests();
		
		//addCus.setLstitemVendors("Vendor 2");
		
		//logger.info("Roles and Vendor added");
		
		addCus.setSaveButton();
		
		logger.info("Save button clicked");
		
		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
				
	}

}
