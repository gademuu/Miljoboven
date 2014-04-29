package miljoboven.client.registeruser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miljoboven.client.MainFrame;
import miljoboven.client.Role;
import miljoboven.client.login.LoginListener;
import miljoboven.client.login.LoginView;

public class RegisterUserViewActionHandler implements ActionListener {

    private MainFrame mainFrame = null;
    RegisterUserListener listener = null;
    RegisterUserView view = null;
	

	public RegisterUserViewActionHandler(MainFrame mainFrame, RegisterUserListener listener) {
		    this.mainFrame = mainFrame;
	        this.listener = listener;
	}
	
	  @Override
	    public void actionPerformed(ActionEvent e) {

	         if(e.getActionCommand().equals("Spara")) {
	        	listener.registerUserButtonPressed(view.tf_name.getText(), view.tf_password.getText(),view.tf_role.getText(), view.tf_unit.getText());
	     
	         }else if(e.getActionCommand().equals("Avsluta")){
	        	 
	        	    mainFrame.getLayout().show(mainFrame.getContentPane(), "LOGIN_VIEW");
	         }
	    }
	    
	    public void setView(RegisterUserView view){
	    	this.view = view;
	    	
	    }


}
