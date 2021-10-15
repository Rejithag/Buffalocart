package com.buffalocart.testscript;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.DeleteUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;

public class DeleteUserTest extends Base {
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	UserPage users;
	AddUserPage adduser;
	DeleteUserPage delpage;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	@Test(priority = 18, enabled = true, description = "TC_018_Verify user can delete a user")
	public void VerifyUserCanDeleteUser() throws IOException {

		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		users = usermanage.clickOnUsersSubMenu();
		delpage=users.clickOnDeleteButton();
		//delpage.switchToAlertWindow(alert);
		users=delpage.clickOnAlertButton();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

}
}
