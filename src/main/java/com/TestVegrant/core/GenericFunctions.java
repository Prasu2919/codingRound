package com.TestVegrant.core;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class GenericFunctions {

	public static int StepNumber;
	static public WebDriver driver = null;
	WebElement element;

	public static void settDriver(WebDriver driver) {
		GenericFunctions.driver = driver;
	}

	public WebDriver getDriver() {
		return GenericFunctions.driver;
	}

	public void click(WebElement locator) {

		locator.click();
	}

	public void setTextBoxValue(WebElement element, String textToInput) {

		element.clear();
		element.sendKeys(textToInput);
		BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>", textToInput
				+ " has been entered in text box : " + "<b>" + element + "</b> " + "</b> " + "   successfully.");

	}

	public String getCurrentTime() {
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String currentTime = df.format(dt);
		return currentTime;

	}

	public void takeScreenShot(String folderPath, String methodName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			File file = new File(folderPath + "//snapshots");
			if (file.exists() == false) {

				file.mkdir();
			}
			folderPath = folderPath + "//snapshots";
			methodName = getTimeStamp() + methodName;
			FileUtils.copyFile(scrFile, new File(folderPath + "\\" + methodName + ".png"));
			System.out.println("***Placed screen shot ***");
			BaseTest.test.log(LogStatus.FAIL,
					"Screencast below: " + BaseTest.test.addScreenCapture("snapshots" + "\\" + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yy-HH_mm_ss");
		return sdf.format(new Date());
	}

	public void selectByValue(WebElement locatorName, String value) {
		new Select(locatorName).selectByValue(value);
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
