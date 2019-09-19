
package com.TestVegrant.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	protected static ExtentReports extent;
	String startClassTime, endClassTime, duration;
	public static String testcaseName;
	static GenericFunctions baseobj = new GenericFunctions();
	static public ExtentTest test;
	public static String testCaseName;
	public static String classResult = "Pass";

	public static int iterationCounter;
	public static String testStep = "";
	static String testMethodName;
	public static String folderPath;

	@BeforeSuite
	public void beforeSuite() throws IOException {

		String ts = GenericFunctions.getTimeStamp();
		String resultFoler = "Automation_Reports";
		String resultFilePath = System.getProperty("user.dir") + "\\" + resultFoler;
		resultFoler = createFolder(resultFilePath);
		folderPath = resultFoler + "\\" + ts + "_ExecutionReport";
		folderPath = createFolder(folderPath);
		String extentReportPath = folderPath + "\\" + "Automation_Report.html";
		extent = new ExtentReports(extentReportPath, true);
		extent.loadConfig(new File("extent-config.xml"));

		System.out.println("------------------@BeforeSuite fired------------------------");

	}

	@BeforeTest
	public void beforeMethod() throws IOException {
		System.out.println("------------------ @BeforeTest fired------------------------");
		startClassTime = baseobj.getCurrentTime();

		Map<String, String> sysInfo = new HashMap<String, String>();
		sysInfo.put("Selenium Version", "3.0");
		sysInfo.put("Environment", "NST-Internal");
		extent.addSystemInfo(sysInfo);

	}

	public String createFolder(String folderPath) {
		File file = new File(folderPath);
		if (file.exists() == false) {
			file.mkdir();
		}
		return folderPath;
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("------------------ @BeforeClass fired------------------------");
		test = extent.startTest(this.getClass().getSimpleName());
	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("------------------ @AfterMethod fired------------------------");
		if (!result.isSuccess()) {
			System.out.println("ITestResult");
			String methodName = result.getName().toString().trim();
			baseobj.takeScreenShot(folderPath, methodName);
		} else {
			test.log(LogStatus.PASS, result.getMethod().getMethodName());
		}

		extent.flush();
		BaseDriver.StopDriver();

	}

	@AfterSuite
	protected void afterSuite() {
		System.out.println("------------------	@AfterSuite fired -----------------------");
		try {
			FileUtils.copyFile(new File(folderPath + "\\" + "Automation_Report.html"),
					new File(System.getProperty("user.dir") + "\\" + "Automation_Report.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
