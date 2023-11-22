import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Delete_item_for_cart {
	
	String id=show_collections._id;
	@Test
	public static void Delete_item_for_cart() {
		
		String id=show_collections._id;
		String response = given().log().all().header("Content-Type", "application/json").pathParam("id",id)
				.body(id).when().delete("/cart/item/believe/{id}").then().log().all().assertThat().statusCode(200).extract().response().asString();
	}

}
