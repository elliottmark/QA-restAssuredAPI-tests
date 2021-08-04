package mark.selenium;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import utilities.PropFileHandler;
import io.restassured.RestAssured;

/**
 * Use testng annotations for assertions and reporting
 * Use Restassured's java-based library to test Restful API webservices and validate HTTP responses
 *
 */

public class TestRunner {

	TestSessionInitiator test;

	@BeforeSuite
	public void startSession() {
		test = new TestSessionInitiator(PropFileHandler.readProperty("browser"));
	}
	
	// Api test code is started from here

	@Test
	public void getAPIRequest(){
		int code = RestAssured.get(PropFileHandler.readProperty("apiURL")).getStatusCode();
		Assert.assertEquals(code, 200,"Status code is not comming as 200");
		System.out.println(">>>>>>>>>>>>>>>>>>> API TEST has been successfully completed");
		Reporter.log("Get request is successfully passed");
	}

	//Api test code ends here

	
	@AfterSuite
	public void closeSession() {
		test.quit();
	}

}
