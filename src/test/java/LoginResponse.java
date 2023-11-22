
public class LoginResponse {

	private String message;
	private String success;
	private  data data ;
	
	
	public data getData() {
		return data;
	}
	public void setData(data data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}

}
