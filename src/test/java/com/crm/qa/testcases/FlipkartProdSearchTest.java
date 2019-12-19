package com.crm.qa.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FlipkartProdSearch;
import com.crm.qa.pages.LoginPage;

public class FlipkartProdSearchTest extends TestBase {
	FlipkartProdSearch flipkartprodsearch;
	String sheetName="SignIn";
	
	
	
	public FlipkartProdSearchTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		flipkartprodsearch = new FlipkartProdSearch();	
	}
	
	@Test()
	public void priceTest() throws Exception{
		
		String a = flipkartprodsearch.clickOnIPhoneModel();
		Assert.assertEquals("69,999", a, "Price matched");
		
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
