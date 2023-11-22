import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;


public class Amdin_login {

	public void adminlogin() {
		
		given().log().all().headers("Content-Type",ContentType.JSON).body("{\r\n"
				+ "	\"mobile\":\"9999459457\"\r\n"
				+ "}").when().post("/DRO/authentication/?type=ADMIN").then().assertThat().statusCode(200).
		body("message", equalTo("OTP sent successfully"));
		
		
	}
}
