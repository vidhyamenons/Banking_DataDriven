package testcases;

import org.apache.commons.math3.stat.inference.TestUtils;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;



public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(String firstname, String Lastname, String postcode, String alerttext) throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("addcustr"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("fstname"))).sendKeys(firstname);
		driver.findElement(By.cssSelector(OR.getProperty("lstname"))).sendKeys(Lastname);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
		driver.findElement(By.cssSelector(OR.getProperty("submit"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Log.debug("Account for customer"+" "+firstname+" "+Lastname+" "+"is succesfully added");
		
		
		
	}

	
}
