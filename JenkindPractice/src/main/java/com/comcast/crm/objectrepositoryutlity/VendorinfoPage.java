package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorinfoPage {

	WebDriver driver;
	public VendorinfoPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="lvtHeaderText")
	private WebElement vedrHeaderinfo;
	public WebElement getVedrHeaderinfo() {
		return vedrHeaderinfo;
	}
}
