/**
 * @author Vaibhav Ghadi
 * @version 0.1
*/
import java.util.Scanner;

/**
 * Main application class to navigate the AgriSmart System.
 */
public class AgriSmartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("==================================================");
        System.out.println("  Welcome to AgriSmart: Unified Farm Management");
        System.out.println("==================================================");

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. User Management (Single Inheritance))");
            System.out.println("2. Crop Lifecycle (Multilevel Inheritance))");
            System.out.println("3. Machinery Fleet (Hierarchical Inheritance))");
            System.out.println("4. IoT Monitoring (Multiple Inheritance))");
            System.out.println("5. Specialized Personnel (Hybrid Inheritance ))");
            System.out.println("0. Exit System");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n[ Executing Single Inheritance ]");
                    FarmManager manager = new FarmManager("U101", "Alice Smith", "alice@agrismart.com", "FARM-A1", 5000.0);
                    manager.login(); 
                    manager.approveRequisition(3500.0); 
                    manager.scheduleHarvest(); 
                    break;

                case 2:
                    System.out.println("\n[ Executing Multilevel Inheritance ]");
                    ExportQualityCrop premiumCoffee = new ExportQualityCrop("Arabica Coffee", "2022-04-15", "Winter", 15.5, "Grade A", "CERT-8891");
                    premiumCoffee.calculateAge(); 
                    premiumCoffee.estimateHarvestDate(); 
                    premiumCoffee.generateExportComplianceReport(); 
                    break;

                case 3:
                    System.out.println("\n[ Executing Hierarchical Inheritance ]");
                    Tractor johnDeere = new Tractor("TRC-01", "2023-09-01", 85.0, 5000.0);
                    CombineHarvester harvester = new CombineHarvester("CH-02", "2023-10-10", 60.0, 12000.0);
                    IrrigationPump pump = new IrrigationPump("IP-05", "2023-11-05", 100.0, 450.0);
                    
                    johnDeere.logMaintenance(); 
                    johnDeere.attachPlow();     
                    
                    harvester.checkFuel();      
                    harvester.emptyGrainBin();  
                    
                    pump.togglePump();          
                    break;

                case 4:
                    System.out.println("\n[ Executing Multiple Inheritance (Interfaces) ]");
                    AutomatedSoilMonitor smartMonitor = new AutomatedSoilMonitor();
                    smartMonitor.runDiagnostics(); 
                    break;

                case 5:
                    System.out.println("\n[ Executing Hybrid Inheritance ]");
                    AgriTechSpecialist specialist = new AgriTechSpecialist("EMP-992", "Night Shift");
                    specialist.logAttendance(); 
                    specialist.launchSurveyDrone(); 
                    specialist.mixChemicals(); 
                    break;

                case 0:
                    System.out.println("\nExiting AgriSmart System. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select from 0 to 5.");
            }
        } while (choice != 0);

        scanner.close();
    }
}