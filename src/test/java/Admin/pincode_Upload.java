package Admin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class pincode_Upload {
	
	@Test
	public void pincode() {
		RestAssured.baseURI = "http://dev.djtretailers.com";
		
		given().log().all().headers("Content-Type",ContentType.JSON).body("{\r\n"
				+ "	\"mobile\":\"9999459457\"\r\n"
				+ "}").multiPart("file",new File("C:\\Users\\Admin\\Downloads\\PincodeExcel (1)")).
		when().post("/pincode/upload_excel").then().log().all().assertThat().statusCode(200).
		body("message",equalTo("Pincode data updated successfully"));	
	}
	

}
