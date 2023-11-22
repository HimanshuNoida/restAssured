import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Banners {
	
	
	@Test
	public static void getBanners() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		
		Response response = given().log().all().header("Content-Type", "application/json").
				
			
				queryParam("page_name","Category").queryParam("page_value",1).when().get("/collection/getbanners/believe")
				.then().log().all().assertThat().statusCode(200)
				.body("message", equalTo("No banner found")).assertThat().extract().response();

	}

}
