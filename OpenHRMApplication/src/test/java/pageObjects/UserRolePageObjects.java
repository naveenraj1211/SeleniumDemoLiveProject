package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePageObjects 
{

	@FindBy(linkText="Admin")
	public static WebElement adminLink;

	@FindBy(linkText="User Management")
	public static WebElement userManagementLink;

	@FindBy(linkText="Users")
	public static WebElement usersLink;	

	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement userName;

	@FindBy(id="searchSystemUser_userType")
	public static WebElement userRole;

	@FindBy(id="searchSystemUser_status")
	public static WebElement userStatus;	

	@FindBy(id="searchBtn")
	public static WebElement searchBtn;

	@FindBy(xpath="(//tr/td[3])[1]")
	public static WebElement userRoleValue;
	
	@FindBy(xpath="(//tr/td[5])[1]")
	public static WebElement userStatusValue;



}
