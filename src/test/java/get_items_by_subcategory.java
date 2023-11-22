import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class get_items_by_subcategory {
@Test
	
	public static void get_items_by_subcategory() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		System.out.println("subcategory_id"+show_collections._id);
		Response response = given().log().all().header("Content-Type", "application/json").

				queryParam("id", show_collections.subcategory).queryParam("page_size", 1).queryParam("page_num", 1).when()
				.get("/item/getitembysubcategory/believe").then().log().all().assertThat().statusCode(200)
				.body("message", equalTo("Here the list of items")).extract().response();
		
		System.out.println(response);

		
	}
}
