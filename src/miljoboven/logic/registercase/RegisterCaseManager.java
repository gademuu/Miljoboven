package miljoboven.logic.registercase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.client.Status;
import miljoboven.client.listcases.ListCasesSetter;
import miljoboven.client.registercase.RegisterCaseListener;
import miljoboven.client.registercase.RegisterCaseViewSetter;

public class RegisterCaseManager implements RegisterCaseListener {
	
	private CaseDAO cd = new CaseDAO();
	private ListCasesSetter setter;
	
	
	public RegisterCaseManager(){
		
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
	        // Not part of register:
	        c.setFileNames(new String[0]);
	        c.setStatus(Status.INRAPPORTERAD);
	        c.setAssignedTo("");
	        c.setNoInvestigation(false);
	  
	        Case storedCase = cd.create(c); 
	        
	        
	        
	        setter.addCase(storedCase.getId(), 
	        		storedCase.getDateOfCrime(), 
	        		storedCase.getNameOfUnit(), 
	        		storedCase.getTypeOfCrime(),
	        		storedCase.getLocationOfCrime(),
	        		storedCase.getComments(),
	        		storedCase.getNameOfReporter(),
	        		storedCase.getAddressOfReporter(),
	        		storedCase.getPhoneOfReporter(),
	        		storedCase.getFileNames(),
	        		storedCase.getStatus(),
	        		storedCase.getDateOfReport(),
	        		storedCase.getAssignedTo(),
	        		storedCase.isNoInvestigation());
		
	}
	
	public void setListCasesSetter(ListCasesSetter setter) {
		if(setter == null) {
	        System.out.println("Setter is null!");
	        System.exit(1);
		}
		this.setter = setter;
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
	
	


