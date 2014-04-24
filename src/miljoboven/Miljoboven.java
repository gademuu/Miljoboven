package miljoboven;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseViewSetter;
import miljoboven.logic.login.LoginManager;
import miljoboven.logic.registercase.RegisterCaseManager;

public class Miljoboven {
	

	private MainFrame mainFrame = null;
    private RegisterCaseManager rcm = null;
    private LoginManager lm = null;
	
	
    public Miljoboven() { 
		
	   //rcm = new RegisterCaseManager(mainFrame.getRegisterCaseViewSetter());
    	rcm = new RegisterCaseManager();
    	lm = new LoginManager();
	    mainFrame = new MainFrame(rcm, lm);
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
