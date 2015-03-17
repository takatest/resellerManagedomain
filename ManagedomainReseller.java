package ManageresellerDomain;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import RegisterReseller.TaskBar;;

/*
 * reseller Management Test
 */
public class ManagedomainReseller {

	private FirefoxDriver 		driver;									// FireFox driver
	private String 				baseUrl = "https://reseller.php5.mit/";	//URL stage
	private String 				reseller = "test";						// reseller ID
	private String				resellerpw = "test";					// reseller password
	private static int			domain_num = 2;			
	private static String[] 	domain = {"takatestrenewsuite","takarenewreseller","takatestb5","takatestb10"};// domain name
	private static String []	domainspace = {"info","org","net","com","biz"};	// domain space
	private int 				year = 1;											// year	
	private static String 		years;
//	private int					time = 5000;
	
	private static logintoResellerPage	logintoResellerPage = new logintoResellerPage();		// login to reseller
	private static RenewDomain			RenewDomain	  		= new RenewDomain();				// renew 
	private static SearchManage		SearchManage  = new SearchManage();							// search domain for manage 
	private static ContactUpdateReseller ContactUpdateReseller = new ContactUpdateReseller(); 	// update contact
	private static DelegateReseller DelegateReseller = new DelegateReseller();					// delegation
	private static TaskBar			TaskBar				= new TaskBar();						// change task bar
	
	@BeforeTest
	public void BeforeTest() {
		driver = new FirefoxDriver();
		driver.get(baseUrl+"login");							// open reseller page
		logintoResellerPage.login(driver,reseller,resellerpw);	// login to reseller page

		driver.findElement(By.id("domainmanage_nav")).click();	// click manage Tab

		// create year 
		if ( year == 1){
			years = year +" year";
		}else{
			years = year +" years";
		}
	}

/*	@BeforeMethod
	public void BeforeMethod(){
//		driver.get(baseUrl); 
	}
*/	
	
	// set up data
	@DataProvider(name = "GetDomain")
	public static Object[][] domainName() {
		Object[][] data = new Object[domain_num][2];
		for (int k = 0; k<domain_num; k++){
			data[k][0] = k; 
			data[k][1]= domain[0]+"."+domainspace[k];
		}
		return data;
	}

/********************************************************************************************
 * 	
 * Manage domain name test for reseller
 * 
 ********************************************************************************************/
	@Test(dataProvider = "GetDomain")
	public void managedomain(int count, String domain){
	
		System.out.println((count+1)+"-"+domain+" - "+years);
		SearchManage.search(driver, domain);										// search domain for manage

	    System.out.print("  1 ");
	    RenewDomain.renew(driver, domain, years);									// renew under manage domain
	    
	    System.out.print("  2 ");
	    ContactUpdateReseller.update(driver, domain);								//ContactUpdate
	
/*	    System.out.print("  3 ");
	    DelegateReseller.delegate(driver, domain);									// Delegation
*/
	    TaskBar.manage(driver);														// click Manage on the top of task bar
	    driver.findElement(By.linkText("Manage a different domain name")).click();	// click manage a different domain name
	    System.out.println("");
	}
	// wait method
	public void waitwhle(int time){
	    try {
	    	Thread.sleep(time);	// wait 10 second
	    } catch (InterruptedException e) {
	    }
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Manage Domain Completed");
		driver.quit();
	}
}
