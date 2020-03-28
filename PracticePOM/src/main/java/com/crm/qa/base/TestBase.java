package com.crm.qa.base;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
		
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/swapn/eclipse-workspace/PracticePOM/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName =prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32(version80)\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		/*else if (browserName.equals("firefox"));
		{
			System.setProperty("webdriver.gecko.driver","");
			driver = new FirefoxDriver();
		}*/
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}

}
