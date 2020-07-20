package com.crm.qa.TestScripts;

import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;

public class LoginTest extends BaseClass{
	
	@Test(testName="LoginPageValidation", groups= {"loginNotRequired"})
	public void LoginPageValidation()
	{
		test=extent.createTest("LoginPageValidation");
		loginPage.verifyLoginTitle();
	}
	
	@Test (testName="TestValidLogin", groups= {"loginRequired"})
	public void TestValidLogin()
	{
		System.out.println("Test report");
		//Assert.fail("Failed intentionally");
//loginPage.login();
		homePage.getLoggedUser();
	}
	
	@Test
	public void TestInvalidLogin()
	{
		test=extent.createTest("TestInvalidLogin");
		loginPage.verifyInvalidLogin();
	}
	
	@Test
	public void TestForgotPassword()
	{
		test=extent.createTest("TestForgotPassword");
		loginPage.forgotPassword();
	}
	
	@Test
	public void TestClassicCRM()
	{
		test=extent.createTest("TestClassicCRM");
		loginPage.classicCRM();
		classicCRM.verifyClassicCRMPageTitle();
	}
	
	@Test
	public void TestSignUp()
	{
		test=extent.createTest("TestSignUp");
		loginPage.clickOnSignUpLink();
		signUpPage.verifySignUpPageHeader();
	}
}
