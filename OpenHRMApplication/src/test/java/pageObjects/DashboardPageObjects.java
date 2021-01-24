package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObjects 
{

	@FindBy(id="menu_dashboard_index")
	public static WebElement dashboard;
	
	@FindBy(xpath="//div[@id='task-list-group-panel-menu_holder']//child::table/tbody/tr/td/a[contains(text(),'Grace')]")
	public static WebElement pendingLeaveRequest;
	
}
