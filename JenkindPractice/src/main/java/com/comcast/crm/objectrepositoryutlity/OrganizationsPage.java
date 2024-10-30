package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement SearchEdit;

	public WebElement getSearchEdit() {
		return SearchEdit;
	}
	
	@FindBy(name="search_field")
	private WebElement SearchDB;

	public WebElement getSearchDB() {
		return SearchDB;
	}
	@FindBy(name="submit")
	private WebElement Searchbtn;

	public WebElement getSearchbtn() {
		return Searchbtn;
	}
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement HeaderMsg;

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}

}
