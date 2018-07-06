package testScriptDefinitions.AdminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkLibrary.ReusableMethods;
import objectRepository.Pg_Home;
import objectRepository.Pg_HomePageMenu;
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;
import objectRepository.Pg_AddinganApp;
import objectRepository.Pg_CreatingProduct;
import objectRepository.Pg_Customers_Admin;
import objectRepository.Pg_General_Settings;

public class TC104_AddingProducts extends UserLibrary 
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

		
//===========================================================================================================
		stepstatus = exists(Pg_Home.Lnk_AdminDashboard, driver);
		plog = "Step 06:Admin Dashboard exists on HomePage";
		flog = "Step 06:Admin Dashboard does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
		
			
		stepstatus = exists(Pg_Home.Wbe_Settings_AdminDashboard, driver);
		plog = "Step 07: 'Settings' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 07: 'Settings' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
				
		stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 08: 'General' link exists on Dashboard of Admin HomePage";
		flog = "Step 08: 'General' link does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 09: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 09: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		//=======================================================================================
		stepstatus = exists(Pg_General_Settings.WebEle_Settings, driver);
		plog = "Step 10: 'Settings' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 10: 'Settings' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = exists(Pg_General_Settings.WebEle_General, driver);
		plog = "Step 11: 'General' tab exists Settings Page";
		flog = "Step 11: 'General' tab does not exists on Settings Page";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = exists(Pg_General_Settings.Lnk_CustomerFeatures, driver);
		plog = "Step 12: 'Customer Features' tab exists Settings Page";
		flog = "Step 12: 'Customer Features' tab does not exists on Settings Page";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = clickElement(Pg_General_Settings.Lnk_CustomerFeatures, driver);
		plog = "Step 13: Able to click on 'Customer Features' Link on Settings Page";
		flog = " Step 13: UnAble to click on 'Customer Features' Link on Settings Page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		WebElement ProductCatalog= driver.findElement(By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']"));
		boolean ProductCatalog_DisplayedStatus=ProductCatalog.isDisplayed();
		System.out.println("Product Catalog Checkbox displayed status is: "+ProductCatalog_DisplayedStatus);
		
		WebElement ProductCatalog_Enabled= driver.findElement(By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']"));
		boolean ProductCatalog_EnabledStatus=ProductCatalog_Enabled.isEnabled();
		System.out.println("Product Catalog Checkbox Enabled status is: "+ProductCatalog_EnabledStatus);
		
		WebElement ProductCatalog_Selected= driver.findElement(By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']"));
		boolean ProductCatalog_SelectedStatus=ProductCatalog_Selected.isSelected();
		System.out.println("Product Catalog Checkbox Selected status is: "+ProductCatalog_SelectedStatus);
		
		if(ProductCatalog_SelectedStatus==false)
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_ProductCatalog, driver);
			plog = "Step 14: Able to click on 'Your Product Catalog' radiobutton on CustomerFeatures Page";
			flog = " Step 14: Unable to click on 'Your Product Catalog' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 15: Able to click on 'Save' button on Settings Page";
			flog = " Step 15: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(10);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 16: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 16: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 17: Clicked on 'OK' button on popup page";
			flog = " Step 17: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(12);
			

			stepstatus = exists(Pg_Home.Lnk_Admin_MyProducts, driver);
			plog = "Step 18: 'My Products' link exists on Dashboard of Admin HomePage after enabling it in Customer Features tab";
			flog = "Step 18: 'My Products' link does not exists on Dashboard of Admin HomePage after enabling it in Customer Features tab";
			logEvent(stepstatus, plog, flog, driver, true); 
		} 
		
//===========================================================================================================
		

		
			
			wait(7);
					
		stepstatus = clickElement(Pg_Home.Lnk_Admin_MyProducts, driver);
		plog = "Step 19: Able to click on 'My Products' Link on Home page of Admin";
		flog = " Step 19: UnAble to click on 'My Products' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		

		
		
		stepstatus = exists(Pg_CreatingProduct.Btn_CreateProduct, driver);
		plog = "Step 20: 'CreateProduct' button exists on My Products page";
		flog = "Step 20: 'CreateProduct' button does not exists on My Products page";
		logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
					
		stepstatus = clickElement(Pg_CreatingProduct.Btn_CreateProduct, driver);
		plog = "Step 21: Able to click on 'CreateProduct' button on My Products page";
		flog = " Step 21: UnAble to click on 'CreateProduct' button on My Products page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		
		stepstatus = setText(Pg_CreatingProduct.Edt_ProductTitle, "Sample Product", driver);
		plog = "Step 22: Able to enter product name on add product page";
		flog = "Step 22: Unable to enter product name on add product page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Create, driver);
		plog = "Step 23: Able to click on 'Create' button on popup window";
		flog = " Step 23: UnAble to click on 'Create' button on popup window";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		wait(4);
		
		
		stepstatus = exists(Pg_CreatingProduct.WebEle_ProductDescription, driver);
		plog = "Step 24: 'Product Description' WebElement exists on My Products page";
		flog = "Step 24: 'Product Description' WebElement does not exists on My Products page";
		logEvent(stepstatus, plog, flog, driver, true);
		
		//wait(2);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_SupplierName, "Supplier1", driver);
		plog = "Step 25: Able to enter Supplier Name";
		flog = "Step 25: Unable to enter Supplier Name";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_TinyDescription, "Supplier Address", driver);
		plog = "Step 26: Able to enter Tiny Description";
		flog = "Step 26: Unable to enter Tiny Description";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_KeyBenefits, "1 Benefit", driver);
		plog = "Step 27: Able to enter Key Benefits";
		flog = "Step 27: Unable to enter Key Benefits";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Submit, driver);
		plog = "Step 28: Able to click on 'Submit' button";
		flog = " Step 28: UnAble to click on 'Submit' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(7);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_AddPricingPlan, driver);
		plog = "Step 29: Able to click on 'AddPricingPlan' ";
		flog = " Step 29: UnAble to click on 'AddPricingPlan' ";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_Name, "First", driver);
		plog = "Step 30: Able to enter Name in Pricing Plan";
		flog = "Step 30: Unable to enter Name in Pricing Plan";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_Description, "Second", driver);
		plog = "Step 31: Able to enter Description in Pricing Plan";
		flog = "Step 31: Unable to enter Description in Pricing Plan";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = selectOptionByText(Pg_CreatingProduct.Wbl_PricingType, "Fixed recurring", driver);
		plog = "Step 32: Selected 'Fixed Recurring' as an option from 'Pricing Type' dropdown";
		flog = " Step 32: UnAble to 'Fixed Recurring' as an option from 'Pricing Type' dropdown";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(2);
		
		stepstatus = selectOptionByText(Pg_CreatingProduct.Wbl_PerUnit, "Organization", driver);
		plog = "Step 33: Selected 'Organization' as an option from 'PerUnit' dropdwon";
		flog = " Step 33: UnAble to Select 'Organization' as an option from 'PerUnit' dropdwon";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(2);
		
		stepstatus = selectOptionByText(Pg_CreatingProduct.Wbl_PerDuration, "Week", driver);
		plog = "Step 34: Selected 'week' as an option from 'Per Duration' dropdown";
		flog = " Step 34: UnAble to Select 'week' as an option from 'Per Duration' dropdown";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(2);
		
		stepstatus = selectOptionByText(Pg_CreatingProduct.Wbl_Prices, "USD", driver);
		plog = "Step 35: Selected 'USD' as currency type from 'Prices' Type dropdown";
		flog = " Step 35: UnAble to Select 'USD' as currency type from 'Prices' Type dropdown";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(2);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_Price, "25", driver);
		plog = "Step 36: Able to enter amount in price edit box";
		flog = "Step 36: Unable to enter amount in price edit box";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Save, driver);
		plog = "Step 37: Able to click on 'Save' button ";
		flog = " Step 37: UnAble to click on 'Save' button ";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(7);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_DraftPublish, driver);
		plog = "Step 38: Able to click on 'DraftPublish' button ";
		flog = " Step 38: UnAble to click on 'DraftPublish' button ";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(10);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 39:Able to click on SignIn";
		flog = " Step 39:UnAble to click on SignIn";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(7);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AccessCompanyView, driver);
		plog = "Step 40:Able to click on AccessCompanyView link";
		flog = " Step 40:UnAble to click on AccessCompanyView link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		stepstatus = exists(Pg_Home.Wbe_Dashboard, driver);
		plog = "Step 41:Dashboard exists on HomePage";
		flog = "Step 41:Dashboard does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true);
		
		
		wait(2);
		
		
		
		Actions builder=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//*[@class='menu vertical']"));
		builder.moveToElement(ele).build().perform();
		
		wait(2);
		
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_MarketplaceIcon, driver);
		plog = "Step 42: Able to click on MarketplaceIcon icon";
		flog = " Step 42: Unable to click on MarketplaceIcon icon";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_MyWebstoreProducts, driver);
		plog = "Step 43:Able to click on 'My Webstore Products' on marketplace page";
		flog = " Step 43:UnAble to click on 'My Webstore Products' on marketplace page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_PublishedProduct, driver);
		plog = "Step 44:Able to click on the added product";
		flog = " Step 44:UnAble to click on the added product";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Provision, driver);
		plog = "Step 45:Able to click on 'Provision' button";
		flog = " Step 45:UnAble to click on 'Provision' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(2);
		
		stepstatus = clickElement(Pg_CreatingProduct.RadioButton_Provision, driver);
		plog = "Step 46:Able to click on radio button";
		flog = " Step 46:UnAble to click on radio button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Next, driver);
		plog = "Step 47:Able to click on 'Next' button";
		flog = " Step 47:UnAble to click on 'Next' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		wait(2);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Validate, driver);
		plog = "Step 48:Able to click on 'Validate' button";
		flog = " Step 48:UnAble to click on 'Validate' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(7);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_GotoMyApp, driver);
		plog = "Step 49:Able to click on 'GotoMyApp' button";
		flog = " Step 49:UnAble to click on 'GotoMyApp' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		Actions builderr=new Actions(driver);
		WebElement elee=driver.findElement(By.xpath("//*[@class='menu vertical']"));
		builder.moveToElement(elee).build().perform();
		
        wait(2);
        
      
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_SubscriptionsIcon, driver);
		plog = "Step 50:Able to click on 'SubscriptionsIcon' link";
		flog = " Step 50:UnAble to click on 'SubscriptionsIcon' link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		wait(7);

        Actions table=new Actions(driver);
		WebElement el=driver.findElement(By.xpath("//*[@class='well pricing-plans']"));
		builder.moveToElement(el).build().perform();
        
		wait(2);
		
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_SubscriptionsTable, driver);
		plog = "Step 51:Able to click on SampleProduct in SubscriptionsTable";
		flog = " Step 51:UnAble to click on SampleProduct in SubscriptionsTable";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		stepstatus = exists(Pg_CreatingProduct.WebEle_ProvisionStatus, driver);
		plog = "Step 52: ProvisionStatus 'Requested' was observed";
		flog = "Step 52: ProvisionStatus 'Requested' was not observed";
		logEvent(stepstatus, plog, flog, driver, true);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_ClickArrow, driver);
		plog = "Step 53:Able to click on ArrowMark";
		flog = " Step 53:UnAble to click on ArrowMark";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AccessControlPanel, driver);
		plog = "Step 54:Able to click on 'AccessControlPanel' link";
		flog = " Step 54:UnAble to click on 'AccessControlPanel' link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		stepstatus = setText(Pg_CreatingProduct.Edt_OrganisationSearch, "Demo Company11", driver);
		plog = "Step 55:Able to enter the text 'Demo Company11' ";
		flog = "Step 55:Unable to enter the text 'Demo Company11' ";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_DemoCompany11, driver);
		plog = "Step 56:Able to click on 'Demo Company11' link from the search results";
		flog = " Step 56:UnAble to click on 'Demo Company11' link from the search results";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(8);
		
		stepstatus = clickElement(Pg_CreatingProduct.Lnk_ApproveSampleProduct, driver);
		plog = "Step 57:Able to click on 'Sample product' link in the table";
		flog = " Step 57:UnAble to click on 'Sample product' link in the table";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_Approve, driver);
		plog = "Step 58:Able to click on 'Approve' button";
		flog = " Step 58:UnAble to click on 'Approve' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_PopupApprove, driver);
		plog = "Step 59:Able to click on 'Approve' popup  button";
		flog = " Step 59:UnAble to click on 'Approve' popup";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(10);
		
		stepstatus = clickElement(Pg_Home.Lnk_Admin_MyProducts, driver);
		plog = "Step 60: Able to click on 'My Products' Link on Home page of Admin";
		flog = " Step 60: UnAble to click on 'My Products' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_DeletingProduct, driver);
		plog = "Step 61: Able to click on the added product in the table";
		flog = " Step 61: UnAble to click on the added product in the table";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_CreatingProduct.Btn_DeletePopUp, driver);
		plog = "Step 62: Able to click on 'DeletePopUp' button";
		flog = " Step 62: UnAble to click on 'DeletePopUp' button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(6);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 63:Able to click on Name link";
		flog = " Step 63:UnAble to click on Name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 64:Sign out link exists after clicking on name link";
		flog = " Step 64:Sign out link does not exists after clicking on name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 65:Able to click on Signout link";
		flog = " Step 65:UnAble to click on SignIn link";
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
