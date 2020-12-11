package base;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import jdk.internal.org.jline.utils.Log;
import utilities.ExcelReader;

public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger Log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() throws IOException {

		if(driver==null) {  
	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
	config.load(fis);
	Log.debug("Congfig file loaded!!");
	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	OR.load(fis);
	Log.debug("Object Repository file loaded!!");
	}
	
	if(config.getProperty("browser").equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajeev\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.debug("Chrome launched");
			
	}
	driver.get(config.getProperty("url"));
	Log.debug("Hitted the url"+" "+"http://www.way2automation.com/angularjs-protractor/banking/#/login");
	driver.manage().window().maximize();
	Log.debug("Window maximized");
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	wait = new WebDriverWait(driver,5);
	
	}
	
	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destnfile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destnfile));
		return destnfile;
	}
	
	
	
	
	@AfterSuite
	public void tearDown() {
if(driver!=null)
{
		driver.close();
		
	}
Log.debug("Test execution completed");

	}
}
