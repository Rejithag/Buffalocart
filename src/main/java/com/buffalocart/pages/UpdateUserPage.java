package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UpdateUserPage {

	WebDriver driver;

	/*** pageconstructor ***/
	public UpdateUserPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _editlastname = "last_name";
	@FindBy(id = _editlastname)
	private WebElement editlastname;
	
	private final String _updateButton = "//button[@id='submit_user_button']";
	@FindBy(xpath= _updateButton)
	private WebElement updateButton;

	
	/*** UserAction Methods ***/
	
	 public String getUserUpdatepageTitle() 
	  { return PageUtility.getPageTitle(driver);
	  }

	public void enterEditUsersDetails(String lastname) {
		PageUtility.enterText(editlastname, lastname);
		
	}

	public UserPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return new UserPage(driver);
	}

	public void enterLastnameInEdit(String lastname) {
		PageUtility.enterText(editlastname, lastname);
		
		
	}

}
