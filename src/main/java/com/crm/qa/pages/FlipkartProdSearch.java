package com.crm.qa.pages;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class FlipkartProdSearch extends TestBase {
	
TestUtil utilities= new TestUtil();
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@type='text']")
	WebElement Serach_TxtBox;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement Search_btn;
	
	@FindBy(xpath="//div[@class='_3wU53n']")
	WebElement list_Iphone;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement iphone_Price;
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	WebElement login_popUp_box_cancel_btn;
	
	
	
	
	
		
	//Initializing the Page Objects:
	public FlipkartProdSearch(){
		PageFactory.initElements(driver, this);
	}
	
	public String clickOnIPhoneModel() throws Exception
	{	
		if(login_popUp_box_cancel_btn.isEnabled())
		{
			login_popUp_box_cancel_btn.click();
		}
		
		Thread.sleep(3000);
		Serach_TxtBox.sendKeys("Apple Iphone");
		Search_btn.click();
		List<WebElement> iphonList= driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		for (WebElement s: iphonList)
		{
			String phonName=s.getText().trim();
			if(phonName.contains("Apple iPhone X (Space Gray, 64 GB)"))
			{
				s.click();
				Thread.sleep(3000);
				break;	
					
			}
			
		}
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(newTab.get(1));
	    String price=iphone_Price.getText().substring(1).trim();
		return price;
		
	}


}
