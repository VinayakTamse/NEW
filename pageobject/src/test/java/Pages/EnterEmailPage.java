package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class EnterEmailPage extends Base{
	
	public EnterEmailPage()	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using="email") WebElement enterEmail;
	@FindBy(how = How.CSS, using="input#continue") WebElement clickContinue;
	
	public void enterTheEmail(String Email)	{
		enterEmail.sendKeys(Email);
	}
	
	public EnterPasswordPage clickOnContinue()	{
		clickContinue.click();
		return new EnterPasswordPage();
	}

}
