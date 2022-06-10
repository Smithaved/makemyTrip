package com.MakeMyTrip.GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverLibrary {
	
	public void launchApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	public void closeApplication(WebDriver driver)
	{
		driver.quit();
	}
	
	public void implicitWait(WebDriver driver, long longtimeout)
	{
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}
	
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public String takeScreenshot(WebDriver driver, String fileName, JavaLibrary javaLibrary)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dateTime=javaLibrary.dateFormat();
		File dst=new File("./screenshot/"+fileName+"_"+dateTime+".png");
	    try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Eroor while coping the file from source to destination");
		}
	    return dst.getAbsolutePath();
	}
}
