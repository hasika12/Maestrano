package objectRepository;

import org.openqa.selenium.By;

public class Pg_HomePageMenu {
	
	public static By HomePage_Icons=By.xpath("//*[@class='menu vertical']");
	
	public static By Lnk_Company=By.xpath("(//*[text()='Company'])[2]");
	
	public static By Btn_Teams = By.xpath("//*[text()='Teams']");
	
	public static By Btn_Members = By.xpath("//*[text()='Members']");
	
	public static By Btn_InviteUsers=By.xpath("//*[@class='btn btn-sm btn-warning ng-binding']");
	
	public static By WebEle_EnterEmailAddress=By.xpath("//h3[text()='Enter email addresses']");
	
	public static By Edt_Email=By.xpath("//*[@ng-model='inviteModal.userEmails']");
	
	public static By Btn_Next=By.xpath("//span[contains(text(),'Next')]");
	
	public static By WebEle_SelectRole=By.xpath("//h3[text()='Select role for each new member']");
	
	public static By WebEle_Email=By.xpath("(//div[@class='cell col-sm-4 ng-binding'])[4]");
	
	public static By Wbl_Role=By.xpath("//select[@ng-model='member.role']");
	
	public static By Wbl_Team=By.xpath("//select[@ng-model='member.team_id']");
	
	public static By Btn_Invite=By.xpath("//span[contains(text(),'Invite')]");
	

}
