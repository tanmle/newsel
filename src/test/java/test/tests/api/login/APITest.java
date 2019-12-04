package test.tests.api.login;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.core.utils.Logger;

import io.restassured.http.ContentType;
import test.pagesJpay.LoginPage;
import test.utils.TestBase;

@Test
public class APITest extends TestBase{

	@Test(description = "API Testing")
	public void api_tc1() {

		Logger.info(
				"4. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		Logger.info(
				"5. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		Logger.info(
				"6. Fill in the Customer Call form, leaving the all 'assign to' is blank");

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then()
				.assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and()
				.header("Content-Length", equalTo("4567"));
	}

	LoginPage loginPage = new LoginPage();
}
