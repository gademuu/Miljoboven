package miljoboven.client.updatecase;

import java.util.Date;


public interface UpdateCaseViewSetter {
	
	public void setUpdateCaseListener(UpdateCaseListener updateCaseListener);
	
	public void showCase(String id, Date crimeDate, String unit, String crimeType,
			String crimeLocation, String comments, String name,
			String address, String phone, String[] uploadFiles,
			String status, Date dateOfReport, String assign,
			boolean investigate);
	

}
