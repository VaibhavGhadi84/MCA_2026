class Product:
    def __init__(self, id, name, price, categories):
        self.id = id
        self.name = name
        self.price = price
        self.categories = categories

class Customer:
    def __init__(self, id, name, address, phone_no):
        self.id = id
        self.name = name
        self.address = address
        self.phone_no = phone_no

    def buy_product(self, product):
        print(f"{self.name} bought {product.name}")

class Employee:
    def __init__(self, id, name, salary):
        self.id = id
        self.name = name
        self.salary = salary

    def sell_product(self, product, customer):
        print(f"{self.name} sold {product.name} to {customer.name}")

class ElectronicStore:
    def __init__(self, address):
        self.address = address
        self.employees = []
        self.products = []

    def add_employee(self, emp):
        self.employees.append(emp)

    def add_product(self, prod):
        self.products.append(prod)

    def get_products(self):
        return self.products

class Stock:
    def __init__(self, stock_list):
        self.stock_list = stock_list

class Supplier:
    def __init__(self, id, name, phone_no):
        self.id = id
        self.name = name
        self.phone_no = phone_no

    def supply_stock(self, stock):
        print(f"{self.name} is supplying stock: {stock.stock_list}")

class Warehouse:
    def __init__(self, location):
        self.location = location
        self.stored_stock = []

    def store_stock(self, stock):
        self.stored_stock.append(stock)

class Inventory:
    def __init__(self):
        self.managed_stock = []
        self.products = []

    def manage_stock(self, stock):
        self.managed_stock.append(stock)

class Owner:
    def __init__(self, name, store):
        self.name = name
        self.store = store


# --- Main Application State & Logic ---

store = ElectronicStore("VGTech")
customers = []
employees = []
default_supplier = Supplier("S001", "TechDistributors", "852464652")
warehouse = Warehouse("Mapusa , Goa")

def add_product():
    print("\n-- Add New Product --")
    product_id = input("Enter Product ID: ")
    name = input("Enter Product Name: ")
    price = float(input("Enter Price: "))
    category = input("Enter Category: ")

    product = Product(product_id, name, price, category)
    store.add_product(product)
    print(f"Success: {name} added to the store.")

def add_customer():
    print("\n-- Register Customer --")
    customer_id = input("Enter Customer ID: ")
    name = input("Enter Name: ")
    address = input("Enter Address: ")
    phone_no = input("Enter Phone No: ")

    customer = Customer(customer_id, name, address, phone_no)
    customers.append(customer)
    print(f"Success: Customer {name} registered.")

def view_products():
    print("\n-- Available Products --")
    products = store.get_products()
    
    if not products:
        print("No products available in the store.")
        return

    for i, p in enumerate(products):
        print(f"{i + 1}. [{p.id}] {p.name} - ${p.price} ({p.categories})")

def process_sale():
    print("\n-- Process a Sale --")
    products = store.get_products()

    if not products:
        print("Error: No products available to sell.")
        return
    if not customers:
        print("Error: No customers registered. Please register a customer first.")
        return

    # Select Customer
    print("Select Customer by number:")
    for i, c in enumerate(customers):
        print(f"{i + 1}. {c.name}")
    
    customer_index = int(input("Choice: ")) - 1
    selected_customer = customers[customer_index]

    # Select Product
    view_products()
    product_index = int(input("Select Product by number to buy: ")) - 1
    selected_product = products[product_index]

    # Process Transaction
    active_employee = employees[0] # Using the default employee
    active_employee.sell_product(selected_product, selected_customer)
    selected_customer.buy_product(selected_product)

def receive_stock():
    print("\n-- Receive Stock --")
    item_desc = input("Enter stock description to order (e.g., '50x Laptops'): ")

    new_stock = Stock([item_desc])
    
    default_supplier.supply_stock(new_stock)
    warehouse.store_stock(new_stock)
    
    print("Success: Stock has been delivered and moved to the Warehouse.")

def main():
    employees.append(Employee("E001", "Alice (Cashier)", 45000))
    running = True

    while running:
        print("\n=== Electronic Store Management System ===")
        print("1. Add a new Product")
        print("2. Register a new Customer")
        print("3. View Store Products")
        print("4. Process a Sale")
        print("5. Receive Stock from Supplier")
        print("6. Exit")
        
        choice = input("Choose an option (1-6): ")

        if choice == '1':
            add_product()
        elif choice == '2':
            add_customer()
        elif choice == '3':
            view_products()
        elif choice == '4':
            process_sale()
        elif choice == '5':
            receive_stock()
        elif choice == '6':
            print("Exiting System. Goodbye!")
            running = False
        else:
            print("Invalid choice. Please enter a number between 1 and 6.")

if __name__ == '__main__':
    main()
