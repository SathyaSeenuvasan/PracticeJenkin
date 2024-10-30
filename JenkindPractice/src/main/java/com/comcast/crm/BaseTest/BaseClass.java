package com.comcast.crm.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtitlity;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.genericwebutility.JavaUtility;
import com.comcast.crm.genericwebutility.UtlityClassobject;
import com.comcast.crm.genericwebutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutlity.HomePage;
import com.comcast.crm.objectrepositoryutlity.LoginPage;

import lombok.experimental.UtilityClass;

public class BaseClass {

	public WebDriver driver ;
	public static WebDriver Sdriver;
	

	public Fileutility flib = new Fileutility();
	public ExcelUtitlity elib = new ExcelUtitlity();
	public JavaUtility jlib = new JavaUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	
	

	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})

	public void configBS() {

		System.out.println("===Connect to DB Report config====");
		dlib.getDbconnection();
		
		

	}
	//@Parameters("Browser")

	@BeforeClass(groups= {"SmokeTest","RegressionTest"})

	public void configBC() throws Throwable {
		System.out.println("==Launch the Browser==");
		//String Browser = browser;
		String Browser=flib.getDataFromPropertiesFile("browser");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			driver = new ChromeDriver();
		}
Sdriver=driver;
UtlityClassobject.setdriver(driver);
	}

	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})

	public void configBM() throws Throwable {
		System.out.println("==Login==");
		String url = flib.getDataFromPropertiesFile("URL");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		wlib.waitForPageToLoad(driver);
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(url, Username, Password);

	}

	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void configAM() {

		System.out.println("==Logout==");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void configAC() throws Throwable {
		System.out.println("close the Browser==");
		driver.quit();

	}

	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void configAS() throws Throwable {

		System.out.println("====Close to DB Report back up===");
		dlib.closeDbconnection();
		
	}

}
