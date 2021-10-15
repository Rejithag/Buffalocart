package com.buffalocart.automationcore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.buffalocart.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public static Properties proper;

	public Base()  {

		FileReader f = null;
		try {
			f = new FileReader(System.getProperty("user.dir") + Constants.CONFIGFILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proper = new Properties();
		try {
			proper.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void testIntialize(String browsername, String url) throws Exception {
		if (browsername.equals("chrome")) {

			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid browsername");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	
	
	
	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browser") public void setUp(String browserName) throws Exception
	 * { String browsername = browserName; String url = proper.getProperty("url");
	 * testIntialize(browsername, url); }
	 */
	 

	
	@BeforeMethod
	public void setUp() throws Exception

	{
		String browser = proper.getProperty("browser");
		String url = proper.getProperty("url");
		testIntialize(browser, url);
	}
	 
	 
	@AfterMethod
	public void teardowm(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
		}

		driver.close();

	}

	

}
