package ourPackage;
import java.util.*;

import ourPackage.Record;
public class Users {
	List<User> users; 
	
	public Users(){
		users = new ArrayList<User>();
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public User get(int i) {
		// TODO Auto-generated method stub
		User u = users.get(i);
		return u;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		
		return users.size();
	}
	
	public void printUsers()
	{
		System.out.println("All of your users: " + "(" + size() + ")");
		System.out.println();
		
		for (int i = 0; i < size(); i++) {
			User user = users.get(i);
			System.out.println("Entry #" + i + ": ");
			System.out.println("User: " + user.getUsername());
			System.out.println();
		}
		System.out.println();
	}
}