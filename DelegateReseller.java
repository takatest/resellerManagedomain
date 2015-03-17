package ManageresellerDomain;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DelegateReseller {

	public void delegate(WebDriver driver, String domain){
		driver.findElement(By.xpath("//a[text()='Delegation Details']")).click(); // contact tab
		
		String newname = "Modify Delegation Details for "+domain;
		driver.findElement(By.linkText(newname)).click();				// click Modify Delegation Details
		
		driver.findElement(By.id("nameserver2")).clear();
	    driver.findElement(By.id("nameserver2")).sendKeys("rns3.melbourneit.com.au");
		driver.findElement(By.id("send")).click();
		
		 assertEquals("Your request was processed successfully.", driver.findElement(By.xpath("//div[@id='manage_delegation']/p")).getText());
// not working  	    driver.findElement(By.xpath("//a[contains(text(),'General Information')]")).click();// go to General Information
		System.out.println("Delegate DNS completed");
	}
}
