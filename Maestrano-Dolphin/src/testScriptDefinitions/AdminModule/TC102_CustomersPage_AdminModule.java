package testScriptDefinitions.AdminModule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepository.Pg_Home;
import objectRepository.Pg_HomePageMenu;
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;
import objectRepository.Pg_CreatingNewCustomer_Admin;
import objectRepository.Pg_Customers_Admin;

public class TC102_CustomersPage_AdminModule extends UserLibrary 
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
		
		stepstatus = exists(Pg_Home.Wbe_CustomerMangement_AdminDashboard, driver);
		plog = "Step 07: 'Customer Mangement' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 07: 'Customer Mangement' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
		
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
		
		stepstatus = clickElement(Pg_Customers_Admin.Lnk_NewCustomer, driver);
		plog = "Step 11: Able to click on 'New Customer' dropdown on Customers homepage";
		flog = " Step 11: UnAble to click on 'New Customer' dropdown on Customers homepage";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_Customers_Admin.Lnk_CreateACustomer, driver);
		plog = "Step 12: 'Create A Customer' link exists under 'New Customer' dropdown on Customers homepage";
		flog = "Step 12: 'Create A Customer' link does not exists under 'New Customer' dropdown on Customers homepage";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = exists(Pg_Customers_Admin.Lnk_ImportCustomers, driver);
		plog = "Step 13: 'Import Customers' link exists under 'New Customer' dropdown on Customers homepage";
		flog = "Step 13: 'Import Customers' link does not exists under 'New Customer' dropdown on Customers homepage";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = clickElement(Pg_Customers_Admin.Lnk_CreateACustomer, driver);
		plog = "Step 14: Able to click on 'Create A Customer' link under 'New Customer' dropdown on Customers homepage";
		flog = " Step 14: UnAble to click on 'Create A Customer' link under 'New Customer' dropdown on Customers homepage";
		logEvent(stepstatus, plog, flog, driver, false);
		
		//=============================================================================================
		stepstatus = setText(Pg_CreatingNewCustomer_Admin.Edt_OrganisationName, "Customer", driver);
		plog = "Step 15: Able to enter OrganisationName";
		flog = "Step 15: Unable to enter OrganisationName";
		logEvent(stepstatus, plog, flog, driver, false);


		stepstatus = setText(Pg_CreatingNewCustomer_Admin.Edt_Street, "James Street", driver);
		plog = "Step 16:Able to enter Street name";
		flog = "Step 16:Unable to enter Street name";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_CreatingNewCustomer_Admin.Edt_City, "Sydney", driver);
		plog = "Step 17: Able to enter City Name";
		flog = "Step 17: Unable to enter City Name";
		logEvent(stepstatus, plog, flog, driver, false);


		stepstatus = setText(Pg_CreatingNewCustomer_Admin.Edt_State, "Australia", driver);
		plog = "Step 18:Able to enter Street name";
		flog = "Step 18:Unable to enter Street name";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_CreatingNewCustomer_Admin.Edt_PostalCode, "4523578", driver);
		plog = "Step 19: Able to enter PostalCode";
		flog = "Step 19: Unable to enter PostalCode";
		logEvent(stepstatus, plog, flog, driver, false);

		stepstatus = selectOptionByText(Pg_CreatingNewCustomer_Admin.Wbl_Countrycode, "Australia", driver);
		plog = "Step 20:Selected 'Australia' as an option from the Country dropdown";
		flog = " Step 20:UnAble to Select 'Australia' as an option from the Country dropdown";
		logEvent(stepstatus, plog, flog, driver, false);

		stepstatus = setText(Pg_CreatingNewCustomer_Admin.Edt_PhoneNumber, "457861242", driver);
		plog = "Step 21:Able to enter PhoneNumber";
		flog = "Step 21:Unable to enter PhoneNumber";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingNewCustomer_Admin.Btn_Create, driver);
		plog = "Step 22:Able to click on Create Button";
		flog = " Step 22:UnAble to click on Create Button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		wait(5);
		//=============================================================================================

		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 23:Able to click on Name link";
		flog = " Step 23:UnAble to click on Name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 24:Sign out link exists after clicking on name link";
		flog = " Step 24:Sign out link does not exists after clicking on name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 25:Able to click on Signout link";
		flog = " Step 25:UnAble to click on SignIn link";
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
