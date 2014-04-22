package client;

import java.util.Date;

public interface RegisterCaseListener {
	
	public void okButtonPressed(String dateOfReport,String dateOfCrime,  String nameOfCoordinator, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter);

}
