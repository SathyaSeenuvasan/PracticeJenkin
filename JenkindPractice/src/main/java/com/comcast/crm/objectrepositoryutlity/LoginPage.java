package com.comcast.crm.objectrepositoryutlity;


import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebutility.WebDriverUtility;
/**
 * @author Sathya
 * 
 * contains Login page elements & business lib loke login()
 * 
 */

public class LoginPage extends WebDriverUtility {// rule1: create seperate java class for all pages
	  
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	// Rule2: Object creation (identify the all element using @FindBy )
	
	@FindBy(name="user_name")
	
	private WebElement usernameEdit;
	@FindBy(name="user_password")
	
	 private WebElement passwordEdit;
	@FindBy(id="submitButton")
	
	//Rule 4: Object Encapsulation
	
	private WebElement loginbtn;
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	// Step5: provide actions another way of utilization 
	//or business method/ it is only for specific application we cant use for any other application
	
	/**
	 * login to app base on url, username,password,
	 * @param url
	 * @param username
	 * @param password
	 */
	
	public void loginToapp(String url,String username,String password) {
		
		waitForPageToLoad(driver);
		
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginbtn.click();
		
		
		
		
	}
	
	


}
