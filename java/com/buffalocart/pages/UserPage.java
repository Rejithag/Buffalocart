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

public class UserPage {

	WebDriver driver;

	/*** pageconstructor ***/
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}

	/*** WebElements ***/

	private final String _userstitle = "//body[1]/div[2]/div[1]/section[1]/h1[1]";
	@FindBy(xpath = _userstitle)
	private WebElement userstitle;
	
	private final String _userSearch = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _userSearch)  
	private WebElement userSearch;
	
	private final String _adduser = "//div[@class='box-tools']//a//i";
	@FindBy(xpath = _adduser)
	private WebElement adduser;
	
	private final String _rElement = "//table[@id='users_table']//tbody//tr";
	@FindBy(xpath = _rElement) 
	private List<WebElement> rowElement;
	
	private final String _cElement = "//table[@id='users_table']//tbody//tr//td";
	@FindBy(xpath = _cElement) 
	private List<WebElement> colElement;
	
	private final String _edituser = "//table[@id='users_table']//tbody//tr//td//a[@class='btn btn-xs btn-primary']";
	@FindBy(xpath = _edituser)  
	private WebElement edituser;
	
	private final String _deleteuser = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deleteuser)  
	private WebElement deleteuser;
	
	
	


	/*** UserAction Methods ***/

	
	  public String getUserpageTitle() 
	  { return PageUtility.getPageTitle(driver);
	  }
	  public void enterSearchKey(String uSearch) {
		  
		//String s= String.valueOf(userSearch);
		PageUtility.enterText(userSearch, uSearch);
	}

	public AddUserPage clickOnAddUser() {
		
		PageUtility.clickOnElement(adduser);
		return new AddUserPage(driver);
	}

	public UserPage clickOnSearch() {
		PageUtility.clickOnElement(userSearch);
		return new UserPage(driver);
		
	}
		public UpdateUserPage clickOnEditButton() {
		
		PageUtility.clickOnElement(edituser);
		return new UpdateUserPage(driver);
	}
	public List<ArrayList<String>> getTableData() {
		return WebTableUtility.getGridData(rowElement, colElement);

	}
	
	public void ClickonEditButton(String user){
		   List<ArrayList<WebElement>> grid = WebTableUtility.actionData(rowElement,colElement);

		   for(int i=0; i<grid.size(); i++){

		      for(int j=0; j<grid.get(0).size(); j++)
		      {
		         String data =grid.get(i).get(j).getText();

		         if(data.equals("mr ivan able"))
		         {
		            WebElement edit = driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr["+(i+1)+"]//td[5]//a[1]"));
		            edit.click();
		         }
		      }

		   }
		}



		public void ClickonViewButton(String user){
		   List<ArrayList<WebElement>> grid = WebTableUtility.actionData(rowElement,colElement);

		   for(int i=0; i<grid.size(); i++){

		      for(int j=0; j<grid.get(0).size(); j++)
		      {
		         String data =grid.get(i).get(j).getText();

		         if(data.equals("mr ivan able"))
		         {
		            WebElement view = driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr["+(i+1)+"]//td[5]//a[2]"));
		            view.click();
		         }
		      }

		   }
		}



		public void ClickonDelete(String user){
		   List<ArrayList<WebElement>> grid = WebTableUtility.actionData(rowElement,colElement);

		   for(int i=0; i<grid.size(); i++){

		      for(int j=0; j<grid.get(0).size(); j++)
		      {
		         String data =grid.get(i).get(j).getText();

		         if(data.equals("mr ivan able"))
		         {
		            WebElement delete = driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr["+(i+1)+"]//td[5]//button"));
		            delete.click();
		         }
		      }

		   }
	}
		public DeleteUserPage clickOnDeleteButton() {
			PageUtility.clickOnElement(deleteuser);
			return new DeleteUserPage(driver);
		}
}

	
	 

		

