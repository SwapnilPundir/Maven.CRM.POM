package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//OR - Objects of the login page.
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;
		
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String verifyHomePageTitle() {
	return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
	return userNameLabel.isDisplayed();
	
	}
	
	public ContactsPage clicksOnContacts() {
	contactsLink.click();
	return new ContactsPage();
	}
	
	public DealsPage clicksOnDeals() {
	dealsLink.click();
	return new DealsPage();
	}
	
	public void clicksNewContactlink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}
	
}