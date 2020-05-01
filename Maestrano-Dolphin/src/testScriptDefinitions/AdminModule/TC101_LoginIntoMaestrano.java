package testScriptDefinitions.AdminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.Pg_Home;
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;
import objectRepository.Pg_Customers_Admin;

public class TC101_LoginIntoMaestrano extends UserLibrary 
{
  String plog;
  String flog;
  boolean stepstatus;
  @Test
  public void scriptDefinition() 
  {
		WebDriver driver = launchBrowser("chrome");
		driver = SetImplicitWait(20, driver);

		stepstatus = OpenUrl(getdata("URL"), driver);
		plog = "Step 01: Able to launch the application";
		flog = "Step 01: Unable to launch Application";
		logEvent(stepstatus, plog, flog, driver, true);
		
		stepstatus = clickElement(Pg_LoginMaestrano.Btn_Login, driver);
		plog = "Step 02:Clicked on Login Button successfully";
		flog = " Step 02:Unable to click on login button";
		logEvent(stepstatus, plog, flog, driver, false);

		stepstatus = setText(Pg_LoginMaestrano.Edt_EmailID, getdata("UserName"), driver);
		plog = "Step 03: Able to enter username";
		flog = "Step 03: Unable to enter username";
		logEvent(stepstatus, plog, flog, driver, false);

		stepstatus = setText(Pg_LoginMaestrano.Edt_Pwd, getdata("Password"), driver);
		plog = "Step 04:Able to enter Password";
		flog = "Step 04:Unable to enter Password";
		logEvent(stepstatus, plog, flog, driver, false);

		stepstatus = clickElement(Pg_LoginMaestrano.Btn_SignIn, driver);
		plog = "Step 05:Able to click on SignIn";
		flog = " Step 05:UnAble to click on SignIn";
		logEvent(stepstatus, plog, flog, driver, false);

		stepstatus = exists(Pg_Home.Lnk_AdminDashboard, driver);
		plog = "Step 06:Admin Dashboard exists on HomePage";
		flog = "Step 06:Admin Dashboard does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		//====================================================================================
		stepstatus = exists(Pg_Home.Wbe_CustomerMangement_AdminDashboard, driver);
		plog = "Step 07: 'Customer Mangement' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 07: 'Customer Mangement' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		//====================================================================================
		WebElement CustomersLink_Admin= driver.findElement(By.xpath("(//*[text()='Customers'])[1]"));
		boolean CustomerLink_DisplayedStatus=CustomersLink_Admin.isDisplayed();
		System.out.println("Customer Link displayed status is: "+CustomerLink_DisplayedStatus);
		
		if(CustomerLink_DisplayedStatus==true)
		{
			stepstatus = exists(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 08: 'Customers' link exists on Dashboard of Admin HomePage";
			flog = "Step 08: 'Customers' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 09:Able to click on 'Customers' Link on Home page of Admin";
			flog = " Step 09:UnAble to click on 'Customers' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 10: 'New Customer' dropdown exists on 'Customers' home Page";
			flog = "Step 10:  'New Customer' dropdown does not exists on 'Customers' home Page";
			logEvent(stepstatus, plog, flog, driver, true); 
		}
		
		//====================================================================================
		
		WebElement OrdersLink_Admin= driver.findElement(By.xpath("(//*[text()='Orders'])[1]"));
		boolean OrdersLink_DisplayedStatus=OrdersLink_Admin.isDisplayed();
		System.out.println("Orders Link displayed status is: "+OrdersLink_DisplayedStatus);
		
		if(OrdersLink_DisplayedStatus==true)
		{
			stepstatus = exists(Pg_Home.Lnk_Admin_Orders, driver);
			plog = "Step 11: 'Orders' link exists on Dashboard of Admin HomePage";
			flog = "Step 11: 'Orders' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Home.Lnk_Admin_Orders, driver);
			plog = "Step 12:Able to click on 'Orders' Link on Dashboard of Admin page";
			flog = " Step 12:UnAble to click on 'Orders' Link on Dashboard of Admin page";
			logEvent(stepstatus, plog, flog, driver, false);
			
		}
		
		
		//====================================================================================
		
	
		stepstatus = exists(Pg_Home.Wbe_ProductMangement_AdminDashboard, driver);
		plog = "Step 13: 'Product Mangement' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 13: 'Product Mangement' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		//====================================================================================
		
		WebElement ProductsLink_Admin= driver.findElement(By.xpath("(//*[text()='Products'])[1]"));
		boolean ProductsLink_DisplayedStatus=ProductsLink_Admin.isDisplayed();
		System.out.println("Products Link displayed status is: "+ProductsLink_DisplayedStatus);
		
		if(ProductsLink_DisplayedStatus==true)
		{
			stepstatus = exists(Pg_Home.Lnk_Admin_Products, driver);
			plog = "Step 14: 'Products' link exists on Dashboard of Admin HomePage";
			flog = "Step 14: 'Products' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
					
			stepstatus = clickElement(Pg_Home.Lnk_Admin_Products, driver);
			plog = "Step 15: Able to click on 'Products' Link on Home page of Admin";
			flog = " Step 15: UnAble to click on 'Products' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
		}
				
		
				
//====================================================================================
	
		
//		WebElement MyProductsLink_Admin= driver.findElement(By.xpath("(//*[text()='My Products'])[1]"));
//		boolean MyProductsLink_DisplayedStatus=MyProductsLink_Admin.isDisplayed();
//		System.out.println("MyProducts Link displayed status is: "+MyProductsLink_DisplayedStatus);
//		
//		if(MyProductsLink_DisplayedStatus==true)
//		{
//
//			stepstatus = exists(Pg_Home.Lnk_Admin_MyProducts, driver);
//			plog = "Step 16: 'My Products' link exists on Dashboard of Admin HomePage";
//			flog = "Step 16: 'My Products' link does not exists on Dashboard of Admin HomePage";
//			logEvent(stepstatus, plog, flog, driver, true); 
//					
//			stepstatus = clickElement(Pg_Home.Lnk_Admin_MyProducts, driver);
//			plog = "Step 17: Able to click on 'My Products' Link on Home page of Admin";
//			flog = " Step 17: UnAble to click on 'My Products' Link on Home page of Admin";
//			logEvent(stepstatus, plog, flog, driver, false);
//		}
		
		
		
		//====================================================================================
		
//		WebElement PriceListLink_Admin= driver.findElement(By.xpath("(//*[text()='Price List'])[1]"));
//		boolean PriceListLink_DisplayedStatus=PriceListLink_Admin.isDisplayed();
//		System.out.println("PriceList Link displayed status is: "+PriceListLink_DisplayedStatus);
//		
//		if(PriceListLink_DisplayedStatus==true)
//		{
//		
//		stepstatus = exists(Pg_Home.Lnk_Admin_PriceList, driver);
//		plog = "Step 18: 'Price List' link exists on Dashboard of Admin HomePage";
//		flog = "Step 18: 'Price List' link does not exists on Dashboard of Admin HomePage";
//		logEvent(stepstatus, plog, flog, driver, true); 
//						
//		stepstatus = clickElement(Pg_Home.Lnk_Admin_PriceList, driver);
//		plog = "Step 19: Able to click on 'Price List' Link on Home page of Admin";
//		flog = " Step 19: UnAble to click on 'Price List' Link on Home page of Admin";
//		logEvent(stepstatus, plog, flog, driver, false);
				
		//}
		//====================================================================================
		
			
			stepstatus= exists(Pg_Home.Wbe_WebStore_AdminDashboard, driver);
			plog = "Step 20: 'WebStore' webelement exists on Dashboard of Admin HomePage";
			flog = "Step 20: 'WebStore' webelement does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
					
			//====================================================================================
			
			WebElement StaffLink_Admin= driver.findElement(By.xpath("(//*[text()='Staff'])[1]"));
			boolean StaffLink_DisplayedStatus=StaffLink_Admin.isDisplayed();
			System.out.println("Staff Link displayed status is: "+StaffLink_DisplayedStatus);
			
			if(StaffLink_DisplayedStatus==true)
			{
					
			stepstatus = exists(Pg_Home.Lnk_Admin_Staff, driver);
			plog = "Step 21: 'Staff' link exists on Dashboard of Admin HomePage";
			flog = "Step 21: 'Staff' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
					
			stepstatus = clickElement(Pg_Home.Lnk_Admin_Staff, driver);
			plog = "Step 22: Able to click on 'Staff' Link on Home page of Admin";
			flog = " Step 22: UnAble to click on 'Staff' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			}
					
		   //====================================================================================
			
			WebElement QuestionsLink_Admin= driver.findElement(By.xpath("(//*[text()='Questions'])[1]"));
			boolean QuestionsLink_DisplayedStatus=QuestionsLink_Admin.isDisplayed();
			System.out.println("Admin Link displayed status is: "+QuestionsLink_DisplayedStatus);
			
			if(QuestionsLink_DisplayedStatus==true)
			{
			
			
			stepstatus = exists(Pg_Home.Lnk_Admin_Questions, driver);
			plog = "Step 23: 'Questions' link exists on Dashboard of Admin HomePage";
			flog = "Step 23: 'Questions' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
					
			stepstatus = clickElement(Pg_Home.Lnk_Admin_Questions, driver);
			plog = "Step 24: Able to click on 'Questions' Link on Home page of Admin";
			flog = " Step 24: UnAble to click on 'Questions' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			}
			
			 //====================================================================================
		
			
			stepstatus = exists(Pg_Home.Wbe_Settings_AdminDashboard, driver);
			plog = "Step 25: 'Settings' webelement exists on Dashboard of Admin HomePage";
			flog = "Step 25: 'Settings' webelement does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
					
			//====================================================================================
					
			stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
			plog = "Step 26: 'General' link exists on Dashboard of Admin HomePage";
			flog = "Step 26: 'General' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
					
			stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
			plog = "Step 27: Able to click on 'General' Link on Home page of Admin";
			flog = " Step 27: UnAble to click on 'General' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
					
	//====================================================================================
			
			
			stepstatus = exists(Pg_Home.Lnk_Admin_Plugins, driver);
			plog = "Step 28: 'Plugins' link exists on Dashboard of Admin HomePage";
			flog = "Step 28: 'Plugins' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 

					
	//====================================================================================
			
	
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 32:Able to click on SignIn";
		flog = " Step 32:UnAble to click on SignIn";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 33:Able to click on SignIn";
		flog = " Step 33:UnAble to click on SignIn";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 34:Able to click on SignIn";
		flog = " Step 34:UnAble to click on SignIn";
		logEvent(stepstatus, plog, flog, driver, false);
		
		quitDriver(driver);
  } 
  
  @BeforeTest
  public void setUp()
  {
	  SetUp();
  }
  @AfterTest
  public void tearDown()
  {
	  TearDown();
  }
}
