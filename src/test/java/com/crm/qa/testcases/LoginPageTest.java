package com.crm.qa.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	String sheetName="SignIn";
	
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(enabled=false)
	public void emailOrPhoneTest(){
		Boolean title = loginPage.validateUsername();
		Assert.assertTrue(title, "Email or Phone field is enabled");
	}
	
	@Test(enabled=false)
	public void passwordFieldTest(){
		Boolean pass = loginPage.validatePassword();
		Assert.assertTrue(pass, "Password field is enabled");
	}
	
	@Test(enabled=false)
	public void signInButtonTest(){
		Boolean loginBtn = loginPage.validateLoginButton();
		Assert.assertTrue(loginBtn, "Login Button is enabled");
	}
	
	@Test(enabled=false)
	public void languageSelect(){
		 String lang=loginPage.selectlanguage();
		Assert.assertEquals(lang, "English (UK)", "English is selected language");
	}
	
	@Test(dataProvider="getSignUpData")
	public void faceBookSignUp(String FN, String LN, String Mobile, String Pass, String DOB, String gender)
	{
		String[] dobObj=DOB.split("-");
		String dd=dobObj[0];
		String mm=dobObj[1];
		String yy=dobObj[2];
		 loginPage.SignIn(FN,LN,Mobile,Pass,dd,mm,yy,gender);
	}
	
	@DataProvider
	public Object[][] getSignUpData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	

	
	
	
	
	
	@AfterMethod
	
	public void screenShot(ITestResult result) throws Exception
	{
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
			if(ITestResult.FAILURE==result.getStatus()){
				try{
					// To create reference of TakesScreenshot
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					// Call method to capture screenshot
					File src=screenshot.getScreenshotAs(OutputType.FILE);
					// Copy files to specific location 
					// result.getName() will return name of test case so that screenshot name will be same as test case name
					FileUtils.copyFile(src, new File("C:\\Users\\suprio\\git\\PageObjectModel\\FacbookLogin\\screenshots\\TC"+result.getName() + System.currentTimeMillis() + ".png"));
					System.out.println("Successfully captured a screenshot");
				}catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
		}
		Thread.sleep(3000);
		driver.quit();
		}
	

	
}
