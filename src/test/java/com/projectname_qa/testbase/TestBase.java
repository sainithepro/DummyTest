package com.projectname_qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.projectname.reports.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ExtentManager{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws Exception {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\projectname_qa\\configurablefiles\\config.properties";
		FileInputStream ip = new FileInputStream(path);
		prop.load(ip);	
	}
	
	public static void initialize() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Browser does not exist");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
