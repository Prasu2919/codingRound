package com.TestVegrant.testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestVegrant.core.BaseDriver;
import com.TestVegrant.core.BaseTest;
import com.TestVegrant.core.GenericFunctions;
import com.TestVegrant.pages.signInPage;

public class SignInTest extends BaseTest {

	signInPage sp;

	@BeforeMethod
	public void b4TestMethod() {
		System.out.println("------------Befor Method Fired--------------");
		BaseDriver.GetDriver();
		GenericFunctions gf = new GenericFunctions();
		sp = new signInPage(gf.getDriver());
	}

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		System.out.println("-----------@Test Fired-------------");
		sp.openSignInBox();
		sp.clickSignIn();
		sp.verifyErrorOnPage("There were errors in your submission");
	}

}
