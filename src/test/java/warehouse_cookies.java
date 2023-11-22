import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.payload;

public class warehouse_cookies{

public static String w;
	@Test
	public static void cookie() {

		RestAssured.baseURI = "http://dev.djtretailers.com";

		Response response = given().log().all().header("Content-Type", "application/json")
				.body(payload.warehouseCookie()).when().post("/address/believe/set").then()
				.log().all().assertThat().statusCode(200).body("message", equalTo("Address set successfully."))
				.extract().response();

		String w = response.getCookie("believe_warehouse");
		System.out.println(w);

		

	}

}
