package miljoboven.client.listcases;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import miljoboven.client.MainFrame;
import miljoboven.client.Role;

public class ListCasesView extends JPanel implements ListCasesSetter{
	
	
	  private ActionListener actionListener = null;
	  private JTable table = null;
	  private DefaultTableModel dataModel  = null;
	  private MainFrame mainFrame = null;
	
	    
	    // Text fields and labels
	    
	    
	   
	    JTextField tf_assignedTo = new JTextField(20);
	    
	 
	    JTextField tf_status = new JTextField(20);
	    
	    // End of fields and labels
	    
	    
	    // Buttons
	    private JButton searchButton = new JButton("S�k");  
	    private JButton registerButton = new JButton("Registrera");  
	    private JButton logoutButton = new JButton("Logga ut");  
	
	    
	    
	    public ListCasesView(MainFrame mainFrame,ActionListener actionListener) {
	      this.actionListener = actionListener;
	      this.mainFrame = mainFrame;
	    }
	    
	    public void initialize() {
	      
	      setBackground(Color.GRAY);
	      setSize(700,700);
	      Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas

	      
	      setLayout(new GridBagLayout());
	      GridBagConstraints c = null;
	    
	      
	      //Navigate button panel
	      c = new GridBagConstraints();
	      JPanel buttonPanel = new JPanel(new FlowLayout()); 
	      buttonPanel.setBorder(outline);
	      buttonPanel.setBackground(Color.GRAY);
	      logoutButton.addActionListener(actionListener); 
	      buttonPanel.add(logoutButton); 
	      c.gridwidth = 3;
	      c.gridx = 0;
	      c.gridy = 0;
	      //c.gridy = 2;
	      c.anchor = GridBagConstraints.PAGE_END;
	      c.fill = GridBagConstraints.HORIZONTAL;
	      add(buttonPanel, c);
	      
	      
	      //Table
	      c = new GridBagConstraints();
	      dataModel = new DefaultTableModel(0,5);
	      table = new JTable(dataModel);
	      JScrollPane scrollpane = new JScrollPane(table);
	      c.gridwidth = 3;
	      c.gridx = 0;
	      c.gridy = 1;
	      //c.anchor = GridBagConstraints.WEST;
	      //c.fill = GridBagConstraints.BOTH;
	      add(scrollpane, c);
	      
	      dependingOnRole();
	    }
	    
		

		@Override
		public void addCase(String id,Date crimeDate, String unit, String crimeType,
				String crimeLocation, String comments, String name,
				String address, String phone, String[] uploadFiles,
				String status, Date dateOfReport, String assign,
				boolean investigate) {
			
			Vector v = new Vector();
			v.add(id);
			v.add(unit);
			v.add(assign);
			v.add(status);
			
			dataModel.addRow(v);
			
			
		}
		

	    public void dependingOnRole(){
	    	 GridBagConstraints	c = new GridBagConstraints();
	    	 
	        switch(mainFrame.getRole().role){
	     	case Role.ENHETSCHEF:
	     	   //
	     	 
	  	      JPanel searchTextBoxPanel = new JPanel(new FlowLayout());
	  	      searchTextBoxPanel.add(tf_assignedTo);
	  	      searchTextBoxPanel.add(tf_status);
	  	      searchTextBoxPanel.add(searchButton);
	  	      searchButton.addActionListener(actionListener); 
	  	      c.gridx = 0;
	  	      c.gridy = 2;
	  	      c.anchor = GridBagConstraints.WEST;
	  	      //c.fill = GridBagConstraints.BOTH;
	  	      add(searchTextBoxPanel, c);
	  	      
	     		break;
	     		
	     	case Role.HANDLAGGARE:
	     		//Ingen extra knapp
	     		break;
	     		
	     	case Role.MILJOSAMORDNARE:
	     		 
		  	      registerButton.addActionListener(actionListener); 
		  	      c.gridx = 0;
		  	      c.gridy = 2;
		  	      c.anchor = GridBagConstraints.WEST;
		  	      //c.fill = GridBagConstraints.BOTH;
		  	      add(registerButton, c);
	     		break;
	     		
	     	default:
	     		
	     		
	     		
	     	}
	      	
	    }

	    
	
}