package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UserManagementPage {
	
	WebDriver driver;
	/***pageconstructor***/ 
	public UserManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*** WebElements ***/
	
	private final String _usermanagementsubmenu="//ul[@class='sidebar-menu']/li[@class='treeview active-sub active']";
	@FindBy(xpath=_usermanagementsubmenu)
	private List<WebElement> usermanagementsubmenu;
	
	private final String _usersmenu="//span[contains(text(),'Users')]/parent::a";
	@FindBy(xpath=_usersmenu)
	private WebElement usersmenu;
	
	private final String _rolesmenu="//span[contains(text(),'Roles')]/parent::a";
	@FindBy(xpath=_rolesmenu)
	private WebElement rolesmenu;
	
	private final String _salesmenu="//span[contains(text(),'Sales Commission Agents')]/parent::a";
	@FindBy(xpath=_salesmenu)
	private WebElement salesmenu;
	
	
	/*** UserAction Methods ***/
	
	public List<String> getUserManagementSubmenu() {
		List<String> submenu = new ArrayList<String>();
		for (int i = 1; i < usermanagementsubmenu.size(); i++) {
		String submenuvalue = usermanagementsubmenu.get(i).getText();
		submenu.add(submenuvalue);
	}
		return submenu;
		

}
	public UserPage clickOnUsersSubMenu() {
		PageUtility.clickOnElement(usersmenu);
		return new UserPage(driver);
		}
	
	public RolesPage clickOnRolesSubMenu() {
		PageUtility.clickOnElement(rolesmenu);
		return new RolesPage(driver);
		
		}
	
	public SalesCommissionPage clickOnSalesCommissionMenu() {
		PageUtility.clickOnElement(salesmenu);
		return new SalesCommissionPage(driver);
		}
}
