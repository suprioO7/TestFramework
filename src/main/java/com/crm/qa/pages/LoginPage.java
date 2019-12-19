package com.crm.qa.pages;

import java.awt.Window;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	TestUtil utilities= new TestUtil();
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@type='email']")
	WebElement Email_Phone;
	
	@FindBy(xpath="//input[@type='password'][@id='pass']")
	WebElement password;
	
	@FindBy(xpath="//a[@role='button'][@class='_42ft _4jy0 _517i _517h _51sy']")
	WebElement languageBtn;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement logInBtn;
	
	@FindBy(xpath="//a[contains(text(),'English (US)')]")
	WebElement english_US_language;
	
	@FindBy(xpath="//li[contains(text(), 'English (UK)')]")
	WebElement main_page_english_US_language;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement first_name_txtBox;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement last_name_txtBox;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	WebElement mobile_number_txtBox;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	WebElement password_txtBox;
	
	@FindBy(xpath="//select[@name='birthday_day']")
	WebElement DOB_day_dropDown;
	
	@FindBy(xpath="//select[@name='birthday_month']")
	WebElement DOB_month_dropDown;
	
	@FindBy(xpath="//select[@name='birthday_year']")
	WebElement DOB_year_dropDown;
	
	@FindBy(xpath="//label[contains(text(),'Male')]/..//input")
	WebElement gender_CheckBox;
	
	@FindBy(xpath="//button[@type='submit'][@name='websubmit']")
	WebElement signIn_btn;
	

	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String selectlanguage() 
	{	 
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 250)");
		languageBtn.click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", english_US_language);
		 */
		english_US_language.click();
		
		 
		  return main_page_english_US_language.getText();
		  
		
		
		
	}
	
	public boolean validateUsername(){
		return Email_Phone.isEnabled();
	}
	
	public boolean validatePassword(){
		return password.isEnabled();
	}
	
	public boolean validateLoginButton(){
		return logInBtn.isEnabled();
	}
	
	public void SignIn(String FN, String LN, String mobileNo, String pass, String DOB_day,String DOB_month, String DOB_year, String gender)
	{
		first_name_txtBox.clear();
		first_name_txtBox.sendKeys(FN);
		last_name_txtBox.clear();
		last_name_txtBox.sendKeys(LN);
		mobile_number_txtBox.clear();
		mobile_number_txtBox.sendKeys(mobileNo);
		password_txtBox.clear();
		password_txtBox.sendKeys(pass);
		Select dayDD= new Select(DOB_day_dropDown);
		dayDD.selectByValue(DOB_day);
		Select monthDD= new Select(DOB_month_dropDown);
		monthDD.selectByVisibleText(DOB_month);
		Select yearDD= new Select(DOB_year_dropDown);
		yearDD.selectByVisibleText(DOB_year);
		WebElement genderCheckBox= driver.findElement(By.xpath("//label[contains(text(),'"+gender+"')]/..//input"));
		genderCheckBox.click();
		signIn_btn.click();
		

	}
	
	
}
