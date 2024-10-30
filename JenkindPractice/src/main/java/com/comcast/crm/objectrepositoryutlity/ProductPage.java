package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement Productlink;
	
	public WebElement getProductlink() {
		return Productlink;
	}
	
@FindBy(xpath="//img[@title=\"Create Product...\"]")
	
	private WebElement Prductbtn;

	public WebElement getPrductbtn() {
		return Prductbtn;
	}


}
