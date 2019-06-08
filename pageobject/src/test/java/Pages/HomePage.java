package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class HomePage extends Base {
	
	public HomePage()	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Hello, Sign in')]") WebElement loginLink;
	@FindBy(xpath="//*[@class='nav-logo-link']//child::span[1]") WebElement logoAmazon;
	
	public boolean verifyLogo()	{
		boolean condition = logoAmazon.isDisplayed();
		return condition;
	}
	
	public EnterEmailPage clickOnLoginLink()	{
		
		loginLink.click();
		return new EnterEmailPage();
		
	}

}
