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
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;
import objectRepository.Pg_CreatingProduct;
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
			
			wait(15);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 17: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 17: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(15);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 18: Clicked on 'OK' button on popup page";
			flog = " Step 18: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(15);
			
			stepstatus = exists(Pg_Home.Lnk_Admin_PriceList, driver);
			plog = "Step 19: 'Price List' link doesnot exists on Dashboard of Admin HomePage after disabling it in general tab under customer features";
			flog = "Step 19: 'Price List' link exists on Dashboard of Admin HomePage evenafter disabling it in general tab under customer features";
			logEvent(stepstatus, plog, flog, driver, true);
		
			
			WebElement Admin_PriceList_Displayed= driver.findElement(By.xpath("(//*[text()='Price List'])[1]"));
			boolean Admin_PriceList_DisplayedStatus=Admin_PriceList_Displayed.isDisplayed();
			System.out.println("Product Markup Checkbox displayed status is: "+Admin_PriceList_DisplayedStatus);
		} 
		
		else
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_ProductMarkup, driver);
			plog = "Step 20: Able to select 'Product Markup' radiobutton on CustomerFeatures Page";
			flog = " Step 20: Unable to select 'Product Markup' radiobutton on CustomerFeatures Page";
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
			
			wait(15);
			
			stepstatus = exists(Pg_Home.Lnk_Admin_PriceList, driver);
			plog = "Step 24: 'Price List' link exists on Dashboard of Admin HomePage after enabling it in general tab under customer features";
			flog = "Step 24: 'Price List' link doesnot exists on Dashboard of Admin HomePage evenafter enabling it in general tab under customer features";
			logEvent(stepstatus, plog, flog, driver, true);
			
			wait(10);
			
			
			stepstatus = clickElement(Pg_Home.Lnk_Admin_PriceList, driver);
			plog = "Step 24.1: Able to click on 'Price List' after enabling it on general features" ;
			flog = " Step 24.1: UnAble to click on 'Price List' after enabling it on general features";
			logEvent(stepstatus, plog, flog, driver, false);
		}
		//=====================================================================================================================================
		
		wait(7);
		
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 24.2: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 24.2: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
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
			
			wait(7);
			
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
			
			wait(15);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 29: Clicked on 'OK' button on popup page";
			flog = " Step 29: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(15);
			
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
			
			wait(15);
			

			stepstatus = exists(Pg_Home.Lnk_Admin_MyProducts, driver);
			plog = "Step 35: 'My Products' link exists on Dashboard of Admin HomePage after enabling it in Customer Features tab";
			flog = "Step 35: 'My Products' link does not exists on Dashboard of Admin HomePage after enabling it in Customer Features tab";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(15);
					
			stepstatus = clickElement(Pg_Home.Lnk_Admin_MyProducts, driver);
			plog = "Step 36: Able to click on 'My Products' Link on Home page of Admin after enabling it in Customer Features tab";
			flog = " Step 36: UnAble to click on 'My Products' Link on Home page of Admin after enabling it in Customer Features tab";
			logEvent(stepstatus, plog, flog, driver, false);
		}
		//=====================================================================================================================================
		
		 wait(7);
		 
		stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 37: 'General' link exists on Dashboard of Admin HomePage";
		flog = "Step 37: 'General' link does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 38: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 38: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
         wait(7);
		
		stepstatus = clickElement(Pg_General_Settings.Lnk_CustomerFeatures, driver);
		plog = "Step 39: Able to click on 'Customer Features' Link on Settings Page";
		flog = " Step 39: UnAble to click on 'Customer Features' Link on Settings Page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		WebElement EnableMarketPlace = driver.findElement(By.xpath("//*[text()='Enable the marketplace']/preceding-sibling::input[@type='checkbox']"));
		boolean EnableMarketPlace_DisplayedStatus=EnableMarketPlace.isDisplayed();
		System.out.println("Enable MarketPlace Checkbox displayed status is: "+EnableMarketPlace_DisplayedStatus);
		
		WebElement EnableMarketPlace_Enabled= driver.findElement(By.xpath("//*[text()='Enable the marketplace']/preceding-sibling::input[@type='checkbox']"));
		boolean EnableMarketPlace_EnabledStatus=EnableMarketPlace_Enabled.isEnabled();
		System.out.println("Enable MarketPlace Checkbox Enabled status is: "+EnableMarketPlace_EnabledStatus);
		
		WebElement EnableMarketPlace_Selected= driver.findElement(By.xpath("//*[text()='Enable the marketplace']/preceding-sibling::input[@type='checkbox']"));
		boolean EnableMarketPlace_SelectedStatus=EnableMarketPlace_Selected.isSelected();
		System.out.println("Enable MarketPlace Checkbox Selected status is: "+EnableMarketPlace_SelectedStatus);
		
		if(EnableMarketPlace_SelectedStatus==true)
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_EnableMarketPlace, driver);
			plog = "Step 40: Able to click on 'Enable MarketPlace' radiobutton on CustomerFeatures Page";
			flog = " Step 40: Unable to click on 'Enable MarketPlace' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 41: Able to click on 'Save' button on Settings Page";
			flog = " Step 41: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(10);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 42: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 42: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(10);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 43: Clicked on 'OK' button on popup page";
			flog = " Step 43: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
	
			wait(25);
			
			stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
			plog = "Step 44:Able to click on SignIn";
			flog = " Step 44:UnAble to click on SignIn";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(15);
			
			stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AccessCompanyView, driver);
			plog = "Step 45:Able to click on AccessCompanyView link";
			flog = " Step 45:UnAble to click on AccessCompanyView link";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(5);
			
			stepstatus = exists(Pg_Home.Wbe_Dashboard, driver);
			plog = "Step 46:Dashboard exists on HomePage of Access Company View page";
			flog = "Step 46:Dashboard does not exists on HomePage of Access Company View page";
			logEvent(stepstatus, plog, flog, driver, true);
			
			
			wait(2);
			
			
			
			Actions builder=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("//*[@class='menu vertical']"));
			builder.moveToElement(ele).build().perform();
			
			wait(2);
			
		
			
			stepstatus = notexists(Pg_CreatingProduct.Lnk_MarketplaceIcon, driver);
			plog = "Step 47:Marketplace Icon does not exists on HomePage of Access Company View page";
			flog = "Step 47:Marketplace Icon still exists on HomePage of Access Company View page even after disabling it on customer features page under general settings";
			logEvent(stepstatus, plog, flog, driver, true);
		} 
		
		else
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_EnableMarketPlace, driver);
			plog = "Step 48: Able to click on 'Enable MarketPlace' radiobutton on CustomerFeatures Page";
			flog = " Step 48: Unable to click on 'Enable MarketPlace' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 49: Able to click on 'Save' button on Settings Page";
			flog = " Step 49: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 50: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 50: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(10);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 51: Clicked on 'OK' button on popup page";
			flog = " Step 51: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(25);
			
			
			stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
			plog = "Step 52:Able to click on SignIn";
			flog = " Step 52:UnAble to click on SignIn";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(20);
			
			stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AccessCompanyView, driver);
			plog = "Step 53:Able to click on AccessCompanyView link";
			flog = " Step 53:UnAble to click on AccessCompanyView link";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(5);
			
			stepstatus = exists(Pg_Home.Wbe_Dashboard, driver);
			plog = "Step 54:Dashboard exists on HomePage of Access Company View page";
			flog = "Step 54:Dashboard does not exists on HomePage of Access Company View page";
			logEvent(stepstatus, plog, flog, driver, true);
			
			
			wait(2);
			
			
			
			Actions builder=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("//*[@class='menu vertical']"));
			builder.moveToElement(ele).build().perform();
			
			wait(2);
			
			
			
			stepstatus = exists(Pg_CreatingProduct.Lnk_MarketplaceIcon, driver);
			plog = "Step 55:Marketplace Icon exists on dashboard of Access Company View page";
			flog = "Step 55:Marketplace Icon does not exists on dashboard of Access Company View page";
			logEvent(stepstatus, plog, flog, driver, true);
			
			stepstatus = clickElement(Pg_CreatingProduct.Lnk_MarketplaceIcon, driver);
			plog = "Step 55.1:Able to click on 'MarketplaceIcon' after enabling it in General settings";
			flog = " Step 55.1:UnAble to click on 'MarketplaceIcon' after enabling it in General settings";
			logEvent(stepstatus, plog, flog, driver, false);
			
		}
		//=====================================================================================================================================
		
		wait(5);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_ClickArrow, driver);
		plog = "Step 56:Able to click on ArrowMark";
		flog = " Step 56:UnAble to click on ArrowMark";
		logEvent(stepstatus, plog, flog, driver, false);
		
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AccessControlPanel, driver);
		plog = "Step 57:Able to click on 'AccessControlPanel' link";
		flog = " Step 57:UnAble to click on 'AccessControlPanel' link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 58: 'General' link exists on Dashboard of Admin HomePage";
		flog = "Step 58: 'General' link does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 59: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 59: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
         wait(7);
		
		
		stepstatus = exists(Pg_General_Settings.Lnk_AdminFeatures, driver);
		plog = "Step 60: 'Customer Features' tab exists Settings Page";
		flog = "Step 60: 'Customer Features' tab does not exists on Settings Page";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		stepstatus = clickElement(Pg_General_Settings.Lnk_AdminFeatures, driver);
		plog = "Step 61: Able to click on 'Customer Features' Link on Settings Page";
		flog = " Step 61: UnAble to click on 'Customer Features' Link on Settings Page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		
		WebElement MassImport_Displayed= driver.findElement(By.xpath("(//*[text()='enabled']/preceding-sibling::input[@type='checkbox'])[18]"));
		boolean MassImport_DisplayedStatus=MassImport_Displayed.isDisplayed();
		System.out.println("MassImport Checkbox displayed status is: "+MassImport_DisplayedStatus);
		
		WebElement MassImport_Enabled= driver.findElement(By.xpath("(//*[text()='enabled']/preceding-sibling::input[@type='checkbox'])[18]"));
		boolean MassImport_EnabledStatus=MassImport_Enabled.isEnabled();
		System.out.println("MassImport Checkbox Enabled status is: "+MassImport_EnabledStatus);
		
		WebElement MassImport_Selected= driver.findElement(By.xpath("(//*[text()='enabled']/preceding-sibling::input[@type='checkbox'])[18]"));
		boolean MassImport_SelectedStatus=MassImport_Selected.isSelected();
		System.out.println("MassImport Checkbox Selected status is: "+MassImport_SelectedStatus);
		
		if(MassImport_SelectedStatus==true)
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_MassImport, driver);
			plog = "Step 62: Able to click on 'MassImport' radiobutton on CustomerFeatures Page";
			flog = " Step 62: Unable to click on 'MassImport' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 63: Able to click on 'Save' button on Settings Page";
			flog = " Step 63: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 64: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 64: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(15);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 65: Clicked on 'OK' button on popup page";
			flog = " Step 65: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(20);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 66: 'Customers' link exists on Dashboard of Admin HomePage";
			flog = "Step 66: 'Customers' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 67:Able to click on 'Customers' Link on Home page of Admin";
			flog = " Step 67:UnAble to click on 'Customers' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 68: 'New Customer' dropdown exists on 'Customers' home Page";
			flog = "Step 68:  'New Customer' dropdown does not exists on 'Customers' home Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 69: Able to click on 'New Customer' dropdown on Customers homepage";
			flog = " Step 69: UnAble to click on 'New Customer' dropdown on Customers homepage";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = notexists(Pg_Customers_Admin.Lnk_ImportCustomers, driver);
			plog = "Step 70: 'Import Customers' link does not exists under 'New Customer' after disabling 'Mass Import' in 'Admin Features'";
			flog = "Step 70: 'Import Customers' link exists under 'New Customer' even after disabling 'Mass Import' in 'Admin Features'";
			logEvent(stepstatus, plog, flog, driver, true); 
		} 
		
		else
		{
			
			wait(10);
			
			stepstatus = clickElement(Pg_General_Settings.ChkBox_MassImport, driver);
			plog = "Step 71: Able to click on 'MassImport' radiobutton on CustomerFeatures Page";
			flog = " Step 71: Unable to click on 'MassImport' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 72: Able to click on 'Save' button on Settings Page";
			flog = " Step 72: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(2);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 73: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 73: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(15);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 74: Clicked on 'OK' button on popup page";
			flog = " Step 74: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(20);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 75: 'Customers' link exists on Dashboard of Admin HomePage";
			flog = "Step 75: 'Customers' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 76:Able to click on 'Customers' Link on Home page of Admin";
			flog = " Step 76:UnAble to click on 'Customers' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 77: 'New Customer' dropdown exists on 'Customers' home Page";
			flog = "Step 77:  'New Customer' dropdown does not exists on 'Customers' home Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 78: Able to click on 'New Customer' dropdown on Customers homepage";
			flog = " Step 78: UnAble to click on 'New Customer' dropdown on Customers homepage";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_ImportCustomers, driver);
			plog = "Step 79: 'Import Customers' link exists under 'New Customer' after Enabling 'Mass Import' in 'Admin Features'";
			flog = "Step 79: 'Import Customers' link does not exists under 'New Customer' even after Enabling 'Mass Import' in 'Admin Features'";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_ImportCustomers, driver);
			plog = "Step 79.1: Able to click on 'Import Customers' after enabling it in General Features";
			flog = " Step 79.1: UnAble to click on 'Import Customers' after enabling it in General Features";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			wait(7);
		}
		
	
		wait(10);
		
		stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 80: 'General' link exists on Dashboard of Admin HomePage";
		flog = "Step 80: 'General' link does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 81: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 81: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		//=======================================================================================
		stepstatus = exists(Pg_General_Settings.WebEle_Settings, driver);
		plog = "Step 82: 'Settings' webelement exists on Dashboard of Admin HomePage";
		flog = "Step 82: 'Settings' webelement does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = exists(Pg_General_Settings.WebEle_General, driver);
		plog = "Step 83: 'General' tab exists Settings Page";
		flog = "Step 83: 'General' tab does not exists on Settings Page";
		logEvent(stepstatus, plog, flog, driver, true); 
		
		wait(5);
		
		stepstatus = clickElement(Pg_General_Settings.Lnk_General, driver);
		plog = "Step 84: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 84: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
	//===============================================================================================================================================	
		
		
wait(5);
		
		
		WebElement MainAddress_Displayed= driver.findElement(By.xpath("//*[text()='Main Address']/preceding-sibling::input[@type='checkbox']"));
		boolean MainAddress_DisplayedStatus=MainAddress_Displayed.isDisplayed();
		System.out.println("Main Address Checkbox displayed status is: "+MainAddress_DisplayedStatus);
		
		WebElement MainAddress_Enabled= driver.findElement(By.xpath("//*[text()='Main Address']/preceding-sibling::input[@type='checkbox']"));
		boolean MainAddress_EnabledStatus=MainAddress_Enabled.isEnabled();
		System.out.println("Main Address Checkbox Enabled status is: "+MainAddress_EnabledStatus);
		
		WebElement MainAddress_Selected= driver.findElement(By.xpath("//*[text()='Main Address']/preceding-sibling::input[@type='checkbox']"));
		boolean MainAddress_SelectedStatus=MainAddress_Selected.isSelected();
		System.out.println("Main Address Checkbox Selected status is: "+MainAddress_SelectedStatus);
		
		if(MainAddress_SelectedStatus==true)
		{
			stepstatus = clickElement(Pg_General_Settings.ChkBox_MainAddress, driver);
			plog = "Step 85: Able to click on 'MassImport' radiobutton on CustomerFeatures Page";
			flog = " Step 85: Unable to click on 'MassImport' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 86: Able to click on 'Save' button on Settings Page";
			flog = " Step 86: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 87: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 87: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(15);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 88: Clicked on 'OK' button on popup page";
			flog = " Step 88: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(20);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 89: 'Customers' link exists on Dashboard of Admin HomePage";
			flog = "Step 89: 'Customers' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 90:Able to click on 'Customers' Link on Home page of Admin";
			flog = " Step 90:UnAble to click on 'Customers' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 91: 'New Customer' dropdown exists on 'Customers' home Page";
			flog = "Step 91:  'New Customer' dropdown does not exists on 'Customers' home Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 92: Able to click on 'New Customer' dropdown on Customers homepage";
			flog = " Step 92: UnAble to click on 'New Customer' dropdown on Customers homepage";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_CreateACustomer, driver);
			plog = "Step 93: Able to click on 'Create A Customer' link under 'New Customer' dropdown on Customers homepage";
			flog = " Step 93: UnAble to click on 'Create A Customer' link under 'New Customer' dropdown on Customers homepage";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = notexists(Pg_General_Settings.WebEle_MainAddress, driver);
			plog = "Step 94: 'MainAddress' field does not exists on 'Create new customer' Page after disabling it on 'General settings' page";
			flog = "Step 94:  'MainAddress' field still exists on 'Create new customer' Page even after disabling it on 'General settings' page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
		} 
		
		else
		{
			
			wait(10);
			
			stepstatus = clickElement(Pg_General_Settings.ChkBox_MainAddress, driver);
			plog = "Step 95: Able to click on 'MassImport' radiobutton on CustomerFeatures Page";
			flog = " Step 95: Unable to click on 'MassImport' radiobutton on CustomerFeatures Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			
			stepstatus = clickElement(Pg_General_Settings.BtnSave, driver);
			plog = "Step 96: Able to click on 'Save' button on Settings Page";
			flog = " Step 96: UnAble to click on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(2);
			
			stepstatus = exists(Pg_General_Settings.ApplyChnages_PopUp, driver);
			plog = "Step 97: Pop up observed after clicking on 'Save' button on Settings Page";
			flog = "Step 97: Pop up was not observed after clicking on 'Save' button on Settings Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(15);
			

			stepstatus = clickElement(Pg_General_Settings.BtnOk, driver);
			plog = "Step 98: Clicked on 'OK' button on popup page";
			flog = " Step 98: Unable to Click on 'OK' button on popup page";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(20);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 99: 'Customers' link exists on Dashboard of Admin HomePage";
			flog = "Step 99: 'Customers' link does not exists on Dashboard of Admin HomePage";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			wait(7);
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_Admin_Customers, driver);
			plog = "Step 100:Able to click on 'Customers' Link on Home page of Admin";
			flog = " Step 100:UnAble to click on 'Customers' Link on Home page of Admin";
			logEvent(stepstatus, plog, flog, driver, false);
			
			wait(7);
			
			stepstatus = exists(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 101: 'New Customer' dropdown exists on 'Customers' home Page";
			flog = "Step 101:  'New Customer' dropdown does not exists on 'Customers' home Page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_NewCustomer, driver);
			plog = "Step 102: Able to click on 'New Customer' dropdown on Customers homepage";
			flog = " Step 102: UnAble to click on 'New Customer' dropdown on Customers homepage";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = clickElement(Pg_Customers_Admin.Lnk_CreateACustomer, driver);
			plog = "Step 103: Able to click on 'Create A Customer' link under 'New Customer' dropdown on Customers homepage";
			flog = " Step 103: UnAble to click on 'Create A Customer' link under 'New Customer' dropdown on Customers homepage";
			logEvent(stepstatus, plog, flog, driver, false);
			
			stepstatus = exists(Pg_General_Settings.WebEle_MainAddress, driver);
			plog = "Step 104: 'MainAddress' field exists on 'Create new customer' Page after Enabling it on 'General settings' page";
			flog = "Step 104:  'MainAddress' field doesnot exists on 'Create new customer' Page even after Enabling it on 'General settings' page";
			logEvent(stepstatus, plog, flog, driver, true); 
			
			
			wait(7);
		}
		
		stepstatus = exists(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 105: 'General' link exists on Dashboard of Admin HomePage";
		flog = "Step 105: 'General' link does not exists on Dashboard of Admin HomePage";
		logEvent(stepstatus, plog, flog, driver, true); 
				
		stepstatus = clickElement(Pg_Home.Lnk_Admin_General, driver);
		plog = "Step 106: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 106: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_Home.Lnk_ThemePreviewer, driver);
		plog = "Step 107: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 107: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(15);
		
		stepstatus = clickElement(Pg_Home.Btn_ControlPanel, driver);
		plog = "Step 108: Able to click on 'General' Link on Home page of Admin";
		flog = " Step 108: UnAble to click on 'General' Link on Home page of Admin";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(10);

		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 109:Able to click on Name link";
		flog = " Step 109:UnAble to click on Name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 110:Sign out link exists after clicking on name link";
		flog = " Step 110:Sign out link does not exists after clicking on name link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AdminSignOut, driver);
		plog = "Step 111:Able to click on Signout link";
		flog = " Step 111:UnAble to click on SignIn link";
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
