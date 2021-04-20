package Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Config.Configs;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import Utils.ExcelOperations;

public class TC001 extends BaseTest {
	
	@Test(dataProvider = "TC001")
	public void tc001(Map<Object, Object> datamap) {
		if(datamap.get("Execute").toString().equalsIgnoreCase("yes")) {
			logger = extent.startTest("TC001");
			LoginPage loginPage = new LoginPage(driver, logger);
			loginPage.login(Configs.username, Configs.passwprd);
			
			DashboardPage dashboardpage = new DashboardPage(driver, logger);
			Assert.assertTrue(dashboardpage.verifyLabelDashBoard(), "Verify label dashboard");
		}
		
	}
	
	@DataProvider(name = "TC001")
	public Object[][] getData() {
		return ExcelOperations.readExcel(getClass().getSimpleName());
	}

}
