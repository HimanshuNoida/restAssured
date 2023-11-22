import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Add_item_to_cart {

	@Test
	public static void add_Item_To_Cart() {
	RestAssured.baseURI = "http://dev.djtretailers.com";

	String id=show_collections._id;
	String response = given().log().all().header("Content-Type", "application/json")
			.body("{\r\n"
					+ "	\"_id\" : \""+id+"\",\r\n"
					+ "	\"quantity\" : 2\r\n"
					+ "}").when().post("/cart/believe").then().log().all().assertThat().body("message",equalTo("Item added successfully")).
			extract().response().asString();


	}
	
	
}
