import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class IncidentAdmin {
    private static List<String> assignedResources = new ArrayList<>();

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Incident Admin Mode");

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. View Incidents");
            System.out.println("2. Assign resources");
            System.out.println("3. Select nearest fire station");
            System.out.println("4. Declare critical incident");
            System.out.println("5. Indicate RTC specialist equipment");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    int IncidentNumbers = IncidentList.getList().size();
                    if(IncidentNumbers == 0) {
                        System.out.println("No incidents found.");
                        break;
                    };
                    for(int i = 0; i < IncidentList.getList().size(); i++){
                        System.out.println((i + 1) + ". " + IncidentList.getIncident(i).toString());
                    }
                    break;
                case 2:
                    assignResources(scanner);
                    break;
                case 3:
                    selectNearestFireStation(scanner);
                    break;
                case 4:
                    declareCriticalIncident(scanner);
                    break;
                case 5:
                    indicateSpecialistEquipment(scanner);
                    break;
                case 6:
                    System.out.println("Exiting Incident Admin Mode");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void assignResources(Scanner scanner) {
        Incident incident = selectIncident(scanner);
        if (incident == null) {
            return;
        }
        if (incident.getIncidentType().equals("RTC")) {
            System.out.println("This Incident Is RTC Please Assign Resources From RTC Equipments Menu!");
            return;
        }
        System.out.println("Enter resources to assign (separated by commas):");
        String resources = null;
        try {
            resources = scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("Error: Scanner object has no valid input. Please try again.");
            return;
        }
        if(resources != null){
            String[] resourceArray = resources.split(",");
            assignedResources = incident.getResources();
            for (String resource : resourceArray) {
                if(assignedResources != null)
                assignedResources.add(resource);
            }
            incident.setResources(assignedResources);
            System.out.println("Resource Assigned To Incident.");
        } else {
            System.out.println("No Resource Assigned To Incident.");
        }
    }    

    private static void selectNearestFireStation(Scanner scanner) {
        Incident incident = selectIncident(scanner);
        if (incident == null) {
            return;
        }
        System.out.println("Please select nearest fire station:");
        FireStationsList.displayAll();
        try {
            int nearestFireStationNumber = scanner.nextInt();
            scanner.nextLine();
            FireStation nearestFireStation = FireStationsList.get(nearestFireStationNumber);
            if (nearestFireStation != null) {
                incident.setFireStation(nearestFireStation);
                System.out.println("Incident Assigned To FireStation #" + nearestFireStationNumber);
            } else {
                System.out.println("Invalid FireStation Selected Please Try Again.");
                selectNearestFireStation(scanner);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private static Incident selectIncident(Scanner scanner) {
        int totalIncidents = IncidentList.getList().size();
        if (totalIncidents == 0) {
            System.out.println("No incidents found.");
            return null;
        }
        System.out.println("Select incident by number:");
        for (int i = 0; i < totalIncidents; i++) {
            System.out.println((i + 1) + ". " + IncidentList.getIncident(i).toString());
        }
        int incidentNumber;
        while (true) {
            try {
                incidentNumber = Integer.parseInt(scanner.nextLine());
                if (incidentNumber < 1 || incidentNumber > totalIncidents) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid incident number. Please try again.");
            }
        }
        Incident incident = IncidentList.getIncident(incidentNumber - 1);
        return incident;
    }    

    private static void declareCriticalIncident(Scanner scanner) {
        Incident incident = selectIncident(scanner);
        if (incident == null) {
            return;
        }
        try {
            incident.setIsCritical(true);
            System.out.println("Incident declared as critical and passed to critical incident commander located at HQ.");
        } catch (Exception e) {
            System.out.println("An error occurred while marking the incident as critical: " + e.getMessage());
        }
    }    

    private static void indicateSpecialistEquipment(Scanner scanner) {
        Incident incident = selectIncident(scanner);
        if (incident != null) {
            if (incident.getIncidentType().equals("RTC")) {
                try {
                    System.out.println("Enter RTC specialist equipment required (e.g. Jaws of Life) separated by commas:");
                    String resources = scanner.nextLine();
                    String[] resourceArray = resources.split(",");
                    List<String> assignedResources = incident.getResources();
                    for (String resource : resourceArray) {
                        assignedResources.add(resource.trim());
                    }
                    incident.setResources(assignedResources);
                    System.out.println("Special Resources Assigned To Incident.");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("This Incident Is Not An RTC Please Use Normal Menu To Assigned Resources.");
                return;
            }
        } else {
            return;
        }
    }
    
}
