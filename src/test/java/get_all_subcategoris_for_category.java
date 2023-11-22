import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class get_all_subcategoris_for_category {
	public static String category;

	@Test
	public static void get_all_subcategoris_for_category() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		Response response = given().log().all().queryParam("category_id",show_collections.category). header("Content-Type", "application/json").when()
				.get("/item/getsubcategoryforcategory").then().log().all().assertThat().statusCode(200).extract()
				.response();
/*
		String js = response.asString();
		JsonPath j = new JsonPath(js);

		int size = j.getInt("data.size()");

		for (int i = 0; i < size; i++) {
			int size1 = j.getInt("data["+i+"].item_details.size()");

			System.out.println(size1);
			for (int q = 0; q < size1; q++) {

				category = j.get("data["+i+"].item_details["+q+"].category._id");
				
				System.out.println(category);
				if (i == 0) {
					break;
				}
			}
		}
*/
	}
}
