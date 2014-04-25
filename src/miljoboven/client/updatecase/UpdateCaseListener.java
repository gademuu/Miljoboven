package miljoboven.client.updatecase;

import java.util.Date;

import miljoboven.client.updatecase.UpdateCaseListener;

public interface UpdateCaseListener {
	
	public void okButtonPressed(Date dateOfCrime,  String nameOfUnit, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter, String seeFiles);

}
