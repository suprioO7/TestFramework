package com.crm.qa.pages;

import java.awt.Window;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@type='email']")
	WebElement Email_Phone;
	
	@FindBy(xpath="//input[@type='password'][@id='pass']")
	WebElement password;
	
	@FindBy(xpath="//a[@role='button'][@class='_42ft _4jy0 _517i _517h _51sy']")
	WebElement languageBtn;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement logInBtn;
	
	@FindBy(xpath="//a[@id='js_vp']")
	WebElement english_US_language;
	
	@FindBy(xpath="//li[contains(text(), 'English (UK)')]")
	WebElement main_page_english_US_language;

	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String selectlanguage(){
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 250)");
		languageBtn.click();
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
	
	
}
