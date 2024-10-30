package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrglink() {
		return Orglink;
	}

	
	public WebElement getContactLink() {
		return contactLink;
	}

	

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	
	public WebElement getMoreLink() {
		return moreLink;
	}

	

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(linkText="Organizations")
	private WebElement Orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText ="Campaigns")
	private WebElement campaignLink;  
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorlink;
	
	public WebElement getVedorlink() {
		return vendorlink;
	}

	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement Singoutlink;
	
	public WebElement getSingoutlink() {
		return Singoutlink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}
	
	@FindBy(xpath="//img[@title=\"Create Vendor...\"]")
	private WebElement vendorbtn;

	public WebElement getVendorbtn() {
		return vendorbtn;
	}

	public void navigateToCampaginPage() {
		
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		
		campaignLink.click();
				
	}
	
	public void logout() {
		
		Actions act =new Actions(driver);
		act.moveToElement(adminImg).perform();
		Singoutlink.click();
		
	}
	
public void navigateToVendorlink() {
		
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		vendorlink.click();
		
		
				
	}
	
	
	
	
	
	

}
