package miljoboven;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseViewSetter;
import miljoboven.logic.login.LoginManager;
import miljoboven.logic.registercase.RegisterCaseManager;
import miljoboven.logic.registeruser.RegisterUserManager;

public class Miljoboven {
	

	private MainFrame mainFrame = null;
    private RegisterCaseManager rcm = null;
    private LoginManager lm = null;
    private RegisterUserManager rum = null;
	
	
    public Miljoboven() { 
		
	   //rcm = new RegisterCaseManager(mainFrame.getRegisterCaseViewSetter());
    	rcm = new RegisterCaseManager();
    	lm = new LoginManager();
    	rum = new RegisterUserManager();
	    mainFrame = new MainFrame(rcm, lm, rum );
	    lm.setLoginSetter(mainFrame);
    } 
      
    public void run() { 
        mainFrame.initialize(); 
    } 
      
      
      
      
    public static void main(String[] args) { 
          
    	Miljoboven mb = new Miljoboven(); 
        mb.run(); 
          
    } 

}
