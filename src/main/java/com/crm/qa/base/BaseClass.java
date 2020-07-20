package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.crm.qa.pages.ClassicCRM;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static int Page_Load_Time=30;
	public static int Implicit_Wait=30;
	
	
	public static WebDriver driver;
	public static Properties propertiesFile;
	String userDir=System.getProperty("user.dir");
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ClassicCRM classicCRM;
	public static SignUpPage signUpPage;
	
	
	public BaseClass()
	{
			try {
			propertiesFile=new Properties();
			FileInputStream ip=new FileInputStream(userDir+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			propertiesFile.load(ip);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	void initialisation()
	{
		String browserName=propertiesFile.getProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.get(propertiesFile.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Implicit_Wait, TimeUnit.SECONDS);
		
		
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		classicCRM= new ClassicCRM(driver);
		signUpPage= new SignUpPage(driver);
				
	}

	@BeforeTest
	public void setUp()
	{
		initialisation();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
