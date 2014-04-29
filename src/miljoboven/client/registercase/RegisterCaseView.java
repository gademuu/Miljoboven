package miljoboven.client.registercase;

import java.awt.*; 
import java.awt.event.*; 

import javax.swing.*; 
import javax.swing.border.Border;

import miljoboven.client.MainFrame;

public class RegisterCaseView extends JPanel {
    
    private ActionListener actionListener = null;
    private MainFrame mainFrame = null;
    // Text fields and labels
    
    private JLabel l_headReporter = new JLabel("Uppgifter om anmälaren");
    
    private JLabel l_name = new JLabel("Namn");
    JTextField tf_name = new JTextField(20);
    
    private JLabel l_address = new JLabel("Adress");
    JTextField tf_address = new JTextField(20);
    
    private JLabel l_phone = new JLabel("Telefon");
    JTextField tf_phone = new JTextField(20);
    
    private JLabel l_headCrime = new JLabel("Uppgifter om brottet");
    
    private JLabel l_crimeDate = new JLabel("Datum for brott");
    JTextField tf_crimeDate = new JTextField("ÅÅÅÅ-MM-DD");
    
    private JLabel l_crimeLocation = new JLabel("Plats för brott");
    JTextField tf_crimeLocation = new JTextField(20);
    
    private JLabel l_crimeType = new JLabel("Typ av brott");
    JTextField tf_crimeType = new JTextField(20);
    
    
    private JLabel l_headComments = new JLabel("Övriga uppgifter");
    
    JTextArea ta_comments = new JTextArea(10,20);
    
    private JLabel l_unit = new JLabel("Välj enhet för utredning");
    JTextField tf_unit = new JTextField(" ",20);
    
    // End of fields and labels
    
    
    // Buttons
    private JButton okButton = new JButton("OK");  
    private JButton cancelButton = new JButton("Avbryt"); 
    
    
    public RegisterCaseView(ActionListener actionListener) {
      this.actionListener = actionListener;
      
      setBackground(Color.CYAN);
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

      
      /*// Unit 
      c = new GridBagConstraints();
      JPanel unitTextBoxPanel = new JPanel(new FlowLayout());
      unitTextBoxPanel.setBorder(outline); // To show the component border
      unitTextBoxPanel.add(l_unit);
      unitTextBoxPanel.add(tf_unit);
      c.gridx = 1;
      c.gridy = 2;
      c.anchor = GridBagConstraints.WEST;
      //c.fill = GridBagConstraints.BOTH;
      add( unitTextBoxPanel, c);*/
      
      
      // Buttons
      c = new GridBagConstraints();
      JPanel buttonPanel = new JPanel(new FlowLayout()); 
      buttonPanel.setBorder(outline);
      buttonPanel.setBackground(Color.ORANGE);
      okButton.addActionListener(actionListener); 
      cancelButton.addActionListener(actionListener); 
      buttonPanel.add(okButton);
      buttonPanel.add(cancelButton);    
      c.gridwidth = 3;
      c.gridx = 0;
      //c.gridy = 2;
      c.anchor = GridBagConstraints.PAGE_END;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(buttonPanel, c);
      
     
      
    }
    
    
}
