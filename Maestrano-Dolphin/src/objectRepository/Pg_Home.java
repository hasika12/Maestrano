package objectRepository;

import org.openqa.selenium.By;

public class Pg_Home 
{

	public static By Wbe_Dashboard=By.xpath("//h2[@class='section-title ng-binding' and contains(text(),'Dashboard')]");
	
	public static By Lnk_AdminDashboard=By.xpath("//*[text()='Dashboard']");
	
	public static By Wbe_CustomerMangement_AdminDashboard=By.xpath("//*[text()='Customer Management']");
	
	public static By Wbe_ProductMangement_AdminDashboard=By.xpath("//*[text()='Product Management']");
	
	public static By Wbe_WebStore_AdminDashboard=By.xpath("//*[text()='Webstore']");
	
	public static By Wbe_Settings_AdminDashboard=By.xpath("//*[text()='Settings']");
	
    public static By Lnk_Admin_Orders=By.xpath("(//*[text()='Orders'])[1]");
	
	public static By Lnk_Admin_Products=By.xpath("(//*[text()='Products'])[1]");
	
    public static By Lnk_Admin_MyProducts=By.xpath("(//*[text()='My Products'])[1]");
			
	public static By Lnk_Admin_PriceList=By.xpath("(//*[text()='Price List'])[1]");
	
    public static By Lnk_Admin_Staff=By.xpath("(//*[text()='Staff'])[1]");
			
	public static By Lnk_Admin_Questions=By.xpath("(//*[text()='Questions'])[1]");
					
	public static By Lnk_Admin_General=By.xpath("(//*[text()='General'])[1]");
	
	public static By Lnk_Admin_Plugins=By.xpath("(//*[text()='Plugins'])[1]");
	
	public static By Lnk_ThemePreviewer=By.xpath("//*[@class='theme-previewer-link pull-right ng-binding']");
	
	public static By Btn_ControlPanel=By.xpath("//*[text()='Back to Control Panel']");
	
	
}
