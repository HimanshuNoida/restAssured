package Admin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class verifyOTP {

	public static String cookies;
	
	
		@Test
		public static void main() throws InterruptedException {
			RestAssured.baseURI = "http://dev.djtretailers.com";
			
			String mobile = "9999459457";
			Thread.sleep(3000);
			RestAssured.baseURI = "http://dev.djtretailers.com";
			SessionFilter session=new SessionFilter();
			
			String OTP = "3050";
			Response response = given().log().all().header("Content-Type", "application/json")
					.body(payload.verifyOTP(OTP))
					.when().post("/authentication/otp-verify").then().log().all().assertThat().statusCode(200)
					.body("message", equalTo("OTP verified successfully")).assertThat().extract().response();

			cookies = response.getCookie("session");
			System.out.println(cookies);
			String resp = response.asString();

			JsonPath js = new JsonPath(resp);
			String mobileNumber = js.get("data.mobile").toString();
			System.out.println(mobileNumber);
			String is_member = js.get("data.is_member").toString();
			System.out.println(is_member);
			String member_card_number = js.get("data.member_card_number").toString();
			System.out.println(member_card_number);
	}

}
