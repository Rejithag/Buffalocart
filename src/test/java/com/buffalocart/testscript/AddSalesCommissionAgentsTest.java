package com.buffalocart.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddSalesCommissionAgentsPage;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesCommissionPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;

public class AddSalesCommissionAgentsTest extends Base {
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	UserPage users;
	AddUserPage adduser;
	SalesCommissionPage sales;
	AddSalesCommissionAgentsPage addsale;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	 @Test(priority = 28,enabled=true, description = "TC_028_Verify user can sales agent ")

		public void VerifyUserCanSalesAgent () throws IOException, InterruptedException {
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
			addsale=sales.clickOnAddButton();
			excel = new ExcelUtility(path, "SalesCommsionAgent");
			addsale.enterPrefix(excel.getStringCellData(1, 0));
			addsale.enterFirstname(excel.getStringCellData(1, 1));
			addsale.enterLastname(excel.getStringCellData(1, 2));
			addsale.enterEmail(excel.getStringCellData(1, 3));
			addsale.enterContact(excel.getStringCellData(1, 4));
			addsale.enterAddress(excel.getStringCellData(1, 5));
			addsale.enterSalesPercentage(excel.getStringCellData(1, 6));
			sales=addsale.clickOnSaveButton();
			List<ArrayList<String>> data = sales.getTableData();
			System.out.println(data);
			boolean status = false;
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equals(excel.getStringCellData(1, 3)));
				status = true;
				break;
			}
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(status, "Adding  Failed");
			softassert.assertAll();
			signout = home.clickOnUserMenu();
			login = signout.clickOnSignoutButton();
			
	 }
}

