package miljoboven.backend.cases; 
  
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar; 
import java.util.Date; 
import java.util.Locale;
import java.util.Properties; 

import miljoboven.backend.BaseDAO;
import miljoboven.backend.conf.ServerConf;
import miljoboven.backend.conf.ServerConfDAO;
import miljoboven.backend.user.User;

  
/** 
 * 
 * @author herman 
 */
public class CaseDAO extends BaseDAO { 
  
    DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("sv","SE"));
    private ServerConfDAO aServerConfDAO = new ServerConfDAO();
  
    private static final String DATEOFREPORT = "dateOfReport"; 
    private static final String DATEOFCRIME = "dateOfCrime"; 
    private static final String NAMEOFUNIT = "nameOfUnit"; 
    private static final String TYPEOFCRIME = "typeOfCrime"; 
    private static final String ID = "id"; 
    private static final String LOCATIONOFCRIME = "locationOfCrime"; 
    private static final String COMMENTS = "comments"; 
    private static final String NAMEOFREPORTER = "nameOfReporter"; 
    private static final String ADDRESSOFREPORTER = "addressOfReporter"; 
    private static final String PHONEOFREPORTER = "phoneOfReporter";
    private static final String FILENAMES = "fileNames";
    private static final String NOINVESTIGATION = "noInvestigation";
    private static final String STATUS = "status";
    private static final String ASSIGNED_TO = "assignedTo";
  
    private static final String CASE_FILE_PREFIX = "case_"; 
    private static final String CASE_FILE_SUFFIX = ".properties"; 
  
    private static final String HYPHEN = "-"; 
    private static final String CRIME_TYPE_ID = "35"; 
  
    public Case create(Case aCase) { 
  
        String id = generateCaseId(); 
        String caseFile = CASE_FILE_PREFIX + id + CASE_FILE_SUFFIX; 
        
  
        Properties prop = new Properties(); 
        prop = load(caseFile); 
        prop.setProperty(DATEOFREPORT, date.format(aCase.getDateOfReport())); 
        prop.setProperty(DATEOFCRIME, date.format(aCase.getDateOfCrime())); 
        prop.setProperty(NAMEOFUNIT, aCase.getNameOfUnit()); 
        prop.setProperty(TYPEOFCRIME, aCase.getTypeOfCrime()); 
        prop.setProperty(ID, id); 
        prop.setProperty(LOCATIONOFCRIME, aCase.getLocationOfCrime()); 
        prop.setProperty(COMMENTS, aCase.getComments()); 
        prop.setProperty(NAMEOFREPORTER, aCase.getNameOfReporter()); 
        prop.setProperty(ADDRESSOFREPORTER, aCase.getAddressOfReporter()); 
        prop.setProperty(PHONEOFREPORTER, aCase.getPhoneOfReporter());
        prop.setProperty(FILENAMES, aCase.getFileNamesAsString());
        prop.setProperty(NOINVESTIGATION, aCase.getNoInvestigationAsString());
        prop.setProperty(STATUS, aCase.getStatus());
        prop.setProperty(ASSIGNED_TO, aCase.getAssignedTo());
  
        store(caseFile, prop, true); 
  
        aCase.setId(id); 
  
        return aCase; 
    } 
    
    public Case update(Case aCase) { 
    	
    	System.out.println("UPDATE: " + aCase.toString());
    	  
        String id = aCase.getId();
        String caseFile = CASE_FILE_PREFIX + id + CASE_FILE_SUFFIX; 
  
        Properties prop = new Properties(); 
        prop = load(caseFile); 
        
      
        prop.setProperty(DATEOFREPORT, date.format(aCase.getDateOfReport())); 
        prop.setProperty(DATEOFCRIME, date.format(aCase.getDateOfCrime())); 
     
        prop.setProperty(NAMEOFUNIT, aCase.getNameOfUnit()); 
        prop.setProperty(TYPEOFCRIME, aCase.getTypeOfCrime()); 
        prop.setProperty(ID, id); 
        prop.setProperty(LOCATIONOFCRIME, aCase.getLocationOfCrime()); 
        prop.setProperty(COMMENTS, aCase.getComments()); 
        prop.setProperty(NAMEOFREPORTER, aCase.getNameOfReporter()); 
        prop.setProperty(ADDRESSOFREPORTER, aCase.getAddressOfReporter()); 
        prop.setProperty(PHONEOFREPORTER, aCase.getPhoneOfReporter());
        prop.setProperty(FILENAMES, aCase.getFileNamesAsString());
        prop.setProperty(NOINVESTIGATION, aCase.getNoInvestigationAsString());
        prop.setProperty(STATUS, aCase.getStatus());
        prop.setProperty(ASSIGNED_TO, aCase.getAssignedTo());
  
        store(caseFile, prop, true); 
  
       
        return aCase; 
    } 
  
    private String generateCaseId() { 
        String newLastCaseID = "";
        ServerConf conf = aServerConfDAO.read();  
        int caseID = new Integer(conf.getLastCaseID()).intValue();
        caseID++;
        conf.setLastCaseID("" + caseID);
        aServerConfDAO.update(conf);
        
        if( caseID < 10 ){
        	
        	newLastCaseID = "00" + caseID;
        }else if(caseID < 100){
        	
        	newLastCaseID = "0" + caseID;
        }else{
        	
        	newLastCaseID = "" + caseID;
        }
        
        
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        return year + HYPHEN + CRIME_TYPE_ID + HYPHEN  + newLastCaseID; 
    } 
    
    
	public Case read(Case aCase){
		
		String id = aCase.getId();
		String caseFile = CASE_FILE_PREFIX + id + CASE_FILE_SUFFIX;
		Case theCase = null;
	
	    Properties prop = new Properties();
	     
	     
	     prop = load(caseFile);
	    
	     theCase= new Case();
	     
	     try {
			theCase.setDateOfReport(date.parse(prop.getProperty(DATEOFREPORT)));
			theCase.setDateOfCrime(date.parse(prop.getProperty(DATEOFCRIME))); 
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	     
	   
	     theCase.setNameOfUnit(prop.getProperty(NAMEOFUNIT));
	     theCase.setTypeOfCrime(prop.getProperty(TYPEOFCRIME));
	     theCase.setId(prop.getProperty(ID));
	     theCase.setLocationOfCrime(prop.getProperty(LOCATIONOFCRIME));
	     theCase.setComments(prop.getProperty(COMMENTS));
	     theCase.setNameOfReporter(prop.getProperty(NAMEOFREPORTER));
	     theCase.setAddressOfReporter(prop.getProperty(ADDRESSOFREPORTER));
	     theCase.setPhoneOfReporter(prop.getProperty(PHONEOFREPORTER));
	     theCase.setStatus(prop.getProperty(STATUS));
	     theCase.setFileNamesFromString(prop.getProperty(FILENAMES));
	     theCase.setNoInvestigation(new Boolean(prop.getProperty(NOINVESTIGATION)).booleanValue());
	     theCase.setAssignedTo(prop.getProperty(ASSIGNED_TO));
	      
	     System.out.println("READ(" + theCase.toString());
	        
	        return theCase;	
		
	}
	
    
	public Case[] find(Case criteria){
		
		
		    ArrayList<Case> cases = new ArrayList<>(); 
	        String filePath = "."; 
	        File f = new File(filePath); 
	        String[] fileNames = f.list(); 
	        Case c1 = new Case();
	        Case c2 = new Case();
	        String assignedTo = criteria.getAssignedTo();
	        String id = "";
	       
	        
	        for (int i = 0; i < fileNames.length; i++) { 
	                if(fileNames[i].startsWith(CASE_FILE_PREFIX)){
	                	System.out.println("File: " + fileNames[i]);
	                    id = fileNames[i].substring(CASE_FILE_PREFIX.length(),fileNames[i].lastIndexOf(CASE_FILE_SUFFIX));
	                	
	                	c1.setId(id);
	                	
	                	c2 = read(c1);
	                	
	                	if( assignedTo != null){
	                		
	                		
	                		if(assignedTo.equals(c2.getAssignedTo())){
	                			cases.add(c2);
	                			System.out.println("FIND: Assigned to NOT null. Adding: " + c2.getId());
	                			
	                		}
	                		
	                		
	                		
	                	}else{
	                		
	                		cases.add(c2);
	                		System.out.println("FIND: Assigned to IS null. Adding: " + c2.getId());
	                	}
	                	
	                
	                }
	                
	            
	        } 
	        
	        
	       Case[] arr = new Case[cases.size()];
	        return cases.toArray(arr); 
	}
  
   /* public static void main(String[] args) { 
  
    	
        CaseDAO cd = new CaseDAO(); 
        Case c = new Case(); 
        */
	
        /*
        c.setDateOfReport(new Date()); 
        c.setDateOfCrime(new Date()); 
        c.setNameOfUnit("Herman"); 
        c.setTypeOfCrime("Brott"); 
        c.setLocationOfCrime("Uppsala"); 
        c.setComments("En kommentar"); 
        c.setNameOfReporter("Isac"); 
        c.setAddressOfReporter("Brottvagen 1"); 
        c.setPhoneOfReporter("1234567"); 
        c.setFileNames(new String[]{"hej","jag","heeheh"});
        c.setStatus("Klar");
        c.setAssignedTo("Skitac");
        c.setNoInvestigation(true);
        Case storedCase = cd.create(c); 
        //System.out.println(storedCase.toString()); 
         
         */
        
        /*
        c.setDateOfReport(new Date()); 
        c.setDateOfCrime(new Date()); 
        c.setNameOfUnit("Apa"); 
        c.setTypeOfCrime("KRIG"); 
        c.setLocationOfCrime("STOCKHOLM"); 
        c.setComments("En kommentar"); 
        c.setNameOfReporter("Isac"); 
        c.setAddressOfReporter("Brottvagen 1"); 
        c.setPhoneOfReporter("125125125125125125217"); 
        c.setFileNames(new String[]{"hej","jag","heeheh"});
        c.setStatus("Klar");
        c.setAssignedTo("Pontus");
        c.setNoInvestigation(true);
        storedCase = cd.create(c); 
       // System.out.println(storedCase.toString());
        storedCase.setAssignedTo("Pontus");
        */
        
	/*
        Case[] cases = cd.find(c);
        for(Case tex : cases){
        	
        	System.out.println("find: " + tex.toString());
        }
      
     
    } */  
  
} 