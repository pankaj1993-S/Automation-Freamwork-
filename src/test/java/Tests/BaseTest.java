package Tests;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Config.Configs;
import Utils.Utilities;

public class BaseTest {

	RemoteWebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String runTime;
	
	@BeforeSuite
	public void setReport() {
		runTime = "Execution_" + Utilities.getTimeStamp();
		System.out.println(new File(System.getProperty("user.dir")+"/test-output/"+runTime+"/Screenshots").mkdirs());
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+runTime+"/SuiteResult.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@BeforeMethod
	@Parameters("Browser")
	public void setBrowser(String browser) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(Configs.URL);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.SKIP) {
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Failed");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Passed");
		}
		extent.endTest(logger);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void closeReport() {
		extent.flush();
		extent.close();
	}
	
	public static String capture(RemoteWebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/test-output/" + runTime + "/Screenshots/" 
				+ System.currentTimeMillis() + ".png");
		
		try {
			FileHandler.copy(src, dest);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
}

