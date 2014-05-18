package miljoboven.client.registercase;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;

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
    	
    	 DateFormat date = DateFormat.getDateInstance();

         if(e.getActionCommand().equals("OK")) {
        	try {
				listener.okButtonPressed(date.parse(view.tf_crimeDate.getText()), view.tf_unit.getText(), view.tf_crimeType.getText(),
						view.tf_crimeLocation.getText(), view.ta_comments.getText(), view.tf_name.getText(), view.tf_address.getText(), view.tf_phone.getText());
			} catch (ParseException e1) {
			
				e1.printStackTrace();
			}
            mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
        } if(e.getActionCommand().equals("Avbryt")) {
        	
            mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
        }
         
         
        
    }
    
    public void setView(RegisterCaseView view){
    	this.view = view;
    	
    }
    
   
}
