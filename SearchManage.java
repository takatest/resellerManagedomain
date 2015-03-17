package ManageresellerDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * search domain for manage domain
 */
public class SearchManage {

	public void search( WebDriver driver, String domain ){
	    driver.findElement(By.id("domain")).clear();
	    driver.findElement(By.id("domain")).sendKeys(domain);	// enter domain name
	    driver.findElement(By.id("send")).click();				// click manage domain name
	}
}
