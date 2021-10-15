package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WebTableUtility;

public class SalesCommissionPage {
	WebDriver driver;

	/*** pageconstructor ***/
	public SalesCommissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	/*** WebElements ***/
	
	private final String _deletesales = "//button[@class='btn btn-xs btn-danger delete_commsn_agnt_button']";
	@FindBy(xpath = _deletesales)  
	private WebElement deletesales;
	
	private final String _addbutton = "//button[@class='btn btn-primary btn-modal pull-right']";
	@FindBy(xpath = _addbutton)
	private WebElement addbutton;
	
	private final String _updatebutton = "//tbody/tr[1]/td[6]/button[1]";
	@FindBy(xpath = _updatebutton)
	private WebElement updatebutton;
	
	private final String _relement = "//table[@id='users_table']//tbody//tr";
	@FindBy(xpath = _relement)
	private List<WebElement> rElement;
	
	private final String _celement = "//table[@id='users_table']//tbody//tr//td";
	@FindBy(xpath = _celement)
	private List<WebElement> cElement;
	
	
	/*** UserAction Methods ***/
	
	
	
	 public String getSalesCommissionTitle() 
	  { return PageUtility.getPageTitle(driver);
	  }


	public DeleteSalesCommissionAgentsPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deletesales);
		return new DeleteSalesCommissionAgentsPage(driver);
	}
	
	public AddSalesCommissionAgentsPage clickOnAddButton()
	{
		PageUtility.clickOnElement(addbutton);
		return new AddSalesCommissionAgentsPage(driver);
	}
	public List<ArrayList<String>> getTableData()
	{
		return WebTableUtility.getGridData(rElement, cElement);
		
	}


	public UpdateSalesCommissionAgentsPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updatebutton);
		return new UpdateSalesCommissionAgentsPage(driver);
	}

}
