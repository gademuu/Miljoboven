package miljoboven.client.updatecase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;




import miljoboven.client.MainFrame;
import miljoboven.util.DateCreator;


public class UpdateCaseViewActionHandler implements ActionListener{

	 private MainFrame mainFrame = null;
	    UpdateCaseListener listener = null;
	    UpdateCaseView view = null;
	    
	    public UpdateCaseViewActionHandler(MainFrame mainFrame, UpdateCaseListener listener) {
	        this.mainFrame = mainFrame;
	        this.listener = listener;
	        
	    }
	    

	    @Override
	    public void actionPerformed(ActionEvent e) {

	         if(e.getActionCommand().equals("Uppdatera")) {
	        	
	        	 DateFormat date = DateFormat.getDateInstance();
	        	
	        	try {
					listener.okButtonPressed(view.l_id.getText(), date.parse(view.tf_crimeDate.getText()), view.tf_unit.getText(), view.tf_crimeType.getText(),
						view.tf_crimeLocation.getText(), view.ta_comments.getText(), view.tf_name.getText(), view.tf_address.getText(), view.tf_phone.getText()
							,view.tf_uploadFiles.getText(),view.tf_status.getText(),date.parse(view.tf_dateOfReport.getText()),view.tf_asssign.getText(), view.cb_investigate.isSelected());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	            mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
	        }else if(e.getActionCommand().equals("Avbryt")){
	        	
	        	mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
	        	
	        }
	         
	     
	         
	         
	        
	    }
	    
	    public void setView(UpdateCaseView view){
	    	this.view = view;
	    	
	    }
	    
	    

}
