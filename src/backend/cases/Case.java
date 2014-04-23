package backend.cases; 
  
import java.util.Date; 
  
/** 
 * 
 * @author herman 
 */
public class Case { 
      
    private Date dateOfReport; 
    private Date dateOfCrime; 
    private String nameOfCoordinator; 
    private String typeOfCrime; 
    private String id; 
    private String locationOfCrime; 
    private String comments; 
    private String nameOfReporter; 
    private String addressOfReporter; 
    private String phoneOfReporter; 
      
    public Case() { 
          
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
  
    public String getNameOfCoordinator() { 
        return nameOfCoordinator; 
    } 
  
    public void setNameOfCoordinator(String nameOfCoordinator) { 
        this.nameOfCoordinator = nameOfCoordinator; 
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
  
    
    public String toString() { 
        return "Case{" + "dateOfReport=" + dateOfReport + ", dateOfCrime=" + dateOfCrime + ", nameOfCoordinator=" + nameOfCoordinator + ", typeOfCrime=" + typeOfCrime + ", id=" + id + ", locationOfCrime=" + locationOfCrime + ", comments=" + comments + ", nameOfReporter=" + nameOfReporter + ", addressOfReporter=" + addressOfReporter + ", phoneOfReporter=" + phoneOfReporter + '}'; 
    } 
      
      
      
      
} 