package testScriptDefinitions.Module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepository.Pg_Home;
import objectRepository.Pg_HomePageMenu;
import objectRepository.Pg_LogOutMaestrano;

import objectRepository.Pg_LoginMaestrano;

import userLibrary.UserLibrary;

public class TC103_AddingUsers extends UserLibrary 
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
						
		//============================================================================

		stepstatus = exists(Pg_Home.Wbe_Dashboard, driver);
		plog = "Step 06:Dashboard exists on HomePage";
		flog = "Step 06:Dashboard does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true);
		
		stepstatus = mouseHover(Pg_HomePageMenu.HomePage_Icons, driver);
		plog = "Step 07:Successfully mousehovered on HomePage icons";
		flog = "Step 07:Unable to mousehover on HomePage icons";
		logEvent(stepstatus, plog, flog, driver, true);
		
		stepstatus = clickElement(Pg_HomePageMenu.Lnk_Company, driver);
		plog = "Step 08:Able to click on Company link";
		flog = " Step 08:UnAble to click on Company link";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_HomePageMenu.Btn_Teams, driver);
		plog = "Step 09:Able to click on Teams button";
		flog = " Step 09:UnAble to click on Teams button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_HomePageMenu.Btn_Members, driver);
		plog = "Step 10:Able to click on Members button";
		flog = " Step 10:UnAble to click on Members button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_HomePageMenu.Btn_InviteUsers, driver);
		plog = "Step 11:Able to click on InviteUsers button";
		flog = " Step 11:UnAble to click on InviteUsers button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_HomePageMenu.WebEle_EnterEmailAddress, driver);
		plog = "Step 12:EnterEmailAddress webelement was observed";
		flog = " Step 12:EnterEmailAddress webelement was not observed";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = setText(Pg_HomePageMenu.Edt_Email, "123@gmail.com", driver);
		plog = "Step 13: Able to enter email id for adding users";
		flog = "Step 13: Unable to enter email id for adding users";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = clickElement(Pg_HomePageMenu.Btn_Next, driver);
		plog = "Step 14:Able to click on Next Button";
		flog = " Step 14:UnAble to click on Next Button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_HomePageMenu.WebEle_SelectRole, driver);
		plog = "Step 15:Select Role webelement exist on page";
		flog = " Step 15:Select Role webelement doesnot exist on page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_HomePageMenu.WebEle_Email, driver);
		plog = "Step 16:Entered email id was found on page";
		flog = " Step 16:Entered email id was not found on page";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = selectOptionByText(Pg_HomePageMenu.Wbl_Role, "Admin", driver);
		plog = "Step 17:Selected Admin as an option from the dropdown";
		flog = " Step 17:UnAble to Select Admin as an option from the dropdown";
		logEvent(stepstatus, plog, flog, driver, false);
		

		/*stepstatus = selectOptionByText(Pg_HomePageMenu.Wbl_Team, "teamB", driver);
		plog = "Step 18:Selected TeamA as an option from the dropdown";
		flog = " Step 18:UnAble to Select TeamA as an option from the dropdown";
		logEvent(stepstatus, plog, flog, driver, false); */
		
		
		stepstatus = clickElement(Pg_HomePageMenu.Btn_Invite, driver);
		plog = "Step 19:Able to click on Invite Button";
		flog = " Step 19:UnAble to click on Invite Button";
		logEvent(stepstatus, plog, flog, driver, false);
		
		wait(5);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_ClickArrow, driver);
		plog = "Step 20:Able to click on ArrowMark";
		flog = " Step 20:UnAble to click on ArrowMark";
		logEvent(stepstatus, plog, flog, driver, false);
		
		stepstatus = exists(Pg_LogOutMaestrano.Lnk_SignOut, driver);
		plog = "Step 21:Signout link exists on HomePage";
		flog = "Step 21:Signout link does not exists on HomePage";
		logEvent(stepstatus, plog, flog, driver, true);
		
		stepstatus = clickElement(Pg_LogOutMaestrano.Lnk_SignOut, driver);
		plog = "Step 22:Able to click on Signout link";
		flog = " Step 22:UnAble to click on Signout link";
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
