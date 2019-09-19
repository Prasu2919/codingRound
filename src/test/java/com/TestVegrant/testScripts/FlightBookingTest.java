package com.TestVegrant.testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestVegrant.core.BaseDriver;
import com.TestVegrant.core.BaseTest;
import com.TestVegrant.core.GenericFunctions;
import com.TestVegrant.pages.FlightBookingPage;

public class FlightBookingTest extends BaseTest {

	FlightBookingPage fbp;

	@BeforeMethod
	public void b4TestMethod() {
		System.out.println("------------Befor Method Fired--------------");
		BaseDriver.GetDriver();
		GenericFunctions gf = new GenericFunctions();
		fbp = new FlightBookingPage(gf.getDriver());
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		System.out.println("----------@Test Fired------------");
		fbp.clickFlight();
		fbp.selectTripType();

		fbp.enterSource("Banglore");

		fbp.enterDestination("Delhi");

		fbp.selectTripDate();
		fbp.searchFlight();

		fbp.verifySearchResult();

	}

}
