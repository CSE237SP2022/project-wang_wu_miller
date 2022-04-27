package ourPackage;
import java.util.Date;

public class User {
	private String username; 
	
	public User (String username) {
		this.username = username; 
	}
	
	public String getUsername() {
		return username; 
	}
	
	public void printUser()
	 {
		 System.out.println("Username: " + username);
	 }
	
}