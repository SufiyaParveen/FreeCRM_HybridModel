package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class LoginPage extends TestUtils{
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[text()='Something went wrong...']")
	WebElement invalidUserMsgText;

	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//h2[text()='Forgot my password']")
	WebElement forgotPasswordPageHeader;
	
	@FindBy(xpath="//a[text()='Classic CRM']")
	WebElement classicCRMLink;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
		
	public LoginPage(WebDriver dr) {
		super(dr);
		PageFactory.initElements(dr, this);
	}
	
//Actions: Methods/Features
	
		/** Reads Login page title and checks for correct page title   
		 * @return Nothing to be returned 
		 */
		public void verifyLoginTitle()
		{
			String title=getPageTitle();
			verifyExpectedResult(title, "Cogmento CRM");
		}
	
		/** Fetches user credentials and log into the application   
		 * @return Nothing to be returned 
		 */
		public void login()
		{
			//String emailText=BaseClass.propertiesFile.getProperty("email");
			TestUtils.sendKeysIn(emailTextbox,BaseClass.propertiesFile.getProperty("email"));
			TestUtils.sendKeysIn(passwordTextbox, BaseClass.propertiesFile.getProperty("password"));
			TestUtils.clickOn(LoginButton);
		}
		
		/** Validates the Invalid user and reads error message  
		 * @return String of error message
		 */
		public void verifyInvalidLogin()
		{
			TestUtils.clickOn(LoginButton);	
			String InvalidMsgText=verifyHeaderText(invalidUserMsgText);
			verifyExpectedResult(InvalidMsgText, "Something went wrong...");
		}
		
		/** Clicks on Forgot Password link and fetches page header text on "Forgot Password" page 
		 * @return Forgot Password Page Header text as a String 
		 */	
		public void forgotPassword()
		{
			TestUtils.clickOn(forgotPasswordLink);
			String ActualForgotPasswordPageHeader= TestUtils.verifyHeaderText(forgotPasswordPageHeader);
			verifyExpectedResult(ActualForgotPasswordPageHeader, "Forgot my password");
		
		}
		
		/** Clicks on classicCRM link  
		 * @return Nothing to be returned 
		 */
		public void classicCRM()
		{
			TestUtils.clickOn(classicCRMLink);
		}
		
		/** Clicks on SignUp link   
		 * @return Nothing to be returned 
		 */
		public void clickOnSignUpLink()
		{
			TestUtils.clickOn(signUpLink);
		}
	
	
	

}
