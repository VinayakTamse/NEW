package Testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.EnterEmailPage;
import Pages.EnterPasswordPage;
import Pages.HomePage;
import Pages.UserHomePage;
import TestBase.Base;

public class EnterPasswordTest extends Base{
	
	HomePage homepage;
	EnterEmailPage emailpage;
	EnterPasswordPage passwordpage;
	UserHomePage userpage;
	
	public EnterPasswordTest()	{
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		Initialisation();
		homepage = new HomePage();
		emailpage = homepage.clickOnLoginLink();
		emailpage.enterTheEmail(props.getProperty("Email"));
		passwordpage = emailpage.clickOnContinue();
		
	}
	
	@Test(priority=1)
	public void EnterPasswordTest()	{
		passwordpage.enterThePassword(props.getProperty("Password"));
		userpage = passwordpage.clickOnSigin();
		boolean condition = userpage.verifyUserName();
		if (condition==true)	{
			Reporter.log("<===================Passed The Test User is Verified============>", true);
		}
		else	{
			Reporter.log("<====================Failed===================>", true);
		}
		userpage.clickOnSignOut();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException	{
		Thread.sleep(3000);
		driver.close();
	}
	
	

}
