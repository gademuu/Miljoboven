package miljoboven.client.registercase;

import java.awt.event.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;

import miljoboven.client.MainFrame;


/**
 *
 * @author herman
 */
public class RegisterCaseViewActionHandler implements ActionListener {
    
    private MainFrame mainFrame = null;
    RegisterCaseListener listener = null;
    RegisterCaseView view = null;
    
    public RegisterCaseViewActionHandler(MainFrame mainFrame, RegisterCaseListener listener) {
        this.mainFrame = mainFrame;
        this.listener = listener;
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

         if(e.getActionCommand().equals("OK")) {
        	listener.okButtonPressed(generateDate(view.tf_crimeDate.getText()), view.tf_unit.getText(), view.tf_crimeType.getText(),
        			view.tf_crimeLocation.getText(), view.ta_comments.getText(), view.tf_name.getText(), view.tf_address.getText(), view.tf_phone.getText());
            mainFrame.getLayout().show(mainFrame.getContentPane(), "SHOW_CASE_VIEW");
        }
         
         
        
    }
    
    public void setView(RegisterCaseView view){
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
