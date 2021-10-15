package com.buffalocart.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
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
import com.buffalocart.utilities.WaitUtility;

public class UserTest extends Base {
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	UserPage users;
	AddUserPage adduser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 10, enabled = true, description = "TC_010_Verify Users page title")
	public void VerifyUsersPageTitle() throws IOException {

		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		String actualTitle = users.getUserpageTitle();
		String expectedTitle = "Users - Reobeen HHC";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "invalid user page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 11, enabled = true, description = "TC_011_Verify  user search")
	public void VerifyUserSearch() throws IOException, InterruptedException {

		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		users.clickOnSearch();
		excel = new ExcelUtility(path, "UserSearch");
		users.enterSearchKey(excel.getStringCellData(1, 3));
		System.out.println(excel.getStringCellData(1, 3));
		List<ArrayList<String>> tabledata = users.getTableData();
		Thread.sleep(1000);
		System.out.println(tabledata);
		boolean searchStatus = false;
		excel = new ExcelUtility(path, "AddUser");

		for (int i = 0; i < tabledata.size(); i++) {
			if (tabledata.get(i).equals(excel.getStringCellData(2, 3)))
				;
			searchStatus = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(searchStatus, "search Failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

	@Test(priority = 13, enabled = true, description = "TC_013_Verify user login with newly added user")
	public void verifyUserLoginWithNewlyAddedUser() throws IOException {

		/*
		 * excel = new ExcelUtility(path, "Login"); login = new LoginPage(driver);
		 * login.enterusername(excel.getStringCellData(1, 0));
		 * login.enterpassword(excel.getStringCellData(1, 1)); home =
		 * login.clickOnLoginButton(); home.clickOnEndTour(); sidebar =
		 * home.navigateToSidebar(); usermanage = sidebar.clickOnUserManagementBar();
		 * users = usermanage.clickOnUsersSubMenu(); adduser = users.clickOnAddUser();
		 * excel = new ExcelUtility(path, "adduser");
		 * adduser.enterPrefix(excel.getStringCellData(1, 0));
		 * adduser.enterFirstName(excel.getStringCellData(1, 1));
		 * adduser.enterLastName(excel.getStringCellData(1, 2));
		 * adduser.enterEmail(excel.getStringCellData(1, 3));
		 * adduser.enterRole(excel.getStringCellData(1, 4));
		 * adduser.enterPassword(excel.getStringCellData(1, 6));
		 * adduser.enterConfirmPassword(excel.getStringCellData(1, 7));
		 * adduser.enterSalesPercentage(excel.getNumericCellData(1, 8));
		 * adduser.clickOnSaveButton(); signout = home.clickOnUserMenu(); login =
		 * signout.clickOnSignoutButton();
		 */

		
		login = new LoginPage(driver);
		excel = new ExcelUtility(path, "Login");
		login.enterusername(excel.getStringCellData(3,0));
		login.enterpassword(excel.getStringCellData(3,1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

}
