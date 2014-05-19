package miljoboven.client.registercase;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import miljoboven.client.MainFrame;
import miljoboven.client.Unit;



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
    	
    	
    	 DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("sv","SE"));

         if(e.getActionCommand().equals("OK")) {
        	try {
				listener.okButtonPressed(date.parse(view.tf_crimeDate.getText()), (String) view.c_unit.getSelectedItem(), view.tf_crimeType.getText(),
						view.tf_crimeLocation.getText(), view.ta_comments.getText(), view.tf_name.getText(), view.tf_address.getText(), view.tf_phone.getText());
			} catch (ParseException e1) {
			
				e1.printStackTrace();
			}
        	view.ta_comments.setText("");
        	view.tf_address.setText("");
        	view.tf_crimeDate.setText("≈≈≈≈-MM-DD");
        	view.tf_crimeLocation.setText("");
        	view.tf_crimeType.setText("");
        	view.tf_name.setText("");
        	view.tf_phone.setText("");
        	view.c_unit.setSelectedItem(Unit.AVFALL);
        	
         	
            JOptionPane pane = new JOptionPane();
            pane.setMessage("ƒrende registrerat");
            JDialog dialog = pane.createDialog(pane, "");
            dialog.setVisible(true);
            Object selectedValue = pane.getValue();
           
        	
        	
        	
            mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
        } if(e.getActionCommand().equals("Avbryt")) {
        	
            mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
        }
         
         
        
    }
    
    public void setView(RegisterCaseView view){
    	this.view = view;
    	
    }
    
   
}
