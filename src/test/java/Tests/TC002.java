package Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Config.Configs;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import Utils.ExcelOperations;

public class TC002 extends BaseTest {
	@Test(dataProvider = "TC002")
	public void tc002(Map<Object, Object> datamap) {
		if(datamap.get("Execute").toString().equalsIgnoreCase("yes")) {
			logger = extent.startTest("TC002");
			LoginPage loginPage = new LoginPage(driver, logger);
			loginPage.login(Configs.username, Configs.passwprd);
			
			DashboardPage dashboardpage = new DashboardPage(driver, logger);
			Assert.assertTrue(dashboardpage.verifyLabelQuickLaunch(), "Verify label QuickLaunch");
		}
		
	}
	
	@DataProvider(name = "TC002")
	public Object[][] getData() {
		return ExcelOperations.readExcel(getClass().getSimpleName());
	}

}
