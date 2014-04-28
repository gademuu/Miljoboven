package miljoboven.client.listcases;
import java.awt.event.*;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseView;


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
		// TODO Auto-generated method stub
		
	}

}
