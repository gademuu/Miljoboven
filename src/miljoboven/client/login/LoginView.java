package miljoboven.client.login;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import miljoboven.client.MainFrame;

public class LoginView extends JPanel{
	
	private ActionListener actionListener = null;
	  private MainFrame mainFrame = null;
	
	// Text fields and labels
	
	
	 private JLabel l_head = new JLabel("Logga in");
	
	
    private JLabel l_name = new JLabel("Användarnamn");
    JTextField tf_name = new JTextField(20);

    
    private JLabel l_password = new JLabel("Lösenord");
    JTextField tf_password = new JTextField(20);
    // End of text fields and labels
    
    // Buttons
    private JButton cancelButton = new JButton("Avsluta");  
    private JButton okButton = new JButton("Logga in"); 
	// End of buttons
    
    public LoginView(ActionListener actionListener) {
        this.actionListener = actionListener;
        
        setBackground(Color.CYAN);
        setSize(700,700);
        Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas

        
        setLayout(new GridBagLayout());
        GridBagConstraints c = null;
        
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        add(l_head, c);
        
        
        //
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
        JPanel passwordTextBoxPanel = new JPanel(new FlowLayout());
        passwordTextBoxPanel.setBorder(outline); // To show the component border
        passwordTextBoxPanel.add(l_password);
        passwordTextBoxPanel.add(tf_password);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        add(passwordTextBoxPanel, c);
        
        
        
        // Buttons
        c = new GridBagConstraints();
        JPanel buttonPanel = new JPanel(new FlowLayout()); 
        buttonPanel.setBorder(outline);
        buttonPanel.setBackground(Color.CYAN);
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
