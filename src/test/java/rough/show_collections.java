package rough;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class show_collections{
	
	@Test
	public static void getcollection() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		String response = given().log().all().header("Content-Type", "application/json")
				.when().get("/collection/showcollection/believe").then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath js=new JsonPath(response);
		String message=js.get("message");
		System.out.println(message);
		
	int size=js.getInt("data.size()");
		System.out.println(size);
		for(int i=0;i<size;i++) {
			
	System.out.println(js.get("data["+i+"].collection_details._id"));
	System.out.println(js.get("data["+i+"].collection_details.name"));
	System.out.println(js.get("data["+i+"].collection_details.description"));
	System.out.println(js.get("data["+i+"].collection_details.collection_type"));	
	System.out.println(js.get("data["+i+"].collection_details.is_visible"));
	System.out.println(js.get("data["+i+"].collection_details.sort_order"));
	int s=js.get("data["+i+"].item_details.size()");
	for(int j=0;j<size;j++) {
		System.out.println(js.get("data["+i+"].item_details["+j+"]._id"));
		System.out.println(js.get("data["+i+"].item_details["+j+"].number"));
		System.out.println(js.get("data["+i+"].item_details["+j+"].name"));
		System.out.println(js.get("data["+i+"].item_details["+j+"].description"));
		System.out.println(js.get("data["+i+"].item_details["+j+"].hsn"));
		
	}
	
	
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
