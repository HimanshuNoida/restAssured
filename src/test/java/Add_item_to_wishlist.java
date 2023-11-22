import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

public class Add_item_to_wishlist {
	
	
	@Test
	public void Add_item_to_wishlist() {
		RestAssured.baseURI = "http://dev.djtretailers.com";

	     String i= id.id();
		Response response =given().log().all().cookie("session",verifyOTP.cookies) .pathParam("item_id","634e5225d6fc9ecc8") .header("Content-Type", "application/json").when()
				.post("/fashion_wishlist/add-fashion-item-to-wishlist/{item_id}").then().log().all().assertThat().statusCode(200).extract()
				.response();
	}

}
