package miljoboven.logic.listcases;

import miljoboven.backend.cases.Case;
import miljoboven.backend.cases.CaseDAO;
import miljoboven.client.listcases.ListCasesListener;
import miljoboven.client.listcases.ListCasesSetter;
import miljoboven.logic.updatecase.UpdateCaseManager;


public class ListCasesManager implements ListCasesListener{
	
	private CaseDAO cd = new CaseDAO();
	private ListCasesSetter listCasesSetter = null;
	private UpdateCaseManager updateManager = null;
	
	public ListCasesManager(UpdateCaseManager updateManager){
		
		this.updateManager = updateManager;
	}
	
	public void setListCasesSetter(ListCasesSetter listCasesSetter){
		this.listCasesSetter = listCasesSetter;
		
	}
	
	public void createList(){
		
		listCasesSetter.clearList();
		
		Case[] cases = cd.find(new Case());
		
		for(Case c : cases){
			listCasesSetter.addCase(c.getId(),c.getDateOfCrime(), c.getNameOfUnit(),c.getTypeOfCrime(),c.getLocationOfCrime(),c.getComments(),
		    c.getNameOfReporter(),c.getAddressOfReporter(),c.getPhoneOfReporter(),c.getFileNames(),c.getStatus(),c.getDateOfReport(),c.getAssignedTo(),c.isNoInvestigation());
			
		}
		
		
	}
	
	public void caseSelected(String caseID){
		
		updateManager.caseSelected(caseID);
		
	}
	
	

	

}
