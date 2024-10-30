package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.genericwebutility.UtlityClassobject;

public class ListImpclass implements ITestListener,ISuiteListener {
	
	 public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	
	public void onStart(ISuite suite) {
		
		System.out.println("Report configuration");
		String time =new Date().toString().replace(" ", "_").replace(":", " ");
		/* spark report config*/
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".htm");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		/* add env information & create test*/
		 report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Window-10");
		report.setSystemInfo("Browser", "Chrome-100");
		
		
	}
	
	public void onFinish(ISuite suite) {
		
		System.out.println("Report backup");
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("== ===>"+result.getMethod().getMethodName()+">===Start===");
		test= report.createTest(result.getMethod().getMethodName());
		UtlityClassobject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"==> STARTED <===");

		
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("== ===>"+result.getMethod().getMethodName()+">===End===");
		test.log(Status.PASS,result.getMethod().getMethodName()+"==> COMPLETED <===");
		

		
	}
	
	public void onTestFailure(ITestResult result) {
		
		/*String testName =result.getMethod().getMethodName();
		EventFiringWebDriver edriver =new EventFiringWebDriver(BaseClass.Sdriver);
		File source =edriver.getScreenshotAs(OutputType.FILE);
		String time =new Date().toString().replace(" ", "_").replace(":", " ");
		
		try {
		FileUtils.copyFile(source, new File("./Screenshot/"+testName+"+"+time+".png"));
		}catch(IOException e) {
			//to autogenerate catch block
			e.printStackTrace();
		}*/
		

		String testName =result.getMethod().getMethodName();
		TakesScreenshot edriver=(TakesScreenshot)BaseClass.Sdriver;
		 String filepath=edriver.getScreenshotAs(OutputType.BASE64);
		String time =new Date().toString().replace(" ", "_").replace(":", " ");
		test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==> FAILED <===");

		
		
		
		
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getMethod().getMethodName()+"==> SKIPPED <===");

	}
	
	

}
