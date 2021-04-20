package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import Utils.StepExecutor;

public class DashboardPage {
	
	By labelDashboard = By.xpath(".//h1[text()='Dashboard']");
	By labelQuickLaunch = By.xpath(".//legend[text()='Quick Launch']");
	By labelAssignLeave = By.xpath(".//span[text()='Assign Leave']");
	By labelLeaveList = By.xpath(".//span[text()='Leave List']");
	
	RemoteWebDriver driver;
	ExtentTest logger;
	
	public DashboardPage(RemoteWebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public boolean verifyLabelDashBoard() {
		return StepExecutor.verifyElement(driver, labelDashboard, "Verify Dashboard", logger);
	}
	
	public boolean verifyLabelQuickLaunch() {
		return StepExecutor.verifyElement(driver, labelQuickLaunch, "Verify QuickLaunch", logger);
	}

}
