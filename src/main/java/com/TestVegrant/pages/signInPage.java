package com.TestVegrant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestVegrant.core.GenericFunctions;

public class signInPage {

	WebDriver driver;

	GenericFunctions gf = new GenericFunctions();

	@FindBy(linkText = "Your trips")
	private WebElement yourtrip;

	@FindBy(id = "SignIn")
	private WebElement signIn;

	@FindBy(id = "signInButton")
	private WebElement signInBtn;

	@FindBy(id = "errors1")
	private WebElement error;

	public signInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openSignInBox() {
		gf.click(yourtrip);
		gf.click(signIn);
	}

	public void clickSignIn() {
		driver.switchTo().frame("modal_window");
		gf.click(signInBtn);
	}

	public void verifyErrorOnPage(String errorText) {
		Assert.assertTrue(error.getText().contains(errorText));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
