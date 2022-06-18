package com.projectname_qa.pages;

import org.apache.commons.collections4.functors.IfClosure;
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
	
	@FindBy(className = "jqiclose ")
	WebElement closeTrashPopup;
	
	@FindBy(className = "jqimessage")
	WebElement TrashConfirmed;
	
	@FindBy(className = "rd_logout")
	WebElement logoutButton;
	
	
	public InboxPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateInboxPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateTrashCleanup() {
		trashButton.click();
		trashConfirmYes.click();
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
