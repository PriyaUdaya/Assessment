package com.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.javautils.Log4jProperties;

public class JpmHomePage {

	@FindBy(xpath="//header/div[3]/nav/div[1]/div/div/a/img")
	WebElement imgLogo;
	
	Boolean flag;
	WebDriver driver;
	WebDriverWait wait;
	public static Logger logger = Logger.getLogger(Log4jProperties.class.getName());	
	
	/***Initialize the page***/
	public JpmHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	/***Validate the logo displayed in the page***/
	public Boolean validateLogoAvailable(){
		try{
			imgLogo.isDisplayed();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(imgLogo));
			logger.info("Verify logo image is displayed");
			flag = true;
		}catch(NoSuchElementException elementException)
		{
			logger.error("NoSuchElement Exception occurred  Logo is not available");
			elementException.printStackTrace();
			flag = false;
		}catch(Exception e){
			logger.error("Exception occurred while validating logo");
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
