package com.TestVegrant.testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestVegrant.core.BaseDriver;
import com.TestVegrant.core.BaseTest;
import com.TestVegrant.core.GenericFunctions;
import com.TestVegrant.pages.HotelPage;

public class HotelBookingTest extends BaseTest {
	HotelPage hp;

	@BeforeMethod
	public void b4TestMethod() {
		System.out.println("------------Befor Method Fired--------------");
		BaseDriver.GetDriver();
		GenericFunctions gf = new GenericFunctions();
		hp = new HotelPage(gf.getDriver());
	}

	@Test
	public void shouldBeAbleToSearchForHotels() {
		System.out.println("------------@Test Fired--------------");
		hp.clickHotel();
		hp.selectHotellocation("Indiranagar, Bangalore");
		hp.selectTravellers("1");
		hp.clickSearchBtn();

	}

}
