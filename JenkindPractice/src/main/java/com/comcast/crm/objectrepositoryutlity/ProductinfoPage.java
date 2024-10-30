package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductinfoPage {
	
	WebDriver driver;
	
	public ProductinfoPage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(className="lvtHeaderText")
	private WebElement PrHeaderinfoedit;

	public WebElement getPrHeaderinfoedit() {
		return PrHeaderinfoedit;
	}
	
	@FindBy(xpath="//td[@id=\"mouseArea_Sales Start Date\"]/child::span")
	private WebElement StdateHeaderedit;
	
	@FindBy(xpath="//td[@id=\"mouseArea_Sales End Date\"]/child::span")
	private WebElement EndateHeaderedit;

	public WebElement getStdateHeaderedit() {
		return StdateHeaderedit;
	}

	public WebElement getEndateHeaderedit() {
		return EndateHeaderedit;
	}

}
