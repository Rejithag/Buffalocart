package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UpdateRolesPage {
	
	WebDriver driver;

	/*** pageconstructor ***/
	public UpdateRolesPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _editrole = "name";
	@FindBy(id = _editrole)
	private WebElement editrole;
	
	private final String _updateButton = "//button[@class='btn btn-primary pull-right']";
	@FindBy(xpath = _updateButton)
	private WebElement updateButton;
	
	/*** UserAction Methods ***/
	
	 public String getRolesUpdatepageTitle() 
	  { return PageUtility.getPageTitle(driver);
	  }

	public void clickOnRoleName() {
		 PageUtility.clickOnElement(editrole);
		
	}

	public void enterupdateRoleName(String rolename) {
		 PageUtility.enterText(editrole, rolename);
		
	}

	public RolesPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return new RolesPage(driver);
	}

}
