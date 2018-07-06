package objectRepository;

import org.openqa.selenium.By;

public class Pg_CreatingProduct {
	
	


//public static By Wbl_Countrycode=By.xpath("//*[@ng-model='address.country_code']");
	
	
	
	public static By Btn_CreateProduct=By.xpath("//*[text()='Create product']");
	
	public static By Edt_ProductTitle=By.xpath("//*[@type='text']");
	
	public static By Btn_Create=By.xpath("//*[@class='btn btn-primary']");
	
	public static By WebEle_ProductDescription=By.xpath("//*[text()='Product Description']");
	
	public static By Edt_SupplierName=By.xpath("//*[text()='Supplier']//following::input[1]");
	
	public static By Edt_TinyDescription=By.xpath("//*[text()='Tiny description']//following::input[1]");

	public static By Edt_KeyBenefits=By.xpath("//*[@ng-model='$ctrl.new_element']");
	
	//*[text()='Key benefits']//following::input[1]
	
	public static By Btn_Submit=By.xpath("(//*[text()='Submit'])[1]");
	
	public static By Btn_AddPricingPlan=By.xpath("//*[@ng-click='vm.addPricingPlan()']");
	
	public static By Edt_Name=By.xpath("//*[@name='name']");
	
	public static By Edt_Description=By.xpath("//*[@ng-model='pricingPlan.description']");
	
	public static By Wbl_PricingType=By.xpath("//*[@ng-model='pricingPlan.pricing_type']");
	
	public static By Wbl_PerUnit=By.xpath("//*[@ng-model='pricingPlan.per_unit']");
	
	public static By Wbl_PerDuration=By.xpath("//*[@ng-model='pricingPlan.per_duration']");
	
	public static By Wbl_Prices=By.xpath("//*[@ng-model='new_price.currency']");
	
	public static By Edt_Price=By.xpath("//*[@ng-model='new_price.price_cents']");
	
	public static By Btn_Save=By.xpath("//*[contains(text(),'save')]");
	
	public static By Btn_Draft=By.xpath("//*[contains(text(),'Draft')]");
	
	public static By Btn_DraftPublish=By.xpath("//*[@class='btn active btn-default  toggle-off']");
	
	
	
	public static By Lnk_MarketplaceIcon=By.xpath("//*[@class='dhb-icon-marketplace']");
	
	
	
	public static By Lnk_SubscriptionsIcon=By.xpath("//*[@class='dhb-icon-subscriptions']");
	
	public static By Lnk_MyWebstoreProducts=By.xpath("(//*[starts-with(text(),'My Webstore')])[2]");
	
	public static By Lnk_PublishedProduct=By.xpath("(//*[text()='Sample Product'])[1]");
	
	
	
	public static By Btn_Provision=By.xpath("//*[text()='Provision']");
	
	
	
	public static By RadioButton_Provision=By.xpath("//*[@name='optradio']");
	
	
	
	public static By Btn_Next=By.xpath("//*[text()='Next']");
	
	public static By Btn_Validate=By.xpath("//*[text()='Validate']");
	
	public static By Btn_GotoMyApp=By.xpath("//*[text()='Go to my app']");
	
	
	
	public static By Lnk_SubscriptionsTable=By.xpath("//*[text()='Sample Product']");
	
	
	
	public static By WebEle_ProvisionStatus=By.xpath("//*[text()='requested']");
	
	
	
	
	
	public static By Edt_OrganisationSearch=By.xpath("//*[@ng-model='organizations.search']");
	
	
	
	
	public static By Lnk_DemoCompany11=By.xpath("//*[contains(text(),'Demo Company11')]");
	
	
	
	
	
	
	public static By Lnk_ApproveSampleProduct=By.xpath("(//*[text()='Sample Product'])[1]");
	
	
	
	public static By Btn_Approve=By.xpath("//*[text()='Approve']");
	
	
	
	public static By Btn_PopupApprove=By.xpath("//*[@class='btn btn-primary']");
	
	
			
	public static By Btn_DeletingProduct=By.xpath("(//*[@class='fa fa-trash-o'])[2]");
			
			
	
	public static By Btn_DeletePopUp=By.xpath("//*[text()='Delete']");
	
	
}
