import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FireStationsList.add(new FireStation("Station# 1", "Block 4"));
        FireStationsList.add(new FireStation("Station# 2", "Block 5"));
        FireStationsList.add(new FireStation("Station# 3", "Block 6"));
        int menuChoice = -1;
        do {
            System.out.println("==== Main Menu ====");
            System.out.println("1. Incident Mode");
            System.out.println("2. Incident Admin Mode");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            try {
                menuChoice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // consume the invalid input
                continue;
            }
            switch (menuChoice) {
                case 1:
                    incidentMode();
                    break;
                case 2:
                    IncidentAdmin.main();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (menuChoice != 0);

        input.close();
    }

    public static void incidentMode() {
        Scanner input = new Scanner(System.in);

        int incidentChoice = -1;
        do {
            System.out.println("==== Incident Mode ====");
            System.out.println("1. Create incident");
            System.out.println("2. View incidents");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            try {
                incidentChoice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // consume the invalid input
                continue;
            }

            switch (incidentChoice) {
                case 1:
                    new IncidentForm().main();
                    break;
                case 2:
                    IncidentList.getAll();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (incidentChoice != 0);
    }
}