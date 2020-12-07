package com.javautils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class SystemProperties {

	private static Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/src/test/resources/propertyfile/config.properties";

	public static Logger logger = Logger.getLogger(Log4jProperties.class.getName());
	
	public SystemProperties(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + propertyFilePath);
		} 
	}

	public String getDriverPath(String browserType){
		String driverPath=null;
		switch(browserType){
		case "chrome":
			driverPath= properties.getProperty("chromedriverPath");
			if(driverPath!= null){
				logger.info("Chrome driver path retrieved successfully");				
			}else throw new RuntimeException("Driver path not specified in the config.properties file.");
			break;
		case "firefox":
			driverPath = properties.getProperty("geckodriverPath");
			if(driverPath!= null){
				logger.info("Firefox driver path retrieved successfully");
			}else throw new RuntimeException("Driver path not specified in the config.properties file.");
			break;
		case "ie":
			driverPath = properties.getProperty("iedriverPath");
			if(driverPath!= null){
				logger.info("IE driver path retrieved successfully");
			}else throw new RuntimeException("Driver path not specified in the config.properties file.");
			break;
		default:
			throw new RuntimeException("Invalid browserType specified in the config.properties file.");
		}
		return System.getProperty("user.dir")+driverPath;
	}

	public String getBrowserType() {
		String browserType = properties.getProperty("browser");
		if(browserType != null){
			logger.info(browserType.toUpperCase()+" Browser is used for execution");
			return browserType;
		}else throw new RuntimeException("Browser type not specified in the config.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null){
			logger.info("Requested application URL is "+url); 
			return url;
		}else throw new RuntimeException("URL not specified in the config.properties file.");
	}
}
