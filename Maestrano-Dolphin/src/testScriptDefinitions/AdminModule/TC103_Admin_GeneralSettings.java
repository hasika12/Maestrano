package testScriptDefinitions.AdminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkLibrary.ReusableMethods;
import objectRepository.Pg_Home;
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;
import objectRepository.Pg_Customers_Admin;
import objectRepository.Pg_General_Settings;

public class TC103_Admin_GeneralSettings extends UserLibrary 
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

			
		stepstatus = exists(Pg_Home.Wbe_Settings_AdminDashboard, driver);
		plog = "Step 08: 'Settings' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 08: 'Settings' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
				
		stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 09: 'General' link exists on Dashboard of Admin HomePage";
		flog = "Step 09: 'General' link does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 10: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 10: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		//=======================================================================================
		stepstatus = exists(Pg_General_Settings.WebEle_Settings, driver);
		plog = "Step 11: 'Settings' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 11: 'Settings' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = exists(Pg_General_Settings.WebEle_General, driver);
		plog = "Step 12: 'General' tab exists Settings Page";
		flog = "Step 12: 'General' tab does not exists on Settings Page";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = exists(Pg_General_Settings.Lnk_CustomerFeatures, driver);
		plog = "Step 13: 'Customer Features' tab exists Settings Page";
		flog = "Step 13: 'Customer Features' tab does not exists on Settings Page";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = clickElement(Pg_General_Settings.Lnk_CustomerFeatures, driver);
		plog = "Step 14: Able to click on 'Customer Features' Link on Settings Page";
		flog = " Step 14: UnAble to click on 'Customer Features' Link on Settings Page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		//=======================================================================================
		WebElement ProductMarkup_Displayed= driver.findElement(By.xpath("//*[text()='Product Markup']/preceding-sibling::input[@type='checkbox']"));
		boolean Product_DisplayedStatus=ProductMarkup_Displayed.isDisplayed();
		System.out.println("Product Markup Checkbox displayed status is: "+Product_DisplayedStatus);
		
		WebElement ProductMarkup_Enabled= driver.findElement(By.xpath("//*[text()='Product Markup']/preceding-sibling::input[@type='checkbox']"));
		boolean Product_EnabledStatus=ProductMarkup_Enabled.isEnabled();
		System.out.println("Product Markup Checkbox Enabled status is: "+Product_EnabledStatus);
		
		WebElement ProductMarkup_Selected= driver.findElement(By.xpath("//*[text()='Product Markup']/preceding-sibling::input[@type='checkbox']"));
		boolean Product_SelectedStatus=ProductMarkup_Selected.isSelected();
		System.out.println("Product Markup Checkbox Selected status is: "+Product_SelectedStatus);
		
		if(Product_SelectedStatus==true)
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_ProductMarkup, driver);
			plog = "Step 15: Able to click on 'Product Markup' radiobutton on CustomerFeatures Page";
			flog = " Step 15: Unable to click on 'Product Markup' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 16: Able to click on 'Save' button on Settings Page";
			flog = " Step 16: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 17: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 17: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 18: Clicked on 'OK' button on popup page";
			flog = " Step 18: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_Home.Lnk_Admin_PriceList, driver);
			plog = "Step 19: 'Price List' link doesnot exists on Dashboard of Admin HomePage after disabling it in general tab under customer features";
			flog = "Step 19: 'Price List' link exists on Dashboard of Admin HomePage evenafter disabling it in general tab under customer features";
			logEvent(stepstatus, plog, flog, driver, true);
		} 
		
		else
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_ProductMarkup, driver);
			plog = "Step 20: Able to click on 'Product Markup' radiobutton on CustomerFeatures Page";
			flog = " Step 20: Unable to click on 'Product Markup' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 21: Able to click on 'Save' button on Settings Page";
			flog = " Step 21: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(2);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 22: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 22: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 23: Clicked on 'OK' button on popup page";
			flog = " Step 23: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_Home.Lnk_Admin_PriceList, driver);
			plog = "Step 24: 'Price List' link doesnot exists on Dashboard of Admin HomePage after disabling it in general tab under customer features";
			flog = "Step 24: 'Price List' link exists on Dashboard of Admin HomePage evenafter disabling it in general tab under customer features";
			logEvent(stepstatus, plog, flog, driver, true);
			
			wait(7);
		}
		//=====================================================================================================================================
		
		wait(7);
		stepstatus = clickElement(Pg_General_Settings.Lnk_CustomerFeatures, driver);
		plog = "Step 25: Able to click on 'Customer Features' Link on Settings Page";
		flog = " Step 25: UnAble to click on 'Customer Features' Link on Settings Page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		//=======================================================================================
		WebElement ProductCatalog= driver.findElement(By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']"));
		boolean ProductCatalog_DisplayedStatus=ProductCatalog.isDisplayed();
		System.out.println("Product Catalog Checkbox displayed status is: "+ProductCatalog_DisplayedStatus);
		
		WebElement ProductCatalog_Enabled= driver.findElement(By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']"));
		boolean ProductCatalog_EnabledStatus=ProductCatalog_Enabled.isEnabled();
		System.out.println("Product Catalog Checkbox Enabled status is: "+ProductCatalog_EnabledStatus);
		
		WebElement ProductCatalog_Selected= driver.findElement(By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']"));
		boolean ProductCatalog_SelectedStatus=ProductCatalog_Selected.isSelected();
		System.out.println("Product Catalog Checkbox Selected status is: "+ProductCatalog_SelectedStatus);
		
		if(ProductCatalog_SelectedStatus==true)
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_ProductCatalog, driver);
			plog = "Step 26: Able to click on 'Your Product Catalog' radiobutton on CustomerFeatures Page";
			flog = " Step 26: Unable to click on 'Your Product Catalog' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 27: Able to click on 'Save' button on Settings Page";
			flog = " Step 27: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(10);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 28: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 28: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 29: Clicked on 'OK' button on popup page";
			flog = " Step 29: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_Home.Lnk_Admin_MyProducts, driver);
			plog = "Step 30: 'My products' link doesnot exists on Dashboard of Admin HomePage after disabling it in general tab under customer features";
			flog = "Step 30: 'My products' link exists on Dashboard of Admin HomePage evenafter disabling it in general tab under customer features";
			logEvent(stepstatus, plog, flog, driver, true);
		} 
		
		else
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_ProductCatalog, driver);
			plog = "Step 31: Able to click on 'Product Markup' radiobutton on CustomerFeatures Page";
			flog = " Step 31: Unable to click on 'Product Markup' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 32: Able to click on 'Save' button on Settings Page";
			flog = " Step 32: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 33: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 33: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(10);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 34: Clicked on 'OK' button on popup page";
			flog = " Step 34: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			

			stepstatus = exists(Pg_Home.Lnk_Admin_MyProducts, driver);
			plog = "Step 35: 'My Products' link exists on Dashboard of Admin HomePage after enabling it in Customer Features tab";
			flog = "Step 35: 'My Products' link does not exists on Dashboard of Admin HomePage after enabling it in Customer Features tab";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
					
			stepstatus = clickElement(Pg_Home.Lnk_Admin_MyProducts, driver);
			plog = "Step 36: Able to click on 'My Products' Link on Home page of Admin";
			flog = " Step 36: UnAble to click on 'My Products' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
		}
		//=====================================================================================================================================

		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 37:Able to click on Name link";
		flog = " Step 37:UnAble to click on Name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 38:Sign out link exists after clicking on name link";
		flog = " Step 38:Sign out link does not exists after clicking on name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 39:Able to click on Signout link";
		flog = " Step 39:UnAble to click on SignIn link";
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
