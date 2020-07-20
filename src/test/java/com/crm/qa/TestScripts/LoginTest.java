package com.crm.qa.TestScripts;

import org.testng.annotations.Test;
import com.crm.qa.base.BaseClass;

public class LoginTest extends BaseClass{
	
	@Test
	public void LoginPageValidation()
	{
		loginPage.verifyLoginTitle();
	}
	
	@Test
	public void TestValidLogin()
	{
		loginPage.login();
		homePage.getLoggedUser();
	}
	
	@Test
	public void TestInvalidLogin()
	{
		loginPage.verifyInvalidLogin();
	}
	
	@Test
	public void TestForgotPassword()
	{
		loginPage.forgotPassword();
	}
	
	@Test
	public void TestClassicCRM()
	{
		loginPage.classicCRM();
		classicCRM.verifyClassicCRMPageTitle();
	}
	
	@Test
	public void TestSignUp()
	{
		loginPage.clickOnSignUpLink();
		signUpPage.verifySignUpPageHeader();
	}
}
