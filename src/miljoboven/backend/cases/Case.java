package miljoboven.backend.cases; 
  
import java.util.Date; 
  
/** 
 * 
 * @author herman 
 */
public class Case { 
      
    private Date dateOfReport; 
    private Date dateOfCrime; 
    private String nameOfUnit; 
    private String typeOfCrime; 
    private String id; 
    private String locationOfCrime; 
    private String comments; 
    private String nameOfReporter; 
    private String addressOfReporter; 
    private String phoneOfReporter; 
    private String[] fileNames;
    private String status;
    private boolean noInvestigation;
    
    public Case() { 
        
    } 


	public String[] getFileNames() {
		return fileNames;
	}
	
	public String getFileNamesAsString(){
		String names = "";
		
		for(String s : fileNames){
			names += s + ",";
		}
		return names.substring(0,names.length() -1);
	}


	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNoInvestigationAsString(){
		return "" + noInvestigation;
    }
	
	public boolean isNoInvestigation() {
		return noInvestigation;
	}

	public void setNoInvestigation(boolean noInvestigation) {
		this.noInvestigation = noInvestigation;
	}
  
    public Date getDateOfReport() { 
        return dateOfReport; 
    } 
  
    public void setDateOfReport(Date dateOfReport) { 
        this.dateOfReport = dateOfReport; 
    } 
  
    public Date getDateOfCrime() { 
        return dateOfCrime; 
    } 
  
    public void setDateOfCrime(Date dateOfCrime) { 
        this.dateOfCrime = dateOfCrime; 
    } 
  
    public String getNameOfUnit() { 
        return nameOfUnit; 
    } 
  
    public void setNameOfUnit(String nameOfUnit) { 
        this.nameOfUnit = nameOfUnit; 
    } 
  
    public String getTypeOfCrime() { 
        return typeOfCrime; 
    } 
  
    public void setTypeOfCrime(String typeOfCrime) { 
        this.typeOfCrime = typeOfCrime; 
    } 
  
    public String getId() { 
        return id; 
    } 
  
    public void setId(String id) { 
        this.id = id; 
    } 
  
    public String getLocationOfCrime() { 
        return locationOfCrime; 
    } 
  
    public void setLocationOfCrime(String locationOfCrime) { 
        this.locationOfCrime = locationOfCrime; 
    } 
  
    public String getComments() { 
        return comments; 
    } 
  
    public void setComments(String comments) { 
        this.comments = comments; 
    } 
  
    public String getNameOfReporter() { 
        return nameOfReporter; 
    } 
  
    public void setNameOfReporter(String nameOfReporter) { 
        this.nameOfReporter = nameOfReporter; 
    } 
  
    public String getAddressOfReporter() { 
        return addressOfReporter; 
    } 
  
    public void setAddressOfReporter(String addressOfReporter) { 
        this.addressOfReporter = addressOfReporter; 
    } 
  
    public String getPhoneOfReporter() { 
        return phoneOfReporter; 
    } 
  
    public void setPhoneOfReporter(String phoneOfReporter) { 
        this.phoneOfReporter = phoneOfReporter; 
    }

	@Override
	public String toString() {
		return "Case [dateOfReport=" + dateOfReport + ", dateOfCrime="
				+ dateOfCrime + ", nameOfUnit=" + nameOfUnit + ", typeOfCrime="
				+ typeOfCrime + ", id=" + id + ", locationOfCrime="
				+ locationOfCrime + ", comments=" + comments
				+ ", nameOfReporter=" + nameOfReporter + ", addressOfReporter="
				+ addressOfReporter + ", phoneOfReporter=" + phoneOfReporter
				+ ", fileNames=" + fileNames + ", status=" + status
				+ ", noInvestigation=" + noInvestigation + "]";
	} 
  
  
      
} 