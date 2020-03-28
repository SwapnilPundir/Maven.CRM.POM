package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long Page_Load_Timeout = 20;
	public static long Implicitly_Wait = 10;
	
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

}
