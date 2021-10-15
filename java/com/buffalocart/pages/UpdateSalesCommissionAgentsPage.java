package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UpdateSalesCommissionAgentsPage {
	WebDriver driver;

	/*** pageconstructor ***/
public UpdateSalesCommissionAgentsPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);

}
}
