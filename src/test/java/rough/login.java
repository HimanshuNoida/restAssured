package rough;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class login {
	
	public static String OTP;
	
	
	@Test
		public static void Login() throws InterruptedException {
		
			RestAssured.baseURI = "http://dev.djtretailers.com";
			
			String cookies;
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("mobile","9999459457");
			
			Response response = given().log().all().header("Content-Type", "application/json")
					.body(map)
					.when().post("/authentication/login").then().log().all().assertThat().statusCode(200)
					.body("message", equalTo("OTP sent successfully")).extract().response();
	}
	
	
		@Test(enabled = false)
		public static void main() throws InterruptedException {
			String mobile = "9999459457";
			Thread.sleep(3000);
			RestAssured.baseURI = "http://dev.djtretailers.com";
			String OTP = "4836";
			Response response = given().log().all().header("Content-Type", "application/json")
					.body("{\r\n"
							+ "	\"mobile\":\"9999459457\",\r\n"
							+ "	\"otp\":{\r\n"
							+ "		\"value\":\""+OTP+"\"\r\n"
							+ "	}\r\n"
							+ "}")
					.when().post("/authentication/otp-verify").then().log().all().assertThat().statusCode(200)
					.body("message", equalTo("OTP verified successfully")).assertThat().extract().response();

			String cookies = response.getCookie("session");
			System.out.println(cookies);

		}

}
