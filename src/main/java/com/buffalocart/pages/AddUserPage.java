package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.utilities.PageUtility;

public class AddUserPage {

	WebDriver driver;

			/*** pageconstructor ***/
	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

			/*** WebElements ***/

	private final String _prefix = "//input[@id='surname']";
	@FindBy(xpath = _prefix)
	private WebElement prefix;

	private final String _firstname = "//input[@id='first_name']";
	@FindBy(xpath = _firstname)
	private WebElement firstname;

	private final String _lastname = "//input[@id='last_name']";
	@FindBy(xpath = _lastname)
	private WebElement lastname;

	private final String _salesPercentage = "//input[@id='cmmsn_percent']";
	@FindBy(xpath = _salesPercentage)
	private WebElement salesPercentage;

	private final String _saveButton = "submit_user_button";
	@FindBy(id = _saveButton)
	private WebElement saveButton;

	private final String _errorMessage = "//label[@id='email-error']";
	@FindBy(xpath = _errorMessage)
	private WebElement errorMessage;
	
	private final String _email = "//input[@id='email']";
	@FindBy(xpath = _email)
	private WebElement email;
	
	private final String _role = "input#email";
	@FindBy(css = _role)
	private WebElement role;
	
	private final String _password =  "password";
	@FindBy(id = _password)
	private WebElement password;
	
	private final String _confirmpassword =  "confirm_password";
	@FindBy(id = _confirmpassword)
	private WebElement confirmpassword;
	
	private final String _addUserRole = "//select[@id='role']";
	@FindBy(xpath = _addUserRole)
	private WebElement addUserRole;

			/*** UserAction Methods ***/

	public void enterPrefix(String pre) {
		PageUtility.enterText(prefix, pre);

	}

	public void enterFirstName(String fname) {
		PageUtility.enterText(firstname, fname);

	}

	public void enterLastName(String lname) {
		PageUtility.enterText(lastname, lname);

	}

	public AddUserPage clickOnSaveButton() {
		PageUtility.clickOnElement(saveButton);
		return new AddUserPage(driver);

		
	}

	public String getErrorMessage() {
		return PageUtility.getElementText(errorMessage);
	}

	public String getAddUserspageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public void enterEmail(String mail) {
		
		PageUtility.enterText(email, mail);
	}

	public void enterRole(String rle) {
		PageUtility.enterText(role, rle);

	}

	public void enterPassword(String pass) {
		PageUtility.enterText(password, pass);

	}

	public void enterConfirmPassword(String cpass) {
		PageUtility.enterText(confirmpassword, cpass);
		

	}

	
	  public void enterSalesPercentage(double percentage) {
		  String s=String.valueOf(percentage);  
	     PageUtility.enterText(salesPercentage, s);
	  
	  
	  }

	public List<String> getOptionsFromRoleDropdown() {
		Select select = new Select(addUserRole);
		List<WebElement> roles=PageUtility.getDropdownOptions(select);
		List<String> actualroles = new ArrayList<String>();
		for (int i = 0; i <roles.size(); i++) {
			actualroles.add(roles.get(i).getText());
	}
		return actualroles;
	}
	 

}
