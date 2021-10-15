package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class DeleteSalesCommissionAgentsPage {

	WebDriver driver;

	/*** pageconstructor ***/
	public DeleteSalesCommissionAgentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	/*** WebElements ***/
	private final String _alertokbutton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _alertokbutton)
	private WebElement alertokbutton;
	
	/*** WebElements ***/

	public SalesCommissionPage clickOnAlertButton() {
		PageUtility.clickOnElement(alertokbutton);
		return new SalesCommissionPage(driver);
	}

}
