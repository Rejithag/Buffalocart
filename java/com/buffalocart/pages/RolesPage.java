package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WebTableUtility;

public class RolesPage {

	WebDriver driver;
	

	/*** pageconstructor ***/
	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*** WebElements ***/
	private final String _addroles = "//div[@class='box-tools']//a[@class='btn btn-block btn-primary']//i";
	@FindBy(xpath = _addroles)
	private WebElement addroles;

	private final String _editroles = "//i[@class='glyphicon glyphicon-edit']";
	@FindBy(xpath = _editroles)
	private WebElement editroles;
	
	private final String _deleteroles = "//button[@class='btn btn-xs btn-danger delete_role_button']";
	@FindBy(xpath = _deleteroles)  
	private WebElement deleteroles;
	
	

	private final String _rElement = "//table[@id='roles_table']//tbody//tr";
	@FindBy(xpath = _rElement)
	private List<WebElement> rowElement;

	private final String _cElement = "//table[@id='roles_table']//tbody//tr//td";
	@FindBy(xpath = _cElement)
	private List<WebElement> colElement;

	/*** UserAction Methods ***/
	public String getRolespageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public AddRolesPage clickOnAddRoles() {
		PageUtility.clickOnElement(addroles);
		return new AddRolesPage(driver);
	}

	public UpdateRolesPage clickOnupdateRoles() {
		PageUtility.clickOnElement(editroles);
		return new UpdateRolesPage(driver);
	}

	public List<ArrayList<String>> getTableData() {
		return WebTableUtility.getGridData(rowElement, colElement);
	}

	public UpdateRolesPage ClickonEditButton(String user) {
		List<ArrayList<WebElement>> grid = WebTableUtility.actionData(rowElement, colElement);
		System.out.println(grid);
		OUTER: for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(0).size(); j++) {
				String data = grid.get(i).get(j).getText();
				if (data.equals(user)) {
					WebElement editbutton = driver.findElement(
							By.xpath("//table[@id='roles_table']//tbody//tr[" + (i + 1) + "]//td[2]//a[1]"));
					PageUtility.clickOnElement(editbutton);
					break OUTER;
				}
			}
		}
		return new UpdateRolesPage(driver);
	}

	public DeleteRolesPage ClickonDeleteButton(String user) {
		List<ArrayList<WebElement>> grid = WebTableUtility.actionData(rowElement, colElement);
		System.out.println(grid);
		OUTER: for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(0).size(); j++) {
				String data = grid.get(i).get(j).getText();
				if (data.equals(user)) {
					WebElement deletebutton = driver.findElement(
							By.xpath("//table[@id='roles_table']//tbody//tr[" + (i + 1) + "]//td[2]//button"));
					PageUtility.clickOnElement(deletebutton);
					break OUTER;
				}
			}
		}
		return new DeleteRolesPage(driver);
	}

	public DeleteRolesPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteroles);
		return new DeleteRolesPage(driver);
	}

}
