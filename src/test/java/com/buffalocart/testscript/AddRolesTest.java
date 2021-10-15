package com.buffalocart.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddRolesPage;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;

public class AddRolesTest extends Base {
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	RolesPage roles;
	AddRolesPage addrole;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	@Test(priority = 21, enabled = true, description = "TC_021_Verify Add Roles page title")
	public void VerifyAddRolespagetitle() throws IOException, InterruptedException {
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
		addrole = roles.clickOnAddRoles();
		SoftAssert softassert = new SoftAssert();
		String actualPageTitle = addrole.getAddRolespageTitle();
		String expectedPageTitle = "Add Role - Reobeen HHC";
		softassert.assertEquals(actualPageTitle, expectedPageTitle, "Invalid  title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}
	@Test(priority = 22, enabled = true, description = "TC_022_Verify  user can add roles ")
	public void Verifyusercanaddroles () throws IOException, InterruptedException {
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
		addrole = roles.clickOnAddRoles();
		addrole.clickOnRoleName();
		excel = new ExcelUtility(path, "roles");
		addrole.enterRoleName(excel.getStringCellData(0, 0));
		addrole.clickOnUserCheckBox();
			roles=addrole.clickOnSaveButton();
			List<ArrayList<String>> data = roles.getTableData();
			System.out.println(data);
			boolean status = false;
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equals("Accountant"));
				status = true;
				break;
			}
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(status, "Adding role Failed");
			softassert.assertAll();
			signout = home.clickOnUserMenu();
			login = signout.clickOnSignoutButton();
			}

}

