package ManageresellerDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * login to reseller page
 */
public class logintoResellerPage {

	public void login(WebDriver driver,String reseller, String resellerpw){
		driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(reseller);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(resellerpw);
	    driver.findElement(By.id("login")).click();
	}
}
