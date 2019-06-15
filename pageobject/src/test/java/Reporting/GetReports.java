package Reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GetReports extends TestListenerAdapter {
	
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	public void onStart(ITestContext context)	{
		
		String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "TestResults"+TimeStamp+".html";
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\"+reportName);
		htmlreport.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("UserName", "Vinayak Tamse");
		
		
	}
	
	public void onTestSuccess(ITestResult tr)	{
		logger = reports.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)	{
		logger = reports.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult tr)	{
		logger = reports.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context)	{
		reports.flush();
	}
	


}
