package miljoboven.logic.registeruser;

import miljoboven.backend.user.User;
import miljoboven.backend.user.UserDAO;
import miljoboven.client.Role;
import miljoboven.client.Unit;
import miljoboven.client.registeruser.RegisterUserListener;

public class RegisterUserManager implements RegisterUserListener {
	
	private UserDAO ud = new UserDAO();

	public RegisterUserManager() {
		
	}

	//TODO
	//Add listener interface
	public void registerUserButtonPressed(String name, String password, String role, String unit){
		User user = new User(name,password,role,unit);
		ud.create(user);
		//TODO 
		//catch exception from DAO in case user already exsists SHOW DIALOUGE.
		
	}
	
	public static void main(String[] args){
		RegisterUserManager rum = new RegisterUserManager();
		rum.registerUserButtonPressed("Lovisa", "apa", Role.MILJOSAMORDNARE, Unit.MILJO);
		
	}
	


}
