package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
@Test
public class BankManagerLoginTest extends TestBase {
	
	public void loginAsBankManager() throws InterruptedException {

		Log.debug("Bank manager login");
	driver.findElement(By.xpath(OR.getProperty("bmlbtn"))).click();
	Log.debug("Login successfull!!!");
	//Thread.sleep(3000);
	String title = driver.findElement(By.cssSelector(OR.getProperty("valbml"))).getText(); 
	System.out.println(title);
	Assert.assertEquals(title, "Add Customer");
	
	
}
}
