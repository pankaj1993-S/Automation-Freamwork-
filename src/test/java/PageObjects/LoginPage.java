package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import Utils.StepExecutor;

public class LoginPage {
	
	By textBoxUsername = By.id("txtUsername");
	By textPassword = By.id("txtPassword");
	By buttonLogin = By.id("btnLogin");
	
	RemoteWebDriver driver;
	ExtentTest logger;
	
	public LoginPage(RemoteWebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public boolean enterUsernsame(String username) {
		return StepExecutor.enterText(driver, textBoxUsername, username, "Enter " + username, logger);
	}
	
	public boolean enterPassword(String password) {
		return StepExecutor.enterText(driver, textPassword, password, "Enter " + password, logger);
	}
	
	public boolean clickLogin() {
		return StepExecutor.click(driver, buttonLogin, "click login", logger);
	}
	
	public boolean login(String username, String password) {
		enterUsernsame(username);
		enterPassword(password);
		clickLogin();
		return true;
	}
	
}
