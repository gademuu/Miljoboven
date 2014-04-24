package miljoboven;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseViewSetter;
import miljoboven.logic.registercase.RegisterCaseManager;

public class Miljoboven {
	

	private MainFrame mainFrame = null;
    private RegisterCaseManager rcm = null;
	
	
    public Miljoboven() { 
		
	   //rcm = new RegisterCaseManager(mainFrame.getRegisterCaseViewSetter());
    	rcm = new RegisterCaseManager();
	    mainFrame = new MainFrame(rcm); 
    } 
      
    public void run() { 
        mainFrame.initialize(); 
    } 
      
      
      
      
    public static void main(String[] args) { 
          
    	Miljoboven mb = new Miljoboven(); 
        mb.run(); 
          
    } 

}
