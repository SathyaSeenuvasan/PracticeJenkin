package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	
	WebDriver driver;
	
	public CreateNewVendorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendrnameEdit;
	
	@FindBy(id="phone")
	private WebElement phonenbrEdit;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getVendrnameEdit() {
		return vendrnameEdit;
	}

	public WebElement getPhonenbrEdit() {
		return phonenbrEdit;
	}
	
	
	
	public void CreateNewVendor(String vendname,String phnumber) {
		
		vendrnameEdit.sendKeys(vendname);
		phonenbrEdit.sendKeys(phnumber);
		savebtn.click();
		
		
		
		
		
		
		
		
	}
	

}
