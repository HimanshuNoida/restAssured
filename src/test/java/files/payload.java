package files;

public class payload {

	public static String loginPayload() {
	return	"{\r\n"
			+ "	\"mobile\":\"9999459457\"\r\n"
			+ "}\r\n"
			+ "";
	}
	
	
	public static String verifyOTP(String OTP) {
		return	"{\r\n"
				+ "	\"mobile\":\"9999459457\",\r\n"
				+ "	\"otp\":{\r\n"
				+ "		\"value\":\""+OTP+"\"\r\n"
				+ "	}\r\n"
				+ "}";
		}
		
	public static String warehouseCookie() {
		return	"{\r\n"
				+ "	\"pincode\" : \"201304\"\r\n"
				+ "}";
	};
		
	
	
	
}
