package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void emailOrPhoneTest(){
		Boolean title = loginPage.validateUsername();
		Assert.assertTrue(title, "Email or Phone field is enabled");
	}
	
	@Test(priority=2)
	public void passwordFieldTest(){
		Boolean pass = loginPage.validatePassword();
		Assert.assertTrue(pass, "Password field is enabled");
	}
	
	@Test(priority=3)
	public void signInButtonTest(){
		Boolean loginBtn = loginPage.validateLoginButton();
		Assert.assertTrue(loginBtn, "Login Button is enabled");
	}
	
	@Test(priority=4)
	public void languageSelect(){
		 String lang=loginPage.selectlanguage();
		Assert.assertEquals(lang, "English (UK)", "English is selected language");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
