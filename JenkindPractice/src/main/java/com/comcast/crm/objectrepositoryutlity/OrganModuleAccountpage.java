package com.comcast.crm.objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganModuleAccountpage {
	
		WebDriver driver;
		
		public OrganModuleAccountpage(WebDriver driver) {
			
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
		private WebElement OrgModuleEdt;

		public WebElement getOrgModuleEdt() {
			return OrgModuleEdt;
		}
		


}
