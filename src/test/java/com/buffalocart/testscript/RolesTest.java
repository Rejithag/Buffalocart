package com.buffalocart.testscript;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SideBarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;

public class RolesTest extends Base {
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SideBarPage sidebar;
	UserManagementPage usermanage;
	SignoutPage signout;
	RolesPage role;
	UserPage users;
	AddUserPage adduser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 20, enabled = true, description = "TC_020_Verify Roles page title")
	public void VerifyRolesPageTitle() throws IOException, InterruptedException {
		
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.navigateToSidebar();
		usermanage = sidebar.clickOnUserManagementBar();
		Thread.sleep(1000);
		role=usermanage.clickOnRolesSubMenu();
		String actualTitle=role.getRolespageTitle();
		String expectedTitle="Roles - Reobeen HHC";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "invalid user page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
		
	}
	
	 @Test(priority = 26,enabled=true, description = "TC_026_Verify whether the added role in Role page is listed in roles field in user add page")
		public void verifyAddedRoleInUserAddpage() throws IOException, InterruptedException {
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
			adduser = users.clickOnAddUser();
			List<String> actualRoleNames=adduser.getOptionsFromRoleDropdown();
			boolean actualRoleName=false;
			for(int i=0;i<actualRoleNames.size();i++)
			{
				if(actualRoleNames.get(i).equals("Accountant"))
				{
					actualRoleName=true;
					break;
				}
			}
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(actualRoleName, "Rolename not found ");
			softassert.assertAll();
			signout = home.clickOnUserMenu();
			login = signout.clickOnSignoutButton();
			
		}
	
	
	
	

}
