package com.qa.regressionsuite.testcases;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;
import com.qa.base.BasePage;
import com.qa.extentereport.ExtentTestManager;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.Constants;
import com.qa.utils.ExcelUtil;

public class Reg_Test1_Demo extends BasePage
{
	
	public BasePage basePage;
	public Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
	}
	
	@org.testng.annotations.Test
	public void test1() throws InterruptedException
	{
		System.out.println("test111...");
		ExtentTestManager.getTest().log(Status.INFO, "test1......");
		
		loginPage.doLaunch_URL(prop.getProperty("demo3_url"));
		Thread.sleep(100);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Reg test1......completed..!!");
	}

	
	@org.testng.annotations.Test
	public void test2()
	{
		System.out.println("Reg...test2..");
		ExtentTestManager.getTest().log(Status.INFO, "....test2 ------");
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][] = ExcelUtil.getTestData(Constants.TEST_DATA_SHEET_NAME);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}