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

public class ListCasesView extends JPanel implements ListCasesSetter{
	
	
	  private ActionListener actionListener = null;
	  private JTable table = null;
	  DefaultTableModel dataModel  = null;
	
	    
	    // Text fields and labels
	    
	    
	   
	    JTextField tf_assignedTo = new JTextField(20);
	    
	 
	    JTextField tf_status = new JTextField(20);
	    
	    // End of fields and labels
	    
	    
	    // Buttons
	    private JButton searchButton = new JButton("Sök");  
	
	    
	    
	    public ListCasesView(ActionListener actionListener) {
	      this.actionListener = actionListener;
	      
	      setBackground(Color.CYAN);
	      setSize(700,700);
	      Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas

	      
	      setLayout(new GridBagLayout());
	      GridBagConstraints c = null;
	    
	      
	      //Table
	      c = new GridBagConstraints();
	      dataModel = new DefaultTableModel(0,5);
	      table = new JTable(dataModel);
	      JScrollPane scrollpane = new JScrollPane(table);
	      
	     
	      
	      c.gridwidth = 3;
	      c.gridx = 0;
	      c.gridy = 0;
	      //c.anchor = GridBagConstraints.WEST;
	      //c.fill = GridBagConstraints.BOTH;
	      add(scrollpane, c);
	      
	      //
	      JPanel searchTextBoxPanel = new JPanel(new FlowLayout());
	      searchTextBoxPanel.setBorder(outline); // To show the component border
	      searchTextBoxPanel.add(tf_assignedTo);
	      searchTextBoxPanel.add(tf_status);
	      searchTextBoxPanel.add(searchButton);
	      searchButton.addActionListener(actionListener); 
	      c.gridx = 0;
	      c.gridy = 1;
	      c.anchor = GridBagConstraints.WEST;
	      //c.fill = GridBagConstraints.BOTH;
	      add(searchTextBoxPanel, c);
	      
	      
	      

	     
	      
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

	    
	
}
