package miljoboven.logic.updatecase;

import java.util.Date;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.backend.user.User;
import miljoboven.backend.user.UserDAO;
import miljoboven.client.Role;
import miljoboven.client.Status;
import miljoboven.client.updatecase.UpdateCaseListener;
import miljoboven.client.updatecase.UpdateCaseViewSetter;


public class UpdateCaseManager implements UpdateCaseListener{

	private CaseDAO cd = new CaseDAO();
	private UpdateCaseViewSetter setter;
	private Case aCase = null;
	private UserDAO ud = new UserDAO();
	
	public UpdateCaseManager() {
		
	}
	
	
	
	public void okButtonPressed(String id, Date crimeDate, String unit,  String crimeType,
			 String crimeLocation, String comments,  String name, String address, String phone
			, String[] fileNames, String status,Date dateOfReport, String assign, boolean investigate){
		
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
	        c.setFileNames(fileNames);
	        
	        System.out.println(" INVESTIGATE " + investigate);
	        
	        if(investigate){
	        	
	        		c.setStatus(Status.SKA_EJ_UTREDAS);
	        		
	        	
	        	
	        }
	  
	        Case storedCase = cd.update(c); 
		
	}
	
	

	@Override
	public void caseSelected(String caseId) {
		System.out.println("CASESELECTED" + caseId);
		
		User[] handlaggare = ud.find(new User(null,null,Role.HANDLAGGARE,null));
		String[] users = new String[handlaggare.length];
		for(int i = 0; i<handlaggare.length;i++){
			
			users[i] = handlaggare[i].getName();
		}
		
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
						theCase.isNoInvestigation(),
						users);
		
		aCase = theCase;
		
		
		
	}
	
	public void setUpdateCaseViewSetter(UpdateCaseViewSetter setter) {
		this.setter = setter;
	}
	
	public void addFile(String fileName){
		
		aCase.addFile(fileName);
		
	}
	
	
	



}
