package testScriptDefinitions.Module1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepository.Pg_Home;
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;

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
		
		//==========================================================================
		//added below 2 steps after making me as an Admin
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_Name, driver);
		plog = "Step 5.1:Able to click on SignIn";
		flog = " Step 5.1:UnAble to click on SignIn";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_AccessCompanyView, driver);
		plog = "Step 5.2:Able to click on AccessCompanyView link";
		flog = " Step 5.2:UnAble to click on AccessCompanyView link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		//==========================================================================

		stepstatus = exists(Pg_Home.Wbe_Dashboard, driver);
		plog = "Step 06:Dashboard exists on HomePage";
		flog = "Step 06:Dashboard does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true);
		
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_ClickArrow, driver);
		plog = "Step 07:Able to click on ArrowMark";
		flog = " Step 07:UnAble to click on ArrowMark";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_SignOut, driver);
		plog = "Step 08:Signout link exists on HomePage";
		flog = "Step 08:Signout link does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_SignOut, driver);
		plog = "Step 09:Able to click on Signout link";
		flog = " Step 09:UnAble to click on Signout link";
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
