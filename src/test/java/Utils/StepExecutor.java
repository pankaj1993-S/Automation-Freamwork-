package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Tests.BaseTest;


public class StepExecutor {
	
	public static boolean goTo(RemoteWebDriver driver, String url) {
		driver.navigate().to(url);
		return true;
	}
	
	public static boolean enterText(RemoteWebDriver driver, By textBox, String data, String step, ExtentTest logger) {
		boolean result = true;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(textBox));
		try {
			WebElement textBx = driver.findElement(textBox);
			textBx.clear();
			textBx.sendKeys(data);
			logger.log(LogStatus.PASS, logger.addScreenCapture(BaseTest.capture(driver)), step);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, logger.addScreenCapture(BaseTest.capture(driver)), step);
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static boolean click(RemoteWebDriver driver, By element, String step, ExtentTest logger) {
		boolean result = true;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		try {
			WebElement ele = driver.findElement(element);
			ele.click();
			logger.log(LogStatus.PASS, logger.addScreenCapture(BaseTest.capture(driver)), step);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, logger.addScreenCapture(BaseTest.capture(driver)), step);
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean selectByValue(RemoteWebDriver driver, By dropdown, String option, String step, ExtentTest logger) {
		boolean result = true;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(dropdown));
		try {
			Select dropDown = new Select(driver.findElement(dropdown));
			dropDown.deselectByValue(option);
			logger.log(LogStatus.PASS, logger.addScreenCapture(BaseTest.capture(driver)), step);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, logger.addScreenCapture(BaseTest.capture(driver)), step);
			e.printStackTrace();
	}
		return result;
	}
	
	public static boolean hover(RemoteWebDriver driver, By element, String step, ExtentTest logger) {
		boolean result = true;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		try {
			WebElement webElement = driver.findElement(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).build().perform();
			logger.log(LogStatus.PASS, logger.addScreenCapture(BaseTest.capture(driver)), step);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, logger.addScreenCapture(BaseTest.capture(driver)), step);
			e.printStackTrace();
	}
		return result;
	}
	
	public static boolean verifyElement(RemoteWebDriver driver, By element, String step, ExtentTest logger) {
		boolean result = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			logger.log(LogStatus.PASS, logger.addScreenCapture(BaseTest.capture(driver)), step);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, logger.addScreenCapture(BaseTest.capture(driver)), step);
			e.printStackTrace();
		}
		return result;
	}

}
