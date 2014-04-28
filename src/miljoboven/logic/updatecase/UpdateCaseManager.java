package miljoboven.logic.updatecase;

import java.util.Date;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.client.updatecase.UpdateCaseListener;


public class UpdateCaseManager implements UpdateCaseListener{

	private CaseDAO cd = new CaseDAO();
	//private UpdateCaseViewSetter registerCaseViewSetter;
	
	
	public UpdateCaseManager(){//RegisterCaseViewSetter registerCaseViewSetter){
		//this.registerCaseViewSetter = registerCaseViewSetter;
		//registerCaseViewSetter.setRegisterCaseListener(this);
		
	}
	
	public void okButtonPressed(Date crimeDate, String unit,  String crimeType,
			 String crimeLocation, String comments,  String name, String address, String phone
			, String uploadFiles, String status,Date dateOfReport, String assign, boolean investigate){
		
		Case c = new Case();
		
	        c.setDateOfReport(dateOfReport); 
	        c.setDateOfCrime(crimeDate); 
	        c.setNameOfUnit(unit); 
	        c.setTypeOfCrime(crimeType); 
	        c.setLocationOfCrime(crimeLocation); 
	        c.setComments(comments); 
	        c.setNameOfReporter(name); 
	        c.setAddressOfReporter(address); 
	        c.setPhoneOfReporter(phone); 
	        c.setAssignedTo(assign);
	        c.setStatus(status);
	        c.setNoInvestigation(investigate);
	  
	        Case storedCase = cd.create(c); 
		
	}
	
	public static void main(String[] args) {
		

	}



}
