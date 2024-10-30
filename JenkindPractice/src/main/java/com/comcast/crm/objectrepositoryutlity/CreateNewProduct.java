package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {
	
	WebDriver driver;
	
	public CreateNewProduct(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(name="productname")
	private WebElement prodnameEdit;

	public WebElement getProdnameEdit() {
		return prodnameEdit;

	}
	
	@FindBy(name="sales_start_date")
	private WebElement startDateEdit;
	
	@FindBy(name="sales_end_date")
	private WebElement endDateEdit;

	public WebElement getStartDateEdit() {
		return startDateEdit;
	}

	public WebElement getEndDateEdit() {
		return endDateEdit;
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement Vendnamebtn;
	
	public WebElement getVendnamebtn() {
		return Vendnamebtn;
	}
	
	@FindBy(xpath="(//td[.='Vendorname'])[1]")
	private WebElement vendorlink;

	public WebElement getVendorlink() {
		return vendorlink;
	}

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void CreateProduct(String Productname) {
		
		prodnameEdit.sendKeys(Productname);
		
		savebtn.click();
		}
	
	@FindBy(id="search_txt")
	private WebElement SearchEdit;
	
	public WebElement getSearchEdit() {
		return SearchEdit;
	}
	
	@FindBy(name="search")
	private WebElement Searchbtn;

	
	public WebElement getSearchbtn() {
		return Searchbtn;
	}
	
	@FindBy(id="my_file_element")
	private WebElement uploadbtn;

	public WebElement getUploadbtn() {
		return uploadbtn;
	}
	
	
	public void addVendorName() {
		
		Vendnamebtn.click();
		
	
		}
	
		
	
	
	
	
	
	
	
	
}


