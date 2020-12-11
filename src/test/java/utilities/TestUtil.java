package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase {
	public WebDriver driver;

	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m)
	{
		
		String sheetName = m.getName();
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++)
		{
			for(int colNum =0; colNum < cols; colNum++ )
			{
				//data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}
		return data;
	}

	
}
