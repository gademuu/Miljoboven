package miljoboven.client.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miljoboven.client.MainFrame;
import miljoboven.client.Role;
import miljoboven.client.registercase.RegisterCaseListener;
import miljoboven.client.registercase.RegisterCaseView;

public class LoginViewActionHandler implements ActionListener {
	
    private MainFrame mainFrame = null;
    LoginListener listener = null;
    LoginView view = null;
	

	public LoginViewActionHandler(MainFrame mainFrame, LoginListener listener) {
		    this.mainFrame = mainFrame;
	        this.listener = listener;
	}
	
	  @Override
	    public void actionPerformed(ActionEvent e) {

	         if(e.getActionCommand().equals("Logga in")) {
	        	listener.loginBtnPressed(view.tf_name.getText(), view.tf_password.getText());
	        	if(mainFrame.getRole().role.equals(Role.ADMIN)){
	        		
	        		mainFrame.getLayout().show(mainFrame.getContentPane(), "REGISTER_USER_VIEW");
	            
	        	}else if(mainFrame.getRole().role.equals(Role.ENHETSCHEF)){
	        		
	        		mainFrame.getLayout().show(mainFrame.getContentPane(), "REGISTER_CASE_VIEW");
	        		
	        	}else if(mainFrame.getRole().role.equals(Role.HANDLAGGARE)){
	        		
	        		mainFrame.getLayout().show(mainFrame.getContentPane(), "REGISTER_CASE_VIEW");
	        		
	        	}else if(mainFrame.getRole().role.equals(Role.MILJOSAMORDNARE)){
	        		
	        		mainFrame.getLayout().show(mainFrame.getContentPane(), "REGISTER_CASE_VIEW");
	        		
	        	}else{
	        		
	        		System.out.println("Unknown role" + mainFrame.getRole().role);
	        	}
	        	
	        }
	         
	         
	        
	    }
	    
	    public void setView(LoginView view){
	    	this.view = view;
	    	
	    }

}
