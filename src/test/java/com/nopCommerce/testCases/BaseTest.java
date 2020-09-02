package com.nopCommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.nopCommerce.utilities.ReadConfig;

public class BaseTest {
	
	ReadConfig readConfig = new ReadConfig();
	
	public static Logger logger;
	public static WebDriver driver;
	public String baseURL=readConfig.getApplicationUrl();
	public String username=readConfig.getUserEmail();
	public String password=readConfig.getPassword();
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		logger = Logger.getLogger("nopECommerce");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("SetUp method : Going to read browser details");
		
		System.out.println("base url is" + baseURL);
		System.out.println("useremail is" + username);
		System.out.println("password is" + password);
		
		if(browser.equals("chrome")) {
			
			System.getProperty("webdriver.chrome.driver", readConfig.getChromePath() );
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath() );
			driver = new ChromeDriver();
			
		}else if(browser.equals("fireFox")) {
			System.getProperty("webdriver.gecko.driver", readConfig.getFireFoxPath() );
			driver = new FirefoxDriver();
		}else if(browser.equals("ie")) {
			System.getProperty("webdriver.ie.driver", readConfig.getFireFoxPath() );
			driver = new InternetExplorerDriver();
		}
		logger.info("Try to open URL");
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL open window maximized");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
