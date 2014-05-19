package miljoboven.client.updatecase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;













import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import miljoboven.client.MainFrame;
import miljoboven.client.Status;
import miljoboven.client.listcases.ListCasesListener;



public class UpdateCaseViewActionHandler implements ActionListener{

	 private MainFrame mainFrame = null;
	 UpdateCaseListener listener = null;
	 ListCasesListener listListener = null;
	 UpdateCaseView view = null;
	 
	    
	    private BufferedImage image;
	    
	    public UpdateCaseViewActionHandler(MainFrame mainFrame, UpdateCaseListener listener,ListCasesListener listListener) {
	        this.mainFrame = mainFrame;
	        this.listener = listener;
	        this.listListener = listListener;
	    }
	    

	    @Override
	    public void actionPerformed(ActionEvent e) {

	         if(e.getActionCommand().equals("Uppdatera")) {
	        	
	        	 DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("sv","SE"));
	        	 int n = view.c_seeFiles.getItemCount();
	        	 String[] fileNames = new String[n];
	        	 
	        	 for(int i = 0; i < n; i++){
	        		 
	        		fileNames[i] = (String) view.c_seeFiles.getItemAt(i);
	        		 
	        	 }
	        	 
	        	
	        	try {
					listener.okButtonPressed(view.l_id.getText(), date.parse(view.tf_crimeDate.getText()), (String) view.c_unit.getSelectedItem(), view.tf_crimeType.getText(),
						view.tf_crimeLocation.getText(), view.ta_comments.getText(), view.tf_name.getText(), view.tf_address.getText(), view.tf_phone.getText()
							,fileNames,(String) view.c_status.getSelectedItem(),date.parse(view.tf_dateOfReport.getText()),view.tf_assign.getText(), view.cb_investigate.isSelected());
					
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
	        	listListener.createList();
	            mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
	       
	        }else if(e.getActionCommand().equals("Avbryt")){
	        	
	        	mainFrame.getLayout().show(mainFrame.getContentPane(), "LIST_CASES_VIEW");
	        	
	        }else if(e.getActionCommand().equals("Ladda up")){
	        	
	        	  JFileChooser chooser = new JFileChooser();
	        	  File file = null;
	        	 
	        	  
	        	  int returnVal = chooser.showOpenDialog(chooser);
	        	  if(returnVal == JFileChooser.APPROVE_OPTION) {
	        	       file = chooser.getSelectedFile();
	        	       
	 	        	  view.c_seeFiles.addItem(file.toString());
	 	        	  listener.addFile(file.toString());
	 	        	  
	 	        	  
	 	        	  
	        	    }
	        	  
	        	 
	        	  
	            try {                
	               image = ImageIO.read(file);
	               
	                   ImageIcon icon = new ImageIcon(image);
	                   JLabel label = new JLabel(icon);
	                   JOptionPane.showMessageDialog(null, label);
	                } catch (IOException ex) {
	                   ex.printStackTrace();
	                }
	        	
	        	
	        	
	        	
	        }else if(e.getSource() == view.c_seeFiles){
	       	 
	            try {                
	               image = ImageIO.read(new File((String)view.c_seeFiles.getSelectedItem()));
	               
	                   ImageIcon icon = new ImageIcon(image);
	                   JLabel label = new JLabel(icon);
	                   JOptionPane.showMessageDialog(null, label);
	                } catch (IOException ex) {
	                   ex.printStackTrace();
	                }
	        	
	        }
	         
	        
	    }
	    
	    
	   
	    
	    public void setView(UpdateCaseView view){
	    	this.view = view;
	    	
	    }
	    
	    

}
