package miljoboven.logic.updatecase;

import java.util.Date;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;


public class UpdateCaseManager {

	private CaseDAO cd = new CaseDAO();
	//private UpdateCaseViewSetter registerCaseViewSetter;
	
	
	public UpdateCaseManager(){//RegisterCaseViewSetter registerCaseViewSetter){
		//this.registerCaseViewSetter = registerCaseViewSetter;
		//registerCaseViewSetter.setRegisterCaseListener(this);
		
	}
	
	public void okButtonPressed(Date dateOfCrime,  String nameOfUnit, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter, Date dateOfReport, String fileName, String status, boolean noInvestigation ){
		
		Case c = new Case();
		
	        c.setDateOfReport(dateOfReport); 
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
	
	public static void main(String[] args) {
		

	}

}
