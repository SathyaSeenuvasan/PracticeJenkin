package com.comcast.crm.contacttest;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtitlity;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.genericwebutility.JavaUtility;
import com.comcast.crm.objectrepositoryutlity.ContactPage;
import com.comcast.crm.objectrepositoryutlity.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutlity.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutlity.HomePage;
import com.comcast.crm.objectrepositoryutlity.OrganModuleAccountpage;
import com.comcast.crm.objectrepositoryutlity.OrganizationsPage;

/**
 * @author Sathya
 * 
 */
public class VitigercontactmoduleTest extends BaseClass {

	@Test(groups="SmokeTest")

	public void createcontact() throws Throwable, Throwable {

/* read the TestScripts data form Excel file*/
		String Lastname = elib.getDataFormExcel("contact", 7, 2) + jlib.getRandomNumber();

		/* step 2: navigate to contact */
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

/* step 3: click on create contact */

		ContactPage cp = new ContactPage(driver);

		cp.getCreateNewContactbtn().click();

/* step 4: enter all the detail& create new contact */

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.CreateContact(Lastname);

		String ActLstname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (ActLstname.equals(Lastname)) {
			System.out.println(Lastname + "is created==pass");
		} else {
			System.out.println(Lastname + "is not Created==Fail");
		}

	}

	@Test(groups="RegressionTest")

	public void CreateContactwithsupportDateTest() throws Throwable, Throwable {

		String Lastname = elib.getDataFormExcel("contact", 4, 2) + jlib.getRandomNumber();

		// step 2: navigate to contact

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on create contact

		ContactPage cp = new ContactPage(driver);

		cp.getCreateNewContactbtn().click();

		// step 4: enter all the detail& create new contact

		String startDate = jlib.getSystemDateYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(30);

		// step 4: enter support start date
		
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.CreateContactwithSupportDate(Lastname, startDate, endDate);

		
		String ActLstname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (ActLstname.equals(Lastname)) {
			System.out.println(Lastname + "is created==pass");
		} else {
			System.out.println(Lastname + "is not Created==Fail");
		}

		String Actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (Actstartdate.equals(startDate)) {
			System.out.println(startDate + "is created==pass");
		} else {
			System.out.println(startDate + "is not Created==Fail");
		}

		String Actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (Actenddate.equals(endDate)) {
			System.out.println(endDate + "information is verified==pass");
		} else {
			System.out.println(endDate + "information is verified==Fail");
		}

		//driver.quit();

	}



	@Test(groups="RegressionTest")

	public void VitigercontactmodulTest() throws Throwable, Throwable {

		// reading data form excel by using excelutility

		String orgName = elib.getDataFormExcel("contact", 7, 2) + jlib.getRandomNumber();// by using javautiltiy

		String contactLastName = elib.getDataFormExcel("contact", 7, 3) + jlib.getRandomNumber();

		// step1: login to application

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 2: navigate to organisations module

		hp.getOrglink().click();

		// step 3: click on create organisation
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step 4: enter all the details and create new organisation

		CreateNewOrganizationPage Cop = new CreateNewOrganizationPage(driver);
		Cop.createorg(orgName);

		// verify header message expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "Header is verified==PASS");
		} else {
			System.out.println(orgName + "Header is not verified==FAIL");
		}

		// step 5 : navigate to contact module
		hp.getContactLink().click();

		// step 6: click on create contact

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactbtn().click();

		// step 7: enter all the details and create new contact

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.getCreateNewContact().sendKeys(contactLastName);
		cnp.getOrgNameBtn().click();

		// switch to child window

		wlib.switchToTabonURL(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();

		// dynamic xpath for opening the organisation in the create contact page
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window

		wlib.switchToTabonURL(driver, "Contacts&action");

		OrganModuleAccountpage omap = new OrganModuleAccountpage(driver);
		omap.getOrgModuleEdt().click();

		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName + "header is verified==PASS");
		} else {
			System.out.println(contactLastName + "header is not verified==FAIL");
		}

		// verify header phonenumber info expected result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==PASS");
		} else {
			System.out.println(orgName + "information is created==FAIL");
		}

	}
	
	@Test
	public void practiceTest() {
		System.out.println("Test completed");
	}


}
