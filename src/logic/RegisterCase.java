package logic;

import java.util.Date;

import backend.Case;
import backend.CaseDAO;
import client.RegisterCaseListener;

public class RegisterCase implements RegisterCaseListener {
	
	private CaseDAO cd = new CaseDAO();
	
	public void okButtonPressed(String dateOfReport,String dateOfCrime,  String nameOfCoordinator, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter){
		
		Case c = new Case();
		   
	        c.setDateOfReport(new Date(dateOfReport)); 
	        c.setDateOfCrime(new Date(dateOfCrime)); 
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
