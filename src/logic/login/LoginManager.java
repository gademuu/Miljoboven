package logic.login;

import client.login.LoginListener;
import backend.user.User;
import backend.user.UserDAO;

public class LoginManager implements LoginListener{
	
	private User user;
	private UserDAO userDAO = new UserDAO();
	
	/**
     * Uses the UserDAO method read to see if the user exists and verifies the password. 
     * @param name
     * @param password
     */
    public void loginBtnPressed(String name, String password){
        user = new User(name, password, "");
        
         user = userDAO.read(user);
         
         if(user == null){
        	 System.out.println("No user found!");
        	 return;
         }
        
        if(user.isCorrect(password)){
            System.out.println("User login okey!");
        	
        }else{
            user = null;
            System.out.println("Wrong username or password");
        }
        
    }
    
    public static void main(String[] args){
    	LoginManager lm = new LoginManager();
    	lm.loginBtnPressed("Herman", "pizza");
    	
    }

}
