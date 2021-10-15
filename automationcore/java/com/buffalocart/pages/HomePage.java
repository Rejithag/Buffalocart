package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
			/***pageconstructor***/ 
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
			/*** WebElements ***/
	
	private final String _endtour="//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath=_endtour)
	private WebElement endtour;
	
	private final String _hometitle="//span[@class='logo-lg']";
	@FindBy(xpath=_hometitle)
	private WebElement hometitle;   
	
	private final String _usermenu="//a[@class='dropdown-toggle']//span";
	@FindBy(xpath=_usermenu)
	private WebElement usermenu;
	
		
	private final String _datetext="//div[@class='m-8 pull-left mt-15 hidden-xs']";
	@FindBy(xpath=_datetext)
	private WebElement datetext;
	
	private final String _sidebarmenu="//ul[@class='sidebar-menu']";
	@FindBy(xpath=_sidebarmenu) 
	private WebElement sidebarmenu;
	
		/*** UserAction Methods ***/
	
	public HomePage clickOnEndTour() {
		PageUtility.clickOnElement(endtour);
		return new HomePage(driver);
		
	}
	public boolean getHomePageLogoStatus() {
		 return PageUtility.isElementDisplayed(hometitle);
	}
	public SignoutPage clickOnUserMenu() {
		PageUtility.clickOnElement(usermenu);
		return new SignoutPage(driver);
		}
	public String getHomepageTitle() {
		return PageUtility.getPageTitle(driver);
	}
	
	public String getHomeDate() {
		return PageUtility.getElementText(datetext);
		
	}
	public SideBarPage navigateToSidebar() {
		PageUtility.clickOnElement(sidebarmenu);
		return new SideBarPage(driver);
	}
	
}
