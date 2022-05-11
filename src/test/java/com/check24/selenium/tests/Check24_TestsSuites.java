package com.check24.selenium.tests;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Check24_TestsSuites {
	
	static String FunctionResult;
	static ExtentReports extent;
	ExtentSparkReporter sparkReporter;
	static boolean ElExist;
	static int TestCaseSheetId = 1;

	@BeforeSuite (alwaysRun = true)
	public void BeforeSuite() {
		String ActualFileName;
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String TimeStamp = sdf3.format(timestamp).toString();
		ActualFileName = TimeStamp.replace(" ","-");
		ActualFileName = ActualFileName.replace(":","-");
		String CurrentClassName = new Object() {}
	      .getClass()
	      .getEnclosingClass()
	      .getSimpleName();

		extent = new ExtentReports();
		String ExtenReportFilePath = System.getProperty("user.dir")+"\\ExtentReport\\"+CurrentClassName+"_ExtentReport_"+com.check24.selenium.utils.Utilities.GenerateFileName()+".html";
		sparkReporter = new ExtentSparkReporter(ExtenReportFilePath);
		extent.attachReporter(sparkReporter);

	}

	@AfterSuite (alwaysRun = true)
	public void AfterSuite() {
		extent.flush();
	}

	@AfterMethod
	public void beforeTestMethod(Method testMethod) {
		System.out.println("Test Case Name:- " + testMethod.getName());
	}
	
	@Test(priority = 1, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_1() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_1");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(1,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}	
	
	@Test(priority = 2, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_2() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_2");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(2,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 3, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_3() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_3");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(3,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 4, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_4() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_4");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(4,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 5, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_5() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_5");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(5,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 6, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_6() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_6");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(6,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 7, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_7() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_7");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(7,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 8, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_8() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_8");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(8,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 9, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_9() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_9");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(9,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
	
	@Test(priority = 10, enabled = true, groups = {"Check24-Regression-TestCases"})
	public static void Check24_TestCases_10() throws Exception {
		ExtentTest test = extent.createTest("Check24_TestCases_10");
		FunctionResult = com.check24.app.utils.Check24Utils.ValidateApplicationLaunch();
		if (FunctionResult == "Pass") {
			test.pass("Step:- DSL Comparision Application Launch - Passed");
			FunctionResult = com.check24.app.utils.Check24Utils.ValidateSubmission(10,TestCaseSheetId);
			if (FunctionResult == "Pass") {
				test.pass("Step:- DSL Comparision Submission Validation - Passed");
				com.check24.selenium.utils.Utilities.AppTearDown();
			}
			else {
				test.fail("Step:- DSL Comparision Submission Validation - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
		}
		 else {
				test.fail("Step:- DSL Comparision Application Launch - Failed");
				String methodName = new Object() {}
			      .getClass()
			      .getEnclosingMethod()
			      .getName();
				com.check24.selenium.utils.Utilities.TakeScreenshot(methodName);
			}
	}
}
