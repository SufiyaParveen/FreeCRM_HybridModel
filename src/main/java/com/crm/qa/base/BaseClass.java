package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.crm.qa.pages.ClassicCRM;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static int Page_Load_Time=40;
	public static int Implicit_Wait=30;
	
	public static WebDriver driver;
	public static Properties propertiesFile;
	String userDir=System.getProperty("user.dir");
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ClassicCRM classicCRM;
	public static SignUpPage signUpPage;
	public static ContactsPage contactsPage;
	
	
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
	
	void initialisation() throws Exception
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
		contactsPage=new ContactsPage(driver);
	}

	@BeforeSuite
	public void setExtent()
	{
	   // htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
	    htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/FreeCRM"+TestUtils.getCurrentDateTime()+".html"));
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(false);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "360NDCLP063");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("User", "Sufiya");
		extent.setSystemInfo("Browser", propertiesFile.getProperty("browser"));
	}
		
	@BeforeMethod (groups= {"loginRequired"})
	public void setUp(ITestResult TC) throws Exception
	{
		initialisation();
		System.out.println(TC.getMethod());
		test=extent.createTest(TC.getMethod().getMethodName());
		loginPage.login();
	}
	
	@BeforeMethod(groups= {"loginNotRequired"})
	public void setUp2(ITestResult TC) throws Exception
	{
		initialisation();
		System.out.println(TC.getMethod());
		test=extent.createTest(TC.getMethod().getMethodName());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath=TestUtils.takeScreenshot(result.getName());
			test.log(Status.FAIL, "Test Case Failed is: "+result.getName()+"<div align='right'><a data-featherlight='image' href='"+screenshotPath+"'><img height='40'; src='"+screenshotPath+"'width='80'/></a></div>");
			
			//test.log(Status.INFO,"<a data-featherlight='image' href='"+screenshotPath+"'><img height='40'; src='"+screenshotPath+"'width='80'/></a>");
	//		test.addScreencastFromPath(screenshotPath);
	//		System.out.println("Path:"+screenshotPath);
	//		test.addScreenCaptureFromPath(screenshotPath);
		}
		
		if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case Skip is: "+result.getName());
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passed is: "+result.getName());
		}
		
		driver.quit();
	}
	
	@AfterSuite
	public void endreport()
	{
		extent.flush();	
	}

}
