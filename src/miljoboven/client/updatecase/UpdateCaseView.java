package miljoboven.client.updatecase;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import miljoboven.client.MainFrame;
import miljoboven.client.Role;

/**
 * The view for updating cases 
 * @author Herman
 *
 */
public class UpdateCaseView extends JPanel {

	private ActionListener actionListener = null;
	private MainFrame mainFrame = null;
    
    // Text fields and labels
	//Reporter
    
    private JLabel l_headReporter = new JLabel("Uppgifter om anm‰laren");
    
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
    
    private JLabel l_unit = new JLabel("Enhet");
    JTextField tf_unit = new JTextField(20);
    
    
    
    
    //Files and comments
    private JLabel l_headComments = new JLabel("÷vriga uppgifter");
    JTextArea ta_comments = new JTextArea(10,20);
    
    private JLabel l_seeFiles = new JLabel("Se filer");
    JTextField tf_seeFiles = new JTextField(20);
    
    private JLabel l_uploadFiles = new JLabel("Ladda upp filer");
    JTextField tf_uploadFiles = new JTextField(20);
    
    private JLabel l_status = new JLabel("Status");
    JTextField tf_status = new JTextField(20);
    
    //TODO
    private JLabel l_assign = new JLabel("Tilldela handl‰ggare");
    JTextField tf_asssign = new JTextField(20);
    
    //TODO
    private JLabel l_investigate = new JLabel("Ska ej utredas");
	JCheckBox cb_investigate = new 	JCheckBox();
    
    
    // End of fields and labels
    
    // Buttons
    private JButton okButton = new JButton("Uppdatera");  
    private JButton cancelButton = new JButton("Cancel"); 
    private JButton uploadButton = new JButton("Upload"); 
    
    public UpdateCaseView(MainFrame mainFrame, ActionListener actionListener) {
        this.actionListener = actionListener;
        this.mainFrame = mainFrame;
    }
    
    
    public void initialize() {
        setBackground(Color.GRAY);
        setSize(700,700);
        Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas

        
        setLayout(new GridBagLayout());
        GridBagConstraints c = null;
      
        // Head Reporter 
        c = new GridBagConstraints(); 
        c.gridx = 0;
        c.gridy = 0;
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
        c.gridy = 1;
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
        c.gridy = 2;
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
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add( phoneTextBoxPanel, c);
        
        
        /////////////////////////
        
        // Head crime
        c = new GridBagConstraints(); 
        c.gridx = 0;
        c.gridy = 4;
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
        c.gridy = 5;
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
        c.gridy = 6;
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
        c.gridy = 7;
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
        c.gridy = 8;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(dateOfReportTextBoxPanel, c);
        
        
        /////////////////////////
       
        // Head comments
        c = new GridBagConstraints(); 
        c.gridx = 1;
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
        JPanel seeFilesTextBoxPanel = new JPanel(new FlowLayout());
        seeFilesTextBoxPanel.setBorder(outline); // To show the component border
        seeFilesTextBoxPanel.add(l_seeFiles);
        seeFilesTextBoxPanel.add(tf_seeFiles);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add( seeFilesTextBoxPanel, c);
        
        //Upload files
        c = new GridBagConstraints();
        JPanel uploadFilesTextBoxPanel = new JPanel(new FlowLayout());
        uploadFilesTextBoxPanel.setBorder(outline); // To show the component border
        uploadFilesTextBoxPanel.add(l_uploadFiles);
        uploadFilesTextBoxPanel.add(tf_uploadFiles);
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add( uploadFilesTextBoxPanel, c);
        
        //Status
        c = new GridBagConstraints();
        JPanel statusTextBoxPanel = new JPanel(new FlowLayout());
        statusTextBoxPanel.setBorder(outline); // To show the component border
        statusTextBoxPanel.add(l_status);
        statusTextBoxPanel.add(tf_status);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(statusTextBoxPanel, c);
        
        
     
      
        
        // Unit 
        c = new GridBagConstraints();
        JPanel unitTextBoxPanel = new JPanel(new FlowLayout());
        unitTextBoxPanel.setBorder(outline); // To show the component border
        unitTextBoxPanel.add(l_unit);
        unitTextBoxPanel.add(tf_unit);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add( unitTextBoxPanel, c);
        
        
        // Upload button
        c = new GridBagConstraints();
        JPanel uploadButtonPanel = new JPanel(new FlowLayout()); 
        uploadButtonPanel.setBorder(outline);
        uploadButtonPanel.setBackground(Color.CYAN);
        uploadButton.addActionListener(actionListener); 
        uploadButtonPanel.add(uploadButton);
        c.gridwidth = 1;
        c.gridx = 0;
        //c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(uploadButtonPanel, c);
        
        
        // Buttons
        c = new GridBagConstraints();
        JPanel buttonPanel = new JPanel(new FlowLayout()); 
        buttonPanel.setBorder(outline);
        buttonPanel.setBackground(Color.CYAN);
        okButton.addActionListener(actionListener); 
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);    
        c.gridwidth = 3;
        c.gridx = 0;
        //c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, c);
        
       
        
      }
    
    
    
    public void dependingOnRole(){
    	
    	 switch(mainFrame.getRole().role){
     	case Role.ENHETSCHEF:
     		
     		break;
     		
     	case Role.HANDLAGGARE:
     		
     		break;
     		
     	case Role.MILJOSAMORDNARE:
     		
     		break;
     		
     	default:
     		
     		break;
     	}
      	
    }

}
