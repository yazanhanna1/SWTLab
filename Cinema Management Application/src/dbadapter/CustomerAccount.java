package dbadapter;
/**
 * Class representing a customerAcocunt
 * 
 * @author Yazan Elyateem
 *
 */

public class CustomerAccount {
	private String email;
	private String password;
	
	public CustomerAccount(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String toString() {
		return "CustomerAccount [email=" + email + ", password=" + password + "]";
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
