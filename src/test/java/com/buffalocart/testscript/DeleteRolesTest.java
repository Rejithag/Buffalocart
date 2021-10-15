package com.buffalocart.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddRolesPage;
import com.buffalocart.pages.DeleteRolesPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class DeleteRolesTest extends Base {

	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	RolesPage roles;
	AddRolesPage addrole;
	DeleteRolesPage delroles;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 25, enabled = true, description = "TC_025_Verify user can delete a role from the list")
	public void VerifyUserCanDeleteAroleFromList() throws IOException, InterruptedException {
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
		delroles=roles.clickOnDeleteButton();
		roles=delroles.clickOnAlertButton();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

}
}
