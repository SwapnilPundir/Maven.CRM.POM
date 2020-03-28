package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//OR - Objects of the login page.
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type ='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement CRMLogo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpbtn;
	
	//Initializing the page objects.
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions

	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMLogo() {
		return CRMLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
