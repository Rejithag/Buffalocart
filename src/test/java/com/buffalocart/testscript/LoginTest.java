package com.buffalocart.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.utilities.ExcelUtility;

public class LoginTest extends Base {
	
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 1, enabled = true, description = "TC_001 _verifyLoginPageTitle")
	public void verifyLoginPageTitle() {
		login = new LoginPage(driver);
		String actualTitle = login.getLoginpageTitle();
		String expectedTitle = "Login - Demo POS";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid login page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		

	}

	@Test(priority = 2, enabled = true, description = "TC_002_ verifyUserLoginWithValidUserCredentials")
	public void verifyUserLoginWithValidUserCredentials() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		boolean actualLogoStatus = home.getHomePageLogoStatus();
		SoftAssert sassert = new SoftAssert();
		sassert.assertTrue(actualLogoStatus, "login failed");
		sassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		

	}

	@Test(priority = 3, enabled = true, description = "TC_003_Verify the error message displayed for user login with invalid credentials")
	public void verifyUserLoginWithInvalidUserCredentials() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(2, 0));
		login.enterpassword(excel.getStringCellData(2, 1));
		login.clickOnLoginButton();
		String actualTextStatus = login.getInvalidLoginMessage();
		String expectedTextStatus = "These credentials do not match our records.";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTextStatus, expectedTextStatus, "Successful Login");
		softassert.assertAll();

	}

	@Test(priority = 4, enabled = true, description = "TC_004_Verify whetehr the user is able to click on 'Remember me' checkbox")
	public void verifyUserAbleToClickOnRememeberMeCheckbox() throws IOException {
		login = new LoginPage(driver);
		login.clickOnRememebermeCheckbox();
		boolean checkboxStatus = login.getRemembermeStatus();
		SoftAssert softassert = new SoftAssert();

		softassert.assertTrue(checkboxStatus, "Unable to check the Rememeberme checkbox");
		softassert.assertAll();
	}
}
