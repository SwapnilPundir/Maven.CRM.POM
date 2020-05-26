package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	String sheetname = "contacts";
	
	public ContactsPageTest() {
	super();
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Class name - "+ this.getClass().getName() + "| Thread no. = " +Thread.currentThread().getId());	initialization();
	testUtil = new TestUtil();
	loginpage = new LoginPage();
	contactsPage = new ContactsPage();
	dealsPage = new DealsPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.swtichToFrame();
	}
	
	@Test(priority=1)
	public void verifyContactsPageTest() {
		homepage.clicksOnContacts();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts name is mising on the page");
	}
	
	@Test(priority=2)
	public void clickOnContactsTest() {
		homepage.clicksOnContacts();
		contactsPage.selectContactsByName("Demo Contact");
	}
	
	@DataProvider
	public Object[][] getTestData() throws IOException {
		Object [][] data = TestUtil.readData(sheetname);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getTestData")
	public void createNewContactTest(String title, String firstname, String lastname, String companyname) {
		homepage.clicksNewContactlink();
		contactsPage.createNewContact(title, firstname, lastname,companyname);
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
