import java.util.ArrayList;

public class IncidentList {

    private static ArrayList<Incident> incidentsList = new ArrayList<Incident>();

    public static void add(Incident incident) {
        incidentsList.add(incident);
    }
    
    public static ArrayList<Incident> getList() {
        return incidentsList;
    }
    
    public static Incident getIncident(int i) {
        return incidentsList.get(i);
    }

    public static void get(int i) {
            Incident incident = incidentsList.get(i);
            System.out.println("Incident " + (i+1) + ":");
            System.out.println("Name: " + incident.getName());
            System.out.println("Contact number: " + incident.getContactNumber());
            System.out.println("Email: " + incident.getEmail());
            System.out.println("Relationship to the incident: " + incident.getRelationship());
            System.out.println("Street address: " + incident.getStreetAddress());
            System.out.println("City/town: " + incident.getCity());
            System.out.println("State/province: " + incident.getState());
            System.out.println("Country: " + incident.getCountry());
            System.out.println("Zip/postal code: " + incident.getZipCode());
            System.out.println("Type of incident: " + incident.getIncidentType());
            System.out.println("Nearby buildings: " + String.join(", ", incident.getNearbyBuildings()));
            System.out.println("Type of injury: " + incident.getInjuryType());
            System.out.println("Number of injured parties: " + incident.getNumInjured());
            if(incident.getfireStation() != null) System.out.println("FireStation: " + incident.getfireStation().getName() + " -- " + incident.getfireStation().getAddress());
            if(incident.getResources() != null && incident.getResources().isEmpty() != true) System.out.println("Assigned Resources: " + String.join(", ", incident.getResources()));
            System.out.println();
    }

    public static void getAll() {
        if(incidentsList.size() < 1){
            System.out.println("No Incidents Found.");
            return;    
        }
        System.out.println("Incidents:");
        for (int i = 0; i < incidentsList.size(); i++) {
            get(i);
        }
    }
}
