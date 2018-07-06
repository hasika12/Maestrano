package objectRepository;

import org.openqa.selenium.By;


public class Pg_AddingTeams 
{
	

	public static By Btn_AddTeam=By.xpath("(//*[@class='btn btn-warning ng-binding'])[3]");
	
	public static By Edt_TeamName=By.xpath("//*[@ng-model='addTeamModal.model.name']");
	
	public static By Btn_Create=By.xpath("//*[@ng-click='addTeamModal.proceed()']");
	
	public static By WebEle_AddedTeamName=By.xpath("(//*[contains(text(),'TEAM3')])[1]");
	
	
	
	
	

}
