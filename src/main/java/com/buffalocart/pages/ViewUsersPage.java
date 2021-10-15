package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewUsersPage {

	WebDriver driver;

	/*** pageconstructor ***/
	public ViewUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	
	/*** UserAction Methods ***/

}
