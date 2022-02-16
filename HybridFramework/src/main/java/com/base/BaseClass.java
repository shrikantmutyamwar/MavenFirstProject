package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;

public class BaseClass {

	// this class should have all common code

	public static WebDriver driver = null;
	//initialize the logger...Logger is a class & getLogger is a static method..which return the object
    public static Logger log = Logger.getLogger("BaseClass"); 
    public static ExtentReports report = null;
    public static ExtentSparkReporter spark = null;
    public static ExtentTest test = null;
    
	public static void initialization() {
		log.info("Initializing the browser");   // it comes in console and in file with date and time
		String browser = PropertiesUtility.readproperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.get(PropertiesUtility.readproperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
//	public static void main(String[] args) {
//		initialization();
//	}
	
	// to initialize report
	public void reportInit(){
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");  //extent report generated in this dest. file path
		report.attachReporter(spark);      // attaching or connecting spark file in report object
		report.setSystemInfo("Shrikant", "JBK");
	}
	
	public String takeScreenShot(String name){
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		File dest = new File(path);
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
