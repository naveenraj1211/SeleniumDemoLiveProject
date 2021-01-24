package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.DashboardPageObjects;
import pageObjects.LoginPageObjects;

public class Test_Pending_Leave_Request extends CommonFunctions
{
	static Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	@BeforeTest
	public void Login() 
	{
		logger.info("Logging in to application");
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.userName.sendKeys(prop.getProperty("username"));
		LoginPageObjects.password.sendKeys(prop.getProperty("password"));
		LoginPageObjects.submit.click();
	}
	
	@Test
	public void VerifyPenidngLeaveRequest() 
	{
		logger.info("Getting the pending leave request details");
		PageFactory.initElements(driver, DashboardPageObjects.class);
		DashboardPageObjects.dashboard.click();
		String LeaveRequesterName = DashboardPageObjects.pendingLeaveRequest.getText().trim();
		System.out.println(LeaveRequesterName);	
		logger.info("Verifying leave request");
		Assert.assertEquals(LeaveRequesterName, "04. Fiona Grace 2020-12-14");	
		logger.info("End of pending leave request test case");
	}
	
}
