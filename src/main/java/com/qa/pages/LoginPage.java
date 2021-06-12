package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.qa.base.BasePage;
import com.qa.extentereport.ExtentTestManager;
import com.qa.utils.ElementUtil;

public class LoginPage extends BasePage{

	public WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	// 1. By locators -- OR
	By signin_link=By.xpath("//a[normalize-space()='Sign in']");
	By txtusername = By.id("email");
	By txtpassword=By.id("passwd");
	By loginBtn=By.id("SubmitLogin");

	public void doLaunch_URL(String url) throws InterruptedException
	{
		
		elementUtil.get(url);
		ExtentTestManager.getTest().log(Status.INFO, "URL Launched......");
		Thread.sleep(3000);
	}
	public HomePage doLogin(String username, String password) 
	{
		try
		{
			Thread.sleep(9000);
			elementUtil.doClick(this.signin_link);
			Thread.sleep(9000);
			elementUtil.waitForElementPresent(this.txtusername, 60);
			Thread.sleep(3000);
			elementUtil.doSendKeys(this.txtusername, username);
			ExtentTestManager.getTest().log(Status.INFO, "Entered user name is : "+username);
			elementUtil.doSendKeys(this.txtpassword, password);
			ExtentTestManager.getTest().log(Status.INFO, "Entered password is : "+password);
			elementUtil.doClick(this.loginBtn);
			ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login button.....");
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new HomePage(driver);
	
	}
	
}