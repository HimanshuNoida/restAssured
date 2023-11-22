import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class show_collections extends verifyOTP {

	public static String _id;
	public static String subcategory;   
	public static String category ;
	@Test
	public static void getcollection() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		
		Response response = given().log().all().header("Content-Type", "application/json").when()
				.get("/collection/showcollection/believe").then().log().all().assertThat().statusCode(200).extract()
				.response();

		String js = response.asString();
		JsonPath j = new JsonPath(js);

		int size = j.getInt("data.size()");

		for (int i = 0; i < size; i++) {
			int size1 = j.getInt("data[" + i + "].item_details.size()");
			
			_id = j.get("data[" + i + "].collection_details._id");
			for (int q = 0; q < size1; q++) {
				
				subcategory = j.get("data[" + i + "].item_details[" + q + "].sub_category._id");
				category=j.get("data[" + i + "].item_details[" + q + "].category._id");
				if (i == 0) {
					break;
				}
			}

		}
	}
}