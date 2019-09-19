package com.TestVegrant.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestVegrant.core.GenericFunctions;

public class FlightBookingPage {

	WebDriver driver;
	GenericFunctions gf = new GenericFunctions();

	@FindBy(xpath = "//div[@class='row content']/aside//a[@href='/flights']")
	private WebElement flightLink;

	@FindBy(id = "OneWay")
	private WebElement tripType;

	@FindBy(id = "FromTag")
	private WebElement source;

	@FindBy(id = "ToTag")
	private WebElement destination;

	@FindBys(@FindBy(xpath = "//*[@id='ui-id-1']/li/a"))
	private List<WebElement> originOptions;

	@FindBys(@FindBy(xpath = "//*[@id='ui-id-2']/li/a"))
	private List<WebElement> destinationOption;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[7]/a")
	private WebElement datePicker;

	@FindBy(id = "SearchBtn")
	private WebElement searchBtn;

	@FindBy(className = "searchSummary")
	public WebElement searchSummary;

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectTripType() {
		gf.click(tripType);
	}

	public void enterSource(String str) {
		gf.setTextBoxValue(source, str);
		gf.waitForElement(originOptions.get(0));
		gf.click(originOptions.get(0));

	}

	public void enterDestination(String str) {
		gf.setTextBoxValue(destination, str);
		gf.waitForElement(destinationOption.get(0));
		gf.click(destinationOption.get(0));
	}

	public void selectTripDate() {
		gf.click(datePicker);

	}

	public void searchFlight() {
		gf.click(searchBtn);
	}

	public void verifySearchResult() {
		Assert.assertTrue(searchSummary.isDisplayed());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickFlight() {
		gf.click(flightLink);

	}
}
