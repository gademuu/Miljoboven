package miljoboven.client.listcases;
import java.awt.event.*;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import miljoboven.client.MainFrame;
import miljoboven.client.registercase.RegisterCaseView;



public class ListCasesViewActionHandler extends MouseAdapter implements ActionListener{
	
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
	        } else if(e.getActionCommand().equals("Sök")) {
	        	
	        	
	        	    RowFilter<TableModel, Object> rf = null;
	        	    //If current expression doesn't parse, don't update.
	        	    try {
	        	        rf = RowFilter.regexFilter(view.tf_assignedTo.getText());
	        	        view.sorter.setRowFilter(rf);
	        	    } catch (java.util.regex.PatternSyntaxException i) {
	        	       
	        	    }
	        	    
	        	    
	        	}
	        	
	 }
	         
		
	
	
	public void caseSelected(String caseId) {
		mainFrame.getLayout().show(mainFrame.getContentPane(), "UPDATE_CASE_VIEW");
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		String caseID = (String) target.getModel().getValueAt(row, 0);
		caseSelected(caseID);
		listener.caseSelected(caseID);
		//TODO
		//Anropa manager för att lägga in data i update view.
		

	}
}