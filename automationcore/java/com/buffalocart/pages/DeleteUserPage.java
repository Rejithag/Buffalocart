package com.buffalocart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class DeleteUserPage {

	WebDriver driver;

	/*** pageconstructor ***/
	public DeleteUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*** WebElements ***/
	
	private final String _alertokbutton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _alertokbutton)
	private WebElement alertokbutton;
	
	/*** UserAction Methods  ***/


	/*
	 * public void switchToAlertWindow(Alert alert) {
	 * PageUtility.dismissAlert(alertokbutton, alert);
	 * 
	 * }
	 */

	public UserPage clickOnAlertButton() {
		PageUtility.clickOnElement(alertokbutton);
		return new UserPage(driver);
	}


	


	
	
	

}
