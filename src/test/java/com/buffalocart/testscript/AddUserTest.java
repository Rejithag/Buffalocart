package com.buffalocart.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;

public class AddUserTest extends Base {
	

	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	UserPage users;
	AddUserPage adduser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 12, enabled = true, description = "TC_012_Verify the error message displayed without filling mandatory fields in add user form")
	public void VerifyErrorMessageWithoutFillingFieldsInAddUser() throws IOException {

		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		adduser = users.clickOnAddUser();
		excel = new ExcelUtility(path, "adduser");
		adduser.enterPrefix(excel.getStringCellData(1, 0));
		adduser.enterFirstName(excel.getStringCellData(1, 1));
		adduser.enterLastName(excel.getStringCellData(1, 2));
		// adduser.enterSalesPercentage(excel.getNumericCellData(1, 9));
		adduser.clickOnSaveButton();
		SoftAssert softassert = new SoftAssert();
		String actualErrorMessage = adduser.getErrorMessage();
		String expectedErrorMessage = "This field is required.";
		softassert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 14, enabled = true, description = "TC_014_Verify  Add Users page title")
	public void verifyAddUserspageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		adduser = users.clickOnAddUser();
		SoftAssert softassert = new SoftAssert();
		String actualPageTitle = adduser.getAddUserspageTitle();
		String expectedPageTitle = "Add user - Reobeen HHC";
		softassert.assertEquals(actualPageTitle, expectedPageTitle, "Invalid add userpage title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}
	@Test(priority = 15,enabled = true, description = "TC_015_Verify User can AddUser Details")
	public void verifyUserCanAddUserDetails() throws IOException
	
	{
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		adduser = users.clickOnAddUser();
		excel = new ExcelUtility(path, "adduser");
		adduser.enterPrefix(excel.getStringCellData(1, 0));
		adduser.enterFirstName(excel.getStringCellData(1, 1));
		adduser.enterLastName(excel.getStringCellData(1, 2));
		adduser.enterEmail(excel.getStringCellData(1, 3));
		adduser.enterRole(excel.getStringCellData(1, 4));
		adduser.enterPassword(excel.getStringCellData(1, 6));
		adduser.enterConfirmPassword(excel.getStringCellData(1, 7));
		adduser.enterSalesPercentage(excel.getNumericCellData(1, 8));
		adduser.clickOnSaveButton();
		List<ArrayList<String>> data = users.getTableData();
		System.out.println(data);
		boolean status=false;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(excel.getStringCellData(1, 3)));
			status=true;
			break;
			}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status);
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}
}