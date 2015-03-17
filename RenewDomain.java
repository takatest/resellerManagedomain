package ManageresellerDomain;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Renew function
 */
public class RenewDomain {

	private static RenewPage	RenewPage  = new RenewPage();		// renew page
	private static ResultPage	ResultPage = new ResultPage();		// renew result page
	
	public void renew(WebDriver driver, String domain, String year){
	
		RenewPage.renew(driver, domain, year);						// renew page
		ResultPage.renewresult(driver, domain, year);				// renew result page
		
	    System.out.println("Renew completed");
	}
}
