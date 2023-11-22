import static org.testng.Assert.assertEquals;

import java.awt.Container;

import org.testng.annotations.Test;

import files.payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class login {

	public static String OTP;
	static RequestSpecification req;
	public 	static String cookies;
	@Test
	public static void Login() throws InterruptedException {
		
			RestAssured.baseURI = "http://dev.djtretailers.com";
			Response response = given().log().all(). header("Content-Type", "application/json")
					.body("{\r\n"
							+ "	\"mobile\":\"9999459457\"\r\n"
							+ "}\r\n"
							+ "")  .when()
					.post("/authentication/login").then().log().all().assertThat().statusCode(200).extract()
					.response();
			
			cookies = response.getCookie("session");
			System.out.println(cookies);
		
		}
	
		
	/*	

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://dev.djtretailers.com")
				.setContentType(ContentType.JSON).build();
		LoginNumber login = new LoginNumber();
		data dlogin = new data();
		login.setMobile("9999459457");
		RequestSpecification reqq = given().log().all().spec(req).body(login);
		LoginResponse loginnresponse = reqq.when().post("/authentication/login").then().extract().response()
				.as(LoginResponse.class);
		System.out.println(loginnresponse.getMessage());
		System.out.println(loginnresponse.getSuccess());
		System.out.println(loginnresponse.getData().getMobile());
	
		*/
		
	

	@Test(enabled = false)
	public static void main() throws InterruptedException {
		String mobile = "9999459457";
		Thread.sleep(3000);
		RestAssured.baseURI = "http://dev.djtretailers.com";
		String OTP = "2843";
		Response response = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "	\"mobile\":\"9999459457\",\r\n" + "	\"otp\":{\r\n" + "		\"value\":\"" + OTP
						+ "\"\r\n" + "	}\r\n" + "}")
				.when().post("/authentication/otp-verify").then().log().all().assertThat().statusCode(200)
				.body("message", equalTo("OTP verified successfully")).assertThat().extract().response();

		String cookies = response.getCookie("session");
		System.out.println(cookies);

	}

}
