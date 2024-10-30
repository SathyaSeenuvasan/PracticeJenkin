package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {
	WebDriver driver;
	public OrganizationinfoPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderMsg;

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}
	
	@FindBy(xpath="//span[@id=\"dtlview_Organization Name\"]")
	private WebElement orgnamemsg;
	public WebElement getOrgnamemsg() {
		return orgnamemsg;
	}
	
	

}
