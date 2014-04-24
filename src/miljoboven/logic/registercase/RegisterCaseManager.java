package miljoboven.logic.registercase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.client.registercase.RegisterCaseListener;
import miljoboven.client.registercase.RegisterCaseViewSetter;

public class RegisterCaseManager implements RegisterCaseListener {
	
	private CaseDAO cd = new CaseDAO();
	private RegisterCaseViewSetter registerCaseViewSetter;
	
	
	public RegisterCaseManager(){//RegisterCaseViewSetter registerCaseViewSetter){
		//this.registerCaseViewSetter = registerCaseViewSetter;
		//registerCaseViewSetter.setRegisterCaseListener(this);
		
	}
	
	public void okButtonPressed(Date dateOfCrime,  String nameOfUnit, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter){
		
		Case c = new Case();
		
	        c.setDateOfReport(new Date()); 
	        c.setDateOfCrime(dateOfCrime); 
	        c.setNameOfUnit(nameOfUnit); 
	        c.setTypeOfCrime(typeOfCrime); 
	        c.setLocationOfCrime(locationOfCrime); 
	        c.setComments(comments); 
	        c.setNameOfReporter(nameOfReporter); 
	        c.setAddressOfReporter( addressOfReporter); 
	        c.setPhoneOfReporter(phoneOfReporter); 
	  
	        Case storedCase = cd.create(c); 
		
	}
	
	public static void main(String[] args){
		
		
		/*Scanner scanner = new Scanner("2014-04-23");
		scanner.useDelimiter("-");
		 while (scanner.hasNext()) {
                String year = scanner.next();
                String month= scanner.next();
                String date = scanner.next();
               System.out.println(year + " "  + month + " " + date);
            }*/
	}
	
}
	
	


