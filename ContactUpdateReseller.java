package ManageresellerDomain;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUpdateReseller {

	public void update(WebDriver driver,String domain){
		
		String newname = "Modify Contact Information for "+domain;
		driver.findElement(By.xpath("//a[text()='Contact Details']")).click(); // contact tab
		
	    driver.findElement(By.linkText(newname)).click();
		driver.findElement(By.name("registrant_organisation")).clear();
	    driver.findElement(By.name("registrant_organisation")).sendKeys("update org");
	    driver.findElement(By.name("registrant_email")).clear();
	    driver.findElement(By.name("registrant_email")).sendKeys("takashi.komuro@melbourneit.com.au");
	    driver.findElement(By.name("registrant_address_line1")).clear();
	    driver.findElement(By.name("registrant_address_line1")).sendKeys("Level 3");
	    driver.findElement(By.name("registrant_address_line2")).clear();
	    driver.findElement(By.name("registrant_address_line2")).sendKeys("269 Latrobe st");
	    new Select(driver.findElement(By.name("registrant_address_countrycode"))).selectByVisibleText("Australia");
	    driver.findElement(By.name("admin_familyname")).clear();
	    driver.findElement(By.name("admin_familyname")).sendKeys("Department updated");
	    driver.findElement(By.name("admin_organisation")).clear();
	    driver.findElement(By.name("admin_organisation")).sendKeys("Melbourne ITT");
	    driver.findElement(By.name("admin_address_line2")).clear();
	    driver.findElement(By.name("admin_address_line2")).sendKeys("269 Latrobe st");
	    new Select(driver.findElement(By.name("admin_address_countrycode"))).selectByVisibleText("Australia");
	    driver.findElement(By.name("bill_familyname")).clear();
	    driver.findElement(By.name("bill_familyname")).sendKeys("Department updated");
	    driver.findElement(By.name("bill_organisation")).clear();
	    driver.findElement(By.name("bill_organisation")).sendKeys("Melbourne IT T");
	    driver.findElement(By.name("bill_address_line1")).clear();
	    driver.findElement(By.name("bill_address_line1")).sendKeys("269 Latrobe st");
	    driver.findElement(By.name("bill_address_line2")).clear();
	    driver.findElement(By.name("bill_address_line2")).sendKeys("");
	    new Select(driver.findElement(By.name("bill_address_countrycode"))).selectByVisibleText("Australia");
	    driver.findElement(By.name("tech_familyname")).clear();
	    driver.findElement(By.name("tech_familyname")).sendKeys("Department updated");
	    driver.findElement(By.name("tech_organisation")).clear();
	    driver.findElement(By.name("tech_organisation")).sendKeys("Melbourne IT upda");
	    driver.findElement(By.name("tech_address_line1")).clear();
	    driver.findElement(By.name("tech_address_line1")).sendKeys("269 Latrobe st");
	    driver.findElement(By.name("tech_address_line2")).clear();
	    driver.findElement(By.name("tech_address_line2")).sendKeys("");
	    new Select(driver.findElement(By.name("tech_address_countrycode"))).selectByVisibleText("Australia");
	    driver.findElement(By.cssSelector("button.btn")).click();
	    assertEquals("Request processed", driver.findElement(By.xpath("//div[@id='registration']/dl/dd[2]")).getText());
	    driver.findElement(By.linkText("Return to Menu")).click();
	
	    System.out.println("Update contact completed");
	}
}
