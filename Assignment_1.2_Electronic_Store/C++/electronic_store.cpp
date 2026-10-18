#include <iostream>
#include <vector>
#include <string>
#include <limits>

using namespace std;

// --- Class Definitions ---

class Product {
private:
    string id;
    string name;
    double price;
    string categories;

public:
    Product(string id, string name, double price, string categories)
        : id(id), name(name), price(price), categories(categories) {}

    string getId() const { return id; }
    string getName() const { return name; }
    double getPrice() const { return price; }
    string getCategories() const { return categories; }
};

class Customer {
private:
    string id;
    string name;
    string address;
    string phoneNo;

public:
    Customer(string id, string name, string address, string phoneNo)
        : id(id), name(name), address(address), phoneNo(phoneNo) {}

    void buyProduct(const Product& product) const {
        cout << name << " bought " << product.getName() << endl;
    }

    string getId() const { return id; }
    string getName() const { return name; }
    string getAddress() const { return address; }
    string getPhoneNo() const { return phoneNo; }
};

class Employee {
private:
    string id;
    string name;
    double salary;

public:
    Employee(string id, string name, double salary)
        : id(id), name(name), salary(salary) {}

    void sellProduct(const Product& product, const Customer& customer) const {
        cout << name << " sold " << product.getName() << " to " << customer.getName() << endl;
    }

    string getId() const { return id; }
    string getName() const { return name; }
    double getSalary() const { return salary; }
};

class ElectronicStore {
private:
    string address;
    vector<Employee> employees;
    vector<Product> products;

public:
    ElectronicStore(string address) : address(address) {}

    void addEmployee(const Employee& emp) {
        employees.push_back(emp);
    }

    void addProduct(const Product& prod) {
        products.push_back(prod);
    }

    const vector<Product>& getProducts() const {
        return products;
    }

    string getAddress() const { return address; }
};

class Stock {
private:
    vector<string> stockList;

public:
    Stock(const vector<string>& stockList) : stockList(stockList) {}
    const vector<string>& getStockList() const { return stockList; }
};

class Supplier {
private:
    string id;
    string name;
    string phoneNo;

public:
    Supplier(string id, string name, string phoneNo)
        : id(id), name(name), phoneNo(phoneNo) {}

    void supplyStock(const Stock& stock) const {
        cout << name << " is supplying stock: [";
        const auto& list = stock.getStockList();
        for (size_t i = 0; i < list.size(); ++i) {
            cout << list[i] << (i < list.size() - 1 ? ", " : "");
        }
        cout << "]" << endl;
    }

    string getId() const { return id; }
    string getName() const { return name; }
    string getPhoneNo() const { return phoneNo; }
};

class Warehouse {
private:
    string location;
    vector<Stock> storedStock;

public:
    Warehouse(string location) : location(location) {}

    void storeStock(const Stock& stock) {
        storedStock.push_back(stock);
    }
};

class Inventory {
private:
    vector<Stock> managedStock;
    vector<Product> products;

public:
    Inventory() {}
    void manageStock(const Stock& stock) {
        managedStock.push_back(stock);
    }
};

class Owner {
private:
    string name;
    ElectronicStore store;

public:
    Owner(string name, ElectronicStore store) : name(name), store(store) {}
};


// --- Global Application State ---

ElectronicStore store("VGTech");
vector<Customer> customers;
vector<Employee> employees;
Supplier defaultSupplier("S001", "TechDistributors", "852464652");
Warehouse warehouse("Mapusa , Goa");

// --- Helper Functions ---

void clearInputBuffer() {
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

void addProduct() {
    cout << "\n-- Add New Product --\n";
    
    string id, name, category;
    double price;
    
    cout << "Enter Product ID: ";
    getline(cin, id);
    
    cout << "Enter Product Name: ";
    getline(cin, name);
    
    cout << "Enter Price: ";
    cin >> price;
    clearInputBuffer();
    
    cout << "Enter Category: ";
    getline(cin, category);

    store.addProduct(Product(id, name, price, category));
    cout << "Success: " << name << " added to the store.\n";
}

void addCustomer() {
    cout << "\n-- Register Customer --\n";
    
    string id, name, address, phoneNo;
    
    cout << "Enter Customer ID: ";
    getline(cin, id);
    
    cout << "Enter Name: ";
    getline(cin, name);
    
    cout << "Enter Address: ";
    getline(cin, address);
    
    cout << "Enter Phone No: ";
    getline(cin, phoneNo);

    customers.push_back(Customer(id, name, address, phoneNo));
    cout << "Success: Customer " << name << " registered.\n";
}

void viewProducts() {
    cout << "\n-- Available Products --\n";
    const vector<Product>& products = store.getProducts();
    
    if (products.empty()) {
        cout << "No products available in the store.\n";
        return;
    }

    for (size_t i = 0; i < products.size(); i++) {
        const Product& p = products[i];
        cout << (i + 1) << ". [" << p.getId() << "] " << p.getName() 
             << " - $" << p.getPrice() << " (" << p.getCategories() << ")\n";
    }
}

void processSale() {
    cout << "\n-- Process a Sale --\n";
    const vector<Product>& products = store.getProducts();

    if (products.empty()) {
        cout << "Error: No products available to sell.\n";
        return;
    }
    if (customers.empty()) {
        cout << "Error: No customers registered. Please register a customer first.\n";
        return;
    }

    // Select Customer
    cout << "Select Customer by number:\n";
    for (size_t i = 0; i < customers.size(); i++) {
        cout << (i + 1) << ". " << customers[i].getName() << "\n";
    }
    cout << "Choice: ";
    int customerIndex;
    cin >> customerIndex;
    clearInputBuffer();
    
    if (customerIndex < 1 || customerIndex > customers.size()) {
        cout << "Invalid customer choice.\n";
        return;
    }
    const Customer& selectedCustomer = customers[customerIndex - 1];

    // Select Product
    viewProducts();
    cout << "Select Product by number to buy: ";
    int productIndex;
    cin >> productIndex;
    clearInputBuffer();

    if (productIndex < 1 || productIndex > products.size()) {
        cout << "Invalid product choice.\n";
        return;
    }
    const Product& selectedProduct = products[productIndex - 1];

    // Process Transaction
    const Employee& activeEmployee = employees[0];
    activeEmployee.sellProduct(selectedProduct, selectedCustomer);
    selectedCustomer.buyProduct(selectedProduct);
}

void receiveStock() {
    cout << "\n-- Receive Stock --\n";
    cout << "Enter stock description to order (e.g., '50x Laptops'): ";
    string itemDesc;
    getline(cin, itemDesc);

    vector<string> stockItems = {itemDesc};
    Stock newStock(stockItems);
    
    defaultSupplier.supplyStock(newStock);
    warehouse.storeStock(newStock);
    
    cout << "Success: Stock has been delivered and moved to the Warehouse.\n";
}

// --- Main Execution ---

int main() {
    employees.push_back(Employee("E001", "Alice (Cashier)", 45000));
    bool running = true;
    int choice;

    while (running) {
        cout << "\n=== Electronic Store Management System ===\n";
        cout << "1. Add a new Product\n";
        cout << "2. Register a new Customer\n";
        cout << "3. View Store Products\n";
        cout << "4. Process a Sale\n";
        cout << "5. Receive Stock from Supplier\n";
        cout << "6. Exit\n";
        cout << "Choose an option (1-6): ";

        if (!(cin >> choice)) {
            clearInputBuffer();
            cout << "Invalid input. Please enter a number.\n";
            continue;
        }
        clearInputBuffer();

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                viewProducts();
                break;
            case 4:
                processSale();
                break;
            case 5:
                receiveStock();
                break;
            case 6:
                cout << "Exiting System. Goodbye!\n";
                running = false;
                break;
            default:
                cout << "Invalid choice. Please enter a number between 1 and 6.\n";
        }
    }

    return 0;
}
