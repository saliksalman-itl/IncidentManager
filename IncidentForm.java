import java.text.SimpleDateFormat;
import java.util.Scanner;

public class IncidentForm {

    public void main() {
        Scanner scanner = new Scanner(System.in);

        // Details of person notifying of incident
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter your email (optional): ");
        String email = scanner.nextLine();

        System.out.print("Enter your relationship to the incident: ");
        String relationship = scanner.nextLine();

        // Location of incident
        System.out.print("Enter street address of incident: ");
        String streetAddress = scanner.nextLine();

        System.out.print("Enter city/town of incident: ");
        String city = scanner.nextLine();

        System.out.print("Enter state/province of incident: ");
        String state = scanner.nextLine();

        System.out.print("Enter country of incident: ");
        String country = scanner.nextLine();

        System.out.print("Enter zip/postal code of incident: ");
        String zipCode = scanner.nextLine();

        // Type of incident
        String incidentType = null;
        boolean incidentTypeValid = false;
        while (!incidentTypeValid) {
            System.out.print("Enter type of incident (building fire, grass fire, factory fire, RTC): ");
            incidentType = scanner.nextLine();
            if (incidentType.equals("building fire") || incidentType.equals("grass fire") ||
                    incidentType.equals("factory fire") || incidentType.equals("RTC")) {
                incidentTypeValid = true;
            } else {
                System.out.println("Invalid incident type. Please enter a valid incident type.");
            }
        }

        // Neighboring buildings
        System.out.print("Enter nearby buildings that may be affected (comma-separated): ");
        String nearbyBuildingsString = scanner.nextLine();
        String[] nearbyBuildings = nearbyBuildingsString.split(",");

        // Any injured parties
        String injuryType = null;
        boolean injuryTypeValid = false;
        while (!injuryTypeValid) {
            System.out.print("Enter type of injury (superficial or life-threatening): ");
            injuryType = scanner.nextLine();
            if (injuryType.equals("superficial") || injuryType.equals("life-threatening")) {
                injuryTypeValid = true;
            } else {
                System.out.println("Invalid injury type. Please enter a valid injury type.");
            }
        }

        int numInjured = 0;
        boolean numInjuredValid = false;
        while (!numInjuredValid) {
            try {
                System.out.print("Enter number of injured parties: ");
                numInjured = scanner.nextInt();
                scanner.nextLine(); // consume the newline character left by nextInt()
                numInjuredValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // consume the invalid input
            }
        }

        // Date And Time
        String Time = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(System.currentTimeMillis()));
        String Date = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

        // Create and fill in the Incident object
        Incident incident = new Incident(Time, Date, name, contactNumber, email, relationship, streetAddress, city,
                                         state, country, zipCode, incidentType,
                                         nearbyBuildings, injuryType, numInjured);
        IncidentList.add(incident);
        System.out.println("==== Incident Created ====");
        IncidentList.get(IncidentList.getList().size() - 1);
    }
}