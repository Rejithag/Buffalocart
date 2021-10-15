package com.buffalocart.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.utilities.ExcelUtility;

public class ResetTest  extends Base{
	
	
	LoginPage login;
	ExcelUtility excel;
	ResetPage reset;
	SignoutPage signout;
	HomePage home;
	String path=System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 5,enabled=true, description = "TC_005_Verify error meesage displyed on  Reset Password page with invalid email id")
	public void VerifyErrorMessageDisplyedOnResetpasswordWithInvalidEmailId() throws IOException
	{
	excel = new ExcelUtility(path, "Login");
	login=new LoginPage(driver);
	reset=login.clickOnForgotPasswordButton();
	reset.enterResetEmail(excel.getStringCellData(2, 0));
	reset.clickOnResetLinkButton();
	String actualmessage=reset.getErrorMessage();
	String expectedmessage="We can't find a user with that e-mail address.";
	SoftAssert softassert=new SoftAssert();
	softassert.assertEquals(actualmessage,expectedmessage,"invalid error message");
	softassert.assertAll();
	signout = home.clickOnUserMenu();
	login = signout.clickOnSignoutButton();
	}

}
