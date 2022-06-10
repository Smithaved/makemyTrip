package com.MakeMyTrip.GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver staticdriver;
	WebDriver driver;
	FileLibrary fileLibrary;
	JavaLibrary javaLibrary;
	WebDriverLibrary webDriverLibrary;
	long longTimeout;
	@BeforeSuite
	public void beforeSuite()
	{
		fileLibrary=new FileLibrary();
		fileLibrary.openPropertyFile(ExternalFilePath.PROPERTYFILEPATH);
		fileLibrary.openExcelFile(ExternalFilePath.EXCELFILEPATH);
	}
	@AfterSuite
	public void afterSuite()
	{
		fileLibrary.writeToExcel(ExternalFilePath.EXCELFILEPATH);
		fileLibrary.closeExcel();
	}
	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browser)
	{
		String url=fileLibrary.getPropertyValue("url");
		String timeout=fileLibrary.getPropertyValue("timeout");
		longTimeout=javaLibrary.convertToLong(timeout);
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		}
		staticdriver=driver;
		webDriverLibrary.launchApplication(driver, url);
		webDriverLibrary.maximizeBrowser(driver);
		webDriverLibrary.implicitWait(driver, longTimeout);
	}
	@AfterClass
	public void afterClass()
	{
		webDriverLibrary.closeApplication(driver);
	}
}
