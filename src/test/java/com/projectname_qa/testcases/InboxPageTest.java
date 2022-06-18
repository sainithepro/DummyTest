package com.projectname_qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.projectname.reports.ExtentManager;
import com.projectname_qa.pages.InboxPage;
import com.projectname_qa.pages.LoginPage;
import com.projectname_qa.pages.LogoutPage;
import com.projectname_qa.testbase.TestBase;

public class InboxPageTest extends TestBase {

	public InboxPage inboxPage;
	public LoginPage loginPage;
	public LogoutPage logoutPage;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;

	public InboxPageTest() throws Exception {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		extent = ExtentManager.getReports();
		test = extent.createTest("Redirecting to inbox page");

		initialize();

		loginPage = new LoginPage();
		loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		inboxPage = new InboxPage();
		
		logoutPage = new LogoutPage();
		test.log(Status.PASS, "Logged in");

	}

	@Test(priority = 1)
	public void inboxPageTitleTest() {
		
		test = extent.createTest("Inbox page Title validation");
		String title = inboxPage.validateInboxPageTitle();
		Assert.assertEquals(title, "Rediffmail");
		test.log(Status.PASS, "Inbox page is displayed");
	}
	
	
	@Test(priority = 2)
	public void inboxPageHiTest() {
		test = extent.createTest("Inbox page validation: Hi preset ?" );
		boolean isPresent = inboxPage.validateInboxPageHi();
		Assert.assertTrue(isPresent);
		test.log(Status.PASS, "Hi logo is Present in inbox page");
	}
	
	@Test(priority = 3)
	public void trashCleanupTest() throws Exception {
		test = extent.createTest("Trash cleanup Test");
		boolean cleanupDone = inboxPage.validateTrashCleanup();
		Thread.sleep(3000);
		if (cleanupDone = true) {
			Assert.assertTrue(cleanupDone);
			test.log(Status.PASS, "Trash cleanup SUCCESS");
		}else {
			test.log(Status.FAIL, "Trash cleanup FAILED");
		}
		
	}
	
	@Test(priority = 4)
	public void logoutTest() {
		test = extent.createTest("Clicking on Logout page");
		logoutPage = inboxPage.valiDateLogout();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		test.log(Status.PASS, "Inbox test case pass");
		extent.flush();
		driver.quit();
	}
	
	
	
	
	

}
