package miljoboven.client.updatecase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;

import miljoboven.client.MainFrame;


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
	        	listener.okButtonPressed(generateDate(view.tf_crimeDate.getText()), view.tf_unit.getText(), view.tf_crimeType.getText(),
	        		view.tf_crimeLocation.getText(), view.ta_comments.getText(), view.tf_name.getText(), view.tf_address.getText(), view.tf_phone.getText(), view.tf_seeFiles
	        			,view.tf_uploadFiles,view.tf_status);
	            mainFrame.getLayout().show(mainFrame.getContentPane(), "SHOW_CASE_VIEW");
	        }
	         
	         
	        
	    }
	    
	    public void setView(UpdateCaseView view){
	    	this.view = view;
	    	
	    }
	    
	    private Date generateDate(String crimeDate){
	    	GregorianCalendar cal = null;
	    	try{
				Scanner scanner = new Scanner(crimeDate);
				scanner.useDelimiter("-");

				String year = null;
				String month = null;
				String date = null;

				 while (scanner.hasNext()) {
		                 year = scanner.next();
		                 month= scanner.next();
		                 date = scanner.next();   
		            }



					cal = new GregorianCalendar(new Integer(year).intValue(), new Integer(month).intValue(), new Integer(date).intValue());

				}catch(NumberFormatException nfe){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("FEL DATUM!");
					return null;
				}catch(IllegalStateException ise){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("Fel state");
					return null;

				}catch(NoSuchElementException nsee){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("Inget element");
					return null;

				}
	    	return cal.getTime();
	    	
	    	
	    }

}
