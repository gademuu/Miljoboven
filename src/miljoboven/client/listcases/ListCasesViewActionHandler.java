package miljoboven.client.listcases;
import java.awt.event.*;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseView;
import miljoboven.util.DateCreator;


public class ListCasesViewActionHandler implements ActionListener{
	
	private ListCasesListener listener = null;
	private MainFrame mainFrame = null;
	private ListCasesView view = null;
	
	public ListCasesViewActionHandler(MainFrame mainFrame, ListCasesListener listener){
		
	      this.mainFrame = mainFrame;
	        this.listener = listener;
		
	}
	
	 public void setView(ListCasesView view){
	    	this.view = view;
	    	
	    }
	 
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		  if(e.getActionCommand().equals("Logga ut")) {
	        	
	            mainFrame.getLayout().show(mainFrame.getContentPane(), "LOGIN_VIEW");
	        } else if(e.getActionCommand().equals("Registrera")) {
	        	
	            mainFrame.getLayout().show(mainFrame.getContentPane(), "REGISTER_CASE_VIEW");
	        }
	         
		
	}

}
