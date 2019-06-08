package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class UserHomePage extends Base{
	
	public UserHomePage()	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Hello, Vijay')]") WebElement userName;
	@FindBy(xpath="//*[text()='Sign Out']") WebElement signOut;
	
	public boolean verifyUserName()	{
		return userName.isDisplayed();
	}
	
	public void clickOnSignOut()	{
		new Actions(driver).moveToElement(userName).moveToElement(signOut).click(signOut).build().perform();
	}

}
