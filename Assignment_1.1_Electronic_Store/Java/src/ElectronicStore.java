import java.util.ArrayList;
import java.util.List;

public class ElectronicStore {
    private String address;
    private List<Employee> employees;
    private List<Product> products;

    public ElectronicStore(String address) {
        this.address = address;
        this.employees = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getAddress() { return address; }
}