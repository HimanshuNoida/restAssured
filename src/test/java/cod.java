import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cod {
	
	@Test
	public void cod() { 
		RestAssured.baseURI = "http://dev.djtretailers.com";
		String response = given().log().all().header("Content-Type", "application/json").cookie("session",login.cookies).when().put("/v2/cod/believe")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);

	}
}
