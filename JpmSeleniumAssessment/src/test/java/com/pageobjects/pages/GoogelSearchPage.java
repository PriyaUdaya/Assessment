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

public class GoogelSearchPage{

	@FindBy(name ="q")
	WebElement searchField;

	@FindBy(xpath ="//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]")
	WebElement search;

	@FindBy(xpath="//*[@id='rso']/div[1]/div/div/div/div[1]/a")
	WebElement txtLink;	

	WebDriver driver;
	WebDriverWait wait;
	public static Logger logger = Logger.getLogger(Log4jProperties.class.getName());
	Boolean flag;

	/***Initialize the page***/
	public GoogelSearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	/***Enter the given search text and click search***/
	public boolean searchGivenData(String text){
		try{
			searchField.click();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(searchField));
			logger.info("Click on SearchText area");
			searchField.sendKeys(text);
			searchField.sendKeys("\n");
			wait.until(ExpectedConditions.visibilityOf(searchField));
			logger.info("Enter given data and hit search button");
			flag =  true;
		}catch(NoSuchElementException elementException)
		{
			logger.error("NoSuchElementException occurred upon search");			
			elementException.printStackTrace();
			flag =  false;
		}catch(Exception e){
			logger.error("Exception occurred upon search");
			e.printStackTrace();
			flag =  false;
		}
		return flag;
	}	

	/***Click on 1st search result***/
	public boolean clickLink(){
		try{	
			txtLink.click();		
			logger.info("Click on the first result");			
			flag =  true;
		}catch(NoSuchElementException elementException)
		{
			logger.error("NoSuchElementException Exception occurred while clicking the link");
			elementException.printStackTrace();
			flag = false;
		}catch(Exception e){
			logger.error("Exception occurred while clicking the link");
			e.printStackTrace();
			flag =  false;
		}
		return flag;
	}
}
