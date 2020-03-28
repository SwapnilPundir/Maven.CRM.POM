package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
	super();
	}
	
	@BeforeMethod
	public void setup() {
	initialization();
	testUtil = new TestUtil();
	loginpage = new LoginPage();
	contactsPage = new ContactsPage();
	dealsPage = new DealsPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Homepage title does not match");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.swtichToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void clickOnContactsTest() {
		testUtil.swtichToFrame();
		contactsPage = homepage.clicksOnContacts();	
	}
	
	@Test(priority=4)
	public void clicksOnDeals() {
		testUtil.swtichToFrame();
		dealsPage = homepage.clicksOnDeals();	
	}

	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
