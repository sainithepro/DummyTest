package com.projectname_qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.projectname.reports.ExtentManager;
import com.projectname_qa.pages.InboxPage;
import com.projectname_qa.pages.LoginPage;
import com.projectname_qa.testbase.TestBase;

public class LoginPageTest extends TestBase {

	public LoginPage loginPage;
	public InboxPage inboxPage;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;

	public LoginPageTest() throws Exception {

		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		extent = ExtentManager.getReports();
		test = extent.createTest("Opening browser Test");
		test.log(Status.INFO, "Starting logging test case");
		test.log(Status.INFO, "Opening the browser");
		
		initialize();
		loginPage = new LoginPage();

	}
	


	@Test(priority = 1)
	public void loginPageTitleTest() {
		test = extent.createTest("Validate Title");
		test.log(Status.INFO, "Validating presence of Title");
		String title = loginPage.validateLoginPageTitle();
		System.out.println("Title is : " + title);
		Assert.assertEquals(title, "Rediffmail");
		test.log(Status.PASS, "successfully validated");
	}

	@Test(priority = 2)
	public void loginPageCurrentURLTest() {
		test = extent.createTest("Validate URL");
		test.log(Status.INFO, "Validating presence of sign in link");
		String currentURL = loginPage.validateLoginPageCurrentURL();
		System.out.println("Current URL is : " + currentURL);
		Assert.assertEquals(currentURL, "https://mail.rediff.com/cgi-bin/login.cgi");
		test.log(Status.PASS, "successfully validated");
	}

	@Test(priority = 3)
	public void loginPageLogoImageTest() {
		test = extent.createTest("Validate Logo");
		test.log(Status.INFO, "Validating presence of Logo Image");
		boolean logoImage = loginPage.validateLoginPageLogoImage();
		System.out.println("Logo is present: " + logoImage);
		test.log(Status.PASS, "LOGO successfully validated");

	}

	@Test(priority = 4)
	public void loginDetailsTest() throws Exception {
		test = extent.createTest("Validate if logged in");
		test.log(Status.INFO, "Entering Credentials");
		loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		String CurrentTitle = driver.getTitle();
		Assert.assertEquals(CurrentTitle, "Rediffmail");
		test.log(Status.PASS, "Successfully logged in ");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		test.log(Status.PASS, "Login test case pass");
		extent.flush();
		driver.quit();
	}

}
