package testcases;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	//dataProviderClass=TestUtil.class, 
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void OpenAccountTest(String customer, String currency, String alerttext) throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("openacc"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("custrname"))).click();
		Select s = new Select(driver.findElement(By.cssSelector(OR.getProperty("custrname"))));
		Log.debug("Clicked on customer");
		s.selectByVisibleText(customer);
		Select ss = new Select(driver.findElement(By.cssSelector(OR.getProperty("curncy"))));
		ss.selectByVisibleText(currency);
		driver.findElement(By.xpath(OR.getProperty("process"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Log.debug("Account for the customer"+" "+customer+" "+"is opened");
	}	
		
		
	
}

