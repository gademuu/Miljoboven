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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import miljoboven.client.MainFrame;
import miljoboven.client.Role;

public class ListCasesView extends JPanel implements ListCasesSetter{//, ListSelectionListener {
	
	
	  private ListCasesViewActionHandler actionListener = null;
	  private JTable table = null;
	  DefaultTableModel dataModel  = null;
	  private MainFrame mainFrame = null;
	  TableRowSorter<TableModel> sorter = null;
	
	    
	    // Text fields and labels
	    
	    
	   
	    JTextField tf_assignedTo = new JTextField(20);
	    
	 
	    JTextField tf_status = new JTextField(20);
	    
	    // End of fields and labels
	    
	    
	    // Buttons
	    private JButton searchButton = new JButton("Sök");  
	    private JButton registerButton = new JButton("Registrera");  
	    private JButton logoutButton = new JButton("Logga ut");  
	    
	
	    
	    
	    public ListCasesView(MainFrame mainFrame,ListCasesViewActionHandler actionListener) {
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
	      clearList();
	      table = new JTable(dataModel);
	      DefaultListSelectionModel sModel = new DefaultListSelectionModel();
	      //sModel.addListSelectionListener(this);
	      table.addMouseListener(actionListener);
	      table.setSelectionModel(sModel);
	      //table.setAutoCreateRowSorter(true);
	      
	      sorter = new TableRowSorter<TableModel>(table.getModel());
	      table.setRowSorter(sorter);
	      
	   
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
		public void clearList() {
			String[][] newVector = new String[0][4];
			String[] colNames = new String[]{"ID", "Enhet", "Handlaggare", "Status"};
			dataModel.setDataVector(newVector, colNames);
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
	  	      //searchTextBoxPanel.add(tf_status);
	  	      searchTextBoxPanel.add(searchButton);
	  	      searchButton.addActionListener(actionListener); 
	  	      c.gridx = 1;
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

		/*@Override
		public void valueChanged(ListSelectionEvent e) {
			
			int row = e.getFirstIndex();
			String caseId= (String)dataModel.getValueAt(row, 0);
			actionListener.caseSelected(caseId);
		}*/

	    
	
}
