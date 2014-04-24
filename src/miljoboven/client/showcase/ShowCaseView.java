package miljoboven.client.showcase;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class ShowCaseView extends JPanel { 
    
 public ShowCaseView(ActionListener actionListener) { 
        
    setBackground(Color.YELLOW); 
    setSize(300,300); 
    

    JPanel buttonPanel = new JPanel(new FlowLayout()); 
      
    JButton okButton = new JButton("OK"); 
      

    buttonPanel.add(okButton); 
    buttonPanel.add(new JButton("Cancel"));     

      

    add("Button", buttonPanel); 
      
      
    okButton.addActionListener(actionListener);  
      
  } 
    
} 
