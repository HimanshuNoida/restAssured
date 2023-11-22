import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class count_of_subcatogries_classes_price_and_sizes {

	public void count_of_subcatogries_classes_price_and_sizes() {

		RestAssured.baseURI = "http://dev.djtretailers.com";
		
		Response response = given().log().all().header("Content-Type", "application/json")
				.when().post("/address/believe/set").then()
				.log().all().assertThat().statusCode(200).body("message", equalTo("Address set successfully."))
				.extract().response();

	}
}
