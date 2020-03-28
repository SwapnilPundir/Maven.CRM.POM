package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath=("//td[contains(text(),'Contacts')]"))
	WebElement contactPageLabel;
	
		
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactPageLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
	driver.findElement(By.xpath(""));
	}
	
	public void createNewContact(String salutation, String ftname, String ltname, String company) {
		Select sel = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		sel.selectByVisibleText(salutation);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(ftname);
		driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(ltname);
		driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(company);
		driver.findElement(By.xpath("//form[@id='contactForm']//input[@type ='submit' and @value = 'Save']")).click();
	}
}
