package client.registercase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.registercase.RegisterCaseManager;

import java.awt.Font;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

public class RegisterCaseView extends JFrame implements RegisterCaseViewSetter{

	private JPanel reportPane;
	private RegisterCaseListener registerCaseListener;
	private JTextField tf_typAvBrott;
	private JTextField tf_datumForBrott;
	private JTextField tf_handlaggare;
	private JTextField tf_platsForBrott;
	private JTextField tf_kommentarer;
	private JTextField tf_namn;
	private JTextField tf_adress;
	private JTextField tf_telefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					RegisterCaseView frame = new RegisterCaseView();
					RegisterCaseManager registerCaseManager = new RegisterCaseManager(frame);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setRegisterCaseListener(RegisterCaseListener registerCaseListener){
		this.registerCaseListener = registerCaseListener;	
	}
	
	

	/**
	 * Create the frame.
	 */
	public RegisterCaseView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		reportPane = new JPanel();
		reportPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(reportPane);
		reportPane.setLayout(null);
		
		JButton btnOkej = new JButton("Okej");
		btnOkej.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				GregorianCalendar cal = null;
				try{
				Scanner scanner = new Scanner(tf_datumForBrott.getText());
				scanner.useDelimiter("-");
				
				String year = null;
				String month = null;
				String date = null;
				
				 while (scanner.hasNext()) {
		                 year = scanner.next();
		                 month= scanner.next();
		                 date = scanner.next();   
		            }
				 
				
				
					cal = new GregorianCalendar(new Integer(year).intValue(), new Integer(month).intValue(), new Integer(date).intValue());
					
				}catch(NumberFormatException nfe){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("FEL DATUM!");
					return;
				}catch(IllegalStateException ise){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("Fel state");
					return;
					
				}catch(NoSuchElementException nsee){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("Inget element");
					return;
					
				}
				
				
				registerCaseListener.okButtonPressed(cal.getTime(), tf_handlaggare.getText(),
						tf_typAvBrott.getText(), tf_platsForBrott.getText(), tf_kommentarer.getText(), tf_namn.getText(), 
						tf_adress.getText(), tf_telefon.getText() );
				
				
				
				
				
			}
		});
		btnOkej.setBounds(335, 228, 89, 23);
		reportPane.add(btnOkej);
		
		JLabel lblTypAvBrott = new JLabel("Typ av brott");
		lblTypAvBrott.setBounds(16, 116, 70, 14);
		reportPane.add(lblTypAvBrott);
		
		tf_typAvBrott = new JTextField();
		tf_typAvBrott.setBounds(115, 116, 86, 20);
		reportPane.add(tf_typAvBrott);
		tf_typAvBrott.setColumns(10);
		
		JLabel lblDatumFrBrott = new JLabel("Datum f\u00F6r brott");
		lblDatumFrBrott.setBounds(16, 54, 89, 14);
		reportPane.add(lblDatumFrBrott);
		
		tf_datumForBrott = new JTextField();
		tf_datumForBrott.setText("\u00E5\u00E5-mm-dd");
		tf_datumForBrott.setBounds(115, 54, 86, 20);
		reportPane.add(tf_datumForBrott);
		tf_datumForBrott.setColumns(10);
		
		JLabel lblHandlggare = new JLabel("Handl\u00E4ggare");
		lblHandlggare.setBounds(16, 82, 89, 14);
		reportPane.add(lblHandlggare);
		
		tf_handlaggare = new JTextField();
		tf_handlaggare.setBounds(115, 85, 86, 20);
		reportPane.add(tf_handlaggare);
		tf_handlaggare.setColumns(10);
		
		JLabel lblPlatsFrBrott = new JLabel("Plats f\u00F6r brott");
		lblPlatsFrBrott.setBounds(16, 150, 70, 14);
		reportPane.add(lblPlatsFrBrott);
		
		tf_platsForBrott = new JTextField();
		tf_platsForBrott.setBounds(115, 147, 86, 20);
		reportPane.add(tf_platsForBrott);
		tf_platsForBrott.setColumns(10);
		
		JLabel lblRapport = new JLabel("Rapport");
		lblRapport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRapport.setBounds(180, 0, 97, 43);
		reportPane.add(lblRapport);
		
		JLabel lblNewLabel = new JLabel("\u00D6vriga kommentarer");
		lblNewLabel.setBounds(16, 175, 127, 14);
		reportPane.add(lblNewLabel);
		
		tf_kommentarer = new JTextField();
		tf_kommentarer.setBounds(16, 189, 294, 62);
		reportPane.add(tf_kommentarer);
		tf_kommentarer.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Namn ");
		lblNewLabel_1.setBounds(211, 57, 92, 14);
		reportPane.add(lblNewLabel_1);
		
		tf_namn = new JTextField();
		tf_namn.setBounds(281, 51, 86, 20);
		reportPane.add(tf_namn);
		tf_namn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adress ");
		lblNewLabel_2.setBounds(211, 83, 108, 14);
		reportPane.add(lblNewLabel_2);
		
		tf_adress = new JTextField();
		tf_adress.setBounds(281, 79, 86, 20);
		reportPane.add(tf_adress);
		tf_adress.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefon ");
		lblNewLabel_3.setBounds(211, 114, 46, 14);
		reportPane.add(lblNewLabel_3);
		
		tf_telefon = new JTextField();
		tf_telefon.setBounds(281, 113, 86, 20);
		reportPane.add(tf_telefon);
		tf_telefon.setColumns(10);
		
		JButton btnNewButton = new JButton("Avbryt");
		btnNewButton.setBounds(335, 194, 89, 23);
		reportPane.add(btnNewButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tf_namn, lblHandlggare, lblPlatsFrBrott, lblRapport, lblNewLabel, lblNewLabel_1, lblNewLabel_3, btnNewButton, tf_adress, tf_telefon, tf_kommentarer, tf_typAvBrott, tf_platsForBrott, tf_handlaggare, btnOkej, lblTypAvBrott, lblDatumFrBrott, tf_datumForBrott, lblNewLabel_2, reportPane}));
	}
}
