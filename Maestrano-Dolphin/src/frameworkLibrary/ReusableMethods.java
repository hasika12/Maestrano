package frameworkLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.Pg_General_Settings;
import objectRepository.Pg_Home;
import userLibrary.UserLibrary;

public class ReusableMethods extends UserLibrary {
	
	String plog;
	String flog;
	boolean stepstatus;
	WebDriver driver;
	
	public void MarketPlace_Functionality()
	{
		WebElement ProductMarkUp=Pg_General_Settings.ChkBox_ProductMarkup();
		
		boolean ProductMarkUp_DisplayedStatus = ProductMarkUp.isDisplayed();
		
		System.out.println("Product MarkUp radio button displayed status is:" + ProductMarkUp_DisplayedStatus);
		
		if(ProductMarkUp_DisplayedStatus==true)
		{
			boolean ProductMarkUp_EnabledStatus = ProductMarkUp.isEnabled();
			
			System.out.println("Product MarkUp radio button Enabled status is:" + ProductMarkUp_EnabledStatus);
			
			if(ProductMarkUp_EnabledStatus==true)
			{
				boolean ProductMarkUp_SelectedStatus = ProductMarkUp.isSelected();
				
				System.out.println("Product MarkUp radio button Selected status is:" + ProductMarkUp_SelectedStatus);
				
				stepstatus = exists(Pg_Home.Lnk_Admin_PriceList, driver);
				plog = "Step 18: 'Price List' link exists on Dashboard of Admin HomePage";
				flog = "Step 18: 'Price List' link does not exists on Dashboard of Admin HomePage";
				logEvent(stepstatus, plog, flog, driver, true); 
								
				stepstatus = clickElement(Pg_Home.Lnk_Admin_PriceList, driver);
				plog = "Step 19: Able to click on 'Price List' Link on Home page of Admin";
				flog = " Step 19: UnAble to click on 'Price List' Link on Home page of Admin";
				logEvent(stepstatus, plog, flog, driver, false);
			}
			
			else
			{
				
			}
		}
	}
	

}
