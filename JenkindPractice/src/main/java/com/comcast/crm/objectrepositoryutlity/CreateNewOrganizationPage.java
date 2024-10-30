package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {

	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement OrgnameEdit;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgnameEdit() {
		return OrgnameEdit;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement Savebtn;

	@FindBy(name = "industry")
	private WebElement IndustryDB;

	public WebElement getIndustryEdit() {
		return IndustryDB;
	}

	@FindBy(name = "accounttype")
	private WebElement TypeDB;

	public WebElement getTypeDB() {
		return TypeDB;
	}
	
	@FindBy(id="phone")
	private WebElement phoneEdit;

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public void createorg(String Orgname) {
		OrgnameEdit.sendKeys(Orgname);
		Savebtn.click();

	}

	public void CreateOrgwithInduAndType(String Orgname, String industry, String type) {

		OrgnameEdit.sendKeys(Orgname);

		Select sel = new Select(IndustryDB);
		sel.selectByVisibleText(industry);
		Select sel1 = new Select(TypeDB);
		sel1.selectByVisibleText(type);
		Savebtn.click();

	}

	public void createorg(String Orgname, String industry) {

		OrgnameEdit.sendKeys(Orgname);

		Select sel = new Select(IndustryDB);
		sel.selectByVisibleText(industry);
		Savebtn.click();
	}

}
