package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.utils.TestUtils;

public class SignUpPage extends TestUtils{
	
	@FindBy(xpath="//h2[contains(text(),'Register')]")
	WebElement RegisterHeaderText;

	public SignUpPage(WebDriver dr) {
		super(dr);
		PageFactory.initElements(dr, this);
	}
	
	/** Verify the Signup page header text is displayed correctly
	 * 
	 * @return Nothing to be returned
	 */
	public void verifySignUpPageHeader()
	{
		String signUpPageHeader= TestUtils.verifyHeaderText(RegisterHeaderText);
		verifyExpectedResult(signUpPageHeader, "Register");
	}
}