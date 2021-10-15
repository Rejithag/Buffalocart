package com.buffalocart.testscript;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.utilities.CalendarUtility;
import com.buffalocart.utilities.ExcelUtility;

public class HomeTest extends Base {
	
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 6, enabled = true, description = "TC_006_Verify home page title")
	public void verifyHomepageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actualTitle = home.getHomepageTitle();
		String expectedTitle = "Home - Reobeen HHC";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid home page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

	@Test(priority = 7, enabled = true, description = "TC_007_Verify date displayed in home page ")
	public void VerifyDateDisplayedInHomepage() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterusername(excel.getStringCellData(1, 0));
		login.enterpassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actualDate = home.getHomeDate();
		String expetedDate = CalendarUtility.getCurrentDate();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualDate, expetedDate, "Invalid date");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}
}
