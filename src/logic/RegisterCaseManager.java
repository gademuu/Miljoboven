package logic;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import backend.Case;
import backend.CaseDAO;
import client.RegisterCaseListener;
import client.RegisterCaseViewSetter;

public class RegisterCaseManager implements RegisterCaseListener {
	
	private CaseDAO cd = new CaseDAO();
	private RegisterCaseViewSetter registerCaseViewSetter;
	
	
	
	public RegisterCaseManager(RegisterCaseViewSetter registerCaseViewSetter){
		this.registerCaseViewSetter = registerCaseViewSetter;
		registerCaseViewSetter.setRegisterCaseListener(this);
		
	}
	
	public void okButtonPressed(String dateOfReport,String dateOfCrime,  String nameOfCoordinator, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter){
		
		Case c = new Case();
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(2014, 04, 22);  
	        c.setDateOfReport(new Date()); 
	        c.setDateOfCrime(gc.getTime()); 
	        c.setNameOfCoordinator(nameOfCoordinator); 
	        c.setTypeOfCrime(typeOfCrime); 
	        c.setLocationOfCrime(locationOfCrime); 
	        c.setComments(comments); 
	        c.setNameOfReporter(nameOfReporter); 
	        c.setAddressOfReporter( addressOfReporter); 
	        c.setPhoneOfReporter(phoneOfReporter); 
	  
	        Case storedCase = cd.create(c); 
		
	}
	
	
	
	

}
