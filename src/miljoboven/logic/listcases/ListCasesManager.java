package miljoboven.logic.listcases;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.client.Role;
import miljoboven.client.listcases.ListCasesListener;
import miljoboven.client.listcases.ListCasesSetter;
import miljoboven.logic.login.LoginManager;
import miljoboven.logic.updatecase.UpdateCaseManager;


public class ListCasesManager implements ListCasesListener{
	
	private CaseDAO cd = new CaseDAO();
	private ListCasesSetter listCasesSetter = null;
	private UpdateCaseManager updateManager = null;
	private LoginManager loginManager = null;
	
	public ListCasesManager(UpdateCaseManager updateManager){
		
		this.updateManager = updateManager;
		
	}
	
	public void setListCasesSetter(ListCasesSetter listCasesSetter){
		this.listCasesSetter = listCasesSetter;
		
	}
	
	public void createList(){
		
		listCasesSetter.clearList();
		
		Case aCase = new Case();
		if(!loginManager.user.getRole().equals(Role.MILJOSAMORDNARE)) {
			aCase.setNameOfUnit(loginManager.user.getUnit());
		}
		
		Case[] cases = cd.find(aCase);
		
		for(Case c : cases){
			listCasesSetter.addCase(c.getId(),c.getDateOfCrime(), c.getNameOfUnit(),c.getTypeOfCrime(),c.getLocationOfCrime(),c.getComments(),
		    c.getNameOfReporter(),c.getAddressOfReporter(),c.getPhoneOfReporter(),c.getFileNames(),c.getStatus(),c.getDateOfReport(),c.getAssignedTo(),c.isNoInvestigation());
			
		}
		
		
	}
	
	public void setLoginManager(LoginManager loginManager){
		this.loginManager = loginManager;
		
	}
	
	public void caseSelected(String caseID){
		
		updateManager.caseSelected(caseID);
		
	}
	
	

	

}
