package miljoboven.logic.updatecase;

import java.util.Date;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.client.updatecase.UpdateCaseListener;
import miljoboven.client.updatecase.UpdateCaseViewSetter;


public class UpdateCaseManager implements UpdateCaseListener{

	private CaseDAO cd = new CaseDAO();
	private UpdateCaseViewSetter setter;
	
	
	public UpdateCaseManager() {
		
	}
	
	public void okButtonPressed(String id, Date crimeDate, String unit,  String crimeType,
			 String crimeLocation, String comments,  String name, String address, String phone
			, String uploadFiles, String status,Date dateOfReport, String assign, boolean investigate){
		
		Case c = new Case();
		
			c.setId(id);
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
	  
	        Case storedCase = cd.update(c); 
		
	}
	
	

	@Override
	public void caseSelected(String caseId) {
		System.out.println("CASESELECTED" + caseId);
		Case c = new Case();
		c.setId(caseId);
		Case theCase = cd.read(c);
		setter.showCase(theCase.getId(), 
						theCase.getDateOfCrime(), 
						theCase.getNameOfUnit(), 
						theCase.getTypeOfCrime(),
						theCase.getLocationOfCrime(), 
						theCase.getComments(),
						theCase.getNameOfReporter(),
						theCase.getAddressOfReporter(),
						theCase.getPhoneOfReporter(),
						theCase.getFileNames(),
						theCase.getStatus(),
						theCase.getDateOfReport(),
						theCase.getAssignedTo(),
						theCase.isNoInvestigation());
		
	}
	
	public void setUpdateCaseViewSetter(UpdateCaseViewSetter setter) {
		this.setter = setter;
	}
	
	
	



}
