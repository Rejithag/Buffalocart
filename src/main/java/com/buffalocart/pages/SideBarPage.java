package com.buffalocart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class SideBarPage {
	WebDriver driver;
			/***pageconstructor***/ 
	public SideBarPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
			/*** WebElements ***/
	
	private final String _usermanagementmenu="//span[contains(text(),'User Management')]/parent::a/parent::li";
	@FindBy(xpath=_usermanagementmenu)
	private WebElement usermanagementmenu;
	
			/*** UserAction Methods ***/
	public UserManagementPage clickOnUserManagementBar() {
		
			PageUtility.clickOnElement(usermanagementmenu);
			//System.out.println("Clicked UserManagement Menu");
		    return new UserManagementPage(driver);
	}

}
