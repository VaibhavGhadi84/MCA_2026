import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static ElectronicStore store = new ElectronicStore("VGTech");
    private static List<Customer> customers = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static Supplier defaultSupplier = new Supplier("S001", "TechDistributors", "852464652");
    private static Warehouse warehouse = new Warehouse("Mapusa , Goa");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        employees.add(new Employee("E001", "Alice (Cashier)", 45000));

        while (running) {
            System.out.println("\n=== Electronic Store Management System ===");
            System.out.println("1. Add a new Product");
            System.out.println("2. Register a new Customer");
            System.out.println("3. View Store Products");
            System.out.println("4. Process a Sale");
            System.out.println("5. Receive Stock from Supplier");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    addCustomer(scanner);
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    processSale(scanner);
                    break;
                case 5:
                    receiveStock(scanner);
                    break;
                case 6:
                    System.out.println("Exiting System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }

    private static void addProduct(Scanner scanner) {
        System.out.println("\n-- Add New Product --");
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        Product product = new Product(id, name, price, category);
        store.addProduct(product);
        System.out.println("Success: " + name + " added to the store.");
    }

    private static void addCustomer(Scanner scanner) {
        System.out.println("\n-- Register Customer --");
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone No: ");
        String phoneNo = scanner.nextLine();

        Customer customer = new Customer(id, name, address, phoneNo);
        customers.add(customer);
        System.out.println("Success: Customer " + name + " registered.");
    }

    private static void viewProducts() {
        System.out.println("\n-- Available Products --");
        List<Product> products = store.getProducts();
        
        if (products.isEmpty()) {
            System.out.println("No products available in the store.");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". [" + p.getId() + "] " + p.getName() + " - $" + p.getPrice() + " (" + p.getCategories() + ")");
        }
    }

    private static void processSale(Scanner scanner) {
        System.out.println("\n-- Process a Sale --");
        List<Product> products = store.getProducts();

        if (products.isEmpty()) {
            System.out.println("Error: No products available to sell.");
            return;
        }
        if (customers.isEmpty()) {
            System.out.println("Error: No customers registered. Please register a customer first.");
            return;
        }

        // Select Customer
        System.out.println("Select Customer by number:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        System.out.print("Choice: ");
        int customerIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        Customer selectedCustomer = customers.get(customerIndex);

        // Select Product
        viewProducts();
        System.out.print("Select Product by number to buy: ");
        int productIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        Product selectedProduct = products.get(productIndex);

        // Process Transaction
        Employee activeEmployee = employees.get(0); // Using the default employee
        activeEmployee.sellProduct(selectedProduct, selectedCustomer);
        selectedCustomer.buyProduct(selectedProduct);
    }

    private static void receiveStock(Scanner scanner) {
        System.out.println("\n-- Receive Stock --");
        System.out.print("Enter stock description to order (e.g., '50x Laptops'): ");
        String itemDesc = scanner.nextLine();

        Stock newStock = new Stock(Arrays.asList(itemDesc));
        
        defaultSupplier.supplyStock(newStock);
        warehouse.storeStock(newStock);
        
        System.out.println("Success: Stock has been delivered and moved to the Warehouse.");
    }
}