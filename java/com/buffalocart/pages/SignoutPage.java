package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class SignoutPage {
	WebDriver driver;
			/***pageconstructor***/ 
	public SignoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		/*** WebElements ***/
	private final String _signout="//div[@class='pull-right']/a[@class='btn btn-default btn-flat']";
	@FindBy(xpath=_signout)
	private WebElement signout;
	
		/*** UserAction Methods ***/
	
	public LoginPage clickOnSignoutButton() {
		PageUtility.clickOnElement(signout);
		return new LoginPage(driver);
		
	}
}
