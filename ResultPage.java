package ManageresellerDomain;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * renew result page
 */
public class ResultPage {

	public void renewresult(WebDriver driver, String Domain, String year){
		assertEquals(year, driver.findElement(By.xpath("//div[@id='page']/div/table/tbody/tr[4]/td[2]")).getText());// check if year is correct or not
	    driver.findElement(By.linkText("Domain Management Tools")).click();						// click domain manage tool
	}
	/*
	 *  result page for register domain
	 */
	public void regresult(WebDriver driver,String domain){
	    if( domain.endsWith(".eu") ){
			assertEquals("Request deferred", driver.findElement(By.xpath("//div[@id='page']/dl/dd[2]")).getText());		// shows Request deferred
	    }else{
	    	assertEquals("Request processed", driver.findElement(By.xpath("//div[@id='page']/dl/dd[2]")).getText());	// shows Request Processed
	    }
	}
}
