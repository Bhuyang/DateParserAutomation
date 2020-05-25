package com.automation.pages.actions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[h3]/div")
	WebElement result;

	@FindBy(name = "date")
	WebElement dateTextBox;

	// <Summary>
	// Enter input date in date text box
	// </Summary>
	public WebElement enterDate() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(dateTextBox));
		return dateTextBox;
		
	}

	// <Summary>
	// Get time difference from system time to GMT.
	// </Summary>
	// <param name = "dateFormate">Input date format</param>
	// <param name = "inputDate">Actual entered date</param>
	// <return>System date and time with GMT time difference</return>
	public Date addInputDate(String dateFormate, String inputDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		sdf.setTimeZone(gmtTime);
		return sdf.parse(inputDate);

	}

	// <Summary>
	// Convert input date to expected format
	// </Summary>
	// <param name = "date">Formatted date</param>
	// <return>Input date in GMT format</return>
	public String converDateInGMT(Date date) {
		SimpleDateFormat print = new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zZ");
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		print.setTimeZone(gmtTime);
		return print.format(date);
	}

	// <Summary>
	// Get expected result
	// </Summary>
	public String getActualResult() throws InterruptedException {
		Thread.sleep(1500);
		return result.getText();

	}
}
