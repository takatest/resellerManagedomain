package ManageresellerDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/* 
 * renew Page
 */
public class RenewPage {

	public void renew(WebDriver driver, String domain, String year){
	    String name = "Renew "+domain;												  	 // create renew link
	    driver.findElement(By.linkText(name)).click();									 // click renew link
	    new Select(driver.findElement(By.id("timeperiod"))).selectByVisibleText(year);	 // select year
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();			 // click submit
	}
}
