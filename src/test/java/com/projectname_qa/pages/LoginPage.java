package com.projectname_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectname_qa.testbase.TestBase;

public class LoginPage extends TestBase {

	// logoImage, Title, CurrentUrl, userName, password, signinBtn

	// 1 : Extend base class
	// 2 : Design the webElements
	// 3: initialize page objects
	// 4 : define actions

	@FindBy(className = "logtext")
	WebElement logoImage;

	@FindBy(id = "login1")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//input[@class = 'signinbtn']")
	WebElement signInButton;

	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validateLoginPageCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean validateLoginPageLogoImage() {
		return logoImage.isDisplayed();
	}
	
	public InboxPage loginDetails(String uname, String pword) throws Exception {
		userName.sendKeys(uname);
		password.sendKeys(pword);
		signInButton.click();
		
		return new InboxPage();
	}
	
	
	
	
	
	
	
	
	
	

}
