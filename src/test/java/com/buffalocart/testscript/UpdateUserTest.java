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
import com.buffalocart.pages.UpdateUserPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;

public class UpdateUserTest extends Base {

	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	UserPage users;
	AddUserPage adduser;
	UpdateUserPage upage;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 16, enabled = true, description = "TC_016_Verify Edit User page title")
	public void verifyEditUserpageTitle() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		upage = users.clickOnEditButton();
		SoftAssert softassert = new SoftAssert();
		String actualPageTitle = upage.getUserUpdatepageTitle();
		String expectedPageTitle = "Edit user - Reobeen HHC";
		softassert.assertEquals(actualPageTitle, expectedPageTitle, "Invalid  title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 17, enabled = true, description = "TC_017_Verify user can edit the user details ")
	public void verifyUserCanEditUserDetails() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		Thread.sleep(1000);
		users = usermanage.clickOnUsersSubMenu();
		upage = users.clickOnEditButton();
		excel = new ExcelUtility(path, "UserSearch");
		upage.enterEditUsersDetails(excel.getStringCellData(1, 1));
		upage.enterLastnameInEdit("  .T");
		users = upage.clickOnUpdateButton();
		List<ArrayList<String>> updateDetails = users.getTableData();
		boolean status = false;
		for (int i = 0; i < updateDetails.size(); i++) {
			if (updateDetails.get(i).equals("ivan able"))
				;
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Edit user Failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

}
