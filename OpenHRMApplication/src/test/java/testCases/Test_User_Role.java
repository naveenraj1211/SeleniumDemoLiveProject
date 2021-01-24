package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.LoginPageObjects;
import pageObjects.UserRolePageObjects;

public class Test_User_Role extends CommonFunctions
{
	static Logger logger = Logger.getLogger(Test_User_Role.class);
	
	@Test
	public void CheckUserRole() 
	{
		logger.info("NAvigating to user page");
		PageFactory.initElements(driver, UserRolePageObjects.class);
		Actions action = new Actions(driver);
		action.moveToElement(UserRolePageObjects.adminLink)
		.moveToElement(UserRolePageObjects.userManagementLink)
		.moveToElement(UserRolePageObjects.userName).click().build().perform(); 
		
		
		logger.info("selecting the user role");
		Select userRole = new Select(UserRolePageObjects.userRole);
		userRole.selectByVisibleText("Admin");
		
		logger.info("selecting the user status");
		Select userStatus = new Select(UserRolePageObjects.userStatus);
		userStatus.selectByVisibleText("Enabled");
		
		UserRolePageObjects.searchBtn.click();
		
		String actualRole=UserRolePageObjects.userRoleValue.getText();
		String actualStatus=UserRolePageObjects.userStatusValue.getText();
		
		logger.info("Verifying the results");
		Assert.assertEquals(actualRole, "Admin");
		Assert.assertEquals(actualStatus, "Enabled");
		
		logger.info("End of user role test case");
		
		
		
	}

	
}
