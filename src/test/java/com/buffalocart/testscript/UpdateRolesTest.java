package com.buffalocart.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddRolesPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UpdateRolesPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class UpdateRolesTest extends Base {
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	RolesPage roles;
	UpdateRolesPage updaterole;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	@Test(priority = 23, enabled = true, description = "TC_023_Verify Edit Role page title")
	public void VerifyEditRolepagetitle() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		Thread.sleep(1000);
		roles = usermanage.clickOnRolesSubMenu();
		updaterole = roles.clickOnupdateRoles();
		SoftAssert softassert = new SoftAssert();
		String actualPageTitle = updaterole.getRolesUpdatepageTitle();
		String expectedPageTitle = "Edit Role - Reobeen HHC";
		softassert.assertEquals(actualPageTitle, expectedPageTitle, "Invalid  title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}
	
	@Test(priority = 24,enabled=true, description = "TC_024_Verify user can update a role ")
	public void verifyUserCanUpdateRole () throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		Thread.sleep(1000);
		roles = usermanage.clickOnRolesSubMenu();
		updaterole = roles.clickOnupdateRoles();
		updaterole.clickOnRoleName();
		excel = new ExcelUtility(path, "update role name");
		updaterole.enterupdateRoleName(excel.getStringCellData(0, 0));
	roles=updaterole.clickOnUpdateButton();
		List<ArrayList<String>> updateTableData = roles.getTableData();
	boolean status = false;
	for (int i = 0; i < updateTableData.size(); i++) {
	if (updateTableData.get(i).equals("Chief Accountant"));
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
