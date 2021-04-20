package Utils;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import Config.Configs;
import Tests.BaseTest;

public class APIExecutor {
	
	public static boolean RequestGet(String step, ExtentTest logger) {
		try {
			given().queryParam("id", 1)
	           .when().get(Configs.API_URL_2).then().log()
	           .body().toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//.queryParam("CUSTOMER_ID","68195")
	    return true;
	}
		
}
