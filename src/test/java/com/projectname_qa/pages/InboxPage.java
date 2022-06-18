package com.projectname_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectname_qa.testbase.TestBase;

public class InboxPage extends TestBase{
	
	//title, Junk, 
	
	@FindBy(className = "rd_fld_empty")
	WebElement trashButton;
	
	@FindBy(id = "jqi_state0_buttonYes")
	WebElement trashConfirmYes;
	
	@FindBy(className = "jqiclose")
	WebElement closeTrashPopup;
	
	@FindBy(className = "jqimessage")
	WebElement TrashConfirmed;
	
	@FindBy(className = "rd_logout")
	WebElement logoutButton;
	
	@FindBy(xpath = "//span[@class = 'rd_tp-rgt']")
	WebElement inboxPageHi;
	
	
	public InboxPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateInboxPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateInboxPageHi() {
		boolean imagePresent = inboxPageHi.isDisplayed();
		return imagePresent;
	}
	
	public boolean validateTrashCleanup() throws Exception {
		trashButton.click();
		Thread.sleep(2000);
		trashConfirmYes.click();
		Thread.sleep(2000);
		boolean message = TrashConfirmed.isDisplayed();
		closeTrashPopup.click();
		return message;
	}
	
	public LogoutPage valiDateLogout() {
		if(logoutButton.isEnabled()){
			logoutButton.click();
		}
		return new LogoutPage();
	}
	
	

}
