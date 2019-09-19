package com.TestVegrant.core;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jna.Platform;

public class BaseDriver extends GenericFunctions {
	public static Properties GlobalVariables;
	public static GenericFunctions wa = new GenericFunctions();

	public static void GetDriver() {

		if (Platform.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (Platform.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (Platform.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/");
		System.out.println("++++++++++" + driver);

	}

	public static void StopDriver() {

		try {
			if (driver != null) {
				driver.close();
				driver.quit();
				driver = null;

			}
		} catch (Exception ignore) {
			System.out.println("Getting Exception while closing the driver: " + ignore);

		}

	}
}
