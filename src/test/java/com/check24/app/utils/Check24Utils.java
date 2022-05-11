package com.check24.app.utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.check24.selenium.utils.Utilities;

public class Check24Utils {
	
	static boolean ElExist;
	static String ORName = "Check24PageFactory.properties";
	static String InpputFileName = "Check24ApplicationDetails.xlsx";
	
	
	public static String ValidateApplicationLaunch() throws Exception {
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		com.check24.selenium.utils.Utilities.launchbrowser("Chrome",prop.getProperty("AppURL") );
		ElExist = com.check24.selenium.utils.Utilities.ValidateElExist("xpath","xpath_RegisterationLink",ORName);
		if (ElExist==true){
			com.check24.selenium.utils.Utilities.ClickEl("xpath", "xpath_CookieConsentBtn");
		}
		ElExist = com.check24.selenium.utils.Utilities.ValidateElExist("xpath","xpath_RegisterationLink",ORName);
		if (ElExist==true){
			return "Pass";
		}else {
			return "Fail";
		}
	}
	
	public static String ValidateSubmission(int row,int TestCaseSheetId) throws Exception {
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		String CityName  = com.check24.selenium.utils.Utilities.GetCommonTestData("CityName",TestCaseSheetId, row,1,InpputFileName);
		String StreetName  = com.check24.selenium.utils.Utilities.GetCommonTestData("StreetName",TestCaseSheetId, row,2,InpputFileName);
		String StreetNum  = com.check24.selenium.utils.Utilities.GetCommonTestData("StreetNum",TestCaseSheetId, row,3,InpputFileName);
		String OnGoingContract  = com.check24.selenium.utils.Utilities.GetCommonTestData("OnGoingContract",TestCaseSheetId, row,4,InpputFileName);
		String ContractProvider  = com.check24.selenium.utils.Utilities.GetCommonTestData("ContractProvider",TestCaseSheetId, row,5,InpputFileName);
		String ContractPeriod  = com.check24.selenium.utils.Utilities.GetCommonTestData("ContractPeriod",TestCaseSheetId, row,6,InpputFileName);
		String TraiffType  = com.check24.selenium.utils.Utilities.GetCommonTestData("TraiffType",TestCaseSheetId, row,7,InpputFileName);
		String WirelessRouter  = com.check24.selenium.utils.Utilities.GetCommonTestData("WirelessRouter",TestCaseSheetId, row,8,InpputFileName);
		String YoungPeople  = com.check24.selenium.utils.Utilities.GetCommonTestData("YoungPeople",TestCaseSheetId, row,9,InpputFileName);
		String MobileNumber  = com.check24.selenium.utils.Utilities.GetCommonTestData("MobileNumber",TestCaseSheetId, row,10,InpputFileName);
		String ScenarioType  = com.check24.selenium.utils.Utilities.GetCommonTestData("ScenarioType",TestCaseSheetId, row,11,InpputFileName);

		com.check24.selenium.utils.Utilities.EnterData("name", "name_City",CityName);
		com.check24.selenium.utils.Utilities.EnterData("name", "name_Street",StreetName);
		com.check24.selenium.utils.Utilities.EnterData("name", "name_StreetNum",StreetNum);
		String xpathOnGoingContract = com.check24.selenium.utils.Utilities.CreateXPath(prop.getProperty("xpath_OnGoingContract")+OnGoingContract+"')]");
		com.check24.selenium.utils.Utilities.driver.findElement(By.xpath(xpathOnGoingContract)).click();
		Thread.sleep(1000);
		if(OnGoingContract.contentEquals("Ja")) {
			String xpathCurrentProvider = com.check24.selenium.utils.Utilities.CreateXPath(prop.getProperty("xpath_CurrentProvider")+ContractProvider+"']/parent::div");
			com.check24.selenium.utils.Utilities.driver.findElement(By.xpath(xpathCurrentProvider)).click();
			com.check24.selenium.utils.Utilities.EnterData("name", "name_ContractRemainingTime",ContractPeriod);
		}
		if(TraiffType.toLowerCase().contentEquals("internet")) {
			com.check24.selenium.utils.Utilities.ClickEl("xpath", "xpath_TariffInternetOnly");
		}else {
			String xpath_TariffAllTarfiff = com.check24.selenium.utils.Utilities.CreateXPath(prop.getProperty("xpath_TariffAllTarfiff&ExtraTV")+TraiffType+"')]");
			com.check24.selenium.utils.Utilities.driver.findElement(By.xpath(xpath_TariffAllTarfiff)).click();
		}
		JavascriptExecutor js = (JavascriptExecutor)com.check24.selenium.utils.Utilities.driver;
		js.executeScript("window.scrollBy(0,350)", "");

		if(WirelessRouter.toLowerCase().contentEquals("yes")) {
			com.check24.selenium.utils.Utilities.ClickEl("xpath", "xpath_WirelessRouter");
		}
		
		String xpathRatesFrYngPple = com.check24.selenium.utils.Utilities.CreateXPath(prop.getProperty("xpath_RatesFrYngPple")+YoungPeople+"')]");
		com.check24.selenium.utils.Utilities.driver.findElement(By.xpath(xpathRatesFrYngPple)).click();
		com.check24.selenium.utils.Utilities.EnterData("name", "name_MobilePhone",MobileNumber);
		com.check24.selenium.utils.Utilities.ClickEl("xpath", "xpath_SubmitBtn");
		ElExist = com.check24.selenium.utils.Utilities.ValidateElExist("xpath","xpath_TariffDetailsPage",ORName);
		if (ElExist==true && ScenarioType.toLowerCase().contentEquals("positive") ){
			return "Pass";
		}else if (ElExist==false && ScenarioType.toLowerCase().contentEquals("negative") ){
			return "Pass";
		}
		else {
			return "Fail";
		}
	}
	


}
