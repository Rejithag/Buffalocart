package com.buffalocart.testscript;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SalesCommissionPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class SalesCommissionTest extends Base{
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	SalesCommissionPage sales;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 27, enabled = true, description = "TC_020_Verify  Sales Commission Agents page title")
	public void VerifySalesCommissionAgentspagetitle() throws IOException, InterruptedException {
		
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		Thread.sleep(1000);
		sales=usermanage.clickOnSalesCommissionMenu();
		String actualTitle=sales.getSalesCommissionTitle();
		String expectedTitle="Sales Commission Agents - Reobeen HHC";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "invalid  page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
		
	}
	

}
