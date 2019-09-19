package com.TestVegrant.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.TestVegrant.core.GenericFunctions;

public class HotelPage {

	WebDriver driver;
	GenericFunctions gf = new GenericFunctions();
	@FindBy(xpath = "//div[@class='row content']/aside//a[@href='/hotels']")
	private WebElement hotelLink;

	@FindBy(xpath = "//input[@id='Tags']")
	private WebElement localityTextBox;

	@FindBys(@FindBy(xpath = "//li[@class='list']/a"))
	private List<WebElement> suggestList;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	public HotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickHotel() {
		System.out.println("*********" + gf.getDriver());
		gf.click(hotelLink);
	}

	public void selectHotellocation(String searchText) {
		gf.setTextBoxValue(localityTextBox, searchText);
		gf.waitForElement(suggestList.get(0));
		gf.click(suggestList.get(0));

	}

	public void selectTravellers(String value) {
		gf.selectByValue(travellerSelection, value);

	}

	public void clickSearchBtn() {
		System.out.println("*********" + gf.getDriver());
		gf.click(searchButton);
	}

}
