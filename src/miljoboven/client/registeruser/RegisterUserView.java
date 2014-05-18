package miljoboven.client.registeruser;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import miljoboven.client.Role;
import miljoboven.client.Unit;

public class RegisterUserView extends JPanel{

private ActionListener actionListener = null;
	
	// Text fields and labels
	
	
	 private JLabel l_head = new JLabel("Registrera användare");
	
	
    private JLabel l_name = new JLabel("Användarnamn");
    JTextField tf_name = new JTextField(20);

    
    private JLabel l_password = new JLabel("Lösenord           ");
    JTextField tf_password = new JTextField(20);
    
    private JLabel l_role = new JLabel("Behörighet        ");
    JComboBox cb_role = new JComboBox(new String[]{Role.ENHETSCHEF,Role.HANDLAGGARE,Role.MILJOSAMORDNARE});
    
    private JLabel l_unit = new JLabel("Enhet                  ");
    JComboBox cb_unit  = new   JComboBox(new String[]{Unit.AVFALL,Unit.AVLOPPSHANTERING,Unit.KLIMAT,Unit.MILJO,Unit.NATUR});
    // End of text fields and labels
    
    // Buttons
    private JButton cancelButton = new JButton("Avsluta");  
    private JButton okButton = new JButton("Spara"); 
   
	// End of buttons
    
    public RegisterUserView(ActionListener actionListener) {
        this.actionListener = actionListener;
        
        setBackground(Color.GRAY);
        setSize(700,700);
        Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas

        
        setLayout(new GridBagLayout());
        GridBagConstraints c = null;
        
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        add(l_head, c);
        
        
        //Namn
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
        
        //Password
        c = new GridBagConstraints();
        JPanel passwordTextBoxPanel = new JPanel(new FlowLayout());
        passwordTextBoxPanel.setBorder(outline); // To show the component border
        passwordTextBoxPanel.add(l_password);
        passwordTextBoxPanel.add(tf_password);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(passwordTextBoxPanel, c);
        
      //Role
        c = new GridBagConstraints();
        JPanel roleTextBoxPanel = new JPanel(new FlowLayout());
        roleTextBoxPanel.setBorder(outline); // To show the component border
        roleTextBoxPanel.add(l_role);
        roleTextBoxPanel.add(cb_role);
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(roleTextBoxPanel, c);
        
      //Unit
        c = new GridBagConstraints();
        JPanel unitTextBoxPanel = new JPanel(new FlowLayout());
        unitTextBoxPanel.setBorder(outline); // To show the component border
        unitTextBoxPanel.add(l_unit);
        unitTextBoxPanel.add(cb_unit);
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(unitTextBoxPanel, c);
        
        
        
        
        // Buttons
        c = new GridBagConstraints();
        JPanel buttonPanel = new JPanel(new FlowLayout()); 
       // buttonPanel.setBorder(outline);
        buttonPanel.setBackground(Color.GRAY);
        okButton.addActionListener(actionListener); 
        cancelButton.addActionListener(actionListener);
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);    
        c.gridwidth = 2;
        c.gridx = 0;
        //c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, c);
    }


}
