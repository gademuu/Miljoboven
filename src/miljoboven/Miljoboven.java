package miljoboven;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseViewSetter;
import miljoboven.logic.listcases.ListCasesManager;
import miljoboven.logic.login.LoginManager;
import miljoboven.logic.registercase.RegisterCaseManager;
import miljoboven.logic.registeruser.RegisterUserManager;
import miljoboven.logic.updatecase.UpdateCaseManager;

public class Miljoboven {
	

	private MainFrame mainFrame = null;
    private RegisterCaseManager rcm = null;
    private LoginManager lm = null;
    private RegisterUserManager rum = null;
    private UpdateCaseManager ucm = null;
    private ListCasesManager lcm = null;
	
	
    public Miljoboven() { 
			  
    	ucm = new UpdateCaseManager();
    	lcm = new ListCasesManager(ucm);
    	lm = new LoginManager(lcm);
    	rcm = new RegisterCaseManager(lcm);
    	rum = new RegisterUserManager();
    	
	    mainFrame = new MainFrame(rcm, lm, rum, ucm, lcm);
	    ucm.setUpdateCaseViewSetter(mainFrame.getUpdateCaseSetter());
	    lcm.setListCasesSetter(mainFrame.getListCasesSetter());
	    
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
