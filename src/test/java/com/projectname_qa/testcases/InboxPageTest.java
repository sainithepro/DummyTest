package com.projectname_qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.projectname.reports.ExtentManager;
import com.projectname_qa.pages.InboxPage;
import com.projectname_qa.testbase.TestBase;

public class InboxPageTest extends TestBase {
	
	public InboxPage inboxPage;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	

	public InboxPageTest() throws Exception {
		super();
	}
	
	@BeforeSuite
	public void setup() throws Exception {
		extent = ExtentManager.getReports();
		test = extent.createTest("Redirecting to inbox page");
		inboxPage = new InboxPage();
	}
	
	@Test
	public void inboxPageTitleTest() {
		
		String title = inboxPage.validateInboxPageTitle();
		Assert.assertEquals(title, "Rediffmail");
		test.log(Status.PASS, "Inbox page is displayed");
		
	}


}
