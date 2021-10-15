package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;


public class LoginPage {
	WebDriver driver;

			/***pageconstructor***/ 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
			/*** WebElements ***/
	private final String _email = "username";
	@FindBy(id = _email)
	private WebElement username;
	
	private final String _password = "password";
	@FindBy(id = _password)
	private WebElement pass;
	
	private final String _login="button[class='btn btn-primary']";
	@FindBy(css=_login)
	private WebElement login;
	
	private final String _invalidmessage = "//span[@class='help-block']//strong";
	@FindBy(xpath = _invalidmessage)
	private WebElement invalidmessage;
	
	private final String _remembermecheckbox = "//input[@name='remember']";
	@FindBy(xpath = _remembermecheckbox)
	private WebElement remembermecheckbox;
	
	private final String _forgotpassword = "//a[@class='btn btn-link']";
	@FindBy(xpath = _forgotpassword)
	private WebElement forgotpassword;
	
	private final String _loginheading="//div[@class='panel-heading']";
	@FindBy(xpath=_loginheading)
	private WebElement loginheading;

	
		/*** UserAction Methods ***/
	
	public String getLoginpageTitle() {
		return PageUtility.getPageTitle(driver);
	}
	public void  enterusername(String uname) {
		PageUtility.enterText(username, uname);
		}
	public void enterpassword(String password) {
		PageUtility.enterText(pass, password);
	}
	public HomePage clickOnLoginButton() {
		PageUtility.clickOnElement(login);
		return new HomePage(driver);
		
	}
	public String getInvalidLoginMessage() {
		return PageUtility.getElementText(invalidmessage);
	}

		public void clickOnRememebermeCheckbox()
		{
		PageUtility.clickOnElement(remembermecheckbox);
		}
		
		public boolean getRemembermeStatus()
		{
		return PageUtility.isElementSelected(remembermecheckbox);
		}
		public ResetPage clickOnForgotPasswordButton() {
			 PageUtility.clickOnElement(forgotpassword);
			 return new ResetPage(driver);
			
		}
		public boolean getLoginlogoStatus() {
			return PageUtility.isElementDisplayed(loginheading);
		}
		
	
	
}
