package objectRepository;

import org.openqa.selenium.By;

public class Pg_CreatingNewCustomer_Admin {
	
	
	public static By Edt_OrganisationName=By.xpath("//*[@id='organization-name']");
	
	public static By Edt_Street=By.xpath("//*[@ng-model='address.street']");
	
public static By Edt_City=By.xpath("//*[@ng-model='address.city']");
	
	public static By Edt_State=By.xpath("//*[@ng-model='address.state_code']");
	
public static By Edt_PostalCode=By.xpath("//*[@ng-model='address.postal_code']");

public static By Wbl_Countrycode=By.xpath("//*[@ng-model='address.country_code']");
	
	public static By Edt_PhoneNumber=By.xpath("//*[@ng-model='address.phone']");
	
	public static By Btn_Create=By.xpath("//*[@type='submit']");
	

}
