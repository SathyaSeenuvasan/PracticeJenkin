package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
WebDriver driver;
	
	public CreateNewContactPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement CreateNewContact;
	
	public WebElement getCreateNewContact() {
		return CreateNewContact;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdit;
	
	public WebElement getStartDateEdit() {
		return startDateEdit;
	}

	public WebElement getEndDateEdit() {
		return endDateEdit;
	}

	@FindBy(name="support_end_date")
	private WebElement endDateEdit;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	
	private WebElement OrgNameBtn;
	
	
	public WebElement getOrgNameBtn() {
		return OrgNameBtn;
	}
	
	

	public String CreateContact(String lastname) {
		
		CreateNewContact.sendKeys(lastname);
		
		saveBtn.click();
		return lastname;
		
		}
	
	public String CreateContactwithSupportDate(String lastname,String startdate,String endDate) {
	
		CreateNewContact.sendKeys(lastname);
		startDateEdit.clear();
		startDateEdit.sendKeys(startdate);
		endDateEdit.clear();
		endDateEdit.sendKeys(endDate);
		saveBtn.click();
		
		
		return lastname;
		}


}
