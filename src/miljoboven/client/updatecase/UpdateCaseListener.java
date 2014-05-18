package miljoboven.client.updatecase;

import java.util.Date;

import miljoboven.client.updatecase.UpdateCaseListener;

public interface UpdateCaseListener {
	
	public void okButtonPressed(String caseId, Date crimeDate, String unit,  String crimeType,
			 String crimeLocation, String comments,  String name, String address, String phone
			, String uploadFiles, String status,Date dateOfReport, String assign, boolean investigate);
	
	public void caseSelected(String caseId);
	
	public void addFile(String fileName);
}
