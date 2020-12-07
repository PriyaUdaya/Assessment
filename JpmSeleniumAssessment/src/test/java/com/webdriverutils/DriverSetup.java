package com.webdriverutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.javautils.SystemProperties;


public class DriverSetup {
	
		public static WebDriver driver;
		public static String baseUrl;
		public String browserStr;	

		/**** Fetch browser, url and driver path from config file****/
		public WebDriver getDriver() {			
			SystemProperties sp = new SystemProperties();
			baseUrl = sp.getApplicationUrl();
			browserStr = sp.getBrowserType();
		
			switch (browserStr) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", sp.getDriverPath(browserStr));
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", sp.getDriverPath(browserStr));
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver",sp.getDriverPath(browserStr));
				driver = new InternetExplorerDriver();
				break;
			default:
				throw new RuntimeException("broswertype is invalid");
			}
			 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			driver.navigate().to(baseUrl);
			  
			return driver;
	}

}

