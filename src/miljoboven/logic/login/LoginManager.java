package miljoboven.logic.login;

import miljoboven.backend.user.User;
import miljoboven.backend.user.UserDAO;
import miljoboven.client.listcases.ListCasesSetter;
import miljoboven.client.login.LoginListener;
import miljoboven.client.login.LoginSetter;
import miljoboven.logic.listcases.ListCasesManager;

public class LoginManager implements LoginListener{
	
   
	private UserDAO userDAO = new UserDAO();
	private LoginSetter loginSetter = null;
    public User user;
	private ListCasesManager lcm = null;
	
	public LoginManager(ListCasesManager lcm) {
		this.lcm = lcm;
	}
	
	/**
     * Uses the UserDAO method read to see if the user exists and verifies the password. 
     * @param name
     * @param password
     */
    public void loginBtnPressed(String name, String password){
        user = new User(name, password, "","");
        
         user = userDAO.read(user);
         
         if(user == null){
        	 System.out.println("No user found!");
        	 return;
         }
        
        if(user.isCorrect(password)){
            System.out.println("User login okey!");
            loginSetter.setRole(user.getRole());
            lcm.createList();
          	
        }else{
            user = null;
            System.out.println("Wrong username or password");
            return;
        }
        
        
    }
    
    
    public void setLoginSetter(LoginSetter setter){
    	this.loginSetter = setter;
    	
    }
    
  

}
