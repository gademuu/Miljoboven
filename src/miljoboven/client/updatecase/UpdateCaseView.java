package miljoboven.client.updatecase;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.Border;

import miljoboven.client.MainFrame;
import miljoboven.client.Role;
import miljoboven.client.Status;
import miljoboven.client.Unit;

/**
 * The view for updating cases 
 * @author Herman
 *
 */
public class UpdateCaseView extends JPanel implements UpdateCaseViewSetter {

	private ActionListener actionListener = null;
	private MainFrame mainFrame = null;
    
    // Text fields and labels
	//Reporter
    
	
	
    private JLabel l_headReporter = new JLabel("Uppgifter om anm‰laren");
    
    JLabel l_id = new JLabel();
    
    private JLabel l_name = new JLabel("Namn");
    JTextField tf_name = new JTextField(20);
    
    private JLabel l_address = new JLabel("Adress");
    JTextField tf_address = new JTextField(20);
    
    private JLabel l_phone = new JLabel("Telefon");
    JTextField tf_phone = new JTextField(20);
    
    //Crime
    private JLabel l_headCrime = new JLabel("Uppgifter om brottet");
    
    private JLabel l_crimeDate = new JLabel("Datum for brott");
    JTextField tf_crimeDate = new JTextField("≈≈≈≈-MM-DD");
    
    private JLabel l_crimeLocation = new JLabel("Plats fˆr brott");
    JTextField tf_crimeLocation = new JTextField(20);
    
    private JLabel l_crimeType = new JLabel("Typ av brott");
    JTextField tf_crimeType = new JTextField(20);
    
    private JLabel l_dateOfReport = new JLabel("Rapporterings datum");
    JTextField tf_dateOfReport = new JTextField("≈≈≈≈-MM-DD");
    
    private JLabel l_unit = new JLabel("V‰lj enhet fˆr utredning");
    JComboBox c_unit = new JComboBox(new String[]{Unit.AVFALL,Unit.AVLOPPSHANTERING,Unit.IT,Unit.KLIMAT,Unit.MILJO,Unit.NATUR});
    
    
    
    
    //Files and comments
    private JLabel l_headComments = new JLabel("÷vriga uppgifter");
    JTextArea ta_comments = new JTextArea(10,20);
    
    private JLabel l_seeFiles = new JLabel("Se filer");
    JComboBox c_seeFiles = new JComboBox();
    
    private JLabel l_uploadFiles = new JLabel("Ladda upp filer");
    JTextField tf_uploadFiles = new JTextField(20);
    
    private JLabel l_status = new JLabel("Status");
    
    JComboBox c_status = new JComboBox(new String[]{Status.INRAPPORTERAD,Status.PABORJAD,Status.KLAR});
    
    //TODO
    private JLabel l_assign = new JLabel("Tilldela handl‰ggare");
    JTextField tf_assign = new JTextField(10);
    
  
    private JLabel l_investigate = new JLabel("Ska ej utredas");
	JCheckBox cb_investigate = new 	JCheckBox();
    
    
    // End of fields and labels
    
    // Buttons
    private JButton okButton = new JButton("Uppdatera");  
    private JButton cancelButton = new JButton("Avbryt"); 
    private JButton uploadButton = new JButton("Ladda up"); 
    
    public UpdateCaseView(MainFrame mainFrame, ActionListener actionListener) {
        this.actionListener = actionListener;
        this.mainFrame = mainFrame;
    }
    
    
    public void initialize() {
        setBackground(Color.GRAY);
        setSize(600,600);
        Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas

        
        setLayout(new GridBagLayout());
        GridBagConstraints c = null;
     
        //ID
        c = new GridBagConstraints(); 
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(l_id, c);
   
            
        // Head Reporter 
        c = new GridBagConstraints(); 
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(l_headReporter, c);
        
        // Reporter name
        c = new GridBagConstraints();
        JPanel nameTextBoxPanel = new JPanel(new FlowLayout());
        nameTextBoxPanel.setBorder(outline); // To show the component border
        nameTextBoxPanel.add(l_name);
        nameTextBoxPanel.add(tf_name);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(nameTextBoxPanel, c);
        
        // Reporter address
        c = new GridBagConstraints();
        JPanel addressTextBoxPanel = new JPanel(new FlowLayout());
        addressTextBoxPanel.setBorder(outline); // To show the component border
        addressTextBoxPanel.add(l_address);
        addressTextBoxPanel.add(tf_address);
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(addressTextBoxPanel, c);
        
        // Reporter phone
        c = new GridBagConstraints();
        JPanel phoneTextBoxPanel = new JPanel(new FlowLayout());
        phoneTextBoxPanel.setBorder(outline); // To show the component border
        phoneTextBoxPanel.add(l_phone);
        phoneTextBoxPanel.add(tf_phone);
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add( phoneTextBoxPanel, c);
        
        
        /////////////////////////
        
        // Head crime
        c = new GridBagConstraints(); 
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(l_headCrime, c);
        
        
        // Crime Date Textbox
        c = new GridBagConstraints();
        JPanel crimeDateTextBoxPanel = new JPanel(new FlowLayout());
        crimeDateTextBoxPanel.setBorder(outline); // To show the component border
        crimeDateTextBoxPanel.add(l_crimeDate);
        crimeDateTextBoxPanel.add(tf_crimeDate);
        c.gridx = 0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(crimeDateTextBoxPanel, c);
        
        // Crime Location Textbox
        c = new GridBagConstraints();
        JPanel crimeLocationTextBoxPanel = new JPanel(new FlowLayout());
        crimeLocationTextBoxPanel.setBorder(outline);
        crimeLocationTextBoxPanel.add(l_crimeLocation);
        crimeLocationTextBoxPanel.add(tf_crimeLocation);
        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.WEST;
        //c.insets = new Insets(0,10,0,0);
        //c.fill = GridBagConstraints.BOTH;
        add(crimeLocationTextBoxPanel, c);
        
        // Crime Type Textbox
        c = new GridBagConstraints();
        JPanel crimeTypeTextBoxPanel = new JPanel(new FlowLayout());
        crimeTypeTextBoxPanel.setBorder(outline); // To show the component border
        crimeTypeTextBoxPanel.add(l_crimeType);
        crimeTypeTextBoxPanel.add(tf_crimeType);
        c.gridx = 0;
        c.gridy = 8;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(crimeTypeTextBoxPanel, c);
        
        // Date of report
        c = new GridBagConstraints();
        JPanel dateOfReportTextBoxPanel = new JPanel(new FlowLayout());
        dateOfReportTextBoxPanel.setBorder(outline); // To show the component border
        dateOfReportTextBoxPanel.add(l_dateOfReport);
        dateOfReportTextBoxPanel.add(tf_dateOfReport);
        c.gridx = 0;
        c.gridy = 9;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(dateOfReportTextBoxPanel, c);
        
        
        /////////////////////////
       
        // Head comments
        c = new GridBagConstraints(); 
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(l_headComments, c);
        
        //comments
        c = new GridBagConstraints(); 
        c.gridheight = 5;
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(ta_comments, c);
        
        //See files
        c = new GridBagConstraints();
        JPanel seeFilesComboBoxPanel = new JPanel(new FlowLayout());
        seeFilesComboBoxPanel.setBorder(outline); // To show the component border
        seeFilesComboBoxPanel.add(l_seeFiles);
        seeFilesComboBoxPanel.add(c_seeFiles);
        c_seeFiles.addActionListener(actionListener);
        c.gridx = 2;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add( seeFilesComboBoxPanel, c);
        
       
        
        //Status
        c = new GridBagConstraints();
        JPanel statusComboBoxPanel = new JPanel(new FlowLayout());
        statusComboBoxPanel.setBorder(outline); // To show the component border
        statusComboBoxPanel.add(l_status);
        statusComboBoxPanel.add(c_status);
        c.gridx = 2;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(statusComboBoxPanel, c);
        
        
     
      
        
       
        
 
        
        
        // Buttons
        c = new GridBagConstraints();
        JPanel buttonPanel = new JPanel(new FlowLayout()); 
        
        buttonPanel.setBackground(Color.GRAY);
        okButton.addActionListener(actionListener); 
        cancelButton.addActionListener(actionListener);
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);    
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 11;
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, c);
        
       
        dependingOnRole();
      }
    
    
    
    public void dependingOnRole(){
    	  GridBagConstraints c = null;
    	  c = new GridBagConstraints();
    	  
    	  
    	 switch(mainFrame.getRole().role){
     	case Role.ENHETSCHEF:
     		
     	    JPanel assignTextBoxPanel = new JPanel(new FlowLayout());
     	   assignTextBoxPanel.add(l_assign);
     	  assignTextBoxPanel.add(tf_assign);
            c.gridx = 2;
            c.gridy = 6;
            c.anchor = GridBagConstraints.WEST;
            //c.fill = GridBagConstraints.BOTH;
            add(assignTextBoxPanel, c);
     		
     	
     
     	      // Unit 
     	      c = new GridBagConstraints();
     	      JPanel unitComboBoxPanel = new JPanel(new FlowLayout());
     	      unitComboBoxPanel.add(l_unit);
     	      unitComboBoxPanel.add(c_unit);
     	      c.gridx = 1;
     	      c.gridy = 7;
     	      c.anchor = GridBagConstraints.WEST;
     	      //c.fill = GridBagConstraints.BOTH;
     	      add( unitComboBoxPanel, c);
     	
     	   //Investigate 
           JPanel investigateTextBoxPanel = new JPanel(new FlowLayout());
           investigateTextBoxPanel.add(l_investigate);
           investigateTextBoxPanel.add(cb_investigate);
           cb_investigate.addActionListener(actionListener);
           c.gridx = 2;
           c.gridy = 5;
           c.anchor = GridBagConstraints.WEST;
           //c.fill = GridBagConstraints.BOTH;
           add(investigateTextBoxPanel, c);
     		
     	
     		break;
     		
     	case Role.HANDLAGGARE:
     	
     		 
     	/*	 //Upload files
            JPanel uploadFilesTextBoxPanel = new JPanel(new FlowLayout());
            uploadFilesTextBoxPanel.add(l_uploadFiles);
            uploadFilesTextBoxPanel.add(tf_uploadFiles);
            c.gridx = 2;
            c.gridy = 3;
            c.anchor = GridBagConstraints.WEST;
            //c.fill = GridBagConstraints.BOTH;
            add( uploadFilesTextBoxPanel, c);*/
            
            // Upload button
            JPanel uploadButtonPanel = new JPanel(new FlowLayout()); 
            uploadButtonPanel.setBackground(Color.GRAY);
            uploadButton.addActionListener(actionListener); 
            uploadButtonPanel.add(uploadButton);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 3;
            //c.gridy = 2;
            c.anchor = GridBagConstraints.PAGE_END;
            c.fill = GridBagConstraints.HORIZONTAL;
            add(uploadButtonPanel, c);
     		
     		
     		break;
     		
     	case Role.MILJOSAMORDNARE:
     		
     	   
     	      // Unit 
     	      c = new GridBagConstraints();
     	      JPanel TwounitComboBoxPanel = new JPanel(new FlowLayout());
     	      TwounitComboBoxPanel.add(l_unit);
     	      TwounitComboBoxPanel.add(c_unit);
     	      c.gridx = 1;
     	      c.gridy = 7;
     	      c.anchor = GridBagConstraints.WEST;
     	      //c.fill = GridBagConstraints.BOTH;
     	      add( TwounitComboBoxPanel, c);
         	 
     		
     		break;
     		
     	default:
     		
     		break;
     	}
      	
    }
    
 


	@Override
	public void setUpdateCaseListener(UpdateCaseListener updateCaseListener) {
		
	}


	@Override
	public void showCase(String id, Date crimeDate, String unit,
			String crimeType, String crimeLocation, String comments,
			String name, String address, String phone, String[] uploadFiles,
			String status, Date dateOfReport, String assign, boolean investigate) {
		
		DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("sv","SE"));
			l_id.setText(id); 
			tf_address.setText(address);
			ta_comments.setText(comments);
			//c_asssign.setText(assign);
	        tf_crimeDate.setText(date.format(crimeDate));
	        tf_crimeLocation.setText(crimeLocation);
	        tf_crimeType.setText(crimeType);
	        tf_dateOfReport.setText(date.format(dateOfReport));
	        tf_name.setText(name);
	        tf_phone.setText(phone);
	        //tf_seeFiles.setText(uploadFiles[0]); //TODO REPLACE WITH CHECK BOX
	        c_status.setSelectedItem(status);
	        c_unit.setSelectedItem(unit);
	        //tf_uploadFiles.setText(uploadFiles[0]); //TODO KANSKE INTE SKA VA S≈
	        cb_investigate.setSelected(investigate);
	        
		
	}

}
