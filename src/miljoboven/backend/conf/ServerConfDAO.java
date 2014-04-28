package miljoboven.backend.conf;

import java.util.Properties;

import miljoboven.backend.BaseDAO;


public class ServerConfDAO extends BaseDAO{ 
    
    //Constants 
    private static final String FILE = "server.properties"; 
    private static final String LAST_CASE_ID = "lastCaseID";
    private static final String DOCROOT = "docroot"; 
    
    //End of constants 
      
   
    public ServerConf update(ServerConf aServerConf) { 
  	  
        
        
  
        Properties prop = new Properties(); 
        prop = load(FILE); 
        prop.setProperty(DOCROOT, aServerConf.getDocroot()); 
        prop.setProperty(LAST_CASE_ID, aServerConf.getLastCaseID()); 
      
  
        store(FILE, prop, true); 
  
       
        return aServerConf; 
    } 
      
    public ServerConf read(){ 
          
        ServerConf sc = null; 
  
        Properties prop = new Properties(); 
        prop = load(FILE); 
        String lastCaseID = (String) prop.get(LAST_CASE_ID); 
        String docroot = (String) prop.get(DOCROOT); 
       
        sc = new ServerConf(docroot, lastCaseID); 
  
        return sc; 
        } 
    
    
         
    } 
     