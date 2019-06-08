package Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.EnterEmailPage;
import Pages.HomePage;
import TestBase.Base;

public class HomePageSigninTest extends Base{
	
	HomePage homepage;
	EnterEmailPage emailpage;
	
	public HomePageSigninTest()	{
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		Initialisation();
		homepage = new HomePage();
		//emailpage = new EnterEmailPage();
	}
	
	@Test(priority=1)
	public void verifyAmazonLogoTest()	{
		boolean condition = homepage.verifyLogo();
		Assert.assertTrue(condition);
	}
	
	@Test(priority=2)
	public void clickOnLoginLinkTest()	{
		emailpage = homepage.clickOnLoginLink();
	}
	
	@AfterMethod
	public void tearDown() throws Exception	{
		Thread.sleep(3000);
		driver.close();
	}

}
