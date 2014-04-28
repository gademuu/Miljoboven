package miljoboven.backend.conf;

/** 
 * ServerConf represents some of the parameters for the application.
 * @author herman 
 */
public class ServerConf { 
      
   
    public ServerConf(String docroot, String lastCaseID) {
		super();
		this.docroot = docroot;
		this.lastCaseID = lastCaseID;
	}
	@Override
	public String toString() {
		return "ServerConf [docroot=" + docroot + ", lastCaseID=" + lastCaseID
				+ "]";
	}
	public String getDocroot() {
		return docroot;
	}
	public void setDocroot(String docroot) {
		this.docroot = docroot;
	}
	public String getLastCaseID() {
		return lastCaseID;
	}
	public void setLastCaseID(String lastCaseID) {
		this.lastCaseID = lastCaseID;
	}
	private String docroot; 
    private String lastCaseID;
    
    
  
    
      
  

      
   
      
      
      
      
} 