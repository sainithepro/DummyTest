package com.projectname.reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static String screenshotFolderPath;
	public static String reportFolderPath;
	
	public static ExtentReports getReports() {
		
		if (extent == null) {
			System.out.println();
			extent = new ExtentReports();
			
			Date d = new Date();
			String reportFolder = d.toString().replaceAll(":", "-") +  "//screenshots";
			
			screenshotFolderPath = System.getProperty("user.dir") + "//reports//" + reportFolder;
			reportFolderPath = System.getProperty("user.dir") + "//reports//" + d.toString().replaceAll(":", "-");
			
			File f = new File(screenshotFolderPath);
			f.mkdirs();
			
		
			spark = new ExtentSparkReporter(reportFolderPath); // object created
			spark.config().setReportName("Automation Test Reporting"); // configuration started
			spark.config().setDocumentTitle("Project Genesys");
			spark.config().setTheme(Theme.DARK);
			spark.config().setEncoding("utf-8");
			extent.attachReporter(spark); //attaching observer with the subject
		}
		return extent;
		
	}

}
