import java.util.ArrayList;
import java.util.List;
public class Incident {

    //Time And Date
    private String date;
    private String time;

    // Details of person notifying of incident
    private String name;
    private String contactNumber;
    private String email;
    private String relationship;

    // Resources to be dispatched
    private List<String> Resources = new ArrayList<String>();

    // Location of incident
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    // Type of incident
    private String incidentType;

    // Neighboring buildings
    private String[] nearbyBuildings;

    // Any injured parties
    private String injuryType;
    private int numInjured;

    //Nearest Firestartion
    private FireStation fireStation;

    //Critical Incident
    private Boolean IsCritical;

    // Constructor
    public Incident(String date, String time, String name, String contactNumber, String email, String relationship,
                    String streetAddress, String city,
                    String state, String country, String zipCode, String incidentType,
                    String[] nearbyBuildings, String injuryType, int numInjured) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.relationship = relationship;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.incidentType = incidentType;
        this.nearbyBuildings = nearbyBuildings;
        this.injuryType = injuryType;
        this.numInjured = numInjured;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public List<String> getResources() {
        return Resources;
    }

    public void setResources(List<String> Resources) {
        this.Resources = Resources;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String[] getNearbyBuildings() {
        return nearbyBuildings;
    }

    public void setNearbyBuildings(String[] nearbyBuildings) {
        this.nearbyBuildings = nearbyBuildings;
    }
    
    public String getInjuryType() {
        return injuryType;
    }
    
    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }
    
    public int getNumInjured() {
        return numInjured;
    }
    
    public void setNumInjured(int numInjured) {
        this.numInjured = numInjured;
    }

    public FireStation getfireStation() {
        return fireStation;
    }
    
    public void setFireStation(FireStation fireStation) {
        this.fireStation = fireStation;
    }

    public Boolean getIsCritical() {
        return IsCritical;
    }
    
    public void setIsCritical(Boolean IsCritical) {
        this.IsCritical = IsCritical;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "Name='" + getName() + '\''+
                ", Contact number='" + getContactNumber() + '\''+
                ", Email='" + getEmail() + '\''+
                ", Relationship to the incident='" + getRelationship() + '\''+
                ", Street address='" + getStreetAddress() + '\''+
                ", City/town='" + getCity() + '\''+
                ", State/province='" + getState() + '\''+
                ", Country='" + getCountry() + '\''+
                ", Zip/postal code='" + getZipCode() + '\''+
                ", Type of incident='" + getIncidentType() + '\''+
                ", Nearby buildings='" + String.join(", ", getNearbyBuildings()) + '\''+
                ", Type of injury='" + getInjuryType() + '\''+
                ", Number of injured parties='" + getNumInjured() + '\'' +
                (getfireStation() != null ? ", FireStation='" + getfireStation().getName() + " -- " + getfireStation().getAddress() + '\'' : "") +
                (getResources() != null && getResources().isEmpty() != true ? ", Assigned Resources='" + String.join(", ", getResources()) + '\'' : "")+
                '}';
    }
}    