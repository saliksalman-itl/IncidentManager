import java.util.ArrayList;
import java.util.List;

public class FireStationsList {
    private static List<FireStation> fireStations = new ArrayList<>();
    
    public static void add(FireStation fireStation) {
        fireStations.add(fireStation);
    }

    public static FireStation get(int index) {
        if (index < 0 || index >= fireStations.size()) {
            return null;
        }
        return fireStations.get(index);
    }    

    public static List<FireStation> getAll(int index) {
        return fireStations;
    }    
    
    public static void displayAll() {
        System.out.println("Fire Stations List:");
        for (int i = 0; i < fireStations.size(); i++) {
            FireStation fireStation = fireStations.get(i);
            System.out.println((i + 1) + ". " + fireStation.getName() + " - " + fireStation.getAddress());
        }
    }
    
    public static void displayByIndex(int index) {
        if (index < 0 || index >= fireStations.size()) {
            System.out.println("Invalid index.");
        } else {
            FireStation fireStation = fireStations.get(index);
            System.out.println("Fire Station #" + (index + 1) + ": " + fireStation.getName() + " - " + fireStation.getAddress());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fire Stations List:\n");
        for (int i = 0; i < fireStations.size(); i++) {
            FireStation fireStation = fireStations.get(i);
            sb.append((i + 1) + ". " + fireStation.getName() + " - " + fireStation.getAddress() + "\n");
        }
        return sb.toString();
    }
}