package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class EnterPasswordPage extends Base {
	
	public EnterPasswordPage()	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ap_password") WebElement enterPassword;
	@FindBy(css = "input#signInSubmit") WebElement clickSigin;
	
	public void enterThePassword(String pass)	{
		enterPassword.sendKeys(pass);
	}
	
	public UserHomePage clickOnSigin()	{
		clickSigin.click();
		return new UserHomePage();
	}

}
