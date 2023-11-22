import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class id {

	public static String i;

	@Test
	public static String id() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		Response response = given().log().all().header("Content-Type", "application/json").when().get("/item/believe")
				.then().log().all().assertThat().statusCode(200).extract().response();
		String js = response.asString();
		JsonPath e = new JsonPath(js);
		int s = e.getInt("data.items.size()");
		System.out.println(s);
		
		for(int sd=0;sd<s;sd++) {
			i=e.get("data.items["+s+"].id");
			
			}
		return i;
		}
		}
	


