package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long Page_Load_Timeout = 50;
	public static long Implicitly_Wait = 30;
	
	public void swtichToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] readData(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\swapn\\eclipse-workspace\\PracticePOM\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		System.out.println(lastrow);
		System.out.println(sheet.getRow(1).getLastCellNum());
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i< lastrow; i++)
		{	
			for(int k = 0; k < sheet.getRow(1).getLastCellNum(); k++)
			{
				data[i][k] = (sheet.getRow(i+1).getCell(k).toString());
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Selenium\\Maven\\Error screenshot\\" + System.currentTimeMillis() +".png"));
	}
}
