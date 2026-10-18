using System;
using System.Collections.Generic;

namespace ElectronicStoreApp
{
    // --- Class Definitions ---

    public class Product
    {
        public string Id { get; }
        public string Name { get; }
        public double Price { get; }
        public string Categories { get; }

        public Product(string id, string name, double price, string categories)
        {
            Id = id;
            Name = name;
            Price = price;
            Categories = categories;
        }
    }

    public class Customer
    {
        public string Id { get; }
        public string Name { get; }
        public string Address { get; }
        public string PhoneNo { get; }

        public Customer(string id, string name, string address, string phoneNo)
        {
            Id = id;
            Name = name;
            Address = address;
            PhoneNo = phoneNo;
        }

        public void BuyProduct(Product product)
        {
            Console.WriteLine($"{Name} bought {product.Name}");
        }
    }

    public class Employee
    {
        public string Id { get; }
        public string Name { get; }
        public double Salary { get; }

        public Employee(string id, string name, double salary)
        {
            Id = id;
            Name = name;
            Salary = salary;
        }

        public void SellProduct(Product product, Customer customer)
        {
            Console.WriteLine($"{Name} sold {product.Name} to {customer.Name}");
        }
    }

    public class ElectronicStore
    {
        public string Address { get; }
        private List<Employee> employees;
        private List<Product> products;

        public ElectronicStore(string address)
        {
            Address = address;
            employees = new List<Employee>();
            products = new List<Product>();
        }

        public void AddEmployee(Employee emp)
        {
            employees.Add(emp);
        }

        public void AddProduct(Product prod)
        {
            products.Add(prod);
        }

        public IReadOnlyList<Product> GetProducts()
        {
            return products;
        }
    }

    public class Stock
    {
        public List<string> StockList { get; }

        public Stock(List<string> stockList)
        {
            StockList = stockList;
        }
    }

    public class Supplier
    {
        public string Id { get; }
        public string Name { get; }
        public string PhoneNo { get; }

        public Supplier(string id, string name, string phoneNo)
        {
            Id = id;
            Name = name;
            PhoneNo = phoneNo;
        }

        public void SupplyStock(Stock stock)
        {
            string items = string.Join(", ", stock.StockList);
            Console.WriteLine($"{Name} is supplying stock: [{items}]");
        }
    }

    public class Warehouse
    {
        public string Location { get; }
        private List<Stock> storedStock;

        public Warehouse(string location)
        {
            Location = location;
            storedStock = new List<Stock>();
        }

        public void StoreStock(Stock stock)
        {
            storedStock.Add(stock);
        }
    }

    public class Inventory
    {
        private List<Stock> managedStock;
        private List<Product> products;

        public Inventory()
        {
            managedStock = new List<Stock>();
            products = new List<Product>();
        }

        public void ManageStock(Stock stock)
        {
            managedStock.Add(stock);
        }
    }

    public class Owner
    {
        public string Name { get; }
        public ElectronicStore Store { get; }

        public Owner(string name, ElectronicStore store)
        {
            Name = name;
            Store = store;
        }
    }

    // --- Main Application Program ---

    class Program
    {
        static ElectronicStore store = new ElectronicStore("VGTech");
        static List<Customer> customers = new List<Customer>();
        static List<Employee> employees = new List<Employee>();
        static Supplier defaultSupplier = new Supplier("S001", "TechDistributors", "852464652");
        static Warehouse warehouse = new Warehouse("Mapusa, Goa");

        static void Main(string[] args)
        {
            employees.Add(new Employee("E001", "Alice (Cashier)", 45000));
            bool running = true;

            while (running)
            {
                Console.WriteLine("\n=== Electronic Store Management System ===");
                Console.WriteLine("1. Add a new Product");
                Console.WriteLine("2. Register a new Customer");
                Console.WriteLine("3. View Store Products");
                Console.WriteLine("4. Process a Sale");
                Console.WriteLine("5. Receive Stock from Supplier");
                Console.WriteLine("6. Exit");
                Console.Write("Choose an option (1-6): ");

                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        AddProduct();
                        break;
                    case "2":
                        AddCustomer();
                        break;
                    case "3":
                        ViewProducts();
                        break;
                    case "4":
                        ProcessSale();
                        break;
                    case "5":
                        ReceiveStock();
                        break;
                    case "6":
                        Console.WriteLine("Exiting System. Goodbye!");
                        running = false;
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
            }
        }

        static void AddProduct()
        {
            Console.WriteLine("\n-- Add New Product --");
            Console.Write("Enter Product ID: ");
            string id = Console.ReadLine();

            Console.Write("Enter Product Name: ");
            string name = Console.ReadLine();

            Console.Write("Enter Price: ");
            double price;
            while (!double.TryParse(Console.ReadLine(), out price))
            {
                Console.Write("Invalid price. Please enter a valid number: ");
            }

            Console.Write("Enter Category: ");
            string category = Console.ReadLine();

            store.AddProduct(new Product(id, name, price, category));
            Console.WriteLine($"Success: {name} added to the store.");
        }

        static void AddCustomer()
        {
            Console.WriteLine("\n-- Register Customer --");
            Console.Write("Enter Customer ID: ");
            string id = Console.ReadLine();

            Console.Write("Enter Name: ");
            string name = Console.ReadLine();

            Console.Write("Enter Address: ");
            string address = Console.ReadLine();

            Console.Write("Enter Phone No: ");
            string phoneNo = Console.ReadLine();

            customers.Add(new Customer(id, name, address, phoneNo));
            Console.WriteLine($"Success: Customer {name} registered.");
        }

        static void ViewProducts()
        {
            Console.WriteLine("\n-- Available Products --");
            var products = store.GetProducts();

            if (products.Count == 0)
            {
                Console.WriteLine("No products available in the store.");
                return;
            }

            for (int i = 0; i < products.Count; i++)
            {
                var p = products[i];
                Console.WriteLine($"{i + 1}. [{p.Id}] {p.Name} ${p.Price} ({p.Categories})");
            }
        }

        static void ProcessSale()
        {
            Console.WriteLine("\n-- Process a Sale --");
            var products = store.GetProducts();

            if (products.Count == 0)
            {
                Console.WriteLine("Error: No products available to sell.");
                return;
            }
            if (customers.Count == 0)
            {
                Console.WriteLine("Error: No customers registered. Please register a customer first.");
                return;
            }

            // Select Customer
            Console.WriteLine("Select Customer by number:");
            for (int i = 0; i < customers.Count; i++)
            {
                Console.WriteLine($"{i + 1}. {customers[i].Name}");
            }
            Console.Write("Choice: ");
            
            if (!int.TryParse(Console.ReadLine(), out int customerIndex) || customerIndex < 1 || customerIndex > customers.Count)
            {
                Console.WriteLine("Invalid customer choice.");
                return;
            }
            Customer selectedCustomer = customers[customerIndex - 1];

            // Select Product
            ViewProducts();
            Console.Write("Select Product by number to buy: ");
            
            if (!int.TryParse(Console.ReadLine(), out int productIndex) || productIndex < 1 || productIndex > products.Count)
            {
                Console.WriteLine("Invalid product choice.");
                return;
            }
            Product selectedProduct = products[productIndex - 1];

            // Process Transaction
            Employee activeEmployee = employees[0]; // Using the default employee
            activeEmployee.SellProduct(selectedProduct, selectedCustomer);
            selectedCustomer.BuyProduct(selectedProduct);
        }

        static void ReceiveStock()
        {
            Console.WriteLine("\n-- Receive Stock --");
            Console.Write("Enter stock description to order (e.g., '50x Laptops'): ");
            string itemDesc = Console.ReadLine();

            Stock newStock = new Stock(new List<string> { itemDesc });

            defaultSupplier.SupplyStock(newStock);
            warehouse.StoreStock(newStock);

            Console.WriteLine("Success: Stock has been delivered and moved to the Warehouse.");
        }
    }
}
