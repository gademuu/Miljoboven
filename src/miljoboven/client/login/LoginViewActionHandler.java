package miljoboven.client.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miljoboven.client.MainFrame;
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
	            mainFrame.getLayout().show(mainFrame.getContentPane(), "SHOW_CASE_VIEW");
	        }
	         
	         
	        
	    }
	    
	    public void setView(LoginView view){
	    	this.view = view;
	    	
	    }

}
