package Admin;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Amdin_login {

	
	@Test
	public void adminlogin() {
		RestAssured.baseURI = "http://dev.djtretailers.com";//initliazing
		Response response = given().log().all().header("Content-Type","application/json")
				.body("{\r\n"
						+ "	\"mobile\":\"9999459457\"\r\n"
						+ "}\r\n"
						+ "").when()
				.post("/DRO/authentication/?type=ADMIN").then().log().all().assertThat().statusCode(200).extract().response();
		
		String r=response.asString();
		System.out.println(r);
	}
}
