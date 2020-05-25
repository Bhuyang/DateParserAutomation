package com.automation.testcases;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.base;
import com.automation.pages.actions.Home;
import com.automation.resources.Utilities;

public class DateValidator extends base{

	private WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
		 log.info("Driver is initialized");
	}

	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void validDateInputChecker(HashMap<String,String> data) throws ParseException, InterruptedException {
		// Arrange
		if(data.get("runmode").equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test as the Run mode is NO");	
		}
			
		Home home = new Home(driver);
		Date enteredDate = home.addInputDate(data.get("DateFormat"), data.get("Date"));

		// Act
		home.enterDate().sendKeys(data.get("Date"));
		home.enterDate().submit();
		String expectedResult = home.converDateInGMT(enteredDate);
		String actualResult = home.getActualResult();

		// Assert
		Assert.assertEquals(actualResult, expectedResult, "Invalid input date");
		log.info("validDateInputChecker Method Executed");

	}
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void inValidDateInputChecker(HashMap<String, String> data) throws ParseException, InterruptedException {
		// Arrange
		if(data.get("runmode").equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test as the Run mode is NO");	
		}
		Home home = new Home(driver);

		// Act
		home.enterDate().sendKeys(data.get("InputData"));
		home.enterDate().submit();
		String expectedResult = "Invalid date";
		String actualResult = home.getActualResult();

		// Assert
		Assert.assertEquals(actualResult, expectedResult, "Invalid input date");
		log.info("inValidDateInputChecker Method Executed");

	}
	
	
	@AfterTest
	public void afterMethod() {
		driver.quit();
	}

}
