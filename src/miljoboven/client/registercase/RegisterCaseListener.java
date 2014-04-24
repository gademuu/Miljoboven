package miljoboven.client.registercase;

import java.util.Date;

public interface RegisterCaseListener {
	
	public void okButtonPressed(Date dateOfCrime,  String nameOfUnit, String typeOfCrime, String locationOfCrime, 
			String comments, String nameOfReporter, String addressOfReporter, String phoneOfReporter);

}
