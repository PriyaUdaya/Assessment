package com.stepdefinition.steps;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.pageobjects.pages.JpmHomePage;
import com.javautils.Log4jProperties;
import com.pageobjects.pages.GoogelSearchPage;
import com.webdriverutils.DriverSetup;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GoogleSearchStepDefs extends DriverSetup{

	WebDriver driver;
	public static Logger logger = Logger.getLogger(Log4jProperties.class.getName());

	GoogelSearchPage searchPage;
	JpmHomePage resultPage;
	
	@Before
	public void setUP(){
		logger.info("Starting execution....");
	}
	
	
	@Given("^user navigate to application$")
	public void navigateToApplication(){
		DriverSetup ds = new DriverSetup();
		driver = ds.getDriver();		
	}
	
	@When("^user enter given (.*) and click on Search button$")
	public void performSearch(String text){
		try{
			searchPage = new GoogelSearchPage(driver);			
			Assert.assertTrue("Search UnSuccessful", searchPage.searchGivenData(text));
		}catch(Exception e){
			logger.error("Exception occurred while search");
			Assert.assertTrue("Search Unsuccessful", false);			
			e.printStackTrace();
		}		
	}	
	
	@Then("^click on the link$")
	public void clickResult(){
		try{
			searchPage = new GoogelSearchPage(driver);
			Assert.assertTrue("Click UnSuccessful", searchPage.clickLink());
		}catch(Exception e){
			logger.error("Exception occurred while clicking the link");
			Assert.assertTrue("Click UnSuccessful", false);
			e.printStackTrace();
		}
	}
	
	@Then("^verify the logo displayed$")
	public void verifyLogo(){
		try{
			resultPage = new JpmHomePage(driver);
			Assert.assertTrue("Logo Unavailable", resultPage.validateLogoAvailable());
		}catch(NoSuchElementException elementException)
		{
			logger.error("Exception occurred while verifying logo and image is not displayed");
			Assert.assertTrue("Logo Unavailable", false);
			elementException.printStackTrace();
		}catch(Exception e){
			logger.error("Exception occurred while verifying logo and image is not displayed");
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown(){
		driver.close();
	}

	
}
