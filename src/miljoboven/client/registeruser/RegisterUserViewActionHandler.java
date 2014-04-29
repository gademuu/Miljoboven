package miljoboven.client.registeruser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
	        	listener.registerUserButtonPressed(view.tf_name.getText(), view.tf_password.getText(),(String)view.cb_role.getSelectedItem(),(String)view.cb_unit.getSelectedItem());
	        	  view.tf_name.setText("");
	        	  view.tf_password.setText("");
	        	  JOptionPane.showMessageDialog(null, "Användare skapad");
	        	  
	        	  
	         }else if(e.getActionCommand().equals("Avsluta")){
	        	 
	        	    mainFrame.getLayout().show(mainFrame.getContentPane(), "LOGIN_VIEW");
	         }
	    }
	    
	    public void setView(RegisterUserView view){
	    	this.view = view;
	    	
	    }


}
