package Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.EnterEmailPage;
import Pages.EnterPasswordPage;
import Pages.HomePage;
import TestBase.Base;

public class EnterEmailTest extends Base{
	
	HomePage homepage;
	EnterEmailPage enteremail;
	EnterPasswordPage enterpassword;
	
	public EnterEmailTest()	{
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		Initialisation();
		homepage = new HomePage();
		enteremail = homepage.clickOnLoginLink();
		}
	
	@Test(priority=0)
	public void enterTheEmailTest()	{
		enteremail.enterTheEmail(props.getProperty("Email"));
		enterpassword = enteremail.clickOnContinue();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException	{
		Thread.sleep(3000);
		driver.close();
	}

}
