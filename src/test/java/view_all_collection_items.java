import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class view_all_collection_items {
	static String id;
	static String expected;

	@Test
	public static void view_all_collections() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		System.out.println("collection_id"+show_collections._id);
		Response response = given().log().all().header("Content-Type", "application/json").
				queryParam("id", show_collections._id).queryParam("page_size", 1).queryParam("page_num", 1).when()
				.get("/collection/viewmorecollectionitem/believe").then().log().all().assertThat().statusCode(200)
				.body("message", equalTo("Here the Collection details")).extract().response();

		
		System.out.println(response);
		
		
		expected = show_collections._id;
		String js = response.asString();
		JsonPath j = new JsonPath(js);
		int jj = j.getInt("data.items.size()");
		for (int a = 0; a < jj; a++) {
			if (a == 0) {
				id = j.getString("data.items["+a+"]._id");
			
			}
		
	}

	
	}
}


