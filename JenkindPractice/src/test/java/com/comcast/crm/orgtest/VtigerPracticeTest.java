package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtitlity;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.genericwebutility.JavaUtility;
import com.comcast.crm.genericwebutility.UtlityClassobject;
import com.comcast.crm.listenerutility.ListImpclass;
import com.comcast.crm.objectrepositoryutlity.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutlity.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutlity.HomePage;
import com.comcast.crm.objectrepositoryutlity.OrganizationinfoPage;
import com.comcast.crm.objectrepositoryutlity.OrganizationsPage;

import lombok.experimental.UtilityClass;
@Listeners(com.comcast.crm.listenerutility.ListImpclass.class)
public class VtigerPracticeTest extends BaseClass {

	@Test(groups="SmokeTest")

	public void OrganizationTest() throws Throwable {
		
		UtlityClassobject.getTest().log(Status.INFO,"read data from Excel");

		String orgname = elib.getDataFormExcel("Vtiger", 1, 2) + jlib.getRandomNumber();

		// step 2: navigate to organization 
		UtlityClassobject.getTest().log(Status.INFO,"navigate to orgpage");
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step 3: click on create organization
		UtlityClassobject.getTest().log(Status.INFO,"navigate to create orgpage");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step 4: enter all the detail& create new organization

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		UtlityClassobject.getTest().log(Status.INFO,"navigate to CreateNew orgpage");
		
		
		cop.createorg(orgname);
		UtlityClassobject.getTest().log(Status.INFO,orgname+"===>create a new orgpage");

		// verify expected result
		
		String acthdinfo = op.getHeaderMsg().getText();
		boolean status = acthdinfo.contains(orgname);
		Assert.assertEquals(status, true);
		
		//String hdinfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		
	  
		
		/*if (hdinfo.contains(orgname)) {
			System.out.println(orgname + "is created==pass");
		} else {
			System.out.println(orgname + "is not Created==Fail");
		}*/

		// Verify Header orgname info expected Result
		//String actorgname = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
		OrganizationinfoPage oinp=new OrganizationinfoPage(driver);
		String actorgname = oinp.getOrgnamemsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actorgname, orgname);
		soft.assertAll();
	
		/*if (actorgname.equals(orgname)) {
			System.out.println(orgname + "HeaderOrgname is created==pass");
		} else {
			System.out.println(orgname + "HeaderOrgname is not Created==Fail");
		}*/

	}
	
	@Test(groups="RegressionTest")

	public void CreateOrgwithphonenumTest() throws Throwable {
		String orgname = elib.getDataFormExcel("Vtiger", 7, 2) + jlib.getRandomNumber();
		String PhoneNumber = elib.getDataFormExcel("Vtiger", 7, 3) + jlib.getRandomNumber();

		// step 2: navigate to organization
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step 3: click on create organization

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step 4: enter all the detail& create new organization

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrgnameEdit().sendKeys(orgname);
		cnop.getPhoneEdit().sendKeys(PhoneNumber);
		cnop.getSavebtn().click();

		String Phnumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (Phnumber.equals(PhoneNumber)) {
			System.out.println(PhoneNumber + "is created==pass");
		} else {
			System.out.println(PhoneNumber + "is not Created==Fail");
		}

	}

	@Test(groups="RegressionTest")

	public void CreateOgwithIndustryTest() throws Throwable {
		// read the data from the physical file

		String orgname = elib.getDataFormExcel("Vtiger", 4, 2) + jlib.getRandomNumber();
		String Industries = elib.getDataFormExcel("Vtiger", 4, 3); // + jlib.getRandomNumber();
		String type = elib.getDataFormExcel("Vtiger", 4, 4); // + jlib.getRandomNumber();

		// String Lastname = elib.getDataFormExcel("contact", 1, 2) +
		// jlib.getRandomNumber();

// step 2: navigate to organization

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step 3: click on create organization

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step 4: enter all the detail& create new organization

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);

		cnop.CreateOrgwithInduAndType(orgname, Industries, type);

		String IndustName = driver.findElement(By.id("dtlview_Industry")).getText();
		if (IndustName.equals(Industries)) {
			System.out.println(Industries + "is created==pass");
		} else {
			System.out.println(Industries + "is not Created==Fail");
		}

		String TypeName = driver.findElement(By.id("dtlview_Type")).getText();
		if (TypeName.equals(type)) {
			System.out.println(type + "is created==pass");
		} else {
			System.out.println(type + "is not Created==Fail");
		}

	}


}
