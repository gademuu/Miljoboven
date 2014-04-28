package miljoboven.client.listcases;

import java.util.Date;

public interface ListCasesSetter {

	public void addCase(String id, Date crimeDate, String unit, String crimeType,
			String crimeLocation, String comments, String name,
			String address, String phone, String[] uploadFiles,
			String status, Date dateOfReport, String assign,
			boolean investigate);
	
}
