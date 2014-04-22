package client;

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

import logic.RegisterCaseManager;

public class RegisterCaseView extends JFrame implements RegisterCaseViewSetter{

	private JPanel contentPane;
	private JTextField tf_rapportDatum;
	private RegisterCaseListener registerCaseListener;
	private JTextField tf_typAvBrott;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRaportdatum = new JLabel("Rapportdatum");
		lblRaportdatum.setBounds(10, 11, 70, 14);
		contentPane.add(lblRaportdatum);
		
		tf_rapportDatum = new JTextField();
		tf_rapportDatum.setBounds(87, 8, 76, 20);
		contentPane.add(tf_rapportDatum);
		tf_rapportDatum.setColumns(10);
		
		JButton btnOkej = new JButton("Okej");
		btnOkej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerCaseListener.okButtonPressed("", "", "",tf_typAvBrott.getText(), "", "", "", "", "");
				
			}
		});
		btnOkej.setBounds(163, 201, 89, 23);
		contentPane.add(btnOkej);
		
		JLabel lblTypAvBrott = new JLabel("Typ av brott");
		lblTypAvBrott.setBounds(10, 42, 70, 14);
		contentPane.add(lblTypAvBrott);
		
		tf_typAvBrott = new JTextField();
		tf_typAvBrott.setBounds(87, 39, 86, 20);
		contentPane.add(tf_typAvBrott);
		tf_typAvBrott.setColumns(10);
	}
}
