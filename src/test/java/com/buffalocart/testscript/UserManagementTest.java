package com.buffalocart.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class UserManagementTest extends Base {
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 9, enabled = true, description = "TC_009_Verify the Usermangement sub tabs")
	public void VerifUsermangementSubTabs() throws IOException {

		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		List<String> actualUserManageBar = usermanage.getUserManagementSubmenu();

		excel = new ExcelUtility(path, "usermanagementsubmenu");
		List<String> expectedUserManageBar = excel.getListCellData();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualUserManageBar, expectedUserManageBar, "invalid menu option");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

}
