package miljoboven.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DateCreator {

	
	
	   public static Date generateDate(String crimeDate){
	    	GregorianCalendar cal = null;
	    	try{
				Scanner scanner = new Scanner(crimeDate);
				scanner.useDelimiter("-");

				String year = null;
				String month = null;
				String date = null;

				 while (scanner.hasNext()) {
		                 year = scanner.next();
		                 month= scanner.next();
		                 date = scanner.next();   
		            }



					cal = new GregorianCalendar(new Integer(year).intValue(), new Integer(month).intValue(), new Integer(date).intValue());

				}catch(NumberFormatException nfe){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("FEL DATUM!");
					return null;
				}catch(IllegalStateException ise){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("Fel state");
					return null;

				}catch(NoSuchElementException nsee){
					//TODO 
					//Add dialouge for desplaying date error
					System.out.println("Inget element");
					return null;

				}
	    	return cal.getTime();
	    	
	    	
	    }
	
	

}
