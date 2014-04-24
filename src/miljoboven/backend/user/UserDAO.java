package miljoboven.backend.user;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import miljoboven.backend.BaseDAO;

public class UserDAO extends BaseDAO{
	
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	private static final String ROLE = "role";
	
	private static final String PREFIX = "user_";
	private static final String SUFFIX = ".properties";
	
	
	
	 
	
	
	 /**
     * Creates a new User object.
     * @param aUser 
     * @return aUser
     */
	public User create(User aUser){
		
		//TODO
		//Throw Exception user already exsists
		//User[] users = find(aUser);
		//if(users.length > 0) throw exception
		
		String id = aUser.getName();
		Properties prop = new Properties();
		String userFile = PREFIX + id + SUFFIX;
		
		prop = load(userFile);
		

        prop.setProperty(NAME,aUser.getName().toString());
        prop.setProperty(PASSWORD,aUser.getPassword().toString());
        prop.setProperty(ROLE,aUser.getRole().toString());
        store(userFile, prop, true);

		
		
		return aUser;
	}
	
	/**
     * Reads a User object.
     * @param aUser 
     * @return aUser
     */
	public User read(User aUser){
		
		String id = aUser.getName();
		String userFile = PREFIX + id + SUFFIX;
		 User user = null;
		 
	     Properties prop = new Properties();
	     
	     
	     prop = load(userFile);
	        String password = (String) prop.get(id);
	        //System.out.println(password);
	        user = new User(id, PASSWORD,ROLE);

	        System.out.println("READ(" + aUser.getName() + "): " + user.toString());
	        
	        return user;	
		
	}
	
	
	 /**
     * Finds a User object
     * @param criteria
     * @return matchUsers
     */
	public User[] find(User criteria){
		
		  ArrayList<User> users = new ArrayList<>(); 
		  
	        String filePath = "."; 
	        File f = new File(filePath); 
	        String[] fileNames = f.list(); 
	        
	       
	        
	        for (int i = 0; i < fileNames.length; i++) { 
	                if(fileNames[i].startsWith(PREFIX + criteria.getName())){
	                	System.out.println("File: " + fileNames[i]);
	                	String userName = fileNames[i].substring(PREFIX.length(),fileNames[i].lastIndexOf(SUFFIX));
	                	System.out.println("User: " + userName);
	                	User u = new User(userName,"","");
	                	users.add(read(u));
	                }
	                
	            
	        } 
	        
	        
	        User[] arr = new User[users.size()];
	        return users.toArray(arr); 
	}
	
	
	public static void main(String[] args){
		UserDAO ud = new UserDAO();
		User u = new User("admin", "admin", "admin");
		ud.create(u);
		
		
		
		
		/*
		User[] users = ud.find(new User("","",""));
		
		for(User apa : users){
		System.out.println(apa.toString());
		}
		*/
		
		/*User[] users = ud.find(new User("Arne","",""));
		
		for(User apa : users){
		System.out.println(apa.toString());
		}*/
	}
	
}
