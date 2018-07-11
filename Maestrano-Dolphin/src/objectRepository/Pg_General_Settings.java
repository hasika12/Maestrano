package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Pg_General_Settings 
{
	
	public static By WebEle_Settings=By.xpath("(//*[text()='Settings'])[2]");
	
	public static By WebEle_General=By.xpath("(//*[text()='General'])[2]");
	
	public static By Lnk_General=By.xpath("(//*[text()='General'])[2]");
	
	public static By Lnk_CustomerFeatures=By.xpath("(//*[text()='Customer features'])[1]");
	
	public static By Lnk_AdminFeatures=By.xpath("(//*[text()='Admin features'])[1]");
	
	public static By WebEle_MarketPlace=By.xpath("//*[text()='marketplace']");
	
	public static By WebEle_MainAddress=By.xpath("//*[text()='Main address']");
	
	public static By ChkBox_EnableMarketPlace=By.xpath("//*[text()='Enable the marketplace']/preceding-sibling::input[@type='checkbox']");
	
	public static By ChkBox_ProductOrdering=By.xpath("//*[text()='Product ordering']/preceding-sibling::input[@type='checkbox']");
	
	public static By ChkBox_ProductMarkup=By.xpath("//*[text()='Product Markup']/preceding-sibling::input[@type='checkbox']");
	
	public static By ChkBox_ProductCatalog=By.xpath("//*[text()='Your product catalog']/preceding-sibling::input[@type='checkbox']");
	
	public static By ChkBox_MainAddress=By.xpath("//*[text()='Main Address']/preceding-sibling::input[@type='checkbox']");
			
	public static By ChkBox_MassImport=By.xpath("(//*[text()='enabled']/preceding-sibling::input[@type='checkbox'])[18]");

	public static By BtnSave=By.xpath("//*[@class='btn btn-primary']");
	
	public static By ApplyChnages_PopUp=By.xpath("//*[@class='modal-content']");
	
	public static By BtnOk=By.xpath("(//*[@class='btn btn-danger'])[1]");

	public static WebElement ChkBox_ProductMarkup() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
