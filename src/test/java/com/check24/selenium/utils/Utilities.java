package com.check24.selenium.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {

	public static WebDriver driver;
	static FileInputStream fis = null;
	static Properties prop;
	static boolean ValidateElExist;
	static boolean ElExist;
	static Actions actions;
	static WebElement ElKey;
	static String CountryCode;
	static String CountryName;
	static String DOB;
	static String TestDataFileName = "Check24ApplicationDetails.xlsx";
	static String ORName = "Check24PageFactory.properties";

	public static WebDriver launchbrowser(String BrowserName, String AppURL) throws Exception {
		if (BrowserName.contentEquals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserName.contentEquals("Firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/java-archive,application/pdf");
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);

			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
		} else if (BrowserName.contentEquals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter the correct browsername, options - Chrome/Firefox/Edge");
		}
		driver.get(AppURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		return driver;
	}

	public static boolean ValidateElExist(String LocatorType, String LocatorVal, String ORName) throws Exception {

		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		ValidateElExist = false;
		List<WebElement> Elmnt;
		if (LocatorType.toLowerCase().contentEquals("xpath")) {
			Elmnt = driver.findElements(By.xpath(prop.getProperty(LocatorVal.trim())));
		} else if (LocatorType.toLowerCase().contentEquals("name")) {
			Elmnt = driver.findElements(By.name(prop.getProperty(LocatorVal.trim())));
		} else if (LocatorType.toLowerCase().contentEquals("id")) {
			Elmnt = driver.findElements(By.id(prop.getProperty(LocatorVal.trim())));
		}else {
			return false;
		}
		
		int HFFlagCounter = 0;
		
		do {
			if (Elmnt.size()>0) {
				ValidateElExist = true;
			} else {
				ValidateElExist = false;
			}
			Thread.sleep(1000);
			HFFlagCounter= HFFlagCounter+1;	
		}while(!(ValidateElExist==true || HFFlagCounter==5));

		return ValidateElExist;

	}
	
	public static boolean ClickEl(String LocatorType, String LocatorVal) throws Exception {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String ClassName = ste.getClassName();
		String ORName = GetORName(ClassName);
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		ElExist = false;
		Thread.sleep(1000);
		ElExist = ValidateElExist(LocatorType, LocatorVal, ORName);
		if (ElExist == true) {
			if (LocatorType.toLowerCase().contentEquals("xpath")) {
				driver.findElement(By.xpath(prop.getProperty(LocatorVal.trim()))).click();
			} else if (LocatorType.toLowerCase().contentEquals("id")) {
				driver.findElement(By.id(prop.getProperty(LocatorVal.trim()))).click();
			} else if (LocatorType.toLowerCase().contentEquals("name")) {
				driver.findElement(By.name(prop.getProperty(LocatorVal.trim()))).click();
			} else {
				System.out.println("Enter Correct Locator Type as an argument.");
			}
		} else {
			System.out.println("Element Name:- " + LocatorVal + " - Not Aavailable on the page");
		}
		return ElExist;

	}
	
	public static boolean OpenLinkinNewTab(String LocatorType, String LocatorVal) throws Exception {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String ClassName = ste.getClassName();
		String ORName = GetORName(ClassName);
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\allresources\\OR\\" + ORName);
		ElExist = false;
		Thread.sleep(1000);
		String clicklnk = Keys.chord(Keys.CONTROL, Keys.ENTER);
		ElExist = ValidateElExist(LocatorType, LocatorVal, ORName);
		if (ElExist == true) {
			if (LocatorType.contentEquals("xpath")) {
				driver.findElement(By.xpath(prop.getProperty(LocatorVal.trim()))).sendKeys(clicklnk);
			} else if (LocatorType.contentEquals("id")) {
				driver.findElement(By.id(prop.getProperty(LocatorVal.trim()))).sendKeys(clicklnk);
			} else if (LocatorType.contentEquals("name")) {
				driver.findElement(By.name(prop.getProperty(LocatorVal.trim()))).sendKeys(clicklnk);
			} else {
				System.out.println("Enter Correct Locator Type as an argument.");
			}
		} else {
			System.out.println("Element Name:- " + LocatorVal + " - Not Aavailable on the page");
		}
		return ElExist;
	}

	public static boolean EnterData(String LocatorType, String LocatorVal, String InputData) throws Exception {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String ClassName = ste.getClassName();
		String ORName = GetORName(ClassName);
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		ElExist = false;
		Thread.sleep(1000);
		ElExist = ValidateElExist(LocatorType, LocatorVal, ORName);
		if (ElExist == true) {
			if (LocatorType.toLowerCase().contentEquals("xpath")) {
				driver.findElement(By.xpath(prop.getProperty(LocatorVal.trim()))).sendKeys(InputData);
			} else if (LocatorType.toLowerCase().contentEquals("id")) {
				driver.findElement(By.id(prop.getProperty(LocatorVal.trim()))).sendKeys(InputData);
			} else if (LocatorType.toLowerCase().contentEquals("name")) {
				driver.findElement(By.name(prop.getProperty(LocatorVal.trim()))).sendKeys(InputData);
			} else {
				System.out.println("Enter Correct Locator Type as an argument.");
			}
		} else {
			System.out.println("Element Name:- " + LocatorVal.trim() + " - Not Aavailable on the page");
		}
		return ElExist;
	}

	public static boolean ClearTextField(String LocatorType, String LocatorVal) throws Exception {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String ClassName = ste.getClassName();
		String ORName = GetORName(ClassName);
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\allresources\\OR\\" + ORName);
		ElExist = false;
		Thread.sleep(1000);
		ElExist = ValidateElExist(LocatorType, LocatorVal, ORName);
		if (ElExist == true) {
			if (LocatorType.contentEquals("xpath")) {
				driver.findElement(By.xpath(prop.getProperty(LocatorVal.trim()))).clear();
			} else if (LocatorType.contentEquals("id")) {
				driver.findElement(By.id(prop.getProperty(LocatorVal.trim()))).clear();
			} else if (LocatorType.contentEquals("name")) {
				driver.findElement(By.name(prop.getProperty(LocatorVal.trim()))).clear();
			} else {
				System.out.println("Enter Correct Locator Type as an argument.");
			}
		} else {
			System.out.println("Element Name:- " + LocatorVal.trim() + " - Not Aavailable on the page");
		}
		return ElExist;
	}

	public static String GetValue(String LocatorType, String LocatorVal) throws Exception {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String ClassName = ste.getClassName();
		String ORName = GetORName(ClassName);
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		ElExist = false;
		String FieldValue = "";
		Thread.sleep(1000);
		ElExist = ValidateElExist(LocatorType, LocatorVal, ORName);
		if (ElExist == true) {
			if (LocatorType.contentEquals("xpath")) {
				FieldValue = driver.findElement(By.xpath(prop.getProperty(LocatorVal.trim()))).getText().trim();
			} else if (LocatorType.contentEquals("id")) {
				FieldValue = driver.findElement(By.id(prop.getProperty(LocatorVal.trim()))).getText().trim();
			} else if (LocatorType.contentEquals("name")) {
				FieldValue = driver.findElement(By.name(prop.getProperty(LocatorVal.trim()))).getText().trim();
			} else {
				System.out.println("Enter Correct Locator Type as an argument.");
			}
		} else {
			System.out.println("Element Name:- " + LocatorVal.trim() + " - Not Aavailable on the page");
		}
		return FieldValue;
	}

	public static String CreateXPath(String xpathExp, Object... args) {
		for (int i = 0; i < args.length; i++) {
			xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
		}
		return xpathExp;

	}

	public static Properties loadpagefactory(String PropPath) throws Exception {

		fis = new FileInputStream(PropPath);
		prop = new Properties();
		prop.load(fis);
		return prop;
	}

	public static String getCallerClassName(Method MthdName) {
		return MthdName.getDeclaringClass().toString();
	}

	public static String GetCallingClassName() {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		return ste.getClassName();
	}

	public static String GetORName(String ClassName) {
		
		return "Check24PageFactory.properties";
	}

	public static void AppTearDown() {
		driver.quit();
	}

	public static String GetCommonTestData(String CommonTestDataType, int SheetId, int RowStr, int ColStr,String InputFileName)
			throws Exception {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\\\TestDataFolder\\"+InputFileName);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet1 = wb.getSheetAt(SheetId);
		if (sheet1.getRow(RowStr).getCell(ColStr).getStringCellValue().length() < 1) {
			StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
			System.out.println("Missing Valid Data: Class Name-"+ste.getClassName()+",Method Name- "+ste.getMethodName()+", Column Number- "+ColStr);
			wb.close();
			return "";
		} else {
			String Default = sheet1.getRow(RowStr).getCell(ColStr).getStringCellValue();
			wb.close();
			return Default;
		}
	}

	public static String[] GetAppDetails(String UserType) throws Exception {
		
		Properties prop = Utilities.loadpagefactory(
				System.getProperty("user.dir") + "\\src\\test\\resources\\PageFactory\\" + ORName);
		int CredentialRowCount=-1 ;
		String[] UserDetail=new String[4];
		File file = new File(System.getProperty("user.dir")+prop.getProperty("TestDataFile")+ TestDataFileName);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowCount = sheet1.getLastRowNum()+1;
		for(int i=1;i<=rowCount;i++) {
			String ActualUserType = sheet1.getRow(i).getCell(0).getStringCellValue();
			if (ActualUserType.trim().toUpperCase().contentEquals(UserType.trim().toUpperCase())){
				CredentialRowCount = i;
				break;
			}
		}
		if(!(CredentialRowCount==-1)) {
			UserDetail[0] = sheet1.getRow(CredentialRowCount).getCell(1).getStringCellValue().trim();
			UserDetail[1] = sheet1.getRow(CredentialRowCount).getCell(2).getStringCellValue().trim();
			UserDetail[2] = sheet1.getRow(CredentialRowCount).getCell(3).getStringCellValue().trim();
			UserDetail[3] = sheet1.getRow(CredentialRowCount).getCell(4).getStringCellValue().trim();
		}
		else {
			System.out.println("Provider the correct UserType as "+UserType+" is not available to select.");
		}
		wb.close();
		return UserDetail;
	}

	public static void TakeScreenshot(String MethodName) {

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir")+"\\screenshots\\"+MethodName+"_"+GenerateFileName()+".jpg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		Assert.fail();
		
	}
	
	public static String GenerateFileName() {
		String ActualFileName;
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String TimeStamp = sdf3.format(timestamp).toString();
		ActualFileName = TimeStamp.replace(" ","-");
		ActualFileName = ActualFileName.replace(":","-");
		return ActualFileName;
	}
	

	

	

}
