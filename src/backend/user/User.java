package backend.user;

/**
 * The User class represents a user with the persistent data, name, role and
 * password.
 *
 * @author herman
 */
public class User {
	
	private String name;
	private String password;
	private String role;
	
	public User(String name, String password, String role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role="
				+ role + "]";
	}
	
	/**
    *
    * @param password
    * @return false
    */
   public boolean isCorrect(String password) {
       if (this.password != null) {
           return this.password.equals(password);
       }

       return false;

   }
	
	
	
	
	
	

}
